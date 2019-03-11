package com.union.aimei.common.feign.app.system.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.system.BaseOperatorFeign;
import com.union.aimei.common.model.system.BaseOperator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
/**
 * @author dell
 */
@Component(value = "app-BaseOperatorFeign")
public class BaseOperatorHystrix implements BaseOperatorFeign {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public int deleteByPrimaryKey(Integer operId) {
        return 1;
    }

    @Override
    public int insertSelective(BaseOperator record) {
        return 1;
    }

    @Override
    public BaseOperator selectByPrimaryKey(Integer operId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(BaseOperator record) {
        return 1;
    }

    @Override
    public PageInfo<BaseOperator> selectListByConditions(Integer pageNo, Integer pageSize, BaseOperator record) {
        return null;
    }
}