package com.union.aimei.common.vo.member;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author GaoWei
 * @describe 购买会员卡VO
 * @time 2018/2/6,18:53
*/
@Data
@EqualsAndHashCode
@ApiModel(value = "会员卡购买列表VO")
public class BuyMemberCardVo implements Serializable{
    @ApiModelProperty(value = "会员卡ID")
    private Integer id;
    @ApiModelProperty(value = "品牌ID")
    private Integer brandId;
    @ApiModelProperty(value = "店铺ID")
    private Integer storeId;
    @ApiModelProperty(value = "会员卡名称")
    private String cardName;
    @ApiModelProperty(value = "折扣比率")
    private Integer discount;
    @ApiModelProperty(value = "卡面金额")
    private Integer balance;
    @ApiModelProperty(value = "使用范围(0:单店,1:多店,2:全通通用)")
    private Integer useRange;
    @ApiModelProperty(value = "可用门店数量")
    private Integer useAbleNum;
}
