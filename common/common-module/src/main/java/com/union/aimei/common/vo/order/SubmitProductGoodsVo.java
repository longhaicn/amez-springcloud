package com.union.aimei.common.vo.order;


import com.union.aimei.common.vo.product.app.PhysicalByInventoryVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 提交实物产品订单Vo
 *
 * @author gaowei
 * @time 2018/8/24 10:03
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "提交实物产品订单Vo")
public class SubmitProductGoodsVo {

    @ApiModelProperty(value = "美容师ID",required = true)
    private Integer beauticianId;
    @ApiModelProperty(value = "美容师号码",required = true)
    private String beauticianPhone;
    @ApiModelProperty(value = "收货人号码",required = true)
    private String consigneePhone;
    @ApiModelProperty(value = "收货人姓名",required = true)
    private String consignee;
    @ApiModelProperty(value = "收货地址",required = true)
    private String address;
    @ApiModelProperty(value = "邮费")
    private Integer postage;
    @ApiModelProperty(value = "备注")
    private String remark;
    @ApiModelProperty(value = "产品库存集合",required = true)
    private List<PhysicalByInventoryVo> physicalInventoryList;
}
