package com.union.aimei.common.vo.store.pc;

import com.union.aimei.common.model.store.StoreBeauticianLevel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 批量美容师等级
 *
 * @author liurenkai
 * @time 2018/3/5 20:14
 */
@Data
@EqualsAndHashCode
@ApiModel("批量美容师等级")
public class StoreBeauticianLevelByBatchVo implements Serializable {

    @ApiModelProperty("美容师等级集合")
    private List<StoreBeauticianLevel> storeBeauticianLevelList;

}
