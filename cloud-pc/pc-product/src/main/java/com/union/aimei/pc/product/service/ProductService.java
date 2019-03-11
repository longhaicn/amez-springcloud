package com.union.aimei.pc.product.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.product.Product;
import com.union.aimei.common.vo.common.IdBatchVo;
import com.union.aimei.common.vo.product.pc.*;
import com.union.common.utils.ResponseMessage;

import java.util.List;

/**
 * 项目
 *
 * @author liurenkai
 * @time 2018/1/5 12:07
 */
public interface ProductService {

    /**
     * 前端分页查询项目
     *
     * @param pageNo   分页索引
     * @param pageSize 每页显示数量
     * @param product  查询条件
     * @return
     */
    PageInfo<Product> findByPageForFront(Integer pageNo, Integer pageSize, Product product);

    /**
     * 新增项目
     *
     * @param product 项目
     * @return
     */
    ResponseMessage<Product> add(Product product);

    /**
     * 修改项目
     *
     * @param product
     * @return
     */
    ResponseMessage modify(Product product);

    /**
     * 保存门店自营项目
     *
     * @param addVo 条件
     * @return
     */
    ResponseMessage<Product> addStoreSelf(ProductStoreSelfAddVo addVo);

    /**
     * 保存品牌项目
     *
     * @param addVo 条件
     * @return
     */
    ResponseMessage<Product> addBrand(ProductBrandAddVo addVo);


    /**
     * 保存平台自营项目
     *
     * @param addVo 条件
     * @return
     */
    ResponseMessage<Product> addPlatformSelf(ProductPlatformSelfAddVo addVo);

    /**
     * 修改门店自营项目
     *
     * @param modifyVo 条件
     * @return
     */
    ResponseMessage<Product> modifyStoreSelf(ProductStoreSelfModifyVo modifyVo);

    /**
     * 修改品牌项目
     *
     * @param modifyVo 条件
     * @return
     */
    ResponseMessage<Product> modifyBrand(ProductBrandModifyVo modifyVo);

    /**
     * 修改平台自营项目
     *
     * @param modifyVo 条件
     * @return
     */
    ResponseMessage<Product> modifyPlatformSelf(ProductPlatformSelfModifyVo modifyVo);

    /**
     * 门店自营项目详情
     *
     * @param productId 项目ID
     * @param storeId   门店ID
     * @return
     */
    ResponseMessage<ProductByDetailResVo> detailByStoreSelf(int productId, int storeId);

    /**
     * 品牌项目详情
     *
     * @param productId 项目ID
     * @return
     */
    ResponseMessage<ProductByDetailResVo> detailByBrand(int productId);

    /**
     * 平台自营项目详情
     *
     * @param productId 项目ID
     * @return
     */
    ResponseMessage<ProductByDetailResVo> detailByPlatformSelf(int productId);

    /**
     * 项目上架（店铺）
     *
     * @param productByOnSaleVo
     * @return
     */
    ResponseMessage storeByOnSale(ProductByOnSaleVo productByOnSaleVo);

    /**
     * 项目下架（店铺）
     *
     * @param productByOffShelvesVo
     * @return
     */
    ResponseMessage storeByOffShelves(ProductByOffShelvesVo productByOffShelvesVo);

    /**
     * 项目上架
     *
     * @param id
     * @return
     */
    ResponseMessage onSale(int id);

    /**
     * 项目下架
     *
     * @param id
     * @return
     */
    ResponseMessage offShelves(int id);

    /**
     * 项目审核
     *
     * @param id          ID
     * @param auditStatus 审核状态  0,待审核  1,已审核 2,不通过
     * @param auditReason 审核原因
     * @return
     */
    ResponseMessage modifyAuditStatus(int id, int auditStatus, String auditReason);

    /**
     * 根据品牌分页查询项目
     *
     * @param pageNo           分页索引
     * @param pageSize         每页显示数量
     * @param productByBrandVo 查询条件
     * @return
     */
    ResponseMessage<PageInfo<Product>> findByPageForBrand(Integer pageNo, Integer pageSize, ProductByBrandVo productByBrandVo);

    /**
     * 根据品牌ID查询项目
     *
     * @param brandId 品牌ID
     * @return
     */
    ResponseMessage<List<Product>> findListByBrandId(Integer brandId);

