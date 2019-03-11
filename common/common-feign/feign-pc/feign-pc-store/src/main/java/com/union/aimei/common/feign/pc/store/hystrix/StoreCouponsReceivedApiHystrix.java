package com.union.aimei.common.feign.pc.store.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.store.StoreCouponsReceivedFeign;
import com.union.aimei.common.model.store.StoreCouponsReceived;
import org.springframework.stereotype.Component;

/**
 * 店铺优惠券领取
 *
 * @author liurenkai
 * @time 2018/1/12 17:35
 */
@Component(value = "pc-StoreCouponsReceivedFeign")
public class StoreCouponsReceivedApiHystrix implements StoreCouponsReceivedFeign {

    /**
     * 前端分页查询店铺优惠券领取
     *
     * @param pageNo               分页索引
     * @param pageSize             每页显示数量
     * @param storeCouponsReceived 查询条件
     * @return
     */
    @Override
    public PageInfo<StoreCouponsReceived> findByPageForFront(Integer pageNo, Integer pageSize, StoreCouponsReceived storeCouponsReceived) {
        return null;
    }

    /**
     * 添加店铺优惠券领取
     *
     * @param storeCouponsReceived
     * @return
     */
    @Override
    public int insert(StoreCouponsReceived storeCouponsReceived) {
        return 0;
    }

    /**
     * 删除店铺优惠券领取
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改店铺优惠券领取
     *
     * @param storeCouponsReceived
     * @return
     */
    @Override
    public int edit(StoreCouponsReceived storeCouponsReceived) {
        return 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnstoreCouponsReceived
     */
    @Override
    public StoreCouponsReceived queryById(int id) {
        return null;
    }
}