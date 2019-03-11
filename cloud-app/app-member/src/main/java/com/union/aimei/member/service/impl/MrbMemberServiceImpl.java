package com.union.aimei.member.service.impl;

import com.codingapi.tx.annotation.TxTransaction;
import com.union.aimei.common.constant.base.SmsConstant;
import com.union.aimei.common.constant.member.MrbMemberConstant;
import com.union.aimei.common.constant.store.BeauticianGrowthRuleEnum;
import com.union.aimei.common.feign.app.im.EasemobImUsersFeign;
import com.union.aimei.common.feign.app.store.GrowthRuleFeign;
import com.union.aimei.common.feign.app.store.StoreBeauticianFeign;
import com.union.aimei.common.feign.app.store.StoreFeign;
import com.union.aimei.common.feign.app.system.BaseUserFeign;
import com.union.aimei.common.feign.app.system.SendSmsFeign;
import com.union.aimei.common.model.im.ImUsers;
import com.union.aimei.common.model.member.Member;
import com.union.aimei.common.model.store.Store;
import com.union.aimei.common.model.store.StoreBeautician;
import com.union.aimei.common.model.system.BaseUser;
import com.union.aimei.common.vo.member.StoreBeauticianByPhoneResultVo;
import com.union.aimei.common.vo.member.StoreByRegisterVo;
import com.union.aimei.common.vo.store.app.GrowthRuleVo;
import com.union.aimei.common.vo.store.app.StoreByRegisterResVo;
import com.union.aimei.common.vo.system.BaseUserVo;
import com.union.aimei.common.vo.system.SmsMessageVo;
import com.union.aimei.member.constant.MemberConstant;
import com.union.aimei.member.mapper.MemberMapper;
import com.union.aimei.member.service.MrbMemberService;
import com.union.aimei.remote.AmezResponse;
import com.union.aimei.remote.model.*;
import com.union.common.utils.ResponseException;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseMessageFactory;
import com.union.common.utils.ResponseUtil;
import com.union.common.utils.constant.ResponseContants;
import com.union.common.utils.exception.ServerException;
import com.union.redis.RedisService;
import io.swagger.client.model.User;
import lombok.extern.apachecommons.CommonsLog;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;
import java.util.function.Predicate;

/**
 * @author GaoWei
 * @time 2018/6/6 11:13
 * @description
 */
@Service
@CommonsLog
public class MrbMemberServiceImpl implements MrbMemberService {


    @Resource
    private AmezResponse amezResponse;
    @Resource
    private EasemobImUsersFeign easemobImUsersFeign;
    @Resource
    private StoreBeauticianFeign storeBeauticianFeign;
    @Resource
    private SendSmsFeign sendSmsFeign;
    @Resource
    private RedisService redisService;
    @Resource
    private BaseUserFeign baseUserFeign;
    @Resource
    private StoreFeign storeFeign;
    @Resource
    private MemberMapper memberMapper;
    @Resource
    private GrowthRuleFeign growthRuleFeign;


    /**
     * 用户端登录
     *
     * @param mrbMemberLoginVo
     * @return
     */
    public ResponseMessage<Map<String, Object>> memberLogin(MrbMemberLoginVo mrbMemberLoginVo) {
        ResponseMessage<Map<String, Object>> res = new ResponseMessage<>();
        int loginType = mrbMemberLoginVo.getLoginType();
        //0--手机登录 1--用户名密码登录
        if (0 == loginType) {
            res = mobileLogin(mrbMemberLoginVo);
        } else if (1 == loginType) {
            res = userNamAndPwdLogin(mrbMemberLoginVo);
        }
        return res;
    }

    /**
     * 手机号登录
     *
     * @param register
     * @return
     */
    public ResponseMessage<Map<String, Object>> mobileLogin(MrbMemberLoginVo register) {
        checkVerifyCode(register.getVerifyCode(), register.getMobile());
        ResponseMessage<Map<String, Object>> responseMessage = new ResponseMessage();
        Member member = new Member();
        member.setRegisterPhone(register.getMobile());
        HashMap<String, Object> map = new HashMap<>(16);
        //手机注册登录
        ResultVo<MemberResult> resultResultVo = amezResponse.memberLogin(register);
        Optional.ofNullable(resultResultVo).filter(vo -> vo.getData() != null).orElseThrow(() -> new ServerException(500, resultResultVo.getMsg()));
        MemberResult result = resultResultVo.getData();
        int amId = result.getMember().getId();
        map.put("hasPayPassword", result.getHasPayPassword());
        map.put("hasPassword", result.getHasPassword());
        String uuid = result.getMember().getUuid();
        map.put("uuid", uuid);
        member.setAmezUserId(amId);
        member.setAmezUuid(uuid);
        //通过UUID查询会员信息
        Member mem = memberMapper.queryMemberInfoByUuid(uuid);
        if (mem != null) {
            map.put("member", mem);
        } else {
            //注册IM用户ID和名称
            addImUserName(member);
            //添加信息到美容邦会员表中
            //设置用户登录的昵称
            StringBuffer sb = new StringBuffer();
            sb.append("小邦举").append((int) ((Math.random() * 9 + 1) * 100000));
            member.setMemberNickname(sb.toString());
            int result1 = memberMapper.insertSelective(member);
            if (result1 != 1) {
                responseMessage.setCode(MemberConstant.Register.INSERT_TO_BEAUTIYBOND_FAIL);
                responseMessage.setMessage(MemberConstant.Register.INSERT_TO_BEAUTIYBOND_FAIL_MSG);
            } else {
                //再次查询
                Member meMsg = memberMapper.queryMemberInfoByUuid(uuid);
                if (meMsg != null) {
                    map.put("member", meMsg);
                }
            }
        }
        responseMessage.setData(map);
        return responseMessage;
    }

    private void checkVerifyCode(String verifyCode, String mobile) {
        String code = redisService.getStr(mobile);
        log.info("从Redis获取的验证码为:" + code);
        Optional.ofNullable(code)
                .filter(x -> !StringUtils.isBlank(x))
                .orElseThrow(() -> new ServerException(500, "验证码已过期"));
        if (!code.equals(verifyCode)) {
            throw new ServerException(500, "验证码不正确,请重新输入");
        }
    }


