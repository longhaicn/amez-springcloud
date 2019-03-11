package com.union.aimei.product.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.constant.product.ProductConstant;
import com.union.aimei.common.model.product.ProductPhysicalBeauticianRef;
import com.union.aimei.common.model.store.StoreBeautician;
import com.union.aimei.common.vo.product.app.PhysicalBeauticianRefListInventoryByProductIdVo;
import com.union.aimei.common.vo.product.app.ProductPhysicalBeauticianRefByBeauticianIdResVo;
import com.union.aimei.common.vo.product.app.ProductPhysicalBeauticianRefByFindVo;
import com.union.aimei.product.mapper.ProductPhysicalBeauticianRefMapper;
import com.union.aimei.product.service.ProductPhysicalBeauticianRefService;
import com.union.common.utils.ResponseException;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.constant.ResponseContants;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 产品-美容师-关联
 *
 * @author liurenkai
 * @time 2018/2/28 15:51
 */
@Service("productPhysicalBeauticianRefService")
public class ProductPhysicalBeauticianRefServiceImpl implements ProductPhysicalBeauticianRefService {
    @Resource
    private ProductPhysicalBeauticianRefMapper productPhysicalBeauticianRefMapper;

    @Override
    public ResponseMessage<PageInfo<ProductPhysicalBeauticianRef>> findByPageForFront(Integer pageNo, Integer pageSize, ProductPhysicalBeauticianRef productPhysicalBeauticianRef) {
        ResponseMessage<PageInfo<ProductPhysicalBeauticianRef>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        List<ProductPhysicalBeauticianRef> list = this.productPhysicalBeauticianRefMapper.selectListByConditions(productPhysicalBeauticianRef);
        PageInfo<ProductPhysicalBeauticianRef> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

    /**
     * 添加产品-美容师-关联
     *
     * @param productPhysicalBeauticianRef
     * @return
     */
    @Override
    public int addObj(ProductPhysicalBeauticianRef productPhysicalBeauticianRef) {
        return this.productPhysicalBeauticianRefMapper.insertSelective(productPhysicalBeauticianRef);
    }

    /**
     * 删除产品-美容师-关联
     *
     * @param id
     * @return
     */
    @Override
    public int deleteObjById(int id) {
        return this.productPhysicalBeauticianRefMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改产品-美容师-关联
     *
     * @param productPhysicalBeauticianRef
     * @return
     */
    @Override
    public int modifyObj(ProductPhysicalBeauticianRef productPhysicalBeauticianRef) {
        return this.productPhysicalBeauticianRefMapper.updateByPrimaryKeySelective(productPhysicalBeauticianRef);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnproductPhysicalBeauticianRef
     */
    @Override
    public ProductPhysicalBeauticianRef queryObjById(int id) {
        ProductPhysicalBeauticianRef model = this.productPhysicalBeauticianRefMapper.selectByPrimaryKey(id);
        return model;
    }

    @Override
    public ResponseMessage<ProductPhysicalBeauticianRef> find(ProductPhysicalBeauticianRefByFindVo productPhysicalBeauticianRefByFindVo) {
        ResponseMessage<ProductPhysicalBeauticianRef> responseMessage = new ResponseMessage<>();
        ProductPhysicalBeauticianRef productPhysicalBeauticianRefCond = new ProductPhysicalBeauticianRef();
        productPhysicalBeauticianRefCond.setProductPhysicalId(productPhysicalBeauticianRefByFindVo.getProductPhysicalId());
        productPhysicalBeauticianRefCond.setBeauticianId(productPhysicalBeauticianRefByFindVo.getBeauticianId());
        productPhysicalBeauticianRefCond.setIsEnabled(true);
        List<ProductPhysicalBeauticianRef> productPhysicalBeauticianRefList = this.productPhysicalBeauticianRefMapper.selectListByConditions(productPhysicalBeauticianRefCond);
        if (productPhysicalBeauticianRefList.isEmpty()) {
            responseMessage.setCode(ResponseContants.QUERY_RESULT_EMPTY);
            responseMessage.setMessage(ResponseContants.QUERY_RESULT_EMPTY_MESSAGE);
            return responseMessage;
        }
        responseMessage.setData(productPhysicalBeauticianRefList.get(0));
        return responseMessage;
    }

    @Override
    public ResponseMessage<PageInfo<ProductPhysicalBeauticianRefByBeauticianIdResVo>> findByPageForBeauticianId(Integer pageNo, Integer pageSize, int beauticianId) {
        ResponseMessage<PageInfo<ProductPhysicalBeauticianRefByBeauticianIdResVo>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        List<ProductPhysicalBeauticianRefByBeauticianIdResVo> list = this.productPhysicalBeauticianRefMapper.selectListByBeauticianId(beauticianId);
        PageInfo<ProductPhysicalBeauticianRefByBeauticianIdResVo> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

    @Override
    public ResponseMessage<List<ProductPhysicalBeauticianRef>> listInventoryByProductIdV111(PhysicalBeauticianRefListInventoryByProductIdVo productIdVo) {
        ResponseMessage<List<ProductPhysicalBeauticianRef>> responseMessage = new ResponseMessage<>();
        Map<String, Object> condMap = JSONObject.parseObject(JSON.toJSONString(productIdVo), Map.class);
        condMap.put("fulltimeBeauticianType", StoreBeautician.BeauticianType.FULL_TIME);
        condMap.put("managerBeauticianType", StoreBeautician.BeauticianType.MANAGER);
        List<ProductPhysicalBeauticianRef> list = this.productPhysicalBeauticianRefMapper.listInventoryByProductId(condMap);
        if (CollectionUtils.isEmpty(list)) {
            throw new ResponseException(ProductConstant.Query.PRODUCT_INVENTORY_NOT_ENOUGH, ProductConstant.Query.PRODUCT_INVENTORY_NOT_ENOUGH_MSG);
        }
        responseMessage.setData(list);
        return responseMessage;
    }

}