package com.union.aimei.common.vo.store.pc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 批量明星美容师
 *
 * @author liurenkai
 * @time 2018/4/19 14:17
 */
@Data
@EqualsAndHashCode
@ApiModel("批量明星美容师")
public class BeauticianByStarBatchVo implements Serializable {

    @ApiModelProperty("城市ID")
    private Integer cityId;

    @ApiModelProperty("美容师集合")
    private List<BeauticianByStarVo> beauticianList;

}
