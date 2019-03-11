package com.union.aimei.common.vo.learn.pc;

import com.union.aimei.common.model.learn.LearnCondition;
import com.union.aimei.common.model.store.Store;
import com.union.aimei.common.model.store.StoreBeautician;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 校验是否具备报名资格
 *
 * @author caizhaoming
 * @create 2018-05-21 10:49
 **/
@Data
@EqualsAndHashCode
@ApiModel("校验是否具备报名资格")
public class CheckConditionVo implements Serializable {

    @ApiModelProperty("门槛集合")
    private List<LearnCondition> learnConditionList;

    @ApiModelProperty("美容师数据")
    private StoreBeautician storeBeautician;

    @ApiModelProperty("店铺数据")
    private Store store;

}
