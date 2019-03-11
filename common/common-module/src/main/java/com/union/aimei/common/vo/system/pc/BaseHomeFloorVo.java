package com.union.aimei.common.vo.system.pc;


import com.union.aimei.common.model.system.BaseHomeArea;
import com.union.aimei.common.model.system.BaseHomeFloor;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 保存装修模版的楼层数据vo
 *
 * @author caizhaoming
 * @create 2018-05-23 17:24
 **/
@Data
@EqualsAndHashCode
@ApiModel(value = "保存装修模版的楼层数据vo")
public class BaseHomeFloorVo implements Serializable {

    @ApiModelProperty("首页区域表")
    private BaseHomeArea baseHomeArea;

    @ApiModelProperty("首页模板-楼层集合数据")
    private List<BaseHomeFloor> baseHomeFloorList;

}
