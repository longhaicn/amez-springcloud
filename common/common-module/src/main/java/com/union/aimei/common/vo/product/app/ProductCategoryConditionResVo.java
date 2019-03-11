package com.union.aimei.common.vo.product.app;

import com.union.aimei.common.vo.common.ConditionResVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 项目分类筛选条件结果
 *
 * @author liurenkai
 * @time 2018/6/22 11:48
 */
@Data
@EqualsAndHashCode
@ApiModel("项目分类筛选条件结果")
public class ProductCategoryConditionResVo implements Serializable {

    @ApiModelProperty("门店连锁品牌")
    private List<ConditionResVo> brandIdList;

    @ApiModelProperty("服务时长")
    private List<ConditionResVo> serverNeedTimeList;

    @ApiModelProperty("功效")
    private List<ConditionResVo> serverEffectList;

}
