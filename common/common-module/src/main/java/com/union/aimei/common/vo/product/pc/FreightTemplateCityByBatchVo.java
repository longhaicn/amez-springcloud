package com.union.aimei.common.vo.product.pc;

import com.union.aimei.common.model.product.FreightTemplateCity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 批量运费模板城市
 *
 * @author liurenkai
 * @time 2018/3/13 10:28
 */
@Data
@EqualsAndHashCode
@ApiModel("批量运费模板城市")
public class FreightTemplateCityByBatchVo implements Serializable {

    public FreightTemplateCityByBatchVo() {

    }

    public FreightTemplateCityByBatchVo(List<FreightTemplateCity> cityList) {
        this.cityList = cityList;
    }

    @ApiModelProperty("运费模板城市集合")
    private List<FreightTemplateCity> cityList;

}
