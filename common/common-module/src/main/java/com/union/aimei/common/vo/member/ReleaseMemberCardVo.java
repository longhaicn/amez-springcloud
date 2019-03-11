package com.union.aimei.common.vo.member;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author GaoWei
 * @describe 发布会员卡VO
 * @time 2018/2/2,10:47
*/
@Data
@EqualsAndHashCode
public class ReleaseMemberCardVo {

    @ApiModelProperty("发行类型(0:品牌连锁,1:门店自营),默认0")
    private Boolean issueType;

    @ApiModelProperty("品牌ID")
    private String brandId;

    @ApiModelProperty("品牌名称")
    private String brandName;

    @ApiModelProperty("门店ID")
    private Integer storeId;

    @ApiModelProperty("门店名称")
    private String storeName;

    @ApiModelProperty("城市ID")
    private Integer cityId;

    @ApiModelProperty(value = "会员卡名称")
    private String memberCardName;

    @ApiModelProperty("发行数量")
    private Integer issueNum;

    @ApiModelProperty(value = "是否支持充值(0:支持，1：不支持)，默认支持0")
    private Boolean supportRecharge;

    @ApiModelProperty(value = "卡面面值")
    private Integer balance;

    @ApiModelProperty(value = "折扣")
    private Integer discount;

    @ApiModelProperty("有效类型(0:永久有效，1：有效日期，2：有效天数)")
    private Byte effectiveType;

    @ApiModelProperty("有效天数(以天为单位)")
    private Integer effectiveDay;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @ApiModelProperty("会员卡开始使用时间")
    private Date useStartTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @ApiModelProperty(value = "会员卡结束时间")
    private Date expiredTime;

    @ApiModelProperty(value = "卡面样式")
    private String stylePattern;

    @ApiModelProperty("使用范围(0:多店,1:单店,2：全国通用),默认0")
    private Boolean useRange;

    @ApiModelProperty("适用门店ID集合")
    private List<Integer> useAbleStoreList=new ArrayList<>(10);

    @ApiModelProperty("适用服务ID集合")
    private List<Integer> useAbleProductList=new ArrayList<>(10);

    @ApiModelProperty("说明(会员卡的介绍，使用须知)")
    private String remark;
}
