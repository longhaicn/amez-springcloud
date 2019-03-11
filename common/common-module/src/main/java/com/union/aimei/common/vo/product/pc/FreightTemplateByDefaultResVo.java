package com.union.aimei.common.vo.product.pc;

import com.union.aimei.common.model.product.FreightTemplate;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 运费模板默认结果
 *
 * @author liurenkai
 * @time 2018/3/12 19:23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("运费模板默认结果")
public class FreightTemplateByDefaultResVo extends FreightTemplate {

    @ApiModelProperty("首件数/首重数")
    private Integer firstNumber;

    @ApiModelProperty("首件价格/首重价格")
    private Integer firstPrice;

    @ApiModelProperty("续件数/续重数")
    private Integer continuedNumber;

    @ApiModelProperty("续件价格/续重价格")
    private Integer continuedPrice;

}
