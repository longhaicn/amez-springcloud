package com.union.aimei.common.vo.learn.pc;

import com.union.aimei.common.model.learn.Course;
import com.union.aimei.common.model.learn.CourseEvaluate;
import com.union.aimei.common.model.learn.LearnCondition;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 课程培训数据vo
 *
 * @author caizhaoming
 * @create 2018-05-10 10:49
 **/
@Data
@EqualsAndHashCode
@ApiModel("课程培训数据vo")
public class CourseDataVo implements Serializable {


    @ApiModelProperty("课程数据")
    private Course course;

    @ApiModelProperty("服务数据list")
    private List<InsertCourseProductVo> insertCourseProductVo;

    @ApiModelProperty("图片集合")
    private List<String> learnImgList;

    @ApiModelProperty("评测集合")
    private List<CourseEvaluate> courseEvaluateList;


    @ApiModelProperty("前台传参门槛集合")
    private List<LearnConditionVo> learnConditionVoList;

    @ApiModelProperty("后台逻辑门槛集合")
    private List<LearnCondition> learnConditionList;


}
