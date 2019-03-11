package com.union.aimei.common.vo.im.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * IM消息（最近联系人列表）
 *
 * @author liurenkai
 * @time 2018/1/16 14:32
 */
@Data
@EqualsAndHashCode
@ApiModel("IM消息（最近联系人列表）")
public class ImMessagesRecentContactlistVo implements Serializable {

    @ApiModelProperty("用户名集合")
    private List<String> userNameList;
}
