package com.union.aimei.common.feign.pc.product.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.product.ProductCategoryFeign;
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
 * @time 2018/1/5 19:18
 */
@Component(value = "pc-ProductCategoryFeign")
public class ProductCategoryApiHystrix implements ProductCategoryFeign {

    /**
     * 前端分页查询商品分类
     *
     * @param pageNo          分页索引
     * @param pageSize        每页显示数量
     * @param productCategory 查询条件
     * @return
     */
    @Override
    public PageInfo<ProductCategory> findByPageForFront(Integer pageNo, Integer pageSize, ProductCategory productCategory) {
        return null;
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