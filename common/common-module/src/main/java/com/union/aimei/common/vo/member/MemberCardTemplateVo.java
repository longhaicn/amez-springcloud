package com.union.aimei.common.vo.member;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author houji
 * @date 2018/3/7  15:49
 */
@Data
@EqualsAndHashCode
@ApiModel(value="会员卡卡面模板批量添加表")
public class MemberCardTemplateVo implements Serializable {
    @ApiModelProperty("主键自增")
    private Integer id;

    @ApiModelProperty("卡面模板分类父类id")
    private Integer parentGroupId;

    @ApiModelProperty("卡面模板分类父类名称")
    private String parentGroupName;

    @ApiModelProperty("卡面模板父类图片数量")
    private Integer parentGroupCount;

    @ApiModelProperty("卡面模板背景图片")
    private String bgImgUrl;

    @ApiModelProperty("软删除 0--正常 1--删除")
    private String isEnabled;

    @ApiModelProperty("批量添加会员卡面模板集合")
    private List<String> bgImgList;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;


}
