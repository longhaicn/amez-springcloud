package com.union.aimei.common.feign.app.order.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.order.OrderProductConsumeGoodsRecordFeign;
import com.union.aimei.common.model.order.OrderProductConsumeGoodsRecord;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.exception.ServerException;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * 订单
 *
 * @author GaoWei
 * @time 2018/8/23 10:28
 */
@Component
public class OrderProductConsumeGoodsRecordhystrix implements OrderProductConsumeGoodsRecordFeign {

    @Override
    public ResponseMessage<OrderProductConsumeGoodsRecord> queryByProductId(int productId) {
        throw new ServerException(500,"服务或网络不稳定");
    }

    @Override
    public ResponseMessage<PageInfo<HashMap<String, Object>>> queryStoreConsumeDetail(Integer pageNo, Integer pageSize, Integer storeId, Integer productId) {
        throw new ServerException(500,"服务或网络不稳定");
    }

    @Override
    public ResponseMessage<PageInfo<HashMap<String, Object>>> queryBeauticianConsumeDetail(Integer pageNo, Integer pageSize, Integer beauticianId, Integer productId) {
        throw new ServerException(500,"服务或网络不稳定");
    }
}
