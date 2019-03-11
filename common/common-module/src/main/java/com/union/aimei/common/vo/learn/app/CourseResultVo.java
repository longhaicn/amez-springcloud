package com.union.aimei.common.vo.learn.app;

import com.union.aimei.common.model.learn.CourseBeauticianRef;
import com.union.aimei.common.model.learn.LearnImg;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 课程返回vo
 *
 * @author caizhaoming
 * @create 2018-05-14 15:09
 **/
@Data
@EqualsAndHashCode
@ApiModel("课程返回vo")
public class CourseResultVo {

    @ApiModelProperty("课程主键id")
    private Integer courseId;

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

    @ApiModelProperty("培训费用")
    private Integer trainingExpenses;

    @ApiModelProperty("报名开始时间")
    private Date registrationBegin;

    @ApiModelProperty("报名结束时间")
    private Date registrationEnd;

    @ApiModelProperty("培训开始时间")
    private Date trainingBegin;

    @ApiModelProperty("培训结束时间")
    private Date trainingEnd;

    @ApiModelProperty("允许报名的人数")
    private Integer trainingAllowNumber;

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

    @ApiModelProperty("经度，长度10位，小数点后7位")
    private BigDecimal storeLongitude;

    @ApiModelProperty("纬度，长度10位，小数点后7位")
    private BigDecimal storeLatitude;

    @ApiModelProperty("详细地区")
    private String storeAddress;

    @ApiModelProperty("课程状态 （0-未发布、1-已发布、2-已撤回）")
    private Integer courseStatus;

    @ApiModelProperty("培训状态 （0-未开始、1-进行中、2-已结束）")
    private Byte trainingStatus;

    @ApiModelProperty("是否免费，0-免费，1-收费")
    private Boolean isFree;

    @ApiModelProperty("是否有人数限制，0-无限制，1-有限制")
    private Boolean isRestrict;

    @ApiModelProperty("课时创建时间")
    private Date createTime;

    @ApiModelProperty("培训小时")
    private Integer trainingHours;

    @ApiModelProperty("培训天数")
    private Integer trainingDay;

    @ApiModelProperty("成长值")
    private Integer growthValue;

    @ApiModelProperty("已评测的人数统计")
    private Integer trainingReviewNumber;

    @ApiModelProperty("图片集合")
    private List<LearnImg> learnImgList;

    @ApiModelProperty("课程列表页图片")
    private String learnImg;

    @ApiModelProperty("课程-美容师-关联")
    private CourseBeauticianRef courseBeauticianRef;

    @ApiModelProperty("详情页按钮判断，0-报名按钮，1-评测按钮（提示课程还未结束，不能进行评测），2-评测按钮（可以进行评测操作），3-查看评测结果")
    private Integer buttonStatus;

    /**
     * 详情页按钮判断，0-报名按钮
     */
    public static final int BUTTON_STATUS_SING_UP = 0;
    /**
     * 详情页按钮判断，1-评测按钮（提示课程还未结束，不能进行评测）
     */
    public static final int BUTTON_STATUS_REVIEW_NO = 1;
    /**
     * 详情页按钮判断，2-评测按钮（可以进行评测操作）
     */
    public static final int BUTTON_STATUS_REVIEW_YES = 2;
    /**
     * 详情页按钮判断，3-查看评测结果
     */
    public static final int BUTTON_STATUS_RESULTS = 3;

}
