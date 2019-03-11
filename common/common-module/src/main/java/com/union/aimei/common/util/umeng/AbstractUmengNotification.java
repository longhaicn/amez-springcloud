package com.union.aimei.common.util.umeng;

import org.json.JSONObject;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 友盟通知
 *
 * @author houji
 * @time 2018/8/24 9:45
 */
public abstract class AbstractUmengNotification {

    protected final JSONObject rootJson = new JSONObject();

    protected String appMasterSecret;

    protected static final HashSet<String> ROOT_KEYS = new HashSet<String>(Arrays.asList(new String[]{
            "appkey", "timestamp", "type", "device_tokens", "alias", "alias_type", "file_id",
            "filter", "production_mode", "feedback", "description", "thirdparty_id"}));

    protected static final HashSet<String> POLICY_KEYS = new HashSet<String>(Arrays.asList(new String[]{
            "start_time", "expire_time", "max_send_num"
    }));

    /**
     * 设置预定义
     *
     * @param key
     * @param value
     * @return
     * @throws Exception
     */
    public abstract boolean setPredefinedKeyValue(String key, Object value) throws Exception;

    public void setAppMasterSecret(String secret) {
        appMasterSecret = secret;
    }

    public String getPostBody() {
        return rootJson.toString();
    }

    protected final String getAppMasterSecret() {
        return appMasterSecret;
    }

    protected void setProductionMode(Boolean prod) throws Exception {
        setPredefinedKeyValue("production_mode", prod.toString());
    }

    /**
     * 正式模式
     *
     * @throws Exception
     */
    public void setProductionMode() throws Exception {
        setProductionMode(true);
    }

    /**
     * 测试模式
     *
     * @throws Exception
     */
    public void setTestMode() throws Exception {
        setProductionMode(false);
    }

    /**
     * 发送消息描述，建议填写。
     *
     * @param description
     * @throws Exception
     */
    public void setDescription(String description) throws Exception {
        setPredefinedKeyValue("description", description);
    }

    /**
     * 定时发送时间，若不填写表示立即发送。格式: "YYYY-MM-DD hh:mm:ss"。
     *
     * @param startTime
     * @throws Exception
     */
    public void setStartTime(String startTime) throws Exception {
        setPredefinedKeyValue("start_time", startTime);
    }

    /**
     * 消息过期时间,格式: "YYYY-MM-DD hh:mm:ss"。
     *
     * @param expireTime
     * @throws Exception
     */
    public void setExpireTime(String expireTime) throws Exception {
        setPredefinedKeyValue("expire_time", expireTime);
    }

    /**
     * 发送限速，每秒发送的最大条数。
     *
     * @param num
     * @throws Exception
     */
    public void setMaxSendNum(Integer num) throws Exception {
        setPredefinedKeyValue("max_send_num", num);
    }

}
