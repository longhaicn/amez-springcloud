package com.union.aimei.product.service.impl;

import com.union.aimei.common.constant.product.ProductConstant;
import com.union.aimei.common.model.product.ProductImg;
import com.union.aimei.product.mapper.ProductImgMapper;
import com.union.aimei.product.service.ProductImgService;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 商品图片
 *
 * @author liurenkai
 * @time 2018/2/27 14:25
 */
@Service("productImgService")
public class ProductImgServiceImpl implements ProductImgService {
    @Resource
    private ProductImgMapper productImgMapper;

    @Override
    public ResponseMessage<ProductImg> findByProductId(int productId) {
        ResponseMessage<ProductImg> responseMessage = new ResponseMessage<>();
        ProductImg productImg = this.productImgMapper.selectByProductId(productId);
        if (null == productImg) {
            responseMessage.setCode(ProductConstant.Query.PRODUCT_IMG_NULL);
            responseMessage.setMessage(ProductConstant.Query.PRODUCT_IMG_NULL_MSG);
            return responseMessage;
        }
        responseMessage.setData(productImg);
        return responseMessage;
    }

}