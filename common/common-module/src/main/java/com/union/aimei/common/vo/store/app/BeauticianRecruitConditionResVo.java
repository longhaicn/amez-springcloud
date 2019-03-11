package com.union.aimei.common.vo.store.app;

import com.union.aimei.common.vo.common.ConditionResVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 招募美容师筛选条件结果
 *
 * @author liurenkai
 * @time 2018/6/20 19:26
 */
@Data
@EqualsAndHashCode
@ApiModel("招募美容师筛选条件结果")
public class BeauticianRecruitConditionResVo implements Serializable {

    @ApiModelProperty("标签")
    private List<ConditionResVo> labelList;

    @ApiModelProperty("位置区域")
    private List<ConditionResVo> areaList;

    @ApiModelProperty("美容师星级")
    private List<ConditionResVo> beauticianStarList;

}
