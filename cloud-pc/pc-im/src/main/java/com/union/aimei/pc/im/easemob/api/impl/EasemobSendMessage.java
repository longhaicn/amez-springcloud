package com.union.aimei.pc.im.easemob.api.impl;

import com.union.aimei.pc.im.easemob.api.SendMessageApi;
import com.union.aimei.pc.im.easemob.comm.EasemobApi;
import com.union.aimei.pc.im.easemob.comm.OrgInfo;
import com.union.aimei.pc.im.easemob.comm.ResponseHandler;
import com.union.aimei.pc.im.easemob.comm.TokenUtil;
import io.swagger.client.ApiException;
import io.swagger.client.api.MessagesApi;
import io.swagger.client.model.Msg;

/**
 * 环信发送消息
 *
 * @author liurenkai
 * @time 2018/8/13 19:28
 */
public class EasemobSendMessage implements SendMessageApi {
    private ResponseHandler responseHandler = new ResponseHandler();
    private MessagesApi api = new MessagesApi();

    @Override
    public Object sendMessage(final Object payload) {
        return responseHandler.handle(new EasemobApi() {
            @Override
            public Object invokeEasemobAPI() throws ApiException {
                return api.orgNameAppNameMessagesPost(OrgInfo.ORG_NAME, OrgInfo.APP_NAME, TokenUtil.getAccessToken(), (Msg) payload);
            }
        });
    }
}
