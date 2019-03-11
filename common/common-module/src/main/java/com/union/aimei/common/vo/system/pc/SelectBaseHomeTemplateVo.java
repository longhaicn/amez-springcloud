package com.union.aimei.common.vo.system.pc;

import com.union.aimei.common.model.system.BaseHomeArea;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 获取模版页面的基础数据vo
 *
 * @author caizhaoming
 * @create 2018-05-24 17:24
 **/
@Data
@EqualsAndHashCode
@ApiModel(value = "获取模版页面的基础数据vo")
public class SelectBaseHomeTemplateVo implements Serializable {

    @ApiModelProperty("首页区域表")
    private BaseHomeArea baseHomeArea;

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
