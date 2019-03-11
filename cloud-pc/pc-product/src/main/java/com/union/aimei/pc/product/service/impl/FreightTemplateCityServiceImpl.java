package com.union.aimei.pc.product.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.product.FreightTemplateCity;
import com.union.aimei.pc.product.mapper.FreightTemplateCityMapper;
import com.union.aimei.pc.product.service.FreightTemplateCityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 运费模板城市
 *
 * @author liurenkai
 * @time 2018/3/12 16:35
 */
@Service("freightTemplateCityService")
public class FreightTemplateCityServiceImpl implements FreightTemplateCityService {
    @Resource
    private FreightTemplateCityMapper freightTemplateCityMapper;

    /**
     * 前端分页查询运费模板城市
     *
     * @param pageNo              分页索引
     * @param pageSize            每页显示数量
     * @param freightTemplateCity 查询条件
     * @return
     */
    @Override
    public PageInfo<FreightTemplateCity> findByPageForFront(Integer pageNo, Integer pageSize, FreightTemplateCity freightTemplateCity) {
        PageHelper.startPage(pageNo, pageSize);
        List<FreightTemplateCity> list = this.freightTemplateCityMapper.selectListByConditions(freightTemplateCity);
        PageInfo<FreightTemplateCity> page = new PageInfo<>(list);
        return page;
    }

    /**
     * 添加运费模板城市
     *
     * @param freightTemplateCity
     * @return
     */
    @Override
    public int addObj(FreightTemplateCity freightTemplateCity) {
        return this.freightTemplateCityMapper.insertSelective(freightTemplateCity);
    }

    /**
     * 删除运费模板城市
     *
     * @param id
     * @return
     */
    @Override
    public int deleteObjById(int id) {
        return this.freightTemplateCityMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改运费模板城市
     *
     * @param freightTemplateCity
     * @return
     */
    @Override
    public int modifyObj(FreightTemplateCity freightTemplateCity) {
        return this.freightTemplateCityMapper.updateByPrimaryKeySelective(freightTemplateCity);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnfreightTemplateCity
     */
    @Override
    public FreightTemplateCity queryObjById(int id) {
        FreightTemplateCity model = this.freightTemplateCityMapper.selectByPrimaryKey(id);
        return model;
    }
}