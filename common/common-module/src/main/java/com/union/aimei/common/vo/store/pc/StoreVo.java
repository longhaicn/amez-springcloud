package com.union.aimei.common.vo.store.pc;

import com.union.aimei.common.model.store.Store;
import com.union.aimei.common.model.store.StoreExtend;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 门店vo
 *
 * @author liurenkai
 * @time 2017/12/20 18:15
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "门店vo")
public class StoreVo implements Serializable {

    @ApiModelProperty("门店")
    private Store store;

    @ApiModelProperty("门店扩展")
    private StoreExtend storeExtend;
}
