package com.union.aimei.pc.system.mapper;

import com.union.aimei.common.model.system.BaseAttachment;
import com.union.aimei.common.model.system.BaseAttachmentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liufeihua
 */
public interface BaseAttachmentMapper {
    /**
     * 统计
     * @param example
     * @return
     */
    long countByExample(BaseAttachmentExample example);
    /**
     * 基本操作
     * @param example
     * @return
     */
    int deleteByExample(BaseAttachmentExample example);

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
    int insert(BaseAttachment record);

    /**
     * 添加
     *
     * @param record
     * @return
     */
    int insertSelective(BaseAttachment record);
    /**
     * 基本操作
     * @param example
     * @return
     */
    List<BaseAttachment> selectByExample(BaseAttachmentExample example);

    /**
     * 查询
     *
     * @param id
     * @return
     */
    BaseAttachment selectByPrimaryKey(Integer id);
    /**
     * 更新
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") BaseAttachment record, @Param("example") BaseAttachmentExample example);
    /**
     * 更新
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") BaseAttachment record, @Param("example") BaseAttachmentExample example);
    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BaseAttachment record);
    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(BaseAttachment record);
    /**
     * 查看
     * @param offset
     * @param limit
     * @return
     */
    List<BaseAttachment> selectByPage(@Param("offset") Long offset, @Param("limit") Long limit);
    /**
     * 查看
     * @param record
     * @return
     */
    List<BaseAttachment> selectListByConditions(BaseAttachment record);
}