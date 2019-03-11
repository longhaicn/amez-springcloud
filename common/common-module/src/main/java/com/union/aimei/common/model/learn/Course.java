package com.union.aimei.common.model.learn;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author caizhaoming
 * @create 2018-05-10 10:49
 **/
@Data
@EqualsAndHashCode
@ApiModel(value = "课程表")
public class Course implements Serializable {
    @ApiModelProperty("主键id")
    private Integer id;

    @ApiModelProperty("课程编码")
    private String courseCode;

    @ApiModelProperty("前置课程ids")
    private String beforeCourseId;

    @ApiModelProperty("前置课程names")
    private String beforeCourseName;

    @ApiModelProperty("课程名字")
    private String courseName;

    @ApiModelProperty("课程封面图")
    private String coverImg;

    @ApiModelProperty("培训内容")
    private String courseContent;

    @ApiModelProperty("培训的注意事项")
    private String courseAttention;

    @ApiModelProperty("课程标签")
    private String courseLabel;


    @ApiModelProperty("培训费用")
    private Integer trainingExpenses;

    @ApiModelProperty("是否免费，0-免费，1-收费")
    private Boolean isFree;

    @ApiModelProperty("允许报名的人数")
    private Integer trainingAllowNumber;

    @ApiModelProperty("是否有人数限制，0-无限制，1-有限制")
    private Boolean isRestrict;

    @ApiModelProperty("报名开始时间")
    private String registrationBegin;

    @ApiModelProperty("报名结束时间")
    private String registrationEnd;

    @ApiModelProperty("培训开始时间")
    private String trainingBegin;

    @ApiModelProperty("培训结束时间")
    private String trainingEnd;

    @ApiModelProperty("已报名的人数统计")
    private Integer trainingCountNumber;

    @ApiModelProperty("报名超出的人数")
    private Integer trainingOutNumber;

    @ApiModelProperty("省id")
    private Integer provinceId;

    @ApiModelProperty("市id")
    private Integer cityId;

    @ApiModelProperty("区id")
    private Integer areaId;

    @ApiModelProperty("省名称")
    private String provinceName;

    @ApiModelProperty("市名称")
    private String cityName;

    @ApiModelProperty("县城市")
    private String areaName;

    @ApiModelProperty("详细地区")
    private String storeAddress;

    @ApiModelProperty("经度，长度10位，小数点后7位")
    private BigDecimal storeLongitude;

    @ApiModelProperty("纬度，长度10位，小数点后7位")
    private BigDecimal storeLatitude;

    @ApiModelProperty("培训状态 （0-未开始、1-进行中、2-已结束）")
    private Byte trainingStatus;

    @ApiModelProperty("培训小时")
    private Integer trainingHours;

    @ApiModelProperty("培训天数")
    private Integer trainingDay;

    @ApiModelProperty("成长值")
    private Integer growthValue;

    @ApiModelProperty("已评测的人数统计")
    private Integer trainingReviewNumber;

    @ApiModelProperty("课程状态 （0-未发布、1-已发布、2-已撤回）")
    private Integer courseStatus;

    @ApiModelProperty("权重排序，数值越高拍越前")
    private Integer permissionsSort;

    @ApiModelProperty("是否有门槛 0-否 1-是")
    private Boolean isCondition;

    @ApiModelProperty("软删除标记，1为正常，0为删除")
    private Boolean isEnabled;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    /**
     * 是否删除 true-否
     */
    public static final boolean IS_ENABLED_TURE = true;
    /**
     * 是否删除 false-是
     */
    public static final boolean IS_ENABLED_FALSE = false;

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
     * 是否有人数限制，false-无限制
     */
    public static final boolean IS_RESTRICT_FALSE = false;
    /**
     * 是否有人数限制，true-有限制
     */
    public static final boolean IS_RESTRICT_TRUE = true;


    /**
     * 是否免费，false-免费，
     */
    public static final boolean IS_FREE_FALSE = false;
    /**
     * 是否免费，true-收费
     */
    public static final boolean IS_FREE_TRUE = true;

    /**
     * 是否有门槛 1-是
     */
    public static final boolean IS_CONDITION_TRUE = true;
    /**
     * 是否有门槛 0-否
     */
    public static final boolean IS_CONDITION_FALSE = false;

    /**
     * 培训状态 0-未开始
     */
    public static final byte TRAINING_STATUS_FOR_THE = 0;
    /**
     * 培训状态 1-进行中
     */
    public static final byte TRAINING_STATUS_ONGOING = 1;
    /**
     * 培训状态 2-已结束
     */
    public static final byte TRAINING_STATUS_ENDED = 2;

    private static final long serialVersionUID = 1L;
}