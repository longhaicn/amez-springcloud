package com.union.aimei.common.model.umeng;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author houji
 * @date 2018/8/20  10:20
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "U盟第三方推送模板表")
public class BaseUmengPushTemplate implements Serializable {

    @ApiModelProperty("主键自增")
    private Integer id;

    @ApiModelProperty("推送类型(0--服务通知  1--招募通知 2--活动通知),必填")
    private Integer sendType;

    @ApiModelProperty("接收消息者(1--店长 2-- 用户 3--美容师)，必填")
    private Integer receiverType;

    @ApiModelProperty("会员手机类型 1--android手机 2--ios手机")
    private Integer deviceType;

    @ApiModelProperty("必填，通知栏通知信息")
    private String pushTicker;

    @ApiModelProperty("必填，通知标题")
    private String pushTitle;

    @ApiModelProperty("必填，通知内容")
    private String pushText;

    @ApiModelProperty("自定义的内容")
    private String custom;

    @ApiModelProperty("跳转类型(0---app原生  1---html5)")
    private String forwardType;

    @ApiModelProperty("跳转页面url")
    private String forwardUrl;

    @ApiModelProperty("会员id")
    private Integer memberId;

    @ApiModelProperty("会员id集合(批量同一类型用户推送所用)")
    private List<Integer> memberIdList;

    @ApiModelProperty("推送手机得device_token")
    private String deviceToken;

    @ApiModelProperty("推送时间。(如果是定时，填写需要推送得时间)格式 yyyy-MM-dd HH:mm:ss")
    private String pushTime;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public interface DeviceType {
        Integer ANDROID = 1;
        Integer IOS = 2;
    }

    public interface ReceiverType {
        int OWNER = 1;
        int USER = 2;
        int BEAUTICIAN = 3;
    }

    /**
     * 推送类型(0--服务通知  1--招募通知 2--活动通知),必填
     */
    public interface SendType {
        int SERVICE = 0;
        int PROJECT = 1;
        int SYSTEM = 2;
    }
}