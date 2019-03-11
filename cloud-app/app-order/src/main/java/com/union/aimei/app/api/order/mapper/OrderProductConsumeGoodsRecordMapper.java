package com.union.aimei.app.api.order.mapper;


import com.union.aimei.common.model.order.OrderProductConsumeGoodsRecord;
import com.union.common.utils.base.BaseMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
  * @author GaoWei
  * @Date 18-8-13 下午1:47
  * @description
  */
public interface OrderProductConsumeGoodsRecordMapper extends BaseMapper<OrderProductConsumeGoodsRecord> {

    /**
     * 批量添加订单消耗实物产品记录表
     * @param list
     */
    void batchInsertRecord(List<OrderProductConsumeGoodsRecord> list);

    /**
     * 查询店铺消耗明细
     * @param map
     * @return
     */
    List<HashMap<String,Object>> queryStoreConsumer(Map<String,Object> map);

    /**
     * 查询美容师消耗明细
     * @param map
     * @return
     */
    List<HashMap<String,Object>> queryBeauticianConsumer(Map<String,Object> map);

}