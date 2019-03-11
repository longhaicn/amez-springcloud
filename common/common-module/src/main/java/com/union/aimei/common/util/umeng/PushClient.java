package com.union.aimei.common.util.umeng;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 推送客户端
 *
 * @author houji
 * @time 2018/8/24 10:03
 */
public class PushClient {

    protected final String USER_AGENT = "Mozilla/5.0";

    protected HttpClient client = new DefaultHttpClient();

    protected static final String HOST = "http://msg.umeng.com";

    protected static final String UPLOADPATH = "/upload";

    protected static final String POSTPATH = "/api/send";

    public int send(AbstractUmengNotification msg) throws Exception {
        String timestamp = Integer.toString((int) (System.currentTimeMillis() / 1000));
        msg.setPredefinedKeyValue("timestamp", timestamp);
        String url = HOST + POSTPATH;
        String postBody = msg.getPostBody();
        String sign = DigestUtils.md5Hex(("POST" + url + postBody + msg.getAppMasterSecret()).getBytes("utf8"));
        url = url + "?sign=" + sign;
        HttpPost post = new HttpPost(url);
        post.setHeader("User-Agent", USER_AGENT);
        StringEntity se = new StringEntity(postBody, "UTF-8");
        post.setEntity(se);
        // Send the post request and get the response
        HttpResponse response = client.execute(post);
        int status = response.getStatusLine().getStatusCode();
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        return status;
    }

    public String uploadContents(String appkey, String appMasterSecret, String contents) throws Exception {
        // Construct the json string
        JSONObject uploadJson = new JSONObject();
        uploadJson.put("appkey", appkey);
        String timestamp = Integer.toString((int) (System.currentTimeMillis() / 1000));
        uploadJson.put("timestamp", timestamp);
        uploadJson.put("content", contents);
        // Construct the request
        String url = HOST + UPLOADPATH;
        String postBody = uploadJson.toString();
        String sign = DigestUtils.md5Hex(("POST" + url + postBody + appMasterSecret).getBytes("utf8"));
        url = url + "?sign=" + sign;
        HttpPost post = new HttpPost(url);
        post.setHeader("User-Agent", USER_AGENT);
        StringEntity se = new StringEntity(postBody, "UTF-8");
        post.setEntity(se);
        // Send the post request and get the response
        HttpResponse response = client.execute(post);
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        // Decode response string and get file_id from it
        JSONObject respJson = new JSONObject(result.toString());
        String ret = respJson.getString("ret");
        String success = "SUCCESS";
        if (!success.equals(ret)) {
            throw new Exception("Failed to upload file");
        }
        JSONObject data = respJson.getJSONObject("data");
        String fileId = data.getString("file_id");
        // Set file_id into rootJson using setPredefinedKeyValue
        return fileId;
    }

}
