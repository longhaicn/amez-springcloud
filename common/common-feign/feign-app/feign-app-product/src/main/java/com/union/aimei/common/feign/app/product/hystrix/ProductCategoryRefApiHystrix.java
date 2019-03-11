package com.union.aimei.common.feign.app.product.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.product.ProductCategoryRefFeign;
import com.union.aimei.common.model.product.ProductCategoryRef;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

/**
 * 商品-分类-关联
 *
 * @author liurenkai
 * @time 2018/2/27 14:42
 */
@Component(value = "app-ProductCategoryRefFeign")
public class ProductCategoryRefApiHystrix implements ProductCategoryRefFeign {

    /**
     * 前端分页查询商品-分类-关联
     *
     * @param pageNo             分页索引
     * @param pageSize           每页显示数量
     * @param productCategoryRef 查询条件
     * @return
     */
    @Override
    public PageInfo<ProductCategoryRef> findByPageForFront(Integer pageNo, Integer pageSize, ProductCategoryRef productCategoryRef) {
        return null;
    }

    /**
     * 添加商品-分类-关联
     *
     * @param productCategoryRef
     * @return
     */
    @Override
    public int insert(ProductCategoryRef productCategoryRef) {
        return 0;
    }

    /**
     * 删除商品-分类-关联
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改商品-分类-关联
     *
     * @param productCategoryRef
     * @return
     */
    @Override
    public int edit(ProductCategoryRef productCategoryRef) {
        return 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnproductCategoryRef
     */
    @Override
    public ProductCategoryRef queryById(int id) {
        return null;
    }

    @Override
    public ResponseMessage<ProductCategoryRef> getByProductId(int productId) {
        return HystrixResponse.invokeFail();
    }

}