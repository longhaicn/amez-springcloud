package com.union.aimei.pc.product.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.product.PhysicalFreightTemplateRef;
import com.union.aimei.pc.product.service.PhysicalFreightTemplateRefService;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 产品-运费模板-关联
 *
 * @author liurenkai
 * @time 2018/3/12 16:37
 */
@Api(tags = "产品-运费模板-关联")
@RestController
@RequestMapping(value = "physicalFreightTemplateRef")
public class PhysicalFreightTemplateRefController {
    @Resource
    private PhysicalFreightTemplateRefService physicalFreightTemplateRefService;

    /**
     * 分页查询
     *
     * @author liurenkai
     * @time 2018/3/13 16:33
     */
    @ApiOperation(httpMethod = "POST", value = "分页查询")
    @PostMapping("/front/findByPage")
    public ResponseMessage<PageInfo<PhysicalFreightTemplateRef>> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo,
                                                                                    @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize,
                                                                                    @ApiParam(value = "查询条件") @RequestBody PhysicalFreightTemplateRef physicalFreightTemplateRef) {
        return this.physicalFreightTemplateRefService.findByPageForFront(pageNo, pageSize, physicalFreightTemplateRef);
    }

    @PostMapping("/insert")
    public int insert(@RequestBody PhysicalFreightTemplateRef physicalFreightTemplateRef) {
        return this.physicalFreightTemplateRefService.addObj(physicalFreightTemplateRef);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable(value = "id") int id) {
        return this.physicalFreightTemplateRefService.deleteObjById(id);
    }

    @PutMapping("/edit")
    public int edit(@RequestBody PhysicalFreightTemplateRef physicalFreightTemplateRef) {
        return this.physicalFreightTemplateRefService.modifyObj(physicalFreightTemplateRef);
    }

    @GetMapping("/queryById/{id}")
    public PhysicalFreightTemplateRef queryById(@PathVariable(value = "id") int id) {
        return this.physicalFreightTemplateRefService.queryObjById(id);
    }

    /**
     * 添加
     *
     * @param physicalFreightTemplateRef
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "添加")
    @PostMapping("/add")
    public ResponseMessage add(@ApiParam(value = "产品-运费模板-关联") @RequestBody PhysicalFreightTemplateRef physicalFreightTemplateRef) {
        return this.physicalFreightTemplateRefService.add(physicalFreightTemplateRef);
    }

}