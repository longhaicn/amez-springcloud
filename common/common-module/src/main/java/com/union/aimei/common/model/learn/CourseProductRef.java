package com.union.aimei.common.model.learn;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author caizhaoming
 * @create 2018-05-10 10:49
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ApiModel(value = "课程适用的服务表")
public class CourseProductRef implements Serializable {
    @ApiModelProperty("主键id")
    private Integer id;

    @ApiModelProperty("课程id")
    private Integer courseId;

    @ApiModelProperty("服务id")
    private Integer serverId;

    @ApiModelProperty("服务名称")
    private String serverName;

    @ApiModelProperty("服务类型名字")
    private String serverTypeName;

    @ApiModelProperty("软删除标记，1为正常，0为删除")
    private Boolean isEnabled;

    @ApiModelProperty("支持上门标记，1-是，0-否")
    private Boolean isSupportHome;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    /**
     * 是否删除 true-否
     */
    public static final Boolean IS_ENABLED_TURE = true ;
    /**
     * 是否删除 false-是
     */
    public static final Boolean IS_ENABLED_FALSE = false ;

    private static final long serialVersionUID = 1L;
}