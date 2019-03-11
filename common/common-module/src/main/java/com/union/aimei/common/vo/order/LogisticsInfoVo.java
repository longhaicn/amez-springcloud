package com.union.aimei.common.vo.order;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.LinkedList;


/**
 * @author GaoWei
 * @describe 物流信息VO
 * @time 2018/3/6,17:59
*/
@Data
@EqualsAndHashCode
@ApiModel(value = "物流信息VO")
public class LogisticsInfoVo {

    @ApiModelProperty(value = "物流公司名称")
    private String logisticsName;
    @ApiModelProperty(value = "运单号")
    private String deliveryNo;
    @ApiModelProperty(value = "配送状态：0在途中、1已揽收、2疑难、3已签收、4退签、5同城派送中、6退回")
    private Integer state;
    @ApiModelProperty(value = "派送内容信息")
    LinkedList<SendInfoVo> linkedList;

}
