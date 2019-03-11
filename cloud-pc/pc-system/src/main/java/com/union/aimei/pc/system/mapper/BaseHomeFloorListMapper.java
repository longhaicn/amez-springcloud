package com.union.aimei.pc.system.mapper;

import com.union.aimei.common.model.system.BaseHomeFloorList;
import com.union.aimei.common.vo.system.pc.BaseHomeFloorListVo;
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
     * @param baseHomeFloorList
     * @return
     */
    List<BaseHomeFloorListVo> findByVoPageForFront(BaseHomeFloorList baseHomeFloorList);

    /**
     * 根据floorId更新数据
     *
     * @param baseHomeFloorList
     * @return
     */
    int updateByFloorId(BaseHomeFloorList baseHomeFloorList);

    /**
     * 批量添加数据
     *
     * @param list
     * @return
     */
    int addBatch(List<BaseHomeFloorList> list);

    /**
     * 根据条件查询商品的id集合
     *
     * @param baseHomeFloorListVo
     * @return
     */
    List<Integer> findProductIdListByFront(BaseHomeFloorListVo baseHomeFloorListVo);

    /**
     * 根据vo条件筛选查出vo数据
     *
     * @param baseHomeFloorListVo
     * @return
     */
    List<BaseHomeFloorListVo> findByVoPageForBaseHomeFloorListVo(BaseHomeFloorListVo baseHomeFloorListVo);

}