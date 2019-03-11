package com.union.aimei.common.feign.app.rule.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.rule.RuleActionFeign;
import com.union.aimei.common.model.rule.RuleAction;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

/**
 * 规则行为
 *
 * @author liurenkai
 * @time 2018/5/10 17:42
 */
@Component(value = "app-RuleActionFeign")
public class RuleActionApiHystrix implements RuleActionFeign {

    @Override
    public ResponseMessage<PageInfo<RuleAction>> findByPageForFront(Integer pageNo, Integer pageSize, RuleAction ruleAction) {
        return HystrixResponse.invokeFail();
    }
}