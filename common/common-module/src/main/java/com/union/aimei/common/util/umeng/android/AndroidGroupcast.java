package com.union.aimei.common.util.umeng.android;

import com.union.aimei.common.util.umeng.AbstractAndroidNotification;
import org.json.JSONObject;
/**
 * @author houji
 * @date 2018/8/20  10:20
 */
public class AndroidGroupcast extends AbstractAndroidNotification {
	public AndroidGroupcast(String appkey,String appMasterSecret) throws Exception {
			setAppMasterSecret(appMasterSecret);
			setPredefinedKeyValue("appkey", appkey);
			this.setPredefinedKeyValue("type", "groupcast");	
	}
	
	public void setFilter(JSONObject filter) throws Exception {
    	setPredefinedKeyValue("filter", filter);
    }
}
