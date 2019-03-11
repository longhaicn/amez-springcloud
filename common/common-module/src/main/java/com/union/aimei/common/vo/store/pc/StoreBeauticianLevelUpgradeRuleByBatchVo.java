package com.union.aimei.common.vo.store.pc;

import com.union.aimei.common.model.store.StoreBeauticianLevelUpgradeRule;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 批量美容师成长值规则设置
 *
 * @author liurenkai
 * @time 2018/3/6 15:57
 */
@Data
@EqualsAndHashCode
@ApiModel("批量美容师成长值规则设置")
public class StoreBeauticianLevelUpgradeRuleByBatchVo implements Serializable {

    @ApiModelProperty("美容师成长值规则设置集合")
    private List<StoreBeauticianLevelUpgradeRule> ruleList;

}
