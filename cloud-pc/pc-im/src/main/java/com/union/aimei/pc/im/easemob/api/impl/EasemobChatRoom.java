package com.union.aimei.pc.im.easemob.api.impl;

import com.union.aimei.pc.im.easemob.api.ChatRoomApi;
import com.union.aimei.pc.im.easemob.comm.EasemobApi;
import com.union.aimei.pc.im.easemob.comm.OrgInfo;
import com.union.aimei.pc.im.easemob.comm.ResponseHandler;
import com.union.aimei.pc.im.easemob.comm.TokenUtil;
import io.swagger.client.ApiException;
import io.swagger.client.StringUtil;
import io.swagger.client.api.ChatRoomsApi;
import io.swagger.client.model.Chatroom;
import io.swagger.client.model.ModifyChatroom;
import io.swagger.client.model.UserNames;

/**
 * 环信聊天室
 *
 * @author liurenkai
 * @time 2018/8/13 19:29
 */
public class EasemobChatRoom implements ChatRoomApi {
    private ResponseHandler responseHandler = new ResponseHandler();
    private ChatRoomsApi api = new ChatRoomsApi();

    @Override
    public Object createChatRoom(final Object payload) {
        return responseHandler.handle(new EasemobApi() {
            @Override
            public Object invokeEasemobAPI() throws ApiException {
                return api.orgNameAppNameChatroomsPost(OrgInfo.ORG_NAME, OrgInfo.APP_NAME, TokenUtil.getAccessToken(), (Chatroom) payload);
            }
        });
    }

    @Override
    public Object modifyChatRoom(final String roomId, final Object payload) {
        return responseHandler.handle(new EasemobApi() {
            @Override
            public Object invokeEasemobAPI() throws ApiException {
                return api.orgNameAppNameChatroomsChatroomIdPut(OrgInfo.ORG_NAME, OrgInfo.APP_NAME, TokenUtil.getAccessToken(), roomId, (ModifyChatroom) payload);
            }
        });
    }

    @Override
    public Object deleteChatRoom(final String roomId) {
        return responseHandler.handle(new EasemobApi() {
            @Override
            public Object invokeEasemobAPI() throws ApiException {
                return api.orgNameAppNameChatroomsChatroomIdDelete(OrgInfo.ORG_NAME, OrgInfo.APP_NAME, TokenUtil.getAccessToken(), roomId);
            }
        });
    }

    @Override
    public Object getAllChatRooms() {
        return responseHandler.handle(new EasemobApi() {
            @Override
            public Object invokeEasemobAPI() throws ApiException {
                return api.orgNameAppNameChatroomsGet(OrgInfo.ORG_NAME, OrgInfo.APP_NAME, TokenUtil.getAccessToken());
            }
        });
    }

    @Override
    public Object getChatRoomDetail(final String roomId) {
        return responseHandler.handle(new EasemobApi() {
            @Override
            public Object invokeEasemobAPI() throws ApiException {
                return api.orgNameAppNameChatroomsChatroomIdGet(OrgInfo.ORG_NAME, OrgInfo.APP_NAME, TokenUtil.getAccessToken(), roomId);
            }
        });
    }

    @Override
    public Object addSingleUserToChatRoom(final String roomId, final String userName) {
        return responseHandler.handle(new EasemobApi() {
            @Override
            public Object invokeEasemobAPI() throws ApiException {
                return api.orgNameAppNameChatroomsChatroomIdUsersUsernamePost(OrgInfo.ORG_NAME, OrgInfo.APP_NAME, TokenUtil.getAccessToken(), roomId, userName);
            }
        });
    }

    @Override
    public Object addBatchUsersToChatRoom(final String roomId, final Object payload) {
        return responseHandler.handle(new EasemobApi() {
            @Override
            public Object invokeEasemobAPI() throws ApiException {
                return api.orgNameAppNameChatroomsChatroomIdUsersPost(OrgInfo.ORG_NAME, OrgInfo.APP_NAME, TokenUtil.getAccessToken(), roomId, (UserNames) payload);
            }
        });
    }

    @Override
    public Object removeSingleUserFromChatRoom(final String roomId, final String userName) {
        return responseHandler.handle(new EasemobApi() {
            @Override
            public Object invokeEasemobAPI() throws ApiException {
                return api.orgNameAppNameChatroomsChatroomIdUsersUsernameDelete(OrgInfo.ORG_NAME, OrgInfo.APP_NAME, TokenUtil.getAccessToken(), roomId, userName);
            }
        });
    }

    @Override
    public Object removeBatchUsersFromChatRoom(final String roomId, final String[] userNames) {
        return responseHandler.handle(new EasemobApi() {
            @Override
            public Object invokeEasemobAPI() throws ApiException {
                return api.orgNameAppNameChatroomsChatroomIdUsersUsernamesDelete(OrgInfo.ORG_NAME, OrgInfo.APP_NAME, TokenUtil.getAccessToken(), roomId, StringUtil.join(userNames, ","));
            }
        });
    }
}
