package com.union.aimei.common.vo.member;

import com.union.aimei.common.model.member.MemberCard;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author GaoWei
 * @describe 编辑会员卡详情VO
 * @time 2018/2/2,19:23
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "修改会员卡信息VO")
public class EditMemberCardVo {

    @ApiModelProperty(value = "会员卡基本信息")
    private MemberCard memberCard;

    @ApiModelProperty("适用门店ID集合")
    private List<Integer> useAbleStoreList = new ArrayList<>(10);

    @ApiModelProperty("适用服务ID集合")
    private List<Integer> useAbleProductList = new ArrayList<>(10);


}
