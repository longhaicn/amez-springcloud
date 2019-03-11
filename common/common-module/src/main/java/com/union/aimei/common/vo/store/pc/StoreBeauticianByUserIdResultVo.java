package com.union.aimei.common.vo.store.pc;

import com.union.aimei.common.model.store.Store;
import com.union.aimei.common.model.store.StoreBeautician;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 店铺美容师结果（用户ID）
 *
 * @author liurenkai
 * @time 2018/1/19 10:17
 */
@Data
@EqualsAndHashCode
@ApiModel("店铺美容师结果（用户ID）")
public class StoreBeauticianByUserIdResultVo implements Serializable {

    @ApiModelProperty("店铺美容师")
    private StoreBeautician storeBeautician;

    @ApiModelProperty("店铺")
    private Store store;
}
