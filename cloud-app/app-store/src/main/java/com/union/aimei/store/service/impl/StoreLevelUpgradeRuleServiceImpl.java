package com.union.aimei.store.service.impl;

import com.union.aimei.common.model.store.StoreLevelUpgradeRule;
import com.union.aimei.store.mapper.StoreLevelUpgradeRuleMapper;
import com.union.aimei.store.service.StoreLevelUpgradeRuleService;
import com.union.aimei.common.vo.store.app.StoreLevelUpgradeRuleVo;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 店铺成长值规则设置
 *
 * @author liurenkai
 * @time 2017/12/27 15:56
 */
@Service("storeLevelUpgradeRuleService")
public class StoreLevelUpgradeRuleServiceImpl implements StoreLevelUpgradeRuleService {
    @Resource
    private StoreLevelUpgradeRuleMapper storeLevelUpgradeRuleMapper;


    @Override
    public ResponseMessage add(StoreLevelUpgradeRuleVo storeLevelUpgradeRuleVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        // 删除原店铺成长值规则设置
        this.storeLevelUpgradeRuleMapper.deleteForAll();
        // 新增新店铺成长值规则设置
        List<StoreLevelUpgradeRule> ruleList = storeLevelUpgradeRuleVo.getRuleList();
        for (StoreLevelUpgradeRule storeLevelUpgradeRule : ruleList) {
            this.storeLevelUpgradeRuleMapper.insertSelective(storeLevelUpgradeRule);
        }
        return responseMessage;
    }

    @Override
    public ResponseMessage<List<StoreLevelUpgradeRule>> findList() {
        ResponseMessage<List<StoreLevelUpgradeRule>> responseMessage = new ResponseMessage<>();
        StoreLevelUpgradeRule ruleConditions = new StoreLevelUpgradeRule();
        List<StoreLevelUpgradeRule> ruleList = this.storeLevelUpgradeRuleMapper.selectListByConditions(ruleConditions);
        responseMessage.setData(ruleList);
        return responseMessage;
    }
}