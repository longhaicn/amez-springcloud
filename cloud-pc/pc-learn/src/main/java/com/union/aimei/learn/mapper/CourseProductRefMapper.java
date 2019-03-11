package com.union.aimei.learn.mapper;

import com.union.aimei.common.model.learn.CourseProductRef;
import com.union.common.utils.base.BaseMapper;

import java.util.List;

/**
 * 课程所指定的商品
 * @author caizhaoming
 * @create 2018-05-10 10:49
 **/
public interface CourseProductRefMapper extends BaseMapper<CourseProductRef> {

    /**
     * 批量添加课程所指定的商品
     *
     * @param list
     * @return
     */
    int addBatch(List<CourseProductRef> list);

    /**
     * 批量根据id删除数据
     *
     * @param list
     * @return
     */
    int deleteByPrimaryKeyList(List<Integer> list);

}