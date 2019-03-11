package com.union.aimei.common.model.system;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
/**
 * @author liufeihua
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
@ApiModel(value="通知公告")
public class BaseNotificationNotice implements Serializable {
    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("活动类型 1-邦女郎,2-门店")
    private Byte activityType;

    @ApiModelProperty("1-首页，2-财务")
    private Byte activityPage;

    @ApiModelProperty("标题")
    private String activityTitle;

    @ApiModelProperty("列表图")
    private String activityImagesUrl;

    @ApiModelProperty("发布状态 1-暂不发布,2-发布")
    private Byte pushStatus;

    @ApiModelProperty("通知详情")
    private String activityDetail;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}