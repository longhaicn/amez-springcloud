package com.union.aimei.common.vo.system.app;

import com.union.aimei.common.model.system.BaseHomeArea;
import com.union.aimei.common.model.system.BaseHomeTemplate;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 保存装修模版的基本数据vo
 *
 * @author caizhaoming
 * @create 2018-05-23 17:24
 **/
@Data
@EqualsAndHashCode
@ApiModel(value = "保存装修模版的基本数据vo")
public class InsertBaseHomeTemplateVo {

    @ApiModelProperty("首页区域表")
    private BaseHomeArea baseHomeArea;

    @ApiModelProperty("首页模板")
    private List<BaseHomeTemplate> baseHomeTemplateList;


}
