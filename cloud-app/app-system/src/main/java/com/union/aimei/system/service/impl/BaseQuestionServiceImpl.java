package com.union.aimei.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseQuestion;
import com.union.aimei.system.mapper.BaseQuestionMapper;
import com.union.aimei.system.service.BaseQuestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return this.baseQuestionMapper.insertSelective(record);
    }

    @Override
    public BaseQuestion selectByPrimaryKey(Integer id) {
        return this.baseQuestionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(BaseQuestion record) {
        return this.baseQuestionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public PageInfo<BaseQuestion> selectListByConditions(Integer pageNo, Integer pageSize, BaseQuestion record) {
        PageHelper.startPage(pageNo, pageSize);
        return new PageInfo<>(baseQuestionMapper.selectListByConditions(record));
    }

    /**
     * 分页和条件查询常见问题-前台
     *
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    @Override
    public PageInfo<Map<String, Object>> selectListByConditionsForBg(Integer pageNo, Integer pageSize, BaseQuestion record) {
        return new PageInfo<>(baseQuestionMapper.selectListByConditionsForBg(record));
    }
}