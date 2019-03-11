package com.union.aimei.store.service;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreBeauticianGrade;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.base.SpringCloudBaseService;

/**
 * @author caizhaoming
 * @version 1.1
 * @create 2018-06-25 11:43
 **/
public interface StoreBeauticianGradeService extends SpringCloudBaseService<StoreBeauticianGrade> {
    /**
     * 前端分页查询店铺-美容师等级
     *
     * @param pageNo               分页索引
     * @param pageSize             每页显示数量
     * @param storeBeauticianGrade 查询条件
     * @return
     */
    PageInfo<StoreBeauticianGrade> findByPageForFront(Integer pageNo, Integer pageSize, StoreBeauticianGrade storeBeauticianGrade);

    /**
     * 根据id删除数据
     *
     * @param id
     * @return
     */
    ResponseMessage deleteByStoreBeauticianGradeV111(Integer id);
}