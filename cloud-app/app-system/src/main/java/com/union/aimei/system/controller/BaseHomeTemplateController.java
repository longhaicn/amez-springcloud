package com.union.aimei.system.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseHomeTemplate;
import com.union.aimei.common.vo.system.app.BaseHomeTemplateRo;
import com.union.aimei.common.vo.system.app.BaseHomeTemplateVo;
import com.union.aimei.common.vo.system.app.SelectBaseHomeTemplateVo;
import com.union.aimei.system.service.BaseHomeTemplateService;
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

    @PostMapping("/front/findByPage")
    public PageInfo<BaseHomeTemplate> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo,
                                                         @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize,
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
     * 获取模版页面的基础数据(v1.1.1)
     *
     * @param selectBaseHomeTemplateVo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "获取模版页面的基础数据(v1.1.1)")
    @PostMapping("/1.1.1/getTemplateDate")
    public ResponseMessage<BaseHomeTemplateRo> getTemplateDateV111(@ApiParam(value = "数据") @RequestBody SelectBaseHomeTemplateVo selectBaseHomeTemplateVo) {
        return this.baseHomeTemplateService.getTemplateDateV111(selectBaseHomeTemplateVo);
    }

}