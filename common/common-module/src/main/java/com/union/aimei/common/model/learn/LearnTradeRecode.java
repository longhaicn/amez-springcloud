package com.union.aimei.common.model.learn;

import com.union.aimei.common.vo.learn.app.CourseBeauticianRefVo;
import com.union.aimei.common.vo.learn.app.SignUpUserVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
/**
 * @author houji
 * @date 2018/8/20  10:20
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "交易记录表")
public class LearnTradeRecode implements Serializable {

    @ApiModelProperty("主键id")
    private Integer id;

    @ApiModelProperty("来源id")
    private Integer sourceId;

    @ApiModelProperty("来源名字")
    private String sourceName;

    @ApiModelProperty("来源关联id")
    private Integer sourceRelId;

    @ApiModelProperty("来源类型 0-课程 ， 1-活动")
    private Integer sourceType;

    @ApiModelProperty("支付类型 0-微信、1-支付宝、2-银联、3-他人支付")
    private Byte payType;

    @ApiModelProperty("支付状态，0-未支付 1-已支付")
    private Boolean payStatus;

    @ApiModelProperty("交易金额（以分为单位存入）")
    private Integer tradeAmount;

    @ApiModelProperty("实际交易金额（以分为单位存入）")
    private Integer actualTradeAmount;

    @ApiModelProperty("订单号")
    private String orderNo;

    @ApiModelProperty("交易流水号")
    private String tradeNo;

    @ApiModelProperty("软删除标记，1为正常，0为删除")
    private Boolean isEnabled;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    @ApiModelProperty("会员memberId")
    private Integer memberId;

    @ApiModelProperty("学员名字")
    private String beauticianName;

    @ApiModelProperty("手机号")
    private String mobilePhone;

    @ApiModelProperty("性别，0-男、1-女")
    private Boolean gender;

    @ApiModelProperty("美容师id")
    private Integer beauticianId;



    @ApiModelProperty("课程-美容师-关联")
    private CourseBeauticianRefVo courseBeauticianRefVo;

    @ApiModelProperty("报名人信息")
    private List<SignUpUserVo> signUpUserVosList;

    private static final long serialVersionUID = 1L;
}