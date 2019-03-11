package com.union.aimei.app.api.product;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.product.ProductCategoryFeign;
import com.union.aimei.common.model.product.ProductCategory;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 商品分类
 *
 * @author liurenkai
 * @time 2018/2/27 14:52
 */
@Api(tags = "商品分类")
@RestController
@RequestMapping(value = "productCategory")
public class ProductCategoryApiController {
    @Resource
    private ProductCategoryFeign productCategoryFeign;

    /**
     * 分页查询商品分类
     *
     * @param pageNo          分页索引
     * @param pageSize        每页数量
     * @param productCategory 查询条件
     * @return ResponseMessage<ProductCategory>
     */
    @ApiOperation(httpMethod = "POST", value = "分页查询商品分类")
    @PostMapping("/front/findByPage")
    public ResponseMessage<PageInfo<ProductCategory>> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                         @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                         @ApiParam(value = "查询条件") @RequestBody ProductCategory productCategory) {
        return this.productCategoryFeign.findByPageForFront(pageNo, pageSize, productCategory);
    }

}