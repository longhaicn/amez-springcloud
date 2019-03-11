package com.union.aimei.common.vo.financial;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;
/**
 * @author liufeihua
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
@Data
@EqualsAndHashCode
@ApiModel(value = "店铺交易")
public class StoreTradeDetailVo implements Serializable {

    @ApiModelProperty(value = "交易年份", example = "2018")
    private String year;

    @ApiModelProperty(value = "交易月份", example = "03")
    private String month;

    @ApiModelProperty("交易状态:0未完成,1-已完成")
    private Date tradeStatus;

    @ApiModelProperty("门店名字/手机号")
    private String beauticianNameAndPhone;

    private static final long serialVersionUID = 1L;
}