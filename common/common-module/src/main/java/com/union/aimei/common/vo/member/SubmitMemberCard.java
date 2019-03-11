package com.union.aimei.common.vo.member;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author GaoWei
 * @describe
 * @time 2018/1/3,15:19
*/
@Data
@EqualsAndHashCode
public class SubmitMemberCard {
    @ApiModelProperty(value = "会员卡名称")
    private String memberCardName;
    @ApiModelProperty(value = "卡面面值")
    private Integer balance;
    @ApiModelProperty(value = "折扣")
    private Integer discount;
    @ApiModelProperty(value = "是否支持充值(0:支持，1：不支持)，默认支持0")
    private Boolean supportRecharge;
    @ApiModelProperty(value = "有效期")
    private Date expiredTime;
    @ApiModelProperty(value = "卡面样式")
    private String stylePattern;
    @ApiModelProperty("使用范围(0:多店,1:单店,默认多店)")
    private Boolean useRange;
    @ApiModelProperty("适用门店ID集合")
    private List<Integer> useAbleStoreList=new ArrayList<>(10);
    @ApiModelProperty("适用服务ID集合")
    private List<Integer> useAbleProductList=new ArrayList<>(10);
    @ApiModelProperty("说明(会员卡的介绍，使用须知)")
    private String remark;
}
