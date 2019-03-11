package com.union.aimei.system.mapper;

import com.union.aimei.common.model.system.BaseRegion;
import com.union.aimei.common.model.system.BaseRegionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
/**
 * @author liufeihua
 */
public interface BaseRegionMapper {
    /**
     * 基本操作
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
     * 基本操作
     * @param regionId
     * @return
     */
    int deleteByPrimaryKey(Integer regionId);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int insert(BaseRegion record);
    /**
     * 基本操作
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
     * 基本操作
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
     * 基本操作
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BaseRegion record);
    /**
     * 基本操作
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
     * 基本操作
     * @param record
     * @return
     */
    List<BaseRegion> selectListByConditions(BaseRegion record);

    /**
     * 根据城市ID查询区列表
     *
     * @param condMap 条件
     * @return
     */
    List<BaseRegion> listAreaByCityId(Map<String, Object> condMap);

}