package com.union.aimei.system.service.impl;

import com.aliyuncs.exceptions.ClientException;
import com.codingapi.tx.annotation.TxTransaction;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.union.aimei.common.model.system.BaseUserExample;
import com.union.aimei.system.config.Constant;
import com.union.aimei.common.model.system.BaseUser;
import com.union.aimei.common.model.system.BaseUserRole;
import com.union.aimei.system.mapper.BaseUserMapper;
import com.union.aimei.system.service.BaseUserRoleService;
import com.union.aimei.system.service.BaseUserService;
import com.union.aimei.system.service.SmsService;
import com.union.aimei.common.vo.system.BaseUserVo;
import com.union.aimei.common.vo.system.SmsMessageVo;
import com.union.common.utils.AssertUtil;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.encryption.Md5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
/**
 * @author liufeihua
 */
@Service
public class BaseUserServiceImpl implements BaseUserService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    SmsService smsService;
    @Autowired(required = false)
    private BaseUserMapper baseUserMapper;
    @Autowired
    private BaseUserRoleService userRoleService;

    @Override
    public int deleteByPrimaryKey(Integer userId) {
        return this.baseUserMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public ResponseMessage<BaseUser> insertSelective(BaseUser record) {
        logger.debug("用户名-----------------------" + record.getLoginName());
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
        record.setUpdateTime(new Date());
        return this.baseUserMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public PageInfo<BaseUser> selectListByConditions(Integer pageNo, Integer pageSize, BaseUser record) {
        PageHelper.startPage(pageNo, pageSize);
        return new PageInfo<>(baseUserMapper.selectListByConditions(record));
    }

    /**
     * 添加老板,店长,者员工
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
        //存在手机号码就返回数据
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

            //3.添加用户角色关联
            insertUserRole(record.getUserType(), baseUser.getUserId());

            //设置返回对象（有可能为null）
            baseUserResponseMessage.setData(baseUser);
        }

        return baseUserResponseMessage;
    }

    /**
     * /处理用户存在的情况
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
     * /添加用户
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
                .password(Md5Util.md5(password+Constant.MD5_CNBBX))
                .isDisabled((byte) 0)
                .createTime(new Date())
                .build();
        //1.添加数据
        this.baseUserMapper.insertSelective(baseUser);
        return baseUser;
    }

    /**
     * /发送短信消息
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
     * /添加用户角色关联
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
