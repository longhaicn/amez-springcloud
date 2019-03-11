package com.union.aimei.common.feign.app.rule;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.rule.hystrix.RuleTemplateApiHystrix;
import com.union.aimei.common.model.rule.RuleTemplate;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 规则模板
 *
 * @author liurenkai
 * @time 2018/5/10 17:42
 */
@FeignClient(serviceId = "APP-RULE-SERVICE", fallback = RuleTemplateApiHystrix.class)
public interface RuleTemplateFeign {

    /**
     * 分页查询规则模板
     *
     * @param pageNo       分页索引
     * @param pageSize     每页数量
     * @param ruleTemplate 查询条件
     * @return
     */
    @PostMapping(value = "/ruleTemplate/front/findByPage")
    ResponseMessage<PageInfo<RuleTemplate>> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                               @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                               @RequestBody RuleTemplate ruleTemplate);
}