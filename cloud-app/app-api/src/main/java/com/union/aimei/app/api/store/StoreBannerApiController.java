package com.union.aimei.app.api.store;

import com.union.aimei.common.feign.app.store.StoreBannerFeign;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 店铺图片
 *
 * @author liurenkai
 * @time 2018/4/11 14:28
 */
@Api(tags = "店铺图片表", description = "api")
@RestController
@RequestMapping(value = "storeBanner")
public class StoreBannerApiController {
    @Resource
    private StoreBannerFeign storeBannerFeign;

}