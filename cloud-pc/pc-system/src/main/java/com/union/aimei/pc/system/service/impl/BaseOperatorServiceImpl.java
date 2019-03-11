package com.union.aimei.pc.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseOperator;
import com.union.aimei.pc.system.mapper.BaseOperatorMapper;
import com.union.aimei.pc.system.service.BaseOperatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liufeihua
 */
@Service
public class BaseOperatorServiceImpl implements BaseOperatorService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired(required = false)
    private BaseOperatorMapper baseOperatorMapper;

    @Override
    public int deleteByPrimaryKey(Integer operId) {
        return this.baseOperatorMapper.deleteByPrimaryKey(operId);
    }

    @Override
    public int insertSelective(BaseOperator record) {
        return this.baseOperatorMapper.insertSelective(record);
    }

    @Override
    public BaseOperator selectByPrimaryKey(Integer operId) {
        return this.baseOperatorMapper.selectByPrimaryKey(operId);
    }

    @Override
    public int updateByPrimaryKeySelective(BaseOperator record) {
        return this.baseOperatorMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public PageInfo<BaseOperator> selectListByConditions(Integer pageNo, Integer pageSize, BaseOperator record) {
        PageHelper.startPage(pageNo, pageSize);
        return new PageInfo<>(baseOperatorMapper.selectListByConditions(record));
    }
}