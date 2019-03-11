package com.union.aimei.pc.api.store;

import com.union.aimei.common.model.store.GrowthRuleLog;
import com.union.aimei.common.feign.pc.store.GrowthRuleLogFeign;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author caizhaoming
 * @version 1.1
 * @create 2018-06-21 11:43
 **/
@Api(tags = "成长规则日志表")
@RestController
@RequestMapping(value = "growthRuleLog")
public class GrowthRuleLogApiController {
    @Resource
    private GrowthRuleLogFeign growthRuleLogFeign;

    /**
     * 分页查询
     *
     * @param pageNo        分页索引
     * @param pageSize      每页显示数量
     * @param growthRuleLog 查询条件
     * @return ResponseMessage<GrowthRuleLog>
     */
    @ApiOperation(httpMethod = "POST", value = "前端分页查询成长规则日志表")
    @PostMapping("/front/findByPage")
    public ResponseMessage<GrowthRuleLog> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0")
                                                                     Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10")
                                                                     Integer pageSize, @ApiParam(value = "查询条件") @RequestBody GrowthRuleLog growthRuleLog) {
        return new ResponseMessage(this.growthRuleLogFeign.findByPageForFront(pageNo, pageSize, growthRuleLog));
    }

    /**
     * 添加GrowthRuleLog
     *
     * @param growthRuleLog
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "添加成长规则日志表")
    @PostMapping("/insert")
    public ResponseMessage insert(@RequestBody GrowthRuleLog growthRuleLog) {
        return new ResponseMessage(this.growthRuleLogFeign.insert(growthRuleLog));
    }

    /**
     * 删除GrowthRuleLog
     *
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "DELETE", value = "删除成长规则日志表")
    @DeleteMapping("/deleteById/{id}")
    public ResponseMessage deleteById(@PathVariable(value = "id") int id) {
        return new ResponseMessage(this.growthRuleLogFeign.deleteById(id));
    }

    /**
     * 修改GrowthRuleLog
     *
     * @param growthRuleLog
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "编辑成长规则日志表")
    @PutMapping("/edit")
    public ResponseMessage edit(@RequestBody GrowthRuleLog growthRuleLog) {
        return new ResponseMessage(this.growthRuleLogFeign.edit(growthRuleLog));
    }

    /**
     * 根据ID查询GrowthRuleLog
     *
     * @param id
     * @returngrowthRuleLog
     */
    @ApiOperation(httpMethod = "GET", value = "通过ID查询成长规则日志表")
    @GetMapping("/queryById/{id}")
    public ResponseMessage<GrowthRuleLog> queryById(@PathVariable(value = "id") int id) {
        return new ResponseMessage(this.growthRuleLogFeign.queryById(id));
    }
}