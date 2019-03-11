package com.union.aimei.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseMenu;
import com.union.aimei.system.mapper.BaseMenuMapper;
import com.union.aimei.system.service.BaseMenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * @author liufeihua
 */
@Service
public class BaseMenuServiceImpl implements BaseMenuService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired(required = false)
    private BaseMenuMapper baseMenuMapper;

    @Override
    public int deleteByPrimaryKey(Integer menuId) {
        return this.baseMenuMapper.deleteByPrimaryKey(menuId);
    }

    @Override
    public int insertSelective(BaseMenu record) {
        return this.baseMenuMapper.insertSelective(record);
    }

    @Override
    public BaseMenu selectByPrimaryKey(Integer menuId) {
        return this.baseMenuMapper.selectByPrimaryKey(menuId);
    }

    @Override
    public int updateByPrimaryKeySelective(BaseMenu record) {
        return this.baseMenuMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public PageInfo<BaseMenu> selectListByConditions(Integer pageNo, Integer pageSize, BaseMenu record) {
        PageHelper.startPage(pageNo, pageSize);
        return new PageInfo<>(baseMenuMapper.selectListByConditions(record));
    }
}