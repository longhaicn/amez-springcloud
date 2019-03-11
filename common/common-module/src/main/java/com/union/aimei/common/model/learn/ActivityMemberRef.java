package com.union.aimei.common.model.learn;

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
@ApiModel(value = "用户活动表")
public class ActivityMemberRef implements Serializable {
    @ApiModelProperty("主键自增")
    private Integer id;

    @ApiModelProperty("活动id")
    private Integer activityId;

    @ApiModelProperty("用户id")
    private Integer memeberId;

    @ApiModelProperty("美容师id")
    private Integer beauticianId;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("手机号")
    private String phone;

    @ApiModelProperty("性别(0--男 1--女)")
    private Boolean sex;

    @ApiModelProperty("参加人标签(0-老板，1-店长，2-全职员工，3-兼职员工，4-朋友)")
    private Integer tag;

    @ApiModelProperty("联系人手机号")
    private String contactPhone;

    @ApiModelProperty("店铺id")
    private Integer storeId;

    @ApiModelProperty("店铺名称")
    private String storeName;

    @ApiModelProperty("支付交易记录refid")
    private Integer tradeRefId;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    @ApiModelProperty("报名周几")
    private String weekdayEntry;

    @ApiModelProperty("完成周几")
    private String weekdayEnd;

    @ApiModelProperty("状态(0--已经报名 1--以完成 2--报名未成功)")
    private Byte status;

    @ApiModelProperty("活动报名所需的用户信息")
    private List<SignUpUserVo> signUpUserVosList;

    private static final long serialVersionUID = 1L;


    public interface Tag {
        Integer BOSS = 0;
        Integer STORE = 1;
        Integer REG_PEO = 2;
        Integer PART_PEO = 3;
        Integer FRIEND = 4;
    }
}