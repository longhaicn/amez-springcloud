package com.union.aimei.pc.api.store;

import com.union.aimei.common.model.store.StoreSchedule;
import com.union.aimei.common.feign.pc.store.StoreScheduleFeign;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 店铺排班
 *
 * @author liurenkai
 * @time 2018/1/12 17:36
 */
@Api(tags = "店铺排班")
@RestController
@RequestMapping(value = "storeSchedule")
public class StoreScheduleApiController {
    @Resource
    private StoreScheduleFeign storeScheduleFeign;

    /**
     * 分页查询
     *
     * @param pageNo        分页索引
     * @param pageSize      每页显示数量
     * @param storeSchedule 查询条件
     * @return ResponseMessage<StoreSchedule>
     */
    @ApiOperation(httpMethod = "POST", value = "前端分页查询店铺排班")
    @PostMapping("/front/findByPage")
    public ResponseMessage<StoreSchedule> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0")
                                                                     Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10")
                                                                     Integer pageSize, @ApiParam(value = "查询条件") @RequestBody StoreSchedule storeSchedule) {
        return new ResponseMessage(this.storeScheduleFeign.findByPageForFront(pageNo, pageSize, storeSchedule));
    }

    /**
     * 添加StoreSchedule
     *
     * @param storeSchedule
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "添加店铺排班")
    @PostMapping("/insert")
    public ResponseMessage insert(@RequestBody StoreSchedule storeSchedule) {
        return new ResponseMessage(this.storeScheduleFeign.insert(storeSchedule));
    }

    /**
     * 删除StoreSchedule
     *
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "DELETE", value = "删除店铺排班")
    @DeleteMapping("/deleteById/{id}")
    public ResponseMessage deleteById(@PathVariable(value = "id") int id) {
        return new ResponseMessage(this.storeScheduleFeign.deleteById(id));
    }

    /**
     * 修改StoreSchedule
     *
     * @param storeSchedule
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "编辑店铺排班")
    @PutMapping("/edit")
    public ResponseMessage edit(@RequestBody StoreSchedule storeSchedule) {
        return new ResponseMessage(this.storeScheduleFeign.edit(storeSchedule));
    }

    /**
     * 根据ID查询StoreSchedule
     *
     * @param id
     * @returnstoreSchedule
     */
    @ApiOperation(httpMethod = "GET", value = "通过ID查询店铺排班")
    @GetMapping("/queryById/{id}")
    public ResponseMessage<StoreSchedule> queryById(@PathVariable(value = "id") int id) {
        return new ResponseMessage(this.storeScheduleFeign.queryById(id));
    }
}