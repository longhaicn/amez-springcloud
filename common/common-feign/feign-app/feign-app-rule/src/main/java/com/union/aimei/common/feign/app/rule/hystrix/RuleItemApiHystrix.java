package com.union.aimei.common.feign.app.rule.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.rule.RuleItemFeign;
import com.union.aimei.common.model.rule.RuleItem;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

/**
 * 规则项
 *
 * @author liurenkai
 * @time 2018/5/10 17:44
 */
@Component(value = "app-RuleItemFeign")
public class RuleItemApiHystrix implements RuleItemFeign {

    @Override
    public ResponseMessage<PageInfo<RuleItem>> findByPageForFront(Integer pageNo, Integer pageSize, RuleItem ruleItem) {
        return HystrixResponse.invokeFail();
    }
}