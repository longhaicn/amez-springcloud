package com.union.aimei.common.feign.pc.system.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.system.BaseSmsHistoryFeign;
import com.union.aimei.common.model.system.BaseSmsHistory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
/**
 * @author dell
 */
@Component(value = "pc-BaseSmsHistoryFeign")
public class BaseSmsHistoryHystrix implements BaseSmsHistoryFeign {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 1;
    }

    @Override
    public int insertSelective(BaseSmsHistory record) {
        return 1;
    }

    @Override
    public BaseSmsHistory selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(BaseSmsHistory record) {
        return 1;
    }

    @Override
    public PageInfo<BaseSmsHistory> selectListByConditions(Integer pageNo, Integer pageSize, BaseSmsHistory record) {
        return null;
    }
}