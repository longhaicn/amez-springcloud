package com.union.aimei.common.vo.product.app;

import com.union.aimei.common.model.product.Product;
import com.union.aimei.common.model.product.ProductImg;
import com.union.aimei.common.vo.store.app.BeauticianNearestByProductIdResVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 上门项目详情结果
 * @author liurenkai
 * @time 2018/5/26 14:01
 */
@Data
@EqualsAndHashCode
@ApiModel("上门项目详情结果")
public class ProductHomeDetailResVo implements Serializable {

    @ApiModelProperty("项目")
    private Product product;

    @ApiModelProperty("项目图片")
    private ProductImg productImg;

    @ApiModelProperty("最近时间，星级最高的美容师")
    private BeauticianNearestByProductIdResVo beautician;

    @ApiModelProperty("是否收藏标记")
    private Boolean isCollection;

}