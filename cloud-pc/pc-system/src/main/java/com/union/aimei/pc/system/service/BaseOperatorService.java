package com.union.aimei.pc.system.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseOperator;

/**
 * @author liufeihua
 */

public interface BaseOperatorService {

    /**
     * 根据id删除
     *
     * @param operId
     * @return
     */
    int deleteByPrimaryKey(Integer operId);

    /**
     * 添加
     *
     * @param record
     * @return
     */
    int insertSelective(BaseOperator record);

    /**
     * 查询
     *
     * @param operId
     * @return
     */
    BaseOperator selectByPrimaryKey(Integer operId);
    /**
     * 更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BaseOperator record);
    /**
     * 查询
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    PageInfo<BaseOperator> selectListByConditions(Integer pageNo, Integer pageSize, BaseOperator record);
}