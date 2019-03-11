package com.union.aimei.common.model.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 运费模板名称domain
 *
 * @author caizhaoming
 * @time 2018/4/26 15:59
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "运费模板名称domain")
public class FreightTemplateParam implements Serializable {

    @ApiModelProperty("模版名称")
    private String templateName;

    @ApiModelProperty("不包括的id，（新增的时候传 0 ，修改的时候需要传模版对象的id）")
    private Integer notId;

}