package com.union.aimei.system.mapper;

import com.union.aimei.common.model.system.BaseUser;
import com.union.aimei.common.model.system.BaseUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @author liufeihua
 */
public interface BaseUserMapper {
    /**
     * 基本操作
     * @param example
     * @return
     */
    long countByExample(BaseUserExample example);
    /**
     * 基本操作
     * @param example
     * @return
     */
    int deleteByExample(BaseUserExample example);
    /**
     * 基本操作
     * @param userId
     * @return
     */
    int deleteByPrimaryKey(Integer userId);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int insert(BaseUser record);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int insertSelective(BaseUser record);
    /**
     * 基本操作
     * @param example
     * @return
     */
    List<BaseUser> selectByExample(BaseUserExample example);
    /**
     * 基本操作
     * @param userId
     * @return
     */
    BaseUser selectByPrimaryKey(Integer userId);
    /**
     * 更新
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") BaseUser record, @Param("example") BaseUserExample example);
    /**
     * 更新
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") BaseUser record, @Param("example") BaseUserExample example);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BaseUser record);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int updateByPrimaryKey(BaseUser record);
    /**
     * 查看
     * @param offset
     * @param limit
     * @return
     */
    List<BaseUser> selectByPage(@Param("offset") Long offset, @Param("limit") Long limit);
    /**
     * 基本操作
     * @param record
     * @return
     */
    List<BaseUser> selectListByConditions(BaseUser record);
}