    /**
     * 分页查询项目（会员卡）
     *
     * @param pageNo                分页索引
     * @param pageSize              每页显示数量
     * @param productByMemberCardVo 查询条件
     * @return
     */
    ResponseMessage<PageInfo<ProductByMemberCardResultVo>> findByPageForMemberCard(Integer pageNo, Integer pageSize, ProductByMemberCardVo productByMemberCardVo);

    /**
     * 分页查询项目（店铺）
     *
     * @param pageNo   分页索引
     * @param pageSize 每页数量
     * @param storeVo  查询条件
     * @return
     */
    ResponseMessage<PageInfo<Product>> findByPageForStore(Integer pageNo, Integer pageSize, ProByStoreVo storeVo);

    /**
     * 待审核项目统计
     *
     * @param dataCountVo 条件
     * @return
     */
    ResponseMessage<Integer> pendingByCount(StoreByDataCountVo dataCountVo);

    /**
     * 新增项目统计
     *
     * @param dataCountVo 条件
     * @return
     */
    ResponseMessage<Integer> addByCount(StoreByDataCountVo dataCountVo);

    /**
     * 根据店铺ID查询项目
     *
     * @param storeId 店铺ID
     * @return
     */
    ResponseMessage<List<Product>> findListByStoreId(int storeId);

    /**
     * 批量根据ID查询项目
     *
     * @param idBatchVo 批量ID
     * @return
     */
    ResponseMessage<List<Product>> findListByIdBatch(IdBatchVo idBatchVo);

    /**
     * 批量项目标签
     *
     * @param labelBatchVo 批量项目标签
     * @return
     */
    ResponseMessage labelByBatch(ProByLabelBatchVo labelBatchVo);

    /**
     * 分页查询项目（项目标签）
     *
     * @param pageNo   分页索引
     * @param pageSize 每页数量
     * @param labelVo  查询条件
     * @return
     */
    ResponseMessage<PageInfo<Product>> findByPageForLabel(Integer pageNo, Integer pageSize, ProByLabelVo labelVo);

    /**
     * 查询店铺项目（店铺优惠券）
     *
     * @param productByStoreCouponsVo 查询条件
     * @return
     */
    ResponseMessage<ProductByStoreCouponsResultVo> findByPageForStoreCoupons(ProductByStoreCouponsVo productByStoreCouponsVo);

    /**
     * 批量根据ID查询 项目-分类的关联数据(v1.1.0)
     *
     * @param idBatchVo
     * @return
     */
    ResponseMessage<List<ProductByCategoryRefVo>> findProductCategoryRefListByIdBatchV110(IdBatchVo idBatchVo);

    /**
     * 批量根据ID查询 所有未删除的项目id(v1.1.0)
     *
     * @param idBatchVo
     * @return
     */
    ResponseMessage<List<Integer>> findIsEnableIdListByIdBatchV110(IdBatchVo idBatchVo);

    /**
     * 项目管理分页查询项目
     *
     * @param pageNo   分页索引
     * @param pageSize 每页数量
     * @param manageVo 管理条件
     * @return
     */
    ResponseMessage<PageInfo<Product>> listManage(Integer pageNo, Integer pageSize, ProductByManageVo manageVo);

    /**
     * 根据ID删除项目
     *
     * @param id ID
     * @return
     */
    ResponseMessage removeById(int id);

    /**
     * 根据门店ID查询项目列表
     *
     * @param storeId 门店ID
     * @return
     */
    ResponseMessage<List<Product>> listByStoreId(int storeId);

    /**
     * 查询首页楼层到店项目列表
     *
     * @param pageNo      分页索引
     * @param pageSize    每页数量
     * @param homeFloorVo 条件
     * @return
     */
    ResponseMessage<PageInfo<Product>> listStoreHomeFloor(Integer pageNo, Integer pageSize, ProductListStoreHomeFloorVo homeFloorVo);

    /**
     * 根据优惠券ID分页查询项目
     *
     * @param pageNo    分页索引
     * @param pageSize  每页数量
     * @param couponsId 优惠券ID
     * @return
     */
    ResponseMessage<PageInfo<Product>> findByPageForCouponsId(Integer pageNo, Integer pageSize, int couponsId);

}
