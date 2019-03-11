package com.union.aimei.product.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.product.PhysicalCategoryRef;
import com.union.aimei.product.mapper.PhysicalCategoryRefMapper;
import com.union.aimei.product.service.PhysicalCategoryRefService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author caizhaoming
 * @version 1.1
 * @create 2018-06-21 11:43
 **/
@Service("physicalCategoryRefService")
public class PhysicalCategoryRefServiceImpl implements PhysicalCategoryRefService {
    @Resource
    private PhysicalCategoryRefMapper physicalCategoryRefMapper;

    /**
     * 前端分页查询产品-产品分类-关联
     *
     * @param pageNo              分页索引
     * @param pageSize            每页显示数量
     * @param physicalCategoryRef 查询条件
     * @return
     */
    @Override
    public PageInfo<PhysicalCategoryRef> findByPageForFront(Integer pageNo, Integer pageSize, PhysicalCategoryRef physicalCategoryRef) {
        PageHelper.startPage(pageNo, pageSize);
        List<PhysicalCategoryRef> list = this.physicalCategoryRefMapper.selectListByConditions(physicalCategoryRef);
        PageInfo<PhysicalCategoryRef> page = new PageInfo<>(list);
        return page;
    }

    /**
     * 添加产品-产品分类-关联
     *
     * @param physicalCategoryRef
     * @return
     */
    @Override
    public int addObj(PhysicalCategoryRef t) {
        return this.physicalCategoryRefMapper.insertSelective(t);
    }

    /**
     * 删除产品-产品分类-关联
     *
     * @param id
     * @return
     */
    @Override
    public int deleteObjById(int id) {
        return this.physicalCategoryRefMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改产品-产品分类-关联
     *
     * @param physicalCategoryRef
     * @return
     */
    @Override
    public int modifyObj(PhysicalCategoryRef t) {
        return this.physicalCategoryRefMapper.updateByPrimaryKeySelective(t);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnphysicalCategoryRef
     */
    @Override
    public PhysicalCategoryRef queryObjById(int id) {
        PhysicalCategoryRef model = this.physicalCategoryRefMapper.selectByPrimaryKey(id);
        return model;
    }
}