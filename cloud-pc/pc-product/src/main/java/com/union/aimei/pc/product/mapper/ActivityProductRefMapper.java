package com.union.aimei.pc.product.mapper;

import com.union.aimei.common.model.product.ActivityProductRef;
import com.union.common.utils.base.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 活动-项目-关联
 *
 * @author liurenkai
 * @time 2018/5/14 10:37
 */
public interface ActivityProductRefMapper extends BaseMapper<ActivityProductRef> {

    /**
     * 批量新增活动-项目-关联
     *
     * @param productRefList 活动-项目-关联集合
     * @return
     */
    int addBatch(@Param(value = "productRefList") List<ActivityProductRef> productRefList);

}