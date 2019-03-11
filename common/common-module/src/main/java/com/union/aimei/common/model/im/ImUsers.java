package com.union.aimei.common.model.im;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * IM用户
 *
 * @author liurenkai
 * @time 2017/11/30 11:04
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "IM用户")
public class ImUsers implements Serializable {
    /**
     * 默认密码
     */
    public static final String DEFAULT_PASSWORD = "amez999";

    @ApiModelProperty("主键ID")
    private Integer id;

    @ApiModelProperty("环信ID")
    private String uuid;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("类型，user-用户")
    private String type;

    @ApiModelProperty("状态，0-离线，1-在线")
    private Integer onlineStatus;

    @ApiModelProperty("是否激活")
    private Boolean activated;

    @ApiModelProperty("创建时间")
    private Long created;

    @ApiModelProperty("修改时间")
    private Long modified;

    @ApiModelProperty("获取时间")
    private Long getTime;

    @ApiModelProperty("结果集的指针（直到没有这个字段，说明已经到最后一页）")
    private String resultCursor;

    private static final long serialVersionUID = 1L;
}