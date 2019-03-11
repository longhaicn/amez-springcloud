package com.union.aimei.common.util.umeng.ios;


import com.union.aimei.common.util.umeng.AbstractIosNotification;
/**
 * @author houji
 * @date 2018/8/20  10:20
 */
public class IosCustomizedcast extends AbstractIosNotification {
	public IosCustomizedcast(String appkey, String appMasterSecret) throws Exception {
			setAppMasterSecret(appMasterSecret);
			setPredefinedKeyValue("appkey", appkey);
			this.setPredefinedKeyValue("type", "customizedcast");	
	}
	
	public void setAlias(String alias,String aliasType) throws Exception {
    	setPredefinedKeyValue("alias", alias);
    	setPredefinedKeyValue("alias_type", aliasType);
    }
		
	public void setFileId(String fileId, String aliasType) throws Exception {
		setPredefinedKeyValue("file_id", fileId);
		setPredefinedKeyValue("alias_type", aliasType);
	}

}
