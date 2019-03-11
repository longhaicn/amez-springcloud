package com.union.aimei.product.service.impl;

import com.union.aimei.common.constant.product.ProductConstant;
import com.union.aimei.common.model.product.Product;
import com.union.aimei.common.model.product.ProductActivity;
import com.union.aimei.common.util.learn.ConditionUtil;
import com.union.aimei.common.vo.product.app.ProductActivityByDetailResVo;
import com.union.aimei.product.mapper.ProductActivityMapper;
import com.union.aimei.product.mapper.ProductMapper;
import com.union.aimei.product.service.ProductActivityService;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.constant.ResponseContants;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 项目活动
 *
 * @author liurenkai
 * @time 2018/5/14 10:39
 */
@Service("productActivityService")
public class ProductActivityServiceImpl implements ProductActivityService {
    @Resource
    private ProductActivityMapper productActivityMapper;
    @Resource
    private ProductMapper productMapper;

    @Override
    public ResponseMessage<List<ProductActivity>> findListBySelectV111(int cityId) {
        ResponseMessage<List<ProductActivity>> responseMessage = new ResponseMessage<>();
        ProductActivity paCond = new ProductActivity();
        paCond.setIsEnabled(true);
        paCond.setCityId(cityId);
        paCond.setIsSelect(true);
        List<ProductActivity> productActivityList = this.productActivityMapper.selectListByConditions(paCond);
        if (productActivityList.isEmpty()) {
            responseMessage.setCode(ResponseContants.QUERY_RESULT_EMPTY);
            responseMessage.setMessage(ResponseContants.QUERY_RESULT_EMPTY_MESSAGE);
            return responseMessage;
        }
        responseMessage.setData(productActivityList);
        return responseMessage;
    }

    @Override
    public ResponseMessage<ProductActivityByDetailResVo> detailV111(int id) {
        ResponseMessage<ProductActivityByDetailResVo> responseMessage = new ResponseMessage<>();
        // 项目活动
        ProductActivity productActivity = this.productActivityMapper.selectByPrimaryKey(id);
        if (null == productActivity || !productActivity.getIsEnabled()) {
            responseMessage.setCode(ProductConstant.Query.PRODUCT_ACTIVITY_NOT_EXIST);
            responseMessage.setMessage(ProductConstant.Query.PRODUCT_ACTIVITY_NOT_EXIST_MSG);
            return responseMessage;
        }
        // 商品集合
        Map<String, Object> condMap = ConditionUtil.onSaleProduct();
        condMap.put("activityId", id);
        List<Product> productList = this.productMapper.selectListByActivity(condMap);
        // 结果
        ProductActivityByDetailResVo detailResVo = new ProductActivityByDetailResVo();
        detailResVo.setProductActivity(productActivity);
        detailResVo.setProductList(productList);
        responseMessage.setData(detailResVo);
        return responseMessage;
    }
}