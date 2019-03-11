package com.union.aimei.app.api.product;

import com.union.aimei.common.feign.app.product.ProductCityFeign;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 项目城市
 *
 * @author liurenkai
 * @time 2018/2/27 14:52
 */
@Api(tags = "项目城市")
@RestController
@RequestMapping(value = "productCity")
public class ProductCityApiController {
    @Resource
    private ProductCityFeign productCityFeign;

}