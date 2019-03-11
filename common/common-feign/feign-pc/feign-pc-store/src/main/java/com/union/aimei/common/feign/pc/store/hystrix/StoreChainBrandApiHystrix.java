package com.union.aimei.common.feign.pc.store.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.store.StoreChainBrandFeign;
import com.union.aimei.common.model.store.StoreChainBrand;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

/**
 * 门店连锁品牌
 *
 * @author liurenkai
 * @time 2018/1/12 17:34
 */
@Component(value = "pc-StoreChainBrandFeign")
public class StoreChainBrandApiHystrix implements StoreChainBrandFeign {

    /**
     * 前端分页查询门店连锁品牌
     *
     * @param pageNo          分页索引
     * @param pageSize        每页显示数量
     * @param storeChainBrand 查询条件
     * @return
     */
    @Override
    public PageInfo<StoreChainBrand> findByPageForFront(Integer pageNo, Integer pageSize, StoreChainBrand storeChainBrand) {
        return null;
    }

    /**
     * 添加门店连锁品牌
     *
     * @param storeChainBrand
     * @return
     */
    @Override
    public int insert(StoreChainBrand storeChainBrand) {
        return 0;
    }

    /**
     * 删除门店连锁品牌
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改门店连锁品牌
     *
     * @param storeChainBrand
     * @return
     */
    @Override
    public int edit(StoreChainBrand storeChainBrand) {
        return 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnstoreChainBrand
     */
    @Override
    public StoreChainBrand queryById(int id) {
        return null;
    }

    @Override
    public ResponseMessage accumStoreTotalByBrandId(int brandId, int number) {
        return HystrixResponse.invokeFail ();
    }

    @Override
    public ResponseMessage accumProductTotalByBrandId(int brandId, int number) {
        return HystrixResponse.invokeFail ();
    }

    @Override
    public ResponseMessage insertLimitBrandOwnershipCompany(StoreChainBrand storeChainBrand) {
        return HystrixResponse.invokeFail ();
    }

    @Override
    public ResponseMessage editLimitBrandOwnershipCompany(StoreChainBrand storeChainBrand) {
        return HystrixResponse.invokeFail ();
    }

    @Override
    public ResponseMessage findLimitBrandCompany(String brandName, int brandId) {
        return HystrixResponse.invokeFail ();
    }

}