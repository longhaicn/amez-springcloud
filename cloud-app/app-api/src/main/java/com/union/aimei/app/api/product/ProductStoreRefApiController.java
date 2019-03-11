package com.union.aimei.app.api.product;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.product.ProductStoreRefFeign;
import com.union.aimei.common.model.product.ProductStoreRef;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 项目-门店-关联
 *
 * @author liurenkai
 * @time 2018/1/5 19:14
 */
@Api(tags = "项目-门店-关联")
@RestController
@RequestMapping(value = "productStoreRef")
public class ProductStoreRefApiController {
    @Resource
    private ProductStoreRefFeign productStoreRefFeign;

    /**
     * 分页查询项目-门店-关联
     *
     * @param pageNo          分页索引
     * @param pageSize        每页数量
     * @param productStoreRef 查询条件
     * @return ResponseMessage<ProductStoreRef>
     */
    @ApiOperation(httpMethod = "POST", value = "前端分页查询项目-门店-关联")
    @PostMapping("/front/findByPage")
    public ResponseMessage<PageInfo<ProductStoreRef>> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                         @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                         @ApiParam(value = "查询条件") @RequestBody ProductStoreRef productStoreRef) {
        return this.productStoreRefFeign.findByPageForFront(pageNo, pageSize, productStoreRef);
    }
}