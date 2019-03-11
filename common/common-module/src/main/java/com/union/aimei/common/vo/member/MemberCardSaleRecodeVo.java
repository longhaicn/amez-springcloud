package com.union.aimei.common.vo.member;

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
 * @date 2018/3/19  17:10
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "售卡记录表")
public class MemberCardSaleRecodeVo implements Serializable {

    @ApiModelProperty("售卡记录id")
    private Integer id;

    @ApiModelProperty("会员ID")
    private Integer memberId;

    @ApiModelProperty("会员昵称")
    private String memberNickname;

    @ApiModelProperty("注册手机号")
    private String registerPhone;

    @ApiModelProperty("发行类型(0:品牌连锁,1:门店自营),默认0")
    private Boolean issueType;

    @ApiModelProperty("品牌ID")
    private String brandId;

    @ApiModelProperty("品牌名称")
    private String brandName;

    @ApiModelProperty("会员卡id")
    private Integer memberCardId;

    @ApiModelProperty("卡名称")
    private String cardName;

    @ApiModelProperty("发卡的门店ID")
    private String issueStoreId;

    @ApiModelProperty("发卡的门店名称")
    private String issueStoreName;

    @ApiModelProperty("面值（以分为单位存入）")
    private Integer balance;

    @ApiModelProperty("折扣")
    private Integer discount;

    @ApiModelProperty("有效类型(0:永久有效，1：有效日期，2：有效天数)")
    private Byte effectiveType;

    @ApiModelProperty("有效天数(以天为单位)")
    private Integer effectiveDay;

    @ApiModelProperty("说明(会员卡的介绍，使用须知)")
    private String remark;

    @ApiModelProperty("支持充值(0:支持,1:不支持)")
    private Boolean supportRecharge;

    @ApiModelProperty("会员卡适用的门店集合")
    private List<Integer> useStoreList;

    @ApiModelProperty("会员卡适用门店集合数量")
    private Integer useStoreListSize;

    @ApiModelProperty("会员卡适用的服务集合")
    private List<Integer> useServiceList;

    @ApiModelProperty("会员卡适用的服务集合数量")
    private Integer useServiceListSize;

    @ApiModelProperty("售卡的门店ID")
    private String saleStoreId;

    @ApiModelProperty("售卡的门店ID前端")
    private String storeId;

    @ApiModelProperty("售卡的门店名称")
    private String saleStoreName;

    @ApiModelProperty("发行单位(0：平台，1：店铺)")
    private Boolean isPlatform;

    @ApiModelProperty("交易金额（以分为单位存入）")
    private Integer tradeAmount;

    @ApiModelProperty("0:充值，1：消费(默认0),2:购卡")
    private Byte useType;

    @ApiModelProperty("交易类型(0:微信支付，1：支付宝支付，2：其他)")
    private Byte payType;

    @ApiModelProperty("交易时间")
    private Date useTime;

    @ApiModelProperty("支付状态(0:未支付，1：已支付)")
    private Byte payStatus;

    @ApiModelProperty("交易流水号")
    private String tradeNo;

    @ApiModelProperty("售卡起始时间")
    private Date startTime;

    @ApiModelProperty("售卡结束时间")
    private Date endTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @ApiModelProperty("会员卡开始使用时间")
    private Date useStartTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @ApiModelProperty("会员卡过期时间")
    private Date expiredTime;

}
