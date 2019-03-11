package com.union.aimei.common.util.umeng.ios;


import com.union.aimei.common.util.umeng.AbstractIosNotification;
/**
 * @author houji
 * @date 2018/8/20  10:20
 */
public class IosFilecast extends AbstractIosNotification {
	public IosFilecast(String appkey, String appMasterSecret) throws Exception {
			setAppMasterSecret(appMasterSecret);
			setPredefinedKeyValue("appkey", appkey);
			this.setPredefinedKeyValue("type", "filecast");	
	}
	
	public void setFileId(String fileId) throws Exception {
    	setPredefinedKeyValue("file_id", fileId);
    }
}
