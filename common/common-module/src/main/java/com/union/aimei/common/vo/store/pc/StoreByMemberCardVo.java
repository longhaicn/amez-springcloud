package com.union.aimei.common.vo.store.pc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 店铺（会员卡）
 *
 * @author liurenkai
 * @time 2018/2/2 15:22
 */
@Data
@EqualsAndHashCode
@ApiModel("店铺（会员卡）")
public class StoreByMemberCardVo implements Serializable {

    @ApiModelProperty("品牌ID")
    private Integer brandId;

    @ApiModelProperty("店铺名称")
    private String storeName;

    @ApiModelProperty("省ID")
    private Integer productId;

    @ApiModelProperty("市ID")
    private Integer cityId;

    @ApiModelProperty("区ID")
    private Integer areaId;

    @ApiModelProperty("店铺ID集合")
    private List<Integer> storeIdList;

}
