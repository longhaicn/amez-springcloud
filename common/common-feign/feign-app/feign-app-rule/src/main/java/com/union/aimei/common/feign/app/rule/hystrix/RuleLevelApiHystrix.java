package com.union.aimei.common.feign.app.rule.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.rule.RuleLevelFeign;
import com.union.aimei.common.model.rule.RuleLevel;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

/**
 * 规则等级
 *
 * @author liurenkai
 * @time 2018/5/10 17:42
 */
@Component(value = "app-RuleLevelFeign")
public class RuleLevelApiHystrix implements RuleLevelFeign {
    @Override
    public ResponseMessage<PageInfo<RuleLevel>> findByPageForFront(Integer pageNo, Integer pageSize, RuleLevel ruleLevel) {
        return HystrixResponse.invokeFail();
    }
}