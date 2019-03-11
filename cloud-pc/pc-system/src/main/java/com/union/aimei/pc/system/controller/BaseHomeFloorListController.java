package com.union.aimei.pc.system.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseHomeFloorList;
import com.union.aimei.common.vo.system.pc.BaseHomeFloorListVo;
import com.union.aimei.pc.system.service.BaseHomeFloorListService;
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
     * @param floorId
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "获取 BaseHomeFloorListVo 分页列表数据")
    @PostMapping("/1.1.0/findByVoPageForFront/{floorId}")
    public ResponseMessage<PageInfo<BaseHomeFloorListVo>> findByVoPageForFrontV110(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo,
                                                                                   @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize,
                                                                                   @ApiParam(value = "楼层id") @PathVariable(value = "floorId") Integer floorId) {
        return this.baseHomeFloorListService.findByVoPageForFrontV110(pageNo, pageSize, floorId);
    }

    /**
     * 根据floorId更新数据(v1.1.0)
     *
     * @param baseHomeFloorList
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "根据floorId更新数据(v1.1.0)")
    @PutMapping("/1.1.0/updateByFloorId")
    public ResponseMessage updateByFloorIdV110(@ApiParam(value = "数据") @RequestBody BaseHomeFloorList baseHomeFloorList) {
        return this.baseHomeFloorListService.updateByFloorIdV110(baseHomeFloorList);
    }

    /**
     * 批量添加楼层商品数据(v1.1.0)
     *
     * @param baseHomeFloorListList
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "批量添加楼层商品数据(v1.1.0)")
    @PostMapping("/1.1.0/addBatch")
    public ResponseMessage addBatchV110(@ApiParam(value = "数据") @RequestBody List<BaseHomeFloorList> baseHomeFloorListList) {
        return this.baseHomeFloorListService.addBatchV110(baseHomeFloorListList);
    }

    /**
     * 根据楼层id获取已选择的产品(v1.1.0)
     *
     * @param floorId 楼层id
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "根据楼层id获取已选择的产品(v1.1.0)")
    @PostMapping("/1.1.0/findByFloorId/{floorId}/{productType}")
    public ResponseMessage<List<BaseHomeFloorList>> findByFloorIdV110(@ApiParam(value = "楼层id") @PathVariable(value = "floorId") int floorId,
                                                                      @ApiParam(value = "产品类型") @PathVariable(value = "productType") int productType) {
        return this.baseHomeFloorListService.findByFloorIdV110(floorId, productType);
    }

}