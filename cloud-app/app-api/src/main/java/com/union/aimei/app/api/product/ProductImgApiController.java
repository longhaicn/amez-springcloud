package com.union.aimei.app.api.product;

import com.union.aimei.common.feign.app.product.ProductImgFeign;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 项目图片
 *
 * @author liurenkai
 * @time 2018/2/27 14:53
 */
@Api(tags = "项目图片")
@RestController
@RequestMapping(value = "productImg")
public class ProductImgApiController {
    @Resource
    private ProductImgFeign productImgFeign;
    
}