package com.union.aimei.product.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.product.ProductStoreRef;
import com.union.aimei.common.util.learn.ConditionUtil;
import com.union.aimei.common.vo.product.app.ProductStoreRefByByProductIdForOrderVo;
import com.union.aimei.product.mapper.ProductStoreRefMapper;
import com.union.aimei.product.service.ProductStoreRefService;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.constant.ResponseContants;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 项目-门店-关联
 *
 * @author liurenkai
 * @time 2018/1/5 19:03
 */
@Service("productStoreRefService")
public class ProductStoreRefServiceImpl implements ProductStoreRefService {
    @Resource
    private ProductStoreRefMapper productStoreRefMapper;

    /**
     * 前端分页查询项目-门店-关联
     *
     * @param pageNo          分页索引
     * @param pageSize        每页显示数量
     * @param productStoreRef 查询条件
     * @return
     */
    @Override
    public PageInfo<ProductStoreRef> findByPageForFront(Integer pageNo, Integer pageSize, ProductStoreRef productStoreRef) {
        PageHelper.startPage(pageNo, pageSize);
        List<ProductStoreRef> list = this.productStoreRefMapper.selectListByConditions(productStoreRef);
        PageInfo<ProductStoreRef> page = new PageInfo<>(list);
        return page;
    }

    /**
     * 添加项目-门店-关联
     *
     * @param productStoreRef
     * @return
     */
    @Override
    public int addObj(ProductStoreRef productStoreRef) {
        return this.productStoreRefMapper.insertSelective(productStoreRef);
    }

    /**
     * 删除项目-门店-关联
     *
     * @param id
     * @return
     */
    @Override
    public int deleteObjById(int id) {
        return this.productStoreRefMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改项目-门店-关联
     *
     * @param productStoreRef
     * @return
     */
    @Override
    public int modifyObj(ProductStoreRef productStoreRef) {
        return this.productStoreRefMapper.updateByPrimaryKeySelective(productStoreRef);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnproductStoreRef
     */
    @Override
    public ProductStoreRef queryObjById(int id) {
        ProductStoreRef model = this.productStoreRefMapper.selectByPrimaryKey(id);
        return model;
    }

    @Override
    public ResponseMessage<PageInfo<ProductStoreRef>> findByPageByProductIdForOrder(Integer pageNo, Integer pageSize, ProductStoreRefByByProductIdForOrderVo productStoreRefByByProductIdForOrderVo) {
        ResponseMessage<PageInfo<ProductStoreRef>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        Map<String, Object> voMap = JSONObject.parseObject(JSON.toJSONString(productStoreRefByByProductIdForOrderVo), Map.class);
        Map<String, Object> condMap = ConditionUtil.onSaleProduct();
        condMap.putAll(voMap);
        List<ProductStoreRef> list = this.productStoreRefMapper.selectListByProductIdForOrder(condMap);
        PageInfo<ProductStoreRef> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

    @Override
    public ResponseMessage<ProductStoreRef> findById(int id) {
        ResponseMessage<ProductStoreRef> responseMessage = new ResponseMessage<>();
        ProductStoreRef productStoreRef = this.productStoreRefMapper.selectByPrimaryKey(id);
        if (null == productStoreRef) {
            responseMessage.setCode(ResponseContants.QUERY_RESULT_EMPTY);
            responseMessage.setMessage(ResponseContants.QUERY_RESULT_EMPTY_MESSAGE);
            return responseMessage;
        }
        responseMessage.setData(productStoreRef);
        return responseMessage;
    }

}