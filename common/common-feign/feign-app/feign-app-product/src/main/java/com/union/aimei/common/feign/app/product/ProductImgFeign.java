package com.union.aimei.common.feign.app.product;

import com.union.aimei.common.feign.app.product.hystrix.ProductImgApiHystrix;
import com.union.aimei.common.model.product.ProductImg;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 项目图片
 *
 * @author liurenkai
 * @time 2018/2/27 14:40
 */
@FeignClient(serviceId = "APP-PRODUCT-SERVICE", fallback = ProductImgApiHystrix.class)
public interface ProductImgFeign {

    /**
     * 根据项目ID查询项目图片
     *
     * @param productId 项目ID
     * @return
     */
    @GetMapping(value = "/productImg/findByProductId/{productId}")
    ResponseMessage<ProductImg> findByProductId(@PathVariable(value = "productId") int productId);

}