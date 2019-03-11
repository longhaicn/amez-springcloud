package com.union.aimei.common.vo.product.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 根据门店ID查询上门服务条件
 *
 * @author liurenkai
 * @time 2018/6/8 11:50
 */
@Data
@EqualsAndHashCode
@ApiModel("根据门店ID查询上门服务条件")
public class ProductListStoreByStoreIdVo implements Serializable {

    /**
     * 排序类型，1-热销，2-新品，3-价格
     */
    public interface SortType {
        int SALE_VOLUME = 1;
        String SALE_VOLUME_FIELD = "p.sale_volume";
        int NEW_PRODUCT = 2;
        String NEW_PRODUCT_FIELD = "p.create_time";
        int PRICE = 3;
        String PRICE_FIELD = "p.sale_price";
    }

    @ApiModelProperty("门店ID")
    private Integer storeId;

    @ApiModelProperty("排序类型，1-热销，2-新品，3-价格")
    private Integer sortType;

    @ApiModelProperty("排序，true-顺序，false-倒序")
    private Boolean sort;

}
