package com.union.aimei.common.vo.order;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author GaoWei
 * @describe 服务购买者vo
 * @time 2018/1/30,19:02
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "服务买家VO")
public class OrderBuyerVo {

    @ApiModelProperty(value = "会员ID")
    private Integer memberId;
    @ApiModelProperty(value = "会员真实名称")
    private String memberRealName;
    @ApiModelProperty(value = "买家电话信息")
    private String memberPhone;
    @ApiModelProperty(value = "上门地址")
    private String forwardAddress;
    @ApiModelProperty(value = "到店地址")
    private String storeAddress;
    @ApiModelProperty(value = "备注")
    private String remark;
}
