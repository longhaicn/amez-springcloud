package com.union.aimei.rule.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.rule.RuleCategory;
import com.union.aimei.rule.mapper.RuleCategoryMapper;
import com.union.aimei.rule.service.RuleCategoryService;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 规则分类
 *
 * @author liurenkai
 * @time 2018/5/10 17:31
 */
@Service("ruleCategoryService")
public class RuleCategoryServiceImpl implements RuleCategoryService {
    @Resource
    private RuleCategoryMapper ruleCategoryMapper;

    @Override
    public ResponseMessage<PageInfo<RuleCategory>> findByPageForFront(Integer pageNo, Integer pageSize, RuleCategory ruleCategory) {
        ResponseMessage<PageInfo<RuleCategory>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        List<RuleCategory> list = this.ruleCategoryMapper.selectListByConditions(ruleCategory);
        PageInfo<RuleCategory> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }
    
}