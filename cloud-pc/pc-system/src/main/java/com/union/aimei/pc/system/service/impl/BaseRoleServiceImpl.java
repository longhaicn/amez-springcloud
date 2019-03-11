package com.union.aimei.pc.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseRole;
import com.union.aimei.pc.system.mapper.BaseRoleMapper;
import com.union.aimei.pc.system.service.BaseRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liufeihua
 */
@Service
public class BaseRoleServiceImpl implements BaseRoleService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired(required = false)
    private BaseRoleMapper baseRoleMapper;

    @Override
    public int deleteByPrimaryKey(Integer roleId) {
        return this.baseRoleMapper.deleteByPrimaryKey(roleId);
    }

    @Override
    public int insertSelective(BaseRole record) {
        return this.baseRoleMapper.insertSelective(record);
    }

    @Override
    public BaseRole selectByPrimaryKey(Integer roleId) {
        return this.baseRoleMapper.selectByPrimaryKey(roleId);
    }

    @Override
    public int updateByPrimaryKeySelective(BaseRole record) {
        return this.baseRoleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public PageInfo<BaseRole> selectListByConditions(Integer pageNo, Integer pageSize, BaseRole record) {
        PageHelper.startPage(pageNo, pageSize);
        return new PageInfo<>(baseRoleMapper.selectListByConditions(record));
    }
}