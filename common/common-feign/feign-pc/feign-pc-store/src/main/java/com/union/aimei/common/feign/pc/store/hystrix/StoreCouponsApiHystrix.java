package com.union.aimei.common.feign.pc.store.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.store.StoreCouponsFeign;
import com.union.aimei.common.model.store.StoreCoupons;
import com.union.aimei.common.vo.common.IdBatchVo;
import com.union.aimei.common.vo.store.pc.StoreCouponsProductCountResultVo;
import com.union.aimei.common.vo.store.pc.StoreCouponsProductCountVo;
import com.union.aimei.common.vo.store.pc.StoreCouponsVo;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 店铺优惠券
 *
 * @author liurenkai
 * @time 2018/1/12 17:34
 */
@Component(value = "pc-StoreCouponsFeign")
public class StoreCouponsApiHystrix implements StoreCouponsFeign {

    /**
     * 前端分页查询店铺优惠券
     *
     * @param pageNo       分页索引
     * @param pageSize     每页显示数量
     * @param storeCoupons 查询条件
     * @return
     */
    @Override
    public PageInfo<StoreCoupons> findByPageForFront(Integer pageNo, Integer pageSize, StoreCoupons storeCoupons) {
        return null;
    }

    /**
     * 添加店铺优惠券
     *
     * @param storeCoupons
     * @return
     */
    @Override
    public int insert(StoreCoupons storeCoupons) {
        return 0;
    }

    /**
     * 删除店铺优惠券
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改店铺优惠券
     *
     * @param storeCoupons
     * @return
     */
    @Override
    public int edit(StoreCoupons storeCoupons) {
        return 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnstoreCoupons
     */
    @Override
    public StoreCoupons queryById(int id) {
        return null;
    }

    @Override
    public ResponseMessage startByScheduleTask() {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage endByScheduleTask() {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage add(StoreCouponsVo storeCouponsVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage isEnabled(int id, int isEnabled) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<StoreCoupons> findById(int id) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<PageInfo<StoreCouponsProductCountResultVo>> findByPageForCountProduct(Integer pageNo, Integer pageSize, StoreCouponsProductCountVo storeCoupons) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<List<StoreCoupons>> findListByStoreIdBatchForAllService(IdBatchVo idBatchVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<List<StoreCoupons>> listAllServiceByStoreIdBatch(IdBatchVo idBatchVo) {
        return HystrixResponse.invokeFail();
    }

}