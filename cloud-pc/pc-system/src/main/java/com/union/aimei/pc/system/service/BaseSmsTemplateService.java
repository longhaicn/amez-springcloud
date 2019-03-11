package com.union.aimei.pc.system.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseSmsTemplate;

/**
 * @author liufeihua
 */

public interface BaseSmsTemplateService {

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
    int insertSelective(BaseSmsTemplate record);

    /**
     * 查询
     *
     * @param id
     * @return
     */
    BaseSmsTemplate selectByPrimaryKey(Integer id);
    /**
     * 更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BaseSmsTemplate record);
    /**
     * 查询
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    PageInfo<BaseSmsTemplate> selectListByConditions(Integer pageNo, Integer pageSize, BaseSmsTemplate record);
}