package com.union.aimei.common.vo.store.pc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 明星美容师
 *
 * @author liurenkai
 * @time 2018/4/19 19:14
 */
@Data
@EqualsAndHashCode
@ApiModel("明星美容师")
public class BeauticianByStarVo implements Serializable {

    @ApiModelProperty("美容师ID")
    private Integer id;

    @ApiModelProperty("排序")
    private Integer sort;

}
