package com.union.aimei.common.vo.product.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 根据美容师ID查询项目列表条件
 *
 * @author liurenkai
 * @time 2018/5/25 15:13
 */
@Data
@EqualsAndHashCode
@ApiModel("根据美容师ID查询项目列表条件")
public class ProductListByBeauticianIdVo implements Serializable {

    /**
     * 列表类型，1-到店，2-上门
     */
    public interface ListType {
        int STORE = 1;
        int HOME = 2;
    }

    @ApiModelProperty("列表类型，1-到店，2-上门")
    private Integer listType;

    @ApiModelProperty("美容师ID")
    private Integer beauticianId;

    @ApiModelProperty("门店ID")
    private Integer storeId;

}
