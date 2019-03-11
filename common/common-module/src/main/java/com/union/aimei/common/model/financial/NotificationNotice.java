package com.union.aimei.common.model.financial;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class NotificationNotice implements Serializable {
    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("公告内容")
    private String noticeContent;

    @ApiModelProperty("公告状态,0-公告中,1-已停止")
    private Integer noticeStatus;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @ApiModelProperty("公告开始时间")
    private Date noticeStartTime;

    @ApiModelProperty("发布时间")
    private Date publishTime;

    @ApiModelProperty("客服端")
    private Integer usedType;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @ApiModelProperty("公告结束时间")
    private Date noticeEndTime;

    @ApiModelProperty("备注")
    private String remarks;

    private static final long serialVersionUID = 1L;
}