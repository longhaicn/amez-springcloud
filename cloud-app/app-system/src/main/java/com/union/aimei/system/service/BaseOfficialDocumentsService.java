package com.union.aimei.system.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseOfficialDocuments;
/**
 * @author liufeihua
 */
public interface BaseOfficialDocumentsService {
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
    int insertSelective(BaseOfficialDocuments record);
    /**
     * 基本操作
     * @param id
     * @return
     */
    BaseOfficialDocuments selectByPrimaryKey(Integer id);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BaseOfficialDocuments record);
    /**
     * 查看
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    PageInfo<BaseOfficialDocuments> selectListByConditions(Integer pageNo, Integer pageSize, BaseOfficialDocuments record);
}