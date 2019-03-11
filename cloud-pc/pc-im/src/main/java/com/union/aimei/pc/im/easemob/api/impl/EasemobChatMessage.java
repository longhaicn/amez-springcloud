package com.union.aimei.pc.im.easemob.api.impl;

import com.union.aimei.pc.im.easemob.api.ChatMessageApi;
import com.union.aimei.pc.im.easemob.comm.EasemobApi;
import com.union.aimei.pc.im.easemob.comm.OrgInfo;
import com.union.aimei.pc.im.easemob.comm.ResponseHandler;
import com.union.aimei.pc.im.easemob.comm.TokenUtil;
import io.swagger.client.ApiException;
import io.swagger.client.api.ChatHistoryApi;

/**
 * 环信聊天记录
 *
 * @author liurenkai
 * @time 2018/8/13 19:29
 */
public class EasemobChatMessage implements ChatMessageApi {

    private ResponseHandler responseHandler = new ResponseHandler();
    private ChatHistoryApi api = new ChatHistoryApi();

    @Override
    public Object exportChatMessages(final Long limit, final String cursor, final String query) {
        return responseHandler.handle(new EasemobApi() {
            @Override
            public Object invokeEasemobAPI() throws ApiException {
                return api.orgNameAppNameChatmessagesGet(OrgInfo.ORG_NAME, OrgInfo.APP_NAME, TokenUtil.getAccessToken(), query, limit + "", cursor);
            }
        });
    }

    @Override
    public Object exportChatMessages(final String timeStr) {
        return responseHandler.handle(new EasemobApi() {
            @Override
            public Object invokeEasemobAPI() throws ApiException {
                return api.orgNameAppNameChatmessagesTimeGet(OrgInfo.ORG_NAME, OrgInfo.APP_NAME, TokenUtil.getAccessToken(), timeStr);
            }
        });
    }
}
