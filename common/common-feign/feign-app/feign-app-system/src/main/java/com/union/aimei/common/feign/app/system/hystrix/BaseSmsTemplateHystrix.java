package com.union.aimei.common.feign.app.system.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.system.BaseSmsTemplateFeign;
import com.union.aimei.common.model.system.BaseSmsTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
/**
 * @author dell
 */
@Component(value = "app-BaseSmsTemplateFeign")
public class BaseSmsTemplateHystrix implements BaseSmsTemplateFeign {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 1;
    }

    @Override
    public int insertSelective(BaseSmsTemplate record) {
        return 1;
    }

    @Override
    public BaseSmsTemplate selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(BaseSmsTemplate record) {
        return 1;
    }

    @Override
    public PageInfo<BaseSmsTemplate> selectListByConditions(Integer pageNo, Integer pageSize, BaseSmsTemplate record) {
        return null;
    }
}