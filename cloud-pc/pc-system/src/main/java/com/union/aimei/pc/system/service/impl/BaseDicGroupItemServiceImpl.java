package com.union.aimei.pc.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseDicGroupItem;
import com.union.aimei.pc.system.mapper.BaseDicGroupItemMapper;
import com.union.aimei.pc.system.service.BaseDicGroupItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liufeihua
 */
@Service
public class BaseDicGroupItemServiceImpl implements BaseDicGroupItemService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired(required = false)
    private BaseDicGroupItemMapper baseDicGroupItemMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return this.baseDicGroupItemMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(BaseDicGroupItem record) {
        return this.baseDicGroupItemMapper.insertSelective(record);
    }

    @Override
    public BaseDicGroupItem selectByPrimaryKey(Integer id) {
        return this.baseDicGroupItemMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(BaseDicGroupItem record) {
        return this.baseDicGroupItemMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public PageInfo<BaseDicGroupItem> selectListByConditions(Integer pageNo, Integer pageSize, BaseDicGroupItem record) {
        PageHelper.startPage(pageNo, pageSize);
        return new PageInfo<>(baseDicGroupItemMapper.selectListByConditions(record));
    }
}