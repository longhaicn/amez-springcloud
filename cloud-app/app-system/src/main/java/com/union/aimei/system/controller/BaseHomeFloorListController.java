package com.union.aimei.system.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseHomeFloorList;
import com.union.aimei.common.vo.system.app.BaseHomeFloorListVo;
import com.union.aimei.system.service.BaseHomeFloorListService;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author caizhaoming
 * @create 2018-05-23 10:49
 **/
@Api(tags = "楼层列表数据表")
@RestController
@RequestMapping(value = "baseHomeFloorList")
public class BaseHomeFloorListController {
    @Resource
    private BaseHomeFloorListService baseHomeFloorListService;

    @PostMapping("/front/findByPage")
    public PageInfo<BaseHomeFloorList> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0")
                                                                  Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10")
                                                                  Integer pageSize, @ApiParam(value = "查询条件") @RequestBody BaseHomeFloorList baseHomeFloorList) {
        return this.baseHomeFloorListService.findByPageForFront(pageNo, pageSize, baseHomeFloorList);
    }

    @PostMapping("/insert")
    public int insert(@RequestBody BaseHomeFloorList baseHomeFloorList) {
        return this.baseHomeFloorListService.addObj(baseHomeFloorList);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable(value = "id") int id) {
        return this.baseHomeFloorListService.deleteObjById(id);
    }

    @PutMapping("/edit")
    public int edit(@RequestBody BaseHomeFloorList baseHomeFloorList) {
        return this.baseHomeFloorListService.modifyObj(baseHomeFloorList);
    }

    @GetMapping("/queryById/{id}")
    public BaseHomeFloorList queryById(@PathVariable(value = "id") int id) {
        return this.baseHomeFloorListService.queryObjById(id);
    }

    /**
     * 获取 BaseHomeFloorListVo 分页列表数据
     *
     * @param pageNo
     * @param pageSize
     * @param baseHomeFloorListVo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "获取 BaseHomeFloorListVo 分页列表数据")
    @PostMapping("/1.1.0/findByVoPageForFront")
    public ResponseMessage<PageInfo<BaseHomeFloorListVo>> findByVoPageForFrontV110(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo,
                                                                                   @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize,
                                                                                   @ApiParam(value = "查询条件") @RequestBody BaseHomeFloorListVo baseHomeFloorListVo) {
        return this.baseHomeFloorListService.findByVoPageForFrontV110(pageNo, pageSize, baseHomeFloorListVo);
    }

}