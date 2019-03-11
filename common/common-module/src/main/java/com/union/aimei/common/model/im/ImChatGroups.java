package com.union.aimei.common.model.im;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * IM群组
 *
 * @author liurenkai
 * @time 2017/11/30 11:01
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "IM群组")
public class ImChatGroups implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("主键ID")
    private Integer id;
    @ApiModelProperty("环信群组ID")
    private String easemobGroupId;
    @ApiModelProperty("群组名称")
    private String name;
    @ApiModelProperty("群组描述")
    private String description;
    @ApiModelProperty("群组类型：true：公开群，false：私有群")
    private String isPublic;
    @ApiModelProperty("加入群组是否需要群主或者群管理员审批。true：是，false：否")
    private String membersonly;
    @ApiModelProperty("是否允许群成员邀请别人加入此群。 true：允许群成员邀请人加入此群，false：只有群主才可以往群里加人")
    private String allowinvites;
    @ApiModelProperty("群成员上限，创建群组的时候设置，可修改")
    private Integer maxusers;
    @ApiModelProperty("现有成员总数")
    private Integer affiliationsCount;
    @ApiModelProperty("群主的环信 ID")
    private String owner;
    @ApiModelProperty("邀请加群，被邀请人是否需要确认。如果是true，表示邀请加群需要被邀请人确认；如果是false，表示不需要被邀请人确认，直接将被邀请人加入群。 该字段的默认值为true。")
    private String inviteNeedConfirm;
}