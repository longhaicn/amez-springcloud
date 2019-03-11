package com.union.aimei.common.feign.pc.system.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.system.BaseUserRoleFeign;
import com.union.aimei.common.model.system.BaseUserRole;
import com.union.common.utils.ResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;
/**
 * @author dell
 */
@Component(value = "pc-BaseUserRoleFeign")
public class BaseUserRoleHystrix implements BaseUserRoleFeign {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public int deleteByPrimaryKey(Integer rightId) {
        return 1;
    }

    @Override
    public int insertSelective(BaseUserRole record) {
        return 1;
    }

    @Override
    public BaseUserRole selectByPrimaryKey(Integer rightId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(BaseUserRole record) {
        return 1;
    }

    @Override
    public PageInfo<BaseUserRole> selectListByConditions(Integer pageNo, Integer pageSize, BaseUserRole record) {
        return null;
    }

    @Override
    public ResponseMessage<String> distributionBaseUserRole(Integer userId, String roleIds) {
        return null;
    }

    @Override
    public ResponseMessage<Map<String, Object>> findBaseUserRoles(Integer userId) {
        return null;
    }
}