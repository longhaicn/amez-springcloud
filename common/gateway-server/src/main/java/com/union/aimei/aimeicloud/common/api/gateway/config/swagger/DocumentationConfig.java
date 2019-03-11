package com.union.aimei.aimeicloud.common.api.gateway.config.swagger;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * @author GaoWei
 * @describe
 * @time 2018/1/2,14:57
*/
@Component
@Primary
public class DocumentationConfig implements SwaggerResourcesProvider {
    @Override
    public List<SwaggerResource> get() {
        List resources = new ArrayList<>(10);
        resources.add(swaggerResource("美容邦APP-token", "/auth/v2/api-docs?group=token", "2.0"));
        resources.add(swaggerResource("美容邦APP-会员", "/app/v2/api-docs?group=会员", "2.0"));
        resources.add(swaggerResource("美容邦APP-商品", "/app/v2/api-docs?group=商品", "2.0"));
        resources.add(swaggerResource("美容邦APP-支付", "/app/v2/api-docs?group=支付", "2.0"));
        resources.add(swaggerResource("美容邦APP-订单", "/app/v2/api-docs?group=订单", "2.0"));
        resources.add(swaggerResource("美容邦APP-门店", "/app/v2/api-docs?group=门店", "2.0"));
        resources.add(swaggerResource("美容邦APP-资产", "/app/v2/api-docs?group=资产", "2.0"));
        resources.add(swaggerResource("美容邦APP-系统管理", "/app/v2/api-docs?group=系统管理", "2.0"));
        resources.add(swaggerResource("美容邦APP-友盟推送", "/app/v2/api-docs?group=友盟推送", "2.0"));
        resources.add(swaggerResource("美容邦APP-IM", "/app/v2/api-docs?group=IM", "2.0"));
        resources.add(swaggerResource("美容邦APP-学习","/app/v2/api-docs?group=学习","2.0"));
        resources.add(swaggerResource("美容邦PC-系统管理", "/pc/v2/api-docs?group=系统管理", "2.0"));
        resources.add(swaggerResource("美容邦PC-商品服务", "/pc/v2/api-docs?group=商品服务管理", "2.0"));
        resources.add(swaggerResource("美容邦PC-店铺服务", "/pc/v2/api-docs?group=店铺服务管理", "2.0"));
        resources.add(swaggerResource("美容邦PC-订单服务", "/pc/v2/api-docs?group=订单管理", "2.0"));
        resources.add(swaggerResource("美容邦PC-会员服务", "/pc/v2/api-docs?group=会员管理", "2.0"));
        resources.add(swaggerResource("美容邦PC-IM", "/pc/v2/api-docs?group=IM", "2.0"));
        resources.add(swaggerResource("美容邦PC-财务", "/pc/v2/api-docs?group=财务", "2.0"));
        resources.add(swaggerResource("美容邦PC-定时器", "/pc/v2/api-docs?group=定时器", "2.0"));
        resources.add(swaggerResource("美容邦PC-学习", "/pc/v2/api-docs?group=学习", "2.0"));
        resources.add(swaggerResource("美容邦PC-友盟推送", "/pc/v2/api-docs?group=友盟推送", "2.0"));
        return resources;
    }

    private SwaggerResource swaggerResource(String name, String location, String version) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion(version);
        return swaggerResource;
    }

}
