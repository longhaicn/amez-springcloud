package com.union.aimei.common.feign.pc.product;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.product.hystrix.ProductImgApiHystrix;
import com.union.aimei.common.model.product.ProductImg;
import com.union.aimei.common.vo.product.pc.ProductImgByBatchVo;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 商品图片
 *
 * @author liurenkai
 * @time 2018/1/5 19:16
 */
@FeignClient(serviceId = "PC-PRODUCT-SERVICE", fallback = ProductImgApiHystrix.class)
public interface ProductImgFeign {
    /**
     * 添加商品图片
     *
     * @param productImg
     * @return
     */
    @PostMapping(value = "/productImg/insert")
    int insert(@RequestBody ProductImg productImg);

    /**
     * 删除商品图片
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/productImg/deleteById/{id}")
    int deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改商品图片
     *
     * @param productImg
     * @return
     */
    @PutMapping(value = "/productImg/edit")
    int edit(@RequestBody ProductImg productImg);

    /**
     * 根据ID查询
     *
     * @param id
     * @returnproductImg
     */
    @GetMapping(value = "/productImg/queryById/{id}")
    ProductImg queryById(@PathVariable(value = "id") int id);

    /**
     * 前端分页查询商品图片
     *
     * @param pageNo     分页索引
     * @param pageSize   每页显示数量
     * @param productImg 查询条件
     * @return
     */
    @PostMapping(value = "/productImg/front/findByPage")
    PageInfo<ProductImg> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                            @RequestBody ProductImg productImg);

    /**
     * 根据商品ID删除商品图片
     *
     * @param productId
     * @return
     */
    @DeleteMapping(value = "/productImg/deleteByProductId/{productId}")
    ResponseMessage deleteByProductId(@PathVariable(value = "productId") int productId);

    /**
     * 批量新增商品图片
     *
     * @param batchVo 批量商品图片
     * @return
     */
    @PostMapping(value = "/productImg/addBatch")
    ResponseMessage addBatch(@RequestBody ProductImgByBatchVo batchVo);

    /**
     * 新增商品图片
     *
     * @param productImg 商品图片
     * @return
     */
    @PostMapping(value = "/productImg/add")
    ResponseMessage add(@RequestBody ProductImg productImg);

}