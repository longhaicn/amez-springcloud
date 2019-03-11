package com.union.aimei.common.feign.app.rule.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.rule.RuleCategoryFeign;
import com.union.aimei.common.model.rule.RuleCategory;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

/**
 * 规则分类
 *
 * @author liurenkai
 * @time 2018/5/10 17:42
 */
@Component(value = "app-RuleCategoryFeign")
public class RuleCategoryApiHystrix implements RuleCategoryFeign {

    @Override
    public ResponseMessage<PageInfo<RuleCategory>> findByPageForFront(Integer pageNo, Integer pageSize, RuleCategory ruleCategory) {
        return HystrixResponse.invokeFail();
    }
}