package com.union.aimei.app.api.product;

import com.union.aimei.common.feign.app.product.PhysicalCategoryRefFeign;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author caizhaoming
 * @version 1.1
 * @create 2018-06-21 11:43
 **/
@Api(tags = "产品-产品分类-关联")
@RestController
@RequestMapping(value = "physicalCategoryRef")
public class PhysicalCategoryRefApiController {
    @Resource
    private PhysicalCategoryRefFeign physicalCategoryRefFeign;
}