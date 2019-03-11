package com.union.aimei.common.feign.app.system.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.system.BaseUserRoleFeign;
import com.union.aimei.common.model.system.BaseUserRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
/**
 * @author dell
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
@Component(value = "app-BaseUserRoleFeign")
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
}