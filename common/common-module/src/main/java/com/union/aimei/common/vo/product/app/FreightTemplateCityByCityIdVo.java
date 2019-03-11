package com.union.aimei.common.vo.product.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 查询运费模板城市（根据城市ID）
 *
 * @author liurenkai
 * @time 2018/3/14 14:52
 */
@Data
@EqualsAndHashCode
@ApiModel("查询运费模板城市（根据城市ID）")
public class FreightTemplateCityByCityIdVo implements Serializable {

    @ApiModelProperty("运费模板ID")
    private Integer templateId;

    @ApiModelProperty("城市ID")
    private Integer cityId;

}
