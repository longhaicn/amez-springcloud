package com.union.aimei.common.feign.pc.system;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.system.hystrix.BaseHomeTemplateApiHystrix;
import com.union.aimei.common.model.system.BaseHomeTemplate;
import com.union.aimei.common.vo.system.pc.BaseHomeTemplateVo;
import com.union.aimei.common.vo.system.pc.SelectBaseHomeTemplateVo;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author dell
 */
@FeignClient(serviceId = "PC-SYSTEM-SERVICE", fallback = BaseHomeTemplateApiHystrix.class)
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
     * 批量添加模版基础数据(v1.1.0)
     *
     * @param baseHomeTemplateList
     * @return
     */
    @PostMapping("/baseHomeTemplate/1.1.0/addBatch")
    ResponseMessage addBatchV110(@RequestBody List<BaseHomeTemplate> baseHomeTemplateList);


    /**
     * 根据 区域id删除数据(v1.1.0)
     *
     * @param areaId
     * @return
     */
    @GetMapping("/baseHomeTemplate/1.1.0/deleteByAreaId/{areaId}")
    ResponseMessage deleteByAreaIdV110(@PathVariable(value = "areaId") int areaId);

    /**
     * 根据条件查询模版基础数据列表(v1.1.0)
     *
     * @param baseHomeTemplate
     * @return
     */
    @PostMapping("/baseHomeTemplate/1.1.0/findForFront")
    ResponseMessage<List<BaseHomeTemplate>> findForFrontV110(@RequestBody BaseHomeTemplate baseHomeTemplate);

    /**
     * 根据 使用类型删除数据(v1.1.0)
     *
     * @param useType
     * @return
     */
    @GetMapping("/baseHomeTemplate/1.1.0/deleteByUseTypeId/{useType}")
    ResponseMessage deleteByUseTypeIdV110(@PathVariable(value = "useType") Integer useType);

    /**
     * 获取模版页面的基础数据(v1.1.0)
     *
     * @param selectBaseHomeTemplateVo
     * @return
     */
    @PostMapping("/baseHomeTemplate/1.1.0/getTemplateDate")
    ResponseMessage<BaseHomeTemplateVo> getTemplateDateV110(@RequestBody SelectBaseHomeTemplateVo selectBaseHomeTemplateVo);

    /**
     * 保存修改模版基本数据(v1.1.0)
     *
     * @param baseHomeTemplate 保存装修模版的基本数据
     * @return
     */
    @PostMapping("/baseHomeTemplate/1.1.0/templateDateInsertUpdate")
    ResponseMessage templateDateInsertUpdateV110(@RequestBody BaseHomeTemplateVo baseHomeTemplate);


    /**
     * 异步查询所有城市数据保存到redis
     *
     * @return
     */
    @GetMapping("/baseHomeTemplate/saveBaseHomeTemplateByRedis")
    ResponseMessage saveBaseHomeTemplateByRedis();

    /**
     * 保存楼层基础数据到mongodb
     *
     * @return
     */
    @GetMapping("/baseHomeTemplate/saveBaseHomeFloorDataByCityIdAnd/{cityId}/{useType}")
    ResponseMessage saveBaseHomeFloorDataByCityIdAnd(@PathVariable(value = "cityId") Integer cityId,
                                                     @PathVariable(value = "useType") Integer useType);

}