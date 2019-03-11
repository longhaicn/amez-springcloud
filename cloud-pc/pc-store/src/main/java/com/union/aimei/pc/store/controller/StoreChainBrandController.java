package com.union.aimei.pc.store.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreBeautician;
import com.union.aimei.common.model.store.StoreChainBrand;
import com.union.aimei.pc.store.service.StoreChainBrandService;
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
public class StoreChainBrandController {
    @Resource
    private StoreChainBrandService storeChainBrandService;

    @PostMapping("/front/findByPage")
    public PageInfo<StoreChainBrand> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0")
                                                                Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10")
                                                                Integer pageSize, @ApiParam(value = "查询条件") @RequestBody StoreChainBrand storeChainBrand) {
        return this.storeChainBrandService.findByPageForFront (pageNo, pageSize, storeChainBrand);
    }

    @PostMapping("/insert")
    public int insert(@RequestBody StoreChainBrand storeChainBrand) {
        return this.storeChainBrandService.addObj (storeChainBrand);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable(value = "id") int id) {
        return this.storeChainBrandService.deleteObjById (id);
    }

    @PutMapping("/edit")
    public int edit(@RequestBody StoreChainBrand storeChainBrand) {
        return this.storeChainBrandService.modifyObj (storeChainBrand);
    }

    @GetMapping("/queryById/{id}")
    public StoreChainBrand queryById(@PathVariable(value = "id") int id) {
        return this.storeChainBrandService.queryObjById (id);
    }


    /**
     * 根据品牌ID累积店铺总数
     *
     * @param brandId 品牌ID
     * @param number  累积数
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "根据品牌ID累积店铺总数")
    @PutMapping("/accumStoreTotalByBrandId/{brandId}/{number}")
    public ResponseMessage accumStoreTotalByBrandId(@ApiParam(value = "品牌ID") @PathVariable(value = "brandId") int brandId,
                                                    @ApiParam(value = "累积数") @PathVariable(value = "number") int number) {
        return this.storeChainBrandService.accumStoreTotalByBrandId (brandId, number);
    }

    /**
     * 根据品牌ID累积商品总数
     *
     * @param brandId 品牌ID
     * @param number  累积数
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "根据品牌ID累积商品总数")
    @PutMapping("/accumProductTotalByBrandId/{brandId}/{number}")
    public ResponseMessage accumProductTotalByBrandId(@ApiParam(value = "品牌ID") @PathVariable(value = "brandId") int brandId,
                                                      @ApiParam(value = "累积数") @PathVariable(value = "number") int number) {
        return this.storeChainBrandService.accumProductTotalByBrandId (brandId, number);
    }


    /**
     * 新增门店连锁品牌, 限定 品牌所属公司下的所有品牌名称不可重复
     *
     * @param storeChainBrand
     * @return
     */
    @PostMapping("/insertLimitBrandOwnershipCompany")
    public ResponseMessage insertLimitBrandOwnershipCompany(@RequestBody StoreChainBrand storeChainBrand) {
        return this.storeChainBrandService.insertLimitBrandOwnershipCompany (storeChainBrand);
    }


    /**
     * 修改门店连锁品牌, 限定 品牌所属公司下的所有品牌名称不可重复
     *
     * @param storeChainBrand
     * @return
     */
    @PostMapping("/editLimitBrandOwnershipCompany")
    public ResponseMessage editLimitBrandOwnershipCompany(@RequestBody StoreChainBrand storeChainBrand) {
        return this.storeChainBrandService.editLimitBrandOwnershipCompany (storeChainBrand);
    }

    /**
     * 判断校验品牌名字是否重复
     *
     * @param brandName 品牌名
     * @param brandId   品牌id
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "判断校验品牌名字是否重复")
    @GetMapping("/findLimitBrandCompany/{brandName}/{brandId}")
    public ResponseMessage findLimitBrandCompany(@ApiParam(value = "品牌名") @PathVariable(value = "brandName") String brandName,
                                                 @ApiParam(value = "品牌id") @PathVariable(value = "brandId") int brandId) {
        return this.storeChainBrandService.findLimitBrandCompany (brandName, brandId);
    }


}