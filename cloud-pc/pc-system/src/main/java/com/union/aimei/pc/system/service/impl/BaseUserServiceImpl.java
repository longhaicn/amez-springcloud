package com.union.aimei.pc.system.service.impl;

import com.aliyuncs.exceptions.ClientException;
import com.codingapi.tx.annotation.TxTransaction;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.union.aimei.common.feign.pc.store.StoreBeauticianFeign;
import com.union.aimei.common.feign.pc.store.StoreFeign;
import com.union.aimei.common.model.store.Store;
import com.union.aimei.common.model.store.StoreBeautician;
import com.union.aimei.common.model.system.BaseOperator;
import com.union.aimei.common.model.system.BaseUser;
import com.union.aimei.common.model.system.BaseUserExample;
import com.union.aimei.common.model.system.BaseUserRole;
import com.union.aimei.common.vo.system.BaseUserVo;
import com.union.aimei.common.vo.system.SmsMessageVo;
import com.union.aimei.common.vo.system.UserVo;
import com.union.aimei.pc.system.config.Constant;
import com.union.aimei.pc.system.mapper.BaseUserMapper;
import com.union.aimei.pc.system.service.*;
import com.union.common.utils.AssertUtil;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseUtil;
import com.union.common.utils.encryption.Md5Util;
import com.union.redis.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author liufeihua
 */
