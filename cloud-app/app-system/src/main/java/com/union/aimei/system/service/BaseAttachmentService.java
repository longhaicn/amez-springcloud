package com.union.aimei.system.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseAttachment;
/**
 * @author liufeihua
 */
public interface BaseAttachmentService {
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
    int insertSelective(BaseAttachment record);
    /**
     * 基本操作
     * @param id
     * @return
     */
    BaseAttachment selectByPrimaryKey(Integer id);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BaseAttachment record);
    /**
     * 查看
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    PageInfo<BaseAttachment> selectListByConditions(Integer pageNo, Integer pageSize, BaseAttachment record);
}