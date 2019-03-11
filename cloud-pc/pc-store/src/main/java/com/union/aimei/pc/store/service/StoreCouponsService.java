package com.union.aimei.pc.store.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreCoupons;
import com.union.aimei.common.vo.common.IdBatchVo;
import com.union.aimei.common.vo.store.pc.StoreCouponsProductCountResultVo;
import com.union.aimei.common.vo.store.pc.StoreCouponsProductCountVo;
import com.union.aimei.common.vo.store.pc.StoreCouponsVo;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.base.SpringCloudBaseService;

import java.util.List;

/**
 * 门店优惠券
 *
 * @author liurenkai
 * @time 2018/1/12 17:34
 */
public interface StoreCouponsService extends SpringCloudBaseService<StoreCoupons> {
    /**
     * 前端查询门店优惠券
     *
     * @param pageNo       分页索引
     * @param pageSize     每页数量
     * @param storeCoupons 查询条件
     * @return
     */
    PageInfo<StoreCoupons> findByPageForFront(Integer pageNo, Integer pageSize, StoreCoupons storeCoupons);

    /**
     * 开始定时任务
     *
     * @return
     */
    ResponseMessage startByScheduleTask();

    /**
     * 结束定时任务
     *
     * @return
     */
    ResponseMessage endByScheduleTask();

    /**
     * 新增优惠券
     *
     * @param storeCouponsVo 优惠券vo
     * @return
     */
    ResponseMessage add(StoreCouponsVo storeCouponsVo);

    /**
     * 修改优惠券软删除标记
     *
     * @param id        优惠券ID
     * @param isEnabled 软删除标记
     * @return
     */
    ResponseMessage isEnabled(int id, int isEnabled);


    /**
     * 根据ID查询优惠券
     *
     * @param id 优惠券ID
     * @return
     */
    ResponseMessage<StoreCoupons> findById(int id);

    /**
     * 查询优惠券列表和包含的服务数量
     *
     * @param pageNo         分页索引
     * @param pageSize       每页数量
     * @param productCountVo 查询条件
     * @return
     */
    ResponseMessage<PageInfo<StoreCouponsProductCountResultVo>> findByPageForCountProduct(Integer pageNo, Integer pageSize, StoreCouponsProductCountVo productCountVo);

    /**
     * 批量根据门店ID查询支持全部服务的优惠券
     *
     * @param idBatchVo 批量门店ID
     * @return
     */
    ResponseMessage<List<StoreCoupons>> listAllServiceByStoreIdBatch(IdBatchVo idBatchVo);

}