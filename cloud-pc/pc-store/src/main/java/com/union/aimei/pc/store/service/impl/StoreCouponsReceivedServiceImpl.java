package com.union.aimei.pc.store.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreCouponsReceived;
import com.union.aimei.pc.store.mapper.StoreCouponsReceivedMapper;
import com.union.aimei.pc.store.service.StoreCouponsReceivedService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 店铺优惠券领取
 *
 * @author liurenkai
 * @time 2018/1/12 17:35
 */
@Service("storeCouponsReceivedService")
public class StoreCouponsReceivedServiceImpl implements StoreCouponsReceivedService {
    @Resource
    private StoreCouponsReceivedMapper storeCouponsReceivedMapper;

    /**
     * 前端分页查询店铺优惠券领取
     *
     * @param pageNo               分页索引
     * @param pageSize             每页显示数量
     * @param storeCouponsReceived 查询条件
     * @return
     */
    @Override
    public PageInfo<StoreCouponsReceived> findByPageForFront(Integer pageNo, Integer pageSize, StoreCouponsReceived storeCouponsReceived) {
        PageHelper.startPage(pageNo, pageSize);
        List<StoreCouponsReceived> list = this.storeCouponsReceivedMapper.selectListByConditions(storeCouponsReceived);
        PageInfo<StoreCouponsReceived> page = new PageInfo<>(list);
        return page;
    }

    /**
     * 添加店铺优惠券领取
     *
     * @param storeCouponsReceived
     * @return
     */
    @Override
    public int addObj(StoreCouponsReceived storeCouponsReceived) {
        return this.storeCouponsReceivedMapper.insertSelective(storeCouponsReceived);
    }

    /**
     * 删除店铺优惠券领取
     *
     * @param id
     * @return
     */
    @Override
    public int deleteObjById(int id) {
        return this.storeCouponsReceivedMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改店铺优惠券领取
     *
     * @param storeCouponsReceived
     * @return
     */
    @Override
    public int modifyObj(StoreCouponsReceived storeCouponsReceived) {
        return this.storeCouponsReceivedMapper.updateByPrimaryKeySelective(storeCouponsReceived);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnstoreCouponsReceived
     */
    @Override
    public StoreCouponsReceived queryObjById(int id) {
        StoreCouponsReceived model = this.storeCouponsReceivedMapper.selectByPrimaryKey(id);
        return model;
    }
}