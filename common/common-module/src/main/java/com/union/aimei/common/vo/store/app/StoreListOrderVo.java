package com.union.aimei.common.vo.store.app;

import com.union.aimei.common.vo.common.MapPointVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 订单门店列表条件
 *
 * @author liurenkai
 * @time 2018/6/21 19:13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("订单门店列表条件")
public class StoreListOrderVo extends MapPointVo {

    /**
     * 排序类型，1-距离，2-销量，3-价格
     */
    public interface SortType {
        int DISTANCE = 1;
        int SALE_VOLUME = 2;
        int SALE_PRICE = 3;
    }

    @ApiModelProperty("服务类型，0-到店，1-上门")
    private Integer serverType;

    @ApiModelProperty("项目ID")
    private Integer productId;

    @ApiModelProperty("门店ID")
    private Integer storeId;

    @ApiModelProperty("排序类型，1-距离，2-销量，3-价格")
    private Integer sortType;

    @ApiModelProperty("排序，true-顺序，false-倒序")
    private Boolean sort;
}
