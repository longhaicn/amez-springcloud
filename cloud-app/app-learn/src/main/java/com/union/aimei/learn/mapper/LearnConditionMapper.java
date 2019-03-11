package com.union.aimei.learn.mapper;

import com.union.aimei.common.model.learn.LearnCondition;
import com.union.aimei.common.vo.learn.app.LearnAuthorityVo;
import com.union.common.utils.base.BaseMapper;

import java.util.List;

/**
 * 门槛查询
 * @author caizhaoming
 * @create 2018-05-10 10:49
 **/
public interface LearnConditionMapper extends BaseMapper<LearnCondition> {

    /**
     * 查询美容师允许报名的课程
     * @param learnAuthorityVo
     * @return
     */
    List<Integer> selectLearnCourseIdAuthority(LearnAuthorityVo learnAuthorityVo);

}