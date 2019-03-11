package com.union.aimei.common.feign.pc.store.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.store.StoreBeauticianLevelUpgradeRuleFeign;
import com.union.aimei.common.model.store.StoreBeauticianLevelUpgradeRule;
import com.union.aimei.common.vo.store.pc.StoreBeauticianLevelUpgradeRuleByBatchVo;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 美容师成长值规则设置
 *
 * @author liurenkai
 * @time 2018/1/12 17:34
 */
@Component(value = "pc-StoreBeauticianLevelUpgradeRuleFeign")
public class StoreBeauticianLevelUpgradeRuleApiHystrix implements StoreBeauticianLevelUpgradeRuleFeign {

    @Override
    public ResponseMessage<PageInfo<StoreBeauticianLevelUpgradeRule>> findByPageForFront(Integer pageNo, Integer pageSize, StoreBeauticianLevelUpgradeRule storeBeauticianLevelUpgradeRule) {
        return HystrixResponse.invokeFail();
    }

    /**
     * 添加美容师成长值规则设置
     *
     * @param storeBeauticianLevelUpgradeRule
     * @return
     */
    @Override
    public int insert(StoreBeauticianLevelUpgradeRule storeBeauticianLevelUpgradeRule) {
        return 0;
    }

    /**
     * 删除美容师成长值规则设置
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改美容师成长值规则设置
     *
     * @param storeBeauticianLevelUpgradeRule
     * @return
     */
    @Override
    public int edit(StoreBeauticianLevelUpgradeRule storeBeauticianLevelUpgradeRule) {
        return 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnstoreBeauticianLevelUpgradeRule
     */
    @Override
    public StoreBeauticianLevelUpgradeRule queryById(int id) {
        return null;
    }

    @Override
    public ResponseMessage addByBatch(StoreBeauticianLevelUpgradeRuleByBatchVo storeBeauticianLevelUpgradeRuleByBatchVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<List<StoreBeauticianLevelUpgradeRule>> findListByAll() {
        return HystrixResponse.invokeFail();
    }
}