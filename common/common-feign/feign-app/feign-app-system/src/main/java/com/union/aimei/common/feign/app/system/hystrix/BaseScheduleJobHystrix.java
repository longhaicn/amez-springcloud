package com.union.aimei.common.feign.app.system.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.system.BaseScheduleJobFeign;
import com.union.aimei.common.model.system.BaseScheduleJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
/**
 * @author dell
 */
@Component(value = "app-BaseScheduleJobFeign")
public class BaseScheduleJobHystrix implements BaseScheduleJobFeign {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 1;
    }

    @Override
    public int insertSelective(BaseScheduleJob record) {
        return 1;
    }

    @Override
    public BaseScheduleJob selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(BaseScheduleJob record) {
        return 1;
    }

    @Override
    public PageInfo<BaseScheduleJob> selectListByConditions(Integer pageNo, Integer pageSize, BaseScheduleJob record) {
        return null;
    }
}