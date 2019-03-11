package com.union.aimei.common.feign.pc.system.hystrix;

import com.union.aimei.aop.logs.WebLog;
import com.union.aimei.aop.logs.WebLogVo;
import com.union.aimei.common.feign.pc.system.WebLogFeign;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

/**
 * WebLogFeignHystrix
 * 
 * @author liufeihua
 * @date 2018/4/11 15:30
 */
@Component(value = "pc-WebLogFeign")
public class WebLogFeignHystrix implements WebLogFeign {

    @Override
    public ResponseMessage<WebLogVo> findList(Integer pageNo, Integer pageSize, WebLog record) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<WebLogVo> insertLogs(WebLog record) {
        return HystrixResponse.invokeFail();
    }
}
