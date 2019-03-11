package com.union.aimei.store.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreSchedule;
import com.union.aimei.store.service.StoreScheduleService;
import com.union.aimei.common.vo.store.app.StoreScheduleVo;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 店铺排班
 *
 * @author liurenkai
 * @time 2017/12/25 11:19
 */
@Api(tags = "店铺排班")
@RestController
@RequestMapping(value = "storeSchedule")
public class StoreScheduleController {
    @Resource
    private StoreScheduleService storeScheduleService;

    /**
     * 前端分页查询店铺排班
     *
     * @param pageNo        分页索引
     * @param pageSize      每页显示数量
     * @param storeSchedule 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "前端分页查询店铺排班")
    @PostMapping("/front/findByPage")
    public PageInfo<StoreSchedule> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                      @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                      @ApiParam(value = "查询条件") @RequestBody StoreSchedule storeSchedule) {
        return this.storeScheduleService.findByPageForFront(pageNo, pageSize, storeSchedule);
    }

    /**
     * 新增店铺排班
     *
     * @param storeScheduleVo 店铺排班vo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "新增店铺排班")
    @PostMapping("/add")
    public ResponseMessage add(@RequestBody StoreScheduleVo storeScheduleVo) {
        return this.storeScheduleService.add(storeScheduleVo);
    }

    /**
     * 修改店铺排班
     *
     * @param storeScheduleVo 店铺排班vo
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "修改店铺排班")
    @PutMapping("/modify")
    public ResponseMessage modify(@RequestBody StoreScheduleVo storeScheduleVo) {
        return this.storeScheduleService.modify(storeScheduleVo);
    }

    /**
     * 更新店铺排班软删除标记
     *
     * @param id        店铺排班ID
     * @param isEnabled 软删除标记，1为正常，0为删除
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "更新店铺排班软删除标记")
    @PutMapping("/isEnabled/{id}/{isEnabled}")
    public ResponseMessage isEnabled(@ApiParam(value = "店铺排班ID") @PathVariable(value = "id") int id,
                                     @ApiParam(value = "软删除标记，1为正常，0为删除") @PathVariable(value = "isEnabled") int isEnabled) {
        return this.storeScheduleService.isEnabled(id, isEnabled);
    }

    /**
     * 根据店铺ID查询店铺排班
     *
     * @param storeId 店铺ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据店铺ID查询店铺排班")
    @GetMapping("/findListByStoreId/{storeId}")
    public ResponseMessage<List<StoreScheduleVo>> findListByStoreId(@ApiParam(value = "店铺ID") @PathVariable(value = "storeId") int storeId) {
        return this.storeScheduleService.findListByStoreId(storeId);
    }
}