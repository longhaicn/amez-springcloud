package com.union.aimei.common.feign.pc.product;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.product.hystrix.ProductBeauticianRefApiHystrix;
import com.union.aimei.common.model.product.ProductBeauticianRef;
import com.union.aimei.common.vo.product.pc.*;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 项目-美容师-关联
 *
 * @author liurenkai
 * @time 2018/2/26 15:04
 */
@FeignClient(serviceId = "PC-PRODUCT-SERVICE", fallback = ProductBeauticianRefApiHystrix.class)
public interface ProductBeauticianRefFeign {
    /**
     * 添加项目-美容师-关联
     *
     * @param productBeauticianRef
     * @return
     */
    @PostMapping(value = "/productBeauticianRef/insert")
    int insert(@RequestBody ProductBeauticianRef productBeauticianRef);

    /**
     * 删除项目-美容师-关联
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/productBeauticianRef/deleteById/{id}")
    int deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改项目-美容师-关联
     *
     * @param productBeauticianRef
     * @return
     */
    @PutMapping(value = "/productBeauticianRef/edit")
    int edit(@RequestBody ProductBeauticianRef productBeauticianRef);

    /**
     * 根据ID查询
     *
     * @param id
     * @returnproductBeauticianRef
     */
    @GetMapping(value = "/productBeauticianRef/queryById/{id}")
    ProductBeauticianRef queryById(@PathVariable(value = "id") int id);

    /**
     * 前端分页查询项目-美容师-关联
     *
     * @param pageNo               分页索引
     * @param pageSize             每页显示数量
     * @param productBeauticianRef 查询条件
     * @return
     */
    @PostMapping(value = "/productBeauticianRef/front/findByPage")
    PageInfo<ProductBeauticianRef> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0")
                                                              Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10")
                                                              Integer pageSize, @RequestBody ProductBeauticianRef productBeauticianRef);

    /**
     * 根据商品ID删除项目-美容师-关联
     *
     * @param productId 商品ID
     * @return
     */
    @DeleteMapping(value = "/productBeauticianRef/deleteByProductId/{productId}")
    ResponseMessage deleteByProductId(@PathVariable(value = "productId") int productId);

    /**
     * 批量添加项目-美容师-关联
     *
     * @param productBeauticianRefByBatchVo
     * @return
     */
    @PostMapping("/productBeauticianRef/addBatch")
    ResponseMessage addBatch(@RequestBody ProductBeauticianRefByBatchVo productBeauticianRefByBatchVo);

    /**
     * 详情
     *
     * @param id
     * @return
     */
    @GetMapping("/productBeauticianRef/detail/{id}")
    ResponseMessage<ProductBeauticianRefByDetailResVo> detail(@PathVariable(value = "id") int id);

    /**
     * 分页查询项目-美容师-关联
     *
     * @param pageNo                 分页索引
     * @param pageSize               每页数量
     * @param productBeauticianRefVo 查询条件
     * @return
     */
    @PostMapping("/productBeauticianRef/findByPage")
    ResponseMessage<PageInfo<ProductBeauticianRefByResVo>> findByPage(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                      @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                      @RequestBody ProductBeauticianRefVo productBeauticianRefVo);

    /**
     * 同意
     *
     * @param agreeVo
     * @return
     */
    @PutMapping(value = "/productBeauticianRef/agree")
    ResponseMessage agree(@RequestBody ProductBeauticianRefByAgreeVo agreeVo);

    /**
     * 审核
     *
     * @param authVo
     * @return
     */
    @PutMapping(value = "/productBeauticianRef/auth")
    ResponseMessage<ProductBeauticianRef> auth(@RequestBody ProductBeauticianRefByAuthVo authVo);

    /**
     * 美容师状态
     *
     * @param beauticianStatusVo
     * @return
     */
    @PutMapping(value = "/productBeauticianRef/beauticianStatus")
    ResponseMessage beauticianStatus(@RequestBody ProductBeauticianRefByBeauticianStatusVo beauticianStatusVo);

    /**
     * 课程通过
     *
     * @param coursePassVo 课程条件
     * @return
     */
    @PostMapping("/productBeauticianRef/1.1.1/coursePass")
    ResponseMessage coursePassV111(@RequestBody ProductBeauticianRefCoursePassVo coursePassVo);

}