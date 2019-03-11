package com.union.aimei.product.controller;

import com.union.aimei.common.model.product.ProductImg;
import com.union.aimei.product.service.ProductImgService;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 项目图片
 *
 * @author liurenkai
 * @time 2018/2/27 14:30
 */
@Api(tags = "项目图片")
@RestController
@RequestMapping(value = "productImg")
public class ProductImgController {
    @Resource
    private ProductImgService productImgService;

    /**
     * 根据项目ID查询项目图片
     *
     * @param productId 项目ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据项目ID查询项目图片")
    @GetMapping("/findByProductId/{productId}")
    public ResponseMessage<ProductImg> findByProductId(@ApiParam(value = "项目ID") @PathVariable(value = "productId") int productId) {
        return this.productImgService.findByProductId(productId);
    }

}