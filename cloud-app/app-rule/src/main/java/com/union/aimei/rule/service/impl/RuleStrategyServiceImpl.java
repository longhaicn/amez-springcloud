package com.union.aimei.rule.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.rule.RuleStrategy;
import com.union.aimei.rule.mapper.RuleStrategyMapper;
import com.union.aimei.rule.service.RuleStrategyService;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 规则策略
 *
 * @author liurenkai
 * @time 2018/5/10 17:34
 */
@Service("ruleStrategyService")
public class RuleStrategyServiceImpl implements RuleStrategyService {
    @Resource
    private RuleStrategyMapper ruleStrategyMapper;


    @Override
    public ResponseMessage<PageInfo<RuleStrategy>> findByPageForFront(Integer pageNo, Integer pageSize, RuleStrategy ruleStrategy) {
        ResponseMessage<PageInfo<RuleStrategy>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        List<RuleStrategy> list = this.ruleStrategyMapper.selectListByConditions(ruleStrategy);
        PageInfo<RuleStrategy> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }
}