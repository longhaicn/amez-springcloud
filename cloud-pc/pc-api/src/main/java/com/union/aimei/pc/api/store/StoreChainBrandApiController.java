package com.union.aimei.pc.api.store;

import com.union.aimei.common.model.store.StoreChainBrand;
import com.union.aimei.common.feign.pc.store.StoreChainBrandFeign;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 门店连锁品牌
 *
 * @author liurenkai
 * @time 2018/1/12 17:34
 */
@Api(tags = "门店连锁品牌")
@RestController
@RequestMapping(value = "storeChainBrand")
public class StoreChainBrandApiController {
    @Resource
    private StoreChainBrandFeign storeChainBrandFeign;

    /**
     * 分页查询
     *
     * @param pageNo          分页索引
     * @param pageSize        每页显示数量
     * @param storeChainBrand 查询条件
     * @return ResponseMessage<StoreChainBrand>
     */
    @ApiOperation(httpMethod = "POST", value = "前端分页查询门店连锁品牌")
    @PostMapping("/front/findByPage")
    public ResponseMessage<StoreChainBrand> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0")
                                                                       Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10")
                                                                       Integer pageSize, @ApiParam(value = "查询条件") @RequestBody StoreChainBrand storeChainBrand) {
        return new ResponseMessage(this.storeChainBrandFeign.findByPageForFront (pageNo, pageSize, storeChainBrand));
    }

    /**
     * 添加StoreChainBrand
     *
     * @param storeChainBrand
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "添加门店连锁品牌")
    @PostMapping("/insert")
    public ResponseMessage insert(@RequestBody StoreChainBrand storeChainBrand) {
        return new ResponseMessage(this.storeChainBrandFeign.insertLimitBrandOwnershipCompany (storeChainBrand));
    }

    /**
     * 删除StoreChainBrand
     *
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "DELETE", value = "删除门店连锁品牌")
    @DeleteMapping("/deleteById/{id}")
    public ResponseMessage deleteById(@PathVariable(value = "id") int id) {
        return new ResponseMessage(this.storeChainBrandFeign.deleteById (id));
    }

    /**
     * 修改StoreChainBrand
     *
     * @param storeChainBrand
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "编辑门店连锁品牌")
    @PutMapping("/edit")
    public ResponseMessage edit(@RequestBody StoreChainBrand storeChainBrand) {
        return new ResponseMessage(this.storeChainBrandFeign.editLimitBrandOwnershipCompany (storeChainBrand));
    }

    /**
     * 根据ID查询StoreChainBrand
     *
     * @param id
     * @returnstoreChainBrand
     */
    @ApiOperation(httpMethod = "GET", value = "通过ID查询门店连锁品牌")
    @GetMapping("/queryById/{id}")
    public ResponseMessage<StoreChainBrand> queryById(@PathVariable(value = "id") int id) {
        return new ResponseMessage(this.storeChainBrandFeign.queryById (id));
    }

    /**
     * 判断校验品牌名字是否重复
     *
     * @param brandName
     * @param brandId
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "判断校验品牌名字是否重复")
    @GetMapping("/findLimitBrandCompany/{brandName}/{brandId}")
    public ResponseMessage findLimitBrandCompany(@PathVariable(value = "brandName") String brandName, @PathVariable(value = "brandId") Integer brandId) {
        return new ResponseMessage(this.storeChainBrandFeign.findLimitBrandCompany (brandName, brandId));
    }

}