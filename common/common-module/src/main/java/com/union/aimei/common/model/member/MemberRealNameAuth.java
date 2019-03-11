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
@ApiModel(value="会员卡实名认证表")
public class MemberRealNameAuth implements Serializable {
       @ApiModelProperty("主键ID")
       private Integer id;

       @ApiModelProperty("会员ID")
       private Integer memberId;

       @ApiModelProperty("真实姓名")
       private String realName;

       @ApiModelProperty("身份证号码")
       private String idCard;

       @ApiModelProperty("身份证正面照")
       private String idCardFacedPhoto;

       @ApiModelProperty("身份证反面照")
       private String idCardObservePhone;

       @ApiModelProperty("身份证手持照")
       private String idCardHandheldPhone;

       @ApiModelProperty("邦女郎(其他相关证书)")
       private String otherRelatedCertificates;

       @ApiModelProperty("审核状态(0:待审核，1：审核通过，2：审核未通过)")
       private Byte auditStatus;

       @ApiModelProperty("第三方实名认证状态(0: 未认证 1：认证通过 2：认证不通过)")
       private Byte thirdAuthStatus;

       @ApiModelProperty("审核时间")
       private Date auditTime;

       @ApiModelProperty("审核说明")
       private String auditRemark;

       @ApiModelProperty("创建时间")
       private Date createTime;

       @ApiModelProperty("更新时间")
       private Date updateTime;

       @ApiModelProperty("店铺编号")
       private Integer storeId;

       @ApiModelProperty("店铺名称")
       private String storeName;

       @ApiModelProperty("员工手机号")
       private String phone;

       private static final long serialVersionUID = 1L;

       public interface AuditStatus{
              Byte WAIT_AUDIT = 0;
              Byte PASS_AUDIT = 1;
              Byte NOT_PASS_AUDIT = 2;
       }
}