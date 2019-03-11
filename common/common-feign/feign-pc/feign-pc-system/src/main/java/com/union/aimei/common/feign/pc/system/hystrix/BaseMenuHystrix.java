package com.union.aimei.common.feign.pc.system.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.system.BaseMenuFeign;
import com.union.aimei.common.model.system.BaseMenu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
/**
 * @author dell
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
@Component(value = "pc-BaseMenuFeign")
public class BaseMenuHystrix implements BaseMenuFeign {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public int deleteByPrimaryKey(Integer menuId) {
        return 1;
    }

    @Override
    public int insertSelective(BaseMenu record) {
        return 1;
    }

    @Override
    public BaseMenu selectByPrimaryKey(Integer menuId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(BaseMenu record) {
        return 1;
    }

    @Override
    public PageInfo<BaseMenu> selectListByConditions(Integer pageNo, Integer pageSize, BaseMenu record) {
        return null;
    }
}