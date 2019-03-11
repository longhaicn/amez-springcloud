package com.union.aimei.common.vo.store.pc;

import com.union.aimei.common.model.store.StoreLevel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 批量店铺等级
 *
 * @author liurenkai
 * @time 2018/3/5 19:35
 */
@Data
@EqualsAndHashCode
@ApiModel("批量店铺等级")
public class StoreLevelByBatchVo implements Serializable {

    @ApiModelProperty("店铺等级集合")
    private List<StoreLevel> storeLevelList;

}
