package com.union.aimei.common.vo.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author GaoWei
 * @describe 美容院信息VO
 * @time 2018/1/30,19:08
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "美容院VO")
public class OrderStoreVo {

    @ApiModelProperty(value = "美容院ID")
    private Integer storeId;
    @ApiModelProperty(value = "美容院名称")
    private String storeName;
    @ApiModelProperty(value = "老板名称")
    private String bossName;
    @ApiModelProperty(value = "注册手机")
    private String registerPhone;
    @ApiModelProperty(value = "地址")
    private String storeAddress;
    @ApiModelProperty(value = "服务美容师ID")
    private String beauticianId;
    @ApiModelProperty(value = "服务美容师")
    private String beauticianName;

}
