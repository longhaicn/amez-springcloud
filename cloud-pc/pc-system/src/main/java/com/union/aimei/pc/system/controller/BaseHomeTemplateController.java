package com.union.aimei.pc.system.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseHomeTemplate;
import com.union.aimei.common.vo.system.pc.BaseHomeTemplateVo;
import com.union.aimei.common.vo.system.pc.SelectBaseHomeTemplateVo;
import com.union.aimei.pc.system.async.BaseHomeTemplateDateAsyncTask;
import com.union.aimei.pc.system.service.BaseHomeTemplateService;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 首页模板
 *
 * @author liurenkai
 * @time 2017/12/26 19:26
 */
@Api(tags = "首页模板")
@RestController
@RequestMapping(value = "baseHomeTemplate")
public class BaseHomeTemplateController {

    @Resource
    private BaseHomeTemplateService baseHomeTemplateService;

    @Resource
    private BaseHomeTemplateDateAsyncTask baseHomeTemplateDateAsyncTask;

    @PostMapping("/front/findByPage")
    public PageInfo<BaseHomeTemplate> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                         @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                         @ApiParam(value = "查询条件") @RequestBody BaseHomeTemplate baseHomeTemplate) {
        return this.baseHomeTemplateService.findByPageForFront(pageNo, pageSize, baseHomeTemplate);
    }

    @PostMapping("/insert")
    public int insert(@RequestBody BaseHomeTemplate baseHomeTemplate) {
        return this.baseHomeTemplateService.addObj(baseHomeTemplate);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable(value = "id") int id) {
        return this.baseHomeTemplateService.deleteObjById(id);
    }

    @PutMapping("/edit")
    public int edit(@RequestBody BaseHomeTemplate baseHomeTemplate) {
        return this.baseHomeTemplateService.modifyObj(baseHomeTemplate);
    }

    @GetMapping("/queryById/{id}")
    public BaseHomeTemplate queryById(@PathVariable(value = "id") int id) {
        return this.baseHomeTemplateService.queryObjById(id);
    }

    @PutMapping("/isEnabled/{id}/{isEnabled}")
    public ResponseMessage isEnabled(@PathVariable(value = "id") int id, @PathVariable(value = "isEnabled") int isEnabled) {
        return this.baseHomeTemplateService.isEnabled(id, isEnabled);
    }


    /**
     * 批量添加模版基础数据(v1.1.0)
     *
     * @param baseHomeTemplateList
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "批量添加模版基础数据(v1.1.0)")
    @PostMapping("/1.1.0/addBatch")
    public ResponseMessage addBatchV110(@ApiParam(value = "参数数据") @RequestBody List<BaseHomeTemplate> baseHomeTemplateList) {
        return this.baseHomeTemplateService.addBatchV110(baseHomeTemplateList);
    }


    /**
     * 根据条件查询模版基础数据列表(v1.1.0)
     *
     * @param baseHomeTemplate
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "根据条件查询模版基础数据列表(v1.1.0)")
    @PostMapping("/1.1.0/findForFront")
    public ResponseMessage<List<BaseHomeTemplate>> findForFrontV110(@ApiParam(value = "参数数据") @RequestBody BaseHomeTemplate baseHomeTemplate) {
        return this.baseHomeTemplateService.findForFrontV110(baseHomeTemplate);
    }

    /**
     * 根据 区域id删除数据(v1.1.0)
     *
     * @param areaId
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据 区域id删除数据(v1.1.0)")
    @GetMapping("/1.1.0/deleteByAreaId/{areaId}")
    public ResponseMessage deleteByAreaIdV110(@PathVariable(value = "areaId") Integer areaId) {
        return this.baseHomeTemplateService.deleteByAreaIdV110(areaId);
    }

    /**
     * 根据 使用类型删除数据(v1.1.0)
     *
     * @param useType
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据 使用类型删除数据(v1.1.0)")
    @GetMapping("/1.1.0/deleteByUseTypeId/{useType}")
    public ResponseMessage deleteByUseTypeIdV110(@PathVariable(value = "useType") Integer useType) {
        return this.baseHomeTemplateService.deleteByUseTypeIdV110(useType);
    }

    /**
     * 获取模版页面的基础数据(v1.1.0)
     *
     * @param selectBaseHomeTemplateVo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "获取模版页面的基础数据(v1.1.0)")
    @PostMapping("/1.1.0/getTemplateDate")
    public ResponseMessage<BaseHomeTemplateVo> getTemplateDateV110(@ApiParam(value = "数据") @RequestBody SelectBaseHomeTemplateVo selectBaseHomeTemplateVo) {
        return this.baseHomeTemplateService.getTemplateDateV110(selectBaseHomeTemplateVo);
    }

    /**
     * 保存修改模版基本数据(v1.1.0)
     *
     * @param baseHomeTemplate 保存装修模版的基本数据
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "保存修改模版基本数据(v1.1.0)")
    @PostMapping("/1.1.0/templateDateInsertUpdate")
    public ResponseMessage templateDateInsertUpdateV110(@ApiParam(value = "保存装修模版的基本数据") @RequestBody BaseHomeTemplateVo baseHomeTemplate) {
        return this.baseHomeTemplateService.templateDateInsertUpdateV110(baseHomeTemplate);
    }


    /**
     * 异步查询所有城市数据保存到redis
     *
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "异步查询所有城市数据保存到redis")
    @GetMapping("/saveBaseHomeTemplateByRedis")
    public ResponseMessage saveBaseHomeTemplateByRedis() {
        this.baseHomeTemplateDateAsyncTask.saveBaseHomeTemplateByRedis();
        return new ResponseMessage();
    }

    /**
     * 保存楼层基础数据到mongodb
     *
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "保存楼层基础数据到mongodb")
    @GetMapping("/saveBaseHomeFloorDataByCityIdAnd/{cityId}/{useType}")
    public ResponseMessage saveBaseHomeFloorDataByCityIdAnd(@PathVariable(value = "cityId") Integer cityId,
                                                            @PathVariable(value = "useType") Integer useType) {
        return this.baseHomeTemplateService.saveBaseHomeFloorDataByCityIdAnd(cityId, useType);
    }


}