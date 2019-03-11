package com.union.aimei.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseRoleResources;
import com.union.aimei.system.mapper.BaseRoleResourcesMapper;
import com.union.aimei.system.service.BaseRoleResourcesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * @author liufeihua
 */
@Service
public class BaseRoleResourcesServiceImpl implements BaseRoleResourcesService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired(required = false)
    private BaseRoleResourcesMapper baseRoleResourcesMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return this.baseRoleResourcesMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(BaseRoleResources record) {
        return this.baseRoleResourcesMapper.insertSelective(record);
    }

    @Override
    public BaseRoleResources selectByPrimaryKey(Integer id) {
        return this.baseRoleResourcesMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(BaseRoleResources record) {
        return this.baseRoleResourcesMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public PageInfo<BaseRoleResources> selectListByConditions(Integer pageNo, Integer pageSize, BaseRoleResources record) {
        PageHelper.startPage(pageNo, pageSize);
        return new PageInfo<>(baseRoleResourcesMapper.selectListByConditions(record));
    }
}