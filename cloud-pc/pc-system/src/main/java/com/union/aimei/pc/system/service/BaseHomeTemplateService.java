package com.union.aimei.pc.system.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseHomeTemplate;
import com.union.aimei.common.vo.system.pc.BaseHomeTemplateVo;
import com.union.aimei.common.vo.system.pc.SelectBaseHomeTemplateVo;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.base.SpringCloudBaseService;

import java.util.List;

/**
 * 首页模板
 *
 * @author liurenkai
 * @time 2017/12/26 19:24
 */
public interface BaseHomeTemplateService extends SpringCloudBaseService<BaseHomeTemplate> {
    /**
     * 前端分页查询首页模板
     *
     * @param pageNo           分页索引
     * @param pageSize         每页显示数量
     * @param baseHomeTemplate 查询条件
     * @return
     */
    PageInfo<BaseHomeTemplate> findByPageForFront(Integer pageNo, Integer pageSize, BaseHomeTemplate baseHomeTemplate);

    /**
     * 更新首页模板软删除标记
     *
     * @param id        ID
     * @param isEnabled 软删除标记，1为正常，0为删除
     * @return
     */
    ResponseMessage isEnabled(int id, int isEnabled);

    /**
     * 批量添加模版基础数据(v1.1.0)
     *
     * @param baseHomeTemplateList
     * @return
     */
    ResponseMessage addBatchV110(List<BaseHomeTemplate> baseHomeTemplateList);

    /**
     * 根据 区域id删除数据(v1.1.0)
     *
     * @param areaId
     * @return
     */
    ResponseMessage deleteByAreaIdV110(Integer areaId);

    /**
     * 根据 使用类型删除数据(v1.1.0)
     *
     * @param useType
     * @return
     */
    ResponseMessage deleteByUseTypeIdV110(Integer useType);

    /**
     * 根据条件查询模版基础数据列表(v1.1.0)
     *
     * @param baseHomeTemplate
     * @return
     */
    ResponseMessage<List<BaseHomeTemplate>> findForFrontV110(BaseHomeTemplate baseHomeTemplate);

    /**
     * 获取模版页面的基础数据
     *
     * @param selectBaseHomeTemplateVo
     * @return
     */
    ResponseMessage<BaseHomeTemplateVo> getTemplateDateV110(SelectBaseHomeTemplateVo selectBaseHomeTemplateVo);

    /**
     * 添加模版基本数据
     *
     * @param baseHomeTemplateVo
     * @return
     */
    ResponseMessage templateDateInsertUpdateV110(BaseHomeTemplateVo baseHomeTemplateVo);

    /**
     * 装配商品类型的数据
     *
     * @param baseHomeTemplateList
     */
    void setProductCategoryDate(List<BaseHomeTemplate> baseHomeTemplateList);

    /**
     * 保存楼层基础数据到mongodb
     *
     * @param cityId
     * @param useType
     * @return
     */
    ResponseMessage saveBaseHomeFloorDataByCityIdAnd(Integer cityId, Integer useType);

}