package com.union.aimei.common.constant.common;

/**
 * @author GaoWei
 * @Date 18-8-13 上午10:39
 * @description hTTP请求状态
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
public enum HttpStatusConstant {

    /**
     * 请求状态正常
     */
    OK(200, "请求状态正常"),
    /**
     * 后台错误
     */
    ERROR(500, "后台错误");

    HttpStatusConstant(int status, String des) {
        this.status = status;
        this.des = des;
    }

    /**
     * 状态
     */
    private int status;
    /**
     * 说明
     */
    private String des;

    public int getStatus() {
        return status;
    }

    public String getDes() {
        return des;
    }
}
