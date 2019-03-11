package com.union.aimei.common.feign.pc.system.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.system.BaseQuestionFeign;
import com.union.aimei.common.model.system.BaseQuestion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;
/**
 * @author dell
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
@Component(value = "pc-BaseQuestionFeign")
public class BaseQuestionHystrix implements BaseQuestionFeign {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 1;
    }

    @Override
    public int insertSelective(BaseQuestion record) {
        return 1;
    }

    @Override
    public BaseQuestion selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(BaseQuestion record) {
        return 1;
    }

    @Override
    public PageInfo<BaseQuestion> selectListByConditions(Integer pageNo, Integer pageSize, BaseQuestion record) {
        return null;
    }

    /**
     * 分页和条件查询常见问题-后台
     *
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    @Override
    public PageInfo<Map<String, Object>> selectListByConditionsForBg(Integer pageNo, Integer pageSize, BaseQuestion record) {
        return null;
    }
}