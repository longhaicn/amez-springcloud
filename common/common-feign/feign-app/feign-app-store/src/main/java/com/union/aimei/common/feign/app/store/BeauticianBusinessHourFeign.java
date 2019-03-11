package com.union.aimei.common.feign.app.store;

import com.union.aimei.common.feign.app.store.hystrix.BeauticianBusinessHourApiHystrix;
import com.union.aimei.common.model.store.BeauticianBusinessHour;
import com.union.aimei.common.vo.store.app.BeauticianBusinessHourByAddVo;
import com.union.aimei.common.vo.store.app.BeauticianBusinessHourByBatchVo;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 美容师营业时间
 *
 * @author liurenkai
 * @time 2018/5/19 11:04
 */
@FeignClient(serviceId = "APP-STORE-SERVICE", fallback = BeauticianBusinessHourApiHystrix.class)
public interface BeauticianBusinessHourFeign {

    /**
     * 批量新增美容师营业时间
     *
     * @param batchVo 美容师营业时间集合
     * @return
     */
    @PostMapping("/beauticianBusinessHour/1.1.1/addBatch")
    ResponseMessage addBatchV111(@RequestBody BeauticianBusinessHourByBatchVo batchVo);

    /**
     * 根据美容师ID删除美容师营业时间
     *
     * @param beauticianId 美容师ID
     * @return
     */
    @DeleteMapping("/beauticianBusinessHour/1.1.1/deleteByBeauticianId/{beauticianId}")
    ResponseMessage deleteByBeauticianIdV111(@PathVariable(value = "beauticianId") int beauticianId);

    /**
     * 根据美容师ID查询美容师营业时间
     *
     * @param beauticianId 美容师ID
     * @return
     */
    @GetMapping("/beauticianBusinessHour/1.1.1/findListByBeauticianId/{beauticianId}")
    ResponseMessage<List<BeauticianBusinessHour>> findListByBeauticianIdV111(@PathVariable(value = "beauticianId") int beauticianId);

    /**
     * 新增美容师营业时间（美容师-我的-服务设置-营业时间）
     *
     * @param addVo 新增条件
     * @return
     */
    @PostMapping("/beauticianBusinessHour/1.1.1/add")
    ResponseMessage addV111(@ApiParam(value = "新增条件") @RequestBody BeauticianBusinessHourByAddVo addVo);

}