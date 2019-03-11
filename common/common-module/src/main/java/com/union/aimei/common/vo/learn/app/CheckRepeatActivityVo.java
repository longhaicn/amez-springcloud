package com.union.aimei.common.vo.learn.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author houji
 * @date 2018/5/23  15:46
 */
@Data
@EqualsAndHashCode
@ApiModel("校验用户或门店报名是否重复")
public class CheckRepeatActivityVo implements Serializable {

    @ApiModelProperty("活动id")
    private Integer activityId;

    @ApiModelProperty("会员id")
    private Integer memberId;

    @ApiModelProperty("门店id")
    private Integer storeId;

}
