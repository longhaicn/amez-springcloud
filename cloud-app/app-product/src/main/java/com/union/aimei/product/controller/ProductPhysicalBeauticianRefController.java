package com.union.aimei.product.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.product.ProductPhysicalBeauticianRef;
import com.union.aimei.common.vo.product.app.PhysicalBeauticianRefListInventoryByProductIdVo;
import com.union.aimei.common.vo.product.app.ProductPhysicalBeauticianRefByBeauticianIdResVo;
import com.union.aimei.common.vo.product.app.ProductPhysicalBeauticianRefByFindVo;
import com.union.aimei.product.service.ProductPhysicalBeauticianRefService;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 产品-美容师-关联
 *
 * @author liurenkai
 * @time 2018/2/28 16:07
 */
@Api(tags = "产品-美容师-关联")
@RestController
@RequestMapping(value = "productPhysicalBeauticianRef")
public class ProductPhysicalBeauticianRefController {
    @Resource
    private ProductPhysicalBeauticianRefService productPhysicalBeauticianRefService;

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
        return this.productPhysicalBeauticianRefService.findByPageForFront(pageNo, pageSize, productPhysicalBeauticianRef);
    }

    @PostMapping("/insert")
    public int insert(@RequestBody ProductPhysicalBeauticianRef productPhysicalBeauticianRef) {
        return this.productPhysicalBeauticianRefService.addObj(productPhysicalBeauticianRef);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable(value = "id") int id) {
        return this.productPhysicalBeauticianRefService.deleteObjById(id);
    }

    @PutMapping("/edit")
    public int edit(@RequestBody ProductPhysicalBeauticianRef productPhysicalBeauticianRef) {
        return this.productPhysicalBeauticianRefService.modifyObj(productPhysicalBeauticianRef);
    }

    @GetMapping("/queryById/{id}")
    public ProductPhysicalBeauticianRef queryById(@PathVariable(value = "id") int id) {
        return this.productPhysicalBeauticianRefService.queryObjById(id);
    }

    /**
     * 产品-美容师-关联查询
     *
     * @param productPhysicalBeauticianRefByFindVo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "产品-美容师-关联查询")
    @PostMapping("/find")
    public ResponseMessage<ProductPhysicalBeauticianRef> find(@ApiParam(value = "查询条件") @RequestBody ProductPhysicalBeauticianRefByFindVo productPhysicalBeauticianRefByFindVo) {
        return this.productPhysicalBeauticianRefService.find(productPhysicalBeauticianRefByFindVo);
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
        return this.productPhysicalBeauticianRefService.findByPageForBeauticianId(pageNo, pageSize, beauticianId);
    }

    /**
     * 根据项目ID查询存在可消耗库存的产品-美容师-关联列表
     *
     * @param productIdVo 条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "根据项目ID查询存在可消耗库存的产品-美容师-关联列表")
    @PostMapping("/1.1.1/listInventoryByProductId")
    public ResponseMessage<List<ProductPhysicalBeauticianRef>> listInventoryByProductIdV111(@ApiParam(value = "条件") @RequestBody PhysicalBeauticianRefListInventoryByProductIdVo productIdVo) {
        return this.productPhysicalBeauticianRefService.listInventoryByProductIdV111(productIdVo);
    }

}