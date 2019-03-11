package com.union.aimei.common.vo.product.app;

import com.union.aimei.common.vo.store.app.StoreByNameResultVo;
import com.github.pagehelper.PageInfo;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 商品与店铺结果(根据名称查询)
 *
 * @author liurenkai
 * @time 2018/1/9 16:43
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "商品与店铺结果(根据名称查询)")
public class ProductStoreByNameResultVo implements Serializable {

    @ApiModelProperty(value = "商品")
    private ResponseMessage<PageInfo<ProductByNameResultVo>> productResponseMessage;

    @ApiModelProperty(value = "店铺")
    private ResponseMessage<PageInfo<StoreByNameResultVo>> storeResponseMessage;
}
