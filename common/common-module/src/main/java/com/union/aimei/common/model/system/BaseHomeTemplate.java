package com.union.aimei.common.model.system;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 首页模板
 *
 * @author liurenkai
 * @time 2017/12/27 10:45
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "首页模板")
public class BaseHomeTemplate implements Serializable {

    @ApiModelProperty("首页模板ID")
    private Integer id;

    @ApiModelProperty("区域id")
    private Integer areaId;

    @ApiModelProperty("模板代码 首页轮播图：INDEX_ONE、 服务类型区：CODE_XX 、  活动区 ACTIVITY_ONE、  底部导航区 BOTTOM_NAVIGATION、 导航按钮 NAVIGATION_BUTTONS：INDEX_ONE、 服务类型区：CODE_XX 、  活动区 ACTIVITY_ONE、  底部导航区 BOTTOM_NAVIGATION、 广告图 ADVERTISING_FIGURE 、新人福利 NEW_WELFARE")
    private String templateCode;

    @ApiModelProperty("使用类型 0-用户端，1-帮女郎，2-门店端")
    private Integer useType;

    @ApiModelProperty("是否展示 0-全部展示 1-全部不展示 2-展示上半部分 3-展示下半部分")
    private Integer showType;

    @ApiModelProperty("模板名称")
    private String templateName;

    @ApiModelProperty("模板类型，1-顶部轮播区，2-服务类型区，3-活动区，4-商品区，5-底部导航区，6-导航按钮型区，4-商品区，5-底部导航区 ，6-导航按钮 ， 7-广告图 ，8-新人福利")
    private String templateType;

    @ApiModelProperty("模板内容")
    private String templateContent;

    @ApiModelProperty("排序")
    private Integer sort;

    @ApiModelProperty("软删除标记，1为正常，0为删除")
    private Boolean isEnabled;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    /**
     * 是否删除 true-否
     */
    public static final Boolean IS_ENABLED_TURE = true;
    /**
     * 是否删除 false-是
     */
    public static final Boolean IS_ENABLED_FALSE = false;

    /**
     * 模板类型，1-顶部轮播区
     */
    public static final String TEMPLATE_TYPE_INDEX_ONE = "1";
    /**
     * 模板类型，2-服务类型区
     */
    public static final String TEMPLATE_TYPE_CODE_XX = "2";
    /**
     * 模板类型，3-活动区
     */
    public static final String TEMPLATE_TYPE_ACTIVITY_ONE = "3";
    /**
     * 模板类型，4-商品区
     */
    public static final String TEMPLATE_TYPE_PRODUCT = "4";
    /**
     * 模板类型，5-底部导航区
     */
    public static final String TEMPLATE_TYPE_BOTTOM_NAVIGATION = "5";
    /**
     * 模板类型，6-导航按钮
     */
    public static final String TEMPLATE_TYPE_BOTTOM_NAVIGATION_BUTTONS = "6";
     /**
     * 模板类型，7-广告图
     */
    public static final String TEMPLATE_TYPE_BOTTOM_ADVERTISING_FIGURE = "7";
    /**
     * 模板类型，8-新人福利
     */
    public static final String TEMPLATE_TYPE_BOTTOM_NEW_WELFARE = "8";



    /**
     * 模板类型，顶部轮播区
     */
    public static final String INDEX_ONE = "INDEX_ONE";
    /**
     * 模板类型，服务类型区
     */
    public static final String CODE_XX = "CODE_XX";
    /**
     * 模板类型，活动区
     */
    public static final String ACTIVITY_ONE = "ACTIVITY_ONE";
    /**
     * 模板类型，底部导航区
     */
    public static final String BOTTOM_NAVIGATION = "BOTTOM_NAVIGATION";
    /**
     * 模板类型，导航按钮
     */
    public static final String BOTTOM_NAVIGATION_BUTTONS = "NAVIGATION_BUTTONS";
    /**
     * 模板类型，广告图
     */
    public static final String ADVERTISING_FIGURE_BUTTONS = "ADVERTISING_FIGURE";
    /**
     * 模板类型，新人福利
     */
    public static final String NEW_WELFARE = "NEW_WELFARE";


    /**
     * 模板类型，顶部轮播区
     */
    public static final String NAME_INDEX_ONE = "顶部轮播区";
    /**
     * 模板类型，服务类型区
     */
    public static final String NAME_CODE_XX = "服务类型区";
    /**
     * 模板类型，活动区
     */
    public static final String NAME_ACTIVITY_ONE = "活动区";
    /**
     * 模板类型，底部导航区
     */
    public static final String NAME_BOTTOM_NAVIGATION = "底部导航区";
    /**
     * 模板类型，导航按钮
     */
    public static final String NAME_BOTTOM_NAVIGATION_BUTTONS = "导航按钮";
    /**
     * 模板类型，广告图
     */
    public static final String NAME_ADVERTISING_FIGURE_BUTTONS = "广告图";
    /**
     * 模板类型，新人福利
     */
    public static final String NAME_NEW_WELFARE = "新人福利";


    private static final long serialVersionUID = 1L;
}