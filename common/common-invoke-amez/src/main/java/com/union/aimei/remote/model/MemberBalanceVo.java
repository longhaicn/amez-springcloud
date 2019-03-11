package com.union.aimei.remote.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/** 
  * @author GaoWei
  * @Date 18-8-13 下午4:03
  * @description
  */
@Data
@EqualsAndHashCode
@ApiModel(value = "会员余额VO")
public class MemberBalanceVo {

    @ApiModelProperty(value = "主键ID")
    private Integer id;
    @ApiModelProperty(value = "会员ID")
    private Integer memberId;
    @ApiModelProperty(value = "收益总额")
    private Double totalBalance;
    @ApiModelProperty(value = "冻结金额")
    private Double freezeBalance;
    @ApiModelProperty(value = "更新时间")
    private String updateTime;
    @ApiModelProperty(value = "修改人")
    private Integer updater;
    @ApiModelProperty(value = "可用余额")
    private Double usableBalance;
    @ApiModelProperty(value = "版本号")
    private Integer version;
    @ApiModelProperty(value = "提现金额")
    private Double withdrawBalance;
    @ApiModelProperty(value = "创建人")
    private Integer creater;
    @ApiModelProperty(value = "创建时间")
    private String createTime;
}
