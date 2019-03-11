package com.union.aimei.pc.system.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseHomeFloor;
import com.union.aimei.common.vo.system.pc.BaseHomeFloorPageVo;
import com.union.aimei.common.vo.system.pc.BaseHomeFloorVo;
import com.union.aimei.common.vo.system.pc.SelectBaseHomeTemplateVo;
import com.union.aimei.pc.system.service.BaseHomeFloorService;
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
@Api(tags = "楼层管理表")
@RestController
@RequestMapping(value = "baseHomeFloor")
public class BaseHomeFloorController {
    @Resource
    private BaseHomeFloorService baseHomeFloorService;

    @PostMapping("/front/findByPage")
    public PageInfo<BaseHomeFloor> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0")
                                                              Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10")
                                                              Integer pageSize, @ApiParam(value = "查询条件") @RequestBody BaseHomeFloor baseHomeFloor) {
        return this.baseHomeFloorService.findByPageForFront(pageNo, pageSize, baseHomeFloor);
    }

    @PostMapping("/insert")
    public int insert(@RequestBody BaseHomeFloor baseHomeFloor) {
        return this.baseHomeFloorService.addObj(baseHomeFloor);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable(value = "id") int id) {
        return this.baseHomeFloorService.deleteObjById(id);
    }

    @PutMapping("/edit")
    public int edit(@RequestBody BaseHomeFloor baseHomeFloor) {
        return this.baseHomeFloorService.modifyObj(baseHomeFloor);
    }

    @GetMapping("/queryById/{id}")
    public BaseHomeFloor queryById(@PathVariable(value = "id") int id) {
        return this.baseHomeFloorService.queryObjById(id);
    }

    /**
     * 根据条件删除数据(v1.1.0)
     *
     * @param baseHomeFloor
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "根据条件删除数据(v1.1.0)")
    @PostMapping("/1.1.0/deleteByFront")
    public ResponseMessage deleteByFrontV110(@ApiParam(value = "参数数据") @RequestBody BaseHomeFloor baseHomeFloor) {
        return this.baseHomeFloorService.deleteByFrontV110(baseHomeFloor);
    }

    /**
     * 批量添加数据(v1.1.0)
     *
     * @param list
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "批量添加数据(v1.1.0)")
    @PostMapping("/1.1.0/addBatch")
    public ResponseMessage<List<BaseHomeFloor>> addBatchV110(@ApiParam(value = "参数数据") @RequestBody List<BaseHomeFloor> list) {
        return this.baseHomeFloorService.addBatchV110(list);
    }

    /**
     * 根据条件获取列表数据(v1.1.0)
     *
     * @param baseHomeFloor
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "根据条件获取列表数据(v1.1.0)")
    @PostMapping("/1.1.0/findForFront")
    public ResponseMessage<List<BaseHomeFloor>> findForFrontV110(@ApiParam(value = "参数数据") @RequestBody BaseHomeFloor baseHomeFloor) {
        return this.baseHomeFloorService.findForFrontV110(baseHomeFloor);
    }

    /**
     * 获取模版页面的楼层数据(v1.1.0)
     *
     * @param pageNo
     * @param pageSize
     * @param selectBaseHomeTemplateVo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "获取模版页面的楼层数据(v1.1.0)")
    @PostMapping("/1.1.0/findPageFloorDate")
    public ResponseMessage<PageInfo<BaseHomeFloorPageVo>> findPageFloorDateV110(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo,
                                                                                @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize,
                                                                                @ApiParam(value = "查询条件") @RequestBody SelectBaseHomeTemplateVo selectBaseHomeTemplateVo) {
        return this.baseHomeFloorService.findPageFloorDateV110(pageNo, pageSize, selectBaseHomeTemplateVo);
    }

    /**
     * 批量更新数据(v1.1.0)
     *
     * @param baseHomeFloorList 更新的数据
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "批量更新数据(v1.1.0)")
    @PutMapping("/1.1.0/editBatch")
    public ResponseMessage<List<BaseHomeFloor>> editBatchV110(@ApiParam(value = "数据") @RequestBody List<BaseHomeFloor> baseHomeFloorList) {
        return this.baseHomeFloorService.editBatchV110(baseHomeFloorList);
    }

    /**
     * 添加模版楼层数据(v1.1.0)
     *
     * @param baseHomeFloorVo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "添加模版楼层数据(v1.1.0)")
    @PostMapping("/1.1.0/floorDateInsertUpdate")
    public ResponseMessage<List<BaseHomeFloor>> floorDateInsertV110(@ApiParam(value = "数据") @RequestBody BaseHomeFloorVo baseHomeFloorVo) {
        return this.baseHomeFloorService.floorDateInsertV110(baseHomeFloorVo);
    }


}