    /**
     * 用户名密码登录
     *
     * @param register
     */
    private ResponseMessage<Map<String, Object>> userNamAndPwdLogin(MrbMemberLoginVo register) {
        ResponseMessage<Map<String, Object>> responseMessage = new ResponseMessage();
        ResultVo<AmezMemberInfoVo> resultResultVo = amezResponse.queryMemberMoreInfo(register);
        if (!MrbMemberConstant.Login.IM_SUCCESS_CATION.equals(resultResultVo.getStatus().name())) {
            throw new ServerException(500, resultResultVo.getMsg());
        }
        AmezMemberInfoVo result = resultResultVo.getData();
        HashMap<String, Object> map = new HashMap<>(16);
        map.put("hasPayPassword", result.getHasPayPassword());
        map.put("hasPassword", result.getHasPassword());
        String uuid = result.getMember().getUuid();
        map.put("uuid", uuid);
        Member mem = memberMapper.queryMemberInfoByUuid(uuid);
        if (mem == null) {
            responseMessage.setCode(ResponseContants.QUERY_RESULT_EMPTY);
            responseMessage.setMessage(ResponseContants.QUERY_RESULT_EMPTY_MESSAGE);
        } else {
            Integer imUserId = mem.getImUserId();
            String imUserName = mem.getImUsername();
            if (imUserId == null || imUserName == null) {
                addImUserName(mem);
                memberMapper.updateByPrimaryKeySelective(mem);
                mem = memberMapper.queryMemberInfoByUuid(uuid);
            }
            map.put("member", mem);
            responseMessage.setData(map);
        }
        return responseMessage;
    }


    private Map<String, String> registerImUser() {
        // 环信用户
        User user = new User();
        user.setUsername(UUID.randomUUID().toString().replace("-", ""));
        user.setPassword(ImUsers.DEFAULT_PASSWORD);
        ResponseMessage<ImUsers> imUsersRes = easemobImUsersFeign.registerSingle(user);
        if (MrbMemberConstant.Login.IM_SUCCESS_CODE == imUsersRes.getCode()) {
            ImUsers users = imUsersRes.getData();
            Map<String, String> map = new HashMap<>(2);
            map.put("imUserId", String.valueOf(users.getId()));
            map.put("imUserName", users.getUsername());
            return map;
        } else {
            throw new ServerException(500, "添加用户聊天功能异常,请稍后重试");
        }
    }


    private void addImUserName(Member member) {
        //注册IM用户ID和名称
        Map<String, String> imMap = registerImUser();
        if (imMap != null) {
            Integer imUserId = Integer.parseInt(imMap.get("imUserId"));
            String userName = imMap.get("imUserName");
            member.setImUserId(imUserId);
            member.setImUsername(userName);
        }
    }


    /**
     * 美容师端登录
     *
     * @param mrbMemberLoginVo
     * @return
     */
    public ResponseMessage beauticianLogin(MrbMemberLoginVo mrbMemberLoginVo) {
        ResponseMessage<Map<String, Object>> res = new ResponseMessage<>();
        int loginType = mrbMemberLoginVo.getLoginType();
        //0--手机登录 1--用户名密码登录
        if (0 == loginType) {
            res = beauticianMobileLoginMrb(mrbMemberLoginVo);
        } else if (1 == loginType) {
            res = generateLogin(mrbMemberLoginVo);
        }
        //return generateLogin(0,mrbMemberLoginVo);
        return res;
    }

    /**
     * 登录会员不为空
     *
     * @param responseMessage
     * @param map
     * @param mem
     * @return
     */
    private ResponseMessage loginByMember(ResponseMessage responseMessage, Map<String, Object> map, Member mem) {
        map.put("memberId", mem.getId());
        map.put("imUsername", mem.getImUsername());
        map.put("imUserid", mem.getImUserId());
        StoreBeautician storeBeautician;
        //根据手机号码查询美容师
        ResponseMessage<StoreBeautician> sbMsg = storeBeauticianFeign.findByPhone(mem.getRegisterPhone());
        if (sbMsg.getCode() != MrbMemberConstant.Login.IM_SUCCESS_CODE) {
            responseMessage.setCode(2001);
            responseMessage.setMessage("根据手机号码查询不到美容师，登录失败");
        }
        storeBeautician = sbMsg.getData();
        //如果美容师账号类型为兼职或者全职美容师才可以登录美容师端登录
        if (storeBeautician.getBeauticianType() == StoreBeautician.BeauticianType.FULL_TIME ||
                storeBeautician.getBeauticianType() == StoreBeautician.BeauticianType.PART_TIME) {
            //再一次做一个判断，美容师的状态是否离职
            if (storeBeautician.getBeauticianStatus() == 0) {
                responseMessage.setCode(4001);
                responseMessage.setMessage("该美容师已经离职");
                return responseMessage;
            }
            map.put("beauticianId", storeBeautician.getId());
            map.put("beauticianType", storeBeautician.getBeauticianType());
            map.put("beauticianStatus", storeBeautician.getBeauticianStatus());
            map.put("registerStatus", storeBeautician.getRegisterStatus());
            map.put("affiliatedStatus", storeBeautician.getAffiliatedStatus());
            map.put("realNameStatus", storeBeautician.getRealNameStatus());
            //美容师登录成功添加成长值
            GrowthRuleVo growthRuleVo = new GrowthRuleVo();
            growthRuleVo.setCode(BeauticianGrowthRuleEnum.DAILY_LOGIN.getCode());
            growthRuleVo.setRuleType((byte) 1);
            growthRuleVo.setSourceId(storeBeautician.getId());
            ResponseMessage resRule = this.growthRuleFeign.saveGrowthRuleV111(growthRuleVo);
            responseMessage.setData(map);
            return responseMessage;
        } else {
            responseMessage.setCode(2002);
            responseMessage.setMessage("非美容师不允许登录美容师,登录失败");
            return responseMessage;
        }
    }

