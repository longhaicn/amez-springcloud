package com.union.aimei.common.constant.system;


import com.union.aimei.common.model.system.BaseHomeTemplate;

/**
 * 店铺装修模版code常量
 *
 * @author caizhaoming
 * @create 2018-05-23 17:57
 **/
public enum BaseHomeTemplateCodeConstant {

    //首页轮播图
    INDEX_ONE(BaseHomeTemplate.INDEX_ONE, BaseHomeTemplate.TEMPLATE_TYPE_INDEX_ONE),
    //服务类型区
    CODE_XX(BaseHomeTemplate.CODE_XX, BaseHomeTemplate.TEMPLATE_TYPE_CODE_XX),
    //活动区
    ACTIVITY_ONE(BaseHomeTemplate.ACTIVITY_ONE, BaseHomeTemplate.TEMPLATE_TYPE_ACTIVITY_ONE),
    //底部导航区
    BOTTOM_NAVIGATION(BaseHomeTemplate.BOTTOM_NAVIGATION, BaseHomeTemplate.TEMPLATE_TYPE_BOTTOM_NAVIGATION),
    //导航按钮
    BOTTOM_NAVIGATION_BUTTONS(BaseHomeTemplate.BOTTOM_NAVIGATION_BUTTONS, BaseHomeTemplate.TEMPLATE_TYPE_BOTTOM_NAVIGATION_BUTTONS),
    //广告图
    FIGURE_BUTTONS(BaseHomeTemplate.ADVERTISING_FIGURE_BUTTONS, BaseHomeTemplate.TEMPLATE_TYPE_BOTTOM_ADVERTISING_FIGURE),
    //新人福利
    NEW_WELFARE(BaseHomeTemplate.NEW_WELFARE, BaseHomeTemplate.TEMPLATE_TYPE_BOTTOM_NEW_WELFARE);

    private String name;
    private String index;

    public static String getName(String index) {
        for (BaseHomeTemplateCodeConstant c : BaseHomeTemplateCodeConstant.values()) {
            if (c.getIndex().equals(index)) {
                return c.name;
            }
        }
        return "";
    }

    BaseHomeTemplateCodeConstant(String name, String index) {
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

