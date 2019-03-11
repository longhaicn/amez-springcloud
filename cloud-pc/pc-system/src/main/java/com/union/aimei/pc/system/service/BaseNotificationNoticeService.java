package com.union.aimei.pc.system.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseNotificationNotice;

/**
 * @author liufeihua
 */

public interface BaseNotificationNoticeService {

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
    int insertSelective(BaseNotificationNotice record);

    /**
     * 查询
     *
     * @param id
     * @return
     */
    BaseNotificationNotice selectByPrimaryKey(Integer id);

    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BaseNotificationNotice record);
    /**
     * 查询
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    PageInfo<BaseNotificationNotice> selectListByConditions(Integer pageNo, Integer pageSize, BaseNotificationNotice record);
}