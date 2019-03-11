package com.union.aimei.pc.system.mapper;

import com.union.aimei.common.model.system.BaseHomeFloor;
import com.union.aimei.common.vo.system.pc.BaseHomeFloorPageVo;
import com.union.common.utils.base.BaseMapper;

import java.util.List;

/**
 * 楼层管理表
 *
 * @author caizhaoming
 * @create 2018-05-23 10:49
 **/
public interface BaseHomeFloorMapper extends BaseMapper<BaseHomeFloor> {


    /**
     * 根据条件删除数据
     *
     * @param baseHomeFloor
     * @return
     */
    int deleteByFront(BaseHomeFloor baseHomeFloor);

    /**
     * 批量添加数据
     *
     * @param list
     * @return
     */
    int addBatch(List<BaseHomeFloor> list);

    /**
     * 根据条件查询数据，返回 装修模版的楼层数据vo
     *
     * @param baseHomeFloor
     * @return
     */
    List<BaseHomeFloorPageVo> selectVoListByConditions(BaseHomeFloor baseHomeFloor);
}