    /**
     * 登录会员为空
     *
     * @param responseMessage
     * @param member
     * @param mem
     * @param map
     * @param uuid
     * @return
     */
    private ResponseMessage loginByMemberForNull(ResponseMessage responseMessage, Member member, Member mem, Map<String, Object> map, String uuid) {
        //第一步：注册IM用户ID和名称
        addImUserName(member);
        //第二部：保存会员
        this.saveMember(member);
        //添加会员信息成功之后，会员存在uuid，查询
        mem = memberMapper.queryMemberInfoByUuid(uuid);
        map.put("memberId", mem.getId());
        map.put("imUsername", mem.getImUsername());
        map.put("imUserid", mem.getImUserId());
        //查询美容师后台账号信息
        BaseUserVo baseUserVo = new BaseUserVo();
        baseUserVo.setPhone(member.getRegisterPhone());
        baseUserVo.setUserType(2);
        BaseUser baseUser;
        ResponseMessage<BaseUser> baseUserMsg = this.baseUserFeign.insertBbossAndShopkeeperAndMember(baseUserVo);
        if (baseUserMsg.getCode() != MrbMemberConstant.Login.IM_SUCCESS_CODE) {
            responseMessage.setMessage("查询后台美容师登录账号错误，注册美容师失败");
            responseMessage.setCode(3005);
            return responseMessage;
        }
        baseUser = baseUserMsg.getData();
        map.put("loginName", baseUser.getLoginName());
        map.put("password", baseUser.getPassword());
        //根据手机号查询美容师是否存在
        ResponseMessage<StoreBeautician> sbMeg = storeBeauticianFeign.findByPhone(mem.getRegisterPhone());
        if (sbMeg.getCode() == MrbMemberConstant.Login.IM_SUCCESS_CODE) {
            //这里做一个判断，当会员刚刚注册成功，还没有注册美容师，但查询到了美容师
            responseMessage.setCode(2006);
            responseMessage.setMessage("美容师手机号已经注册，注册美容师失败");
        }
        StoreBeautician storeBeautician = new StoreBeautician();
        StringBuffer sb = new StringBuffer();
        sb.append("邦女郎").append((int) ((Math.random() * 9 + 1) * 100000));
        storeBeautician.setBeauticianNickName(sb.toString());
        storeBeautician.setPhone(member.getRegisterPhone());
        storeBeautician.setMemberId(mem.getId());
        storeBeautician.setImUserId(mem.getImUserId());
        storeBeautician.setImUsername(mem.getImUsername());
        storeBeautician.setUserId(baseUser.getUserId());
        //手机注册师兼职员工
        storeBeautician.setBeauticianType(3);
        ResponseMessage<StoreBeautician> sbMsg = storeBeauticianFeign.add(storeBeautician);
        if (sbMsg.getCode() != MrbMemberConstant.Login.IM_SUCCESS_CODE) {
            responseMessage.setMessage("店长信息添加失败，注册店长失败");
            responseMessage.setCode(3008);
            return responseMessage;
        }
        //查询美容师信息
        storeBeautician = sbMsg.getData();
        map.put("beauticianId", storeBeautician.getId());
        map.put("beauticianType", storeBeautician.getBeauticianType());
        map.put("beauticianStatus", storeBeautician.getBeauticianStatus());
        map.put("registerStatus", storeBeautician.getRegisterStatus());
        map.put("affiliatedStatus", storeBeautician.getAffiliatedStatus());
        map.put("realNameStatus", storeBeautician.getRealNameStatus());
        //美容师登录成功添加成长值
        GrowthRuleVo growthRuleVo = new GrowthRuleVo();
        growthRuleVo.setCode(BeauticianGrowthRuleEnum.DAILY_LOGIN.getCode());
        growthRuleVo.setRuleType((byte) 1);
        growthRuleVo.setSourceId(storeBeautician.getId());
        ResponseMessage resRule = this.growthRuleFeign.saveGrowthRuleV111(growthRuleVo);
        responseMessage.setData(map);
        return responseMessage;
    }

    /**
     * 保存会员
     *
     * @param member
     */
    private void saveMember(Member member) {
        //这里做一个判断，上一步操作我们根据uuid查询会员是为null,这里进行一个根据手机号码进行查询一遍，保证数据的准确性
        //当根据手机号码查询数据存在，则这个手机号已经产生了uuid，则与上一步的uuid查询会员的数据不一致
        //提示数据错误
        Member phoneMem = this.memberMapper.queryByMobile(member.getRegisterPhone());
        if (phoneMem != null) {
            throw new ResponseException(2004, "艾美一族uuid与美容邦uuid不一致，注册会员失败");
        }
        //当数据一致时候
        //第二步：添加信息到美容邦会员表中
        int result1 = memberMapper.insertSelective(member);
        if (result1 != 1) {
            //添加会员信息到美容邦失败
            throw new ResponseException(MemberConstant.Register.INSERT_TO_BEAUTIYBOND_FAIL, MemberConstant.Register.INSERT_TO_BEAUTIYBOND_FAIL_MSG);
        }
    }

    /**
     * 美容师手机验证码登录（新）
     *
     * @param register
     * @return
     */
    @TxTransaction(isStart = true, rollbackFor = Exception.class)
    @Transactional(rollbackFor = Exception.class)
    public ResponseMessage beauticianMobileLoginMrb(MrbMemberLoginVo register) {
        checkVerifyCode(register.getVerifyCode(), register.getMobile());
        ResponseMessage<Map<String, Object>> responseMessage = new ResponseMessage();
        Member member = new Member();
        member.setRegisterPhone(register.getMobile());
        HashMap<String, Object> map = new HashMap<>(16);
        map.put("mobile", register.getMobile());
        //手机注册登录
        ResultVo<MemberResult> resultResultVo = amezResponse.memberLogin(register);
        Optional.ofNullable(resultResultVo).filter(vo -> vo.getData() != null).orElseThrow(() -> new ServerException(500, resultResultVo.getMsg()));
        MemberResult result = resultResultVo.getData();
        //获取艾美会员id
        int amId = result.getMember().getId();
        map.put("hasPayPassword", result.getHasPayPassword());
        map.put("hasPassword", result.getHasPassword());
        String uuid = result.getMember().getUuid();
        //获取艾美uuid
        map.put("uuid", uuid);
        member.setAmezUserId(amId);
        member.setAmezUuid(uuid);
        //通过UUID查询会员信息
        Member mem = memberMapper.queryMemberInfoByUuid(uuid);
        if (mem != null) {
            //会员不为空，则是登录美容师
            this.loginByMember(responseMessage, map, mem);
        } else {
            //如果会员查询为空，注册美容师
            this.loginByMemberForNull(responseMessage, member, mem, map, uuid);
        }
        return responseMessage;
    }


