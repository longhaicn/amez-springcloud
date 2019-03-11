package com.union.aimei.common.model.umeng;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 友盟推送消息模板(新)
 *
 * @author houji
 * @time 2018/8/24 10:01
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "友盟推送消息模板(新)")
public class BasePushTemplate implements Serializable {
    @ApiModelProperty("主键自增")
    private Integer id;

    @ApiModelProperty("0--服务消息 1--项目消息  2--系统消息")
    private Integer templateType;

    @ApiModelProperty("模板名称")
    private String templateName;

    @ApiModelProperty("模板code")
    private String templateCode;

    @ApiModelProperty("模板内容")
    private String templateContent;

    @ApiModelProperty("模板描述")
    private String templateDescription;

    @ApiModelProperty("推送对象(0--用户 1--美容师 2--店长)")
    private Integer pushObject;

    @ApiModelProperty("推送对象的会员id")
    private Integer memberId;

    @ApiModelProperty("推送标题")
    private String pushTitle;


    @ApiModelProperty("跳转类型(系统消息招募挂靠跳转参数)")
    private Integer target;

    @ApiModelProperty("参数(系统消息招募挂靠内容参数)")
    private String param;

    @ApiModelProperty("推送自定义内容")
    private String pushCostom;

    @ApiModelProperty("是否删除(0--正常 1--删除)")
    private Byte status;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("修改时间")
    private Date updateTime;

    public interface TemplateType {
        Integer SERVICE = 0;
        Integer PROJECT = 1;
        Integer SYSTEM = 2;
    }

    /**
     * 推送对象
     */
    public interface PushObject {
        Integer USER = 0;
        Integer BEAUTICIAN = 1;
        Integer OWNER = 2;
    }

    private static final long serialVersionUID = 1L;
}