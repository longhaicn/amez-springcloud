package com.union.aimei.common.vo.product.pc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 项目-美容师-关联查询条件
 *
 * @author liurenkai
 * @time 2018/3/29 10:32
 */
@Data
@EqualsAndHashCode
@ApiModel("项目-美容师-关联查询条件")
public class ProductBeauticianRefVo implements Serializable {

    @ApiModelProperty("店铺ID")
    private Integer storeId;

    @ApiModelProperty("店铺名称")
    private String storeName;

    @ApiModelProperty("美容师昵称")
    private String beauticianNickName;

    @ApiModelProperty("服务类型，0-到店，1-上门")
    private Integer serverType;

    @ApiModelProperty("同意状态，0-待处理，1-已同意，2-已拒绝")
    private Integer agreeStatus;

    @ApiModelProperty("审核状态，0-待审核，1-审核通过，2-不通过")
    private Integer authStatus;

    @ApiModelProperty("商品名称")
    private String serverName;

}
