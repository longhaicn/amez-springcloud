package com.union.aimei.common.vo.store.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 店铺美容师预收入金额
 *
 * @author liurenkai
 * @time 2018/3/8 17:15
 */
@Data
@EqualsAndHashCode
@ApiModel("店铺预收入金额")
public class StoreBeaByPreIncomeAmountVo implements Serializable {

    @ApiModelProperty("店铺ID")
    private Integer id;

    @ApiModelProperty("预收入金额")
    private Integer preIncomeAmount;
}
