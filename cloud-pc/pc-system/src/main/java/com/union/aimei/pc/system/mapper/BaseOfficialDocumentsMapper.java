package com.union.aimei.pc.system.mapper;

import com.union.aimei.common.model.system.BaseOfficialDocuments;
import com.union.aimei.common.model.system.BaseOfficialDocumentsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liufeihua
 */

public interface BaseOfficialDocumentsMapper {
    /**
     * 统计
     * @param example
     * @return
     */
    long countByExample(BaseOfficialDocumentsExample example);

    /**
     * 基本操作
     * @param example
     * @return
     */
    int deleteByExample(BaseOfficialDocumentsExample example);

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 添加
     *
     * @param record
     * @return
     */
    int insert(BaseOfficialDocuments record);

    /**
     * 添加
     *
     * @param record
     * @return
     */
    int insertSelective(BaseOfficialDocuments record);
    /**
     * 基本操作
     * @param example
     * @return
     */
    List<BaseOfficialDocuments> selectByExample(BaseOfficialDocumentsExample example);

    /**
     * 查询
     *
     * @param id
     * @return
     */
    BaseOfficialDocuments selectByPrimaryKey(Integer id);

    /**
     * 更新
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") BaseOfficialDocuments record, @Param("example") BaseOfficialDocumentsExample example);
    /**
     * 更新
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") BaseOfficialDocuments record, @Param("example") BaseOfficialDocumentsExample example);

    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BaseOfficialDocuments record);
    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(BaseOfficialDocuments record);

    /**
     * 查看
     * @param offset
     * @param limit
     * @return
     */
    List<BaseOfficialDocuments> selectByPage(@Param("offset") Long offset, @Param("limit") Long limit);

    /**
     * 查看
     * @param record
     * @return
     */
    List<BaseOfficialDocuments> selectListByConditions(BaseOfficialDocuments record);
}