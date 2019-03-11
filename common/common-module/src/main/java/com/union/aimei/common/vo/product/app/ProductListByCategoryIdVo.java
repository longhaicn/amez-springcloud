package com.union.aimei.common.vo.product.app;

import com.union.aimei.common.vo.common.MapPointVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 根据分类ID查询项目列表条件
 *
 * @author liurenkai
 * @time 2018/6/12 14:41
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("根据分类ID查询项目列表条件")
public class ProductListByCategoryIdVo extends MapPointVo {

    /**
     * 排序类型，1-热销，2-新品，3-价格
     */
    public interface SortType {
        int SALE_VOLUME = 1;
        String SALE_VOLUME_FIELD = "p.sale_volume";
        int NEW_PRODUCT = 2;
        String NEW_PRODUCT_FIELD = "p.create_time";
        int PRICE = 3;
        String PRICE_FIELD = "p.sale_price";
    }

    @ApiModelProperty("分类ID")
    private Integer categoryId;

    @ApiModelProperty("服务类型，0-到店，1-上门")
    private Integer serverType;

    @ApiModelProperty("品牌ID")
    private Integer brandId;

    @ApiModelProperty("最低销售价格")
    private Integer minSalePrice;

    @ApiModelProperty("最高销售价格")
    private Integer maxSalePrice;

    @ApiModelProperty("服务所需耗时，分钟为单位")
    private String serverNeedTime;

    @ApiModelProperty("功效")
    private String serverEffect;

    @ApiModelProperty(value = "排序类型，1=热销，2，新品，3，价格")
    private Integer sortType;

    @ApiModelProperty(value = "排序，true-顺序，false-倒序")
    private Boolean sort;

}
