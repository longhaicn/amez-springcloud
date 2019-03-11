package com.union.aimei.common.feign.app.store.hystrix;

import com.union.aimei.common.feign.app.store.StoreLevelUpgradeRuleFeign;
import com.union.aimei.common.model.store.StoreLevelUpgradeRule;
import com.union.aimei.common.vo.store.app.StoreLevelUpgradeRuleVo;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 店铺成长值规则设置
 *
 * @author liurenkai
 * @time 2017/12/27 16:08
 */
@Component(value = "app-StoreLevelUpgradeRuleFeign")
public class StoreLevelUpgradeRuleApiHystrix implements StoreLevelUpgradeRuleFeign {


    @Override
    public ResponseMessage add(StoreLevelUpgradeRuleVo storeLevelUpgradeRuleVo) {
        return null;
    }

    @Override
    public ResponseMessage<List<StoreLevelUpgradeRule>> findList() {
        return null;
    }
}