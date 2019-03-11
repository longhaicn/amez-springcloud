package com.union.aimei.remote.config;




import com.union.common.utils.CollectionUtils;
import com.union.common.utils.exception.ServerException;
import lombok.Data;
import lombok.extern.apachecommons.CommonsLog;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.List;
import java.util.logging.Logger;


/**
 * @author GaoWei
 * @describe 获取艾美一族请求URL地址
 * @time 2018/4/11,11:59
*/
@Data
@Configuration
@EnableConfigurationProperties(value = AmezRequestProperties.class)
@CommonsLog
public class AmezRequestUrl {

    private static final String DEV="dev";
    private static final String TEST="test";
    private static final String IMG="imagek8s";
    private static final String FH="/";

    @Resource
    private AmezRequestProperties amezRequestProperties;
    @Value(value = "${spring.profiles.active}")
    private String active;

    /**
     * 获取请求URL地址
     * @param pathName
     * @param interfaceName
     * @param urlPath
     * @return
     */
    public String getRequestUrl(String pathName,String interfaceName,List<String> urlPath){
        StringBuilder sb=new StringBuilder();
        String host;
        String port;
        if(DEV.equals(active)||TEST.equals(active)||IMG.equals(active)){
            host=amezRequestProperties.getDev().getHost();
            port=amezRequestProperties.getDev().getPort();
        }else{
            host=amezRequestProperties.getPro().getHost();
            port=amezRequestProperties.getPro().getPort();
        }
        log.debug("request-host-port:"+host);
        if(StringUtils.isBlank(host)){
            throw new ServerException(500,"application.yml文件host属性不能为空");
        }
        sb.append(host);
        if(!StringUtils.isBlank(port)){
            sb.append(":");
            sb.append(port);
        }
        String path=amezRequestProperties.getPath().get(pathName);
        if(!StringUtils.isBlank(path)){
            judgeIfEndWithSlash(path,sb);
        }
        if(!StringUtils.isBlank(interfaceName)){
            judgeIfEndWithSlash(interfaceName,sb);
        }
        if(!CollectionUtils.isEmpty(urlPath)){
            for (String str: urlPath){
                judgeIfEndWithSlash(str,sb);
            }
        }

        return sb.toString();
    }

    /**
     * 判断是否以"/"结尾
     * @param str
     * @param sb
     */
    private void judgeIfEndWithSlash(String str,StringBuilder sb){
        if(str.startsWith(FH)){
            sb.append(str);
        }else{
            sb.append(FH);
            sb.append(str);
        }
    }


}
