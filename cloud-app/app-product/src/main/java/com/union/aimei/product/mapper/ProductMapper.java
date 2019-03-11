package com.union.aimei.product.mapper;

import com.union.aimei.common.model.product.Product;
import com.union.aimei.common.vo.common.IdBatchVo;
import com.union.aimei.common.vo.product.app.*;
import com.union.common.utils.base.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 项目
 *
 * @author liurenkai
 * @time 2018/1/11 16:40
 */
public interface ProductMapper extends BaseMapper<Product> {

    /**
     * 查询项目（名称）
     *
     * @param condMap 条件
     * @return
     */
    List<ProductByNameResultVo> selectListByName(Map<String, Object> condMap);

    /**
     * 查询店铺品牌项目（店铺优惠券）
     *
     * @param condMap 条件
     * @return
     */
    List<ProductByStoreCouponsForBrandResultVo> selectListByStoreCouponsForBrand(Map<String, Object> condMap);

    /**
     * 查询店铺自营项目（店铺优惠券）
     *
     * @param condMap 条件
     * @return
     */
    List<ProductByStoreCouponsForSelfResultVo> selectListByStoreCouponsForSelf(Map<String, Object> condMap);

    /**
     * 分页查询项目（店铺）
     *
     * @param condMap 条件
     * @return
     */
    List<Product> selectListByStoreIdForSort(Map<String, Object> condMap);

    /**
     * 查询项目上架状态（店铺）
     *
     * @param condMap 条件
     * @return
     */
    Product selectBySaleStatusForStore(Map<String, Object> condMap);

    /**
     * 更新收藏总数
     *
     * @param product 项目
     * @return
     */
    int updateByCollectionTotal(Product product);

    /**
     * 累积销量
     *
     * @param productBySaleVolumeVo
     * @return
     */
    int accumulateBySaleVolume(ProductBySaleVolumeVo productBySaleVolumeVo);

    /**
     * 查询项目（精选）
     *
     * @param condMap 条件
     * @return
     */
    List<Product> selectListBySelect(Map<String, Object> condMap);

    /**
     * 查询项目（活动）
     *
     * @param condMap 条件
     * @return
     */
    List<Product> selectListByActivity(Map<String, Object> condMap);

    /**
     * 查询招募项目（全职美容师）
     *
     * @param condMap 条件
     * @return
     */
    List<ProductByRecruitResVo> selectListByRecruitForFullTime(Map<String, Object> condMap);

    /**
     * 查询可申请招募项目
     *
     * @param condMap 条件
     * @return
     */
    List<ProductByRecruitResVo> selectListByCanApplyForRecruit(Map<String, Object> condMap);

    /**
     * 招募项目管理列表
     *
     * @param condMap 条件
     * @return
     */
    List<ProductByRecruitResVo> listRecruitManage(Map<String, Object> condMap);

    /**
     * 查询招募项目
     *
     * @param condMap 条件
     * @return
     */
    List<ProductByRecruitResVo> selectListByRecruit(Map<String, Object> condMap);

    /**
     * 统计招募项目邀请
     *
     * @param condMap 条件
     * @return
     */
    int countByRecruitForInvination(Map<String, Object> condMap);

    /**
     * 根据门店ID查询招募项目
     *
     * @param condMap 条件
     * @return
     */
    List<ProductByStoreIdForRecruitResVo> selectListByStoreIdForRecruit(Map<String, Object> condMap);

    /**
     * 统计招募项目申请
     *
     * @param condMap 条件
     * @return
     */
    int countByRecruitForApply(Map<String, Object> condMap);

    /**
     * 根据美容师ID查询到店项目
     *
     * @param condMap 条件
     * @return
     */
    List<ProductListByBeauticianIdResVo> listStoreByBeauticianId(Map<String, Object> condMap);

    /**
     * 根据美容师ID查询上门项目
     *
     * @param condMap 条件
     * @return
     */
    List<ProductListByBeauticianIdResVo> listHomeByBeauticianId(Map<String, Object> condMap);

    /**
     * 批量根据ID查询 项目-分类的关联数据
     *
     * @param idBatchVo
     * @return
     */
    List<ProductByCategoryRefVo> findProductCategoryRefListByIdBatch(IdBatchVo idBatchVo);

    /**
     * 批量根据ID查询 项目-分类的关联数据(限定只有美容师服务的项目)
     * @param idBatchVo
     * @return
     */
    List<ProductByCategoryRefVo> findProductCategoryRefListByIdBatchForStoreBeautician(IdBatchVo idBatchVo);

    /**
     * 根据分类ID查询到店项目列表
     *
     * @param condMap 条件
     * @return
     */
    List<ProductListDisplayResVo> listStoreByCategoryId(Map<String, Object> condMap);

    /**
     * 根据分类ID查询上门项目列表
     *
     * @param condMap 条件
     * @return
     */
    List<ProductListDisplayResVo> listHomeByCategoryId(Map<String, Object> condMap);

    /**
     * 根据美容师ID查询美容师类型
     *
     * @param beauticianId 美容师ID
     * @return
     */
    Integer selectBeauticianTypeByBeauticianId(@Param(value = "beauticianId") int beauticianId);

    /**
     * 美容师-项目管理-项目详情
     *
     * @param condMap 条件
     * @return
     */
    ProductByDetailByManageForBeauticianResVo getByProductBeauticianRefId(Map<String, Object> condMap);

    /**
     * 招募项目详情
     *
     * @param condMap 条件
     * @return
     */
    ProductRecruitDetailResVo getByProductStoreRefId(Map<String, Object> condMap);

    /**
     * 根据门店ID查询到店服务
     *
     * @param condMap 条件
     * @return
     */
    List<ProductListDisplayResVo> listStoreByStoreId(Map<String, Object> condMap);

    /**
     * 管理项目列表
     *
     * @param condMap 条件
     * @return
     */
    List<ProductListManageResVo> listManage(Map<String, Object> condMap);

    /**
     * 项目预约人数
     *
     * @param condMap 条件
     * @return
     */
    int appointment(Map<String, Object> condMap);

}