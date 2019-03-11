package com.union.aimei.pc.im.service.impl;

import com.codingapi.tx.annotation.TxTransaction;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.union.aimei.pc.im.easemob.api.impl.EasemobImUsers;
import com.union.aimei.pc.im.easemob.comm.OrgInfo;
import com.union.aimei.common.model.im.ImUsers;
import com.union.aimei.pc.im.mapper.ImUsersMapper;
import com.union.aimei.pc.im.service.EasemobImUsersService;
import com.union.aimei.common.vo.im.common.ResponseResult;
import com.union.common.utils.AssertUtil;
import com.union.common.utils.ResponseException;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseMessageFactory;
import com.union.common.utils.constant.ResponseContants;
import io.swagger.client.model.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * IM用户service impl
 *
 * @author liurenkai
 * @time 2017/11/28 15:45
 */
@Service("easemobImUsersService")
public class EasemobImUsersServiceImpl implements EasemobImUsersService {

    @Resource
    private ImUsersMapper imUsersMapper;

    @Override
    @TxTransaction
    @Transactional(rollbackFor = Exception.class)
    public ResponseMessage<ImUsers> registerSingle(User user) {
        ResponseMessage<ImUsers> responseMessage = new ResponseMessage<>();
        EasemobImUsers easemobIMUsers = new EasemobImUsers();
        RegisterUsers registerUsers = new RegisterUsers();
        registerUsers.add(user);
        Object responseObject = easemobIMUsers.createNewIMUserSingle(registerUsers);
        if (responseObject == null) {
            throw new ResponseException(ResponseContants.ADD, ResponseContants.ADD_MESSAGE);
        }
        ResponseResult responseResult = new Gson().fromJson(responseObject.toString(), ResponseResult.class);
        if (responseResult.getEntities() == null) {
            throw new ResponseException(ResponseContants.ADD, ResponseContants.ADD_MESSAGE);
        }
        JsonArray jsonArray = new JsonParser().parse(responseResult.getEntities().toString()).getAsJsonArray();
        ImUsers imUsers = new Gson().fromJson(jsonArray.get(0), ImUsers.class);
        ImUsers imUsersCond = new ImUsers();
        imUsersCond.setUuid(imUsers.getUuid());
        List<ImUsers> imUsersList = this.imUsersMapper.selectListByConditions(imUsersCond);
        if (imUsersList.size() > 0) {
            throw new ResponseException(ResponseContants.ADD, ResponseContants.ADD_MESSAGE);
        }
        this.imUsersMapper.insertSelective(imUsers);
        responseMessage.setData(imUsers);
        return responseMessage;
    }

    @Override
    public ResponseMessage<ResponseResult> registerBatch(RegisterUsers registerUsers) {
        ResponseMessage responseMessage = ResponseMessageFactory.newInstance();
        EasemobImUsers easemobIMUsers = new EasemobImUsers();
        Object responseObject = easemobIMUsers.createNewIMUserBatch(registerUsers);
        if (null == responseObject) {
            AssertUtil.numberGtZero(null, ResponseContants.ADD_MESSAGE, ResponseContants.ADD);
        }
        ResponseResult responseResult = new Gson().fromJson(responseObject.toString(), ResponseResult.class);
        responseMessage.setData(responseResult);
        return responseMessage;
    }

    @Override
    public ResponseMessage getByUserName(String userName) {
        ResponseMessage responseMessage = ResponseMessageFactory.newInstance();
        EasemobImUsers easemobIMUsers = new EasemobImUsers();
        Object responseObject = easemobIMUsers.getIMUserByUserName(userName);
        if (null == responseObject) {
            AssertUtil.numberGtZero(null, ResponseContants.QUERY_EMPTY_MESSAGE, ResponseContants.QUERY_EMPTY);
        }
        ResponseResult responseResult = new Gson().fromJson(responseObject.toString(), ResponseResult.class);
        responseMessage.setData(responseResult);
        return responseMessage;
    }

