package com.union.aimei.product.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.product.ProductCity;
import com.union.aimei.product.mapper.ProductCityMapper;
import com.union.aimei.product.service.ProductCityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 项目城市
 *
 * @author liurenkai
 * @time 2018/2/27 14:23
 */
@Service("productCityService")
public class ProductCityServiceImpl implements ProductCityService {
    @Resource
    private ProductCityMapper productCityMapper;

    /**
     * 前端分页查询项目城市
     *
     * @param pageNo      分页索引
     * @param pageSize    每页显示数量
     * @param productCity 查询条件
     * @return
     */
    @Override
    public PageInfo<ProductCity> findByPageForFront(Integer pageNo, Integer pageSize, ProductCity productCity) {
        PageHelper.startPage(pageNo, pageSize);
        List<ProductCity> list = this.productCityMapper.selectListByConditions(productCity);
        PageInfo<ProductCity> page = new PageInfo<>(list);
        return page;
    }

    /**
     * 添加项目城市
     *
     * @param productCity
     * @return
     */
    @Override
    public int addObj(ProductCity productCity) {
        return this.productCityMapper.insertSelective(productCity);
    }

    /**
     * 删除项目城市
     *
     * @param id
     * @return
     */
    @Override
    public int deleteObjById(int id) {
        return this.productCityMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改项目城市
     *
     * @param productCity
     * @return
     */
    @Override
    public int modifyObj(ProductCity productCity) {
        return this.productCityMapper.updateByPrimaryKeySelective(productCity);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnproductCity
     */
    @Override
    public ProductCity queryObjById(int id) {
        ProductCity model = this.productCityMapper.selectByPrimaryKey(id);
        return model;
    }
}