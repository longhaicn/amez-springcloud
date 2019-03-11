package com.union.aimei.common.feign.app.product;

import com.union.aimei.common.feign.app.product.hystrix.ActivityProductRefApiHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * 活动-项目-关联
 *
 * @author liurenkai
 * @time 2018/5/14 11:36
 */
@FeignClient(serviceId = "APP-PRODUCT-SERVICE", fallback = ActivityProductRefApiHystrix.class)
public interface ActivityProductRefFeign {

}