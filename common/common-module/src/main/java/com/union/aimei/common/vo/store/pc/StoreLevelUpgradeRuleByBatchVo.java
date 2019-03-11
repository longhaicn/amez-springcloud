package com.union.aimei.common.vo.store.pc;

import com.union.aimei.common.model.store.StoreLevelUpgradeRule;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 批量店铺成长值规则设置
 *
 * @author liurenkai
 * @time 2017/12/27 15:54
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "批量店铺成长值规则设置")
public class StoreLevelUpgradeRuleByBatchVo {

    @ApiModelProperty("店铺成长值规则设置集合")
    private List<StoreLevelUpgradeRule> ruleList;

}
