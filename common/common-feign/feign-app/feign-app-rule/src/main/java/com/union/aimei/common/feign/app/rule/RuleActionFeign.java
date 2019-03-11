package com.union.aimei.common.feign.app.rule;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.rule.hystrix.RuleActionApiHystrix;
import com.union.aimei.common.model.rule.RuleAction;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 规则行为
 *
 * @author liurenkai
 * @time 2018/5/10 17:42
 */
@FeignClient(serviceId = "APP-RULE-SERVICE", fallback = RuleActionApiHystrix.class)
public interface RuleActionFeign {

    /**
     * 分页查询规则行为
     *
     * @param pageNo     分页索引
     * @param pageSize   每页数量
     * @param ruleAction 查询条件
     * @return
     */
    @PostMapping(value = "/ruleAction/front/findByPage")
    ResponseMessage<PageInfo<RuleAction>> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                             @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                             @RequestBody RuleAction ruleAction);
}