package com.union.aimei.common.vo.store.pc;

import com.union.aimei.common.vo.store.pc.StoreCouponsProductDetailResultVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 优惠券下所支持服务的id集合vo
 *
 * @author caizhaoming
 * @time 2018/04/18 16:10
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "优惠券下所支持服务的id集合")
public class StoreCouponsProductResultVo {

    @ApiModelProperty(value = "服务id集合")
    private List<StoreCouponsProductDetailResultVo> couponsProductDetailResultVos;

}
