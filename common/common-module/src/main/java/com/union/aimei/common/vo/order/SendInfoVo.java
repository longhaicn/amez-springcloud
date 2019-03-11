package com.union.aimei.common.vo.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 物流派送信息Vo
 *
 * @author GaoWei
 * @time 2018/8/24 10:03
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "物流派送信息Vo")
public class SendInfoVo {

    @ApiModelProperty(value = "派送原始时间")
    private String time;
    @ApiModelProperty(value = "派送格式化时间")
    private String ftime;
    @ApiModelProperty(value = "派送美容")
    private String context;
}
