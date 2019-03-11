package com.union.aimei.common.model.member;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * @author houji
 * @date 2018/8/10  10:43
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "会员卡使用范围")
public class MemberCardUseRange implements Serializable {
    /**
     * 会员卡状态 0冻结 1正常
     */
    public static final int CARD_STATUS_OFF = 0;
    public static final int CARD_STATUS_ON = 1;
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("主键ID")
    private Integer id;
    @ApiModelProperty("会员卡ID")
    private Integer cardId;
    @ApiModelProperty("可使用门店ID")
    private Integer storeId;
    @ApiModelProperty("可使用门店名称")
    private String storeName;
    @ApiModelProperty("是否启用 0--正常 1--门店关闭 2--卡失效")
    private String disable;
    @ApiModelProperty("会员卡状态：0-冻结，1-正常")
    private Integer cardStatus;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("更新时间")
    private Date updateTime;
}