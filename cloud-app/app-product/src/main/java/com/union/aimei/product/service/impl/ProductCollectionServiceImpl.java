package com.union.aimei.product.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.constant.product.ProductConstant;
import com.union.aimei.common.model.product.Product;
import com.union.aimei.common.model.product.ProductCollection;
import com.union.aimei.common.vo.product.app.ProductCollectionResultVo;
import com.union.aimei.common.vo.product.app.ProductCollectionVo;
import com.union.aimei.product.mapper.ProductCollectionMapper;
import com.union.aimei.product.mapper.ProductMapper;
import com.union.aimei.product.service.ProductCollectionService;
import com.union.common.utils.ResponseMessage;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 项目收藏
 *
 * @author liurenkai
 * @time 2018/1/26 11:08
 */
@Service("productCollectionService")
public class ProductCollectionServiceImpl implements ProductCollectionService {
    @Resource
    private ProductCollectionMapper productCollectionMapper;
    @Resource
    private ProductMapper productMapper;

    @Override
    public ResponseMessage<PageInfo<ProductCollectionResultVo>> selectListPageCollectionByMemberId(Integer pageNo, Integer pageSize, ProductCollectionVo productCollectionVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        PageHelper.startPage(pageNo, pageSize);
        List<ProductCollectionResultVo> list = this.productCollectionMapper.selectListPageCollectionByMemberId(productCollectionVo);
        PageInfo<ProductCollectionResultVo> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

    @Override
    public ResponseMessage<ProductCollection> collection(int productId, int memberId, boolean isCollection) {
        ResponseMessage<ProductCollection> responseMessage = new ResponseMessage<>();
        // 项目收藏
        ProductCollection cond = new ProductCollection();
        cond.setProductId(productId);
        cond.setMemberId(memberId);
        List<ProductCollection> list = this.productCollectionMapper.selectListByConditions(cond);
        ProductCollection productCollection;
        if (CollectionUtils.isNotEmpty(list)) {
            productCollection = list.get(0);
            if (isCollection == productCollection.getIsCollection()) {
                if (isCollection) {
                    responseMessage.setCode(ProductConstant.Query.PRODUCT_COLLECTION_COLLECTED);
                    responseMessage.setMessage(ProductConstant.Query.PRODUCT_COLLECTION_COLLECTED_MSG);
                    return responseMessage;
                } else {
                    responseMessage.setCode(ProductConstant.Query.PRODUCT_COLLECTION_CANCELED);
                    responseMessage.setMessage(ProductConstant.Query.PRODUCT_COLLECTION_CANCELED_MSG);
                    return responseMessage;
                }
            } else {
                productCollection.setIsCollection(isCollection);
                this.productCollectionMapper.updateByPrimaryKeySelective(productCollection);
            }
        } else {
            if (isCollection) {
                productCollection = new ProductCollection();
                productCollection.setProductId(productId);
                productCollection.setMemberId(memberId);
                productCollection.setIsCollection(isCollection);
                this.productCollectionMapper.insertSelective(productCollection);
            } else {
                responseMessage.setCode(ProductConstant.Query.PRODUCT_COLLECTION_NOT_COLLECTION);
                responseMessage.setMessage(ProductConstant.Query.PRODUCT_COLLECTION_NOT_COLLECTION_MSG);
                return responseMessage;
            }
        }
        // 项目收藏总数
        Product product = this.productMapper.selectByPrimaryKey(productId);
        product.setCollectionTotal(product.getCollectionTotal() + 1);
        this.productMapper.updateByPrimaryKeySelective(product);
        responseMessage.setData(productCollection);
        return responseMessage;
    }

    @Override
    public ResponseMessage<Boolean> isCollection(int productId, int memberId) {
        ResponseMessage<Boolean> responseMessage = new ResponseMessage<>();
        ProductCollection pcCond = new ProductCollection();
        pcCond.setProductId(productId);
        pcCond.setMemberId(memberId);
        List<ProductCollection> productCollectionList = this.productCollectionMapper.selectListByConditions(pcCond);
        boolean isCollection = false;
        if (CollectionUtils.isNotEmpty(productCollectionList)) {
            ProductCollection productCollection = productCollectionList.get(0);
            isCollection = productCollection.getIsCollection();
        }
        responseMessage.setData(isCollection);
        return responseMessage;
    }

}