package com.union.aimei.common.vo.member;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author houji
 * @date 2018/4/27  15:24
 */
@Data
@EqualsAndHashCode
@ApiModel(value="品牌发布商品")
public class NewProductGroundVo {

    @ApiModelProperty("品牌Id")
    private Integer brandId;

    @ApiModelProperty("所属品牌下的门店Id集合")
    private List<Integer> storeIdList;

    @ApiModelProperty("商品id")
    private Integer productId;

    @ApiModelProperty("商品名称")
    private Integer productName;

}
