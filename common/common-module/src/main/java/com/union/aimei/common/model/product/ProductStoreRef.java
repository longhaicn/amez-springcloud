package com.union.aimei.common.model.product;

import com.union.aimei.common.model.store.Store;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 项目-门店-关联
 *
 * @author liurenkai
 * @time 2018/1/22 16:09
 */
@Data
@EqualsAndHashCode
@NoArgsConstructor
@ApiModel(value = "项目-门店-关联")
public class ProductStoreRef implements Serializable {

    public ProductStoreRef(Store store) {
        this.storeId = store.getId();
        this.storeName = store.getStoreName();
        this.cityId = store.getCityId();
        this.storeLongitude = store.getStoreLongitude();
        this.storeLatitude = store.getStoreLatitude();
    }

    @ApiModelProperty("距离，M/米为单位，非数据库字段")
    private Long distance;

    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("商品ID")
    private Integer productId;

    @ApiModelProperty("店铺ID")
    private Integer storeId;

    @ApiModelProperty("店铺名称")
    private String storeName;

    @ApiModelProperty("上架状态  0,下架  1,上架")
    private Integer saleStatus;

    @ApiModelProperty("商品状态：0-冻结，1-正常")
    private Integer productStatus;

    @ApiModelProperty("城市ID")
    private Integer cityId;

    @ApiModelProperty("经度，长度10位，小数点后7位")
    private BigDecimal storeLongitude;

    @ApiModelProperty("纬度，长度10位，小数点后7位")
    private BigDecimal storeLatitude;

    @ApiModelProperty("软删除标记，1为正常，0为删除")
    private Boolean isEnabled;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}