package com.union.aimei.common.vo.product.app.productbeauticianref;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 根据美容师ID删除门店项目条件
 *
 * @author liurenkai
 * @time 2018/8/6 17:25
 */
@Data
@EqualsAndHashCode
@ApiModel("根据美容师ID删除门店项目条件")
public class RemoveStoreByBeauticianIdVo implements Serializable {

    @ApiModelProperty("门店ID")
    private Integer storeId;

    @ApiModelProperty("美容师ID")
    private Integer beauticianId;

}
