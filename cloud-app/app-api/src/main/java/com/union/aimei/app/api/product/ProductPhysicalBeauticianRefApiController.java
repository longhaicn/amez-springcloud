package com.union.aimei.app.api.product;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.product.ProductPhysicalBeauticianRefFeign;
import com.union.aimei.common.model.product.ProductPhysicalBeauticianRef;
import com.union.aimei.common.vo.product.app.ProductPhysicalBeauticianRefByBeauticianIdResVo;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 产品-美容师-关联
 *
 * @author liurenkai
 * @time 2018/2/28 16:25
 */
@Api(tags = "产品-美容师-关联")
@RestController
@RequestMapping(value = "productPhysicalBeauticianRef")
public class ProductPhysicalBeauticianRefApiController {
    @Resource
    private ProductPhysicalBeauticianRefFeign productPhysicalBeauticianRefFeign;

    /**
     * 分页查询产品-美容师-关联
     *
     * @param pageNo                       分页索引
     * @param pageSize                     每页数量
     * @param productPhysicalBeauticianRef 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "分页查询产品-美容师-关联")
    @PostMapping("/front/findByPage")
    public ResponseMessage<PageInfo<ProductPhysicalBeauticianRef>> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                      @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                      @ApiParam(value = "查询条件") @RequestBody ProductPhysicalBeauticianRef productPhysicalBeauticianRef) {
        return this.productPhysicalBeauticianRefFeign.findByPageForFront(pageNo, pageSize, productPhysicalBeauticianRef);
    }

    /**
     * 分页查询产品-美容师-关联（根据美容师ID）
     *
     * @param pageNo       分页索引
     * @param pageSize     每页数量
     * @param beauticianId 美容师ID
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "分页查询产品-美容师-关联（根据美容师ID）")
    @PostMapping("/findByPageForBeauticianId/{beauticianId}")
    public ResponseMessage<PageInfo<ProductPhysicalBeauticianRefByBeauticianIdResVo>> findByPageForBeauticianId(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                                                @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                                                @ApiParam(value = "美容师ID") @PathVariable(value = "beauticianId") int beauticianId) {
        return this.productPhysicalBeauticianRefFeign.findByPageForBeauticianId(pageNo, pageSize, beauticianId);
    }

}