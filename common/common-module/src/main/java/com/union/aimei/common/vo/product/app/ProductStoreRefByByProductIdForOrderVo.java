package com.union.aimei.common.vo.product.app;

import com.union.aimei.common.vo.store.app.StoreByProductIdForOrderVo;
import com.union.common.baidumap.util.BaiDuMapApi;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 根据商品ID查询项目-门店-关联（提交订单）
 *
 * @author liurenkai
 * @time 2018/1/17 14:12
 */
@Data
@EqualsAndHashCode
@ApiModel("根据商品ID查询项目-门店-关联（提交订单）")
public class ProductStoreRefByByProductIdForOrderVo implements Serializable {

    public ProductStoreRefByByProductIdForOrderVo(StoreByProductIdForOrderVo storeByProductIdForOrderVo) {

    }

    @ApiModelProperty("城市ID")
    private Integer cityId;

    @ApiModelProperty("商品ID")
    private Integer productId;

    @ApiModelProperty("地图坐标")
    private BaiDuMapApi.Point point;

    @ApiModelProperty("排序类型，1-距离，2-销量，3-价格")
    private Integer sortType;

    @ApiModelProperty("排序，0-顺序，1-倒序")
    private Integer sort;

}
