package com.union.aimei.pc.product.mapper;

import com.union.aimei.common.model.product.Product;
import com.union.aimei.common.vo.common.IdBatchVo;
import com.union.aimei.common.vo.product.pc.*;
import com.union.common.utils.base.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 商品
 *
 * @author liurenkai
 * @time 2018/1/5 12:08
 */
public interface ProductMapper extends BaseMapper<Product> {

    /**
     * 根据品牌分页查询商品
     *
     * @param productByBrandVo
     * @return
     */
    List<Product> selectListByBrand(ProductByBrandVo productByBrandVo);

    /**
     * 查询商品（会员卡）
     *
     * @param productByMemberCardVo 查询条件
     * @return
     */
    List<ProductByMemberCardResultVo> selectListByMemberCard(ProductByMemberCardVo productByMemberCardVo);

    /**
     * 查询商品（品牌，平台自营）
     *
     * @param storeVo
     * @return
     */
    List<Product> selectListByMultipleStore(ProByStoreVo storeVo);

    /**
     * 查询商品（店铺）
     *
     * @param storeVo
     * @return
     */
    List<Product> selectListByStore(ProByStoreVo storeVo);

    /**
     * 待审核商品统计
     *
     * @param condMap 条件
     * @return
     */
    int pendingByCount(Map<String, Object> condMap);

    /**
     * 新增商品统计
     *
     * @param condMap 条件
     * @return
     */
    int addByCount(Map<String, Object> condMap);

    /**
     * 分页查询商品（店铺）
     *
     * @param condMap
     * @return
     */
    List<Product> selectListByStoreIdForSort(Map<String, Object> condMap);

    /**
     * 批量根据ID查询商品
     *
     * @param idBatchVo 批量ID
     * @return
     */
    List<Product> selectListByIdBatch(IdBatchVo idBatchVo);

    /**
     * 查询商品（商品标签）
     *
     * @param condMap 条件
     * @return
     */
    List<Product> selectListByLabel(Map<String, Object> condMap);

    /**
     * 查询店铺品牌商品（店铺优惠券）
     *
     * @param condMap 条件
     * @return
     */
    List<ProductByStoreCouponsForBrandResultVo> selectListByStoreCouponsForBrand(Map<String, Object> condMap);

    /**
     * 查询店铺自营商品（店铺优惠券）
     *
     * @param condMap 条件
     * @return
     */
    List<ProductByStoreCouponsForSelfResultVo> selectListByStoreCouponsForSelf(Map<String, Object> condMap);

    /**
     * 查询商品（活动）
     *
     * @param condMap 条件
     * @return
     */
    List<Product> selectListByActivity(Map<String, Object> condMap);

    /**
     * 批量根据ID查询 项目-分类的关联数据
     *
     * @param idBatchVo
     * @return
     */
    List<ProductByCategoryRefVo> findProductCategoryRefListByIdBatch(IdBatchVo idBatchVo);


    /**
     * 批量根据ID查询 所有未删除的项目id
     *
     * @param idBatchVo
     * @return
     */
    List<Integer> findIsEnableIdListByIdBatch(IdBatchVo idBatchVo);

    /**
     * 查询项目管理-有门店
     *
     * @param condMap 条件
     * @return
     */
    List<Product> listManageByStore(Map<String, Object> condMap);

    /**
     * 查询项目管理-无门店
     *
     * @param condMap 条件
     * @return
     */
    List<Product> listManage(Map<String, Object> condMap);

    /**
     * 根据门店ID查询项目列表
     *
     * @param storeId 门店ID
     * @return
     */
    List<Product> listByStoreId(@Param(value = "storeId") int storeId);

    /**
     * 查询首页楼层到店项目列表
     *
     * @param condMap 条件
     * @return
     */
    List<Product> listStoreHomeFloor(Map<String, Object> condMap);

}