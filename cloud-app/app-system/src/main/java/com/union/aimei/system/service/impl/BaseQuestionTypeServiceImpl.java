package com.union.aimei.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseQuestionType;
import com.union.aimei.system.mapper.BaseQuestionTypeMapper;
import com.union.aimei.system.service.BaseQuestionTypeService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * @author liufeihua
 */
@Service
public class BaseQuestionTypeServiceImpl implements BaseQuestionTypeService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired(required = false)
    private BaseQuestionTypeMapper baseQuestionTypeMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return this.baseQuestionTypeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(BaseQuestionType record) {
        return this.baseQuestionTypeMapper.insertSelective(record);
    }

    @Override
    public BaseQuestionType selectByPrimaryKey(Integer id) {
        return this.baseQuestionTypeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(BaseQuestionType record) {
        return this.baseQuestionTypeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public PageInfo<BaseQuestionType> selectListByConditions(Integer pageNo, Integer pageSize, BaseQuestionType record) {
        PageHelper.startPage(pageNo, pageSize);
        return new PageInfo<>(baseQuestionTypeMapper.selectListByConditions(record));
    }
}