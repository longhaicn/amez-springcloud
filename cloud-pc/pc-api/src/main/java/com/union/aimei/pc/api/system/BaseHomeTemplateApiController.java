package com.union.aimei.pc.api.system;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.system.BaseHomeTemplateFeign;
import com.union.aimei.common.model.system.BaseHomeTemplate;
import com.union.aimei.common.vo.system.pc.BaseHomeTemplateVo;
import com.union.aimei.common.vo.system.pc.SelectBaseHomeTemplateVo;
import com.union.common.utils.AssertUtil;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseMessageFactory;
import com.union.common.utils.constant.ResponseContants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 首页模板
 *
 * @author liurenkai
 * @time 2017/12/26 19:31
 */
@Api(tags = "首页模板")
@RestController
@RequestMapping(value = "baseHomeTemplate")
public class BaseHomeTemplateApiController {

    @Resource
    private BaseHomeTemplateFeign baseHomeTemplateFeign;

    /**
     * 前端分页查询首页模板
     *
     * @param pageNo           分页索引
     * @param pageSize         每页显示数量
     * @param baseHomeTemplate 查询条件
     * @return ResponseMessage<BaseHomeTemplate>
     */
    @ApiOperation(httpMethod = "POST", value = "前端分页查询首页模板")
    @PostMapping("/front/findByPage")
    public ResponseMessage<BaseHomeTemplate> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                @ApiParam(value = "查询条件") @RequestBody BaseHomeTemplate baseHomeTemplate) {
        ResponseMessage result = ResponseMessageFactory.newInstance();
        PageInfo<BaseHomeTemplate> page = baseHomeTemplateFeign.findByPageForFront(pageNo, pageSize, baseHomeTemplate);
        if (page != null) {
            result.setData(page);
        } else {
            result.setCode(ResponseContants.QUERY_EMPTY);
            result.setMessage(ResponseContants.QUERY_EMPTY_MESSAGE);
        }
        return result;
    }

    /**
     * 添加首页模板
     *
     * @param baseHomeTemplate
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "添加首页模板")
    @PostMapping("/insert")
    public ResponseMessage insert(@RequestBody BaseHomeTemplate baseHomeTemplate) {
        ResponseMessage result = ResponseMessageFactory.newInstance();
        int res = this.baseHomeTemplateFeign.insert(baseHomeTemplate);
        AssertUtil.numberGtZero(res, ResponseContants.ADD_MESSAGE, ResponseContants.ADD);
        return result;
    }

    /**
     * 删除首页模板
     *
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "DELETE", value = "删除首页模板")
    @DeleteMapping("/deleteById/{id}")
    public ResponseMessage deleteById(@PathVariable(value = "id") int id) {
        ResponseMessage result = ResponseMessageFactory.newInstance();
        int res = this.baseHomeTemplateFeign.deleteById(id);
        AssertUtil.numberGtZero(res, ResponseContants.DELETE_MESSAGE, ResponseContants.DELETE);
        return result;
    }

    /**
     * 编辑首页模板
     *
     * @param baseHomeTemplate
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "编辑首页模板")
    @PutMapping("/edit")
    public ResponseMessage edit(@RequestBody BaseHomeTemplate baseHomeTemplate) {
        ResponseMessage result = ResponseMessageFactory.newInstance();
        int res = this.baseHomeTemplateFeign.edit(baseHomeTemplate);
        AssertUtil.numberGtZero(res, ResponseContants.EDIT_MESSAGE, ResponseContants.EDIT);
        return result;
    }

    /**
     * 通过ID查询首页模板
     *
     * @param id
     * @returnbaseHomeTemplate
     */
    @ApiOperation(httpMethod = "GET", value = "通过ID查询首页模板")
    @GetMapping("/queryById/{id}")
    public ResponseMessage<BaseHomeTemplate> queryById(@PathVariable(value = "id") int id) {
        ResponseMessage result = ResponseMessageFactory.newInstance();
        BaseHomeTemplate model = this.baseHomeTemplateFeign.queryById(id);
        AssertUtil.notNull(model, ResponseContants.QUERY_EMPTY_MESSAGE, ResponseContants.QUERY_EMPTY);
        result.setData(model);
        return result;
    }


    /**
     * 更新首页模板软删除标记
     *
     * @param id        ID
     * @param isEnabled 软删除标记，1为正常，0为删除
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "更新首页模板软删除标记")
    @PutMapping("/isEnabled/{id}/{isEnabled}")
    public ResponseMessage isEnabled(@ApiParam(value = "ID") @PathVariable(value = "id") int id,
                                     @ApiParam(value = "软删除标记，1为正常，0为删除") @PathVariable(value = "isEnabled") int isEnabled) {
        return this.baseHomeTemplateFeign.isEnabled(id, isEnabled);
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
        return this.baseHomeTemplateFeign.templateDateInsertUpdateV110(baseHomeTemplate);
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
        return this.baseHomeTemplateFeign.getTemplateDateV110(selectBaseHomeTemplateVo);
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
        return this.baseHomeTemplateFeign.saveBaseHomeFloorDataByCityIdAnd(cityId, useType);
    }


}