package com.union.aimei.rule.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.rule.RuleLevel;
import com.union.aimei.rule.mapper.RuleLevelMapper;
import com.union.aimei.rule.service.RuleLevelService;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 规则等级
 *
 * @author liurenkai
 * @time 2018/5/10 17:33
 */
@Service("ruleLevelService")
public class RuleLevelServiceImpl implements RuleLevelService {
    @Resource
    private RuleLevelMapper ruleLevelMapper;

    @Override
    public ResponseMessage<PageInfo<RuleLevel>> findByPageForFront(Integer pageNo, Integer pageSize, RuleLevel ruleLevel) {
        ResponseMessage<PageInfo<RuleLevel>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        List<RuleLevel> list = this.ruleLevelMapper.selectListByConditions(ruleLevel);
        PageInfo<RuleLevel> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

}