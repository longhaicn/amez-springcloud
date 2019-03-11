package com.union.aimei.common.feign.app.product.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.product.ProductCategoryFeign;
import com.union.aimei.common.model.product.ProductCategory;
import com.union.aimei.common.vo.common.IdBatchVo;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 商品分类
 *
 * @author liurenkai
 * @time 2018/2/27 14:42
 */
@Component(value = "app-ProductCategoryFeign")
public class ProductCategoryApiHystrix implements ProductCategoryFeign {

    @Override
    public ResponseMessage<PageInfo<ProductCategory>> findByPageForFront(Integer pageNo, Integer pageSize, ProductCategory productCategory) {
        return HystrixResponse.invokeFail ();
    }

    @Override
    public ResponseMessage<List<ProductCategory>> findListByIdBatchV110(IdBatchVo idBatchVo) {
        return HystrixResponse.invokeFail ();
    }

    /**
     * 添加商品分类
     *
     * @param productCategory
     * @return
     */
    @Override
    public int insert(ProductCategory productCategory) {
        return 0;
    }

    /**
     * 删除商品分类
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改商品分类
     *
     * @param productCategory
     * @return
     */
    @Override
    public int edit(ProductCategory productCategory) {
        return 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnproductCategory
     */
    @Override
    public ProductCategory queryById(int id) {
        return null;
    }
}