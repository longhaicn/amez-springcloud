package com.union.aimei.common.vo.financial;

import com.union.aimei.common.model.financial.StoreTradeDetail;
import com.union.aimei.common.model.order.OrderBase;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 店铺流水详情vo
 *
 * @author caizhaoming
 * @create 2018-06-07 13:44
 **/
@Data
@EqualsAndHashCode
@ApiModel(value = "店铺流水详情vo")
public class QueryStoreTradeDetailVo implements Serializable {

    @ApiModelProperty(value = "订单详情")
    private OrderBase orderBase;

    @ApiModelProperty(value = "流水详情")
    private StoreTradeDetail storeTradeDetail;

    @ApiModelProperty(value = "项目类型，1-门店自营，2-品牌，3-平台自营")
    private Integer productType;

    @ApiModelProperty(value = "平台佣金")
    private Integer platformCommission;

    private static final long serialVersionUID = 1L;
}