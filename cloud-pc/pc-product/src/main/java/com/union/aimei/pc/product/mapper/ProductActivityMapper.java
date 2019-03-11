package com.union.aimei.pc.product.mapper;

import com.union.aimei.common.model.product.ProductActivity;
import com.union.common.utils.base.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 项目活动
 *
 * @author liurenkai
 * @time 2018/5/14 10:37
 */
public interface ProductActivityMapper extends BaseMapper<ProductActivity> {

    /**
     * 根据城市ID取消精选项目活动
     *
     * @param cityId 城市ID
     * @return
     */
    int cancelSelectByCityId(@Param(value = "cityId") int cityId);

    /**
     * 批量精选项目活动
     *
     * @param idList 项目活动ID集合
     * @return
     */
    int selectBatch(@Param(value = "idList") List<Integer> idList);

}