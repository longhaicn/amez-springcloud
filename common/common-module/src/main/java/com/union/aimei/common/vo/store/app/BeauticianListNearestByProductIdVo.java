package com.union.aimei.common.vo.store.app;

import com.union.aimei.common.vo.common.MapPointVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 根据项目ID查询最近时间，星级最高的美容师列表条件
 *
 * @author liurenkai
 * @time 2018/5/29 11:02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("根据项目ID查询最近时间，星级最高的美容师列表条件")
public class BeauticianListNearestByProductIdVo extends MapPointVo {

    @ApiModelProperty("项目ID")
    private Integer productId;

    @ApiModelProperty("门店ID")
    private Integer storeId;

}
