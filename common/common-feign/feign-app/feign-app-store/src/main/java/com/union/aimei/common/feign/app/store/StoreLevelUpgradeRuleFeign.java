package com.union.aimei.common.feign.app.store;

import com.union.aimei.common.feign.app.store.hystrix.StoreLevelUpgradeRuleApiHystrix;
import com.union.aimei.common.model.store.StoreLevelUpgradeRule;
import com.union.aimei.common.vo.store.app.StoreLevelUpgradeRuleVo;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 店铺成长值规则设置
 *
 * @author liurenkai
 * @time 2017/12/27 16:06
 */
@FeignClient(serviceId = "APP-STORE-SERVICE", fallback = StoreLevelUpgradeRuleApiHystrix.class)
public interface StoreLevelUpgradeRuleFeign {
    /**
     * 添加店铺成长值规则设置
     *
     * @param storeLevelUpgradeRuleVo 店铺成长值规则设置vo
     * @return
     */
    @PostMapping(value = "/storeLevelUpgradeRule/add")
    ResponseMessage add(@RequestBody StoreLevelUpgradeRuleVo storeLevelUpgradeRuleVo);

    /**
     * 查询店铺成长值规则设置
     *
     * @return
     */
    @GetMapping(value = "/storeLevelUpgradeRule/findList")
    ResponseMessage<List<StoreLevelUpgradeRule>> findList();
}