package com.union.aimei.pc.financial.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.financial.NotificationNotice;
/**
 * @author dell
 */
public interface NotificationNoticeService {
    /**
     * 基本操作
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int insertSelective(NotificationNotice record);
    /**
     * 基本操作
     *
     * @param id
     * @return
     */
    NotificationNotice selectByPrimaryKey(Integer id);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(NotificationNotice record);
    /**
     * 查看
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    PageInfo<NotificationNotice> selectListByConditions(Integer pageNo, Integer pageSize, NotificationNotice record);
}