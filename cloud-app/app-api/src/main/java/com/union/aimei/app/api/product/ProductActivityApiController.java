package com.union.aimei.app.api.product;

import com.union.aimei.common.feign.app.product.ProductActivityFeign;
import com.union.aimei.common.model.product.ProductActivity;
import com.union.aimei.common.vo.product.app.ProductActivityByDetailResVo;
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
 * @time 2018/5/14 11:38
 */
@Api(tags = "项目活动")
@RestController
@RequestMapping(value = "productActivity")
public class ProductActivityApiController {
    @Resource
    private ProductActivityFeign productActivityFeign;

    /**
     * 查询精选项目活动
     *
     * @param cityId 城市ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "查询精选项目活动")
    @GetMapping("/1.1.0/findListBySelect/{cityId}")
    public ResponseMessage<List<ProductActivity>> findListBySelectV111(@ApiParam(value = "城市ID", required = true) @PathVariable(value = "cityId") int cityId) {
        return this.productActivityFeign.findListBySelectV111(cityId);
    }

    /**
     * 项目活动详情
     *
     * @param id ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "项目活动详情")
    @GetMapping("/1.1.0/detail/{id}")
    public ResponseMessage<ProductActivityByDetailResVo> detailV111(@ApiParam(value = "ID", required = true) @PathVariable(value = "id") int id) {
        return this.productActivityFeign.detailV111(id);
    }

}