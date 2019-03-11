package com.union.aimei.common.vo.learn.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author houji
 * @date 2018/5/23  17:35
 */
@Data
@EqualsAndHashCode
@ApiModel("门店或美容师报名活动数据vo")
public class ActivityMemberRefVo {

    @ApiModelProperty("活动id(必填)")
    private Integer activityId;

    @ApiModelProperty("活动报名美容师id集合(集合不能为null)")
    private List<Integer> beauticianIdList;

}
