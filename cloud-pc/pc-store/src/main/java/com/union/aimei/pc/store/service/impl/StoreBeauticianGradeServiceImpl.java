package com.union.aimei.pc.store.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreBeauticianGrade;
import com.union.aimei.pc.store.mapper.StoreBeauticianGradeMapper;
import com.union.aimei.pc.store.service.StoreBeauticianGradeService;
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
        List<StoreBeauticianGrade> list = this.storeBeauticianGradeMapper.selectListByConditions(storeBeauticianGrade);
        PageInfo<StoreBeauticianGrade> page = new PageInfo<>(list);
        return page;
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