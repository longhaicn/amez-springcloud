package com.union.aimei.common.vo.learn.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author houji
 * @date 2018/5/24  17:01
 */
@Data
@EqualsAndHashCode
@ApiModel("报名人信息")
public class SignUpUserVo implements Serializable {

    @ApiModelProperty("会员id")
    private Integer memberId;

    @ApiModelProperty("美容师id")
    private Integer beauticianId;

    @ApiModelProperty("用户名字")
    private String name;

    @ApiModelProperty("用户手机号")
    private String phone;

    @ApiModelProperty("参加人标签(0-老板，1-店长，2-正式员工，3-兼职员工，4-朋友)")
    private Integer tag;

    @ApiModelProperty("联系人手机")
    private String contactPhone;

    @ApiModelProperty("报名的门店")
    private Integer storeId;

    @ApiModelProperty("门店名称")
    private String storeName;

    @ApiModelProperty("性别(0--女 1--男)")
    private Boolean sex;

    public interface Tag {
        Integer BOSS = 0;
        Integer STORE = 1;
        Integer REG_PEO = 2;
        Integer PART_PEO = 3;
        Integer FRIEND = 4;
    }

}
