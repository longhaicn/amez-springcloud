package com.union.aimei.common.feign.app.store.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.store.StoreCouponsReceivedFeign;
import com.union.aimei.common.model.store.StoreCouponsReceived;
import com.union.aimei.common.vo.store.app.StoreCouponsReceivedByUsedVo;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

/**
 * 优惠券-服务-关联
 *
 * @author liurenkai
 * @time 2017/12/22 16:25
 */
@Component(value = "app-StoreCouponsReceivedFeign")
public class StoreCouponsReceivedApiHystrix implements StoreCouponsReceivedFeign {

    @Override
    public PageInfo<StoreCouponsReceived> findByPageForFront(Integer pageNo, Integer pageSize, StoreCouponsReceived storeCouponsReceived) {
        return null;
    }

    @Override
    public ResponseMessage add(int storeCouponsId, int memberId) {
        return null;
    }

    @Override
    public ResponseMessage used(StoreCouponsReceivedByUsedVo storeCouponsReceivedByUsedVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage sendBackByOrderNo(String orderNo) {
        return HystrixResponse.invokeFail();
    }
}