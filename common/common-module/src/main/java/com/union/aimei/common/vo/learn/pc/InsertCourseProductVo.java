package com.union.aimei.common.vo.learn.pc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 发布课程培训指定服务vo
 *
 * @author caizhaoming
 * @create 2018-05-10 10:49
 **/
@Data
@EqualsAndHashCode
@ApiModel("发布课程培训指定服务")
public class InsertCourseProductVo implements Serializable {

    @ApiModelProperty("服务id")
    private Integer serviceId;

    @ApiModelProperty("服务名字")
    private String serviceName;

    @ApiModelProperty("服务类型名字")
    private String serverTypeName;

    @ApiModelProperty("支持上门标记，1-是，0-否")
    private Integer isSupportHome;


}
