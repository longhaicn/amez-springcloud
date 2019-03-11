package com.union.aimei.app.api.product;

import com.union.aimei.common.feign.app.product.ProductPhysicalCategoryRefFeign;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 产品-分类-关联
 *
 * @author liurenkai
 * @time 2018/2/28 16:25
 */
@Api(tags = "产品-分类-关联")
@RestController
@RequestMapping(value = "productPhysicalCategoryRef")
public class ProductPhysicalCategoryRefApiController {
    @Resource
    private ProductPhysicalCategoryRefFeign productPhysicalCategoryRefFeign;

}