package com.union.aimei.system.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseHomeFloor;
import com.union.aimei.common.vo.system.app.BaseHomeFloorPageVo;
import com.union.aimei.common.vo.system.app.SelectBaseHomeTemplateVo;
import com.union.aimei.system.service.BaseHomeFloorService;
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
        return this.baseHomeFloorService.findByPageForFront (pageNo, pageSize, baseHomeFloor);
    }

    @PostMapping("/insert")
    public int insert(@RequestBody BaseHomeFloor baseHomeFloor) {
        return this.baseHomeFloorService.addObj (baseHomeFloor);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable(value = "id") int id) {
        return this.baseHomeFloorService.deleteObjById (id);
    }

    @PutMapping("/edit")
    public int edit(@RequestBody BaseHomeFloor baseHomeFloor) {
        return this.baseHomeFloorService.modifyObj (baseHomeFloor);
    }

    @GetMapping("/queryById/{id}")
    public BaseHomeFloor queryById(@PathVariable(value = "id") int id) {
        return this.baseHomeFloorService.queryObjById (id);
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
        return this.baseHomeFloorService.findForFrontV110 (baseHomeFloor);
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
        return this.baseHomeFloorService.findPageFloorDateV110 (pageNo, pageSize, selectBaseHomeTemplateVo);
    }


}