    /**
     * 店长端登录
     *
     * @param mrbMemberLoginVo
     * @return
     */
    public ResponseMessage storeOwnerLogin(MrbMemberLoginVo mrbMemberLoginVo) {
        ResponseMessage<Map<String, Object>> res = new ResponseMessage<>();
        int loginType = mrbMemberLoginVo.getLoginType();
        //0--手机验证码登录 1--用户名密码登录
        if (0 == loginType) {
            res = storeOwnerMobileLoginMbr(mrbMemberLoginVo);
        } else if (1 == loginType) {
            res = generateLogin(mrbMemberLoginVo);
        }
        return res;
        //return  generateLogin(1,mrbMemberLoginVo);
    }

    /**
     * 登录店长会员不为空
     *
     * @param responseMessage
     * @param map
     * @param mem
     * @param register
     * @param member
     * @return
     */
    private ResponseMessage loginBySeller(ResponseMessage responseMessage, Map<String, Object> map, Member mem, MrbMemberLoginVo register, Member member) {
        map.put("memberId", mem.getId());
        map.put("imUsername", mem.getImUsername());
        map.put("imUserid", mem.getImUserId());
        //这里再一次查询，根据phone查询uuid是否一致
        Member memPhone = this.memberMapper.queryByMobile(register.getMobile());
        if (memPhone != null) {
            if (mem.getAmezUuid().equals(memPhone.getAmezUuid()) == false) {
                responseMessage.setCode(3001);
                responseMessage.setMessage("艾美一族uuid与美容邦的uuid数据不一致，登录失败");
                return responseMessage;
            }
        } else {
            responseMessage.setCode(3002);
            responseMessage.setMessage("根据注册手机号查询美容邦会员信息为空，登录失败");
            return responseMessage;
        }
        //查询后台店长登录账号
        BaseUserVo baseUserVo = new BaseUserVo();
        baseUserVo.setPhone(member.getRegisterPhone());
        baseUserVo.setUserType(1);
        BaseUser baseUser;
        ResponseMessage<BaseUser> baseUserMsg = this.baseUserFeign.insertBbossAndShopkeeperAndMember(baseUserVo);
        if (baseUserMsg.getCode() != MrbMemberConstant.Login.IM_SUCCESS_CODE && baseUserMsg.getCode() != MrbMemberConstant.Login.REGIN_SERVER_USER_CODE) {
            responseMessage.setMessage("查询后台店长登录账号错误，登录店长失败");
            responseMessage.setCode(3005);
            return responseMessage;
        }
        baseUser = baseUserMsg.getData();
        map.put("loginName", baseUser.getLoginName());
        map.put("password", baseUser.getPassword());
        // 门店，店长
        Store store = this.loginBySellerForStore(register, map, mem);
        // 店长登录加入成长值
        this.loginBySellerForGrowthRule(store);
        responseMessage.setData(map);
        return responseMessage;
    }

    /**
     * 登录店长门店信息
     *
     * @param register
     * @param map
     * @param mem
     * @return
     */
    private Store loginBySellerForStore(MrbMemberLoginVo register, Map<String, Object> map, Member mem) {
        //查询门店信息
        ResponseMessage<Store> sMsg = this.storeFeign.getBySellerPhoneV111(register.getMobile());
        if (sMsg.getCode() != MrbMemberConstant.Login.IM_SUCCESS_CODE) {
            throw new ResponseException(MemberConstant.Login.SHOPOWNER_LOGIN_FAIL, MemberConstant.Login.SHOPOWNER_LOGIN_FAIL_MSG);
        }
        Store store = sMsg.getData();
        map.put("storeId", store.getId());
        map.put("storeName", store.getStoreName());
        map.put("settledCode", store.getSettledCode());
        map.put("settledStatus", store.getSettledStatus());
        map.put("qualificationStatus", store.getQualificationStatus());
        //查询美容师信息
        ResponseMessage<StoreBeautician> sbMeg = storeBeauticianFeign.findByPhone(mem.getRegisterPhone());
        if (ResponseUtil.isFail(sbMeg)) {
            throw new ResponseException(3012, "门店美容师查询失败，登录店长失败");
        }
        StoreBeautician storeBeautician = sbMeg.getData();
        //这里做一个判断，美容师必须为店长类型，才可以登录店长端
        if (storeBeautician.getBeauticianType() != 1) {
            throw new ResponseException(3013, "非店长类型不允许使用店长登录，登录店长失败");
        }
        if (storeBeautician.getBeauticianStatus() == 0) {
            throw new ResponseException(3014, "该店长已经离职，登录店长失败");
        }
        map.put("beauticianId", storeBeautician.getId());
        map.put("beauticianType", storeBeautician.getBeauticianType());
        map.put("beauticianStatus", storeBeautician.getBeauticianStatus());
        map.put("registerStatus", storeBeautician.getRegisterStatus());
        map.put("affiliatedStatus", storeBeautician.getAffiliatedStatus());
        map.put("realNameStatus", storeBeautician.getRealNameStatus());
        return store;
    }

    /**
     * 登录店长保存成长值
     *
     * @param store
     */
    private void loginBySellerForGrowthRule(Store store) {
        GrowthRuleVo growthRuleVo = new GrowthRuleVo();
        growthRuleVo.setCode(BeauticianGrowthRuleEnum.DAILY_LOGIN.getCode());
        growthRuleVo.setSourceId(store.getId());
        growthRuleVo.setRuleType(GrowthRuleVo.RuleTypes.STORE);
        ResponseMessage growthMsg = this.growthRuleFeign.saveGrowthRuleV111(growthRuleVo);
    }

