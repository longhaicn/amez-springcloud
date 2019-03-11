package com.union.aimei.aimeicloud.common.api.gateway.feign;


import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;
/**
 * @author liufeihua
 */
@FeignClient(serviceId = "COMMON-AUTH",fallback = CommonAuthHystrix.class)
public interface CommonAuthFeign {

    /**
     * 校验token有效性
     * @param map
     * @return
     */
    @PostMapping(value = "/jwt/verifyToken")
    ResponseMessage verifyToken(@RequestBody Map<String,String> map);

}
