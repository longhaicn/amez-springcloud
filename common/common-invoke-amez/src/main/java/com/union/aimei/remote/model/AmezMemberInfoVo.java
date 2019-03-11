package com.union.aimei.remote.model;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author GaoWei
 * @describe 艾美一族会员信息
 * @time 2018/4/12,9:26
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "艾美一族会员扩展信息")
public class AmezMemberInfoVo {

    private  Boolean hasPassword;
    private Boolean hasPayPassword;
    private AmezMember member;
    private List<MemberOneCardVo> memberOneCardVoList;
    private String token;
    private Double usableBalance;
}
