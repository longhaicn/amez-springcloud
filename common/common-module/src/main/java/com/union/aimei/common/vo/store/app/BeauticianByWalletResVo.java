package com.union.aimei.common.vo.store.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 美容师我的钱包返回结果
 *
 * @author liurenkai
 * @time 2018/4/13 16:55
 */
@Data
@EqualsAndHashCode
@ApiModel("美容师我的钱包返回结果")
public class BeauticianByWalletResVo implements Serializable {

    @ApiModelProperty("账户余额")
    private Integer accountBalance;

    @ApiModelProperty("未到账金额")
    private Integer preIncomeAmount;

}