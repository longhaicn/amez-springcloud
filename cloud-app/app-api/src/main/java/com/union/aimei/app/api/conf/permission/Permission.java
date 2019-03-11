package com.union.aimei.app.api.conf.permission;

import java.lang.annotation.*;

/**
  * @auto GaoWei
  * @Date 18-7-26 上午10:36
  * @description  判断是否有访问API权限注解
  */

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Permission {

    /**
     * 游客是否有访问权限，默认不允许
     * @return
     */
    boolean visitorAccess() default false ;
}
