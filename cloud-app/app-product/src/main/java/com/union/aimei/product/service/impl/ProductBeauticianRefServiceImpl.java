package com.union.aimei.product.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.codingapi.tx.annotation.TxTransaction;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.constant.product.ProductConstant;
import com.union.aimei.common.model.product.Product;
import com.union.aimei.common.model.product.ProductBeauticianRef;
import com.union.aimei.common.vo.product.app.*;
import com.union.aimei.common.vo.product.app.productbeauticianref.RemoveStoreByBeauticianIdVo;
import com.union.aimei.product.mapper.ProductBeauticianRefMapper;
import com.union.aimei.product.mapper.ProductMapper;
import com.union.aimei.product.service.ProductBeauticianRefService;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.constant.ResponseContants;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 项目-美容师-关联
 *
 * @author liurenkai
 * @time 2018/2/27 14:20
 */
@Service("productBeauticianRefService")
public class ProductBeauticianRefServiceImpl implements ProductBeauticianRefService {
    @Resource
    private ProductBeauticianRefMapper productBeauticianRefMapper;
    @Resource
    private ProductMapper productMapper;

    @Override
    public ResponseMessage<PageInfo<ProductBeauticianRef>> findByPageForFront(Integer pageNo, Integer pageSize, ProductBeauticianRef productBeauticianRef) {
        ResponseMessage<PageInfo<ProductBeauticianRef>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        List<ProductBeauticianRef> list = this.productBeauticianRefMapper.selectListByConditions(productBeauticianRef);
        PageInfo<ProductBeauticianRef> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

    @Override
    public ResponseMessage<ProductBeauticianRef> findByRandom(ProductBeauticianRefByRandomVo productBeauticianRefByRandomVo) {
        ResponseMessage<ProductBeauticianRef> responseMessage = new ResponseMessage<>();
        ProductBeauticianRef productBeauticianRef = this.productBeauticianRefMapper.selectByRandom(productBeauticianRefByRandomVo);
        if (productBeauticianRef == null) {
            responseMessage.setCode(ResponseContants.QUERY_RESULT_EMPTY);
            responseMessage.setMessage(ResponseContants.QUERY_RESULT_EMPTY_MESSAGE);
            return responseMessage;
        }
        responseMessage.setData(productBeauticianRef);
        return responseMessage;
    }

    @Override
    public ResponseMessage<PageInfo<ProductBeauticianRefByRecruitResVo>> findByPageForRecruit(Integer pageNo, Integer pageSize, ProductBeauticianRef productBeauticianRef) {
        ResponseMessage<PageInfo<ProductBeauticianRefByRecruitResVo>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        List<ProductBeauticianRefByRecruitResVo> list = this.productBeauticianRefMapper.selectListByRecruit(productBeauticianRef);
        PageInfo<ProductBeauticianRefByRecruitResVo> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

    @Override
    public ResponseMessage<ProductBeauticianRefByDetailForRecruitResVo> detailByRecruit(int id) {
        ResponseMessage<ProductBeauticianRefByDetailForRecruitResVo> responseMessage = new ResponseMessage<>();
        // 项目-美容师-关联
        ProductBeauticianRef productBeauticianRef = this.productBeauticianRefMapper.selectByPrimaryKey(id);
        // 商品
        Product product = this.productMapper.selectByPrimaryKey(productBeauticianRef.getProductId());
        // 结果
        ProductBeauticianRefByDetailForRecruitResVo resVo = new ProductBeauticianRefByDetailForRecruitResVo();
        resVo.setProductBeauticianRef(productBeauticianRef);
        resVo.setProduct(product);
        responseMessage.setData(resVo);
        return responseMessage;
    }

    @Override
    public ResponseMessage agree(ProductBeauticianRefByAgreeVo agreeVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        ProductBeauticianRef productBeauticianRef = this.productBeauticianRefMapper.selectByPrimaryKey(agreeVo.getId());
        if (productBeauticianRef == null) {
            responseMessage.setCode(ProductConstant.Query.PRODUCT_BEAUTICIAN_REF_NOT_EXIST);
            responseMessage.setMessage(ProductConstant.Query.PRODUCT_BEAUTICIAN_REF_NOT_EXIST_MSG);
            return responseMessage;
        }
        this.productBeauticianRefMapper.updateByPrimaryKeySelective(productBeauticianRef);
        return responseMessage;
    }

    @Override
    public ResponseMessage auth(ProductBeauticianRefByAuthVo authVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        ProductBeauticianRef productBeauticianRef = this.productBeauticianRefMapper.selectByPrimaryKey(authVo.getId());
        if (productBeauticianRef == null) {
            responseMessage.setCode(ProductConstant.Query.PRODUCT_BEAUTICIAN_REF_NOT_EXIST);
            responseMessage.setMessage(ProductConstant.Query.PRODUCT_BEAUTICIAN_REF_NOT_EXIST_MSG);
            return responseMessage;
        }
        this.productBeauticianRefMapper.updateByPrimaryKeySelective(productBeauticianRef);
        return responseMessage;
    }

    @Override
    public ResponseMessage<List<ProductBeauticianRef>> findListByOrder(StoreBeauticianByOrderVo orderVo) {
        ResponseMessage<List<ProductBeauticianRef>> responseMessage = new ResponseMessage<>();
        ProductBeauticianRef cond = new ProductBeauticianRef();
        cond.setProductId(orderVo.getProductId());
        cond.setStoreId(orderVo.getStoreId());
        cond.setServerType(orderVo.getServerType());
        List<ProductBeauticianRef> list = this.productBeauticianRefMapper.selectListByConditions(cond);
        if (null == list || list.size() == 0) {
            responseMessage.setCode(ResponseContants.QUERY_RESULT_EMPTY);
            responseMessage.setMessage(ResponseContants.QUERY_RESULT_EMPTY_MESSAGE);
            return responseMessage;
        }
        responseMessage.setData(list);
        return responseMessage;
    }

    @Override
    public ResponseMessage add(ProductBeauticianRef productBeauticianRef) {
        ResponseMessage responseMessage = new ResponseMessage();
        int result = this.productBeauticianRefMapper.insertSelective(productBeauticianRef);
        responseMessage.setData(result);
        return responseMessage;
    }

    @Override
    public ResponseMessage modify(ProductBeauticianRef productBeauticianRef) {
        ResponseMessage responseMessage = new ResponseMessage();
        int result = this.productBeauticianRefMapper.updateByPrimaryKeySelective(productBeauticianRef);
        responseMessage.setData(result);
        return responseMessage;
    }

    @Override
    public ResponseMessage<ProductBeauticianRef> findById(int id) {
        ResponseMessage<ProductBeauticianRef> responseMessage = new ResponseMessage<>();
        ProductBeauticianRef productBeauticianRef = this.productBeauticianRefMapper.selectByPrimaryKey(id);
        if (null == productBeauticianRef) {
            responseMessage.setCode(ResponseContants.QUERY_RESULT_EMPTY);
            responseMessage.setMessage(ResponseContants.QUERY_RESULT_EMPTY_MESSAGE);
            return responseMessage;
        }
        responseMessage.setData(productBeauticianRef);
        return responseMessage;
    }


    @Override
    public ResponseMessage<ProductBeauticianRef> findByRefIdV111(ProductBeauticianRefByRefIdVo refIdVo) {
        ResponseMessage<ProductBeauticianRef> responseMessage = new ResponseMessage<>();
        ProductBeauticianRef productBeauticianRef = this.productBeauticianRefMapper.selectByRefId(refIdVo);
        if (null == productBeauticianRef) {
            responseMessage.setCode(ResponseContants.QUERY_RESULT_EMPTY);
            responseMessage.setMessage(ResponseContants.QUERY_RESULT_EMPTY_MESSAGE);
            return responseMessage;
        }
        responseMessage.setData(productBeauticianRef);
        return responseMessage;
    }

    @Override
    public ResponseMessage updateAuditStatusV111(ProductBeauticianRef productBeauticianRef) {
        Map<String, Object> condMap = new HashMap<>(16);
        condMap.put("auditStatus", productBeauticianRef.getAuditStatus());
        condMap.put("productId", productBeauticianRef.getProductId());
        condMap.put("storeId", productBeauticianRef.getStoreId());
        condMap.put("beauticianId", productBeauticianRef.getBeauticianId());
        this.productBeauticianRefMapper.updateAuditStatus(condMap);
        return new ResponseMessage();
    }

    @Override
    public ResponseMessage deleteShowByIdV111(Integer id) {
        ProductBeauticianRef productBeauticianRef = new ProductBeauticianRef();
        productBeauticianRef.setId(id);
        productBeauticianRef.setIsShow(ProductBeauticianRef.IsShow.HIDDEN);
        this.productBeauticianRefMapper.updateByPrimaryKeySelective(productBeauticianRef);
        return new ResponseMessage();
    }

    @Override
    @TxTransaction(rollbackFor = Exception.class)
    @Transactional(rollbackFor = Exception.class)
    public ResponseMessage removeStoreByBeauticianIdV111(RemoveStoreByBeauticianIdVo beauticianIdVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        Map<String, Object> condMap = JSONObject.parseObject(JSON.toJSONString(beauticianIdVo), Map.class);
        condMap.put("productType", Product.ProductType.STORE_SELF);
        int result = this.productBeauticianRefMapper.removeStoreByBeauticianId(condMap);
        responseMessage.setData(result);
        return responseMessage;
    }

}