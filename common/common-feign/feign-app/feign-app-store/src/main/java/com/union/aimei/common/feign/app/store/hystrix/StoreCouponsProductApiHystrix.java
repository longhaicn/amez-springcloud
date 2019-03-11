package com.union.aimei.common.feign.app.store.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.store.StoreCouponsProductFeign;
import com.union.aimei.common.model.store.StoreCouponsProduct;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 优惠券-服务-关联
 *
 * @author liurenkai
 * @time 2017/12/22 16:22
 */
@Component(value = "app-StoreCouponsProductFeign")
public class StoreCouponsProductApiHystrix implements StoreCouponsProductFeign {

    @Override
    public PageInfo<StoreCouponsProduct> findByPageForFront(Integer pageNo, Integer pageSize, StoreCouponsProduct storeCouponsProduct) {
        return null;
    }

    @Override
    public ResponseMessage<List<StoreCouponsProduct>> findListByStoreCouponsId(int storeCouponsId) {
        return null;
    }
}