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
@ApiModel(value = "日志表")
public class BaseLogs implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    @ApiModelProperty("账号名称")
    private String userName;
    @ApiModelProperty("部门名称")
    private String departmentName;
    @ApiModelProperty("登录时间")
    private Date loginTime;
    @ApiModelProperty("是否登录成功1成功,0失败")
    private Boolean isLogin;
    @ApiModelProperty("登录Ip地址")
    private String loginIp;
    @ApiModelProperty("操作内容")
    private String remarks;
}