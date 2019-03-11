package com.union.aimei.common.vo.learn.app;

import com.union.aimei.common.model.store.StoreBeautician;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 课程入参vo
 *
 * @author caizhaoming
 * @create 2018-05-14 15:17
 **/
@Data
@EqualsAndHashCode
@ApiModel("课程入参vo")
public class CourseParamVo {

    @ApiModelProperty("美容师ID")
    private Integer beauticianId;

    @ApiModelProperty("列表类型 （0-课程列表、1-已报名、2-已完成）")
    private Integer type;

    @ApiModelProperty("培训状态 （0-未开始、1-进行中、2-已结束）")
    private Integer trainingStatus;

    @ApiModelProperty("允许学习的课程id（前端无需传）")
    private List<Integer> courseIdList;

    @ApiModelProperty("课程状态 （0-未发布、1-已发布）")
    private Integer courseStatus;

    @ApiModelProperty("省id")
    private Integer provinceId;

    @ApiModelProperty("市id")
    private Integer cityId;

    @ApiModelProperty("区id")
    private Integer areaId;

    @ApiModelProperty("店铺美容师数据")
    private StoreBeautician storeBeautician;


    /**
     * 列表类型 0-课程列表
     */
    public static final int TYPE_LIST = 0;
    /**
     * 列表类型 1-已报名
     */
    public static final int TYPE_LIST_SIGN = 1;
    /**
     * 列表类型 2-已完成
     */
    public static final int TYPE_LIST_COMPLETED = 2;


    /**
     * 课程状态 0-未发布
     */
    public static final int COURSE_STATUS_CLOSE = 0;
    /**
     * 课程状态 1-已发布
     */
    public static final int COURSE_STATUS_OPEN = 1;
    /**
     * 课程状态 2-已撤回
     */
    public static final int COURSE_STATUS_WITHDRAWN = 2;


    /**
     * 培训状态 0-未完成
     */
    public static final int TRAINING_STATUS_NOT_AT = 0;
    /**
     * 培训状态 1-进行中
     */
    public static final int TRAINING_STATUS_ONGOING = 1;
    /**
     * 培训状态 2-已结束
     */
    public static final int TRAINING_STATUS_ENDED = 2;

}
