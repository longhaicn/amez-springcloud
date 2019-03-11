package com.union.aimei.common.vo.product.app;


import com.union.aimei.common.model.product.Product;
import com.union.aimei.common.model.product.ProductActivity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 项目活动详情结果
 *
 * @author liurenkai
 * @time 2018/5/14 10:41
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "项目活动详情结果")
public class ProductActivityByDetailResVo implements Serializable {

    @ApiModelProperty("项目活动")
    private ProductActivity productActivity;

    @ApiModelProperty("商品集合")
    private List<Product> productList;

}
