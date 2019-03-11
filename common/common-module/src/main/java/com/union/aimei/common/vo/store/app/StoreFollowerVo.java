package com.union.aimei.common.vo.store.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 收藏店铺vo
 *
 * @author liurenkai
 * @time 2018/1/22 14:44
 */
@Data
@EqualsAndHashCode
@ApiModel("收藏店铺vo")
public class StoreFollowerVo implements Serializable {

    @ApiModelProperty("店铺ID")
    private Integer storeId;

    @ApiModelProperty("粉丝ID")
    private Integer followerId;

    @ApiModelProperty("收藏标记")
    private Boolean isCollection;

}
