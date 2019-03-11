package com.union.aimei.common.model.system;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
/**
 * @author liufeihua
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
@ApiModel(value = "升级表")
public class BaseAppUpdateVersion implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("主键")
    private Integer id;
    @ApiModelProperty("版本号")
    private Integer versionCode;
    @ApiModelProperty("版本名字")
    private String versionName;
    @ApiModelProperty("描述")
    private String updateContent;
    @ApiModelProperty("apk路径")
    private String updateUrl;
    @ApiModelProperty("app系统类型:1-安卓,2-ios")
    private Integer appSystemType;
    @ApiModelProperty("app客户端类型:1-门店端,2-用户端,3-美容师端")
    private Integer appClientType;
    @ApiModelProperty("强制或者手动更新:1-强制更新,2-手动更新")
    private Integer forced;
    @ApiModelProperty("是否忽更新:1-不忽略,2忽略")
    private Integer ignoreUpdate;
    @ApiModelProperty("md5")
    private String md5;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("更新时间")
    private Date updateTime;
    @ApiModelProperty("备注")
    private String remarks;
}