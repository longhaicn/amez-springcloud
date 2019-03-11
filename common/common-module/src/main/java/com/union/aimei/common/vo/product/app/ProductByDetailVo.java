package com.union.aimei.common.vo.product.app;

import com.union.common.baidumap.util.BaiDuMapApi;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 到店项目详情条件
 *
 * @author liurenkai
 * @time 2018/3/7 14:22
 */
@Data
@EqualsAndHashCode
@ApiModel("到店项目详情条件")
public class ProductByDetailVo implements Serializable {

    @ApiModelProperty("商品ID")
    private Integer productId;

    @ApiModelProperty("会员ID")
    private Integer memberId;

    @ApiModelProperty("地图坐标")
    private BaiDuMapApi.Point point;

}
