package com.union.aimei.common.vo.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author GaoWei
 * @time 2018/7/10 11:43
 * @description 统计店铺或平台营业额VO
 */
@Data
@ApiModel
public class StatisticsOrderVo {

    @ApiModelProperty(value = "类型,0:平台，1：店铺",notes = "0:平台，1：店铺")
    private int type;
    @ApiModelProperty(value = "店铺ID")
    private Integer storeId;
    @ApiModelProperty(value = "开始时间")
    private String startTime;
    @ApiModelProperty(value = "结束时间")
    private String endTime;
}
