package com.union.aimei.pc.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseBtnMenus;
import com.union.aimei.pc.system.mapper.BaseBtnMenusMapper;
import com.union.aimei.pc.system.service.BaseBtnMenusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liufeihua
 */
@Service
public class BaseBtnMenusServiceImpl implements BaseBtnMenusService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired(required = false)
    private BaseBtnMenusMapper baseBtnMenusMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return this.baseBtnMenusMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(BaseBtnMenus record) {
        return this.baseBtnMenusMapper.insertSelective(record);
    }

    @Override
    public BaseBtnMenus selectByPrimaryKey(Integer id) {
        return this.baseBtnMenusMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(BaseBtnMenus record) {
        return this.baseBtnMenusMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public PageInfo<BaseBtnMenus> selectListByConditions(Integer pageNo, Integer pageSize, BaseBtnMenus record) {
        PageHelper.startPage(pageNo, pageSize);
        return new PageInfo<>(baseBtnMenusMapper.selectListByConditions(record));
    }
}