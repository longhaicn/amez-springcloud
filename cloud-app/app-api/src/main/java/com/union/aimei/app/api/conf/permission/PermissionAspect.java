package com.union.aimei.app.api.conf.permission;

import com.union.aimei.common.constant.auth.AuthCode;
import com.union.aimei.common.constant.common.CommonConstant;
import com.union.common.utils.exception.ServerException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @author gaowei
 */
@Aspect
@Component
public class PermissionAspect {

    @Resource
    private PermissionSwithchProperties permissionSwithchProperties;

    @Resource
    private HttpServletRequest httpServletRequest;

    @Pointcut("@annotation(com.union.aimei.app.api.conf.permission.Permission)")
    public  void annotationPointCut() {
    }

    @Before("annotationPointCut()")
    public void before(JoinPoint joinPoint){
        boolean switchManger=permissionSwithchProperties.isEnabled();
        if(switchManger){
            String subject=httpServletRequest.getHeader("identityType");
            if(CommonConstant.Common.IdentityType.VISITOR.equals(subject)){
                MethodSignature sign =  (MethodSignature)joinPoint.getSignature();
                Method method = sign.getMethod();
                Permission annotation = method.getAnnotation(Permission.class);
                boolean isTrue=annotation.visitorAccess();
                if(!isTrue){
                    throw new ServerException(AuthCode.NOT_MEMBER.getCode(),AuthCode.NOT_MEMBER.getMessage());
                }
            }else if(CommonConstant.Common.IdentityType.MEMBER.equals(subject)){
                return;
            }else{
                throw new ServerException(500,"未知身份请求");
            }
        }
    }

}
