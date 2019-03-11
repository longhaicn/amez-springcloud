package com.union.aimei.app.api.product;

import com.union.aimei.common.feign.app.product.ProductCategoryRefFeign;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 商品-分类-关联
 *
 * @author liurenkai
 * @time 2018/2/27 14:52
 */
@Api(tags = "商品-分类-关联")
@RestController
@RequestMapping(value = "productCategoryRef")
public class ProductCategoryRefApiController {
    @Resource
    private ProductCategoryRefFeign productCategoryRefFeign;

}