package com.union.aimei.pc.api.product;

import com.union.aimei.common.feign.pc.product.ActivityProductRefFeign;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 活动-项目-关联
 *
 * @author liurenkai
 * @time 2018/5/14 11:38
 */
@Api(tags = "活动-项目-关联")
@RestController
@RequestMapping(value = "activityProductRef")
public class ActivityProductRefApiController {
    @Resource
    private ActivityProductRefFeign activityProductRefFeign;

}