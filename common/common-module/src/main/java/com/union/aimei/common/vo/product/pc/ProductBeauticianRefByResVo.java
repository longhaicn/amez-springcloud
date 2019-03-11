package com.union.aimei.common.vo.product.pc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 项目-美容师-关联结果
 *
 * @author liurenkai
 * @time 2018/3/14 18:28
 */
@Data
@EqualsAndHashCode
@ApiModel("项目-美容师-关联结果")
public class ProductBeauticianRefByResVo implements Serializable {

    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("商品ID")
    private Integer productId;

    @ApiModelProperty("店铺ID")
    private Integer storeId;

    @ApiModelProperty("店铺名称")
    private String storeName;

    @ApiModelProperty("美容师ID")
    private Integer beauticianId;

    @ApiModelProperty("美容师昵称")
    private String beauticianNickName;

    @ApiModelProperty("美容师头像")
    private String beauticianHeadImgUrl;

    @ApiModelProperty("会员ID")
    private Integer memberId;

    @ApiModelProperty("服务类型，0-到店，1-上门")
    private Integer serverType;

    @ApiModelProperty("同意状态，0-待处理，1-已同意，2-已拒绝")
    private Integer agreeStatus;

    @ApiModelProperty("审核状态，0-待审核，1-审核通过，2-不通过")
    private Integer authStatus;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("商品名称")
    private String serverName;

    @ApiModelProperty("销售价")
    private Integer salePrice;

    @ApiModelProperty("正式美容师佣金")
    private Integer formalBeauticianCommission;

    @ApiModelProperty("兼职美容师佣金")
    private Integer parttimeBeauticianCommission;

    @ApiModelProperty("服务所需耗时，分钟为单位")
    private Integer serverNeedTime;

    @ApiModelProperty("商品封面图")
    private String coverImg;

    @ApiModelProperty("上门费")
    private String homeFee;
}
