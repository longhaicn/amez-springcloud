package com.union.aimei.system.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseOperator;
/**
 * @author liufeihua
 */
public interface BaseOperatorService {
    /**
     * 基本操作
     * @param operId
     * @return
     */
    int deleteByPrimaryKey(Integer operId);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int insertSelective(BaseOperator record);
    /**
     * 基本操作
     * @param operId
     * @return
     */
    BaseOperator selectByPrimaryKey(Integer operId);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BaseOperator record);
    /**
     * 查看
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    PageInfo<BaseOperator> selectListByConditions(Integer pageNo, Integer pageSize, BaseOperator record);
}