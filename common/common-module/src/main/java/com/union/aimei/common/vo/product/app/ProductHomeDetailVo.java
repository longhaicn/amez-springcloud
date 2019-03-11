package com.union.aimei.common.vo.product.app;

import com.union.common.baidumap.util.BaiDuMapApi;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 上门项目详情条件
 *
 * @author liurenkai
 * @time 2018/5/26 13:59
 */
@Data
@EqualsAndHashCode
@ApiModel("上门项目详情条件")
public class ProductHomeDetailVo implements Serializable {

    @ApiModelProperty("项目ID")
    private Integer productId;

    @ApiModelProperty("会员ID")
    private Integer memberId;

    @ApiModelProperty("美容师ID（从邦女郎详情进入，不为空，从其它页面进入为空）")
    private Integer beauticianId;

    @ApiModelProperty("城市ID")
    private Integer cityId;

    @ApiModelProperty("地图坐标")
    private BaiDuMapApi.Point point;

}
