package com.union.aimei.common.vo.store.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 门店个人收款账号结果
 *
 * @author caizhaoming
 * @time 2018/07/09 16:01
 */
@Data
@EqualsAndHashCode
@ApiModel("门店个人收款账号结果")
public class StoreByPersonageReceivingAccountResVo implements Serializable {


    @ApiModelProperty("商户个人收款账号-开户银行")
    private String praBank;

    @ApiModelProperty("商户个人收款账号-开户地区")
    private String praArea;

    @ApiModelProperty("商户个人收款账号-支行名称")
    private String praBankBranch;

    @ApiModelProperty("商户个人收款账号-开户名称")
    private String praAccountName;

    @ApiModelProperty("商户个人收款账号-银行卡号")
    private String praBankCardNumber;

}
