package com.union.aimei.common.vo.store.app;

import com.union.aimei.common.model.store.Store;
import com.union.aimei.common.model.store.StoreExtend;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 修改门店
 *
 * @author liurenkai
 * @time 2018/5/25 16:21
 */
@Data
@EqualsAndHashCode
@ApiModel("修改门店")
public class StoreByModifyVo implements Serializable {

    @ApiModelProperty("门店")
    private Store store;

    @ApiModelProperty("门店扩展")
    private StoreExtend storeExtend;
}
