package com.union.aimei.store.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.constant.store.StoreBeauticianGradeConstant;
import com.union.aimei.common.model.store.StoreBeautician;
import com.union.aimei.common.model.store.StoreBeauticianGrade;
import com.union.aimei.store.mapper.StoreBeauticianGradeMapper;
import com.union.aimei.store.mapper.StoreBeauticianMapper;
import com.union.aimei.store.service.StoreBeauticianGradeService;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.exception.ServerException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author caizhaoming
 * @version 1.1
 * @create 2018-06-25 11:43
 **/
@Service("storeBeauticianGradeService")
public class StoreBeauticianGradeServiceImpl implements StoreBeauticianGradeService {

    @Resource
    private StoreBeauticianGradeMapper storeBeauticianGradeMapper;
    @Resource
    private StoreBeauticianMapper storeBeauticianMapper;

    /**
     * 前端分页查询店铺-美容师等级
     *
     * @param pageNo               分页索引
     * @param pageSize             每页显示数量
     * @param storeBeauticianGrade 查询条件
     * @return
     */
    @Override
    public PageInfo<StoreBeauticianGrade> findByPageForFront(Integer pageNo, Integer pageSize, StoreBeauticianGrade storeBeauticianGrade) {
        PageHelper.startPage(pageNo, pageSize);
        storeBeauticianGrade.setIsEnabled(StoreBeauticianGrade.IS_ENABLED_TURE);
        List<StoreBeauticianGrade> list = this.storeBeauticianGradeMapper.selectListByConditions(storeBeauticianGrade);
        PageInfo<StoreBeauticianGrade> page = new PageInfo<>(list);
        return page;
    }


    @Override
    public ResponseMessage deleteByStoreBeauticianGradeV111(Integer id) {
        //判断是否有美容师设置了等级
        StoreBeautician storeBeautician = new StoreBeautician();
        storeBeautician.setIsEnabled(true);
        storeBeautician.setGradeId(id);
        Integer total = this.storeBeauticianMapper.selectCountByConditions(storeBeautician);
        if (total != 0) {
            throw new ServerException(StoreBeauticianGradeConstant.Delete.DELETE_ERROR, StoreBeauticianGradeConstant.Delete.DELETE_ERROR_MESSAGE_NOT_DELETE);
        }
        StoreBeauticianGrade storeBeauticianGrade = new StoreBeauticianGrade();
        storeBeauticianGrade.setId(id);
        storeBeauticianGrade.setIsEnabled(StoreBeauticianGrade.IS_ENABLED_FALSE);
        this.storeBeauticianGradeMapper.updateByPrimaryKeySelective(storeBeauticianGrade);
        return new ResponseMessage();
    }

    /**
     * 添加店铺-美容师等级
     *
     * @param t
     * @return
     */
    @Override
    public int addObj(StoreBeauticianGrade t) {
        return this.storeBeauticianGradeMapper.insertSelective(t);
    }

    /**
     * 删除店铺-美容师等级
     *
     * @param id
     * @return
     */
    @Override
    public int deleteObjById(int id) {
        return this.storeBeauticianGradeMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改店铺-美容师等级
     *
     * @param t
     * @return
     */
    @Override
    public int modifyObj(StoreBeauticianGrade t) {
        return this.storeBeauticianGradeMapper.updateByPrimaryKeySelective(t);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnstoreBeauticianGrade
     */
    @Override
    public StoreBeauticianGrade queryObjById(int id) {
        StoreBeauticianGrade model = this.storeBeauticianGradeMapper.selectByPrimaryKey(id);
        return model;
    }
}