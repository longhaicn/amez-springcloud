package com.union.aimei.product.mapper;

import com.union.aimei.common.model.product.ProductBeauticianRef;
import com.union.aimei.common.vo.product.app.ProductBeauticianRefByBatchVo;
import com.union.aimei.common.vo.product.app.ProductBeauticianRefByRandomVo;
import com.union.aimei.common.vo.product.app.ProductBeauticianRefByRecruitResVo;
import com.union.aimei.common.vo.product.app.ProductBeauticianRefByRefIdVo;
import com.union.common.utils.base.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 项目-美容师-关联
 *
 * @author liurenkai
 * @time 2018/2/27 14:10
 */
public interface ProductBeauticianRefMapper extends BaseMapper<ProductBeauticianRef> {

    /**
     * 随机查询项目-美容师-关联
     *
     * @param productBeauticianRefByRandomVo
     * @return
     */
    ProductBeauticianRef selectByRandom(ProductBeauticianRefByRandomVo productBeauticianRefByRandomVo);

    /**
     * 根据商品ID删除
     *
     * @param productId 商品ID
     * @return
     */
    int deleteByProductId(@Param(value = "productId") int productId);

    /**
     * 批量添加
     *
     * @param productBeauticianRefByBatchVo
     * @return
     */
    int addBatch(ProductBeauticianRefByBatchVo productBeauticianRefByBatchVo);

    /**
     * 查询项目-美容师-关联（招募）
     *
     * @param productBeauticianRef
     * @return
     */
    List<ProductBeauticianRefByRecruitResVo> selectListByRecruit(ProductBeauticianRef productBeauticianRef);

    /**
     * 根据关联ID查询项目-美容师-关联
     *
     * @param refIdVo 条件
     * @return
     */
    ProductBeauticianRef selectByRefId(ProductBeauticianRefByRefIdVo refIdVo);

    /**
     * 更新选择
     *
     * @param condMap 条件
     * @return
     */
    int updateIsSelect(Map<String, Object> condMap);

    /**
     * 更新审核状态
     *
     * @param condMap 条件
     * @return
     */
    int updateAuditStatus(Map<String, Object> condMap);

    /**
     * 根据商品ID删除门店项目-美容师-关联
     *
     * @param condMap 条件
     * @return
     */
    int removeStoreByProductId(Map<String, Object> condMap);

    /**
     * 根据美容师ID删除门店项目
     *
     * @param condMap 条件
     * @return
     */
    int removeStoreByBeauticianId(Map<String, Object> condMap);

    /**
     * 取消选择
     *
     * @param condMap 条件
     * @return
     */
    int cancelSelect(Map<String, Object> condMap);

}