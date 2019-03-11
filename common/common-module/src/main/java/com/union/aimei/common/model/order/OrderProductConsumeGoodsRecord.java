package com.union.aimei.common.model.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单-服务消耗实物产品记录表
 *
 * @author gaowei
 * @time 2018/8/24 10:03
 */
@Data
@EqualsAndHashCode
@ApiModel(value="订单-服务消耗实物产品记录表")
public class OrderProductConsumeGoodsRecord implements Serializable {
       @ApiModelProperty("主键ID")
       private Integer id;

       @ApiModelProperty("订单ID")
       private Integer orderId;

       @ApiModelProperty("服务ID")
       private Integer productId;

       @ApiModelProperty("实物产品id")
       private Integer productPhysicalId;

       @ApiModelProperty("实物产品名称")
       private String productPhysicalName;

       @ApiModelProperty("销售价格")
       private Integer salePrice;

       @ApiModelProperty("产品编码")
       private String physicalCode;

       @ApiModelProperty("封面图")
       private String coverImg;

       @ApiModelProperty("单位")
       private String unit;

       @ApiModelProperty("消耗数量")
       private Integer consumeNum;

       @ApiModelProperty("消耗时间")
       private Date addTime;

       private static final long serialVersionUID = 1L;
}