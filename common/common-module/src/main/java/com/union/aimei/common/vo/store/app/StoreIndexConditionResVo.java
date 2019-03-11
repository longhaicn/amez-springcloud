package com.union.aimei.common.vo.store.app;

import com.union.aimei.common.vo.common.ConditionResVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 美店筛选条件结果
 *
 * @author liurenkai
 * @time 2018/1/15 17:00
 */
@Data
@EqualsAndHashCode
@ApiModel("美店筛选条件结果")
public class StoreIndexConditionResVo implements Serializable {

    @ApiModelProperty("区域")
    private List<ConditionResVo> areaIdList;

    @ApiModelProperty("星级")
    private List<ConditionResVo> storeLevelList;

    @ApiModelProperty("品牌")
    private List<ConditionResVo> brandIdList;

    @ApiModelProperty("经营年限")
    private List<ConditionResVo> manageYearList;

    @ApiModelProperty("特色项目")
    private List<ConditionResVo> specialProjectList;

}
