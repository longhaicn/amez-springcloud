package com.union.aimei.common.vo.store.pc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 门店企业收款账号结果
 *
 * @author liurenkai
 * @time 2018/6/1 14:19
 */
@Data
@EqualsAndHashCode
@ApiModel("门店企业收款账号结果")
public class StoreByEnterpriseReceivingAccountResVo implements Serializable {

    @ApiModelProperty("企业收款账号-开户银行")
    private String eraBank;

    @ApiModelProperty("企业收款账号-开户地区")
    private String eraArea;

    @ApiModelProperty("企业收款账号-支行名称")
    private String eraBankBranch;

    @ApiModelProperty("企业收款账号-公司名称")
    private String eraCompanyName;

    @ApiModelProperty("企业收款账号-银行卡号")
    private String eraBankCardNumber;

}
