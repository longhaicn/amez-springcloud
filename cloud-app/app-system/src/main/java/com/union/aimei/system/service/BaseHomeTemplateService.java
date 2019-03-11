package com.union.aimei.system.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseHomeTemplate;
import com.union.aimei.common.vo.system.app.BaseHomeTemplateRo;
import com.union.aimei.common.vo.system.app.BaseHomeTemplateVo;
import com.union.aimei.common.vo.system.app.SelectBaseHomeTemplateVo;
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
     * 获取模版页面的基础数据(1.1.1)
     *
     * @param selectBaseHomeTemplateVo
     * @return
     */
    ResponseMessage<BaseHomeTemplateRo> getTemplateDateV111(SelectBaseHomeTemplateVo selectBaseHomeTemplateVo);
}