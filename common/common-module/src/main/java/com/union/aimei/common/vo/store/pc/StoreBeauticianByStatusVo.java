package com.union.aimei.common.vo.store.pc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 美容师（状态）
 *
 * @author liurenkai
 * @time 2018/4/16 23:30
 */
@Data
@EqualsAndHashCode
@ApiModel("美容师（状态）")
public class StoreBeauticianByStatusVo implements Serializable {

    @ApiModelProperty("美容师ID")
    private Integer id;

    @ApiModelProperty("状态，0-离职，1-在职，2-休息")
    private Integer beauticianStatus;

}
