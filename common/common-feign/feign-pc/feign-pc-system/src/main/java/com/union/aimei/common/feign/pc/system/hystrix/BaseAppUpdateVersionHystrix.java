package com.union.aimei.common.feign.pc.system.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.system.BaseAppUpdateVersionFeign;
import com.union.aimei.common.model.system.BaseAppUpdateVersion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
/**
 * @author dell
 */
@Component(value = "pc-BaseAppUpdateVersionFeign")
public class BaseAppUpdateVersionHystrix implements BaseAppUpdateVersionFeign {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 1;
    }

    @Override
    public int insertSelective(BaseAppUpdateVersion record) {
        return 1;
    }

    @Override
    public BaseAppUpdateVersion selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(BaseAppUpdateVersion record) {
        return 1;
    }

    @Override
    public PageInfo<BaseAppUpdateVersion> selectListByConditions(Integer pageNo, Integer pageSize, BaseAppUpdateVersion record) {
        return null;
    }
}