package com.union.aimei.pc.store.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreCouponsProduct;
import com.union.aimei.pc.store.mapper.StoreCouponsProductMapper;
import com.union.aimei.pc.store.service.StoreCouponsProductService;
import com.union.aimei.common.vo.store.pc.StoreCouponsProductByBatchVo;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 优惠券-服务-关联
 *
 * @author liurenkai
 * @time 2018/1/12 17:35
 */
@Service("storeCouponsProductService")
public class StoreCouponsProductServiceImpl implements StoreCouponsProductService {

    @Resource
    private StoreCouponsProductMapper storeCouponsProductMapper;

    @Override
    public ResponseMessage<PageInfo<StoreCouponsProduct>> findByPageForFront(Integer pageNo, Integer pageSize, StoreCouponsProduct storeCouponsProduct) {
        ResponseMessage<PageInfo<StoreCouponsProduct>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        List<StoreCouponsProduct> list = this.storeCouponsProductMapper.selectListByConditions(storeCouponsProduct);
        PageInfo<StoreCouponsProduct> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }


    /**
     * 添加优惠券-服务-关联
     *
     * @param storeCouponsProduct
     * @return
     */
    @Override
    public int addObj(StoreCouponsProduct storeCouponsProduct) {
        return this.storeCouponsProductMapper.insertSelective(storeCouponsProduct);
    }

    /**
     * 删除优惠券-服务-关联
     *
     * @param id
     * @return
     */
    @Override
    public int deleteObjById(int id) {
        return this.storeCouponsProductMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改优惠券-服务-关联
     *
     * @param storeCouponsProduct
     * @return
     */
    @Override
    public int modifyObj(StoreCouponsProduct storeCouponsProduct) {
        return this.storeCouponsProductMapper.updateByPrimaryKeySelective(storeCouponsProduct);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnstoreCouponsProduct
     */
    @Override
    public StoreCouponsProduct queryObjById(int id) {
        StoreCouponsProduct model = this.storeCouponsProductMapper.selectByPrimaryKey(id);
        return model;
    }


    @Override
    public ResponseMessage addBatch(StoreCouponsProductByBatchVo batchVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        int result = this.storeCouponsProductMapper.addBatch(batchVo);
        responseMessage.setData(result);
        return responseMessage;
    }

    @Override
    public ResponseMessage updateByIsEnabledByCouponsId(int couponsId, boolean isEnabled) {
        ResponseMessage responseMessage = new ResponseMessage();
        Map<String, Object> condMap = new HashMap<>(16);
        condMap.put("couponsId", couponsId);
        condMap.put("isEnabled", isEnabled);
        int result = this.storeCouponsProductMapper.updateByIsEnabledByCouponsId(condMap);
        responseMessage.setData(result);
        return responseMessage;
    }

    @Override
    public ResponseMessage updateByIsEnabledByProductId(int productId, boolean isEnabled) {
        ResponseMessage responseMessage = new ResponseMessage();
        Map<String, Object> condMap = new HashMap<>(16);
        condMap.put("productId", productId);
        condMap.put("isEnabled", isEnabled);
        int result = this.storeCouponsProductMapper.updateByIsEnabledByProductId(condMap);
        responseMessage.setData(result);
        return responseMessage;
    }

}