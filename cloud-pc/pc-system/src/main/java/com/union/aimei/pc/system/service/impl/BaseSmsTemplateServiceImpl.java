package com.union.aimei.pc.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseSmsTemplate;
import com.union.aimei.pc.system.mapper.BaseSmsTemplateMapper;
import com.union.aimei.pc.system.service.BaseSmsTemplateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author liufeihua
 */
@Service
public class BaseSmsTemplateServiceImpl implements BaseSmsTemplateService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired(required = false)
    private BaseSmsTemplateMapper baseSmsTemplateMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return this.baseSmsTemplateMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(BaseSmsTemplate record) {
        record.setCreateTime(new Date());
        return this.baseSmsTemplateMapper.insertSelective(record);
    }

    @Override
    public BaseSmsTemplate selectByPrimaryKey(Integer id) {
        return this.baseSmsTemplateMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(BaseSmsTemplate record) {
        record.setUpdateTime(new Date());
        return this.baseSmsTemplateMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public PageInfo<BaseSmsTemplate> selectListByConditions(Integer pageNo, Integer pageSize, BaseSmsTemplate record) {
        PageHelper.startPage(pageNo, pageSize);
        return new PageInfo<>(baseSmsTemplateMapper.selectListByConditions(record));
    }
}