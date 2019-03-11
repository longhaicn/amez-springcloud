package com.union.aimei.common.model.member;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;
/**
 * @author houji
 * @date 2018/8/10  10:43
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "会员银行卡表")
public class MemberBankCard implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("主键ID")
    private Integer id;
    @ApiModelProperty("会员ID")
    private Integer memberId;
    @ApiModelProperty("银行卡号码")
    private String bankcard;
    @ApiModelProperty("真实姓名")
    private String realName;
    @ApiModelProperty("身份证号码")
    private String cardNo;
    @ApiModelProperty("银行预留手机号码")
    private String mobile;
    @ApiModelProperty("银行卡所属银行拼音大写缩写(CGB)")
    private String abbreviation;
    @ApiModelProperty("银行图标")
    private String bankimage;
    @ApiModelProperty("银行名称")
    private String bankname;
    @ApiModelProperty("开户银行支行名称")
    private String banknameBranch;
    @ApiModelProperty("银行卡官网网址")
    private String bankurl;
    @ApiModelProperty("银行卡卡名字")
    private String cardname;
    @ApiModelProperty("银行卡类型(银联贷记卡)")
    private String cardtype;
    @ApiModelProperty("所属银行缩写的拼音(China Guangfa Bank)")
    private String enbankname;
    private Boolean isLuhn;
    @ApiModelProperty("信用卡类型")
    private Integer iscreditcard;
    @ApiModelProperty("银行客服电话")
    private String servicephone;
    @ApiModelProperty("类型(0：个人，1：公司，默认0)")
    private Boolean type;
    @ApiModelProperty("第三方实名验证结果(0 --未验证 1 --验证通过 2--验证不通过)")
    private Byte thirdAuthStatus;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("修改时间")
    private Date updateTime;
}