package com.union.aimei.system.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseNotificationNotice;
/**
 * @author liufeihua
 */
public interface BaseNotificationNoticeService {
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
    int insertSelective(BaseNotificationNotice record);
    /**
     * 基本操作
     * @param id
     * @return
     */
    BaseNotificationNotice selectByPrimaryKey(Integer id);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BaseNotificationNotice record);
    /**
     * 查看
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    PageInfo<BaseNotificationNotice> selectListByConditions(Integer pageNo, Integer pageSize, BaseNotificationNotice record);
}