package com.union.aimei.common.vo.store.pc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 解除挂靠列表条件
 *
 * @author liurenkai
 * @time 2018/6/5 18:06
 */
@Data
@EqualsAndHashCode
@ApiModel("解除挂靠列表条件")
public class AffiliatedListRemoveVo implements Serializable {

    @ApiModelProperty("输入条件（门店/美容师）")
    private String inputCondition;

    @ApiModelProperty("审核状态，0-待审核，1-审核通过，2-审核不通过，3-平台通过，4-平台不通过")
    private Integer auditStatus;

}
