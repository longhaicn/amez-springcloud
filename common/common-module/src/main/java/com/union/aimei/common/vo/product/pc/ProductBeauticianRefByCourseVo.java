package com.union.aimei.common.vo.product.pc;

import com.union.aimei.common.model.learn.Course;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Set;

/**
 * 项目-美容师-关联-课程
 *
 * @author liurenkai
 * @time 2018/6/4 19:54
 */
@Data
@EqualsAndHashCode
@ApiModel("项目-美容师-关联-课程")
public class ProductBeauticianRefByCourseVo implements Serializable {

    @ApiModelProperty("项目ID集合")
    private Set<Integer> productIdList;

    @ApiModelProperty("美容师ID")
    private Integer beauticianId;

    @ApiModelProperty("课程")
    private Course course;

    @ApiModelProperty("会员ID")
    private Integer memberId;

}
