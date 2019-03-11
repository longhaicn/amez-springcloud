package com.union.aimei.pc.system.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseAttachment;

/**
 * @author liufeihua
 */

public interface BaseAttachmentService {
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
    int insertSelective(BaseAttachment record);

    /**
     * 查询
     *
     * @param id
     * @return
     */
    BaseAttachment selectByPrimaryKey(Integer id);
    /**
     * 更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BaseAttachment record);
    /**
     * 查询
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    PageInfo<BaseAttachment> selectListByConditions(Integer pageNo, Integer pageSize, BaseAttachment record);
}