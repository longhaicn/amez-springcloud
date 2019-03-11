package com.union.aimei.store.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreCouponsProduct;
import com.union.aimei.store.mapper.StoreCouponsProductMapper;
import com.union.aimei.store.service.StoreCouponsProductService;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 店铺优惠券-商品-关联
 *
 * @author liurenkai
 * @time 2017/12/22 10:51
 */
@Service("storeCouponsProductService")
public class StoreCouponsProductServiceImpl implements StoreCouponsProductService {
    @Resource
    private StoreCouponsProductMapper storeCouponsProductMapper;

    /**
     * 前端分页查询店铺优惠券-商品-关联
     *
     * @param pageNo              分页索引
     * @param pageSize            每页显示数量
     * @param storeCouponsProduct 查询条件
     * @return
     */
    @Override
    public PageInfo<StoreCouponsProduct> findByPageForFront(Integer pageNo, Integer pageSize, StoreCouponsProduct storeCouponsProduct) {
        PageHelper.startPage(pageNo, pageSize);
        List<StoreCouponsProduct> list = this.storeCouponsProductMapper.selectListByConditions(storeCouponsProduct);
        PageInfo<StoreCouponsProduct> page = new PageInfo<>(list);
        return page;
    }

    @Override
    public ResponseMessage<List<StoreCouponsProduct>> findListByStoreCouponsId(int storeCouponsId) {
        ResponseMessage<List<StoreCouponsProduct>> responseMessage = new ResponseMessage<>();
        StoreCouponsProduct storeCouponsProduct = new StoreCouponsProduct();
        storeCouponsProduct.setStoreCouponsId(storeCouponsId);
        List<StoreCouponsProduct> list = this.storeCouponsProductMapper.selectListByConditions(storeCouponsProduct);
        responseMessage.setData(list);
        return responseMessage;
    }
}