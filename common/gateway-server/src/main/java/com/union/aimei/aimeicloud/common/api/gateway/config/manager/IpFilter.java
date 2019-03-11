package com.union.aimei.aimeicloud.common.api.gateway.config.manager;


import com.netflix.zuul.ZuulFilter;

/**
 * @author liufeihua
 */
public class IpFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return null;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return false;
    }

    @Override
    public Object run() {
        return null;
    }
}
