package com.union.aimei.common.feign.pc.system.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.system.BaseUserFeign;
import com.union.aimei.common.model.system.BaseUser;
import com.union.aimei.common.vo.system.BaseUserVo;
import com.union.aimei.common.vo.system.UserVo;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;
/**
 * @author dell
 */
@Component(value = "pc-BaseUserFeign")
public class BaseUserHystrix implements BaseUserFeign {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public int deleteByPrimaryKey(Integer userId) {
        return 1;
    }

    @Override
    public ResponseMessage<BaseUser> insertSelective(BaseUser record) {
        return null;
    }

    @Override
    public BaseUser selectByPrimaryKey(Integer userId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(BaseUser record) {
        return 1;
    }

    @Override
    public PageInfo<BaseUser> selectListByConditions(Integer pageNo, Integer pageSize, BaseUser record) {
        return null;
    }

    /**
     * describe: 用户登录
     * create_by: liufeihua in 2017/12/1 11:10
     *
     * @param userVo
     */
    @Override
    public ResponseMessage<Map<String, Object>> userLogin(UserVo userVo) {
        return HystrixResponse.invokeFail();
    }

    /**
     * 添加老板,店长,者员工
     *
     * @param record
     * @return
     */
    @Override
    public ResponseMessage<BaseUser> insertBbossAndShopkeeperAndMember(BaseUserVo record) {
        return null;
    }

    /**
     * 关闭店铺的时候禁用用户登录
     *
     * @param phone
     * @param flag
     * @return
     */
    @Override
    public ResponseMessage<Integer> updateUserSatuts(String phone, Integer flag) {
        return null;
    }
}