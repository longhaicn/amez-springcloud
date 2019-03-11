package com.union.aimei.common.vo.store.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 批量IM用户名
 *
 * @author liurenkai
 * @time 2018/3/20 11:33
 */
@Data
@EqualsAndHashCode
@ApiModel("批量IM用户名称")
public class StoreBeauticianByImUsernameBatchVo implements Serializable {

    @ApiModelProperty("IM用户名集合")
    private List<String> imUsernameList;
    
}