    @Override
    public ResponseMessage getBatch(long limit, String cursor) {
        ResponseMessage responseMessage = ResponseMessageFactory.newInstance();
        EasemobImUsers easemobIMUsers = new EasemobImUsers();
        Object responseObject = easemobIMUsers.getIMUsersBatch(limit, cursor);
        if (null == responseObject) {
            AssertUtil.numberGtZero(null, ResponseContants.QUERY_EMPTY_MESSAGE, ResponseContants.QUERY_EMPTY);
        }
        ResponseResult responseResult = new Gson().fromJson(responseObject.toString(), ResponseResult.class);
        System.out.println(responseResult);
        if (null != responseResult.getEntities()) {
            JsonArray jsonArray = new JsonParser().parse(responseResult.getEntities().toString()).getAsJsonArray();
            Gson gson = new Gson();
            for (JsonElement jsonElement : jsonArray) {
                ImUsers imUsers = gson.fromJson(jsonElement, ImUsers.class);
                ImUsers imUsersCond = new ImUsers();
                imUsersCond.setUuid(imUsers.getUuid());
                List<ImUsers> imUsersList = this.imUsersMapper.selectListByConditions(imUsersCond);
                if (imUsersList.isEmpty()) {
                    this.imUsersMapper.insertSelective(imUsers);
                }
            }
        }
        System.out.println(responseResult);
        responseMessage.setData(responseResult);
        return responseMessage;
    }

    @Override
    public ResponseMessage deleteByUserName(String userName) {
        ResponseMessage responseMessage = ResponseMessageFactory.newInstance();
        EasemobImUsers easemobIMUsers = new EasemobImUsers();
        Object responseObject = easemobIMUsers.deleteIMUserByUserName(userName);
        if (null == responseObject) {
            AssertUtil.numberGtZero(null, ResponseContants.DELETE_MESSAGE, ResponseContants.DELETE);
        }
        ResponseResult responseResult = new Gson().fromJson(responseObject.toString(), ResponseResult.class);
        responseMessage.setData(responseResult);
        return responseMessage;
    }

    @Override
    public ResponseMessage deleteBatch(long limit, String cursor) {
        ResponseMessage responseMessage = ResponseMessageFactory.newInstance();
        EasemobImUsers easemobIMUsers = new EasemobImUsers();
        Object responseObject = easemobIMUsers.deleteIMUserBatch(limit, cursor);
        if (null == responseObject) {
            AssertUtil.numberGtZero(null, ResponseContants.DELETE_MESSAGE, ResponseContants.DELETE);
        }
        ResponseResult responseResult = new Gson().fromJson(responseObject.toString(), ResponseResult.class);
        responseMessage.setData(responseResult);
        return responseMessage;
    }

    @Override
    public ResponseMessage modifyPassword(String userName, String newPassword) {
        ResponseMessage responseMessage = ResponseMessageFactory.newInstance();
        EasemobImUsers easemobIMUsers = new EasemobImUsers();
        NewPassword newPasswordPayload = new NewPassword();
        newPasswordPayload.setNewpassword(newPassword);
        Object responseObject = easemobIMUsers.modifyIMUserPasswordWithAdminToken(userName, newPasswordPayload);
        if (null == responseObject) {
            AssertUtil.numberGtZero(null, ResponseContants.EDIT_MESSAGE, ResponseContants.EDIT);
        }
        ResponseResult responseResult = new Gson().fromJson(responseObject.toString(), ResponseResult.class);
        responseMessage.setData(responseResult);
        return responseMessage;
    }

    @Override
    public ResponseMessage modifyNickName(String userName, String nickname) {
        ResponseMessage responseMessage = ResponseMessageFactory.newInstance();
        EasemobImUsers easemobIMUsers = new EasemobImUsers();
        Nickname nicknamePayload = new Nickname();
        nicknamePayload.setNickname(nickname);
        Object responseObject = easemobIMUsers.modifyIMUserNickNameWithAdminToken(userName, nicknamePayload);
        if (null == responseObject) {
            AssertUtil.numberGtZero(null, ResponseContants.EDIT_MESSAGE, ResponseContants.EDIT);
        }
        ResponseResult responseResult = new Gson().fromJson(responseObject.toString(), ResponseResult.class);
        responseMessage.setData(responseResult);
        return responseMessage;
    }

    @Override
    public ResponseMessage addFriendSingle(String userName, String friendName) {
        ResponseMessage responseMessage = ResponseMessageFactory.newInstance();
        EasemobImUsers easemobIMUsers = new EasemobImUsers();
        Object responseObject = easemobIMUsers.addFriendSingle(userName, friendName);
        if (null == responseObject) {
            AssertUtil.numberGtZero(null, ResponseContants.ADD_MESSAGE, ResponseContants.ADD);
        }
        ResponseResult responseResult = new Gson().fromJson(responseObject.toString(), ResponseResult.class);
        responseMessage.setData(responseResult);
        return responseMessage;
    }

