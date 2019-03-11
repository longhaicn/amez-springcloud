package com.union.aimei.pc.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseDicGroup;
import com.union.aimei.pc.system.mapper.BaseDicGroupMapper;
import com.union.aimei.pc.system.service.BaseDicGroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liufeihua
 */
@Service
public class BaseDicGroupServiceImpl implements BaseDicGroupService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired(required = false)
    private BaseDicGroupMapper baseDicGroupMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return this.baseDicGroupMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(BaseDicGroup record) {
        return this.baseDicGroupMapper.insertSelective(record);
    }

    @Override
    public BaseDicGroup selectByPrimaryKey(Integer id) {
        return this.baseDicGroupMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(BaseDicGroup record) {
        return this.baseDicGroupMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public PageInfo<BaseDicGroup> selectListByConditions(Integer pageNo, Integer pageSize, BaseDicGroup record) {
        PageHelper.startPage(pageNo, pageSize);
        return new PageInfo<>(baseDicGroupMapper.selectListByConditions(record));
    }
}