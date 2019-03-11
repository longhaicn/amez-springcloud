package com.union.aimei.common.vo.product.app;

import com.union.aimei.common.vo.common.ConditionResVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 招募项目筛选条件结果
 *
 * @author liurenkai
 * @time 2018/6/6 22:52
 */
@Data
@EqualsAndHashCode
@ApiModel("招募项目筛选条件结果")
public class ProductRecruitConditionResVo implements Serializable {

    @ApiModelProperty("项目类型")
    private List<ConditionResVo> categoryList;

    @ApiModelProperty("位置区域")
    private List<ConditionResVo> areaList;

    @ApiModelProperty("分成比例")
    private List<ConditionResVo> commissionRatioList;

    @ApiModelProperty("价格范围")
    private List<ConditionResVo> priceRangeList;

}