    @Override
    public ResponseMessage deleteFriendSingle(String userName, String friendName) {
        ResponseMessage responseMessage = ResponseMessageFactory.newInstance();
        EasemobImUsers easemobIMUsers = new EasemobImUsers();
        Object responseObject = easemobIMUsers.deleteFriendSingle(userName, friendName);
        if (null == responseObject) {
            AssertUtil.numberGtZero(null, ResponseContants.DELETE_MESSAGE, ResponseContants.DELETE);
        }
        ResponseResult responseResult = new Gson().fromJson(responseObject.toString(), ResponseResult.class);
        responseMessage.setData(responseResult);
        return responseMessage;
    }

    @Override
    public ResponseMessage getFriends(String userName) {
        ResponseMessage responseMessage = ResponseMessageFactory.newInstance();
        EasemobImUsers easemobIMUsers = new EasemobImUsers();
        Object responseObject = easemobIMUsers.getFriends(userName);
        if (null == responseObject) {
            AssertUtil.numberGtZero(null, ResponseContants.QUERY_EMPTY_MESSAGE, ResponseContants.QUERY_EMPTY);
        }
        ResponseResult responseResult = new Gson().fromJson(responseObject.toString(), ResponseResult.class);
        responseMessage.setData(responseResult);
        return responseMessage;
    }

    @Override
    public ResponseMessage getBlackList(String userName) {
        ResponseMessage responseMessage = ResponseMessageFactory.newInstance();
        EasemobImUsers easemobIMUsers = new EasemobImUsers();
        Object responseObject = easemobIMUsers.getBlackList(userName);
        if (null == responseObject) {
            AssertUtil.numberGtZero(null, ResponseContants.QUERY_EMPTY_MESSAGE, ResponseContants.QUERY_EMPTY);
        }
        ResponseResult responseResult = new Gson().fromJson(responseObject.toString(), ResponseResult.class);
        responseMessage.setData(responseResult);
        return responseMessage;
    }

    @Override
    public ResponseMessage addToBlackList(String userName, String userNames) {
        ResponseMessage responseMessage = ResponseMessageFactory.newInstance();
        EasemobImUsers easemobIMUsers = new EasemobImUsers();
        UserNames userNamesPayload = new UserNames();
        UserName userNamePayload = new UserName();
        userNamePayload.add(userNames);
        userNamesPayload.setUsernames(userNamePayload);
        Object responseObject = easemobIMUsers.addToBlackList(userName, userNamesPayload);
        if (null == responseObject) {
            AssertUtil.numberGtZero(null, ResponseContants.ADD_MESSAGE, ResponseContants.ADD);
        }
        ResponseResult responseResult = new Gson().fromJson(responseObject.toString(), ResponseResult.class);
        responseMessage.setData(responseResult);
        return responseMessage;
    }

    @Override
    public ResponseMessage removeFromBlackList(String userName, String blackListName) {
        ResponseMessage responseMessage = ResponseMessageFactory.newInstance();
        EasemobImUsers easemobIMUsers = new EasemobImUsers();
        Object responseObject = easemobIMUsers.removeFromBlackList(userName, blackListName);
        if (null == responseObject) {
            AssertUtil.numberGtZero(null, ResponseContants.DELETE_MESSAGE, ResponseContants.DELETE);
        }
        ResponseResult responseResult = new Gson().fromJson(responseObject.toString(), ResponseResult.class);
        responseMessage.setData(responseResult);
        return responseMessage;
    }

    @Override
    public ResponseMessage getStatus(String userName) {
        ResponseMessage responseMessage = ResponseMessageFactory.newInstance();
        EasemobImUsers easemobIMUsers = new EasemobImUsers();
        Object responseObject = easemobIMUsers.getIMUserStatus(userName);
        if (null == responseObject) {
            AssertUtil.numberGtZero(null, ResponseContants.QUERY_EMPTY_MESSAGE, ResponseContants.QUERY_EMPTY);
        }
        ResponseResult responseResult = new Gson().fromJson(responseObject.toString(), ResponseResult.class);
        responseMessage.setData(responseResult);
        return responseMessage;
    }

