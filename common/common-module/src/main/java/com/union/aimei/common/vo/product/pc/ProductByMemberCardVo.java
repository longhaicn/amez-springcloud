package com.union.aimei.common.vo.product.pc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 商品（会员卡）
 *
 * @author liurenkai
 * @time 2018/2/2 15:42
 */
@Data
@EqualsAndHashCode
@ApiModel("商品（会员卡）")
public class ProductByMemberCardVo implements Serializable {

    @ApiModelProperty("店铺ID集合")
    private List<Integer> storeIdList;

    @ApiModelProperty("商品名称")
    private String serverName;

    @ApiModelProperty("商品ID集合")
    private List<Integer> productIdList;
}
