package com.union.aimei.pc.system.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseHomeArea;
import com.union.aimei.pc.system.service.BaseHomeAreaService;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author caizhaoming
 * @create 2018-05-23 10:49
 **/
@Api(tags = "首页区域表")
@RestController
@RequestMapping(value = "baseHomeArea")
public class BaseHomeAreaController {
    @Resource
    private BaseHomeAreaService baseHomeAreaService;

    @PostMapping("/front/findByPage")
    public PageInfo<BaseHomeArea> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0")
                                                             Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10")
                                                             Integer pageSize, @ApiParam(value = "查询条件") @RequestBody BaseHomeArea baseHomeArea) {
        return this.baseHomeAreaService.findByPageForFront(pageNo, pageSize, baseHomeArea);
    }

    @PostMapping("/insert")
    public int insert(@RequestBody BaseHomeArea baseHomeArea) {
        return this.baseHomeAreaService.addObj(baseHomeArea);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable(value = "id") int id) {
        return this.baseHomeAreaService.deleteObjById(id);
    }

    @PutMapping("/edit")
    public int edit(@RequestBody BaseHomeArea baseHomeArea) {
        return this.baseHomeAreaService.modifyObj(baseHomeArea);
    }

    @GetMapping("/queryById/{id}")
    public BaseHomeArea queryById(@PathVariable(value = "id") int id) {
        return this.baseHomeAreaService.queryObjById(id);
    }

    /**
     * 添加数据(v1.1.0)
     *
     * @param baseHomeArea
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "添加数据(v1.1.0)")
    @PostMapping("/1.1.0/insertBasehomeArea")
    public ResponseMessage insertBasehomeAreaV110(@ApiParam(value = "数据") @RequestBody BaseHomeArea baseHomeArea) {
        return this.baseHomeAreaService.insertBasehomeAreaV110(baseHomeArea);
    }

    /**
     * 根据区域数据获取list(v1.1.0)
     *
     * @param baseHomeArea
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "根据区域数据获取list(v1.1.0)")
    @PostMapping("/1.1.0/findForFront")
    public ResponseMessage<List<BaseHomeArea>> findForFrontV110(@ApiParam(value = "数据") @RequestBody BaseHomeArea baseHomeArea) {
        return this.baseHomeAreaService.findForFrontV110(baseHomeArea);
    }


}