package com.union.aimei.pc.store.mapper;

import com.union.aimei.common.model.store.StoreCoupons;
import com.union.aimei.common.vo.store.pc.StoreCouponsProductCountResultVo;
import com.union.aimei.common.vo.store.pc.StoreCouponsProductCountVo;
import com.union.common.utils.base.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * 门店优惠券
 *
 * @author liurenkai
 * @time 2018/1/12 17:34
 */
public interface StoreCouponsMapper extends BaseMapper<StoreCoupons> {

    /**
     * 开始定时任务
     *
     * @return
     */
    int updateByStartForScheduleTask();

    /**
     * 结束定时任务
     *
     * @return
     */
    int updateByEndForScheduleTask();

    /**
     * 查询优惠券列表和包含的服务数量
     *
     * @param productCountVo 查询条件
     * @return
     */
    List<StoreCouponsProductCountResultVo> selectListByConditionsAndCountProduct(StoreCouponsProductCountVo productCountVo);

    /**
     * 批量根据门店ID查询支持全部服务的优惠券
     *
     * @param condMap 条件
     * @return
     */
    List<StoreCoupons> listAllServiceByStoreIdBatch(Map<String, Object> condMap);

}