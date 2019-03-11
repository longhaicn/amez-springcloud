package com.union.aimei.common.vo.product.pc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 查询首页楼层到店项目列表条件
 *
 * @author liurenkai
 * @time 2018/7/25 16:42
 */
@Data
@EqualsAndHashCode
@ApiModel("查询首页楼层到店项目列表条件")
public class ProductListStoreHomeFloorVo implements Serializable {

    @ApiModelProperty("城市ID")
    private Integer cityId;

    @ApiModelProperty("项目名称")
    private String serverName;

    @ApiModelProperty("项目类型，1-门店自营，2-品牌，3-平台自营")
    private Integer productType;

}
