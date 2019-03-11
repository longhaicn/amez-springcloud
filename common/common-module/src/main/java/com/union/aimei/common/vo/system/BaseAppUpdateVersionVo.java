package com.union.aimei.common.vo.system;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
/**
 * @author dell
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
@ApiModel(value="升级表")
public class BaseAppUpdateVersionVo implements Serializable {

    @ApiModelProperty("版本号")
    private Integer versionCode;

    @ApiModelProperty("版本名字")
    private String versionName;

    @ApiModelProperty("描述")
    private String updateContent;

    @ApiModelProperty("apk路径")
    private String updateUrl;

    @ApiModelProperty("强制或者手动更新:true-强制更新,false-手动更新")
    private boolean forced;

    @ApiModelProperty("是否忽更新:true-不忽略,false-忽略")
    private boolean ignore;

    @ApiModelProperty("md5")
    private String md5;

    private static final long serialVersionUID = 1L;
}