    /**
     * 登录店长会员为空
     *
     * @param responseMessage
     * @param map
     * @param mem
     * @param register
     * @param member
     * @return
     */
    private ResponseMessage loginBySellerForNull(ResponseMessage responseMessage, Map<String, Object> map, Member mem, MrbMemberLoginVo register, Member member) {
        //第二步：注册im
        addImUserName(member);
        //第三步：注册美容邦会员
        //注册会员之前，做一个条件判断：
        // 根据uuid查询member是查询不到，根据phone查询得到，则美容邦的会员uuid与艾美一族uuid不一致
        Member phoneMem = this.memberMapper.queryByMobile(member.getRegisterPhone());
        if (phoneMem != null) {
            responseMessage.setCode(3004);
            responseMessage.setMessage("艾美一族uuid与美容邦uuid不一致，数据错误，注册店长失败");
            return responseMessage;
        }
        //添加信息到美容邦会员表中
        int result1 = memberMapper.insertSelective(member);
        //添加结果失败，返回数据
        if (result1 != 1) {
            responseMessage.setCode(MemberConstant.Register.INSERT_TO_BEAUTIYBOND_FAIL);
            responseMessage.setMessage(MemberConstant.Register.INSERT_TO_BEAUTIYBOND_FAIL_MSG);
            return responseMessage;
        }
        //再次查询获取会员信息
        mem = this.memberMapper.queryByMobile(register.getMobile());
        map.put("memberId", mem.getId());
        map.put("imUsername", mem.getImUsername());
        map.put("imUserid", mem.getImUserId());
        //第四步：注册后台店长账号
        BaseUserVo baseUserVo = new BaseUserVo();
        baseUserVo.setPhone(member.getRegisterPhone());
        baseUserVo.setUserType(1);
        BaseUser baseUser;
        ResponseMessage<BaseUser> baseUserMsg = this.baseUserFeign.insertBbossAndShopkeeperAndMember(baseUserVo);
        if (baseUserMsg.getCode() != MrbMemberConstant.Login.IM_SUCCESS_CODE) {
            responseMessage.setMessage("查询后台店长登录账号错误，注册店长失败");
            responseMessage.setCode(3005);
            return responseMessage;
        }
        baseUser = baseUserMsg.getData();
        map.put("loginName", baseUser.getLoginName());
        map.put("password", baseUser.getPassword());
        //第五步:注册门店
        StoreByRegisterResVo storeInfo = this.loginBySellerForNullForStore(baseUser, member, map, mem);
        //店长登录加入成长值
        GrowthRuleVo growthRuleVo = new GrowthRuleVo();
        growthRuleVo.setCode(BeauticianGrowthRuleEnum.DAILY_LOGIN.getCode());
        growthRuleVo.setSourceId(storeInfo.getStore().getId());
        growthRuleVo.setRuleType(GrowthRuleVo.RuleTypes.STORE);
        ResponseMessage growthMsg = this.growthRuleFeign.saveGrowthRuleV111(growthRuleVo);
        responseMessage.setData(map);
        return responseMessage;
    }

    /**
     * 登录店长，会员为空，注册门店
     *
     * @param baseUser
     * @param member
     * @param map
     * @param mem
     * @return
     */
    private StoreByRegisterResVo loginBySellerForNullForStore(BaseUser baseUser, Member member, Map<String, Object> map, Member mem) {
        StoreByRegisterVo storeByRegisterResVo = new StoreByRegisterVo();
        storeByRegisterResVo.setSellerName(baseUser.getLoginName());
        storeByRegisterResVo.setSellerPhone(member.getRegisterPhone());
        storeByRegisterResVo.setSellerUserId(baseUser.getUserId());
        ResponseMessage<StoreByRegisterResVo> srvMsg = this.storeFeign.registerV111(storeByRegisterResVo);
        if (srvMsg.getCode() != MrbMemberConstant.Login.IM_SUCCESS_CODE) {
            throw new ResponseException(3006, "注册门店信息失败，注册店长失败");
        }
        StoreByRegisterResVo storeInfo = srvMsg.getData();
        map.put("storeId", storeInfo.getStore().getId());
        map.put("storeName", storeInfo.getStore().getStoreName());
        map.put("settledCode", storeInfo.getStore().getSettledCode());
        map.put("settledStatus", storeInfo.getStore().getSettledStatus());
        map.put("qualificationStatus", storeInfo.getStore().getQualificationStatus());
        //第六步：注册美容师
        //根据手机号查询美容师是否存在
        StoreBeautician storeBeautician;
        ResponseMessage<StoreBeautician> sbMeg = storeBeauticianFeign.findByPhone(mem.getRegisterPhone());
        if (sbMeg.getCode() == MrbMemberConstant.Login.IM_SUCCESS_CODE) {
            throw new ResponseException(3007, "用户手机号码已经存在美容师类型，注册店长失败");
        }
        storeBeautician = new StoreBeautician();
        StringBuffer sb = new StringBuffer();
        sb.append("邦主").append((int) ((Math.random() * 9 + 1) * 100000));
        storeBeautician.setBeauticianNickName(sb.toString());
        storeBeautician.setPhone(member.getRegisterPhone());
        storeBeautician.setMemberId(mem.getId());
        storeBeautician.setImUserId(mem.getImUserId());
        storeBeautician.setImUsername(mem.getImUsername());
        storeBeautician.setUserId(baseUser.getUserId());
        storeBeautician.setStoreId(storeInfo.getStore().getId());
        storeBeautician.setStoreName(storeInfo.getStore().getStoreName());
        storeBeautician.setBeauticianType(1);
        ResponseMessage<StoreBeautician> sbMsg = storeBeauticianFeign.add(storeBeautician);
        if (sbMsg.getCode() != MrbMemberConstant.Login.IM_SUCCESS_CODE) {
            throw new ResponseException(3008, "店长注册美容师信息添加失败，注册店长失败");
        }
        storeBeautician = sbMsg.getData();
        map.put("beauticianId", storeBeautician.getId());
        map.put("beauticianType", storeBeautician.getBeauticianType());
        map.put("beauticianStatus", storeBeautician.getBeauticianStatus());
        map.put("registerStatus", storeBeautician.getRegisterStatus());
        map.put("affiliatedStatus", storeBeautician.getAffiliatedStatus());
        map.put("realNameStatus", storeBeautician.getRealNameStatus());
        return storeInfo;
    }

    /**
     * 手机端店长登录(新)
     *
     * @param register
     * @return
     */

