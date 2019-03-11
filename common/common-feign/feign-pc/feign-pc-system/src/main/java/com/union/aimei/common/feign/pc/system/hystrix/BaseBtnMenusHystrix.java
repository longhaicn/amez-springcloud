package com.union.aimei.common.feign.pc.system.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.system.BaseBtnMenusFeign;
import com.union.aimei.common.model.system.BaseBtnMenus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
/**
 * @author dell
 */
@Component(value = "pc-BaseBtnMenusFeign")
public class BaseBtnMenusHystrix implements BaseBtnMenusFeign {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 1;
    }

    @Override
    public int insertSelective(BaseBtnMenus record) {
        return 1;
    }

    @Override
    public BaseBtnMenus selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(BaseBtnMenus record) {
        return 1;
    }

    @Override
    public PageInfo<BaseBtnMenus> selectListByConditions(Integer pageNo, Integer pageSize, BaseBtnMenus record) {
        return null;
    }
}