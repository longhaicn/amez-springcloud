package com.union.aimei.system.mapper;

import com.union.aimei.common.model.system.BaseHomepageGuidePage;
import com.union.aimei.common.model.system.BaseHomepageGuidePageExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @author liufeihua
 */
public interface BaseHomepageGuidePageMapper {
    /**
     * 基本操作
     * @param example
     * @return
     */
    long countByExample(BaseHomepageGuidePageExample example);
    /**
     * 基本操作
     * @param example
     * @return
     */
    int deleteByExample(BaseHomepageGuidePageExample example);
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
    int insert(BaseHomepageGuidePage record);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int insertSelective(BaseHomepageGuidePage record);
    /**
     * 基本操作
     * @param example
     * @return
     */
    List<BaseHomepageGuidePage> selectByExample(BaseHomepageGuidePageExample example);
    /**
     * 基本操作
     * @param id
     * @return
     */
    BaseHomepageGuidePage selectByPrimaryKey(Integer id);
    /**
     * 更新
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") BaseHomepageGuidePage record, @Param("example") BaseHomepageGuidePageExample example);
    /**
     * 更新
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") BaseHomepageGuidePage record, @Param("example") BaseHomepageGuidePageExample example);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BaseHomepageGuidePage record);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int updateByPrimaryKey(BaseHomepageGuidePage record);
    /**
     * 查看
     * @param offset
     * @param limit
     * @return
     */
    List<BaseHomepageGuidePage> selectByPage(@Param("offset") Long offset, @Param("limit") Long limit);
    /**
     * 基本操作
     * @param record
     * @return
     */
    List<BaseHomepageGuidePage> selectListByConditions(BaseHomepageGuidePage record);
}