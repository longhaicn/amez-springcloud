package com.union.aimei.pc.system.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseOfficialDocuments;

/**
 * @author liufeihua
 */

public interface BaseOfficialDocumentsService {
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
    int insertSelective(BaseOfficialDocuments record);

    /**
     * 查询
     *
     * @param id
     * @return
     */
    BaseOfficialDocuments selectByPrimaryKey(Integer id);
    /**
     * 更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BaseOfficialDocuments record);
    /**
     * 查询
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    PageInfo<BaseOfficialDocuments> selectListByConditions(Integer pageNo, Integer pageSize, BaseOfficialDocuments record);
}