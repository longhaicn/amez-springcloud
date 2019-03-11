package com.union.aimei.common.feign.app.product.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.product.PhysicalCategoryRefFeign;
import com.union.aimei.common.model.product.PhysicalCategoryRef;
import org.springframework.stereotype.Component;

/**
 * @author caizhaoming
 * @version 1.1
 * @create 2018-06-21 11:43
 **/
@Component(value = "app-PhysicalCategoryRefFeign")
public class PhysicalCategoryRefApiHystrix implements PhysicalCategoryRefFeign {

    /**
     * 前端分页查询产品-产品分类-关联
     *
     * @param pageNo              分页索引
     * @param pageSize            每页显示数量
     * @param physicalCategoryRef 查询条件
     * @return
     */
    @Override
    public PageInfo<PhysicalCategoryRef> findByPageForFront(Integer pageNo, Integer pageSize, PhysicalCategoryRef physicalCategoryRef) {
        return null;
    }

    /**
     * 添加产品-产品分类-关联
     *
     * @param physicalCategoryRef
     * @return
     */
    @Override
    public int insert(PhysicalCategoryRef physicalCategoryRef) {
        return 0;
    }

    /**
     * 删除产品-产品分类-关联
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改产品-产品分类-关联
     *
     * @param physicalCategoryRef
     * @return
     */
    @Override
    public int edit(PhysicalCategoryRef physicalCategoryRef) {
        return 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnphysicalCategoryRef
     */
    @Override
    public PhysicalCategoryRef queryById(int id) {
        return null;
    }
}