package com.union.aimei.pc.api.product;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.product.ProductFeign;
import com.union.aimei.common.model.product.Product;
import com.union.aimei.common.vo.product.pc.*;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 项目
 *
 * @author liurenkai
 * @time 2018/1/5 19:25
 */
@Api(tags = "项目")
@RestController
@RequestMapping(value = "product")
public class ProductApiController {
    @Resource
    private ProductFeign productFeign;

    /**
     * 保存门店自营项目
     *
     * @param addVo 条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "保存门店自营项目")
    @PostMapping("/add/storeSelf")
    public ResponseMessage addStoreSelf(@ApiParam(value = "保存门店自营项目") @RequestBody ProductStoreSelfAddVo addVo) {
        return this.productFeign.addStoreSelf(addVo);
    }

    /**
     * 保存品牌项目
     *
     * @param addVo 条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "保存品牌项目")
    @PostMapping("/add/brand")
    public ResponseMessage addBrand(@ApiParam(value = "保存品牌项目") @RequestBody ProductBrandAddVo addVo) {
        return this.productFeign.addBrand(addVo);
    }

    /**
     * 保存平台自营项目
     *
     * @param addVo 条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "保存平台自营项目")
    @PostMapping("/add/platformSelf")
    public ResponseMessage addPlatformSelf(@ApiParam(value = "保存平台自营项目") @RequestBody ProductPlatformSelfAddVo addVo) {
        return this.productFeign.addPlatformSelf(addVo);
    }

    /**
     * 修改门店自营项目
     *
     * @param modifyVo 条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "修改门店自营项目")
    @PostMapping("/modify/storeSelf")
    public ResponseMessage modifyStoreSelf(@ApiParam(value = "修改门店自营项目") @RequestBody ProductStoreSelfModifyVo modifyVo) {
        return this.productFeign.modifyStoreSelf(modifyVo);
    }

    /**
     * 修改品牌项目
     *
     * @param modifyVo 条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "修改品牌项目")
    @PostMapping("/modify/brand")
    public ResponseMessage modifyBrand(@ApiParam(value = "修改品牌项目") @RequestBody ProductBrandModifyVo modifyVo) {
        return this.productFeign.modifyBrand(modifyVo);
    }

    /**
     * 修改平台自营项目
     *
     * @param modifyVo 条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "修改平台自营项目")
    @PostMapping("/modify/platformSelf")
    public ResponseMessage modifyPlatformSelf(@ApiParam(value = "修改平台自营项目") @RequestBody ProductPlatformSelfModifyVo modifyVo) {
        return this.productFeign.modifyPlatformSelf(modifyVo);
    }

    /**
     * 门店自营项目详情
     *
     * @param storeId   门店ID
     * @param productId 项目ID
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "门店自营项目详情")
    @PostMapping("/detail/storeSelf/{productId}/{storeId}")
    public ResponseMessage<ProductByDetailResVo> detailByStoreSelf(@ApiParam(value = "项目ID") @PathVariable(value = "productId") int productId,
                                                                   @ApiParam(value = "门店ID") @PathVariable(value = "storeId") int storeId) {
        return this.productFeign.detailByStoreSelf(productId, storeId);
    }

    /**
     * 品牌项目详情
     *
     * @param productId 项目ID
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "品牌项目详情")
    @PostMapping("/detail/brand/{productId}")
    public ResponseMessage<ProductByDetailResVo> detailByBrand(@ApiParam(value = "项目ID") @PathVariable(value = "productId") int productId) {
        return this.productFeign.detailByBrand(productId);
    }

    /**
     * 平台自营项目详情
     *
     * @param productId 项目ID
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "平台自营项目详情")
    @PostMapping("/detail/platformSelf/{productId}")
    public ResponseMessage<ProductByDetailResVo> detailByPlatformSelf(@ApiParam(value = "项目ID") @PathVariable(value = "productId") int productId) {
        return this.productFeign.detailByPlatformSelf(productId);
    }

    /**
     * 项目上架（店铺）
     *
     * @param productByOnSaleVo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "项目上架（店铺）")
    @PostMapping(value = "/store/onSale")
    public ResponseMessage storeByOnSale(@ApiParam(value = "查询条件") @RequestBody ProductByOnSaleVo productByOnSaleVo) {
        return this.productFeign.storeByOnSale(productByOnSaleVo);
    }

    /**
     * 项目下架（店铺）
     *
     * @param productByOffShelvesVo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "项目下架（店铺）")
    @PostMapping(value = "/store/offShelves")
    public ResponseMessage storeByOffShelves(@ApiParam(value = "查询条件") @RequestBody ProductByOffShelvesVo productByOffShelvesVo) {
        return this.productFeign.storeByOffShelves(productByOffShelvesVo);
    }

    /**
     * 项目上架
     *
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "项目上架")
    @GetMapping(value = "/onSale/{id}")
    public ResponseMessage onSale(@ApiParam(value = "ID") @PathVariable(value = "id") int id) {
        return this.productFeign.onSale(id);
    }

    /**
     * 项目下架
     *
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "项目下架")
    @GetMapping(value = "/offShelves/{id}")
    public ResponseMessage offShelves(@ApiParam(value = "ID") @PathVariable(value = "id") int id) {
        return this.productFeign.offShelves(id);
    }

    /**
     * 项目审核
     *
     * @param id          ID
     * @param auditStatus 审核状态  0,待审核  1,已审核 2,不通过
     * @param auditReason 审核原因
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "项目审核")
    @PutMapping(value = "/modify/auditStatus/{id}/{auditStatus}")
    public ResponseMessage modifySaleStatusBySelf(@ApiParam(value = "ID") @PathVariable(value = "id") int id,
                                                  @ApiParam(value = "审核状态  0,待审核  1,已审核 2,不通过") @PathVariable(value = "auditStatus") int auditStatus,
                                                  @ApiParam(value = "审核原因") @RequestParam(value = "auditReason") String auditReason) {
        return this.productFeign.modifyAuditStatus(id, auditStatus, auditReason);
    }

    /**
     * 根据品牌分页查询项目
     *
     * @param pageNo           分页索引
     * @param pageSize         每页数量
     * @param productByBrandVo 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "根据品牌分页查询项目")
    @PostMapping("/findByPageForBrand")
    public ResponseMessage<PageInfo<Product>> findByPageForBrand(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                 @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                 @ApiParam(value = "查询条件") @RequestBody ProductByBrandVo productByBrandVo) {
        return this.productFeign.findByPageForBrand(pageNo, pageSize, productByBrandVo);
    }

    /**
     * 根据品牌ID查询项目
     *
     * @param brandId 品牌ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据品牌ID查询项目")
    @GetMapping("/findListByBrandId/{brandId}")
    public ResponseMessage<List<Product>> findListByBrandId(@ApiParam(value = "品牌ID") @PathVariable(value = "brandId") Integer brandId) {
        return this.productFeign.findListByBrandId(brandId);
    }

    /**
     * 分页查询项目（会员卡）
     *
     * @param pageNo                分页索引
     * @param pageSize              每页数量
     * @param productByMemberCardVo 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "分页查询项目（会员卡）")
    @PostMapping("/findByPageForMemberCard")
    public ResponseMessage<PageInfo<ProductByMemberCardResultVo>> findByPageForMemberCard(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                          @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                          @ApiParam(value = "查询条件") @RequestBody ProductByMemberCardVo productByMemberCardVo) {
        return this.productFeign.findByPageForMemberCard(pageNo, pageSize, productByMemberCardVo);
    }

    /**
     * 分页查询项目（店铺）
     *
     * @param pageNo   分页索引
     * @param pageSize 每页数量
     * @param storeVo  查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "分页查询项目（店铺）")
    @PostMapping("/findByPageForStore")
    public ResponseMessage<PageInfo<Product>> findByPageForStore(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                 @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                 @ApiParam(value = "查询条件") @RequestBody ProductByStoreVo storeVo) {
        return this.productFeign.findByPageForStore(pageNo, pageSize, storeVo);
    }

    /**
     * 批量项目标签
     *
     * @param labelBatchVo
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "批量项目标签")
    @PutMapping(value = "/label/batch")
    public ResponseMessage labelByBatch(@ApiParam(value = "批量项目标签") @RequestBody ProductByLabelBatchVo labelBatchVo) {
        return this.productFeign.labelByBatch(labelBatchVo);
    }

    /**
     * 分页查询项目（项目标签）
     *
     * @param pageNo   分页索引
     * @param pageSize 每页数量
     * @param labelVo  查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "分页查询项目（项目标签）")
    @PostMapping("/findByPageForLabel")
    public ResponseMessage<PageInfo<Product>> findByPageForLabel(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                 @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                 @ApiParam(value = "查询条件") @RequestBody ProductByLabelVo labelVo) {
        return this.productFeign.findByPageForLabel(pageNo, pageSize, labelVo);
    }

    /**
     * 查询店铺项目（店铺优惠券）
     *
     * @param productByStoreCouponsVo 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "查询店铺项目（店铺优惠券）")
    @PostMapping(value = "/findByPageForStoreCoupons")
    public ResponseMessage<ProductByStoreCouponsResultVo> findByPageForStoreCoupons(@ApiParam(value = "查询条件") @RequestBody ProductByStoreCouponsVo productByStoreCouponsVo) {
        return this.productFeign.findByPageForStoreCoupons(productByStoreCouponsVo);
    }

    /**
     * 根据优惠券ID分页查询项目
     *
     * @param pageNo    分页索引
     * @param pageSize  每页数量
     * @param couponsId 优惠券ID
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "根据优惠券ID分页查询项目")
    @PostMapping("/findByPageForCouponsId/{couponsId}")
    public ResponseMessage<PageInfo<Product>> findByPageForCouponsId(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                     @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                     @ApiParam(value = "优惠券ID") @PathVariable(value = "couponsId") int couponsId) {
        return this.productFeign.findByPageForCouponsId(pageNo, pageSize, couponsId);
    }

    /**
     * 项目管理分页查询项目
     *
     * @param pageNo   分页索引
     * @param pageSize 每页数量
     * @param manageVo 条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "项目管理分页查询项目")
    @PostMapping("/listManage")
    public ResponseMessage<PageInfo<Product>> listManage(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                         @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                         @ApiParam(value = "条件") @RequestBody ProductByManageVo manageVo) {
        return this.productFeign.listManage(pageNo, pageSize, manageVo);
    }

    /**
     * 根据ID删除项目
     *
     * @param id ID
     * @return
     */
    @ApiOperation(httpMethod = "DELETE", value = "根据ID删除项目")
    @DeleteMapping("/removeById/{id}")
    public ResponseMessage removeById(@ApiParam(value = "ID") @PathVariable(value = "id") int id) {
        return this.productFeign.removeById(id);
    }

    /**
     * 查询首页楼层到店项目列表
     *
     * @param pageNo      分页索引
     * @param pageSize    每页数量
     * @param homeFloorVo 条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "查询首页楼层到店项目列表")
    @PostMapping("/listStoreHomeFloor")
    public ResponseMessage<PageInfo<Product>> listStoreHomeFloor(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                 @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                 @ApiParam(value = "条件") @RequestBody ProductListStoreHomeFloorVo homeFloorVo) {
        return this.productFeign.listStoreHomeFloor(pageNo, pageSize, homeFloorVo);
    }

}