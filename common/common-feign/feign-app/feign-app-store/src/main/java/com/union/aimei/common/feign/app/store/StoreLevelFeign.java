package com.union.aimei.common.feign.app.store;

import com.union.aimei.common.feign.app.store.hystrix.StoreLevelApiHystrix;
import com.union.aimei.common.model.store.StoreLevel;
import com.union.aimei.common.vo.store.app.StoreLevelVo;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 门店级别
 *
 * @author liurenkai
 * @time 2017/12/27 16:04
 */
@FeignClient(serviceId = "APP-STORE-SERVICE", fallback = StoreLevelApiHystrix.class)
public interface StoreLevelFeign {
    /**
     * 添加门店级别
     *
     * @param storeLevelVo 门店级别vo
     * @return
     */
    @PostMapping(value = "/storeLevel/add")
    ResponseMessage add(@RequestBody StoreLevelVo storeLevelVo);

    /**
     * 查询门店级别
     *
     * @return
     */
    @GetMapping(value = "/storeLevel/findList")
    ResponseMessage<List<StoreLevel>> findList();

}