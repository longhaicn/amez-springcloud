package com.union.aimei.common.vo.product.pc;

import com.union.aimei.common.model.product.Product;
import com.union.aimei.common.model.product.ProductBeauticianRef;
import com.union.aimei.common.model.store.Store;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 项目-美容师-关联详情结果
 *
 * @author liurenkai
 * @time 2018/3/14 18:07
 */
@Data
@EqualsAndHashCode
@ApiModel("项目-美容师-关联详情结果")
public class ProductBeauticianRefByDetailResVo implements Serializable {

    @ApiModelProperty("项目-美容师-关联")
    private ProductBeauticianRef productBeauticianRef;

    @ApiModelProperty("商品")
    private Product product;

    @ApiModelProperty("门店")
    private Store store;

}
