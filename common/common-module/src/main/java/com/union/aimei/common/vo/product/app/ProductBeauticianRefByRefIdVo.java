package com.union.aimei.common.vo.product.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 根据关联ID条件
 *
 * @author liurenkai
 * @time 2018/6/1 9:54
 */
@Data
@EqualsAndHashCode
@ApiModel("根据关联ID条件")
public class ProductBeauticianRefByRefIdVo implements Serializable {

    @ApiModelProperty("发起方，1-美容师，2-门店，3-平台")
    private Integer sponsor;

    @ApiModelProperty("美容师ID")
    private Integer beauticianId;

    @ApiModelProperty("项目ID")
    private Integer productId;

    @ApiModelProperty("门店ID")
    private Integer storeId;

    @ApiModelProperty("服务类型，0-到店，1-上门")
    private Integer serverType;

    @ApiModelProperty("审核状态集合，0-待审核，1-审核通过，2-审核不通过")
    private List<Integer> auditStatusList;

}
