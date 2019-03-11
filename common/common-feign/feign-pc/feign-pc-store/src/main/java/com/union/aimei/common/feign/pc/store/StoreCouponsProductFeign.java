package com.union.aimei.common.feign.pc.store;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.store.hystrix.StoreCouponsProductApiHystrix;
import com.union.aimei.common.model.store.StoreCouponsProduct;
import com.union.aimei.common.vo.store.pc.StoreCouponsProductByBatchVo;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 优惠券-服务-关联
 *
 * @author liurenkai
 * @time 2018/1/12 17:35
 */
@FeignClient(serviceId = "PC-STORE-SERVICE", fallback = StoreCouponsProductApiHystrix.class)
public interface StoreCouponsProductFeign {
    /**
     * 添加优惠券-服务-关联
     *
     * @param storeCouponsProduct
     * @return
     */
    @PostMapping(value = "/storeCouponsProduct/insert")
    int insert(@RequestBody StoreCouponsProduct storeCouponsProduct);

    /**
     * 删除优惠券-服务-关联
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/storeCouponsProduct/deleteById/{id}")
    int deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改优惠券-服务-关联
     *
     * @param storeCouponsProduct
     * @return
     */
    @PutMapping(value = "/storeCouponsProduct/edit")
    int edit(@RequestBody StoreCouponsProduct storeCouponsProduct);

    /**
     * 根据ID查询
     *
     * @param id
     * @returnstoreCouponsProduct
     */
    @GetMapping(value = "/storeCouponsProduct/queryById/{id}")
    StoreCouponsProduct queryById(@PathVariable(value = "id") int id);

    /**
     * 分页查询优惠券-服务-关联
     *
     * @param pageNo              分页索引
     * @param pageSize            每页显示数量
     * @param storeCouponsProduct 查询条件
     * @return
     */
    @PostMapping(value = "/storeCouponsProduct/front/findByPage")
    ResponseMessage<PageInfo<StoreCouponsProduct>> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                      @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                      @RequestBody StoreCouponsProduct storeCouponsProduct);

    /**
     * 批量新增优惠券-服务-关联
     *
     * @param batchVo 批量优惠券-服务-关联
     * @return
     */
    @PostMapping(value = "/storeCouponsProduct/addBatch")
    ResponseMessage addBatch(@RequestBody StoreCouponsProductByBatchVo batchVo);

    /**
     * 根据优惠券ID更新软删除标记
     *
     * @param couponsId 优惠券ID
     * @param isEnabled 软删除标记，1-正常，0-删除
     * @return
     */
    @PutMapping("/storeCouponsProduct/updateByIsEnabledByCouponsId/{couponsId}/{isEnabled}")
    ResponseMessage updateByIsEnabledByCouponsId(@PathVariable(value = "couponsId") int couponsId,
                                                 @PathVariable(value = "isEnabled") boolean isEnabled);

    /**
     * 根据商品ID更新软删除标记
     *
     * @param productId 商品ID
     * @param isEnabled 软删除标记，1-正常，0-删除
     * @return
     */
    @PutMapping("/storeCouponsProduct/updateByIsEnabledByProductId/{productId}/{isEnabled}")
    ResponseMessage updateByIsEnabledByProductId(@PathVariable(value = "productId") int productId,
                                                 @PathVariable(value = "isEnabled") boolean isEnabled);

}
