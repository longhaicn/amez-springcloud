package com.union.aimei.store.controller;

import com.union.aimei.common.model.store.BeauticianBusinessHour;
import com.union.aimei.common.vo.store.app.BeauticianBusinessHourByAddVo;
import com.union.aimei.common.vo.store.app.BeauticianBusinessHourByBatchVo;
import com.union.aimei.store.service.BeauticianBusinessHourService;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 美容师营业时间
 *
 * @author liurenkai
 * @time 2018/5/19 11:03
 */
@Api(tags = "美容师营业时间")
@RestController
@RequestMapping(value = "beauticianBusinessHour")
public class BeauticianBusinessHourController {
    @Resource
    private BeauticianBusinessHourService beauticianBusinessHourService;

    /**
     * 批量新增美容师营业时间
     *
     * @param batchVo 美容师营业时间集合
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "批量新增美容师营业时间")
    @PostMapping("/1.1.1/addBatch")
    public ResponseMessage addBatchV111(@ApiParam(value = "美容师营业时间集合") @RequestBody BeauticianBusinessHourByBatchVo batchVo) {
        return this.beauticianBusinessHourService.addBatchV111(batchVo.getBeauticianBusinessHourList());
    }

    /**
     * 根据美容师ID删除美容师营业时间
     *
     * @param beauticianId 美容师ID
     * @return
     */
    @ApiOperation(httpMethod = "DELETE", value = "根据美容师ID删除美容师营业时间")
    @DeleteMapping("/1.1.1/deleteByBeauticianId/{beauticianId}")
    public ResponseMessage deleteByBeauticianIdV111(@ApiParam(value = "美容师ID") @PathVariable(value = "beauticianId") int beauticianId) {
        return this.beauticianBusinessHourService.deleteByBeauticianIdV111(beauticianId);
    }

    /**
     * 根据美容师ID查询美容师营业时间
     *
     * @param beauticianId 美容师ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据美容师ID查询美容师营业时间")
    @GetMapping("/1.1.1/findListByBeauticianId/{beauticianId}")
    public ResponseMessage<List<BeauticianBusinessHour>> findListByBeauticianIdV111(@ApiParam(value = "美容师ID") @PathVariable(value = "beauticianId") int beauticianId) {
        return this.beauticianBusinessHourService.findListByBeauticianIdV111(beauticianId);
    }

    /**
     * 新增美容师营业时间（美容师-我的-服务设置-营业时间）
     *
     * @param addVo 新增条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "新增美容师营业时间（美容师-我的-服务设置-营业时间）")
    @PostMapping("/1.1.1/add")
    public ResponseMessage addV111(@ApiParam(value = "新增条件") @RequestBody BeauticianBusinessHourByAddVo addVo) {
        return this.beauticianBusinessHourService.addV111(addVo);
    }

}