package com.union.aimei.common.feign.app.rule.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.rule.RuleTemplateFeign;
import com.union.aimei.common.model.rule.RuleTemplate;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

/**
 * 规则模板
 *
 * @author liurenkai
 * @time 2018/5/10 17:42
 */
@Component(value = "app-RuleTemplateFeign")
public class RuleTemplateApiHystrix implements RuleTemplateFeign {

    @Override
    public ResponseMessage<PageInfo<RuleTemplate>> findByPageForFront(Integer pageNo, Integer pageSize, RuleTemplate ruleTemplate) {
        return HystrixResponse.invokeFail();
    }
}