package com.union.aimei.system.mapper;

import com.union.aimei.common.model.system.BaseAppUpdateVersion;
import com.union.aimei.common.model.system.BaseAppUpdateVersionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @author liufeihua
 */
public interface BaseAppUpdateVersionMapper {
    /**
     * 基本操作
     * @param example
     * @return
     */
    long countByExample(BaseAppUpdateVersionExample example);
    /**
     * 基本操作
     * @param example
     * @return
     */
    int deleteByExample(BaseAppUpdateVersionExample example);
    /**
     * 基本操作
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int insert(BaseAppUpdateVersion record);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int insertSelective(BaseAppUpdateVersion record);
    /**
     * 基本操作
     * @param example
     * @return
     */
    List<BaseAppUpdateVersion> selectByExample(BaseAppUpdateVersionExample example);
    /**
     * 基本操作
     * @param id
     * @return
     */
    BaseAppUpdateVersion selectByPrimaryKey(Integer id);
    /**
     * 更新
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") BaseAppUpdateVersion record, @Param("example") BaseAppUpdateVersionExample example);
    /**
     * 更新
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") BaseAppUpdateVersion record, @Param("example") BaseAppUpdateVersionExample example);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BaseAppUpdateVersion record);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int updateByPrimaryKey(BaseAppUpdateVersion record);
    /**
     * 查看
     * @param offset
     * @param limit
     * @return
     */
    List<BaseAppUpdateVersion> selectByPage(@Param("offset") Long offset, @Param("limit") Long limit);
    /**
     * 基本操作
     * @param record
     * @return
     */
    List<BaseAppUpdateVersion> selectListByConditions(BaseAppUpdateVersion record);
}