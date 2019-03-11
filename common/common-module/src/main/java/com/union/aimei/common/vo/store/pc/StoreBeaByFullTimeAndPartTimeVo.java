package com.union.aimei.common.vo.store.pc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 美容师查询条件（正式与兼职）
 *
 * @author liurenkai
 * @time 2018/4/2 18:35
 */
@Data
@EqualsAndHashCode
@ApiModel("美容师查询条件（正式与兼职）")
public class StoreBeaByFullTimeAndPartTimeVo implements Serializable {

    @ApiModelProperty("城市ID")
    private Integer cityId;

    @ApiModelProperty("店铺ID")
    private Integer storeId;

    @ApiModelProperty("员工类型，0-老板，1-店长，2-正式员工，3-兼职员工")
    private Integer beauticianType;

    @ApiModelProperty("明星标记，1-是，0-否")
    private Boolean isStar;

    @ApiModelProperty("员工名字筛选")
    private String beauticianName;

}
