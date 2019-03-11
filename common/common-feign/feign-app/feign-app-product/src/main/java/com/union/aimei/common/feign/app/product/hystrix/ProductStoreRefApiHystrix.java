package com.union.aimei.common.feign.app.product.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.product.ProductStoreRefFeign;
import com.union.aimei.common.model.product.ProductStoreRef;
import com.union.aimei.common.vo.product.app.ProductStoreRefByByProductIdForOrderVo;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

/**
 * 项目-门店-关联
 *
 * @author liurenkai
 * @time 2018/1/5 19:19
 */
@Component(value = "app-ProductStoreRefFeign")
public class ProductStoreRefApiHystrix implements ProductStoreRefFeign {

    /**
     * 前端分页查询项目-门店-关联
     *
     * @param pageNo          分页索引
     * @param pageSize        每页数量
     * @param productStoreRef 查询条件
     * @return
     */
    @Override
    public ResponseMessage<PageInfo<ProductStoreRef>> findByPageForFront(Integer pageNo, Integer pageSize, ProductStoreRef productStoreRef) {
        return HystrixResponse.invokeFail();
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
    public ResponseMessage<PageInfo<ProductStoreRef>> findByPageByProductIdForOrder(Integer pageNo, Integer pageSize, ProductStoreRefByByProductIdForOrderVo productStoreRefByByProductIdForOrderVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<ProductStoreRef> findById(int id) {
        return HystrixResponse.invokeFail();
    }

}