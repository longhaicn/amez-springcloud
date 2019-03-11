package com.union.aimei.common.vo.store.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 美容师成长值排行榜结果
 *
 * @author liurenkai
 * @time 2018/6/4 14:02
 */
@Data
@EqualsAndHashCode
@ApiModel("美容师成长值排行榜结果")
public class BeauticianByListGrowthValueRankingResVo implements Serializable {

    @ApiModelProperty("排名")
    private Integer ranking;

    @ApiModelProperty("美容师昵称")
    private String beauticianNickName;

    @ApiModelProperty("成长值")
    private Integer growthValue;

    @ApiModelProperty("是否自己，true-是，false-不是")
    private Boolean isOneself;

}
