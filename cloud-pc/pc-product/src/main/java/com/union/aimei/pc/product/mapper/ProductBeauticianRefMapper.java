package com.union.aimei.pc.product.mapper;

import com.union.aimei.common.model.product.ProductBeauticianRef;
import com.union.aimei.common.vo.product.pc.ProductBeauticianRefByBeauticianStatusVo;
import com.union.aimei.common.vo.product.pc.ProductBeauticianRefByResVo;
import com.union.aimei.common.vo.product.pc.ProductBeauticianRefVo;
import com.union.common.utils.base.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 项目-美容师-关联
 *
 * @author liurenkai
 * @time 2018/2/26 15:40
 */
public interface ProductBeauticianRefMapper extends BaseMapper<ProductBeauticianRef> {

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
     * @param productBeauticianRefList
     * @return
     */
    int addBatch(@Param(value = "productBeauticianRefList") List<ProductBeauticianRef> productBeauticianRefList);

    /**
     * 查询项目-美容师-关联
     *
     * @param productBeauticianRefVo
     * @return
     */
    List<ProductBeauticianRefByResVo> selectList(ProductBeauticianRefVo productBeauticianRefVo);

    /**
     * 更新美容师状态
     *
     * @param beauticianStatusVo
     * @return
     */
    int updateByBeauticianStatus(ProductBeauticianRefByBeauticianStatusVo beauticianStatusVo);

    /**
     * 去重
     *
     * @param condMap 条件
     * @return
     */
    List<Integer> deduplication(Map<String, Object> condMap);

}