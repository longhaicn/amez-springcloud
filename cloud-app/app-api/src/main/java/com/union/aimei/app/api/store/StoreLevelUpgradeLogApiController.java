package com.union.aimei.app.api.store;

import com.union.aimei.common.feign.app.store.StoreLevelUpgradeLogFeign;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 门店成长值记录
 *
 * @author liurenkai
 * @time 2018/4/11 14:28
 */
@Api(tags = "门店成长值记录", description = "api")
@RestController
@RequestMapping(value = "storeLevelUpgradeLog")
public class StoreLevelUpgradeLogApiController {
    @Resource
    private StoreLevelUpgradeLogFeign storeLevelUpgradeLogFeign;

}