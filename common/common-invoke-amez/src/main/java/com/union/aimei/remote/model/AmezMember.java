package com.union.aimei.remote.model;


import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author GaoWei
 * @describe 艾美会员VO
 * @time 2018/4/11,18:21
*/
@Data
@NoArgsConstructor
@ApiModel(value = "艾美会员")
public class AmezMember {

    private Integer appSystem;
    private String avatarUrl;
    private String birthDay;
    private Integer certification;
    private String createTime;
    private String deadlineTime;
    private String email;
    private String grade;
    private Integer id;
    private Integer loginNum;
    private String mobile;
    private String nickName;
    private String openId;
    private Integer pid;
    private Integer prerogative;
    private String qrcodeAddressUrl;
    private String realName;
    private String registerIp;
    private String registerTime;
    private String sex;
    private Integer status;
    private Integer subCompany;
    private String updateTime;
    private Integer updater;
    private String userName;
    private String uuid;
}
