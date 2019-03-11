package com.union.aimei.system.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseSmsTemplate;
/**
 * @author liufeihua
 */
public interface BaseSmsTemplateService {
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
    int insertSelective(BaseSmsTemplate record);
    /**
     * 基本操作
     * @param id
     * @return
     */
    BaseSmsTemplate selectByPrimaryKey(Integer id);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BaseSmsTemplate record);
    /**
     * 查看
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    PageInfo<BaseSmsTemplate> selectListByConditions(Integer pageNo, Integer pageSize, BaseSmsTemplate record);
}