package com.union.aimei.common.vo.member;


import com.union.aimei.common.model.store.Store;
import com.union.aimei.common.model.store.StoreExtend;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 注册门店结果
 *
 * @author liurenkai
 * @time 2018/5/25 17:44
 */
@Data
@EqualsAndHashCode
@ApiModel("注册门店结果")
public class StoreByRegisterResVo implements Serializable {

    @ApiModelProperty("门店")
    private Store store;

    @ApiModelProperty("门店扩展")
    private StoreExtend storeExtend;

}
