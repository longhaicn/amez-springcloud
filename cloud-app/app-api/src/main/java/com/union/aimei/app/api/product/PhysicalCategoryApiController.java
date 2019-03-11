package com.union.aimei.app.api.product;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.product.PhysicalCategoryFeign;
import com.union.aimei.common.model.product.PhysicalCategory;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author caizhaoming
 * @version 1.1
 * @create 2018-06-21 11:43
 **/
@Api(tags = "产品分类")
@RestController
@RequestMapping(value = "physicalCategory")
public class PhysicalCategoryApiController {
    @Resource
    private PhysicalCategoryFeign physicalCategoryFeign;

    /**
     * 获取所有产品分类数据
     *
     * @param physicalCategory
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "获取所有产品分类数据V1.1.1")
    @PostMapping("/1.1.1/front/findByForFront")
    public ResponseMessage<PageInfo<PhysicalCategory>> findByForFrontV111(@ApiParam(value = "查询条件") @RequestBody PhysicalCategory physicalCategory) {
        return new ResponseMessage<>(this.physicalCategoryFeign.findByForFrontV111(physicalCategory));
    }
}