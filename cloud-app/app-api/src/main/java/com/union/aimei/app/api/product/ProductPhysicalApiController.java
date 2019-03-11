package com.union.aimei.app.api.product;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.product.ProductPhysicalFeign;
import com.union.aimei.common.model.product.ProductPhysical;
import com.union.aimei.common.vo.product.app.PhysicalByInventoryForBeauticianVo;
import com.union.aimei.common.vo.product.app.ProductPhysicalByCalcFreightVo;
import com.union.aimei.common.vo.product.app.ProductPhysicalByCategoryVo;
import com.union.aimei.common.vo.product.app.ProductPhysicalByIdBatchVo;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 产品
 *
 * @author liurenkai
 * @time 2018/2/28 16:25
 */
@Api(tags = "产品")
@RestController
@RequestMapping(value = "productPhysical")
public class ProductPhysicalApiController {
    @Resource
    private ProductPhysicalFeign productPhysicalFeign;

    /**
     * 分页查询产品
     *
     * @param pageNo          分页索引
     * @param pageSize        每页显示数量
     * @param productPhysical 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "分页查询产品")
    @PostMapping("/front/findByPage")
    public ResponseMessage<PageInfo<ProductPhysical>> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                         @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                         @ApiParam(value = "查询条件") @RequestBody ProductPhysical productPhysical) {
        return this.productPhysicalFeign.findByPageForFront(pageNo, pageSize, productPhysical);
    }

    /**
     * 根据分类分页查询产品
     *
     * @param pageNo                      分页索引
     * @param pageSize                    每页显示数量
     * @param productPhysicalByCategoryVo 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "根据分类分页查询产品")
    @PostMapping("/findByPageForCategory")
    public ResponseMessage<PageInfo<ProductPhysical>> findByPageForCategory(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                            @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                            @ApiParam(value = "查询条件") @RequestBody ProductPhysicalByCategoryVo productPhysicalByCategoryVo) {
        return this.productPhysicalFeign.findByPageForCategory(pageNo, pageSize, productPhysicalByCategoryVo);
    }

    /**
     * 产品详情
     *
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "产品详情")
    @GetMapping("/detail/{id}")
    public ResponseMessage<ProductPhysical> detail(@ApiParam(value = "产品ID") @PathVariable(value = "id") int id) {
        return this.productPhysicalFeign.detail(id);
    }

    /**
     * 产品库存检查
     *
     * @param inventoryForBeauticianVo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "产品库存检查")
    @PostMapping("/inventoryCheck")
    public ResponseMessage inventoryCheck(@ApiParam(value = "查询条件") @RequestBody PhysicalByInventoryForBeauticianVo inventoryForBeauticianVo) {
        return this.productPhysicalFeign.inventoryCheck(inventoryForBeauticianVo);
    }

    /**
     * 批量根据ID查询产品
     *
     * @param productPhysicalByIdBatchVo 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "批量根据ID查询产品")
    @PostMapping("/findListByIdBatch")
    public ResponseMessage<List<ProductPhysical>> findListByIdBatch(@ApiParam(value = "查询条件") @RequestBody ProductPhysicalByIdBatchVo productPhysicalByIdBatchVo) {
        return this.productPhysicalFeign.findListByIdBatch(productPhysicalByIdBatchVo);
    }

    /**
     * 计算运费
     *
     * @param calcFreightVo 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "计算运费")
    @PostMapping("/calcFreight")
    public ResponseMessage<Integer> calcFreight(@ApiParam(value = "查询条件") @RequestBody ProductPhysicalByCalcFreightVo calcFreightVo) {
        return this.productPhysicalFeign.calcFreight(calcFreightVo);
    }

}