    @TxTransaction(isStart = true, rollbackFor = Exception.class)
    @Transactional(rollbackFor = Exception.class)
    public ResponseMessage storeOwnerMobileLoginMbr(MrbMemberLoginVo register) {
        //店长注册流程
        //1.注册艾美，2-注册会员，3-注册后台用户，4-注册IM，5-注册门店，6-注册美容师（店长身份）
        checkVerifyCode(register.getVerifyCode(), register.getMobile());
        ResponseMessage<Map<String, Object>> responseMessage = new ResponseMessage();
        Member member = new Member();
        member.setRegisterPhone(register.getMobile());
        HashMap<String, Object> map = new HashMap<>(16);
        map.put("mobile", register.getMobile());
        //手机注册登录
        //第一步：注册艾美会员
        ResultVo<MemberResult> resultResultVo = amezResponse.memberLogin(register);
        Optional.ofNullable(resultResultVo).filter(vo -> vo.getData() != null).orElseThrow(() -> new ServerException(500, resultResultVo.getMsg()));
        MemberResult result = resultResultVo.getData();
        int amId = result.getMember().getId();
        map.put("hasPayPassword", result.getHasPayPassword());
        map.put("hasPassword", result.getHasPassword());
        String uuid = result.getMember().getUuid();
        map.put("uuid", uuid);
        member.setAmezUserId(amId);
        member.setAmezUuid(uuid);
        member.setRegisterPhone(register.getMobile());
        //通过UUID查询会员信息,会员信息不为null,则是手机验证码登录
        Member mem = memberMapper.queryMemberInfoByUuid(uuid);
        if (mem != null) {
            this.loginBySeller(responseMessage, map, mem, register, member);
        } else {
            //通过uuid查询会员信息为null，则是注册店长步骤
            this.loginBySellerForNull(responseMessage, map, mem, register, member);
        }
        return responseMessage;
    }

    /**
     * 基本登录，会员登录处理
     *
     * @param res
     * @param sb
     * @param store
     * @param mrbMemberLoginVo
     * @return
     */
    private ResponseMessage generateLoginByMemberLoginHander(ResponseMessage res, StoreBeautician sb, Store store, MrbMemberLoginVo mrbMemberLoginVo) {
        Map<String, Object> map = new HashMap<>(16);
        map.put("storeId", sb.getStoreId());
        map.put("memberId", sb.getMemberId());
        map.put("mobile", sb.getPhone());
        map.put("brandId", store.getBrandId());
        map.put("storeName", store.getStoreName());
        map.put("settledCode", store.getSettledCode());
        map.put("settledStatus", store.getSettledStatus());
        map.put("qualificationStatus", store.getQualificationStatus());
        map.put("beauticianId", sb.getId());
        map.put("beauticianType", sb.getBeauticianType());
        map.put("beauticianStatus", sb.getBeauticianStatus());
        map.put("registerStatus", sb.getRegisterStatus());
        map.put("affiliatedStatus", sb.getAffiliatedStatus());
        map.put("realNameStatus", sb.getRealNameStatus());
        map.put("imUsername", sb.getImUsername());
        ResponseMessage<Map<String, Object>> resMsg = memberLogin(mrbMemberLoginVo);
        if (MrbMemberConstant.Login.IM_SUCCESS_CODE == resMsg.getCode()) {
            Map<String, Object> loginMap = (Map<String, Object>) resMsg.getData();
            String hasPassword = loginMap.get("hasPassword").toString();
            String hasPayPassword = loginMap.get("hasPayPassword").toString();
            String uuid = loginMap.get("uuid").toString();
            map.put("hasPayPassword", hasPayPassword);
            map.put("hasPassword", hasPassword);
            map.put("uuid", uuid);
            //美容师(店长)登录成功则增加成长值
            //员工类型，0-老板，1-店长，2-全职员工，3-兼职员工
            GrowthRuleVo growthRuleVo = new GrowthRuleVo();
            growthRuleVo.setCode(BeauticianGrowthRuleEnum.DAILY_LOGIN.getCode());
            if (sb.getBeauticianType() == StoreBeautician.BeauticianType.FULL_TIME || sb.getBeauticianType() == StoreBeautician.BeauticianType.PART_TIME) {
                growthRuleVo.setRuleType(GrowthRuleVo.RuleTypes.BEAUTICIAN);
                growthRuleVo.setSourceId(sb.getId());
            } else if (sb.getBeauticianType() == 1) {
                growthRuleVo.setRuleType(GrowthRuleVo.RuleTypes.STORE);
                growthRuleVo.setSourceId(store.getId());
            }
            this.growthRuleFeign.saveGrowthRuleV111(growthRuleVo);
            res.setData(map);
            return res;
        } else {
            throw new ServerException(resMsg.getCode(), resMsg.getMessage());
        }
    }

    /**
     * 美容师或店长登录基本方法
     *
     * @param mrbMemberLoginVo
     * @return
     */
    @TxTransaction(isStart = true, rollbackFor = Exception.class)
    @Transactional(rollbackFor = Exception.class)
    public ResponseMessage generateLogin(MrbMemberLoginVo mrbMemberLoginVo) {
        String phone = mrbMemberLoginVo.getMobile() == null ? mrbMemberLoginVo.getUserName() : mrbMemberLoginVo.getMobile();
        ResponseMessage res = storeBeauticianFeign.findByPhoneForStore(phone);
        int logincustomer = mrbMemberLoginVo.getLoginCustomer();
        if (MrbMemberConstant.Login.IM_SUCCESS_CODE == res.getCode()) {
            StoreBeauticianByPhoneResultVo sbvo = (StoreBeauticianByPhoneResultVo) res.getData();
            final StoreBeautician sb = sbvo.getStoreBeautician();
            final Store store = sbvo.getStore();
            Predicate<StoreBeautician> isTrue = (s) -> {
                boolean is = false;
                //员工类型
                Integer beauticianType = s.getBeauticianType();
                //是否在职
                Integer beauticianStatus = s.getBeauticianStatus();
                if (logincustomer == MrbMemberLoginVo.LoginCustomer.BEAUTICIAN) {
                    is = (2 == beauticianType || 3 == beauticianType) && (1 == beauticianStatus);
                } else if (logincustomer == MrbMemberLoginVo.LoginCustomer.OWENR) {
                    is = 1 == beauticianType && 1 == beauticianStatus;
                }
                return is;
            };
            if (isTrue.test(sb)) {
                //当店长登录，门店状态，0关闭，1开启，2待审核，3冻结
                if (MrbMemberLoginVo.Source.OWENR.equals(mrbMemberLoginVo.getSource())) {
                    if (store.getStoreState() == Store.StoreState.CLOSE || store.getStoreState() == Store.StoreState.FREEZE) {
                        res = new ResponseMessage();
                        res.setCode(6006);
                        res.setMessage("该店长所属店铺已经关闭或店铺已经冻结,登录失败");
                        return res;
                    }
                }
                this.generateLoginByMemberLoginHander(res, sb, store, mrbMemberLoginVo);
            } else {
                throw new ServerException(500, logincustomer == 1 ? MemberConstant.Login.BEAUTICIAN_LOGIN_FAIL_MSG : MemberConstant.Login.SHOPOWNER_LOGIN_FAIL_MSG);
            }
        } else {
            throw new ServerException(500, res.getMessage());
        }
        return res;
    }


