package com.union.aimei.common.vo.product.app;

import com.union.aimei.common.model.product.Product;
import com.union.aimei.common.model.product.ProductBeauticianRef;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author liurenkai
 * @time 2018/3/21 20:28
 */
@Data
@EqualsAndHashCode
@ApiModel("项目-美容师-关联详情结果（招募）")
public class ProductBeauticianRefByDetailForRecruitResVo implements Serializable {

    @ApiModelProperty("项目-美容师-关联")
    private ProductBeauticianRef productBeauticianRef;

    @ApiModelProperty("商品")
    private Product product;

}
