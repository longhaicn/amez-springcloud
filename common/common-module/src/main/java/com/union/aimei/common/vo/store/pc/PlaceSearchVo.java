package com.union.aimei.common.vo.store.pc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 位置搜索
 *
 * @author liurenkai
 * @time 2018/3/30 17:16
 */
@Data
@EqualsAndHashCode
@ApiModel("位置搜索")
public class PlaceSearchVo implements Serializable {

    @ApiModelProperty("关键词")
    private String query;

    @ApiModelProperty("城市")
    private String region;

}
