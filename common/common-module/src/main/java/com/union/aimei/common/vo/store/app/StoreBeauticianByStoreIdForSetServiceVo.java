package com.union.aimei.common.vo.store.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 店铺美容师（设置店铺客服）
 *
 * @author liurenkai
 * @time 2018/1/19 17:06
 */
@Data
@EqualsAndHashCode
@ApiModel("店铺美容师（设置店铺客服）")
public class StoreBeauticianByStoreIdForSetServiceVo implements Serializable {

    @ApiModelProperty("店铺ID")
    private Integer storeId;

    @ApiModelProperty("客服ID集合")
    private List<Integer> idLsit;
}
