package com.union.aimei.rule.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.rule.RuleTemplate;
import com.union.aimei.rule.mapper.RuleTemplateMapper;
import com.union.aimei.rule.service.RuleTemplateService;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 规则模板
 *
 * @author liurenkai
 * @time 2018/5/10 17:34
 */
@Service("ruleTemplateService")
public class RuleTemplateServiceImpl implements RuleTemplateService {
    @Resource
    private RuleTemplateMapper ruleTemplateMapper;

    @Override
    public ResponseMessage<PageInfo<RuleTemplate>> findByPageForFront(Integer pageNo, Integer pageSize, RuleTemplate ruleTemplate) {
        ResponseMessage<PageInfo<RuleTemplate>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        List<RuleTemplate> list = this.ruleTemplateMapper.selectListByConditions(ruleTemplate);
        PageInfo<RuleTemplate> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }
    
}