package com.union.aimei.common.vo.store.pc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 店铺结果（会员卡）
 *
 * @author liurenkai
 * @time 2018/2/2 15:22
 */
@Data
@EqualsAndHashCode
@ApiModel("店铺结果（会员卡）")
public class StoreByMemberCardResultVo implements Serializable {

    @ApiModelProperty("编号")
    private Integer id;

    @ApiModelProperty("店铺名称")
    private String storeName;

    @ApiModelProperty("老板账号")
    private String bossName;

    @ApiModelProperty("老板手机号码")
    private String bossPhone;

    @ApiModelProperty("省名称")
    private String provinceName;

    @ApiModelProperty("市名称")
    private String cityName;

    @ApiModelProperty("区名称")
    private String areaName;

}
