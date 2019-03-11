package com.union.aimei.rule.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.rule.RuleItem;
import com.union.aimei.rule.mapper.RuleItemMapper;
import com.union.aimei.rule.service.RuleItemService;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 规则项
 *
 * @author liurenkai
 * @time 2018/5/10 17:33
 */
@Service("ruleItemService")
public class RuleItemServiceImpl implements RuleItemService {
    @Resource
    private RuleItemMapper ruleItemMapper;

    @Override
    public ResponseMessage<PageInfo<RuleItem>> findByPageForFront(Integer pageNo, Integer pageSize, RuleItem ruleItem) {
        ResponseMessage<PageInfo<RuleItem>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        List<RuleItem> list = this.ruleItemMapper.selectListByConditions(ruleItem);
        PageInfo<RuleItem> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

}