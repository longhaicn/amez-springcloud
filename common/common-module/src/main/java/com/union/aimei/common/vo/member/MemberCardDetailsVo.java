package com.union.aimei.common.vo.member;

import com.union.common.baidumap.util.BaiDuMapApi;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author houji
 * @date 2018/3/2  14:53
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "会员卡详情实体临时类")
public class MemberCardDetailsVo implements Serializable {

    @ApiModelProperty("会员卡id")
    private Integer id;

    @ApiModelProperty(value = "地图坐标")
    private BaiDuMapApi.Point point;

}
