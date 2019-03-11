package com.union.aimei.app.api.store;

import com.union.aimei.common.feign.app.store.BeauticianBusyTimeFeign;
import com.union.aimei.common.model.store.BeauticianBusyTime;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 美容师忙碌时间
 *
 * @author liurenkai
 * @time 2018/5/19 11:07
 */
@Api(tags = "美容师忙碌时间")
@RestController
@RequestMapping(value = "beauticianBusyTime")
public class BeauticianBusyTimeApiController {
    @Resource
    private BeauticianBusyTimeFeign beauticianBusyTimeFeign;

    /**
     * 新增美容师忙碌时间（美容师-我的-服务设置-忙时设置）
     *
     * @param beauticianBusyTime 美容师忙碌时间
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "新增美容师忙碌时间（美容师-我的-服务设置-忙时设置）")
    @PostMapping("/1.1.1/add")
    public ResponseMessage addV111(@ApiParam(value = "美容师忙碌时间") @RequestBody BeauticianBusyTime beauticianBusyTime) {
        return this.beauticianBusyTimeFeign.addV111(beauticianBusyTime);
    }

    /**
     * 根据忙碌日期查询美容师忙碌时间（美容师-我的-服务设置-忙时设置）
     *
     * @param beauticianId 美容师ID
     * @param busyDate     忙碌日期
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据忙碌日期查询美容师忙碌时间（美容师-我的-服务设置-忙时设置）")
    @GetMapping("/1.1.1/findByBeauticianIdForBusyDate/{beauticianId}/{busyDate}")
    public ResponseMessage<BeauticianBusyTime> findByBeauticianIdForBusyDateV111(@ApiParam(value = "美容师ID") @PathVariable(value = "beauticianId") int beauticianId,
                                                                                 @ApiParam(value = "忙碌日期") @PathVariable(value = "busyDate") String busyDate) {
        return this.beauticianBusyTimeFeign.findByBeauticianIdForBusyDateV111(beauticianId, busyDate);
    }

}