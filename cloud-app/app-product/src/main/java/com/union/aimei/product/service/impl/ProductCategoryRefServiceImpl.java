package com.union.aimei.product.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.constant.product.ProductConstant;
import com.union.aimei.common.model.product.ProductCategoryRef;
import com.union.aimei.product.mapper.ProductCategoryRefMapper;
import com.union.aimei.product.service.ProductCategoryRefService;
import com.union.common.utils.ResponseException;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品-分类-关联
 *
 * @author liurenkai
 * @time 2018/2/27 14:22
 */
@Service("productCategoryRefService")
public class ProductCategoryRefServiceImpl implements ProductCategoryRefService {
    @Resource
    private ProductCategoryRefMapper productCategoryRefMapper;

    /**
     * 前端分页查询商品-分类-关联
     *
     * @param pageNo             分页索引
     * @param pageSize           每页显示数量
     * @param productCategoryRef 查询条件
     * @return
     */
    @Override
    public PageInfo<ProductCategoryRef> findByPageForFront(Integer pageNo, Integer pageSize, ProductCategoryRef productCategoryRef) {
        PageHelper.startPage(pageNo, pageSize);
        List<ProductCategoryRef> list = this.productCategoryRefMapper.selectListByConditions(productCategoryRef);
        PageInfo<ProductCategoryRef> page = new PageInfo<>(list);
        return page;
    }

    /**
     * 添加商品-分类-关联
     *
     * @param productCategoryRef
     * @return
     */
    @Override
    public int addObj(ProductCategoryRef productCategoryRef) {
        return this.productCategoryRefMapper.insertSelective(productCategoryRef);
    }

    /**
     * 删除商品-分类-关联
     *
     * @param id
     * @return
     */
    @Override
    public int deleteObjById(int id) {
        return this.productCategoryRefMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改商品-分类-关联
     *
     * @param productCategoryRef
     * @return
     */
    @Override
    public int modifyObj(ProductCategoryRef productCategoryRef) {
        return this.productCategoryRefMapper.updateByPrimaryKeySelective(productCategoryRef);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnproductCategoryRef
     */
    @Override
    public ProductCategoryRef queryObjById(int id) {
        ProductCategoryRef model = this.productCategoryRefMapper.selectByPrimaryKey(id);
        return model;
    }

    @Override
    public ResponseMessage<ProductCategoryRef> getByProductId(int productId) {
        ResponseMessage<ProductCategoryRef> responseMessage = new ResponseMessage<>();
        ProductCategoryRef productCategoryRef = this.productCategoryRefMapper.selectByProductId(productId);
        if (null == productCategoryRef) {
            throw new ResponseException(ProductConstant.Query.PRODUCT_CATEGORY_NULL, ProductConstant.Query.PRODUCT_CATEGORY_NULL_MSG);
        }
        responseMessage.setData(productCategoryRef);
        return responseMessage;
    }

}