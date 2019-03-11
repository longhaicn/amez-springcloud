package com.union.aimei.pc.product.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.product.FreightTemplate;
import com.union.aimei.pc.product.service.FreightTemplateService;
import com.union.aimei.common.vo.product.pc.FreightTemplateByAddVo;
import com.union.aimei.common.vo.product.pc.FreightTemplateByDefaultResVo;
import com.union.aimei.common.vo.product.pc.FreightTemplateByDetailResVo;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 运费模板
 *
 * @author liurenkai
 * @time 2018/3/12 16:37
 */
@Api(tags = "运费模板")
@RestController
@RequestMapping(value = "freightTemplate")
public class FreightTemplateController {
    @Resource
    private FreightTemplateService freightTemplateService;

    /**
     * 分页查询运费模板
     *
     * @param pageNo          分页索引
     * @param pageSize        每页数量
     * @param freightTemplate 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "分页查询运费模板")
    @PostMapping("/front/findByPage")
    public ResponseMessage<PageInfo<FreightTemplate>> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo,
                                                                         @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize,
                                                                         @ApiParam(value = "查询条件") @RequestBody FreightTemplate freightTemplate) {
        return this.freightTemplateService.findByPageForFront(pageNo, pageSize, freightTemplate);
    }

    @PostMapping("/insert")
    public int insert(@RequestBody FreightTemplate freightTemplate) {
        return this.freightTemplateService.addObj(freightTemplate);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable(value = "id") int id) {
        return this.freightTemplateService.deleteObjById(id);
    }

    @PutMapping("/edit")
    public int edit(@RequestBody FreightTemplate freightTemplate) {
        return this.freightTemplateService.modifyObj(freightTemplate);
    }

    @GetMapping("/queryById/{id}")
    public FreightTemplate queryById(@PathVariable(value = "id") int id) {
        return this.freightTemplateService.queryObjById(id);
    }

    /**
     * 分页查询运费模板（模板）
     *
     * @param pageNo          分页索引
     * @param pageSize        每页数量
     * @param freightTemplate 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "分页查询运费模板（模板）")
    @PostMapping("/findByPageForDefault")
    public ResponseMessage<PageInfo<FreightTemplateByDefaultResVo>> findByPageForDefault(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo,
                                                                                         @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize,
                                                                                         @ApiParam(value = "查询条件") @RequestBody FreightTemplate freightTemplate) {
        return this.freightTemplateService.findByPageForDefault(pageNo, pageSize, freightTemplate);
    }

    /**
     * 详情
     *
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "详情")
    @GetMapping("/detail/{id}")
    public ResponseMessage<FreightTemplateByDetailResVo> detail(@ApiParam(value = "ID") @PathVariable(value = "id") int id) {
        return this.freightTemplateService.detail(id);
    }


    /**
     * 添加
     *
     * @param addVo 条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "添加")
    @PostMapping("/add")
    public ResponseMessage add(@ApiParam("添加") @RequestBody FreightTemplateByAddVo addVo) {
        return this.freightTemplateService.add(addVo);
    }

    /**
     * 修改
     *
     * @param addVo 条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "修改")
    @PostMapping("/modify")
    public ResponseMessage modify(@ApiParam("修改") @RequestBody FreightTemplateByAddVo addVo) {
        return this.freightTemplateService.modify(addVo);
    }

    /**
     * 根据模板名称查询数量
     *
     * @param templateName 模版名称
     * @param notId        不等于的ID
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "根据模板名称查询数量")
    @PostMapping("/selectCountByTemplateName")
    public ResponseMessage selectCountByTemplateName(@ApiParam(value = "模版名称") @RequestParam(value = "templateName") String templateName,
                                                     @ApiParam(value = "不等于的ID，（新增的时候可以不传或传空，修改的时候需要传模版对象的ID）") @RequestParam(value = "notId") Integer notId) {
        return this.freightTemplateService.selectCountByTemplateName(templateName, notId);
    }
    
}