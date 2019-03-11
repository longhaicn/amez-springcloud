package com.union.aimei.common.feign.pc.product.hystrix;

import com.union.aimei.common.feign.pc.product.ActivityProductRefFeign;
import org.springframework.stereotype.Component;

/**
 * 活动-项目-关联
 *
 * @author liurenkai
 * @time 2018/5/14 11:36
 */
@Component(value = "pc-ActivityProductRefFeign")
public class ActivityProductRefApiHystrix implements ActivityProductRefFeign {
}