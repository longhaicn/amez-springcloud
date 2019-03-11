package com.union.aimei.common.feign.app.product;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.product.hystrix.ProductCollectionApiHystrix;
import com.union.aimei.common.model.product.ProductCollection;
import com.union.aimei.common.model.product.ProductCollectionParam;
import com.union.aimei.common.model.product.ProductCollectionResult;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 项目收藏
 *
 * @author liurenkai
 * @time 2018/1/26 11:13
 */
@FeignClient(serviceId = "APP-PRODUCT-SERVICE", fallback = ProductCollectionApiHystrix.class)
public interface ProductCollectionFeign {
    /**
     * 根据用户id查询该用户所收藏的商品
     *
     * @param pageNo                 分页索引
     * @param pageSize               每页显示数量
     * @param productCollectionParam 查询条件
     * @return
     */
    @PostMapping(value = "/productCollection/selectListPageCollectionByMemberId")
    ResponseMessage<PageInfo<ProductCollectionResult>> selectListPageCollectionByMemberId(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                          @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                          @RequestBody ProductCollectionParam productCollectionParam);

    /**
     * 项目收藏
     *
     * @param productId    项目ID
     * @param memberId     会员ID
     * @param isCollection 是否收藏，1-是，0-否
     * @return
     */
    @PostMapping("/productCollection/collection/{productId}/{memberId}/{isCollection}")
    ResponseMessage<ProductCollection> collection(@PathVariable(value = "productId") int productId,
                                                  @PathVariable(value = "memberId") int memberId,
                                                  @PathVariable(value = "isCollection") boolean isCollection);

    /**
     * 是否收藏
     *
     * @param productId 项目ID
     * @param memberId  会员ID
     * @return
     */
    @GetMapping("/productCollection/isCollection/{productId}/{memberId}")
    ResponseMessage<Boolean> isCollection(@PathVariable(value = "productId") int productId,
                                          @PathVariable(value = "memberId") int memberId);


}