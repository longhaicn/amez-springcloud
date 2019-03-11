package com.union.aimei.pc.store.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.constant.store.StoreConstant;
import com.union.aimei.common.model.store.StoreCoupons;
import com.union.aimei.common.model.store.StoreCouponsProduct;
import com.union.aimei.common.vo.common.IdBatchVo;
import com.union.aimei.common.vo.store.pc.StoreCouponsProductByBatchVo;
import com.union.aimei.common.vo.store.pc.StoreCouponsProductCountResultVo;
import com.union.aimei.common.vo.store.pc.StoreCouponsProductCountVo;
import com.union.aimei.common.vo.store.pc.StoreCouponsVo;
import com.union.aimei.pc.store.mapper.StoreCouponsMapper;
import com.union.aimei.pc.store.mapper.StoreCouponsProductMapper;
import com.union.aimei.pc.store.service.StoreCouponsService;
import com.union.common.utils.ResponseException;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.constant.ResponseContants;
import lombok.extern.apachecommons.CommonsLog;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 门店优惠券
 *
 * @author liurenkai
 * @time 2018/1/12 17:34
 */
@Service("storeCouponsService")
@CommonsLog
public class StoreCouponsServiceImpl implements StoreCouponsService {
    @Resource
    private StoreCouponsMapper storeCouponsMapper;

    @Resource
    private StoreCouponsProductMapper storeCouponsProductMapper;

    /**
     * 前端分页查询门店优惠券
     *
     * @param pageNo       分页索引
     * @param pageSize     每页显示数量
     * @param storeCoupons 查询条件
     * @return
     */
    @Override
    public PageInfo<StoreCoupons> findByPageForFront(Integer pageNo, Integer pageSize, StoreCoupons storeCoupons) {
        PageHelper.startPage(pageNo, pageSize);
        List<StoreCoupons> list = this.storeCouponsMapper.selectListByConditions(storeCoupons);
        PageInfo<StoreCoupons> page = new PageInfo<>(list);
        return page;
    }

    /**
     * 添加门店优惠券
     *
     * @param storeCoupons
     * @return
     */
    @Override
    public int addObj(StoreCoupons storeCoupons) {
        return this.storeCouponsMapper.insertSelective(storeCoupons);
    }

    /**
     * 删除门店优惠券
     *
     * @param id
     * @return
     */
    @Override
    public int deleteObjById(int id) {
        return this.storeCouponsMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改门店优惠券
     *
     * @param storeCoupons
     * @return
     */
    @Override
    public int modifyObj(StoreCoupons storeCoupons) {
        return this.storeCouponsMapper.updateByPrimaryKeySelective(storeCoupons);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnstoreCoupons
     */
    @Override
    public StoreCoupons queryObjById(int id) {
        StoreCoupons model = this.storeCouponsMapper.selectByPrimaryKey(id);
        return model;
    }

    @Override
    public ResponseMessage startByScheduleTask() {
        log.info("优惠券开始时间调度开始");
        ResponseMessage responseMessage = new ResponseMessage();
        int result = this.storeCouponsMapper.updateByStartForScheduleTask();
        log.info("优惠券开始时间调度结束result=" + result);
        responseMessage.setData(result);
        return responseMessage;
    }

    @Override
    public ResponseMessage endByScheduleTask() {
        log.info("优惠券结束时间调度开始");
        ResponseMessage responseMessage = new ResponseMessage();
        int result = this.storeCouponsMapper.updateByEndForScheduleTask();
        log.info("优惠券结束时间调度结束result=" + result);
        responseMessage.setData(result);
        return responseMessage;
    }

    @Override
    public ResponseMessage add(StoreCouponsVo storeCouponsVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        // 门店优惠券
        StoreCoupons storeCoupons = storeCouponsVo.getStoreCoupons();
        storeCoupons.setIsReceived(true);
        // 优惠券状态
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date beginTime = sdf.parse(storeCoupons.getBeginTime());
            Date currTime = sdf.parse(sdf.format(new Date()));
            if (beginTime.after(currTime)) {
                storeCoupons.setCouponStatus(StoreCoupons.CouponStatus.NOT_START);
            } else {
                storeCoupons.setCouponStatus(StoreCoupons.CouponStatus.ACTIVE);
            }
        } catch (ParseException e) {
            responseMessage.setCode(ResponseContants.PARAMS_ERROR);
            responseMessage.setMessage(ResponseContants.PARAMS_ERROR_MSG);
            return responseMessage;
        }
        this.storeCouponsMapper.insertSelective(storeCoupons);
        // 优惠券-商品-关联
        List<StoreCouponsProduct> storeCouponsProductList = storeCouponsVo.getStoreCouponsProductList();
        if (!storeCouponsProductList.isEmpty()) {
            storeCouponsProductList.forEach(storeCouponsProduct -> {
                storeCouponsProduct.setStoreCouponsId(storeCoupons.getId());
            });
            this.storeCouponsProductMapper.addBatch(new StoreCouponsProductByBatchVo(storeCouponsProductList));
        }
        return responseMessage;
    }

    @Override
    public ResponseMessage isEnabled(int id, int isEnabled) {
        ResponseMessage responseMessage = new ResponseMessage();
        // 门店优惠券
        StoreCoupons storeCoupons = new StoreCoupons();
        storeCoupons.setId(id);
        storeCoupons.setIsEnabled(1 == isEnabled ? true : false);
        this.storeCouponsMapper.updateByPrimaryKeySelective(storeCoupons);
        // 优惠卷-商品-关联
        Map<String, Object> condMap = new HashMap<>(16);
        condMap.put("couponsId", id);
        condMap.put("isEnabled", 1 == isEnabled ? true : false);
        this.storeCouponsProductMapper.updateByIsEnabledByCouponsId(condMap);
        return responseMessage;
    }

    @Override
    public ResponseMessage<StoreCoupons> findById(int id) {
        ResponseMessage<StoreCoupons> responseMessage = new ResponseMessage<>();
        StoreCoupons storeCoupons = this.storeCouponsMapper.selectByPrimaryKey(id);
        responseMessage.setData(storeCoupons);
        return responseMessage;
    }

    @Override
    public ResponseMessage<PageInfo<StoreCouponsProductCountResultVo>> findByPageForCountProduct(Integer pageNo, Integer pageSize, StoreCouponsProductCountVo productCountVo) {
        ResponseMessage<PageInfo<StoreCouponsProductCountResultVo>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        List<StoreCouponsProductCountResultVo> list = this.storeCouponsMapper.selectListByConditionsAndCountProduct(productCountVo);
        PageInfo<StoreCouponsProductCountResultVo> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

    @Override
    public ResponseMessage<List<StoreCoupons>> listAllServiceByStoreIdBatch(IdBatchVo idBatchVo) {
        ResponseMessage<List<StoreCoupons>> responseMessage = new ResponseMessage<>();
        Map<String, Object> condMap = new HashMap<>(16);
        condMap.put("supportServiceType", StoreCoupons.SupportServiceType.ALL);
        condMap.put("storeIdList", idBatchVo.getIdList());
        List<StoreCoupons> list = this.storeCouponsMapper.listAllServiceByStoreIdBatch(condMap);
        if (CollectionUtils.isEmpty(list)) {
            throw new ResponseException(StoreConstant.Query.COUPONS_STORE_NULL, StoreConstant.Query.COUPONS_STORE_NULL_MSG);
        }
        responseMessage.setData(list);
        return responseMessage;
    }

}