package com.union.aimei.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseUserRole;
import com.union.aimei.system.mapper.BaseUserRoleMapper;
import com.union.aimei.system.service.BaseUserRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * @author liufeihua
 */
@Service
public class BaseUserRoleServiceImpl implements BaseUserRoleService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired(required = false)
    private BaseUserRoleMapper baseUserRoleMapper;

    @Override
    public int deleteByPrimaryKey(Integer rightId) {
        return this.baseUserRoleMapper.deleteByPrimaryKey(rightId);
    }

    @Override
    public int insertSelective(BaseUserRole record) {
        return this.baseUserRoleMapper.insertSelective(record);
    }

    @Override
    public BaseUserRole selectByPrimaryKey(Integer rightId) {
        return this.baseUserRoleMapper.selectByPrimaryKey(rightId);
    }

    @Override
    public int updateByPrimaryKeySelective(BaseUserRole record) {
        return this.baseUserRoleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public PageInfo<BaseUserRole> selectListByConditions(Integer pageNo, Integer pageSize, BaseUserRole record) {
        PageHelper.startPage(pageNo, pageSize);
        return new PageInfo<>(baseUserRoleMapper.selectListByConditions(record));
    }
}