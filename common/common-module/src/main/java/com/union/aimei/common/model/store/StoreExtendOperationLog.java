package com.union.aimei.common.model.store;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 店铺扩展操作日志
 *
 * @author liurenkai
 * @time 2018/4/11 14:29
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "店铺扩展操作日志")
public class StoreExtendOperationLog implements Serializable {
    @ApiModelProperty("编号")
    private Integer id;

    @ApiModelProperty("店铺ID")
    private Integer storeId;

    @ApiModelProperty("操作内容")
    private String content;

    @ApiModelProperty("原值")
    private String oldValue;

    @ApiModelProperty("新值")
    private String newValue;

    @ApiModelProperty("操作人ID")
    private Integer operationUserId;

    @ApiModelProperty("操作人登录名")
    private String operationLoginName;

    @ApiModelProperty("操作时间")
    private Date operationTime;

    private static final long serialVersionUID = 1L;
}