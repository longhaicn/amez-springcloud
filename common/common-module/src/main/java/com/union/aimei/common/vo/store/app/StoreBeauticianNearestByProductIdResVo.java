package com.union.aimei.common.vo.store.app;

import com.union.aimei.common.model.store.Store;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 根据项目ID查询最近的门店美容师结果
 *
 * @author liurenkai
 * @time 2018/6/25 20:04
 */
@Data
@EqualsAndHashCode
@ApiModel("根据项目ID查询最近的门店美容师结果")
public class StoreBeauticianNearestByProductIdResVo implements Serializable {

    @ApiModelProperty("门店")
    private Store store;

    @ApiModelProperty("美容师")
    private BeauticianNearestByProductIdResVo storeBeautician;

}