    /**
     * 判断登录类型，返回不同数据
     *
     * @param mrbMemberLoginVo
     * @return
     */
    @Override
    public ResponseMessage generatorLoginCustomer(MrbMemberLoginVo mrbMemberLoginVo) {
        ResponseMessage res = null;
        int loginCustomer = mrbMemberLoginVo.getLoginCustomer();
        //0--用户端登录 1--美容师登录 2--店长端登录
        if (MrbMemberLoginVo.LoginCustomer.USER == loginCustomer) {
            res = memberLogin(mrbMemberLoginVo);
        } else if (MrbMemberLoginVo.LoginCustomer.BEAUTICIAN == loginCustomer) {
            res = beauticianLogin(mrbMemberLoginVo);
        } else if (MrbMemberLoginVo.LoginCustomer.OWENR == loginCustomer) {
            res = storeOwnerLogin(mrbMemberLoginVo);
        }
        return res;
    }


    /**
     * 查询用户余额
     *
     * @param uuid
     * @return
     */
    @Override
    public ResponseMessage<Double> queryUserUseBalance(String uuid) {
        ResponseMessage<Double> res = new ResponseMessage<>();
        ResultVo<MemberBalanceVo> resultVo = amezResponse.queryMemberBalance(uuid);
        Optional.of(resultVo)
                .filter(vo -> "SUCCESS".equals(vo.getStatus().name()))
                .map(vo -> vo.getData())
                .map(vo -> vo.getUsableBalance())
                .orElseThrow(() -> new ServerException(resultVo.getCode(), resultVo.getMsg()));
        double resDouble = getTwoDecimal(resultVo.getData().getUsableBalance());
        res.setData(resDouble);
        return res;
    }

    /**
     * 将数据保留两位小数
     */
    private static double getTwoDecimal(double num) {
        return new BigDecimal(num).setScale(2, BigDecimal.ROUND_DOWN).doubleValue();
    }


    /**
     * 查询用户一卡通信息
     *
     * @param uuid
     * @return
     */
    @Override
    public ResponseMessage<List<MemberOneCardVo>> queryUserOneCardInfo(String uuid) {
        ResponseMessage<List<MemberOneCardVo>> res = new ResponseMessage<>();
        ResultVo<List<MemberOneCardVo>> resultVo = amezResponse.queryMemberOneCardInfo(uuid);
        Optional.of(resultVo)
                .filter(vo -> "SUCCESS".equals(vo.getStatus().name()))
                .map(vo -> vo.getData())
                .orElseThrow(() -> new ServerException(resultVo.getCode(), resultVo.getMsg()));
        res.setData(resultVo.getData());
        return res;
    }


    /**
     * 获取验证码
     *
     * @param mobileVerifyCodeVo
     * @return
     */
    @Override
    public ResponseMessage getLoginVerifyCode(MobileVerifyCodeVo mobileVerifyCodeVo) {
        int codeType = mobileVerifyCodeVo.getCodeType();
        SmsMessageVo vo = getSmsMessageVo(codeType, mobileVerifyCodeVo.getMobile());
        if (codeType == MobileVerifyCodeVo.CodeType.UPDATE_LOGIN_CODE || codeType == MobileVerifyCodeVo.CodeType.UPDATE_PAY_CODE) {
            Member member = new Member();
            member.setAmezUuid(mobileVerifyCodeVo.getUuid());
            //通过UUID查询会员是否存在
            Member memMsg = memberMapper.queryMemberInfoByUuid(mobileVerifyCodeVo.getUuid());
            if (memMsg == null) {
                throw new ServerException(500, "会员不存在,无法发送验证码");
            }
        }
        int result = sendSmsFeign.sendSmsMessage(vo);
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessage("验证码已发送，请注意查收");
        if (result != 1) {
            throw new ServerException(500, "验证码发送失败,请重试");
        }
        return responseMessage;
    }

    private static SmsMessageVo getSmsMessageVo(int codeType, String phone) {
        SmsMessageVo vo = new SmsMessageVo();
        vo.setPhone(phone);
        String smsCode = null;
        switch (codeType) {
            case 0:
                smsCode = SmsConstant.MEMBER_LOGIN.getSmsCode();
                break;
            case 1:
                smsCode = SmsConstant.MODIFY_LOGIN_PASSWORD.getSmsCode();
                break;
            case 2:
                smsCode = SmsConstant.MODIFY_PAY_PASSWORD.getSmsCode();
                break;
            case 3:
                smsCode = SmsConstant.RETRIEVE_PASSWORD.getSmsCode();
                break;
            default:
        }
        vo.setSmsCode(smsCode);
        return vo;
    }


    /**
     * 找回登录密码
     *
     * @param resetLoginPwdVo
     * @return
     */
    @Override
    public ResponseMessage reSetPasswordOnUnLogin(ResetLoginPwdVo resetLoginPwdVo) {
        checkVerifyCode(resetLoginPwdVo.getVerifyCode(), resetLoginPwdVo.getMobile());
        ResponseMessage resMsg = ResponseMessageFactory.newInstance();
        //根据手机号码查询UUID
        Member member = memberMapper.queryByMobile(resetLoginPwdVo.getMobile());
        if (member != null) {
            String uuid = member.getAmezUuid();
            String token = amezResponse.getAccessToken();
            if (!StringUtils.isBlank(token)) {
                //获取forgetPwdCode
                String forgetCode = amezResponse.getForgetCode(uuid, token, 1);
                if (StringUtils.isBlank(forgetCode)) {
                    throw new ServerException(500, "获取Code失败");
                }
                //提交重置
                ResultVo<MemberResult> resultResultVo = amezResponse.resetUpdateLoginPasswordByUuid(uuid, resetLoginPwdVo.getPwd(), forgetCode, resetLoginPwdVo.getIp(), resetLoginPwdVo.getSource(), token);
                if (!MrbMemberConstant.Login.IM_SUCCESS_CATION.equals(resultResultVo.getStatus().name())) {
                    throw new ServerException(500, resultResultVo.getMsg());
                }
            } else {
                throw new ServerException(500, "获取accessToken失败");
            }
        } else {
            resMsg.setCode(6001);
            resMsg.setMessage("该手机号码未注册，请输入正确的手机号码");
        }
        return resMsg;
    }


