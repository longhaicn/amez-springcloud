package com.union.aimei.common.feign.app.system.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.system.BaseLogsFeign;
import com.union.aimei.common.model.system.BaseLogs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
/**
 * @author dell
 */
@Component(value = "app-BaseLogsFeign")
public class BaseLogsHystrix implements BaseLogsFeign {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 1;
    }

    @Override
    public int insertSelective(BaseLogs record) {
        return 1;
    }

    @Override
    public BaseLogs selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(BaseLogs record) {
        return 1;
    }

    @Override
    public PageInfo<BaseLogs> selectListByConditions(Integer pageNo, Integer pageSize, BaseLogs record) {
        return null;
    }
}