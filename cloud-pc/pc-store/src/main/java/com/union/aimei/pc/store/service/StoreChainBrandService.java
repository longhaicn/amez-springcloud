package com.union.aimei.pc.store.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreChainBrand;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.base.SpringCloudBaseService;

/**
 * 门店连锁品牌
 *
 * @author liurenkai
 * @time 2018/1/12 17:34
 */
public interface StoreChainBrandService extends SpringCloudBaseService<StoreChainBrand> {
    /**
     * 前端分页查询门店连锁品牌
     *
     * @param pageNo          分页索引
     * @param pageSize        每页显示数量
     * @param storeChainBrand 查询条件
     * @return
     */
    PageInfo<StoreChainBrand> findByPageForFront(Integer pageNo, Integer pageSize, StoreChainBrand storeChainBrand);

    /**
     * 根据品牌ID累积店铺总数
     *
     * @param brandId 品牌ID
     * @param number  累积数
     * @return
     */
    ResponseMessage accumStoreTotalByBrandId(int brandId, int number);

    /**
     * 更新品牌ID累积商品总数
     *
     * @param brandId 品牌ID
     * @param number  累积数
     * @return
     */
    ResponseMessage accumProductTotalByBrandId(int brandId, int number);


    /**
     * 新增门店连锁品牌, 限定 品牌所属公司下的所有品牌名称不可重复
     * @param storeChainBrand
     * @return
     */
    ResponseMessage insertLimitBrandOwnershipCompany(StoreChainBrand storeChainBrand);

    /**
     * 修改门店连锁品牌, 限定 品牌所属公司下的所有品牌名称不可重复
     * @param storeChainBrand
     * @return
     */
    ResponseMessage editLimitBrandOwnershipCompany(StoreChainBrand storeChainBrand);

    /**
     * 判断校验品牌名字是否重复
     * @param brandName
     * @param brandId
     * @return
     */
    ResponseMessage findLimitBrandCompany(String brandName , Integer brandId);



}