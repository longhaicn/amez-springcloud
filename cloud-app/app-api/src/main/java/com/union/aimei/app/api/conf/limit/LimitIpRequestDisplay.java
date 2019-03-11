package com.union.aimei.app.api.conf.limit;

import com.union.aimei.common.constant.common.CommonConstant;
import com.union.common.utils.exception.ClientException;
import lombok.extern.apachecommons.CommonsLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * @author GaoWei
 * @time 2018/6/30
 * @description 限制提交订单频率
 */
@Aspect
@Component
@CommonsLog
public class LimitIpRequestDisplay {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Pointcut("execution(* com.union.aimei.app.api.order.*.*(..)) && @annotation(com.union.aimei.app.api.conf.limit.LimitIpRequest)")
    public void before() {
    }

    @Before("before()")
    public void requestLimit(JoinPoint joinPoint) throws ClientException {
        try {
            // 获取HttpRequest
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            HttpServletResponse response = attributes.getResponse();

            // 判断request不能为空
            if (request == null) {
                throw new ClientException(500, "HttpServletRequest有误...");
            }

            LimitIpRequest limit = this.getAnnotation(joinPoint);
            if (limit == null) {
                return;
            }

            String ip = getIpAddress(request);
            log.info("请求IP为:" + ip);
            String uri = request.getRequestURI();
            String redisKey = "limit-ip-request:" + uri + ":" + ip;
            Long count = stringRedisTemplate.opsForValue().increment(redisKey, 1L);
            // 设置在redis中的缓存，累加1
            log.info("当前请求redis数量为:" + count);
            // 如果该key不存在，则从0开始计算，并且当count为1的时候，设置过期时间
            if (count == 1) {
                stringRedisTemplate.expire(redisKey, limit.timeSecond(), TimeUnit.SECONDS);
            }
            // 如果redis中的count大于限制的次数，则报错
            if (count > limit.limitCounts()) {
                throw new ClientException(500, "操作太过频繁,请稍后再试");
            }
        } catch (ClientException e) {
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取请求主机IP地址,如果通过代理进来，则透过防火墙获取真实IP地址;
     *
     * @param request
     * @return
     * @throws IOException
     */
    public final static String getIpAddress(HttpServletRequest request) throws IOException {
        // 获取请求主机IP地址,如果通过代理进来，则透过防火墙获取真实IP地址

        String ip = request.getHeader("X-Forwarded-For");
        String unknown = "unknown";
        if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
            if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_CLIENT_IP");
            }
            if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            }
            if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
            }
        } else if (CommonConstant.Common.IP_LENGTH_LIMIT < ip.length()) {
            String[] ips = ip.split(",");
            for (int index = 0; index < ips.length; index++) {
                String strIp = ips[index];
                if (!(unknown.equalsIgnoreCase(strIp))) {
                    ip = strIp;
                    break;
                }
            }
        }
        return ip;
    }


    /**
     * @param joinPoint
     * @return
     * @throws Exception
     * @Description: 获得注解
     * @author
     */
    private LimitIpRequest getAnnotation(JoinPoint joinPoint) throws Exception {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();

        if (method != null) {
            return method.getAnnotation(LimitIpRequest.class);
        }
        return null;
    }
}
