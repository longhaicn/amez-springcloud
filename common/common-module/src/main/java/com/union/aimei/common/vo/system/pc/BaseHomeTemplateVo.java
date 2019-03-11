package com.union.aimei.common.vo.system.pc;

import com.union.aimei.common.model.system.BaseHomeArea;
import com.union.aimei.common.model.system.BaseHomeFloor;
import com.union.aimei.common.model.system.BaseHomeTemplate;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 保存装修模版的基本数据vo
 *
 * @author caizhaoming
 * @create 2018-05-23 17:24
 **/
@Data
@EqualsAndHashCode
@ApiModel(value = "保存装修模版的基本数据vo")
public class BaseHomeTemplateVo implements Serializable {

    @ApiModelProperty("首页区域表")
    private BaseHomeArea baseHomeArea;

    @ApiModelProperty("首页模板-轮播图、导航按钮、底部菜单")
    private List<BaseHomeTemplate> baseHomeTemplateList;

    @ApiModelProperty("首页模板-活动集合数据")
    private List<BaseHomeFloor> baseHomeFloorList;

    @ApiModelProperty("使用类型 0-用户端，1-帮女郎，2-门店端")
    private Integer useType;

    /**
     * 使用类型 0-用户端，
     */
    public static final int USER_TYPE_USER = 0;
    /**
     * 使用类型 1-帮女郎，
     */
    public static final int USER_TYPE_HELP_GIRL = 1;
    /**
     * 使用类型 2-门店端
     */
    public static final int USER_TYPE_STORE_SIDE = 2;

}
