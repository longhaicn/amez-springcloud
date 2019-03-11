package com.union.aimei.common.feign.pc.product.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.product.FreightTemplateCityFeign;
import com.union.aimei.common.model.product.FreightTemplateCity;
import org.springframework.stereotype.Component;

/**
 * 运费模板城市
 *
 * @author liurenkai
 * @time 2018/3/12 16:55
 */
@Component(value = "pc-FreightTemplateCityFeign")
public class FreightTemplateCityApiHystrix implements FreightTemplateCityFeign {

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
        return null;
    }

    /**
     * 添加运费模板城市
     *
     * @param freightTemplateCity
     * @return
     */
    @Override
    public int insert(FreightTemplateCity freightTemplateCity) {
        return 0;
    }

    /**
     * 删除运费模板城市
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改运费模板城市
     *
     * @param freightTemplateCity
     * @return
     */
    @Override
    public int edit(FreightTemplateCity freightTemplateCity) {
        return 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnfreightTemplateCity
     */
    @Override
    public FreightTemplateCity queryById(int id) {
        return null;
    }
}