package com.union.aimei.common.vo.store.app;

import com.union.aimei.common.model.store.StoreLevel;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 门店级别
 *
 * @author liurenkai
 * @time 2017/12/27 14:30
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "门店级别")
public class StoreLevelVo implements Serializable {

    /**
     * 门店级别集合
     */
    private List<StoreLevel> storeLevelList;

}
