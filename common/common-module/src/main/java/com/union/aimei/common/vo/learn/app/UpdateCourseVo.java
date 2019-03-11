package com.union.aimei.common.vo.learn.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 更新课程数据
 *
 * @author caizhaoming
 * @create 2018-05-18 15:17
 **/
@Data
@EqualsAndHashCode
@ApiModel("更新课程数据")
public class UpdateCourseVo implements Serializable {

    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("类型1-自增已报名的人数 2-已评测的人数")
    private Integer type;

    /**
     * 类型 1-自增已报名的人数
     */
    public static final Integer TYPE_COUNT = 1 ;
    /**
     * 类型 2-已评测的人数
     */
    public static final Integer TYPE_REVIEW = 2 ;


}
