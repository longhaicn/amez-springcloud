package com.union.aimei.common.feign.pc.product;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.product.hystrix.ProductApiHystrix;
import com.union.aimei.common.model.product.Product;
import com.union.aimei.common.vo.common.IdBatchVo;
import com.union.aimei.common.vo.product.pc.*;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 项目
 *
 * @author liurenkai
 * @time 2018/1/5 19:16
 */
@FeignClient(serviceId = "PC-PRODUCT-SERVICE", fallback = ProductApiHystrix.class)
public interface ProductFeign {

    /**
     * 保存项目
     *
     * @param product
     * @return
     */
    @PostMapping("/product/add")
    ResponseMessage<Product> add(@RequestBody Product product);

    /**
     * 修改项目
     *
     * @param product 项目
     * @return
     */
    @PutMapping("/product/modify")
    ResponseMessage modify(@RequestBody Product product);

    /**
     * 保存门店自营项目
     *
     * @param addVo 条件
     * @return
     */
    @PostMapping("/product/add/storeSelf")
    ResponseMessage<Product> addStoreSelf(@RequestBody ProductStoreSelfAddVo addVo);

    /**
     * 保存品牌项目
     *
     * @param addVo 条件
     * @return
     */
    @PostMapping("/product/add/brand")
    ResponseMessage<Product> addBrand(@RequestBody ProductBrandAddVo addVo);


    /**
     * 保存平台自营项目
     *
     * @param addVo 条件
     * @return
     */
    @PostMapping("/product/add/platformSelf")
    ResponseMessage<Product> addPlatformSelf(@RequestBody ProductPlatformSelfAddVo addVo);

    /**
     * 修改门店自营项目
     *
     * @param modifyVo 条件
     * @return
     */
    @PostMapping("/product/modify/storeSelf")
    ResponseMessage<Product> modifyStoreSelf(@RequestBody ProductStoreSelfModifyVo modifyVo);

    /**
     * 修改品牌项目
     *
     * @param modifyVo 条件
     * @return
     */
    @PostMapping("/product/modify/brand")
    ResponseMessage<Product> modifyBrand(@RequestBody ProductBrandModifyVo modifyVo);

    /**
     * 修改平台自营项目
     *
     * @param modifyVo 条件
     * @return
     */
    @PostMapping("/product/modify/platformSelf")
    ResponseMessage<Product> modifyPlatformSelf(@RequestBody ProductPlatformSelfModifyVo modifyVo);

    /**
     * 门店自营项目详情
     *
     * @param productId 项目ID
     * @param storeId   门店ID
     * @return
     */
    @PostMapping("/product/detail/storeSelf/{productId}/{storeId}")
    ResponseMessage<ProductByDetailResVo> detailByStoreSelf(@PathVariable(value = "productId") int productId,
                                                            @PathVariable(value = "storeId") int storeId);

    /**
     * 品牌项目详情
     *
     * @param productId 项目ID
     * @return
     */
    @PostMapping("/product/detail/brand/{productId}")
    ResponseMessage<ProductByDetailResVo> detailByBrand(@PathVariable(value = "productId") int productId);

    /**
     * 平台自营项目详情
     *
     * @param productId 项目ID
     * @return
     */
    @PostMapping("/product/detail/platformSelf/{productId}")
    ResponseMessage<ProductByDetailResVo> detailByPlatformSelf(@PathVariable(value = "productId") int productId);

    /**
     * 门店项目上架
     *
     * @param onSaleVo 条件
     * @return
     */
    @PostMapping(value = "/product/store/onSale")
    ResponseMessage storeByOnSale(@RequestBody ProductByOnSaleVo onSaleVo);

    /**
     * 门店项目下架
     *
     * @param offShelvesVo 条件
     * @return
     */
    @PostMapping(value = "/product/store/offShelves")
    ResponseMessage storeByOffShelves(@RequestBody ProductByOffShelvesVo offShelvesVo);

    /**
     * 项目上架
     *
     * @param id ID
     * @return
     */
    @GetMapping(value = "/product/onSale/{id}")
    ResponseMessage onSale(@PathVariable(value = "id") int id);

    /**
     * 项目下架
     *
     * @param id ID
     * @return
     */
    @GetMapping(value = "/product/offShelves/{id}")
    ResponseMessage offShelves(@PathVariable(value = "id") int id);

    /**
     * 项目审核
     *
     * @param id          ID
     * @param auditStatus 审核状态  0,待审核  1,已审核 2,不通过
     * @param auditReason 审核原因
     * @return
     */
    @PutMapping(value = "/product/modify/auditStatus/{id}/{auditStatus}")
    ResponseMessage modifyAuditStatus(@PathVariable(value = "id") int id,
                                      @PathVariable(value = "auditStatus") int auditStatus,
                                      @RequestParam(value = "auditReason") String auditReason);


    /**
     * 根据品牌分页查询项目
     *
     * @param pageNo   分页索引
     * @param pageSize 每页数量
     * @param brandVo  查询条件
     * @return
     */
    @PostMapping("/product/findByPageForBrand")
    ResponseMessage<PageInfo<Product>> findByPageForBrand(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                          @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                          @RequestBody ProductByBrandVo brandVo);

    /**
     * 根据品牌ID查询项目
     *
     * @param brandId 品牌ID
     * @return
     */
    @GetMapping("/product/findListByBrandId/{brandId}")
    ResponseMessage<List<Product>> findListByBrandId(@PathVariable(value = "brandId") Integer brandId);

