package com.union.aimei.common.vo.store.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 上架项目选择美容师列表结果
 *
 * @author liurenkai
 * @time 2018/6/22 17:11
 */
@Data
@EqualsAndHashCode
@ApiModel("上架项目选择美容师列表结果")
public class BeauticianListSelectOnSaleProductResVo implements Serializable {

    @ApiModelProperty("美容师ID")
    private Integer beauticianId;

    @ApiModelProperty("昵称")
    private String beauticianNickName;

    @ApiModelProperty("员工类型，0-老板，1-店长，2-全职员工，3-兼职员工")
    private Integer beauticianType;

    @ApiModelProperty("工牌号")
    private String workCardNo;

    @ApiModelProperty("头像")
    private String headImgUrl;

    @ApiModelProperty("从业年限")
    private Integer years;

    @ApiModelProperty("美容师等级名称")
    private String gradeName;

    @ApiModelProperty("是否选择，1-是，0-否")
    private Boolean isSelect;

}
