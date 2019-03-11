package com.union.aimei.common.vo.learn.pc;

import com.union.aimei.common.model.learn.Course;
import com.union.aimei.common.model.learn.CourseEvaluate;
import com.union.aimei.common.model.learn.CourseProductRef;
import com.union.aimei.common.model.learn.LearnCondition;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 课程类详情vo
 *
 * @author caizhaoming
 * @create 2018-05-16 11:28
 **/
@Data
@EqualsAndHashCode
@ApiModel("课程类详情vo")
public class CourseDetailVo implements Serializable {


    @ApiModelProperty("课程数据")
    private Course course;

    @ApiModelProperty("服务数据list")
    private List<CourseProductRef> courseProductRefList;

    @ApiModelProperty("图片集合")
    private List<String> learnImgList;

    @ApiModelProperty("评测集合")
    private List<CourseEvaluate> courseEvaluateList;

    @ApiModelProperty("前台传参门槛集合")
    private List<LearnConditionVo> learnConditionVoList;

    @ApiModelProperty("后台逻辑门槛集合")
    private List<LearnCondition> learnConditionList;
}
