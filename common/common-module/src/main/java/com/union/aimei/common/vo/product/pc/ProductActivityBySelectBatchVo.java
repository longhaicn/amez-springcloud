package com.union.aimei.common.vo.product.pc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 批量精选项目活动条件
 *
 * @author liurenkai
 * @time 2018/5/15 17:05
 */
@Data
@EqualsAndHashCode
@ApiModel("批量精选项目活动条件")
public class ProductActivityBySelectBatchVo implements Serializable {

    @ApiModelProperty("城市ID")
    private Integer cityId;

    @ApiModelProperty("项目活动ID集合")
    private List<Integer> idList;

}
