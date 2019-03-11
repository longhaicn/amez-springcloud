package com.union.aimei.common.vo.store.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 店铺美容师（ID批量）
 *
 * @author liurenkai
 * @time 2018/3/16 14:00
 */
@Data
@EqualsAndHashCode
@ApiModel("店铺美容师（ID批量）")
public class StoreBeauticianByIdBatchVo implements Serializable {

    public StoreBeauticianByIdBatchVo() {

    }

    public StoreBeauticianByIdBatchVo(List<Integer> beauticianIdList) {
        this.beauticianIdList = beauticianIdList;
    }

    @ApiModelProperty(value = "美容师ID集合")
    private List<Integer> beauticianIdList;

}
