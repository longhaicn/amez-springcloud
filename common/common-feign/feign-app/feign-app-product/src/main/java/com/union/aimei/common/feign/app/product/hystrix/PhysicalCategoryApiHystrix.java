package com.union.aimei.common.feign.app.product.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.product.PhysicalCategoryFeign;
import com.union.aimei.common.model.product.PhysicalCategory;
import org.springframework.stereotype.Component;

/**
 * @author caizhaoming
 * @version 1.1
 * @create 2018-06-21 11:43
 **/
@Component(value = "app-PhysicalCategoryFeign")
public class PhysicalCategoryApiHystrix implements PhysicalCategoryFeign {

    /**
     * 前端分页查询产品分类
     *
     * @param pageNo           分页索引
     * @param pageSize         每页显示数量
     * @param physicalCategory 查询条件
     * @return
     */
    @Override
    public PageInfo<PhysicalCategory> findByPageForFront(Integer pageNo, Integer pageSize, PhysicalCategory physicalCategory) {
        return null;
    }

    @Override
    public PageInfo<PhysicalCategory> findByForFrontV111(PhysicalCategory physicalCategory) {
        return null;
    }

    /**
     * 添加产品分类
     *
     * @param physicalCategory
     * @return
     */
    @Override
    public int insert(PhysicalCategory physicalCategory) {
        return 0;
    }

    /**
     * 删除产品分类
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改产品分类
     *
     * @param physicalCategory
     * @return
     */
    @Override
    public int edit(PhysicalCategory physicalCategory) {
        return 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnphysicalCategory
     */
    @Override
    public PhysicalCategory queryById(int id) {
        return null;
    }
}