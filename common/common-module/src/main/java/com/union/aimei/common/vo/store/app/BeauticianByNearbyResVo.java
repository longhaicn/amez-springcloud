package com.union.aimei.common.vo.store.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 查询附近的美容师结果
 *
 * @author liurenkai
 * @time 2018/5/25 14:01
 */
@Data
@EqualsAndHashCode
@ApiModel("查询附近的美容师结果")
public class BeauticianByNearbyResVo implements Serializable {

    @ApiModelProperty("美容师ID")
    private Integer beauticianId;

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

    @ApiModelProperty("服务半径")
    private Integer serviceRadius;

    @ApiModelProperty("距离，M/米为单位（非数据库字段）")
    private Long distance;

    @ApiModelProperty("服务日期")
    private String serviceDate;

    @ApiModelProperty("服务时间")
    private String serviceTime;

}
