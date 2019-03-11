package com.union.aimei.common.vo.system.app;

import com.union.aimei.common.model.system.BaseDicGroup;
import com.union.aimei.common.model.system.BaseDicGroupItem;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 数据字典详情结果
 *
 * @author liurenkai
 * @time 2018/6/20 17:05
 */
@Data
@EqualsAndHashCode
@ApiModel("数据字典详情结果")
public class BaseDicGroupDeatilResVo implements Serializable {

    @ApiModelProperty("数据字典")
    private BaseDicGroup dicGroup;

    @ApiModelProperty("数据字典子项集合")
    private List<BaseDicGroupItem> itemList;

}
