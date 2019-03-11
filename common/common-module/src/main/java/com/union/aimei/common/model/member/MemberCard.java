package com.union.aimei.common.model.member;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author houji
 * @date 2018/8/10  10:43
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "会员卡")
public class MemberCard implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("主键")
    private Integer id;
    @ApiModelProperty("样式图案")
    private String stylePattern;
    @ApiModelProperty("发行类型(0:品牌连锁,1:门店自营),默认0")
    private Boolean issueType;
    @ApiModelProperty("品牌ID")
    private String brandId;
    @ApiModelProperty("品牌名称")
    private String brandName;
    @ApiModelProperty("卡名称")
    private String cardName;
    @ApiModelProperty("销售状态(0:销售中,1:已下架,2：已失效)")
    private Byte sellStatus;
    @ApiModelProperty("支持充值(0:支持,1:不支持)")
    private Boolean supportRecharge;
    @ApiModelProperty("使用范围(0:多店,1:单店,2：全国通用),默认0")
    private Boolean useRange;
    @ApiModelProperty("会员卡编号")
    private String cardNo;
    @ApiModelProperty("门店ID")
    private Integer storeId;
    @ApiModelProperty("门店名称")
    private String storeName;
    @ApiModelProperty("城市id(深圳市id,成都市id)")
    private Integer cityId;
    @ApiModelProperty("发行数量")
    private Integer issueNum;
    @ApiModelProperty("面值（以分为单位存入）")
    private Integer balance;
    @ApiModelProperty("折扣")
    private Integer discount;
    @ApiModelProperty("有效类型(0:永久有效，1：有效日期，2：有效天数)")
    private Byte effectiveType;
    @ApiModelProperty("有效天数(以天为单位)")
    private Integer effectiveDay;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("更新时间")
    private Date updateTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty("会员卡开始使用时间")
    private Date useStartTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty("会员卡过期时间")
    private Date expiredTime;
    @ApiModelProperty("说明(会员卡的介绍，使用须知)")
    private String remark;
    @ApiModelProperty("制卡查询开始时间")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date makeCardStartTime;
    @ApiModelProperty("制卡查询结束时间")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date makeCardEndTime;
    @ApiModelProperty("会员卡是用城市的id的集合")
    private List<Integer> useCityIdStoreList;
}