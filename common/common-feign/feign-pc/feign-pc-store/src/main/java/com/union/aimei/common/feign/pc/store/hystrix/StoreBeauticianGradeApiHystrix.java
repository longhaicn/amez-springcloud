package com.union.aimei.common.feign.pc.store.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.store.StoreBeauticianGradeFeign;
import com.union.aimei.common.model.store.StoreBeauticianGrade;
import org.springframework.stereotype.Component;

/**
 * @author caizhaoming
 * @version 1.1
 * @create 2018-06-25 11:43
 **/
@Component(value = "pc-StoreBeauticianGradeFeign")
public class StoreBeauticianGradeApiHystrix implements StoreBeauticianGradeFeign {

    /**
     * 前端分页查询店铺-美容师等级
     *
     * @param pageNo               分页索引
     * @param pageSize             每页显示数量
     * @param storeBeauticianGrade 查询条件
     * @return
     */
    @Override
    public PageInfo<StoreBeauticianGrade> findByPageForFront(Integer pageNo, Integer pageSize, StoreBeauticianGrade storeBeauticianGrade) {
        return null;
    }

    /**
     * 添加店铺-美容师等级
     *
     * @param storeBeauticianGrade
     * @return
     */
    @Override
    public int insert(StoreBeauticianGrade storeBeauticianGrade) {
        return 0;
    }

    /**
     * 删除店铺-美容师等级
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改店铺-美容师等级
     *
     * @param storeBeauticianGrade
     * @return
     */
    @Override
    public int edit(StoreBeauticianGrade storeBeauticianGrade) {
        return 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnstoreBeauticianGrade
     */
    @Override
    public StoreBeauticianGrade queryById(int id) {
        return null;
    }
}