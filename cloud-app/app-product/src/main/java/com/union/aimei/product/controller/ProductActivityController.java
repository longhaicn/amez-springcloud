package com.union.aimei.product.controller;

import com.union.aimei.common.model.product.ProductActivity;
import com.union.aimei.common.vo.product.app.ProductActivityByDetailResVo;
import com.union.aimei.product.service.ProductActivityService;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 项目活动
 *
 * @author liurenkai
 * @time 2018/5/14 11:13
 */
@Api(tags = "项目活动")
@RestController
@RequestMapping(value = "productActivity")
public class ProductActivityController {
    @Resource
    private ProductActivityService productActivityService;

    /**
     * 查询精选项目活动（1.1.1）
     *
     * @param cityId 城市ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "查询精选项目活动（1.1.1）")
    @GetMapping("/1.1.1/findListBySelect/{cityId}")
    public ResponseMessage<List<ProductActivity>> findListBySelectV111(@ApiParam(value = "城市ID") @PathVariable(value = "cityId") int cityId) {
        return this.productActivityService.findListBySelectV111(cityId);
    }

    /**
     * 项目活动详情（1.1.1）
     *
     * @param id ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "项目活动详情（1.1.1）")
    @GetMapping("/1.1.1/detail/{id}")
    public ResponseMessage<ProductActivityByDetailResVo> detailV111(@ApiParam(value = "ID") @PathVariable(value = "id") int id) {
        return this.productActivityService.detailV111(id);
    }

}