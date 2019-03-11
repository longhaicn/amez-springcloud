package com.union.aimei.common.vo.store.pc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 精选店铺
 *
 * @author liurenkai
 * @time 2018/4/19 19:17
 */
@Data
@EqualsAndHashCode
@ApiModel("精选店铺")
public class StoreBySelectVo implements Serializable {

    @ApiModelProperty("店铺ID")
    private Integer id;

    @ApiModelProperty("排序")
    private Integer sort;

}