    /**
     * 分页查询项目（会员卡）
     *
     * @param pageNo       分页索引
     * @param pageSize     每页数量
     * @param memberCardVo 条件
     * @return
     */
    @PostMapping("/product/findByPageForMemberCard")
    ResponseMessage<PageInfo<ProductByMemberCardResultVo>> findByPageForMemberCard(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                   @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                   @RequestBody ProductByMemberCardVo memberCardVo);

    /**
     * 分页查询项目（门店）
     *
     * @param pageNo   分页索引
     * @param pageSize 每页数量
     * @param storeVo  条件
     * @return
     */
    @PostMapping("/product/findByPageForStore")
    ResponseMessage<PageInfo<Product>> findByPageForStore(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                          @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                          @RequestBody ProductByStoreVo storeVo);

    /**
     * 待审核项目统计
     *
     * @param dataCountVo 条件
     * @return
     */
    @PostMapping("/product/pending/count")
    ResponseMessage<Integer> pendingByCount(@RequestBody StoreByDataCountVo dataCountVo);

    /**
     * 保存项目统计
     *
     * @param dataCountVo 条件
     * @return
     */
    @PostMapping("/product/add/count")
    ResponseMessage<Integer> addByCount(@RequestBody StoreByDataCountVo dataCountVo);

    /**
     * 根据门店ID查询项目
     *
     * @param storeId 门店ID
     * @return
     */
    @PostMapping("/product/findListByStoreId/{storeId}")
    ResponseMessage<List<Product>> findListByStoreId(@PathVariable(value = "storeId") int storeId);

    /**
     * 批量根据ID查询项目
     *
     * @param idBatchVo 批量ID
     * @return
     */
    @PostMapping("/product/findListByIdBatch")
    ResponseMessage<List<Product>> findListByIdBatch(@RequestBody IdBatchVo idBatchVo);

    /**
     * 批量项目标签
     *
     * @param labelBatchVo
     * @return
     */
    @PutMapping(value = "/product/label/batch")
    ResponseMessage labelByBatch(@RequestBody ProductByLabelBatchVo labelBatchVo);

    /**
     * 分页查询项目（项目标签）
     *
     * @param pageNo   分页索引
     * @param pageSize 每页数量
     * @param labelVo  查询条件
     * @return
     */
    @PostMapping("/product/findByPageForLabel")
    ResponseMessage<PageInfo<Product>> findByPageForLabel(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                          @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                          @RequestBody ProductByLabelVo labelVo);

    /**
     * 查询门店项目（门店优惠券）
     *
     * @param storeCouponsVo 条件
     * @return
     */
    @PostMapping(value = "/product/findByPageForStoreCoupons")
    ResponseMessage<ProductByStoreCouponsResultVo> findByPageForStoreCoupons(@RequestBody ProductByStoreCouponsVo storeCouponsVo);

    /**
     * 批量根据ID查询 项目-分类的关联数据(v1.1.0)
     *
     * @param idBatchVo 批量ID
     * @return
     */
    @PostMapping("/product/1.1.0/findProductCategoryRefListByIdBatch")
    ResponseMessage<List<ProductByCategoryRefVo>> findProductCategoryRefListByIdBatchV110(@RequestBody IdBatchVo idBatchVo);

    /**
     * 批量根据ID查询 所有未删除的项目id(v1.1.0)
     *
     * @param idBatchVo 批量ID
     * @return
     */
    @PostMapping("/product/1.1.0/findIsEnableIdListByIdBatch")
    ResponseMessage<List<Integer>> findIsEnableIdListByIdBatchV110(@ApiParam(value = "批量ID") @RequestBody IdBatchVo idBatchVo);

    /**
     * 项目管理分页查询项目
     *
     * @param pageNo   分页索引
     * @param pageSize 每页数量
     * @param manageVo 条件
     * @return
     */
    @PostMapping("/product/listManage")
    ResponseMessage<PageInfo<Product>> listManage(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                  @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                  @RequestBody ProductByManageVo manageVo);

    /**
     * 根据ID删除项目
     *
     * @param id ID
     * @return
     */
    @DeleteMapping("/product/removeById/{id}")
    ResponseMessage removeById(@PathVariable(value = "id") int id);

    /**
     * 查询首页楼层到店项目列表
     *
     * @param pageNo      分页索引
     * @param pageSize    每页数量
     * @param homeFloorVo 条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "查询首页楼层到店项目列表")
    @PostMapping("/product/listStoreHomeFloor")
    ResponseMessage<PageInfo<Product>> listStoreHomeFloor(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                          @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                          @RequestBody ProductListStoreHomeFloorVo homeFloorVo);

    /**
     * 根据店铺ID查询商品
     *
     * @param storeId 店铺ID
     * @return
     */
    @PostMapping("/product/findListByStoreId/{storeId}")
    ResponseMessage<List<Product>> findByPageForSelect(@ApiParam(value = "店铺ID") @PathVariable(value = "storeId") int storeId);

    /**
     * 根据优惠券ID分页查询项目
     *
     * @param pageNo    分页索引
     * @param pageSize  每页数量
     * @param couponsId 优惠券ID
     * @return
     */
    @PostMapping("/product/findByPageForCouponsId/{couponsId}")
    ResponseMessage<PageInfo<Product>> findByPageForCouponsId(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                              @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                              @ApiParam(value = "优惠券ID") @PathVariable(value = "couponsId") int couponsId);

}