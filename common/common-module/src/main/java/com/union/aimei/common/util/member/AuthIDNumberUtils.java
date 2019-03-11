package com.union.aimei.common.util.member;


import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @author houji
 * @date 2018/3/6  17:16
 */
public class AuthIDNumberUtils {
    /**
     * 第三方实名认证方法
     * @param cardNo
     * @param realName
     * @return
     */
    public static int config(String cardNo, String realName){
        int res = 0;
        String host = "https://1.api.apistore.cn";
        String path = "/idcard3";
        String method = "POST";
        //阿里云appCode
        String appcode = "2242a27066df4d5faf25fe79d4b2fb25";
        Map<String, String> headers = new HashMap<String, String>(16);
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        //根据API的要求，定义相对应的Content-Type
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        Map<String, String> querys = new HashMap<String, String>(16);
        Map<String, String> bodys = new HashMap<String, String>(16);
        bodys.put("cardNo", cardNo);
        bodys.put("realName", realName);

        try {
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            JSONObject resObj = new JSONObject(EntityUtils.toString(response.getEntity()));
            int errorCode  = Integer.parseInt(resObj.getString("error_code"));
            res = errorCode;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
}
