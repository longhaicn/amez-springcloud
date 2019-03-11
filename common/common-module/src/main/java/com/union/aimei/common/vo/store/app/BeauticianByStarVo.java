package com.union.aimei.common.vo.store.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 明星美容师条件
 *
 * @author liurenkai
 * @time 2018/4/27 15:53
 */
@Data
@EqualsAndHashCode
@ApiModel("明星美容师条件")
public class BeauticianByStarVo implements Serializable {

    @ApiModelProperty("城市ID")
    private Integer cityId;

}
