package com.union.aimei.common.vo.learn.pc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 更新排课表数据
 *
 * @author caizhaoming
 * @create 2018-05-10 15:32
 **/
@Data
@EqualsAndHashCode
@ApiModel("更新排课表数据")
public class UpdateCourseArrangEnabledVo implements Serializable {

    @ApiModelProperty("课程id")
    private Integer courseId;

    @ApiModelProperty("课程状态 （0-未发布、1-已发布、2-已撤回）")
    private Integer courseStatus;

    @ApiModelProperty("软删除标记，1为正常，0为删除")
    private Boolean isEnabled;

}
