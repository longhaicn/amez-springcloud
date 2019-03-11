package com.union.aimei.common.feign.app.product;

import com.union.aimei.common.feign.app.product.hystrix.ProductActivityApiHystrix;
import com.union.aimei.common.model.product.ProductActivity;
import com.union.aimei.common.vo.product.app.ProductActivityByDetailResVo;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * 项目活动
 *
 * @author liurenkai
 * @time 2018/5/14 11:29
 */
@FeignClient(serviceId = "APP-PRODUCT-SERVICE", fallback = ProductActivityApiHystrix.class)
public interface ProductActivityFeign {

    /**
     * 查询精选项目活动
     *
     * @param cityId 城市ID
     * @return
     */
    @GetMapping("/productActivity/1.1.0/findListBySelect/{cityId}")
    ResponseMessage<List<ProductActivity>> findListBySelectV111(@PathVariable(value = "cityId") int cityId);

    /**
     * 项目活动详情
     *
     * @param id ID
     * @return
     */
    @GetMapping("/productActivity/1.1.0/detail/{id}")
    ResponseMessage<ProductActivityByDetailResVo> detailV111(@PathVariable(value = "id") int id);
}