package com.union.aimei.common.vo.product.pc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 课程通过项目条件
 *
 * @author liurenkai
 * @time 2018/6/22 13:52
 */
@Data
@EqualsAndHashCode
@ApiModel("课程通过项目条件")
public class CoursePassProductVo implements Serializable {

    @ApiModelProperty("项目ID")
    private Integer productId;

    @ApiModelProperty("项目类型，0-到店，1-上门")
    private Integer serverType;

}
