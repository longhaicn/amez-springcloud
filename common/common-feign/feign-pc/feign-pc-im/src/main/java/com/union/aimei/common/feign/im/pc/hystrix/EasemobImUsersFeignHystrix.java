package com.union.aimei.common.feign.im.pc.hystrix;

import com.union.aimei.common.feign.im.pc.EasemobImUsersFeign;
import com.union.aimei.common.model.im.ImUsers;
import com.union.aimei.common.vo.im.common.ResponseResult;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import io.swagger.client.model.RegisterUsers;
import io.swagger.client.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * IM用户feign hystrix
 *
 * @author liurenkai
 * @time 2017/11/28 16:03
 */
@Component(value = "pc-EasemobImUsersFeign")
public class EasemobImUsersFeignHystrix implements EasemobImUsersFeign {

    @Override
    public ResponseMessage<ImUsers> registerSingle(User user) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<ResponseResult> registerBatch(RegisterUsers registerUsers) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<ResponseResult> getByUserName(String userName) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<ResponseResult> getBatch(long limit, String cursor) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<ResponseResult> deleteByUserName(String userName) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<ResponseResult> deleteBatch(long limit, String cursor) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<ResponseResult> modifyPassword(String userName, String newPassword) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<ResponseResult> modifyNickName(String userName, String nickname) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<ResponseResult> addFriendSingle(String userName, String friendName) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<ResponseResult> deleteFriendSingle(String userName, String friendName) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<ResponseResult> getFriends(String userName) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<ResponseResult> getBlackList(String userName) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<ResponseResult> addToBlackList(String userName, String userNames) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<ResponseResult> removeFromBlackList(String userName, String blackListName) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<ResponseResult> getStatus(String userName) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<List<ResponseResult>> getStatusBatch(List<String> userNameList) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<ResponseResult> getOfflineMsgCount(String userName) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<ResponseResult> getSpecifiedOfflineMsgStatus(String userName, String msgId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<ResponseResult> deactivate(String userName) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<ResponseResult> activate(String userName) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<ResponseResult> disconnect(String userName) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage login(String userName, String password) {
        return HystrixResponse.invokeFail();
    }

}
