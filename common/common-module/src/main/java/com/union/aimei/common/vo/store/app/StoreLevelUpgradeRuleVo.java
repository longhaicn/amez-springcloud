package com.union.aimei.common.vo.store.app;

import com.union.aimei.common.model.store.StoreLevelUpgradeRule;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 店铺成长值规则设置vo
 *
 * @author liurenkai
 * @time 2017/12/27 15:54
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "店铺成长值规则设置")
public class StoreLevelUpgradeRuleVo {

    /**
     * 店铺成长值规则设置集合
     */
    private List<StoreLevelUpgradeRule> ruleList;

}
