package com.union.aimei.common.constant.auth;


/**
  * @author GaoWei
  * @Date 18-7-26 上午10:54
  * @description 权限相关Code及说明
  */
public enum  AuthCode {

    /**
     *令牌相关
     */
    ACCESS_TOKEN_LOST(501,"权限令牌不能为空"),
    ACCESS_TOKEN_EXPIRED(502,"权限令牌过期,通过刷新令牌获取到新的权限令牌"),
    REFRESH_TOKEN_EXPIRED(503,"刷新令牌过期,请重新登录"),

    /**
     * 会员相关
     */
    NOT_MEMBER(504,"不是会员,请先登录")
    ;
    private int code;
    private String message;

    AuthCode(int code,String message){
        this.code=code;
        this.message=message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
