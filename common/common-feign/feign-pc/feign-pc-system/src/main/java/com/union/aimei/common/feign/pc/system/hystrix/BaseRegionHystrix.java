package com.union.aimei.common.feign.pc.system.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.system.BaseRegionFeign;
import com.union.aimei.common.model.system.BaseRegion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
/**
 * @author dell
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
@Component(value = "pc-BaseRegionFeign")
public class BaseRegionHystrix implements BaseRegionFeign {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public int deleteByPrimaryKey(Integer regionId) {
        return 1;
    }

    @Override
    public int insertSelective(BaseRegion record) {
        return 1;
    }

    @Override
    public BaseRegion selectByPrimaryKey(Integer regionId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(BaseRegion record) {
        return 1;
    }

    @Override
    public PageInfo<BaseRegion> selectListByConditions(Integer pageNo, Integer pageSize, BaseRegion record) {
        return null;
    }
}