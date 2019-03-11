package com.union.aimei.pc.im.easemob.api.impl;

import com.union.aimei.pc.im.easemob.api.FileApi;
import com.union.aimei.pc.im.easemob.comm.EasemobApi;
import com.union.aimei.pc.im.easemob.comm.OrgInfo;
import com.union.aimei.pc.im.easemob.comm.ResponseHandler;
import com.union.aimei.pc.im.easemob.comm.TokenUtil;
import io.swagger.client.ApiException;
import io.swagger.client.api.UploadAndDownloadFilesApi;

import java.io.File;

/**
 * 环信文件
 *
 * @author liurenkai
 * @time 2018/8/13 19:29
 */
public class EasemobFile implements FileApi {
    private ResponseHandler responseHandler = new ResponseHandler();
    private UploadAndDownloadFilesApi api = new UploadAndDownloadFilesApi();

    @Override
    public Object uploadFile(final Object file) {
        return responseHandler.handle(new EasemobApi() {
            @Override
            public Object invokeEasemobAPI() throws ApiException {
                return api.orgNameAppNameChatfilesPost(OrgInfo.ORG_NAME, OrgInfo.APP_NAME, TokenUtil.getAccessToken(), (File) file, true);
            }
        });
    }

    @Override
    public Object downloadFile(final String fileUUID, final String shareSecret, final Boolean isThumbnail) {
        return responseHandler.handle(new EasemobApi() {
            @Override
            public Object invokeEasemobAPI() throws ApiException {
                return api.orgNameAppNameChatfilesUuidGet(OrgInfo.ORG_NAME, OrgInfo.APP_NAME, TokenUtil.getAccessToken(), fileUUID, shareSecret, isThumbnail);
            }
        });
    }
}
