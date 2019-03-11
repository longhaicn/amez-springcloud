package com.union.aimei.common.vo.product.pc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品(品牌)
 *
 * @author liurenkai
 * @time 2018/1/5 17:56
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "商品(品牌)")
public class ProductByBrandVo implements Serializable {

    @ApiModelProperty("商品类型，true-品牌，false-自营")
    private Boolean isBrand;

    @ApiModelProperty("店铺ID")
    private Integer storeId;

    @ApiModelProperty("店铺名称")
    private String storeName;

    @ApiModelProperty("品牌ID")
    private Integer brandId;

    @ApiModelProperty("商品名称")
    private String serverName;

    @ApiModelProperty("审核状态  0,待审核  1,已审核 2,不通过")
    private Integer auditStatus;

    @ApiModelProperty("上架状态  0,下架  1,上架")
    private Integer saleStatus;

    @ApiModelProperty("起始发布时间")
    private Date beginReleaseTime;

    @ApiModelProperty("截止发布时间")
    private Date endReleaseTime;
}
