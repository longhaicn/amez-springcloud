package com.union.aimei.common.feign.pc.system.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.system.BaseRoleFeign;
import com.union.aimei.common.model.system.BaseRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
/**
 * @author dell
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
@Component(value = "pc-BaseRoleFeign")
public class BaseRoleHystrix implements BaseRoleFeign {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public int deleteByPrimaryKey(Integer roleId) {
        return 1;
    }

    @Override
    public int insertSelective(BaseRole record) {
        return 1;
    }

    @Override
    public BaseRole selectByPrimaryKey(Integer roleId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(BaseRole record) {
        return 1;
    }

    @Override
    public PageInfo<BaseRole> selectListByConditions(Integer pageNo, Integer pageSize, BaseRole record) {
        return null;
    }
}