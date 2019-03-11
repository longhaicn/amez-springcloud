package com.union.aimei.common.vo.store.app;

import com.union.aimei.common.vo.order.OrderTimeVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * 下单美容师服务时间结果
 *
 * @author liurenkai
 * @time 2018/7/6 10:54
 */
@Data
@EqualsAndHashCode
@ApiModel("下单美容师服务时间结果")
public class BeauticianServiceTimeOrderResVo implements Serializable {

    @ApiModelProperty("美容师ID")
    private Integer beauticianId;

    @ApiModelProperty("开始营业时间")
    private Date startBusinessHour;

    @ApiModelProperty("结束营业时间")
    private Date endBusinessHour;

    @ApiModelProperty("忙碌时间集合")
    private Set<OrderTimeVo> busyTimeSet;

}
