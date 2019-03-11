package com.union.aimei.aimeicloud.common.api.gateway.feign;

import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

import java.util.Map;
/**
 * @author liufeihua
 */
@Component
public class CommonAuthHystrix implements CommonAuthFeign{

    @Override
    public ResponseMessage verifyToken(Map<String,String> map) {
        return HystrixResponse.invokeFail();
    }
}
