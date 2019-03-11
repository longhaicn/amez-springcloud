package com.union.aimei.common.vo.product.pc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 课程通过项目-美容师-关联条件
 *
 * @author liurenkai
 * @time 2018/6/22 13:50
 */
@Data
@EqualsAndHashCode
@ApiModel("课程通过项目-美容师-关联条件")
public class ProductBeauticianRefCoursePassVo implements Serializable {

    @ApiModelProperty("项目集合")
    private List<CoursePassProductVo> productList;

    @ApiModelProperty("美容师ID集合")
    private List<Integer> beauticianIdList;

}