    @Override
    public ResponseMessage<List<ResponseResult>> getStatusBatch(List<String> userNameList) {
        ResponseMessage responseMessage = ResponseMessageFactory.newInstance();
        List<ResponseResult> responseResultList = new ArrayList<>(10);
        EasemobImUsers easemobIMUsers = new EasemobImUsers();
        for (String userName : userNameList) {
            Object responseObject = easemobIMUsers.getIMUserStatus(userName);
            if (null == responseObject) {
                AssertUtil.numberGtZero(null, ResponseContants.QUERY_EMPTY_MESSAGE, ResponseContants.QUERY_EMPTY);
            }
            ResponseResult responseResult = new Gson().fromJson(responseObject.toString(), ResponseResult.class);
            responseResultList.add(responseResult);
        }
        responseMessage.setData(responseResultList);
        return responseMessage;
    }

    @Override
    public ResponseMessage getOfflineMsgCount(String userName) {
        ResponseMessage responseMessage = ResponseMessageFactory.newInstance();
        EasemobImUsers easemobIMUsers = new EasemobImUsers();
        Object responseObject = easemobIMUsers.getOfflineMsgCount(userName);
        if (null == responseObject) {
            AssertUtil.numberGtZero(null, ResponseContants.QUERY_EMPTY_MESSAGE, ResponseContants.QUERY_EMPTY);
        }
        ResponseResult responseResult = new Gson().fromJson(responseObject.toString(), ResponseResult.class);
        responseMessage.setData(responseResult);
        return responseMessage;
    }

    @Override
    public ResponseMessage getSpecifiedOfflineMsgStatus(String userName, String msgId) {
        ResponseMessage responseMessage = ResponseMessageFactory.newInstance();
        EasemobImUsers easemobIMUsers = new EasemobImUsers();
        Object responseObject = easemobIMUsers.getSpecifiedOfflineMsgStatus(userName, msgId);
        if (null == responseObject) {
            AssertUtil.numberGtZero(null, ResponseContants.QUERY_EMPTY_MESSAGE, ResponseContants.QUERY_EMPTY);
        }
        ResponseResult responseResult = new Gson().fromJson(responseObject.toString(), ResponseResult.class);
        responseMessage.setData(responseResult);
        return responseMessage;
    }

    @Override
    public ResponseMessage deactivate(String userName) {
        ResponseMessage responseMessage = ResponseMessageFactory.newInstance();
        EasemobImUsers easemobIMUsers = new EasemobImUsers();
        Object responseObject = easemobIMUsers.deactivateIMUser(userName);
        if (null == responseObject) {
            AssertUtil.numberGtZero(null, ResponseContants.EDIT_MESSAGE, ResponseContants.EDIT);
        }
        ResponseResult responseResult = new Gson().fromJson(responseObject.toString(), ResponseResult.class);
        responseMessage.setData(responseResult);
        return responseMessage;
    }

    @Override
    public ResponseMessage activate(String userName) {
        ResponseMessage responseMessage = ResponseMessageFactory.newInstance();
        EasemobImUsers easemobIMUsers = new EasemobImUsers();
        Object responseObject = easemobIMUsers.activateIMUser(userName);
        if (null == responseObject) {
            AssertUtil.numberGtZero(null, ResponseContants.EDIT_MESSAGE, ResponseContants.EDIT);
        }
        ResponseResult responseResult = new Gson().fromJson(responseObject.toString(), ResponseResult.class);
        responseMessage.setData(responseResult);
        return responseMessage;
    }

    @Override
    public ResponseMessage disconnect(String userName) {
        ResponseMessage responseMessage = ResponseMessageFactory.newInstance();
        EasemobImUsers easemobIMUsers = new EasemobImUsers();
        Object responseObject = easemobIMUsers.disconnectIMUser(userName);
        if (null == responseObject) {
            AssertUtil.numberGtZero(null, ResponseContants.EDIT_MESSAGE, ResponseContants.EDIT);
        }
        ResponseResult responseResult = new Gson().fromJson(responseObject.toString(), ResponseResult.class);
        responseMessage.setData(responseResult);
        return responseMessage;
    }

    @Override
    public ResponseMessage login(String userName, String password) {
        ResponseMessage responseMessage = ResponseMessageFactory.newInstance();
        String apiUrl = "http://a1.easemob.com/" + OrgInfo.ORG_NAME + "/" + OrgInfo.APP_NAME + "/token";
        Map<String, String> params = new HashMap<>(4);
        params.put("grant_type", "password");
        params.put("username", userName);
        params.put("password", password);
        params.put("timestamp", String.valueOf(System.currentTimeMillis()));
        String body = new RestTemplate().postForObject(apiUrl, params, String.class);
        responseMessage.setData(body);
        return responseMessage;
    }

}