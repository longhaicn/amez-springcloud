package com.union.aimei.common.feign.im.pc.hystrix;

import com.union.aimei.common.feign.im.pc.EasemobImChatGroupsFeign;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import io.swagger.client.model.Group;
import io.swagger.client.model.ModifyGroup;
import io.swagger.client.model.NewOwner;
import io.swagger.client.model.UserNames;
import org.springframework.stereotype.Component;

/**
 * IM群组feign hystrix
 *
 * @author liurenkai
 * @time 2017/11/28 16:03
 */
@Component(value = "pc-EasemobImChatGroupsFeign")
public class EasemobImChatGroupsFeignHystrix implements EasemobImChatGroupsFeign {

    @Override
    public ResponseMessage getLimit(long limit, String cursor) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage getDetails(String groupId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage create(Group group) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage modify(String groupId, ModifyGroup modifyGroup) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage delete(String groupId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage getUsers(String groupId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage addSingleUser(String groupId, String userId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage addBatchUsers(String groupId, UserNames userNames) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage removeSingleUser(String groupId, String userId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage removeBatchUsers(String groupId, String[] userIds) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage transferOwner(String groupId, NewOwner newOwner) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage addSingleBlockUser(String groupId, String userId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage addBatchBlockUsers(String groupId, UserNames userNames) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage removeSingleBlockUser(String groupId, String userId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage removeSingleBlockUsers(String groupId, String[] userIds) {
        return HystrixResponse.invokeFail();
    }
}
