package com.union.aimei.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseSmsHistory;
import com.union.aimei.system.mapper.BaseSmsHistoryMapper;
import com.union.aimei.system.service.BaseSmsHistoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * @author liufeihua
 */
@Service
public class BaseSmsHistoryServiceImpl implements BaseSmsHistoryService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired(required = false)
    private BaseSmsHistoryMapper baseSmsHistoryMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return this.baseSmsHistoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(BaseSmsHistory record) {
        return this.baseSmsHistoryMapper.insertSelective(record);
    }

    @Override
    public BaseSmsHistory selectByPrimaryKey(Integer id) {
        return this.baseSmsHistoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(BaseSmsHistory record) {
        return this.baseSmsHistoryMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public PageInfo<BaseSmsHistory> selectListByConditions(Integer pageNo, Integer pageSize, BaseSmsHistory record) {
        PageHelper.startPage(pageNo, pageSize);
        return new PageInfo<>(baseSmsHistoryMapper.selectListByConditions(record));
    }
}