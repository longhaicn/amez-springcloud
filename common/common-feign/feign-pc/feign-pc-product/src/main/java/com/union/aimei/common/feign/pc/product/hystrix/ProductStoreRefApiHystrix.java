package com.union.aimei.common.feign.pc.product.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.product.ProductStoreRefFeign;
import com.union.aimei.common.model.product.ProductStoreRef;
import com.union.aimei.common.vo.product.pc.ProductStoreRefByBatchVo;
import com.union.aimei.common.vo.product.pc.ProductStoreRefByStoreIdListVo;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 项目-门店-关联
 *
 * @author liurenkai
 * @time 2018/1/5 19:19
 */
@Component(value = "pc-ProductStoreRefFeign")
public class ProductStoreRefApiHystrix implements ProductStoreRefFeign {

    /**
     * 前端分页查询项目-门店-关联
     *
     * @param pageNo          分页索引
     * @param pageSize        每页显示数量
     * @param productStoreRef 查询条件
     * @return
     */
    @Override
    public PageInfo<ProductStoreRef> findByPageForFront(Integer pageNo, Integer pageSize, ProductStoreRef productStoreRef) {
        return null;
    }

    @Override
    public List<Integer> findByStoreIdList(ProductStoreRefByStoreIdListVo productStoreRefByStoreIdListVo) {
        return null;
    }

    /**
     * 添加项目-门店-关联
     *
     * @param productStoreRef
     * @return
     */
    @Override
    public int insert(ProductStoreRef productStoreRef) {
        return 0;
    }

    /**
     * 删除项目-门店-关联
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改项目-门店-关联
     *
     * @param productStoreRef
     * @return
     */
    @Override
    public int edit(ProductStoreRef productStoreRef) {
        return 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnproductStoreRef
     */
    @Override
    public ProductStoreRef queryById(int id) {
        return null;
    }

    @Override
    public ResponseMessage deleteByProductId(int productId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage deleteByStoreId(int storeId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage addBatch(ProductStoreRefByBatchVo productStoreRefByBatchVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage storeByOffShelves(int storeId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage freezeByStoreId(int storeId, boolean isFreeze) {
        return HystrixResponse.invokeFail();
    }

}