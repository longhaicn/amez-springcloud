package com.union.aimei.app.api.order.okhttp;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import okhttp3.*;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author GaoWei
 * @describe 发起json请求工具类
 * @time 2018/3/6,16:25
*/
public class RequestUtil {


    /**
     * GET请求
     * @param url
     * @return
     */
    public static JsonObject doGet(String url){
        OkHttpClient client= new OkHttpClient.Builder().
                //连接超时
                        connectTimeout(5, TimeUnit.SECONDS)
                //写超时
                .writeTimeout(5, TimeUnit.SECONDS)
                //读取超时
                .readTimeout(5, TimeUnit.SECONDS)
                //断网重连
                .retryOnConnectionFailure(true).build();
        Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = client.newCall(request);
        JsonObject jsonObject=null;
        String res="";
        try {
            Response response = call.execute();
            jsonObject=returnJsonObj(response,res,jsonObject);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }


    /**
     * POST请求
     * @param url
     * @return
     */
    public static JsonObject doPost(String url,String customer,String key,String sign,String param){
        OkHttpClient client= new OkHttpClient.Builder().
                //连接超时
                        connectTimeout(5, TimeUnit.SECONDS)
                //写超时
                .writeTimeout(5, TimeUnit.SECONDS)
                //读取超时
                .readTimeout(5, TimeUnit.SECONDS)
                //断网重连
                .retryOnConnectionFailure(true).build();
        //post方式提交的数据
        FormBody formBody = new FormBody.Builder()
                .add("customer", customer)
                .add("key",key)
                .add("sign", sign)
                .add("param",param)
                .build();
        Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();
        String res="";
        JsonObject jsonObject=null;
        try{
            Response response = client.newCall(request).execute();
            jsonObject=returnJsonObj(response,res,jsonObject);
        }catch (IOException e){
            e.printStackTrace();
        }
        return jsonObject;
    }

    private static JsonObject returnJsonObj(Response response,String res,JsonObject jsonObject)throws IOException{
        if(response!=null){
            jsonObject=new JsonObject();
            ResponseBody responseBody=response.body();
            if(responseBody!=null){
                res=responseBody.string();
            }
            Gson gson=new Gson();
            if(!StringUtils.isBlank(res)){
                jsonObject=gson.fromJson(res,JsonObject.class);
            }
        }
        return jsonObject;
    }
}
