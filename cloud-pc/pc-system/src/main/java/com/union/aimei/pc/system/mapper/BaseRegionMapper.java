package com.union.aimei.pc.system.mapper;

import com.union.aimei.common.model.system.BaseRegion;
import com.union.aimei.common.model.system.BaseRegionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liufeihua
 */

public interface BaseRegionMapper {
    /**
     * 统计
     * @param example
     * @return
     */
    long countByExample(BaseRegionExample example);
    /**
     * 基本操作
     * @param example
     * @return
     */
    int deleteByExample(BaseRegionExample example);

    /**
     * 根据id删除
     *
     * @param regionId
     * @return
     */
    int deleteByPrimaryKey(Integer regionId);

    /**
     * 添加
     *
     * @param record
     * @return
     */
    int insert(BaseRegion record);

    /**
     * 添加
     *
     * @param record
     * @return
     */
    int insertSelective(BaseRegion record);
    /**
     * 基本操作
     * @param example
     * @return
     */
    List<BaseRegion> selectByExample(BaseRegionExample example);

    /**
     * 查询
     *
     * @param regionId
     * @return
     */
    BaseRegion selectByPrimaryKey(Integer regionId);
    /**
     * 更新
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") BaseRegion record, @Param("example") BaseRegionExample example);
    /**
     * 更新
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") BaseRegion record, @Param("example") BaseRegionExample example);
    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BaseRegion record);
    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(BaseRegion record);
    /**
     * 查看
     * @param offset
     * @param limit
     * @return
     */
    List<BaseRegion> selectByPage(@Param("offset") Long offset, @Param("limit") Long limit);
    /**
     * 查看
     * @param record
     * @return
     */
    List<BaseRegion> selectListByConditions(BaseRegion record);
}