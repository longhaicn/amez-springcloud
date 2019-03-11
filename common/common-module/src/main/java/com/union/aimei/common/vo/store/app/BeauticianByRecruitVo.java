package com.union.aimei.common.vo.store.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 分页查询招募项目的美容师条件
 *
 * @author liurenkai
 * @time 2018/5/22 15:46
 */
@Data
@EqualsAndHashCode
@ApiModel("分页查询招募项目的美容师条件")
public class BeauticianByRecruitVo implements Serializable {

    @ApiModelProperty("门店ID")
    private Integer storeId;

    @ApiModelProperty("项目ID")
    private Integer productId;

    @ApiModelProperty("审核状态集合，0-待审核，1-审核通过，2-审核不通过")
    private List<Integer> auditStatusList;

}
