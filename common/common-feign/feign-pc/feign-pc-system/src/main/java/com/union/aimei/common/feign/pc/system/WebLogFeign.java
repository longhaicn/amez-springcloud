package com.union.aimei.common.feign.pc.system;

import com.union.aimei.aop.logs.WebLog;
import com.union.aimei.aop.logs.WebLogVo;
import com.union.aimei.common.feign.pc.system.hystrix.WebLogFeignHystrix;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * WebLogFeign
 *
 * @author liufeihua
 * @date 2018/4/11 15:19
 */
@FeignClient(name = "pc-system-service", fallback = WebLogFeignHystrix.class)
public interface WebLogFeign {
    /**
     * 查看
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    @RequestMapping(value = "/webLogs/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    ResponseMessage<WebLogVo> findList(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, @RequestBody WebLog record);
    /**
     * 基本操作
     * @param record
     * @return
     */
    @RequestMapping(value = "/webLogs/insertLogs", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    ResponseMessage<WebLogVo> insertLogs(@RequestBody WebLog record);
}
