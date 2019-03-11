package com.union.aimei.app.api.conf.limit;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.lang.annotation.*;

/**
 * @author GaoWei
 * @time 2018/6/30
 * @description 限制某个IP在某个时间段内请求某个方法的次数
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
@Order(Ordered.HIGHEST_PRECEDENCE)
public @interface LimitIpRequest {

    /**
     *
     * @Description: 限制某时间段内可以访问的次数，默认设置1
     * @return
     */
    int limitCounts() default 1;

    /**
     *
     * @Description: 限制访问的某一个时间段，单位为秒，默认值1分钟即可
     * @return
     * */
    int timeSecond() default 60;

}
