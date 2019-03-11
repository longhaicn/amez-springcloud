package com.union.aimei.store.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.BeauticianGrowthValueLog;
import com.union.aimei.store.service.BeauticianGrowthValueLogService;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 美容师成长值记录
 *
 * @author liurenkai
 * @time 2018/6/4 13:34
 */
@Api(tags = "美容师成长值记录")
@RestController
@RequestMapping(value = "beauticianGrowthValueLog")
public class BeauticianGrowthValueLogController {
    @Resource
    private BeauticianGrowthValueLogService beauticianGrowthValueLogService;

    /**
     * 保存美容师成长值记录
     *
     * @param beauticianGrowthValueLog 美容师成长值记录
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "保存美容师成长值记录")
    @GetMapping(value = "/1.1.1/save")
    public ResponseMessage<BeauticianGrowthValueLog> saveV111(@RequestBody BeauticianGrowthValueLog beauticianGrowthValueLog) {
        return this.beauticianGrowthValueLogService.saveV111(beauticianGrowthValueLog);
    }

    /**
     * 根据美容师ID分页查询美容师成长值记录
     *
     * @param pageNo       分页索引
     * @param pageSize     每页数量
     * @param beauticianId 美容师ID
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "根据美容师ID分页查询美容师成长值记录（美容师-我的-成长值-成长值明细）")
    @PostMapping(value = "/1.1.1/listByBeauticianId/{beauticianId}")
    public ResponseMessage<PageInfo<BeauticianGrowthValueLog>> listByBeauticianIdV111(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                      @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                      @PathVariable(value = "beauticianId") int beauticianId) {
        return this.beauticianGrowthValueLogService.listByBeauticianIdV111(pageNo, pageSize, beauticianId);
    }

}