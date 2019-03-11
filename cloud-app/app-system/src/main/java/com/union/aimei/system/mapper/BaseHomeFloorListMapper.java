package com.union.aimei.system.mapper;


import com.union.aimei.common.model.system.BaseHomeFloorList;
import com.union.aimei.common.vo.system.app.BaseHomeFloorListVo;
import com.union.common.utils.base.BaseMapper;

import java.util.List;

/**
 * 楼层列表数据表
 *
 * @author caizhaoming
 * @create 2018-05-23 10:49
 **/
public interface BaseHomeFloorListMapper extends BaseMapper<BaseHomeFloorList> {
    /**
     * 获取 BaseHomeFloorListVo 分页列表数据
     *
     * @param baseHomeFloorListVo
     * @return
     */
    List<BaseHomeFloorListVo> findByVoPageForFront(BaseHomeFloorListVo baseHomeFloorListVo);

    /**
     * 根据条件查询商品的id集合
     *
     * @param baseHomeFloorListVo
     * @return
     */
    List<Integer> findProductIdListByFront(BaseHomeFloorListVo baseHomeFloorListVo);
}