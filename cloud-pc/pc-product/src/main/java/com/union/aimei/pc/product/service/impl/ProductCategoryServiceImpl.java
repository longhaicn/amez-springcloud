package com.union.aimei.pc.product.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.system.BaseHomeTemplateFeign;
import com.union.aimei.common.model.product.ProductCategory;
import com.union.aimei.common.vo.common.IdBatchVo;
import com.union.aimei.pc.product.mapper.ProductCategoryMapper;
import com.union.aimei.pc.product.service.ProductCategoryService;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品分类
 *
 * @author liurenkai
 * @time 2018/1/5 19:02
 */
@Service("productCategoryService")
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Resource
    private ProductCategoryMapper productCategoryMapper;

    @Resource
    private BaseHomeTemplateFeign baseHomeTemplateFeign;

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
        PageHelper.startPage(pageNo, pageSize);
        List<ProductCategory> list = this.productCategoryMapper.selectListByConditions(productCategory);
        PageInfo<ProductCategory> page = new PageInfo<>(list);
        return page;
    }

    @Override
    public ResponseMessage<List<ProductCategory>> findListByIdBatchV110(IdBatchVo idBatchVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        List<ProductCategory> productCategoryList = this.productCategoryMapper.selectListByIdBatch(idBatchVo);
        responseMessage.setData(productCategoryList);
        return responseMessage;
    }

    /**
     * 添加商品分类
     *
     * @param productCategory
     * @return
     */
    @Override
    public int addObj(ProductCategory productCategory) {
        int total = this.productCategoryMapper.insertSelective(productCategory);
        //更新楼层模版的缓存
        this.baseHomeTemplateFeign.saveBaseHomeTemplateByRedis();
        return total;
    }

    /**
     * 删除商品分类
     *
     * @param id
     * @return
     */
    @Override
    public int deleteObjById(int id) {
        return this.productCategoryMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改商品分类
     *
     * @param productCategory
     * @return
     */
    @Override
    public int modifyObj(ProductCategory productCategory) {
        int total = this.productCategoryMapper.updateByPrimaryKeySelective(productCategory);
        //更新楼层模版的缓存
        this.baseHomeTemplateFeign.saveBaseHomeTemplateByRedis();
        return total;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnproductCategory
     */
    @Override
    public ProductCategory queryObjById(int id) {
        ProductCategory model = this.productCategoryMapper.selectByPrimaryKey(id);
        return model;
    }
}