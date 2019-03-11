package com.union.aimei.common.vo.product.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 项目管理列表条件
 *
 * @author liurenkai
 * @time 2018/6/13 17:36
 */
@Data
@EqualsAndHashCode
@ApiModel("项目管理列表条件")
public class ProductListManageVo implements Serializable {

    /**
     * 列表类型，1-上架中，2-下架中，3-审核中，4-未通过
     */
    public interface ListType {
        int ON_SALE = 1;
        int OFF_SHELVES = 2;
        int PENDING = 3;
        int NOT_PASS = 4;
    }

    @ApiModelProperty("列表类型，1-上架中，2-下架中，3-审核中，4-未通过")
    private Integer listType;

    @ApiModelProperty("门店ID")
    private Integer storeId;

}
