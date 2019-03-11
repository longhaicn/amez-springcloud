package com.union.aimei.common.vo.product.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 批量产品ID
 *
 * @author liurenkai
 * @time 2018/3/5 14:51
 */
@Data
@EqualsAndHashCode
@ApiModel("批量产品ID")
public class ProductPhysicalByIdBatchVo implements Serializable {

    @ApiModelProperty("产品ID集合")
    private List<Integer> productPhysicalIdList;
}
