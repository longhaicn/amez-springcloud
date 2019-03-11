package com.union.aimei.common.vo.store.app;

import com.union.common.baidumap.util.BaiDuMapApi;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 根据商品ID查询店铺（提交订单）
 *
 * @author liurenkai
 * @time 2018/1/17 10:59
 */
@Data
@EqualsAndHashCode
@ApiModel("根据商品ID查询店铺（提交订单）")
public class StoreByProductIdForOrderVo implements Serializable {

    @ApiModelProperty("城市ID")
    private Integer cityId;

    @ApiModelProperty("是否品牌标记，1-品牌，0-自营")
    private Boolean isBrand;

    @ApiModelProperty("平台标记，1-是，0-否")
    private Boolean isPlatform;

    @ApiModelProperty("服务类型，0-到店，1-上门")
    private Integer serverType;

    @ApiModelProperty("商品ID")
    private Integer productId;

    @ApiModelProperty("店铺ID")
    private Integer storeId;

    @ApiModelProperty("会员ID")
    private Integer memberId;

    @ApiModelProperty("地图坐标")
    private BaiDuMapApi.Point point;

    @ApiModelProperty("排序类型，1-距离，2-销量，3-价格")
    private Integer sortType;

    @ApiModelProperty("排序，0-顺序，1-倒序")
    private Integer sort;

}
