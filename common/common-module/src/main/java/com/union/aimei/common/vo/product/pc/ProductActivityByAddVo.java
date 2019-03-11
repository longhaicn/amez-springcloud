package com.union.aimei.common.vo.product.pc;

import com.union.aimei.common.model.product.ActivityProductRef;
import com.union.aimei.common.model.product.ProductActivity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 新增项目活动条件
 *
 * @author liurenkai
 * @time 2018/5/15 14:38
 */
@Data
@EqualsAndHashCode
@ApiModel("新增项目活动条件")
public class ProductActivityByAddVo implements Serializable {

    @ApiModelProperty("项目活动")
    private ProductActivity activity;

    @ApiModelProperty("活动-项目-关联集合")
    private List<ActivityProductRef> productRefList;

}
