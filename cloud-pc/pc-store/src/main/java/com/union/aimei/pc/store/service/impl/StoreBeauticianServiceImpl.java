package com.union.aimei.pc.store.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.codingapi.tx.annotation.TxTransaction;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.constant.common.CommonConstant;
import com.union.aimei.common.constant.store.StoreConstant;
import com.union.aimei.common.feign.im.pc.EasemobImUsersFeign;
import com.union.aimei.common.feign.pc.member.MemberFeign;
import com.union.aimei.common.feign.pc.product.ProductBeauticianRefFeign;
import com.union.aimei.common.feign.pc.product.ProductFeign;
import com.union.aimei.common.feign.pc.system.BaseUserFeign;
import com.union.aimei.common.model.im.ImUsers;
import com.union.aimei.common.model.member.Member;
import com.union.aimei.common.model.product.Product;
import com.union.aimei.common.model.product.ProductBeauticianRef;
import com.union.aimei.common.model.store.Store;
import com.union.aimei.common.model.store.StoreBeautician;
import com.union.aimei.common.model.store.StoreBeauticianAffiliated;
import com.union.aimei.common.model.store.StoreBeauticianLevel;
import com.union.aimei.common.model.system.BaseUser;
import com.union.aimei.common.util.learn.ConditionUtil;
import com.union.aimei.common.vo.product.pc.StoreByDataCountVo;
import com.union.aimei.common.vo.store.app.BeauticianListSelectOnSaleProductResVo;
import com.union.aimei.common.vo.store.app.BeauticianListSelectOnSaleProductVo;
import com.union.aimei.common.vo.store.pc.BeauticianByStarBatchVo;
import com.union.aimei.common.vo.store.pc.StoreBeaByFullTimeAndPartTimeVo;
import com.union.aimei.common.vo.store.pc.StoreBeauticianByRecruitVo;
import com.union.aimei.common.vo.system.BaseUserVo;
import com.union.aimei.pc.store.mapper.StoreBeauticianAffiliatedMapper;
import com.union.aimei.pc.store.mapper.StoreBeauticianMapper;
import com.union.aimei.pc.store.service.StoreBeauticianLevelService;
import com.union.aimei.pc.store.service.StoreBeauticianService;
import com.union.aimei.remote.model.MrbMemberLoginVo;
import com.union.common.utils.ResponseException;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseUtil;
import com.union.common.utils.constant.ResponseContants;
import com.union.common.utils.encryption.Md5Util;
import io.swagger.client.model.User;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

/**
 * 店铺美容师
 *
 * @author liurenkai
 * @time 2018/1/12 17:34
 */
@SuppressWarnings("ALL")
@Service("storeBeauticianService")
public class StoreBeauticianServiceImpl implements StoreBeauticianService {
    @Resource
    private StoreBeauticianMapper storeBeauticianMapper;
    @Resource
    private BaseUserFeign baseUserFeign;
    @Resource
    private EasemobImUsersFeign easemobImUsersFeign;
    @Resource
    private MemberFeign memberFeign;
    @Resource
    private StoreBeauticianAffiliatedMapper storeBeauticianAffiliatedMapper;
    @Resource
    private ProductFeign productFeign;
    @Resource
    private ProductBeauticianRefFeign productBeauticianRefFeign;
    @Resource
    private StoreBeauticianLevelService storeBeauticianLevelService;

