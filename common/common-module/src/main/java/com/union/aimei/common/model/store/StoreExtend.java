package com.union.aimei.common.model.store;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 店铺扩展
 *
 * @author liurenkai
 * @time 2018/1/12 19:08
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "店铺扩展")
public class StoreExtend implements Serializable {
    @ApiModelProperty("编号")
    private Integer id;

    @ApiModelProperty("店铺ID")
    private Integer storeId;

    @ApiModelProperty("合同")
    private String contract;

    @ApiModelProperty("公司名称")
    private String companyName;

    @ApiModelProperty("营业执照号码")
    private String businessLicenseNumber;

    @ApiModelProperty("法人姓名")
    private String legalPersonName;

    @ApiModelProperty("法人身份证号码")
    private String legalPersonIdcard;

    @ApiModelProperty("企业收款账号-开户银行")
    private String eraBank;

    @ApiModelProperty("企业收款账号-开户地区")
    private String eraArea;

    @ApiModelProperty("企业收款账号-支行名称")
    private String eraBankBranch;

    @ApiModelProperty("企业收款账号-公司名称")
    private String eraCompanyName;

    @ApiModelProperty("企业收款账号-银行卡号")
    private String eraBankCardNumber;

    @ApiModelProperty("商户个人收款账号-开户银行")
    private String praBank;

    @ApiModelProperty("商户个人收款账号-开户地区")
    private String praArea;

    @ApiModelProperty("商户个人收款账号-支行名称")
    private String praBankBranch;

    @ApiModelProperty("商户个人收款账号-开户名称")
    private String praAccountName;

    @ApiModelProperty("商户个人收款账号-银行卡号")
    private String praBankCardNumber;

    @ApiModelProperty("营业执照")
    private String businessLicense;

    @ApiModelProperty("卫生许可证")
    private String hygienicLicense;

    @ApiModelProperty("身份证头像面照")
    private String idcardPositivePhoto;

    @ApiModelProperty("身份证国徽面照")
    private String idcardNegativePhoto;

    @ApiModelProperty("身份证手持照")
    private String idcardHandheldPhoto;

    @ApiModelProperty("店门照")
    private String storeDoorPhoto;

    @ApiModelProperty("店收银台照")
    private String storeCashierPhoto;

    @ApiModelProperty("店内照")
    private String storeInPhoto;

    @ApiModelProperty("保证金缴纳状态")
    private Boolean marginPaymentStatus;

    @ApiModelProperty("缴费金额")
    private Integer paymentAmount;

    @ApiModelProperty("店铺面积")
    private Integer storeArea;

    @ApiModelProperty("店铺资质和荣誉")
    private String storeHonorPhoto;

    @ApiModelProperty("店铺图片")
    private String storePhote;

    @ApiModelProperty("其他服务 ")
    private String otherService;

    @ApiModelProperty("软删除标记，1为正常，0为删除")
    private Boolean isEnabled;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}