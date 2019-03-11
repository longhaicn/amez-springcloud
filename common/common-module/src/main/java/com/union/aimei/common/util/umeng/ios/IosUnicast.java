package com.union.aimei.common.util.umeng.ios;


import com.union.aimei.common.util.umeng.AbstractIosNotification;
/**
 * @author houji
 * @date 2018/8/20  10:20
 */
public class IosUnicast extends AbstractIosNotification {
	public IosUnicast(String appkey, String appMasterSecret) throws Exception{
			setAppMasterSecret(appMasterSecret);
			setPredefinedKeyValue("appkey", appkey);
			this.setPredefinedKeyValue("type", "unicast");	
	}
	
	public void setDeviceToken(String token) throws Exception {
    	setPredefinedKeyValue("device_tokens", token);
    }
}
