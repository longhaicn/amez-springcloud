package com.union.aimei.common.constant.system;


import com.union.aimei.common.model.system.BaseHomeTemplate;

/**
 * 店铺装修模版名字常量
 *
 * @author caizhaoming
 * @create 2018-05-23 17:57
 **/
public enum BaseHomeTemplateNameConstant {

    //首页轮播图
    INDEX_ONE(BaseHomeTemplate.NAME_INDEX_ONE, BaseHomeTemplate.TEMPLATE_TYPE_INDEX_ONE),
    //服务类型区
    CODE_XX(BaseHomeTemplate.NAME_CODE_XX, BaseHomeTemplate.TEMPLATE_TYPE_CODE_XX),
    //活动区
    ACTIVITY_ONE(BaseHomeTemplate.NAME_ACTIVITY_ONE, BaseHomeTemplate.TEMPLATE_TYPE_ACTIVITY_ONE),
    //底部导航区
    BOTTOM_NAVIGATION(BaseHomeTemplate.NAME_BOTTOM_NAVIGATION, BaseHomeTemplate.TEMPLATE_TYPE_BOTTOM_NAVIGATION),
    //导航按钮
    BOTTOM_NAVIGATION_BUTTONS(BaseHomeTemplate.NAME_BOTTOM_NAVIGATION_BUTTONS, BaseHomeTemplate.TEMPLATE_TYPE_BOTTOM_NAVIGATION_BUTTONS),
    //广告图
    FIGURE_BUTTONS(BaseHomeTemplate.NAME_ADVERTISING_FIGURE_BUTTONS, BaseHomeTemplate.TEMPLATE_TYPE_BOTTOM_ADVERTISING_FIGURE),
    //新人福利
    NEW_WELFARE(BaseHomeTemplate.NAME_NEW_WELFARE, BaseHomeTemplate.TEMPLATE_TYPE_BOTTOM_NEW_WELFARE);


    private String name;
    private String index;

    public static String getName(String index) {
        for (BaseHomeTemplateNameConstant c : BaseHomeTemplateNameConstant.values()) {
            if (c.getIndex().equals(index)) {
                return c.name;
            }
        }
        return "";
    }

    BaseHomeTemplateNameConstant(String name, String index) {
        this.name = name;
        this.index = index;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIndex() {
        return index;
    }

}

