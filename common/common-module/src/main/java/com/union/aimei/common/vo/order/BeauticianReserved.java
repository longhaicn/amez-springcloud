package com.union.aimei.common.vo.order;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.Map;

/**
 * @author GaoWei
 * @describe 美容师预约看板
 * @time 2017/12/27,11:29
*/
@Data
@EqualsAndHashCode
public class BeauticianReserved {

    @ApiModelProperty(value = "订单ID")
    private Integer orderId;
    @ApiModelProperty(value = "美容师ID")
    private Integer id;
    @ApiModelProperty(value = "美容师名称")
    private String name;
    @ApiModelProperty(value = "美容师头像")
    private String imgUrl;
    @ApiModelProperty(value = "美容师预约数量")
    private int num;
    @ApiModelProperty(value = "美容师订单简略介绍")
    List<Map<String,Object>> beauticianOrder;
}
