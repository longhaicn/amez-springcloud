package com.union.aimei.common.vo.store.app;

import com.union.aimei.common.model.store.Store;
import com.union.aimei.common.model.store.StoreBeautician;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 根据商品ID查询距离最近店铺（提交订单）
 *
 * @author liurenkai
 * @time 2018/1/17 16:22
 */
@Data
@EqualsAndHashCode
@ApiModel("根据商品ID查询距离最近店铺（提交订单）")
public class StoreByProductIdForRecentForOrderResultVo implements Serializable {

    @ApiModelProperty("店铺")
    private Store store;

    @ApiModelProperty("店铺美容师")
    private StoreBeautician storeBeautician;

    @ApiModelProperty("是否招募")
    private Boolean isRecruit;

}
