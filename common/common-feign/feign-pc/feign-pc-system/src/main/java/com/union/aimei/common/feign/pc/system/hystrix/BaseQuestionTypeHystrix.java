package com.union.aimei.common.feign.pc.system.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.system.BaseQuestionTypeFeign;
import com.union.aimei.common.model.system.BaseQuestionType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
/**
 * @author dell
 */
@Component(value = "pc-BaseQuestionTypeFeign")
public class BaseQuestionTypeHystrix implements BaseQuestionTypeFeign {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 1;
    }

    @Override
    public int insertSelective(BaseQuestionType record) {
        return 1;
    }

    @Override
    public BaseQuestionType selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(BaseQuestionType record) {
        return 1;
    }

    @Override
    public PageInfo<BaseQuestionType> selectListByConditions(Integer pageNo, Integer pageSize, BaseQuestionType record) {
        return null;
    }
}