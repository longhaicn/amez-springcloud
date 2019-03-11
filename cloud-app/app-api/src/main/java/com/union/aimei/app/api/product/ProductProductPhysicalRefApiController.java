package com.union.aimei.app.api.product;

import com.union.aimei.common.feign.app.product.ProductProductPhysicalRefFeign;
import com.union.aimei.common.vo.product.app.ProductProductPhysicalRefByProductIdReturnVo;
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
 * 项目-产品-关联
 *
 * @author liurenkai
 * @time 2018/2/28 16:26
 */
@Api(tags = "项目-产品-关联")
@RestController
@RequestMapping(value = "productProductPhysicalRef")
public class ProductProductPhysicalRefApiController {
    @Resource
    private ProductProductPhysicalRefFeign productProductPhysicalRefFeign;

    /**
     * 根据商品ID查询项目-产品-关联
     *
     * @param productId 商品ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据商品ID查询项目-产品-关联")
    @GetMapping("/findListByProductId/{productId}")
    public ResponseMessage<List<ProductProductPhysicalRefByProductIdReturnVo>> findListByProductId(@ApiParam(value = "商品ID") @PathVariable(value = "productId") int productId) {
        return this.productProductPhysicalRefFeign.findListByProductId(productId);
    }

}