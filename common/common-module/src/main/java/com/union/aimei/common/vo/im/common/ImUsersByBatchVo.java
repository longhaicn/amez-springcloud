package com.union.aimei.common.vo.im.common;

import com.union.aimei.common.model.im.ImUsers;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 批量IM用户
 *
 * @author liurenkai
 * @time 2018/3/26 20:31
 */
@Data
@EqualsAndHashCode
@ApiModel("批量IM用户")
public class ImUsersByBatchVo implements Serializable {

    @ApiModelProperty("IM用户集合")
    private List<ImUsers> imUsersList;

}
