package com.union.aimei.pc.product.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.product.ProductPhysicalCategoryRef;
import com.union.aimei.pc.product.mapper.ProductPhysicalCategoryRefMapper;
import com.union.aimei.pc.product.service.ProductPhysicalCategoryRefService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 产品-分类-关联
 *
 * @author liurenkai
 * @time 2018/2/28 15:52
 */
@Service("productPhysicalCategoryRefService")
public class ProductPhysicalCategoryRefServiceImpl implements ProductPhysicalCategoryRefService {
    @Resource
    private ProductPhysicalCategoryRefMapper productPhysicalCategoryRefMapper;

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
        PageHelper.startPage(pageNo, pageSize);
        List<ProductPhysicalCategoryRef> list = this.productPhysicalCategoryRefMapper.selectListByConditions(productPhysicalCategoryRef);
        PageInfo<ProductPhysicalCategoryRef> page = new PageInfo<>(list);
        return page;
    }

    /**
     * 添加产品-分类-关联
     *
     * @param productPhysicalCategoryRef
     * @return
     */
    @Override
    public int addObj(ProductPhysicalCategoryRef productPhysicalCategoryRef) {
        return this.productPhysicalCategoryRefMapper.insertSelective(productPhysicalCategoryRef);
    }

    /**
     * 删除产品-分类-关联
     *
     * @param id
     * @return
     */
    @Override
    public int deleteObjById(int id) {
        return this.productPhysicalCategoryRefMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改产品-分类-关联
     *
     * @param productPhysicalCategoryRef
     * @return
     */
    @Override
    public int modifyObj(ProductPhysicalCategoryRef productPhysicalCategoryRef) {
        return this.productPhysicalCategoryRefMapper.updateByPrimaryKeySelective(productPhysicalCategoryRef);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnproductPhysicalCategoryRef
     */
    @Override
    public ProductPhysicalCategoryRef queryObjById(int id) {
        ProductPhysicalCategoryRef model = this.productPhysicalCategoryRefMapper.selectByPrimaryKey(id);
        return model;
    }
}