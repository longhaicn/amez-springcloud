package com.union.aimei.product.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.product.ProductCategory;
import com.union.aimei.common.vo.common.IdBatchVo;
import com.union.aimei.product.mapper.ProductCategoryMapper;
import com.union.aimei.product.service.ProductCategoryService;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品分类
 *
 * @author liurenkai
 * @time 2018/2/27 14:23
 */
@Service("productCategoryService")
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Resource
    private ProductCategoryMapper productCategoryMapper;

    @Override
    public ResponseMessage<PageInfo<ProductCategory>> findByPageForFront(Integer pageNo, Integer pageSize, ProductCategory productCategory) {
        ResponseMessage<PageInfo<ProductCategory>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        List<ProductCategory> list = this.productCategoryMapper.selectListByConditions(productCategory);
        PageInfo<ProductCategory> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

    @Override
    public ResponseMessage<List<ProductCategory>> findListByIdBatchV110(IdBatchVo idBatchVo) {
        ResponseMessage responseMessage = new ResponseMessage ();
        List<ProductCategory> productCategoryList = this.productCategoryMapper.selectListByIdBatch (idBatchVo);
        responseMessage.setData (productCategoryList);
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
        return this.productCategoryMapper.insertSelective(productCategory);
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
        return this.productCategoryMapper.updateByPrimaryKeySelective(productCategory);
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