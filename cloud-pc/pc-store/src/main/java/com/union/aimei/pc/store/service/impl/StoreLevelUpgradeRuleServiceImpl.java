package com.union.aimei.pc.store.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreLevelUpgradeRule;
import com.union.aimei.pc.store.mapper.StoreLevelUpgradeRuleMapper;
import com.union.aimei.pc.store.service.StoreLevelUpgradeRuleService;
import com.union.aimei.common.vo.store.pc.StoreLevelUpgradeRuleByBatchVo;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 店铺成长值规则设置
 *
 * @author liurenkai
 * @time 2018/1/12 17:36
 */
@Service("storeLevelUpgradeRuleService")
public class StoreLevelUpgradeRuleServiceImpl implements StoreLevelUpgradeRuleService {
    @Resource
    private StoreLevelUpgradeRuleMapper storeLevelUpgradeRuleMapper;

    @Override
    public ResponseMessage<PageInfo<StoreLevelUpgradeRule>> findByPageForFront(Integer pageNo, Integer pageSize, StoreLevelUpgradeRule storeLevelUpgradeRule) {
        ResponseMessage<PageInfo<StoreLevelUpgradeRule>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        List<StoreLevelUpgradeRule> list = this.storeLevelUpgradeRuleMapper.selectListByConditions(storeLevelUpgradeRule);
        PageInfo<StoreLevelUpgradeRule> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

    /**
     * 添加店铺成长值规则设置
     *
     * @param storeLevelUpgradeRule
     * @return
     */
    @Override
    public int addObj(StoreLevelUpgradeRule storeLevelUpgradeRule) {
        return this.storeLevelUpgradeRuleMapper.insertSelective(storeLevelUpgradeRule);
    }

    /**
     * 删除店铺成长值规则设置
     *
     * @param id
     * @return
     */
    @Override
    public int deleteObjById(int id) {
        return this.storeLevelUpgradeRuleMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改店铺成长值规则设置
     *
     * @param storeLevelUpgradeRule
     * @return
     */
    @Override
    public int modifyObj(StoreLevelUpgradeRule storeLevelUpgradeRule) {
        return this.storeLevelUpgradeRuleMapper.updateByPrimaryKeySelective(storeLevelUpgradeRule);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnstoreLevelUpgradeRule
     */
    @Override
    public StoreLevelUpgradeRule queryObjById(int id) {
        StoreLevelUpgradeRule model = this.storeLevelUpgradeRuleMapper.selectByPrimaryKey(id);
        return model;
    }

    @Override
    public ResponseMessage addByBatch(StoreLevelUpgradeRuleByBatchVo storeLevelUpgradeRuleByBatchVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        // 删除所有店铺成长值规则设置
        this.storeLevelUpgradeRuleMapper.deleteByAll();
        // 批量添加店铺成长值规则设置
        this.storeLevelUpgradeRuleMapper.addByBatch(storeLevelUpgradeRuleByBatchVo);
        return responseMessage;
    }

    @Override
    public ResponseMessage<List<StoreLevelUpgradeRule>> findListByAll() {
        ResponseMessage<List<StoreLevelUpgradeRule>> responseMessage = new ResponseMessage<>();
        StoreLevelUpgradeRule storeLevelUpgradeRuleCond = new StoreLevelUpgradeRule();
        storeLevelUpgradeRuleCond.setIsEnabled(true);
        List<StoreLevelUpgradeRule> storeLevelUpgradeRuleList = this.storeLevelUpgradeRuleMapper.selectListByConditions(storeLevelUpgradeRuleCond);
        responseMessage.setData(storeLevelUpgradeRuleList);
        return responseMessage;
    }

}