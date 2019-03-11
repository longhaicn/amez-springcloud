package com.union.aimei.pc.product.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.product.Product;
import com.union.aimei.common.vo.common.IdBatchVo;
import com.union.aimei.common.vo.product.pc.*;
import com.union.aimei.pc.product.service.ProductService;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品
 *
 * @author liurenkai
 * @time 2018/1/5 14:08
 */
@Api(tags = "商品")
@RestController
@RequestMapping(value = "product")
public class ProductController {
    @Resource
    private ProductService productService;

    @PostMapping("/front/findByPage")
    public PageInfo<Product> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                @ApiParam(value = "查询条件") @RequestBody Product product) {
        return this.productService.findByPageForFront(pageNo, pageSize, product);
    }

    /**
     * 新增商品
     *
     * @param product
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "新增商品")
    @PostMapping("/add")
    public ResponseMessage<Product> add(@RequestBody Product product) {
        return this.productService.add(product);
    }

    /**
     * 修改商品
     *
     * @param product
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "修改商品")
    @PutMapping("/modify")
    public ResponseMessage modify(@RequestBody Product product) {
        return this.productService.modify(product);
    }

    /**
     * 保存门店自营项目
     *
     * @param addVo 条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "保存门店自营项目")
    @PostMapping("/add/storeSelf")
    public ResponseMessage addStoreSelf(@ApiParam(value = "保存门店自营项目") @RequestBody ProductStoreSelfAddVo addVo) {
        return this.productService.addStoreSelf(addVo);
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
        return this.productService.addBrand(addVo);
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
        return this.productService.addPlatformSelf(addVo);
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
        return this.productService.modifyStoreSelf(modifyVo);
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
        return this.productService.modifyBrand(modifyVo);
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
        return this.productService.modifyPlatformSelf(modifyVo);
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
        return this.productService.detailByStoreSelf(productId, storeId);
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
        return this.productService.detailByBrand(productId);
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
        return this.productService.detailByPlatformSelf(productId);
    }


    /**
     * 商品上架（店铺）
     *
     * @param productByOnSaleVo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "商品上架（店铺）")
    @PostMapping(value = "/store/onSale")
    public ResponseMessage storeByOnSale(@ApiParam(value = "查询条件") @RequestBody ProductByOnSaleVo productByOnSaleVo) {
        return this.productService.storeByOnSale(productByOnSaleVo);
    }

    /**
     * 商品下架（店铺）
     *
     * @param productByOffShelvesVo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "商品下架（店铺）")
    @PostMapping(value = "/store/offShelves")
    public ResponseMessage storeByOffShelves(@ApiParam(value = "查询条件") @RequestBody ProductByOffShelvesVo productByOffShelvesVo) {
        return this.productService.storeByOffShelves(productByOffShelvesVo);
    }

    /**
     * 商品上架
     *
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "商品上架")
    @GetMapping(value = "/onSale/{id}")
    public ResponseMessage onSale(@ApiParam(value = "ID") @PathVariable(value = "id") int id) {
        return this.productService.onSale(id);
    }

    /**
     * 商品下架
     *
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "商品下架")
    @GetMapping(value = "/offShelves/{id}")
    public ResponseMessage offShelves(@ApiParam(value = "ID") @PathVariable(value = "id") int id) {
        return this.productService.offShelves(id);
    }

    /**
     * 商品审核
     *
     * @param id          ID
     * @param auditStatus 审核状态  0,待审核  1,已审核 2,不通过
     * @param auditReason 审核原因
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "商品审核")
    @PutMapping(value = "/modify/auditStatus/{id}/{auditStatus}")
    public ResponseMessage modifySaleStatusBySelf(@ApiParam(value = "ID") @PathVariable(value = "id") int id,
                                                  @ApiParam(value = "审核状态  0,待审核  1,已审核 2,不通过") @PathVariable(value = "auditStatus") int auditStatus,
                                                  @ApiParam(value = "审核原因") @RequestParam(value = "auditReason") String auditReason) {
        return this.productService.modifyAuditStatus(id, auditStatus, auditReason);
    }

    /**
     * 根据品牌分页查询商品
     *
     * @param pageNo           分页索引
     * @param pageSize         每页数量
     * @param productByBrandVo 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "根据品牌分页查询商品")
    @PostMapping("/findByPageForBrand")
    public ResponseMessage<PageInfo<Product>> findByPageForBrand(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                 @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                 @ApiParam(value = "查询条件") @RequestBody ProductByBrandVo productByBrandVo) {
        return this.productService.findByPageForBrand(pageNo, pageSize, productByBrandVo);
    }

    /**
     * 根据品牌ID查询商品
     *
     * @param brandId 品牌ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据品牌ID查询商品")
    @GetMapping("/findListByBrandId/{brandId}")
    public ResponseMessage<List<Product>> findListByBrandId(@ApiParam(value = "品牌ID") @PathVariable(value = "brandId") Integer brandId) {
        return this.productService.findListByBrandId(brandId);
    }

    /**
     * 分页查询商品（会员卡）
     *
     * @param pageNo                分页索引
     * @param pageSize              每页数量
     * @param productByMemberCardVo 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "分页查询商品（会员卡）")
    @PostMapping("/findByPageForMemberCard")
    public ResponseMessage<PageInfo<ProductByMemberCardResultVo>> findByPageForMemberCard(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                          @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                          @ApiParam(value = "查询条件") @RequestBody ProductByMemberCardVo productByMemberCardVo) {
        return this.productService.findByPageForMemberCard(pageNo, pageSize, productByMemberCardVo);
    }

    /**
     * 分页查询商品（店铺）
     *
     * @param pageNo   分页索引
     * @param pageSize 每页数量
     * @param storeVo  查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "分页查询商品（店铺）")
    @PostMapping("/findByPageForStore")
    public ResponseMessage<PageInfo<Product>> findByPageForStore(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                 @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                 @ApiParam(value = "查询条件") @RequestBody ProByStoreVo storeVo) {
        return this.productService.findByPageForStore(pageNo, pageSize, storeVo);
    }

    /**
     * 待审核商品统计
     *
     * @param dataCountVo 条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "待审核商品统计")
    @PostMapping("/pending/count")
    public ResponseMessage<Integer> pendingByCount(@ApiParam(value = "条件") @RequestBody StoreByDataCountVo dataCountVo) {
        return this.productService.pendingByCount(dataCountVo);
    }

    /**
     * 新增商品统计
     *
     * @param dataCountVo 条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "新增商品统计")
    @PostMapping("/add/count")
    public ResponseMessage<Integer> addByCount(@ApiParam(value = "条件") @RequestBody StoreByDataCountVo dataCountVo) {
        return this.productService.addByCount(dataCountVo);
    }

    /**
     * 根据店铺ID查询商品
     *
     * @param storeId 店铺ID
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "根据店铺ID查询商品")
    @PostMapping("/findListByStoreId/{storeId}")
    public ResponseMessage<List<Product>> findByPageForSelect(@ApiParam(value = "店铺ID") @PathVariable(value = "storeId") int storeId) {
        return this.productService.findListByStoreId(storeId);
    }


    /**
     * 批量根据ID查询商品
     *
     * @param idBatchVo 批量ID
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "批量根据ID查询商品")
    @PostMapping("/findListByIdBatch")
    public ResponseMessage<List<Product>> findListByIdBatch(@ApiParam(value = "批量ID") @RequestBody IdBatchVo idBatchVo) {
        return this.productService.findListByIdBatch(idBatchVo);
    }

    /**
     * 批量商品标签
     *
     * @param labelBatchVo 批量商品标签
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "批量商品标签")
    @PutMapping(value = "/label/batch")
    public ResponseMessage labelByBatch(@ApiParam(value = "批量商品标签") @RequestBody ProByLabelBatchVo labelBatchVo) {
        return this.productService.labelByBatch(labelBatchVo);
    }

    /**
     * 分页查询商品（商品标签）
     *
     * @param pageNo   分页索引
     * @param pageSize 每页数量
     * @param labelVo  查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "分页查询商品（商品标签）")
    @PostMapping("/findByPageForLabel")
    public ResponseMessage<PageInfo<Product>> findByPageForLabel(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                 @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                 @ApiParam(value = "查询条件") @RequestBody ProByLabelVo labelVo) {
        return this.productService.findByPageForLabel(pageNo, pageSize, labelVo);
    }

    /**
     * 查询店铺商品（店铺优惠券）
     *
     * @param productByStoreCouponsVo 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "查询店铺商品（店铺优惠券）")
    @PostMapping(value = "/findByPageForStoreCoupons")
    public ResponseMessage<ProductByStoreCouponsResultVo> findByPageForStoreCoupons(@ApiParam(value = "查询条件") @RequestBody ProductByStoreCouponsVo productByStoreCouponsVo) {
        return this.productService.findByPageForStoreCoupons(productByStoreCouponsVo);
    }


    /**
     * 批量根据ID查询 项目-分类的关联数据(v1.1.0)
     *
     * @param idBatchVo 批量ID
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "批量根据ID查询 项目-分类的关联数据(v1.1.0)")
    @PostMapping("/1.1.0/findProductCategoryRefListByIdBatch")
    public ResponseMessage<List<ProductByCategoryRefVo>> findProductCategoryRefListByIdBatchV110(@ApiParam(value = "批量ID") @RequestBody IdBatchVo idBatchVo) {
        return this.productService.findProductCategoryRefListByIdBatchV110(idBatchVo);
    }

    /**
     * 批量根据ID查询 所有未删除的项目id(v1.1.0)
     *
     * @param idBatchVo 批量ID
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "批量根据ID查询 所有未删除的项目id(v1.1.0)")
    @PostMapping("/1.1.0/findIsEnableIdListByIdBatch")
    public ResponseMessage<List<Integer>> findIsEnableIdListByIdBatchV110(@ApiParam(value = "批量ID") @RequestBody IdBatchVo idBatchVo) {
        return this.productService.findIsEnableIdListByIdBatchV110(idBatchVo);
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
        return this.productService.listManage(pageNo, pageSize, manageVo);
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
        return this.productService.removeById(id);
    }

    /**
     * 根据门店ID查询项目列表
     *
     * @param storeId 门店ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据门店ID查询项目列表")
    @GetMapping("/listByStoreId/{id}")
    public ResponseMessage<List<Product>> listByStoreId(@ApiParam(value = "门店ID") @PathVariable(value = "storeId") int storeId) {
        return this.productService.listByStoreId(storeId);
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
        return this.productService.listStoreHomeFloor(pageNo, pageSize, homeFloorVo);
    }

    /**
     * 根据优惠券ID分页查询项目
     *
     * @param pageNo    分页索引
     * @param pageSize  每页数量
     * @param couponsId 优惠券ID
     * @return
     */
    @PostMapping("/findByPageForCouponsId/{couponsId}")
    public ResponseMessage<PageInfo<Product>> findByPageForCouponsId(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                     @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                     @ApiParam(value = "优惠券ID") @PathVariable(value = "couponsId") int couponsId) {
        return this.productService.findByPageForCouponsId(pageNo, pageSize, couponsId);
    }

}