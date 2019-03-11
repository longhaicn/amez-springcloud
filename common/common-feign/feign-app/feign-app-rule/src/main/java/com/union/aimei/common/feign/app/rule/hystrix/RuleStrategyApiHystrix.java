package com.union.aimei.common.feign.app.rule.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.rule.RuleStrategyFeign;
import com.union.aimei.common.model.rule.RuleStrategy;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

/**
 * 规则策略
 *
 * @author liurenkai
 * @time 2018/5/10 17:42
 */
@Component(value = "app-RuleStrategyFeign")
public class RuleStrategyApiHystrix implements RuleStrategyFeign {

    @Override
    public ResponseMessage<PageInfo<RuleStrategy>> findByPageForFront(Integer pageNo, Integer pageSize, RuleStrategy ruleStrategy) {
        return HystrixResponse.invokeFail();
    }
}