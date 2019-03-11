package com.union.aimei.common.feign.pc.store.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.store.StoreCouponsProductFeign;
import com.union.aimei.common.model.store.StoreCouponsProduct;
import com.union.aimei.common.vo.store.pc.StoreCouponsProductByBatchVo;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

/**
 * 优惠券-服务-关联
 *
 * @author liurenkai
 * @time 2018/1/12 17:35
 */
@Component(value = "pc-StoreCouponsProductFeign")
public class StoreCouponsProductApiHystrix implements StoreCouponsProductFeign {

    @Override
    public ResponseMessage<PageInfo<StoreCouponsProduct>> findByPageForFront(Integer pageNo, Integer pageSize, StoreCouponsProduct storeCouponsProduct) {
        return HystrixResponse.invokeFail();
    }

    /**
     * 添加优惠券-服务-关联
     *
     * @param storeCouponsProduct
     * @return
     */
    @Override
    public int insert(StoreCouponsProduct storeCouponsProduct) {
        return 0;
    }

    /**
     * 删除优惠券-服务-关联
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改优惠券-服务-关联
     *
     * @param storeCouponsProduct
     * @return
     */
    @Override
    public int edit(StoreCouponsProduct storeCouponsProduct) {
        return 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnstoreCouponsProduct
     */
    @Override
    public StoreCouponsProduct queryById(int id) {
        return null;
    }

    @Override
    public ResponseMessage addBatch(StoreCouponsProductByBatchVo batchVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage updateByIsEnabledByCouponsId(int couponsId, boolean isEnabled) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage updateByIsEnabledByProductId(int productId, boolean isEnabled) {
        return HystrixResponse.invokeFail();
    }

}