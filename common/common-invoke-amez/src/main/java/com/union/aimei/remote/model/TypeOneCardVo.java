package com.union.aimei.remote.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/** 
  * @author GaoWei
  * @Date 18-8-13 下午4:03
  * @description
  */
@Data
@EqualsAndHashCode
@ApiModel(value = "一卡通VO")
public class TypeOneCardVo {
    @ApiModelProperty(value = "ID")
    private Integer id;
    @ApiModelProperty(value = "背景图片地址")
    private String backPictureUrl;
    @ApiModelProperty(value = "一卡通卡号前缀")
    private String cardNoPrefix;
    @ApiModelProperty(value = "一卡通卡类型（ 13种）")
    private Integer cardType;
    @ApiModelProperty(value = "一卡通卡类型名称（ 13种）")
    private String cardTypeName;
    @ApiModelProperty(value = "创建时间")
    private String createTime;
    @ApiModelProperty(value = "创建人")
    private Integer creater;
    @ApiModelProperty(value = "卡折扣")
    private double discount;
    @ApiModelProperty(value = "是否售卖（1 卖 0 不卖 ）")
    private  Integer isSell;
    @ApiModelProperty(value = "定额")
    private Double quota;
    @ApiModelProperty(value = "备注")
    private  String remark;
    @ApiModelProperty(value = "状态（1 有效 0无效 ）")
    private Integer status;
    @ApiModelProperty(value = "修改时间")
    private String updateTime;
    @ApiModelProperty(value = "修改人")
    private Integer updater;
    @ApiModelProperty(value = "有效天数")
    private Integer validDay;

}