    @Override
    public ResponseMessage<PageInfo<StoreBeautician>> findByPageForFront(Integer pageNo, Integer pageSize, StoreBeautician storeBeautician) {
        ResponseMessage<PageInfo<StoreBeautician>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        List<StoreBeautician> list = this.storeBeauticianMapper.selectListByConditions(storeBeautician);
        PageInfo<StoreBeautician> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

    /**
     * 添加店铺美容师
     *
     * @param storeBeautician
     * @return
     */
    @Override
    @TxTransaction
    @Transactional(rollbackFor = Exception.class)
    public int addObj(StoreBeautician storeBeautician) {
        return this.storeBeauticianMapper.insertSelective(storeBeautician);
    }

    /**
     * 删除店铺美容师
     *
     * @param id
     * @return
     */
    @Override
    public int deleteObjById(int id) {
        return this.storeBeauticianMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改店铺美容师
     *
     * @param storeBeautician
     * @return
     */
    @Override
    public int modifyObj(StoreBeautician storeBeautician) {
        return this.storeBeauticianMapper.updateByPrimaryKeySelective(storeBeautician);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnstoreBeautician
     */
    @Override
    public StoreBeautician queryObjById(int id) {
        StoreBeautician model = this.storeBeauticianMapper.selectByPrimaryKey(id);
        return model;
    }

    @Override
    public ResponseMessage<StoreBeautician> findByUserId(int userId) {
        ResponseMessage<StoreBeautician> responseMessage = new ResponseMessage<>();
        // 美容师
        StoreBeautician beautician = this.storeBeauticianMapper.selectByUserId(userId);
        if (null == beautician) {
            responseMessage.setCode(StoreConstant.Query.BEAUTICIAN_NULL);
            responseMessage.setMessage(StoreConstant.Query.BEAUTICIAN_NULL_MSG);
            return responseMessage;
        }
        responseMessage.setData(beautician);
        return responseMessage;
    }

    @Override
    public ResponseMessage<StoreBeautician> findByUserIdForNormal(int userId) {
        ResponseMessage<StoreBeautician> responseMessage = new ResponseMessage<>();
        // 美容师
        StoreBeautician beautician = this.storeBeauticianMapper.selectByUserId(userId);
        if (null == beautician) {
            throw new ResponseException(StoreConstant.Query.BEAUTICIAN_NULL, StoreConstant.Query.BEAUTICIAN_NULL_MSG);
        }
        if (beautician.getRegisterStatus() != StoreBeautician.RegisterStatus.PASS) {
            throw new ResponseException(StoreConstant.Query.BEAUTICIAN_NULL, StoreConstant.Query.BEAUTICIAN_NULL_MSG);
        }
        responseMessage.setData(beautician);
        return responseMessage;
    }

    @Override
    public ResponseMessage<StoreBeautician> findByPhone(String phone) {
        ResponseMessage<StoreBeautician> responseMessage = new ResponseMessage<>();
        StoreBeautician beautician = this.storeBeauticianMapper.selectByPhone(phone);
        if (null == beautician) {
            throw new ResponseException(StoreConstant.Query.BEAUTICIAN_NULL, StoreConstant.Query.BEAUTICIAN_NULL_MSG);
        }
        responseMessage.setData(beautician);
        return responseMessage;
    }

    @Override
    public ResponseMessage<StoreBeautician> findByMemberId(Integer memberId) {
        ResponseMessage<StoreBeautician> responseMessage = new ResponseMessage<>();
        StoreBeautician beautician = this.storeBeauticianMapper.getByMemberId(memberId);
        if (null == beautician) {
            throw new ResponseException(StoreConstant.Query.BEAUTICIAN_NULL, StoreConstant.Query.BEAUTICIAN_NULL_MSG);
        }
        responseMessage.setData(beautician);
        return responseMessage;
    }

    @Override
    public ResponseMessage<PageInfo<StoreBeautician>> findByPageForRecruit(Integer pageNo, Integer pageSize, StoreBeauticianByRecruitVo storeBeauticianByRecruitVo) {
        ResponseMessage<PageInfo<StoreBeautician>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        storeBeauticianByRecruitVo.setAuditStatus(StoreBeauticianByRecruitVo.AUDIT_STATUS_STATUS_TYPE_APPROVED);
        storeBeauticianByRecruitVo.setBeauticianStatus(StoreBeauticianByRecruitVo.BEAUTICIAN_STATUS_TYPE_OFFICE);
        storeBeauticianByRecruitVo.setBeauticianType(StoreBeauticianByRecruitVo.BEAUTICIAN_TYPE_THE_EMPLOYEES);
        List<StoreBeautician> storeBeauticianList = this.storeBeauticianMapper.selectListByRecruit(storeBeauticianByRecruitVo);
        PageInfo<StoreBeautician> page = new PageInfo<>(storeBeauticianList);
        responseMessage.setData(page);
        return responseMessage;
    }

    @Override
    public ResponseMessage<StoreBeautician> findById(int id) {
        ResponseMessage<StoreBeautician> responseMessage = new ResponseMessage<>();
        StoreBeautician storeBeautician = this.storeBeauticianMapper.selectByPrimaryKey(id);
        if (storeBeautician == null) {
            responseMessage.setCode(StoreConstant.Query.BEAUTICIAN_NULL);
            responseMessage.setMessage(StoreConstant.Query.BEAUTICIAN_NULL_MSG);
            return responseMessage;
        }
        responseMessage.setData(storeBeautician);
        return responseMessage;
    }

    @Override
    public ResponseMessage<StoreBeautician> findByStoreIdForManager(int storeId) {
        ResponseMessage<StoreBeautician> responseMessage = new ResponseMessage<>();
        StoreBeautician storeBeautician = this.storeBeauticianMapper.selectByStoreIdForManager(storeId);
        if (storeBeautician == null) {
            responseMessage.setCode(StoreConstant.Query.BEAUTICIAN_STORE_MANAGER_NULL);
            responseMessage.setMessage(StoreConstant.Query.BEAUTICIAN_STORE_MANAGER_NULL_MSG);
            return responseMessage;
        }
        responseMessage.setData(storeBeautician);
        return responseMessage;
    }

    @Override
    public ResponseMessage<PageInfo<StoreBeautician>> findByPageForFullTimeAndPartTime(Integer pageNo, Integer pageSize, StoreBeaByFullTimeAndPartTimeVo fullTimeAndPartTimeVo) {
        ResponseMessage<PageInfo<StoreBeautician>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        Map<String, Object> voMap = JSONObject.parseObject(JSON.toJSONString(fullTimeAndPartTimeVo), Map.class);
        Map<String, Object> condMap = ConditionUtil.passBeautician();
        condMap.putAll(voMap);
        List<StoreBeautician> storeBeauticianList = this.storeBeauticianMapper.selectListByBeautician(condMap);
        PageInfo<StoreBeautician> page = new PageInfo<>(storeBeauticianList);
        responseMessage.setData(page);
        return responseMessage;
    }

    @Override
    public ResponseMessage<Integer> pendingByCount(StoreByDataCountVo dataCountVo) {
        ResponseMessage<Integer> responseMessage = new ResponseMessage<>();
        Map<String, Object> condMap = new HashMap<>(16);
        Map<String, Object> voMap = JSONObject.parseObject(JSON.toJSONString(dataCountVo), Map.class);
        condMap.put("storeId", dataCountVo.getStoreId());
        condMap.putAll(voMap);
        int count = this.storeBeauticianMapper.pendingByCount(condMap);
        responseMessage.setData(count);
        return responseMessage;
    }

    @Override
    public ResponseMessage star(int id, boolean isStar) {
        ResponseMessage responseMessage = new ResponseMessage();
        if (isStar) {
            StoreBeautician starCond = new StoreBeautician();
            starCond.setIsEnabled(true);
            starCond.setIsStar(true);
            List<StoreBeautician> starList = this.storeBeauticianMapper.selectListByConditions(starCond);
            if (CommonConstant.Beautician.STAR_LIMIT <= starList.size()) {
                responseMessage.setCode(StoreConstant.Update.BEAUTICIAN_STAR_LIMIT);
                responseMessage.setMessage(StoreConstant.Update.BEAUTICIAN_STAR_LIMIT_MSG);
                return responseMessage;
            }
        }
        StoreBeautician storeBeautician = new StoreBeautician();
        storeBeautician.setId(id);
        storeBeautician.setIsStar(isStar);
        this.storeBeauticianMapper.updateByPrimaryKeySelective(storeBeautician);
        return responseMessage;
    }

    @Override
    public ResponseMessage starByBatch(BeauticianByStarBatchVo starBatchVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        this.storeBeauticianMapper.cancelStarByCityId(starBatchVo.getCityId());
        this.storeBeauticianMapper.updateBatchByStar(starBatchVo.getBeauticianList());
        return responseMessage;
    }

    @Override
    public ResponseMessage workCardNoByStoreIdCount(int storeId, String workCardNo, int notId) {
        ResponseMessage<StoreBeautician> responseMessage = new ResponseMessage<>();
        Map<String, Object> map = new HashMap<>(16);
        map.put("storeId", storeId);
        map.put("workCardNo", workCardNo);
        if (notId != -1) {
            map.put("notId", notId);
        }
        Integer total = this.storeBeauticianMapper.pendingByCount(map);
        if (total != 0) {
            responseMessage.setCode(StoreConstant.Query.BEAUTICIAN_WORK_CARD_NO_EXIST);
            responseMessage.setMessage(StoreConstant.Query.BEAUTICIAN_WORK_CARD_NO_EXIST_MSG);
        }
        return responseMessage;
    }

    @Override
    public ResponseMessage editLimitWorkCardNoByStoreId(StoreBeautician storeBeautician) {
        ResponseMessage responseMessage = this.workCardNoByStoreIdCount(storeBeautician.getStoreId(), storeBeautician.getWorkCardNo(), storeBeautician.getId());
        if (ResponseUtil.isSuccess(responseMessage)) {
            Integer total = this.storeBeauticianMapper.updateByPrimaryKeySelective(storeBeautician);
            if (total != 1) {
                responseMessage.setCode(StoreConstant.Query.BEAUTICIAN_WORK_CARD_NO_EXIST);
                responseMessage.setMessage(StoreConstant.Query.BEAUTICIAN_WORK_CARD_NO_EXIST_MSG);
            }
        }
        return responseMessage;
    }

    @Override
    public ResponseMessage<StoreBeautician> add(StoreBeautician beautician) {
        ResponseMessage<StoreBeautician> responseMessage = new ResponseMessage();
        // 手机号是否存在
        StoreBeautician phoneBeautician = this.storeBeauticianMapper.selectByPhone(beautician.getPhone());
        if (null != phoneBeautician) {
            throw new ResponseException(StoreConstant.Query.BEAUTICIAN_PHONE_EXIST, StoreConstant.Query.BEAUTICIAN_PHONE_EXIST_MSG);
        }
        // 工牌号是否存在
        if (null != beautician.getStoreId() && StringUtils.isNotEmpty(beautician.getWorkCardNo())) {
            Map<String, Object> workCardNoCond = new HashMap<>(16);
            workCardNoCond.put("storeId", beautician.getStoreId());
            workCardNoCond.put("workCardNo", beautician.getWorkCardNo());
            StoreBeautician workCardNoBeautician = this.storeBeauticianMapper.getByWorkCardNo(workCardNoCond);
            if (null != workCardNoBeautician) {
                throw new ResponseException(StoreConstant.Query.BEAUTICIAN_WORK_CARD_NO_EXIST, StoreConstant.Query.BEAUTICIAN_WORK_CARD_NO_EXIST_MSG);
            }
        }
        // 是否平台
        if (Store.ID_PLATEFORM == beautician.getStoreId()) {
            this.addByPlatform(beautician);
        } else {
            this.addByStore(beautician);
        }
        responseMessage.setData(beautician);
        return responseMessage;
    }

    /**
     * 保存平台美容师
     *
     * @param beautician 美容师
     * @return
     */
    private StoreBeautician addByPlatform(StoreBeautician beautician) {
        // 后台用户
        BaseUserVo baseUserVo = new BaseUserVo();
        baseUserVo.setPhone(beautician.getPhone());
        baseUserVo.setUserType(beautician.getBeauticianType());
        ResponseMessage<BaseUser> baseUserRes = this.baseUserFeign.insertBbossAndShopkeeperAndMember(baseUserVo);
        ResponseUtil.isFailThrowException(baseUserRes);
        BaseUser baseUser = baseUserRes.getData();
        beautician.setUserId(baseUser.getUserId());
        // IM用户
        User user = new User();
        user.setUsername(UUID.randomUUID().toString().replace("-", ""));
        user.setPassword(ImUsers.DEFAULT_PASSWORD);
        ResponseMessage<ImUsers> imUsersRes = this.easemobImUsersFeign.registerSingle(user);
        ResponseUtil.isFailThrowException(imUsersRes);
        ImUsers imUsers = imUsersRes.getData();
        beautician.setImUserId(imUsers.getId());
        beautician.setImUsername(imUsers.getUsername());
        // 美容师
        this.storeBeauticianMapper.insertSelective(beautician);
        return beautician;
    }

    /**
     * 保存美容师
     *
     * @param beautician 美容师
     * @return
     */
    private StoreBeautician addByStore(StoreBeautician beautician) {
        // 后台用户
        // 美容师类型=老板/店长
        if (beautician.getBeauticianType() == StoreBeautician.BeauticianType.BOSS || beautician.getBeauticianType() == StoreBeautician.BeauticianType.MANAGER) {
            BaseUserVo baseUserVo = new BaseUserVo();
            baseUserVo.setPhone(beautician.getPhone());
            baseUserVo.setUserType(beautician.getBeauticianType());
            ResponseMessage<BaseUser> baseUserRes = this.baseUserFeign.insertBbossAndShopkeeperAndMember(baseUserVo);
            ResponseUtil.isFailThrowException(baseUserRes);
            BaseUser baseUser = baseUserRes.getData();
            beautician.setUserId(baseUser.getUserId());
        }
        // 会员
        MrbMemberLoginVo mrbMemberLoginVo = new MrbMemberLoginVo();
        mrbMemberLoginVo.setLoginCustomer(1);
        mrbMemberLoginVo.setLoginType(1);
        mrbMemberLoginVo.setIp("192.168.1.1");
        mrbMemberLoginVo.setMobile(beautician.getPhone());
        mrbMemberLoginVo.setPassword(Md5Util.md5("123456cnbbx"));
        mrbMemberLoginVo.setSource("1");
        mrbMemberLoginVo.setUserName(beautician.getPhone());
        ResponseMessage<Member> memberRes = this.memberFeign.registerAmezMember(mrbMemberLoginVo);
        if (ResponseUtil.isFail(memberRes)) {
            // 1-已注册，2-用户=老板
            if (!(ResponseContants.QUERY_RESULT_EMPTY == memberRes.getCode() && StoreBeautician.BeauticianType.BOSS == beautician.getBeauticianType())) {
                throw new ResponseException(memberRes);
            }
        }
        Member member = memberRes.getData();
        beautician.setMemberId(member.getId());
        // IM用户
        User user = new User();
        user.setUsername(UUID.randomUUID().toString().replace("-", ""));
        user.setPassword(ImUsers.DEFAULT_PASSWORD);
        ResponseMessage<ImUsers> imUsersRes = this.easemobImUsersFeign.registerSingle(user);
        ResponseUtil.isFailThrowException(imUsersRes);
        ImUsers imUsers = imUsersRes.getData();
        beautician.setImUserId(imUsers.getId());
        beautician.setImUsername(imUsers.getUsername());
        member.setImUserId(imUsers.getId());
        member.setImUsername(imUsers.getUsername());
        // 会员更新
        this.memberFeign.modify(member);
        // 美容师
        beautician.setRegisterStatus(StoreBeautician.RegisterStatus.PASS);
        beautician.setRealNameStatus(StoreBeautician.RealNameStatus.WAIT_COMMIT);
        this.storeBeauticianMapper.insertSelective(beautician);
        // 门店-美容师-招募
        StoreBeauticianAffiliated affiliated = new StoreBeauticianAffiliated();
        affiliated.setAffiliatedType(StoreBeauticianAffiliated.AffiliatedType.APPLY);
        affiliated.setSponsor(StoreBeauticianAffiliated.Sponsor.STORE);
        affiliated.setBeauticianType(beautician.getBeauticianType());
        affiliated.setStoreId(beautician.getStoreId());
        affiliated.setStoreName(beautician.getStoreName());
        affiliated.setBeauticianId(beautician.getId());
        affiliated.setAuditStatus(StoreBeauticianAffiliated.AuditStatus.PASS);
        affiliated.setAuditTime(new Date());
        this.storeBeauticianAffiliatedMapper.insertSelective(affiliated);
        // 美容师更新
        switch (beautician.getBeauticianType()) {
            case StoreBeautician.BeauticianType.FULL_TIME:
                beautician.setAffiliatedId(affiliated.getId());
                beautician.setAffiliatedStatus(StoreBeautician.AffiliatedStatus.SETTLED);
                this.storeBeauticianMapper.updateByPrimaryKeySelective(beautician);
                break;
            case StoreBeautician.BeauticianType.PART_TIME:
                beautician.setAffiliatedId(affiliated.getId());
                beautician.setAffiliatedStatus(StoreBeautician.AffiliatedStatus.AFFILIATED);
                this.storeBeauticianMapper.updateByPrimaryKeySelective(beautician);
                break;
            default:
                break;
        }
        return beautician;
    }

    @Override
    public ResponseMessage modify(StoreBeautician storeBeautician) {
        ResponseMessage responseMessage = new ResponseMessage();
        int result = this.storeBeauticianMapper.updateByPrimaryKeySelective(storeBeautician);
        responseMessage.setData(result);
        return responseMessage;
    }

    @Override
    public ResponseMessage<List<StoreBeautician>> listFullTimeByStoreId(int storeId) {
        ResponseMessage<List<StoreBeautician>> responseMessage = new ResponseMessage<>();
        Map<String, Object> condMap = ConditionUtil.passBeautician();
        condMap.put("beauticianType", StoreBeautician.BeauticianType.FULL_TIME);
        condMap.put("storeId", storeId);
        List<StoreBeautician> list = this.storeBeauticianMapper.listFullTimeByStoreId(condMap);
        if (CollectionUtils.isEmpty(list)) {
            throw new ResponseException(StoreConstant.Query.BEAUTICIAN_STORE_FULL_TIME_NULL, StoreConstant.Query.BEAUTICIAN_STORE_FULL_TIME_NULL_MSG);
        }
        responseMessage.setData(list);
        return responseMessage;
    }

    @Override
    public ResponseMessage accumulateGrowthValueV111(int beauticianId, int growthValue) {
        ResponseMessage responseMessage = new ResponseMessage();
        StoreBeautician beautician = this.storeBeauticianMapper.selectByPrimaryKey(beauticianId);
        if (null == beautician) {
            throw new ResponseException(StoreConstant.Query.BEAUTICIAN_NULL, StoreConstant.Query.BEAUTICIAN_NULL_MSG);
        }
        Integer growth = beautician.getGrowupValue() + growthValue;
        //查询当前等级
        ResponseMessage<StoreBeauticianLevel> storeBeauticianLevelResponseMessage = this.storeBeauticianLevelService.getLevelBySetionGrowup(growth);
        ResponseUtil.isFailThrowException(storeBeauticianLevelResponseMessage);
        StoreBeauticianLevel storeBeauticianLevel = storeBeauticianLevelResponseMessage.getData();
        if (null == storeBeauticianLevel) {
            throw new ResponseException(StoreConstant.Query.BEAUTICIAN_LEVEL_EXIST, StoreConstant.Query.BEAUTICIAN_LEVEL_EXIST_MSG);
        }
        beautician.setBeauticianStar(storeBeauticianLevel.getStarValue());
        beautician.setLevelId(storeBeauticianLevel.getId());
        beautician.setLevelLogo(storeBeauticianLevel.getLevelLogo());
        beautician.setLevelName(storeBeauticianLevel.getLevelName());
        beautician.setGrowupValue(growth);
        this.storeBeauticianMapper.updateByPrimaryKeySelective(beautician);
        responseMessage.setData(beautician.getGrowupValue());
        return responseMessage;
    }

    @Override
    public ResponseMessage<PageInfo<BeauticianListSelectOnSaleProductResVo>> listSelectOnSaleProduct(Integer pageNo, Integer pageSize, BeauticianListSelectOnSaleProductVo productVo) {
        ResponseMessage<PageInfo<BeauticianListSelectOnSaleProductResVo>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        Map<String, Object> condMap = JSONObject.parseObject(JSON.toJSONString(productVo), Map.class);
        condMap.put("pbrAuditStatus", ProductBeauticianRef.AuditStatus.PASS);
        condMap.putAll(ConditionUtil.passBeautician());
        condMap.put("fulltimeBeauticianType", StoreBeautician.BeauticianType.FULL_TIME);
        List<BeauticianListSelectOnSaleProductResVo> list = null;
        switch (productVo.getServerType()) {
            case Product.ServerType.STORE:
                list = this.storeBeauticianMapper.listSelectOnSaleStoreProduct(condMap);
                break;
            case Product.ServerType.HOME:
                list = this.storeBeauticianMapper.listSelectOnSaleHomeProduct(condMap);
                break;
            default:
                break;
        }
        PageInfo<BeauticianListSelectOnSaleProductResVo> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

}