package com.union.aimei.common.feign.pc.product.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.product.ProductCategoryRefFeign;
import com.union.aimei.common.model.product.ProductCategoryRef;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

/**
 * 商品-商品分类-关联
 *
 * @author liurenkai
 * @time 2018/1/5 19:19
 */
@Component(value = "pc-ProductCategoryRefFeign")
public class ProductCategoryRefApiHystrix implements ProductCategoryRefFeign {

    /**
     * 前端分页查询商品-商品分类-关联
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
     * 添加商品-商品分类-关联
     *
     * @param productCategoryRef
     * @return
     */
    @Override
    public int insert(ProductCategoryRef productCategoryRef) {
        return 0;
    }

    /**
     * 删除商品-商品分类-关联
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改商品-商品分类-关联
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
    public ResponseMessage add(ProductCategoryRef productCategoryRef) {
        return HystrixResponse.invokeFail();
    }

}