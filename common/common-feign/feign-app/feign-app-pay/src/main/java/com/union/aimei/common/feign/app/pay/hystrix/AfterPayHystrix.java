package com.union.aimei.common.feign.app.pay.hystrix;

import com.union.aimei.common.feign.app.pay.AfterPayFeign;
import com.union.common.utils.exception.ServerException;
import org.springframework.stereotype.Component;

/**
 * @author GaoWei
 * @time 2018/6/11 10:43
 * @description
 */
@Component
public class AfterPayHystrix implements AfterPayFeign {


    @Override
    public void invokeAfterPayBusiness() {
        throw new ServerException(500,"");
    }
}
