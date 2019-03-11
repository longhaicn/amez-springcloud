package com.union.aimei.common.util.member;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @author houji
 * @date 2018/3/6  17:47
 */
public class AuthBankCardUtils {
    /**
     * 用户(会员)银行卡实名认证
     *
     * @param mobile   必须
     * @param bankcard 必须
     * @param cardNo   必须
     * @param realName 必须
     * @return
     */
    public static JSONObject configBankCard(String mobile, String bankcard, String cardNo, String realName) {
        JSONObject res = new JSONObject();
        String host = "https://aliyun-bankcard4-verify.apistore.cn";
        String path = "/bank4";
        String method = "GET";
        //appcode是从aliyun服务器得AppCode
        String appcode = "2242a27066df4d5faf25fe79d4b2fb25";
        Map<String, String> headers = new HashMap<String, String>(16);
        //最后在header中的格式(中间mz是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>(16);
        querys.put("Mobile", mobile);
        querys.put("bankcard", bankcard);
        querys.put("cardNo", cardNo);
        querys.put("realName", realName);
        try {
            HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
            //获取response的body
            JSONObject jsonObject = new JSONObject(EntityUtils.toString(response.getEntity()));
            int errorCode = Integer.parseInt(jsonObject.getString("error_code"));
            if (errorCode != 0) {
                res = null;
            } else {
                JSONObject result = jsonObject.getJSONObject("result");
                JSONObject information = result.getJSONObject("information");
                res = information;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
}