@Service
public class BaseUserServiceImpl implements BaseUserService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    RedisService redisService;
    @Autowired
    SmsService smsService;
    @Autowired
    BaseOperatorService operatorService;
    @Autowired(required = false)
    private BaseUserMapper baseUserMapper;
    @Autowired
    private BaseMenuService menuService;
    @Autowired
    private BaseUserRoleService userRoleService;

    @Autowired
    private StoreFeign storeFeign;
    @Autowired
    private StoreBeauticianFeign storeBeauticianFeign;

    @Override
    public int deleteByPrimaryKey(Integer userId) {
        return this.baseUserMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public ResponseMessage<BaseUser> insertSelective(BaseUser record) {
        logger.info("用户名-----------------------" + record.getLoginName());
        AssertUtil.notNull(record.getLoginName(), "用户名不能为空!", Constant.NAME_IS_NOT_NULL);

        //判断用户名是否重复
        BaseUser parames = new BaseUser();
        parames.setLoginName(record.getLoginName());
        List<BaseUser> baseUsersLoginName = baseUserMapper.selectListByConditions(parames);
        AssertUtil.isTrue(baseUsersLoginName.size() <= 0, "用户名已存在", Constant.NAME_IS_EXIT);

        //判断手机号码是否重复
        if (record.getMobilePhone() != null) {
            parames.setLoginName(null);
            logger.debug("手机号码-----------------------" + record.getMobilePhone());
            parames.setMobilePhone(record.getMobilePhone());
        }
        List<BaseUser> baseUsersPhone = baseUserMapper.selectListByConditions(parames);
        AssertUtil.isTrue(baseUsersPhone.size() <= 0, "手机号码已存在", Constant.PHONE_IS_EXIT);

        //密码由前端加密
        record.setCreateTime(new Date());
        int id = baseUserMapper.insertSelective(record);
        logger.debug("用户id-----------------------" + id);
        return new ResponseMessage<>();


    }

    @Override
    public BaseUser selectByPrimaryKey(Integer userId) {
        return this.baseUserMapper.selectByPrimaryKey(userId);
    }

    @Override
    public int updateByPrimaryKeySelective(BaseUser record) {
        record.setPassword(record.getPassword());
        record.setUpdateTime(new Date());
        return this.baseUserMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public PageInfo<BaseUser> selectListByConditions(Integer pageNo, Integer pageSize, BaseUser record) {
        PageHelper.startPage(pageNo, pageSize);
        return new PageInfo<>(baseUserMapper.selectListByConditions(record));
    }

    /**
     * describe: 用户登录
     * create_by: liufeihua in 2017/12/11 11:21
     */
    @Override
    public ResponseMessage<Map<String, Object>> userLogin(UserVo userVo) {
        HashMap<String, Object> response = new HashMap<>(2);
        AssertUtil.notNull(userVo.getUserName(), "用户名或者手机号码不能为空!", Constant.NAME_IS_NOT_NULL);
        AssertUtil.notNull(userVo.getPassword(), "密码或者验证码不能为空!", Constant.PASS_IS_NOT_NULL);
        //判断是账号登录还是手机登录
        BaseUserExample e = new BaseUserExample();
        BaseUserExample.Criteria c = e.createCriteria();
        if (userVo.getLoginType() == 0) {
            c.andLoginNameEqualTo(userVo.getUserName());
        } else if (userVo.getLoginType() == 1) {
            c.andMobilePhoneEqualTo(userVo.getUserName());
        }
        List<BaseUser> baseUsers = baseUserMapper.selectByExample(e);
        AssertUtil.isTrue(baseUsers.size() > 0, "用户不存在!", Constant.NAME_IS_NOT_EXIT);
        BaseUser user = baseUsers.get(0);
        //判断密码还是验证码
        if (userVo.getLoginType() == 0) {
            //密码由前端加密过来
            AssertUtil.isTrue(user.getPassword().equals(userVo.getPassword()), "密码不正确!", Constant.PASS_IS_NOT_CORRECT);
        } else if (userVo.getLoginType() == 1) {
            String random = redisService.getStr(userVo.getUserName());
            AssertUtil.isTrue(userVo.getPassword().equals(random), "验证码不正确!", Constant.PASS_IS_NOT_CORRECT);
        }
        AssertUtil.isTrue(user.getIsDisabled() == 0, "用户被禁用!", Constant.NAME_IS_NOT_USE);
        String admin = "admin";
        if (admin.equals(user.getLoginName())) {
            response.put("menu", menuService.findAdminLoginMenus());
        } else {
            response.put("menu", menuService.findLoginMenus(user.getUserId()));
        }
        //添加用户类型
        BaseUserRole build = BaseUserRole.builder().userId(user.getUserId()).build();
        PageInfo<BaseUserRole> baseUserRolePageInfo = userRoleService.selectListByConditions(0, 10, build);
        List<BaseUserRole> list = baseUserRolePageInfo.getList();
        if (list.size() > 0) {
            BaseUserRole userRole = list.get(0);
            response.put("workerType", userRole.getRoleId());
            //查询权限
            PageInfo<BaseOperator> baseOperatorPageInfo = null;
            if (admin.equals(user.getLoginName())) {
                baseOperatorPageInfo = operatorService.selectListByConditions(0, 100, new BaseOperator());
            } else {
                BaseOperator baseOperator = BaseOperator.builder().roleId(userRole.getRoleId()).build();
                baseOperatorPageInfo = operatorService.selectListByConditions(0, 100, baseOperator);
            }
            response.put("operator", baseOperatorPageInfo);
        }
        response.put("user", user);
        ResponseMessage<Map<String, Object>> message = new ResponseMessage<>(response);
        Map<String, Object> data = message.getData();
        if (null != data && !admin.equals(userVo.getUserName())) {
            // 美容师
            ResponseMessage<StoreBeautician> beauticianRes = this.storeBeauticianFeign.findByUserId(user.getUserId());
            int code =200;
            if (beauticianRes.getCode() == code) {
                StoreBeautician beautician = beauticianRes.getData();
                // 门店
                ResponseMessage<Store> storeRes = this.storeFeign.findById(beautician.getStoreId());
                ResponseUtil.isFailThrowException(storeRes);
                Store store = storeRes.getData();
                data.put("storeBeautician", beautician);
                data.put("store", store);
                message.setData(data);
            }

        }
        return message;

    }

    /**
     * 添加老板
     *
     * @param record
     * @return
     */
    @Override
    @TxTransaction
    @Transactional(rollbackFor = Exception.class)
    public ResponseMessage<BaseUser> insertBbossAndShopkeeperAndMember(BaseUserVo record) {
        BaseUserExample example = new BaseUserExample();
        BaseUserExample.Criteria criteria = example.createCriteria();
        criteria.andMobilePhoneEqualTo(record.getPhone());
        BaseUserExample.Criteria criteria2 = example.createCriteria();
        example.or(criteria2.andLoginNameEqualTo(record.getPhone()));
        List<BaseUser> baseUsers = baseUserMapper.selectByExample(example);

        ResponseMessage<BaseUser> baseUserResponseMessage = new ResponseMessage<>();

        BaseUser baseUser;
        //存在手机号码就直接返回数据
        if (baseUsers.size() > 0) {
            //处理用户存在的情况
            BaseUser user = baseUsers.get(0);
            if (user.getLoginName() == null) {
                user.setLoginName(record.getPhone());
            } else if (user.getMobilePhone() == null) {
                user.setMobilePhone(record.getPhone());
            }
            baseUserMapper.updateByPrimaryKeySelective(user);
            handlerUserIsExist(record, baseUsers, baseUserResponseMessage);
        } else {
            //不存在
            //生成密码
            String password = "123456";

            //1.添加用户
            baseUser = getBaseUser(record, password);

            //2.构造短信对象

            insertUserRole(record.getUserType(), baseUser.getUserId());

            //设置返回对象（有可能为null）
            baseUserResponseMessage.setData(baseUser);
        }

        return baseUserResponseMessage;
    }

    /**
     * 处理用户存在的情况
     *
     * @param record
     * @param baseUsers
     * @param baseUserResponseMessage
     */
    private void handlerUserIsExist(BaseUserVo record, List<BaseUser> baseUsers, ResponseMessage<BaseUser> baseUserResponseMessage) {
        baseUserResponseMessage.setCode(Constant.PHONE_IS_EXIT);
        baseUserResponseMessage.setMessage("手机号码已存在!");

        //如果是老板的话
        if (record.getUserType() == 0) {
            BaseUserRole build = BaseUserRole.builder().userId(baseUsers.get(0).getUserId()).roleId(62).build();
            PageInfo<BaseUserRole> baseUserRolePageInfo = userRoleService.selectListByConditions(0, 10, build);
            if (baseUserRolePageInfo.getList().size() > 0) {
                baseUserResponseMessage.setCode(200);

            }
        }
        baseUserResponseMessage.setData(baseUsers.get(0));
    }

    /**
     * 添加用户
     *
     * @param record
     * @param password
     * @return
     */
    private BaseUser getBaseUser(BaseUserVo record, String password) {
        BaseUser baseUser;
        baseUser = BaseUser.builder()
                .loginName(record.getPhone())
                .nickName(record.getPhone())
                .mobilePhone(record.getPhone())
                .password(Md5Util.md5(password + Constant.MD5_CNBBX))
                .isDisabled((byte) 0)
                .createTime(new Date())
                .build();
        //1.添加数据
        this.baseUserMapper.insertSelective(baseUser);
        return baseUser;
    }

    /**
     * 发送短信消息
     *
     * @param userType
     * @param phone
     * @param password
     */
    private void sendSmsMessage(int userType, String phone, String password) {

        SmsMessageVo smsMessageVo;
        //短信内容
        HashMap<String, Object> stringObjectHashMap = new HashMap<>(2);
        String smsCode = "";
        switch (userType) {
            //老板
            case 0:
                smsCode = "SMS_130928908";
                break;
            //店长
            case 1:
                smsCode = "SMS_130928909";
                break;
            //员工
            case 2:
                smsCode = "SMS_122283695";
                break;
            default:
                break;
        }
        smsMessageVo = SmsMessageVo.builder().phone(phone).smsCode(smsCode).build();

        stringObjectHashMap.put("phonenumber", phone);
        stringObjectHashMap.put("password", password);

        //设置短信内容
        smsMessageVo.setSmsContent(new Gson().toJson(stringObjectHashMap));

        //送短信
        try {
            smsService.sendSmsCode(smsMessageVo);
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加用户角色关联
     *
     * @param userType
     * @param userId
     */
    private void insertUserRole(int userType, int userId) {
        BaseUserRole userRole;
        int roleId = 0;
        switch (userType) {
            //老板
            case 0:
                roleId = 62;
                break;
            //店长
            case 1:
                roleId = 61;
                break;
            //员工
            case 2:
                roleId = 63;
                break;
            default:
                break;
        }
        userRole = BaseUserRole.builder().userId(userId).roleId(roleId).createTime(new Date()).build();
        //添加角色
        userRoleService.insertSelective(userRole);
    }


    @Override
    public List<Map<String, Object>> selectNewByPage() {
        return baseUserMapper.selectNewByPage();
    }

    /**
     * 关闭店铺的时候禁用用户登录--0启用 1禁用
     *
     * @param phone
     * @param flag
     * @return
     */
    @Override
    public ResponseMessage<Integer> updateUserSatuts(String phone, Integer flag) {
        BaseUser build = BaseUser.builder().mobilePhone(phone).build();

        List<BaseUser> baseUsers = baseUserMapper.selectListByConditions(build);
        if (baseUsers.size() > 0) {
            BaseUser baseUser = baseUsers.get(0);
            baseUser.setIsDisabled(flag.byteValue());
            return new ResponseMessage<>(baseUserMapper.updateByPrimaryKeySelective(baseUser));
        }
        return new ResponseMessage<>();
    }

    public String getRandomcode() {
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        str += str.toLowerCase();
        str += "0123456789";
        System.out.println(str);
        char ch = str.charAt(str.length() - 1);
        System.out.println(ch);
        StringBuffer sb = new StringBuffer(6);
        int i1 = 6;
        for (int i = 0; i < i1; i++) {
            char ch2 = str.charAt(new Random().nextInt(str.length()));
            sb.append(ch2);
        }
        return sb.toString();
    }
}