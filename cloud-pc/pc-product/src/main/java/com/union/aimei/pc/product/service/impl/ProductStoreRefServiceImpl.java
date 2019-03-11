package com.union.aimei.pc.product.service.impl;

import com.codingapi.tx.annotation.TxTransaction;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.product.Product;
import com.union.aimei.common.model.product.ProductStoreRef;
import com.union.aimei.common.vo.product.pc.ProductStoreRefByBatchVo;
import com.union.aimei.common.vo.product.pc.ProductStoreRefByStoreIdListVo;
import com.union.aimei.pc.product.mapper.ProductStoreRefMapper;
import com.union.aimei.pc.product.service.ProductStoreRefService;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
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

    @Override
    public List<Integer> findByStoreIdList(ProductStoreRefByStoreIdListVo productStoreRefByStoreIdListVo) {
        return this.productStoreRefMapper.findByStoreIdList(productStoreRefByStoreIdListVo.getStoreIdList());

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
    public ResponseMessage deleteByProductId(int productId) {
        ResponseMessage responseMessage = new ResponseMessage();
        this.productStoreRefMapper.deleteByProductId(productId);
        return responseMessage;
    }

    @Override
    public ResponseMessage deleteByStoreId(int storeId) {
        ResponseMessage responseMessage = new ResponseMessage();
        this.productStoreRefMapper.deleteByStoreId(storeId);
        return responseMessage;
    }

    @Override
    @TxTransaction
    @Transactional(rollbackFor = Exception.class)
    public ResponseMessage addBatch(ProductStoreRefByBatchVo productStoreRefByBatchVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        this.productStoreRefMapper.addBatch(productStoreRefByBatchVo);
        return responseMessage;
    }

    @Override
    public ResponseMessage storeByOffShelves(int storeId) {
        ResponseMessage responseMessage = new ResponseMessage();
        Map<String, Object> condMap = new HashMap<>(16);
        condMap.put("storeId", storeId);
        condMap.put("saleStatus", Product.SaleStatus.OFF_SHELVES);
        int result = this.productStoreRefMapper.updateSaleStatusByStoreId(condMap);
        responseMessage.setData(result);
        return responseMessage;
    }


    @Override
    public ResponseMessage storeByFreeze(int storeId, boolean isFreeze) {
        ResponseMessage responseMessage = new ResponseMessage();
        Map<String, Object> condMap = new HashMap<>(16);
        condMap.put("storeId", storeId);
        if (isFreeze) {
            condMap.put("freezeSaleStatus", Product.SaleStatus.OFF_SHELVES);
            condMap.put("saleStatus", Product.SaleStatus.ON_SALE);
            this.productStoreRefMapper.freezeByStoreId(condMap);
        }
        return responseMessage;
    }

}