package com.union.aimei.common.vo.store.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 美容师展示列表结果
 *
 * @author liurenkai
 * @time 2018/6/12 17:17
 */
@Data
@EqualsAndHashCode
@ApiModel("美容师展示列表结果")
public class BeauticianListDisplayResVo implements Serializable {

    @ApiModelProperty("美容师ID")
    private Integer beauticianId;

    @ApiModelProperty("门店ID")
    private Integer storeId;

    @ApiModelProperty("昵称")
    private String beauticianNickName;

    @ApiModelProperty("员工类型，0-老板，1-店长，2-全职员工，3-兼职员工")
    private Integer beauticianType;

    @ApiModelProperty("头像")
    private String headImgUrl;

    @ApiModelProperty("美容师星级，范围为0-100")
    private Integer beauticianStar;

    @ApiModelProperty("满意度，范围为0-100")
    private Integer satisfaction;

    @ApiModelProperty("标签")
    private String label;

}
