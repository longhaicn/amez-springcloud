package com.union.aimei.learn.mapper;

import com.union.aimei.common.model.learn.CourseBeauticianRef;
import com.union.aimei.common.vo.learn.pc.BeauticianParamVo;
import com.union.aimei.common.vo.learn.pc.UpdateBeauticianVo;
import com.union.common.utils.base.BaseMapper;

import java.util.List;

/**
 * 课程-美容师-关联表
 * @author caizhaoming
 * @create 2018-05-10 10:49
 **/
public interface CourseBeauticianRefMapper extends BaseMapper<CourseBeauticianRef> {

    /**
     * 根据条件筛选课程-美容师-关联表
     *
     * @param beauticianParamVo
     * @return
     */
    List<CourseBeauticianRef> selectPageListByConditions(BeauticianParamVo beauticianParamVo);

    /**
     * 批量更新课程-美容师-关联数据
     *
     * @param updateBeauticianVo
     * @return
     */
    int updateBatch(UpdateBeauticianVo updateBeauticianVo);

}