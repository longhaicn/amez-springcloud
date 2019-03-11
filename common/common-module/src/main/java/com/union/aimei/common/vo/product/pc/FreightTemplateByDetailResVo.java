package com.union.aimei.common.vo.product.pc;

import com.union.aimei.common.model.product.FreightTemplate;
import com.union.aimei.common.model.product.FreightTemplateCity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 运费模板详情结果
 *
 * @author liurenkai
 * @time 2018/3/12 19:23
 */
@Data
@EqualsAndHashCode
@ApiModel("运费模板详情结果")
public class FreightTemplateByDetailResVo implements Serializable {

    @ApiModelProperty("运费模板")
    private FreightTemplate freightTemplate;

    @ApiModelProperty("运费模板城市集合")
    private List<FreightTemplateCity> freightTemplateCityList;

}
