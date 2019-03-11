package com.union.aimei.common.vo.store.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 根据门店ID查询挂靠邀请条件
 *
 * @author liurenkai
 * @time 2018/5/22 10:26
 */
@Data
@EqualsAndHashCode
@ApiModel("根据门店ID查询挂靠邀请条件")
public class AffiliatedByStoreIdVo implements Serializable {

    @ApiModelProperty("门店ID")
    private Integer storeId;

    @ApiModelProperty("挂靠类型，1-申请，2-解除")
    private Integer affiliatedType;

    @ApiModelProperty("发起方，1-美容师，2-店铺，3-平台")
    private Integer sponsor;

    @ApiModelProperty("美容师类型，0-老板，1-店长，2-正式美容师，3-兼职美容师")
    private Integer beauticianType;

    @ApiModelProperty("审核状态集合，0-待审核，1-当前门店同意，2-挂靠门店同意，3-平台同意")
    private List<Integer> auditStatusList;

}
