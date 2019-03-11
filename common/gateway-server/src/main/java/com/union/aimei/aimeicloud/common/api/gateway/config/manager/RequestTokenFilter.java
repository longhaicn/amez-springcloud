package com.union.aimei.aimeicloud.common.api.gateway.config.manager;

import com.google.gson.Gson;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.union.aimei.aimeicloud.common.api.gateway.feign.CommonAuthFeign;
import com.union.common.utils.ResponseMessage;
import lombok.extern.apachecommons.CommonsLog;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liufeihua
 */
@Component
@CommonsLog
public class RequestTokenFilter extends ZuulFilter {


    @Resource
    private ManagerProperties managerProperties;
    @Resource
    private CommonAuthFeign commonAuthFeign;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return managerProperties.isEnabled();
    }

    /**
     * 1:判断是否请求token的请求，如果是则直接放行，允许路由
     * 2:判断请求API,校验Token是否为空
     * @return
     */
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        //获取请求URI
        String uri=request.getRequestURI();
        System.out.println("请求资源："+uri);
        boolean isTrue=uri.contains("/auth")||uri.contains("/v2/api-docs");
        System.out.println("判断是否通过"+isTrue);
        if(isTrue){
            success(ctx);
        }else{
            //从请求头中获取access_token以及refresh_token
            String identityType=request.getHeader("identityType");
            String accessToken = request.getHeader("accessToken");
            String refreshToken=request.getHeader("refreshToken");
            if (StringUtils.isNotBlank(accessToken)) {
                Map<String,String> map=new HashMap<>(3);
                map.put("identityType",identityType);
                map.put("accessToken",accessToken);
                map.put("refreshToken",refreshToken);
                System.out.println("校验参数："+map.toString());
                //校验token正确性
                ResponseMessage res=commonAuthFeign.verifyToken(map);
                System.out.println("校验结果："+res.toString());
                int i = 200;
                if(i ==res.getCode()){
                    success(ctx);
                }else{
                    fail(ctx,res);
                }
            } else{
                fail(ctx,new ResponseMessage(500,"令牌不能为空"));
            }
        }
        return null;
    }


    private void success(RequestContext ctx){
        ctx.setSendZuulResponse(true);
        ctx.setResponseStatusCode(200);
        ctx.set("isSuccess", true);
    }

    private void fail(RequestContext ctx,ResponseMessage responseMessage){
        ctx.setSendZuulResponse(false);
        ctx.setResponseStatusCode(401);
        ctx.setResponseBody(new Gson().toJson(responseMessage));
        ctx.getResponse().setContentType("application/json; charset=utf-8");
        ctx.set("isSuccess", false);
    }
}
