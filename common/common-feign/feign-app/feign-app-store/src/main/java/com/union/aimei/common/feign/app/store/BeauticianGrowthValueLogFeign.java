package com.union.aimei.common.feign.app.store;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.store.hystrix.BeauticianGrowthValueLogApiHystrix;
import com.union.aimei.common.model.store.BeauticianGrowthValueLog;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 美容师成长值记录
 *
 * @author liurenkai
 * @time 2018/6/4 13:35
 */
@FeignClient(serviceId = "APP-STORE-SERVICE", fallback = BeauticianGrowthValueLogApiHystrix.class)
public interface BeauticianGrowthValueLogFeign {

    /**
     * 保存美容师成长值记录
     *
     * @param beauticianGrowthValueLog 美容师成长值记录
     * @return
     */
    @GetMapping(value = "/beauticianGrowthValueLog/1.1.1/save")
    ResponseMessage<BeauticianGrowthValueLog> saveV111(@RequestBody BeauticianGrowthValueLog beauticianGrowthValueLog);

    /**
     * 根据美容师ID分页查询美容师成长值记录
     *
     * @param pageNo       分页索引
     * @param pageSize     每页数量
     * @param beauticianId 美容师ID
     * @return
     */
    @PostMapping(value = "/beauticianGrowthValueLog/1.1.1/listByBeauticianId/{beauticianId}")
    ResponseMessage<PageInfo<BeauticianGrowthValueLog>> listByBeauticianIdV111(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                               @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                               @PathVariable(value = "beauticianId") int beauticianId);

}