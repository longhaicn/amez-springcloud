package com.union.aimei.pc.store.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreBeauticianLevelUpgradeRule;
import com.union.aimei.pc.store.mapper.StoreBeauticianLevelUpgradeRuleMapper;
import com.union.aimei.pc.store.service.StoreBeauticianLevelUpgradeRuleService;
import com.union.aimei.common.vo.store.pc.StoreBeauticianLevelUpgradeRuleByBatchVo;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 美容师成长值规则设置
 *
 * @author liurenkai
 * @time 2018/1/12 17:34
 */
@Service("storeBeauticianLevelUpgradeRuleService")
public class StoreBeauticianLevelUpgradeRuleServiceImpl implements StoreBeauticianLevelUpgradeRuleService {
    @Resource
    private StoreBeauticianLevelUpgradeRuleMapper storeBeauticianLevelUpgradeRuleMapper;

    @Override
    public ResponseMessage<PageInfo<StoreBeauticianLevelUpgradeRule>> findByPageForFront(Integer pageNo, Integer pageSize, StoreBeauticianLevelUpgradeRule storeBeauticianLevelUpgradeRule) {
        ResponseMessage<PageInfo<StoreBeauticianLevelUpgradeRule>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        List<StoreBeauticianLevelUpgradeRule> list = this.storeBeauticianLevelUpgradeRuleMapper.selectListByConditions(storeBeauticianLevelUpgradeRule);
        PageInfo<StoreBeauticianLevelUpgradeRule> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

    /**
     * 添加美容师成长值规则设置
     *
     * @param storeBeauticianLevelUpgradeRule
     * @return
     */
    @Override
    public int addObj(StoreBeauticianLevelUpgradeRule storeBeauticianLevelUpgradeRule) {
        return this.storeBeauticianLevelUpgradeRuleMapper.insertSelective(storeBeauticianLevelUpgradeRule);
    }

    /**
     * 删除美容师成长值规则设置
     *
     * @param id
     * @return
     */
    @Override
    public int deleteObjById(int id) {
        return this.storeBeauticianLevelUpgradeRuleMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改美容师成长值规则设置
     *
     * @param storeBeauticianLevelUpgradeRule
     * @return
     */
    @Override
    public int modifyObj(StoreBeauticianLevelUpgradeRule storeBeauticianLevelUpgradeRule) {
        return this.storeBeauticianLevelUpgradeRuleMapper.updateByPrimaryKeySelective(storeBeauticianLevelUpgradeRule);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnstoreBeauticianLevelUpgradeRule
     */
    @Override
    public StoreBeauticianLevelUpgradeRule queryObjById(int id) {
        StoreBeauticianLevelUpgradeRule model = this.storeBeauticianLevelUpgradeRuleMapper.selectByPrimaryKey(id);
        return model;
    }

    @Override
    public ResponseMessage addByBatch(StoreBeauticianLevelUpgradeRuleByBatchVo storeBeauticianLevelUpgradeRuleByBatchVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        // 删除所有美容师成长值规则设置
        this.storeBeauticianLevelUpgradeRuleMapper.deleteByAll();
        // 批量添加美容师成长值规则设置
        this.storeBeauticianLevelUpgradeRuleMapper.addByBatch(storeBeauticianLevelUpgradeRuleByBatchVo);
        return responseMessage;
    }

    @Override
    public ResponseMessage<List<StoreBeauticianLevelUpgradeRule>> findListByAll() {
        ResponseMessage<List<StoreBeauticianLevelUpgradeRule>> responseMessage = new ResponseMessage<>();
        StoreBeauticianLevelUpgradeRule ruleCond = new StoreBeauticianLevelUpgradeRule();
        ruleCond.setIsEnabled(true);
        List<StoreBeauticianLevelUpgradeRule> ruleList = this.storeBeauticianLevelUpgradeRuleMapper.selectListByConditions(ruleCond);
        responseMessage.setData(ruleList);
        return responseMessage;
    }
}