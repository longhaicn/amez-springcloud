package com.union.aimei.rule.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.rule.RuleAction;
import com.union.aimei.rule.mapper.RuleActionMapper;
import com.union.aimei.rule.service.RuleActionService;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 规则行为
 *
 * @author liurenkai
 * @time 2018/5/10 17:31
 */
@Service("ruleActionService")
public class RuleActionServiceImpl implements RuleActionService {
    @Resource
    private RuleActionMapper ruleActionMapper;

    @Override
    public ResponseMessage<PageInfo<RuleAction>> findByPageForFront(Integer pageNo, Integer pageSize, RuleAction ruleAction) {
        ResponseMessage<PageInfo<RuleAction>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        List<RuleAction> list = this.ruleActionMapper.selectListByConditions(ruleAction);
        PageInfo<RuleAction> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }
    
}