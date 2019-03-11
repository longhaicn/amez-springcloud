package com.union.aimei.common.vo.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 筛选条件结果
 *
 * @author liurenkai
 * @time 2018/5/17 20:33
 */
@Data
@EqualsAndHashCode
@ApiModel("筛选条件结果")
public class ConditionResVo implements Serializable {

    @ApiModelProperty("文本")
    private String text;

    @ApiModelProperty("值")
    private String value;

}
