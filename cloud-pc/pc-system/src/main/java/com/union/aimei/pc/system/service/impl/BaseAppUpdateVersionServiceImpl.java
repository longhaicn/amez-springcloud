package com.union.aimei.pc.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseAppUpdateVersion;
import com.union.aimei.pc.system.mapper.BaseAppUpdateVersionMapper;
import com.union.aimei.pc.system.service.BaseAppUpdateVersionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author liufeihua
 */
@Service
public class BaseAppUpdateVersionServiceImpl implements BaseAppUpdateVersionService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired(required = false)
    private BaseAppUpdateVersionMapper baseAppUpdateVersionMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return this.baseAppUpdateVersionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(BaseAppUpdateVersion record) {
        record.setCreateTime(new Date());
        record.setUpdateTime(new Date());
        return this.baseAppUpdateVersionMapper.insertSelective(record);
    }

    @Override
    public BaseAppUpdateVersion selectByPrimaryKey(Integer id) {
        return this.baseAppUpdateVersionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(BaseAppUpdateVersion record) {
        record.setUpdateTime(new Date());
        return this.baseAppUpdateVersionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public PageInfo<BaseAppUpdateVersion> selectListByConditions(Integer pageNo, Integer pageSize, BaseAppUpdateVersion record) {
        PageHelper.startPage(pageNo, pageSize);
        return new PageInfo<>(baseAppUpdateVersionMapper.selectListByConditions(record));
    }
}