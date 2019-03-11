package com.union.aimei.common.feign.app.product.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.product.ProductPhysicalCategoryRefFeign;
import com.union.aimei.common.model.product.ProductPhysicalCategoryRef;
import org.springframework.stereotype.Component;

/**
 * 产品-分类-关联
 *
 * @author liurenkai
 * @time 2018/2/28 16:19
 */
@Component(value = "app-ProductPhysicalCategoryRefFeign")
public class ProductPhysicalCategoryRefApiHystrix implements ProductPhysicalCategoryRefFeign {

    /**
     * 前端分页查询产品-分类-关联
     *
     * @param pageNo                     分页索引
     * @param pageSize                   每页显示数量
     * @param productPhysicalCategoryRef 查询条件
     * @return
     */
    @Override
    public PageInfo<ProductPhysicalCategoryRef> findByPageForFront(Integer pageNo, Integer pageSize, ProductPhysicalCategoryRef productPhysicalCategoryRef) {
        return null;
    }

    /**
     * 添加产品-分类-关联
     *
     * @param productPhysicalCategoryRef
     * @return
     */
    @Override
    public int insert(ProductPhysicalCategoryRef productPhysicalCategoryRef) {
        return 0;
    }

    /**
     * 删除产品-分类-关联
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改产品-分类-关联
     *
     * @param productPhysicalCategoryRef
     * @return
     */
    @Override
    public int edit(ProductPhysicalCategoryRef productPhysicalCategoryRef) {
        return 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnproductPhysicalCategoryRef
     */
    @Override
    public ProductPhysicalCategoryRef queryById(int id) {
        return null;
    }
}