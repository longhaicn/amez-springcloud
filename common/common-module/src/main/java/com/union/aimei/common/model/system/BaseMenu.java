package com.union.aimei.common.model.system;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * @author liufeihua
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
@ApiModel(value = "基础菜单表")
public class BaseMenu implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("菜单Id")
    private Integer menuId;
    @ApiModelProperty("父类菜单Id")
    private Integer parentId;
    @ApiModelProperty("菜单类型")
    private String menuType;
    @ApiModelProperty("菜单名称")
    private String menuName;
    @ApiModelProperty("菜单栏目代码")
    private String menuCode;
    @ApiModelProperty("菜单请求地址")
    private String menuUrl;
    @ApiModelProperty("菜单排序号")
    private Integer sortNo;
    @ApiModelProperty("菜单logo图标")
    private String menuLogo;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("更新时间")
    private Date updateTime;
    private boolean hasChildList = false;
    private List<BaseMenu> childList = new ArrayList<>(10);
    private String href;
    private String name;
    private String type;
}