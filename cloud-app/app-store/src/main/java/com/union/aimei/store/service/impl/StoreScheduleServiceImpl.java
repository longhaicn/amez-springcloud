package com.union.aimei.store.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreSchedule;
import com.union.aimei.common.model.store.StoreScheduleBeauticianRef;
import com.union.aimei.store.mapper.StoreScheduleBeauticianRefMapper;
import com.union.aimei.store.mapper.StoreScheduleMapper;
import com.union.aimei.store.service.StoreScheduleService;
import com.union.aimei.common.vo.store.app.StoreScheduleVo;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 店铺排班
 *
 * @author liurenkai
 * @time 2017/12/25 10:58
 */
@Service("storeScheduleService")
public class StoreScheduleServiceImpl implements StoreScheduleService {
    @Resource
    private StoreScheduleMapper storeScheduleMapper;
    @Resource
    private StoreScheduleBeauticianRefMapper storeScheduleBeauticianRefMapper;

    /**
     * 前端分页查询店铺排班
     *
     * @param pageNo        分页索引
     * @param pageSize      每页显示数量
     * @param storeSchedule 查询条件
     * @return
     */
    @Override
    public PageInfo<StoreSchedule> findByPageForFront(Integer pageNo, Integer pageSize, StoreSchedule storeSchedule) {
        PageHelper.startPage(pageNo, pageSize);
        List<StoreSchedule> list = this.storeScheduleMapper.selectListByConditions(storeSchedule);
        PageInfo<StoreSchedule> page = new PageInfo<>(list);
        return page;
    }

    @Override
    public ResponseMessage add(StoreScheduleVo storeScheduleVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        // 店铺排班
        StoreSchedule storeSchedule = storeScheduleVo.getStoreSchedule();
        this.storeScheduleMapper.insertSelective(storeSchedule);
        // 店铺排班-美容师-关联
        List<StoreScheduleBeauticianRef> beauticianRefList = storeScheduleVo.getBeauticianRefList();
        for (StoreScheduleBeauticianRef beauticianRef : beauticianRefList) {
            beauticianRef.setStoreScheduleId(storeSchedule.getId());
            this.storeScheduleBeauticianRefMapper.insertSelective(beauticianRef);
        }
        return responseMessage;
    }

    @Override
    public ResponseMessage modify(StoreScheduleVo storeScheduleVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        // 店铺排班
        StoreSchedule storeSchedule = storeScheduleVo.getStoreSchedule();
        this.storeScheduleMapper.updateByPrimaryKeySelective(storeSchedule);
        // 删除原店铺排班-美容师-关联
        this.storeScheduleBeauticianRefMapper.deleteByStoreScheduleId(storeSchedule.getId());
        // 新增新店铺排班-美容师-关联
        List<StoreScheduleBeauticianRef> beauticianRefList = storeScheduleVo.getBeauticianRefList();
        for (StoreScheduleBeauticianRef beauticianRef : beauticianRefList) {
            beauticianRef.setStoreScheduleId(storeSchedule.getId());
            this.storeScheduleBeauticianRefMapper.insertSelective(beauticianRef);
        }
        return responseMessage;
    }

    @Override
    public ResponseMessage isEnabled(int id, int isEnabled) {
        ResponseMessage responseMessage = new ResponseMessage();
        // 店铺排班
        StoreSchedule storeSchedule = new StoreSchedule();
        storeSchedule.setId(id);
        storeSchedule.setIsEnabled(1 == isEnabled ? true : false);
        this.storeScheduleMapper.updateByPrimaryKeySelective(storeSchedule);
        // 店铺排班-美容师-关联
        StoreScheduleBeauticianRef storeScheduleBeauticianRef = new StoreScheduleBeauticianRef();
        storeScheduleBeauticianRef.setStoreScheduleId(id);
        storeScheduleBeauticianRef.setIsEnabled(1 == isEnabled ? true : false);
        this.storeScheduleBeauticianRefMapper.updateByIsEnabledByStoreScheduleId(storeScheduleBeauticianRef);
        return responseMessage;
    }

    @Override
    public ResponseMessage<List<StoreScheduleVo>> findListByStoreId(int storeId) {
        ResponseMessage<List<StoreScheduleVo>> responseMessage = new ResponseMessage<>();
        List<StoreScheduleVo> storeScheduleVoList = new ArrayList<>(10);
        // 店铺排班条件
        StoreSchedule storeScheduleConditions = new StoreSchedule();
        storeScheduleConditions.setStoreId(storeId);
        // 店铺排班
        List<StoreSchedule> storeScheduleList = this.storeScheduleMapper.selectListByConditions(storeScheduleConditions);
        for (StoreSchedule storeSchedule : storeScheduleList) {
            // 店铺排班-美容师-关联条件
            StoreScheduleBeauticianRef storeScheduleBeauticianRefConditions = new StoreScheduleBeauticianRef();
            storeScheduleBeauticianRefConditions.setStoreScheduleId(storeSchedule.getId());
            // 店铺排班-美容师-关联
            List<StoreScheduleBeauticianRef> beauticianRefList = this.storeScheduleBeauticianRefMapper.selectListByConditions(storeScheduleBeauticianRefConditions);
            // 店铺排班vo
            StoreScheduleVo storeScheduleVo = new StoreScheduleVo();
            storeScheduleVo.setStoreSchedule(storeSchedule);
            storeScheduleVo.setBeauticianRefList(beauticianRefList);
            storeScheduleVoList.add(storeScheduleVo);
        }
        responseMessage.setData(storeScheduleVoList);
        return responseMessage;
    }
}