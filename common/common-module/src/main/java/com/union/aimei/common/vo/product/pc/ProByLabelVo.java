package com.union.aimei.common.vo.product.pc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 查询商品条件（商品标签）
 *
 * @author liurenkai
 * @time 2018/4/20 10:50
 */
@Data
@EqualsAndHashCode
@ApiModel("查询商品条件（商品标签）")
public class ProByLabelVo implements Serializable {

    @ApiModelProperty("城市ID")
    private Integer cityId;

    @ApiModelProperty("商品标签，0-默认，1-推荐，2-新品")
    private Integer productLabel;

    @ApiModelProperty("商品名称")
    private String serverName;

}
