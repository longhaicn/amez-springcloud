package com.union.aimei.pc.product.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.product.ProductStoreRef;
import com.union.aimei.common.vo.product.pc.ProductStoreRefByBatchVo;
import com.union.aimei.common.vo.product.pc.ProductStoreRefByStoreIdListVo;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.base.SpringCloudBaseService;

import java.util.List;

/**
 * 项目-门店-关联
 *
 * @author liurenkai
 * @time 2018/1/5 19:34
 */
public interface ProductStoreRefService extends SpringCloudBaseService<ProductStoreRef> {
    /**
     * 前端分页查询项目-门店-关联
     *
     * @param pageNo          分页索引
     * @param pageSize        每页显示数量
     * @param productStoreRef 查询条件
     * @return
     */
    PageInfo<ProductStoreRef> findByPageForFront(Integer pageNo, Integer pageSize, ProductStoreRef productStoreRef);

    /**
     * 根据条件查询集合
     *
     * @param productStoreRefByStoreIdListVo 条件
     * @return
     */
    List<Integer> findByStoreIdList(ProductStoreRefByStoreIdListVo productStoreRefByStoreIdListVo);

    /**
     * 根据商品ID删除项目-门店-关联
     *
     * @param productId 商品ID
     * @return
     */
    ResponseMessage deleteByProductId(int productId);

    /**
     * 根据店铺ID删除项目-门店-关联
     *
     * @param storeId
     * @return
     */
    ResponseMessage deleteByStoreId(int storeId);

    /**
     * 批量添加项目-门店-关联
     *
     * @param productStoreRefByBatchVo
     * @return
     */
    ResponseMessage addBatch(ProductStoreRefByBatchVo productStoreRefByBatchVo);

    /**
     * 门店商品下架
     *
     * @param storeId 门店ID
     * @return
     */
    ResponseMessage storeByOffShelves(int storeId);


    /**
     * 门店冻结或者解冻
     *
     * @param storeId  门店ID
     * @param isFreeze 是否冻结，true-冻结，false-解冻
     * @return
     */
    ResponseMessage storeByFreeze(int storeId, boolean isFreeze);

}