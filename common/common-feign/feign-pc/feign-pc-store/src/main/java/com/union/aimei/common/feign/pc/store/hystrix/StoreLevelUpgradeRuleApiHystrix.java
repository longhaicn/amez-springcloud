package com.union.aimei.common.feign.pc.store.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.store.StoreLevelUpgradeRuleFeign;
import com.union.aimei.common.model.store.StoreLevelUpgradeRule;
import com.union.aimei.common.vo.store.pc.StoreLevelUpgradeRuleByBatchVo;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 店铺成长值规则设置
 *
 * @author liurenkai
 * @time 2018/1/12 17:36
 */
@Component(value = "pc-StoreLevelUpgradeRuleFeign")
public class StoreLevelUpgradeRuleApiHystrix implements StoreLevelUpgradeRuleFeign {

    @Override
    public ResponseMessage<PageInfo<StoreLevelUpgradeRule>> findByPageForFront(Integer pageNo, Integer pageSize, StoreLevelUpgradeRule storeLevelUpgradeRule) {
        return HystrixResponse.invokeFail();
    }

    /**
     * 添加店铺成长值规则设置
     *
     * @param storeLevelUpgradeRule
     * @return
     */
    @Override
    public int insert(StoreLevelUpgradeRule storeLevelUpgradeRule) {
        return 0;
    }

    /**
     * 删除店铺成长值规则设置
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改店铺成长值规则设置
     *
     * @param storeLevelUpgradeRule
     * @return
     */
    @Override
    public int edit(StoreLevelUpgradeRule storeLevelUpgradeRule) {
        return 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnstoreLevelUpgradeRule
     */
    @Override
    public StoreLevelUpgradeRule queryById(int id) {
        return null;
    }

    @Override
    public ResponseMessage addByBatch(StoreLevelUpgradeRuleByBatchVo storeLevelUpgradeRuleByBatchVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<List<StoreLevelUpgradeRule>> findListByAll() {
        return HystrixResponse.invokeFail();
    }
}