    /**
     * 找回支付密码
     *
     * @param payPwdVo
     * @return
     */
    @Override
    public ResponseMessage reSetPayPwdOnUnLogin(ResetPayPwdVo payPwdVo) {
        checkVerifyCode(payPwdVo.getVerifyCode(), payPwdVo.getMobile());
        ResponseMessage resMsg = ResponseMessageFactory.newInstance();
        //根据手机号码查询UUID
        Member member = memberMapper.queryByMobile(payPwdVo.getMobile());
        if (member != null) {
            String uuid = member.getAmezUuid();
            String token = amezResponse.getAccessToken();
            if (!StringUtils.isBlank(token)) {
                //获取forgetPwdCode
                String forgetCode = amezResponse.getForgetCode(uuid, token, 2);
                if (StringUtils.isBlank(forgetCode)) {
                    throw new ServerException(500, "获取Code失败");
                }
                //提交重置
                ResultVo<Boolean> resultResultVo = amezResponse.resetUpdatePayPasswordByUuid(uuid, payPwdVo.getPayPwd(), forgetCode, payPwdVo.getIp(), payPwdVo.getSource(), token);
                if (!MrbMemberConstant.Login.IM_SUCCESS_CATION.equals(resultResultVo.getStatus().name())) {
                    throw new ServerException(500, resultResultVo.getMsg());
                } else {
                    boolean result = resultResultVo.getData();
                    if (!result) {
                        throw new ServerException(500, resultResultVo.getMsg());
                    }
                }
            } else {
                throw new ServerException(500, "获取accessToken失败");
            }
        } else {
            resMsg.setCode(6001);
            resMsg.setMessage("查询不到会员信息，无法找回");
        }
        return resMsg;
    }


    @Override
    public ResponseMessage initLoginPassword(String uuid, String password, String ip, String source) {
        ResponseMessage res = new ResponseMessage();
        ResultVo<MemberResult> resultVo = amezResponse.initLoginPwdByUuid(uuid, password, ip, source);
        boolean isTrue = "SUCCESS".equals(resultVo.getStatus().name());
        if (!isTrue) {
            res.setCode(resultVo.getCode());
            res.setMessage(resultVo.getMsg());
        }
        return res;
    }


    @Override
    public ResponseMessage initPayPassWord(String uuid, String password, String ip, String source) {
        ResponseMessage res = new ResponseMessage();
        ResultVo<Boolean> resultVo = amezResponse.initPayPassword(uuid, password, ip, source);
        boolean isTrue = ("SUCCESS".equals(resultVo.getStatus().name())) && (true == resultVo.getData().booleanValue());
        if (!isTrue) {
            res.setCode(resultVo.getCode());
            res.setMessage(resultVo.getMsg());
        }
        return res;
    }


    @Override
    public ResponseMessage updateLoginPassword(String uuid, String oldPassword, String newPassword, String ip) {
        ResponseMessage res = new ResponseMessage();
        ResultVo<MemberResult> resultVo = amezResponse.updateLoginPassword(uuid, oldPassword, newPassword, ip);
        boolean isTrue = "SUCCESS".equals(resultVo.getStatus().name());
        if (!isTrue) {
            res.setCode(resultVo.getCode());
            res.setMessage(resultVo.getMsg());
        }
        return res;
    }

    @Override
    public ResponseMessage updatePayPassword(String uuid, String oldPayPassword, String newPayPassword, String ip) {
        ResponseMessage res = new ResponseMessage();
        ResultVo<Boolean> resultVo = amezResponse.updatePayPassword(uuid, oldPayPassword, newPayPassword, ip);
        boolean isTrue = ("SUCCESS".equals(resultVo.getStatus().name())) && (true == resultVo.getData().booleanValue());
        if (!isTrue) {
            res.setCode(resultVo.getCode());
            res.setMessage(resultVo.getMsg());
        }
        return res;
    }


    @Override
    public ResponseMessage matchPayPassword(String uuid, String payPassword) {
        ResponseMessage res = new ResponseMessage();
        /**
         * 校验支付密码错误超过三次，冻结24小时业务
         * redis的key
         */
        StringBuffer sb = new StringBuffer();
        sb.append("payPwd_").append(uuid);
        boolean exists = redisService.existsStr(sb.toString());
        //查看redis的支付密码key是否存在。
        //如不存在：验证正确直接返回，验证错误记录错误次数+1
        if (!exists) {
            ResultVo<Boolean> resultVo = amezResponse.matchPayPassword(uuid, payPassword);
            boolean isTrue = ("SUCCESS".equals(resultVo.getStatus().name())) && (true == resultVo.getData().booleanValue());
            if (!isTrue) {
                redisService.set(sb.toString(), 1, 1000L * 60 * 60 * 24);
                res.setCode(resultVo.getCode());
                res.setMessage(resultVo.getMsg());
            }
        } else {
            //如存在：判断是否超过三次，如果超过3次，提示稍后重新输入。
            Integer pwdCount = Integer.parseInt(redisService.getStr(sb.toString()));
            int maxNumber = 3;
            if (pwdCount >= maxNumber) {
                res.setCode(6001);
                res.setMessage("您支付密码输入错误超过三次，请稍后重新输入!");
            } else {
                //如果不超过三次：验证正确直接返回并且删除支付密码的Key，如果不正确，错误验证次数再次+1
                ResultVo<Boolean> resultVo = amezResponse.matchPayPassword(uuid, payPassword);
                boolean isTrue = ("SUCCESS".equals(resultVo.getStatus().name())) && (true == resultVo.getData().booleanValue());
                if (!isTrue) {
                    redisService.set(sb.toString(), 1 + pwdCount, 1000L * 60 * 60 * 24);
                    res.setCode(resultVo.getCode());
                    res.setMessage(resultVo.getMsg());
                } else {
                    redisService.remove(sb.toString());
                }
            }
        }
        return res;
    }
}
