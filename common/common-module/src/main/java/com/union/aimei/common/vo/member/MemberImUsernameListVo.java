package com.union.aimei.common.vo.member;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author GaoWei
 * @describe
 * @time 2018/1/15,17:03
*/
@Data
@EqualsAndHashCode
@ApiModel(value = "会员ImUsernameListVO")
public class MemberImUsernameListVo {

    @ApiModelProperty(value = "ImUsernameList集合")
    private List<String> imUsernameList;

}
