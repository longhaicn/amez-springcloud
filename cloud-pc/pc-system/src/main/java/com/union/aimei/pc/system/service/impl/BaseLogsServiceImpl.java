package com.union.aimei.pc.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseLogs;
import com.union.aimei.pc.system.mapper.BaseLogsMapper;
import com.union.aimei.pc.system.service.BaseLogsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liufeihua
 */
@Service
public class BaseLogsServiceImpl implements BaseLogsService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired(required = false)
    private BaseLogsMapper baseLogsMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return this.baseLogsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(BaseLogs record) {
        return this.baseLogsMapper.insertSelective(record);
    }

    @Override
    public BaseLogs selectByPrimaryKey(Integer id) {
        return this.baseLogsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(BaseLogs record) {
        return this.baseLogsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public PageInfo<BaseLogs> selectListByConditions(Integer pageNo, Integer pageSize, BaseLogs record) {
        PageHelper.startPage(pageNo, pageSize);
        return new PageInfo<>(baseLogsMapper.selectListByConditions(record));
    }
}