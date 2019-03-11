package com.union.aimei.pc.product.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.constant.product.ProductConstant;
import com.union.aimei.common.model.product.ActivityProductRef;
import com.union.aimei.common.model.product.Product;
import com.union.aimei.common.model.product.ProductActivity;
import com.union.aimei.common.util.learn.ConditionUtil;
import com.union.aimei.common.vo.product.pc.ProductActivityByAddVo;
import com.union.aimei.common.vo.product.pc.ProductActivityByDetailResVo;
import com.union.aimei.common.vo.product.pc.ProductActivityBySelectBatchVo;
import com.union.aimei.pc.product.mapper.ActivityProductRefMapper;
import com.union.aimei.pc.product.mapper.ProductActivityMapper;
import com.union.aimei.pc.product.mapper.ProductMapper;
import com.union.aimei.pc.product.service.ProductActivityService;
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
    @Resource
    private ActivityProductRefMapper activityProductRefMapper;

    @Override
    public ResponseMessage<PageInfo<ProductActivity>> findByPageForFront(Integer pageNo, Integer pageSize, ProductActivity productActivity) {
        ResponseMessage<PageInfo<ProductActivity>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        List<ProductActivity> list = this.productActivityMapper.selectListByConditions(productActivity);
        PageInfo<ProductActivity> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

    @Override
    public ResponseMessage<List<ProductActivity>> findListBySelect(int cityId) {
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
        return responseMessage;
    }

    @Override
    public ResponseMessage<ProductActivityByDetailResVo> detail(int id) {
        ResponseMessage<ProductActivityByDetailResVo> responseMessage = new ResponseMessage<>();
        // 项目活动
        ProductActivity productActivity = this.productActivityMapper.selectByPrimaryKey(id);
        if (null == productActivity || !productActivity.getIsEnabled()) {
            responseMessage.setCode(ProductConstant.Query.PRODUCT_ACTIVITY_NOT_EXIST);
            responseMessage.setMessage(ProductConstant.Query.PRODUCT_ACTIVITY_NOT_EXIST_MSG);
            return responseMessage;
        }
        // 商品集合
        Map<String, Object> condMap = ConditionUtil.onSaleStoreProduct();
        condMap.put("activityId", id);
        List<Product> productList = this.productMapper.selectListByActivity(condMap);
        // 结果
        ProductActivityByDetailResVo detailResVo = new ProductActivityByDetailResVo();
        detailResVo.setProductActivity(productActivity);
        detailResVo.setProductList(productList);
        responseMessage.setData(detailResVo);
        return responseMessage;
    }

    @Override
    public ResponseMessage add(ProductActivityByAddVo addVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        // 项目活动
        ProductActivity activity = addVo.getActivity();
        this.productActivityMapper.insertSelective(activity);
        // 活动-项目-关联
        List<ActivityProductRef> productRefList = addVo.getProductRefList();
        productRefList.forEach(productRef -> {
            productRef.setActivityId(activity.getId());
        });
        this.activityProductRefMapper.addBatch(productRefList);
        return responseMessage;
    }

    @Override
    public ResponseMessage selectByBatch(ProductActivityBySelectBatchVo selectBatchVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        // 根据城市ID取消精选项目活动
        this.productActivityMapper.cancelSelectByCityId(selectBatchVo.getCityId());
        // 批量精选项目活动
        List<Integer> idList = selectBatchVo.getIdList();
        if (!idList.isEmpty()) {
            this.productActivityMapper.selectBatch(selectBatchVo.getIdList());
        }
        return responseMessage;
    }

}