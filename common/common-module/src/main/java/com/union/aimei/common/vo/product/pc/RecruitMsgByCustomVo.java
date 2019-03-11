package com.union.aimei.common.vo.product.pc;

import com.union.aimei.common.model.product.Product;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 招募消息（自定义）
 *
 * @author liurenkai
 * @time 2018/3/26 15:48
 */
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("招募消息（自定义）")
public class RecruitMsgByCustomVo implements Serializable {

    public RecruitMsgByCustomVo(Product product) {
        this.sendTime = new Date();
        this.productId = product.getId();
        this.serverName = product.getServerName();
        this.coverImg = product.getCoverImg();
        this.isSupportStore = product.getIsSupportStore();
        this.isSupportHome = product.getIsSupportHome();
        this.parttimeBeauticianCommission = product.getParttimeBeauticianCommission();
        this.homeFee = product.getHomeFee();
        this.serverNeedTime = product.getServerNeedTime();
    }

    @ApiModelProperty("推送时间")
    private Date sendTime;

    @ApiModelProperty("商品ID")
    private Integer productId;

    @ApiModelProperty("商品名称")
    private String serverName;

    @ApiModelProperty("商品封面图")
    private String coverImg;

    @ApiModelProperty("支持到店标记，1-是，0-否")
    private Boolean isSupportStore;

    @ApiModelProperty("支持上门标记，1-是，0-否")
    private Boolean isSupportHome;

    @ApiModelProperty("兼职美容师佣金")
    private Integer parttimeBeauticianCommission;

    @ApiModelProperty("上门费")
    private Integer homeFee;

    @ApiModelProperty("服务时长")
    private Integer serverNeedTime;

}
