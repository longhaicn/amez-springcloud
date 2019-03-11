package com.union.aimei.common.vo.member;


import com.union.aimei.common.model.store.Store;
import com.union.aimei.common.model.store.StoreBeautician;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 门店美容师（手机号）
 *
 * @author liurenkai
 * @time 2018/1/24 10:32
 */
@Data
@EqualsAndHashCode
@ApiModel("门店美容师结果（手机号）")
public class StoreBeauticianByPhoneResultVo implements Serializable {

    @ApiModelProperty("门店美容师")
    private StoreBeautician storeBeautician;

    @ApiModelProperty("店铺")
    private Store store;

}
