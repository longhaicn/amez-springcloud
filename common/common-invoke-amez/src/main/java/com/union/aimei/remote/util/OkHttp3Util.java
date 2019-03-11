package com.union.aimei.remote.util;

import com.union.common.utils.StringUtil;
import com.union.common.utils.exception.ServerException;
import okhttp3.*;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author GaoWei
 * @describe 远程调用工具类
 * @time 2018/4/27,15:16
*/
public class OkHttp3Util {

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");


    /**
     * POST请求
     * @param url
     * @param token
     * @return
     */
    public static String doPost(String url, String json, String token){
        OkHttpClient client= new OkHttpClient.Builder().
                //连接超时
                        connectTimeout(10, TimeUnit.SECONDS)
                //写超时
                .writeTimeout(10, TimeUnit.SECONDS)
                //读取超时
                .readTimeout(10, TimeUnit.SECONDS)
                //断网重连
                .retryOnConnectionFailure(true).build();
        RequestBody body = RequestBody.create(JSON, json==null?"":json);
        Request request = new Request.Builder()
                .addHeader("appSystem","200")
                .addHeader("microServiceAccessToken",token==null?"":token)
                .url(url)
                .post(body)
                .build();
        String res=null;
        try{
            Response response = client.newCall(request).execute();
            res=response.body().string();
        }catch (IOException e){
            e.printStackTrace();
        }
        if(StringUtils.isBlank(res)){
            throw new ServerException(500,"网络异常,请稍后重试");
        }
        return res;
    }

    /**
     * GET请求
     * @param url
     * @param token
     * @return
     */
    public static String doGet(String url,String token){
        OkHttpClient client= new OkHttpClient.Builder().
                //连接超时
                        connectTimeout(10, TimeUnit.SECONDS)
                //写超时
                .writeTimeout(10, TimeUnit.SECONDS)
                //读取超时
                .readTimeout(10, TimeUnit.SECONDS)
                //断网重连
                .retryOnConnectionFailure(true).build();
        Request request = new Request.Builder()
                .url(url)
                .addHeader("appSystem", "200")
                .addHeader("microserviceAccessToken", StringUtil.trimNull(token))
                .build();
        Call call = client.newCall(request);
        String res=null;
        try {
            Response response = call.execute();
            res=response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(StringUtils.isBlank(res)){
           throw new ServerException(500,"网络异常,请稍后重试");
        }
        return res;
    }


}
