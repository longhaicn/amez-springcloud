package com.union.aimei.common.vo.store.app;

import com.union.aimei.common.vo.common.MapPointVo;
import com.union.common.baidumap.util.BaiDuMapApi;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 美店列表条件
 *
 * @author liurenkai
 * @time 2018/6/22 9:57
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("美店列表条件")
public class StoreListIndexVo extends MapPointVo {

    @ApiModelProperty("区域ID")
    private Integer areaId;

    @ApiModelProperty("星级")
    private Integer storeLevel;

    @ApiModelProperty("品牌ID")
    private Integer brandId;

    @ApiModelProperty("经营年限")
    private String manageYear;

    @ApiModelProperty("特色项目")
    private String specialProject;

}
