package com.union.aimei.common.vo.store.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 美容师服务时间结果
 *
 * @author liurenkai
 * @time 2018/6/13 9:39
 */
@Data
@EqualsAndHashCode
@ApiModel("美容师服务时间结果")
public class BeauticianServiceTimeResVo implements Serializable {

    @ApiModelProperty("美容师ID")
    private Integer beauticianId;

    @ApiModelProperty("开始服务时间")
    private String startServiceTime;

    @ApiModelProperty("结束服务时间")
    private String endServiceTime;

}
