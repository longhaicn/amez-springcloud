package com.union.aimei.pc.api.system;

import com.union.aimei.aop.logs.WebLog;
import com.union.aimei.common.feign.pc.system.WebLogFeign;
import io.swagger.annotations.ApiOperation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @author liufeihua
 */
@Aspect
@Component
public class WebLogAspectPcApi {

    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    WebLogFeign webLogFeign;

    @Pointcut("execution(public * com.union.aimei.pc.api.*.controller.*.*(..))")
    public void webLog() {
    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        WebLog log = new WebLog();
        log.setRequestURL(request.getRequestURL().toString());
        log.setRequestURI(request.getRequestURI());
        log.setQueryString(request.getQueryString());
        log.setRemoteAddr(request.getRemoteAddr());
        log.setRemoteHost(request.getRemoteHost());
        log.setRemotePort(request.getRemotePort() + "");
        log.setLocalAddr(request.getLocalAddr());
        log.setLocalName(request.getLocalName());
        log.setMethod(request.getMethod());
        log.setParameters(request.getParameterMap().toString());
        log.setHeaders(getHeadersInfo(request).toString());
        log.setClassMethod(joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        log.setArgs(Arrays.toString(joinPoint.getArgs()));

        log.setOperateId(request.getHeader("operateId"));
        log.setOperateUserName(request.getHeader("operateUserName"));
        log.setCreateTime(new Date());


        //
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method targetMethod = methodSignature.getMethod();

        Class clazz = targetMethod.getClass();
        if (targetMethod.isAnnotationPresent(ApiOperation.class)) {
            //获取方法上注解中表明的权限
            ApiOperation apiOperation = targetMethod.getAnnotation(ApiOperation.class);
            log.setOperateName(apiOperation.value());
        }

        String find = "find";
        String select = "select";
        String insertLogs = "insertLogs";
        String query = "query";
        if (targetMethod.getName().startsWith(find) || targetMethod.getName().startsWith(select) || insertLogs.equals(targetMethod.getName()) || targetMethod.getName().startsWith(query)) {

        } else {
            webLogFeign.insertLogs(log);
        }

    }

//    @AfterReturning(returning = "ret : "+ pointcut = "webLog()")
//    public void doAfterReturning(Object ret) throws Throwable {
//        // 处理完请求，返回内容
//        logger.info("RESPONSE : " + ret.toString());
//    }

    private Map<String, String> getHeadersInfo(HttpServletRequest request) {
        Map<String, String> map = new HashMap<>(64);
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            map.put(key, value);
        }
        return map;
    }
}

