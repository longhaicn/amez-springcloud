package com.union.aimei.pc.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseQuestion;
import com.union.aimei.pc.system.mapper.BaseQuestionMapper;
import com.union.aimei.pc.system.service.BaseQuestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

/**
 * @author liufeihua
 */
@Service
public class BaseQuestionServiceImpl implements BaseQuestionService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired(required = false)
    private BaseQuestionMapper baseQuestionMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return this.baseQuestionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(BaseQuestion record) {
        record.setCreateTime(new Date());
        return this.baseQuestionMapper.insertSelective(record);
    }

    @Override
    public BaseQuestion selectByPrimaryKey(Integer id) {
        return this.baseQuestionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(BaseQuestion record) {
        record.setUpdateTime(new Date());
        return this.baseQuestionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public PageInfo<BaseQuestion> selectListByConditions(Integer pageNo, Integer pageSize, BaseQuestion record) {
        PageHelper.startPage(pageNo, pageSize);
        return new PageInfo<>(baseQuestionMapper.selectListByConditions(record));
    }

    @Override
    public PageInfo<Map<String, Object>> selectListByConditionsForBg(Integer pageNo, Integer pageSize, BaseQuestion record) {
        PageHelper.startPage(pageNo, pageSize);
        return new PageInfo<>(baseQuestionMapper.selectListByConditionsForBg(record));
    }
}