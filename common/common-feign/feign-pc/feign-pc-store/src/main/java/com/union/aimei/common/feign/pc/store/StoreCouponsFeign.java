package com.union.aimei.common.feign.pc.store;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.store.hystrix.StoreCouponsApiHystrix;
import com.union.aimei.common.model.store.StoreCoupons;
import com.union.aimei.common.vo.common.IdBatchVo;
import com.union.aimei.common.vo.store.pc.StoreCouponsProductCountResultVo;
import com.union.aimei.common.vo.store.pc.StoreCouponsProductCountVo;
import com.union.aimei.common.vo.store.pc.StoreCouponsVo;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 店铺优惠券
 *
 * @author liurenkai
 * @time 2018/1/12 17:34
 */
@FeignClient(serviceId = "PC-STORE-SERVICE", fallback = StoreCouponsApiHystrix.class)
public interface StoreCouponsFeign {
    /**
     * 添加店铺优惠券
     *
     * @param storeCoupons
     * @return
     */
    @PostMapping(value = "/storeCoupons/insert")
    int insert(@RequestBody StoreCoupons storeCoupons);

    /**
     * 删除店铺优惠券
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/storeCoupons/deleteById/{id}")
    int deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改店铺优惠券
     *
     * @param storeCoupons
     * @return
     */
    @PutMapping(value = "/storeCoupons/edit")
    int edit(@RequestBody StoreCoupons storeCoupons);

    /**
     * 根据ID查询
     *
     * @param id
     * @returnstoreCoupons
     */
    @GetMapping(value = "/storeCoupons/queryById/{id}")
    StoreCoupons queryById(@PathVariable(value = "id") int id);

    /**
     * 分页查询店铺优惠券
     *
     * @param pageNo       分页索引
     * @param pageSize     每页数量
     * @param storeCoupons 查询条件
     * @return
     */
    @PostMapping(value = "/storeCoupons/front/findByPage")
    PageInfo<StoreCoupons> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                              @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                              @RequestBody StoreCoupons storeCoupons);

    /**
     * 开始定时任务
     *
     * @return
     */
    @PutMapping(value = "/storeCoupons/startByScheduleTask")
    ResponseMessage startByScheduleTask();

    /**
     * 结束定时任务
     *
     * @return
     */
    @PutMapping(value = "/storeCoupons/endByScheduleTask")
    ResponseMessage endByScheduleTask();


    /**
     * 新增店铺优惠券
     *
     * @param storeCouponsVo 店铺优惠券vo
     * @return
     */
    @PostMapping(value = "/storeCoupons/add")
    ResponseMessage add(@RequestBody StoreCouponsVo storeCouponsVo);

    /**
     * 修改店铺优惠券软删除标记
     *
     * @param id        店铺优惠券ID
     * @param isEnabled 软删除标记
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "修改店铺优惠券软删除标记")
    @PutMapping(value = "/storeCoupons/isEnabled/{id}/{isEnabled}")
    ResponseMessage isEnabled(@ApiParam(value = "店铺优惠券ID") @PathVariable(value = "id") int id,
                              @ApiParam(value = "软删除标记，1为正常，0为删除") @PathVariable(value = "isEnabled") int isEnabled);


    /**
     * 根据ID查询店铺优惠券
     *
     * @param id 店铺优惠券ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据ID查询店铺优惠券")
    @GetMapping("/storeCoupons/findById/{id}")
    ResponseMessage<StoreCoupons> findById(@ApiParam(value = "店铺优惠券ID") @PathVariable(value = "id") int id);


    /**
     * 查询优惠券列表和包含的服务数量
     *
     * @param pageNo       分页索引
     * @param pageSize     每页数量
     * @param storeCoupons 查询条件
     * @return
     */
    @PostMapping(value = "/storeCoupons/findByPageForCountProduct")
    ResponseMessage<PageInfo<StoreCouponsProductCountResultVo>> findByPageForCountProduct(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                          @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                          @RequestBody StoreCouponsProductCountVo storeCoupons);

    /**
     * 批量根据店铺ID查询支持全部服务的优惠券
     *
     * @param idBatchVo 批量店铺ID
     * @return
     */
    @PostMapping("/storeCoupons/findListByStoreIdBatchForAllService")
    ResponseMessage<List<StoreCoupons>> findListByStoreIdBatchForAllService(@RequestBody IdBatchVo idBatchVo);

    /**
     * 批量根据门店ID查询支持全部服务的优惠券
     *
     * @param idBatchVo 批量门店ID
     * @return
     */
    @PostMapping("/storeCoupons/listAllServiceByStoreIdBatch")
    ResponseMessage<List<StoreCoupons>> listAllServiceByStoreIdBatch(@RequestBody IdBatchVo idBatchVo);

}