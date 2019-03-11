package com.union.aimei.common.vo.store.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 根据门店ID查询活动美容师结果
 *
 * @author liurenkai
 * @time 2018/6/7 16:21
 */
@Data
@EqualsAndHashCode
@ApiModel("根据门店ID查询活动美容师结果")
public class BeauticianByStoreIdForActivityResVo implements Serializable {

    @ApiModelProperty("美容师ID")
    private Integer beauticianId;

    @ApiModelProperty("美容师昵称")
    private String beauticianNickName;

    @ApiModelProperty("手机号码")
    private String phone;

    @ApiModelProperty("员工类型，0-老板，1-店长，2-全职员工，3-兼职员工，4-朋友")
    private Integer beauticianType;

}
