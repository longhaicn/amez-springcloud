package com.union.aimei.common.feign.app.system;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.system.hystrix.BaseHomeTemplateApiHystrix;
import com.union.aimei.common.model.system.BaseHomeTemplate;
import com.union.aimei.common.vo.system.app.BaseHomeTemplateRo;
import com.union.aimei.common.vo.system.app.BaseHomeTemplateVo;
import com.union.aimei.common.vo.system.app.SelectBaseHomeTemplateVo;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author dell
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
@FeignClient(serviceId = "APP-SYSTEM-SERVICE", fallback = BaseHomeTemplateApiHystrix.class)
public interface BaseHomeTemplateFeign {
    /**
     * 添加首页模板
     *
     * @param baseHomeTemplate
     * @return
     */
    @PostMapping(value = "/baseHomeTemplate/insert")
    int insert(@RequestBody BaseHomeTemplate baseHomeTemplate);

    /**
     * 删除首页模板
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/baseHomeTemplate/deleteById/{id}")
    int deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改首页模板
     *
     * @param baseHomeTemplate
     * @return
     */
    @PutMapping(value = "/baseHomeTemplate/edit")
    int edit(@RequestBody BaseHomeTemplate baseHomeTemplate);

    /**
     * 根据ID查询
     *
     * @param id
     * @returnbaseHomeTemplate
     */
    @GetMapping(value = "/baseHomeTemplate/queryById/{id}")
    BaseHomeTemplate queryById(@PathVariable(value = "id") int id);

    /**
     * 前端分页查询首页模板
     *
     * @param pageNo           分页索引
     * @param pageSize         每页显示数量
     * @param baseHomeTemplate 查询条件
     * @return
     */
    @PostMapping(value = "/baseHomeTemplate/front/findByPage")
    PageInfo<BaseHomeTemplate> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                  @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                  @RequestBody BaseHomeTemplate baseHomeTemplate);

    /**
     * 更新首页模板软删除标记
     *
     * @param id        ID
     * @param isEnabled 软删除标记，1为正常，0为删除
     * @return
     */
    @PutMapping(value = "/baseHomeTemplate/isEnabled/{id}/{isEnabled}")
    ResponseMessage isEnabled(@PathVariable(value = "id") int id, @PathVariable(value = "isEnabled") int isEnabled);

    /**
     * 根据条件查询模版基础数据列表(v1.1.0)
     *
     * @param baseHomeTemplate
     * @return
     */
    @PostMapping("/baseHomeTemplate/1.1.0/findForFront")
    ResponseMessage<List<BaseHomeTemplate>> findForFrontV110(@RequestBody BaseHomeTemplate baseHomeTemplate);

    /**
     * 获取模版页面的基础数据(v1.1.0)
     *
     * @param selectBaseHomeTemplateVo
     * @return
     */
    @PostMapping("/baseHomeTemplate/1.1.0/getTemplateDate")
    ResponseMessage<BaseHomeTemplateVo> getTemplateDateV110(@RequestBody SelectBaseHomeTemplateVo selectBaseHomeTemplateVo);

    /**
     * 获取模版页面的基础数据(v1.1.1)
     *
     * @param selectBaseHomeTemplateVo
     * @return
     */
    @PostMapping("/baseHomeTemplate/1.1.1/getTemplateDate")
    ResponseMessage<BaseHomeTemplateRo> getTemplateDateV111(@RequestBody SelectBaseHomeTemplateVo selectBaseHomeTemplateVo);
}