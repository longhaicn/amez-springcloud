package com.union.aimei.common.vo.store.app;

import com.union.aimei.common.model.store.Store;
import com.union.aimei.common.model.store.StoreExtend;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 店铺详情结果
 *
 * @author liurenkai
 * @time 2017/12/20 18:15
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "店铺详情结果")
public class StoreByDetailResultVo implements Serializable {

    @ApiModelProperty("店铺")
    private Store store;

    @ApiModelProperty("店铺扩展")
    private StoreExtend storeExtend;

    @ApiModelProperty("收藏标记")
    private Boolean isCollection;

}
