package com.union.aimei.pc.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseRegion;
import com.union.aimei.pc.system.mapper.BaseRegionMapper;
import com.union.aimei.pc.system.service.BaseRegionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liufeihua
 */
@Service
public class BaseRegionServiceImpl implements BaseRegionService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired(required = false)
    private BaseRegionMapper baseRegionMapper;

    @Override
    public int deleteByPrimaryKey(Integer regionId) {
        return this.baseRegionMapper.deleteByPrimaryKey(regionId);
    }

    @Override
    public int insertSelective(BaseRegion record) {
        return this.baseRegionMapper.insertSelective(record);
    }

    @Override
    public BaseRegion selectByPrimaryKey(Integer regionId) {
        return this.baseRegionMapper.selectByPrimaryKey(regionId);
    }

    @Override
    public int updateByPrimaryKeySelective(BaseRegion record) {
        return this.baseRegionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public PageInfo<BaseRegion> selectListByConditions(Integer pageNo, Integer pageSize, BaseRegion record) {
        PageHelper.startPage(pageNo, pageSize);
        return new PageInfo<>(baseRegionMapper.selectListByConditions(record));
    }
}