package com.union.aimei.common.vo.store.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 美容师查询条件（预约时间）
 *
 * @author liurenkai
 * @time 2018/1/13 17:28
 */
@Data
@EqualsAndHashCode
@ApiModel("美容师查询条件（预约时间）")
public class StoreBeauticianByAppointmentVo implements Serializable {

    @ApiModelProperty(value = "店铺ID")
    private Integer storeId;

    @ApiModelProperty(value = "预约时间")
    private String appointmentTime;

}
