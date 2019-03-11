package com.union.aimei.im.service.impl;

import com.google.gson.Gson;
import com.union.aimei.im.easemob.api.impl.EasemobChatGroup;
import com.union.aimei.common.model.im.ImChatGroups;
import com.union.aimei.im.mapper.ImChatGroupsMapper;
import com.union.aimei.im.service.EasemobImChatGroupsService;
import com.union.aimei.common.vo.im.common.ResponseResult;
import com.union.common.utils.AssertUtil;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseMessageFactory;
import com.union.common.utils.constant.ResponseContants;
import io.swagger.client.model.Group;
import io.swagger.client.model.ModifyGroup;
import io.swagger.client.model.NewOwner;
import io.swagger.client.model.UserNames;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * IM群组 api impl
 *
 * @author liurenkai
 * @time 2017/11/30 11:30
 */
@Service("easemobImChatGroupsService")
public class EasemobImChatGroupsServiceImpl implements EasemobImChatGroupsService {
    @Resource
    private ImChatGroupsMapper imChatGroupsMapper;

    @Override
    public ResponseMessage getLimit(long limit, String cursor) {
        ResponseMessage responseMessage = ResponseMessageFactory.newInstance();
        EasemobChatGroup easemobChatGroup = new EasemobChatGroup();
        Object responseObject = easemobChatGroup.getChatGroups(limit, cursor);
        if (null == responseObject) {
            AssertUtil.numberGtZero(null, ResponseContants.QUERY_EMPTY_MESSAGE, ResponseContants.QUERY_EMPTY);
        }
        ResponseResult responseResult = new Gson().fromJson(responseObject.toString(), ResponseResult.class);
        responseMessage.setData(responseResult.getData());
        return responseMessage;
    }

    @Override
    public ResponseMessage getDetails(String groupId) {
        ResponseMessage responseMessage = ResponseMessageFactory.newInstance();
        EasemobChatGroup easemobChatGroup = new EasemobChatGroup();
        Object responseObject = easemobChatGroup.getChatGroupDetails(new String[]{groupId});
        if (null == responseObject) {
            AssertUtil.numberGtZero(null, ResponseContants.QUERY_EMPTY_MESSAGE, ResponseContants.QUERY_EMPTY);
        }
        ResponseResult responseResult = new Gson().fromJson(responseObject.toString(), ResponseResult.class);
        responseMessage.setData(responseResult.getData());
        return responseMessage;
    }

    @Override
    public ResponseMessage<ImChatGroups> create(Group group) {
        ResponseMessage responseMessage = ResponseMessageFactory.newInstance();
        EasemobChatGroup easemobChatGroup = new EasemobChatGroup();
        Object responseObject = easemobChatGroup.createChatGroup(group);
        if (null == responseObject) {
            AssertUtil.numberGtZero(null, ResponseContants.ADD_MESSAGE, ResponseContants.ADD);
        }
        ResponseResult responseResult = new Gson().fromJson(responseObject.toString(), ResponseResult.class);
        responseMessage.setData(responseResult.getData());
        return responseMessage;
    }

    @Override
    public ResponseMessage modify(String groupId, ModifyGroup modifyGroup) {
        ResponseMessage responseMessage = ResponseMessageFactory.newInstance();
        EasemobChatGroup easemobChatGroup = new EasemobChatGroup();
        Object responseObject = easemobChatGroup.modifyChatGroup(groupId, modifyGroup);
        if (null == responseObject) {
            AssertUtil.numberGtZero(null, ResponseContants.ADD_MESSAGE, ResponseContants.ADD);
        }
        ResponseResult responseResult = new Gson().fromJson(responseObject.toString(), ResponseResult.class);
        responseMessage.setData(responseResult.getData());
        return responseMessage;
    }

    @Override
    public ResponseMessage delete(String groupId) {
        ResponseMessage responseMessage = ResponseMessageFactory.newInstance();
        EasemobChatGroup easemobChatGroup = new EasemobChatGroup();
        Object responseObject = easemobChatGroup.deleteChatGroup(groupId);
        if (null == responseObject) {
            AssertUtil.numberGtZero(null, ResponseContants.ADD_MESSAGE, ResponseContants.ADD);
        }
        ResponseResult responseResult = new Gson().fromJson(responseObject.toString(), ResponseResult.class);
        responseMessage.setData(responseResult.getData());
        return responseMessage;
    }

    @Override
    public ResponseMessage getUsers(String groupId) {
        ResponseMessage responseMessage = ResponseMessageFactory.newInstance();
        EasemobChatGroup easemobChatGroup = new EasemobChatGroup();
        Object responseObject = easemobChatGroup.getChatGroupUsers(groupId);
        if (null == responseObject) {
            AssertUtil.numberGtZero(null, ResponseContants.ADD_MESSAGE, ResponseContants.ADD);
        }
        ResponseResult responseResult = new Gson().fromJson(responseObject.toString(), ResponseResult.class);
        responseMessage.setData(responseResult.getData());
        return responseMessage;
    }

    @Override
    public ResponseMessage addSingleUser(String groupId, String userId) {
        ResponseMessage responseMessage = ResponseMessageFactory.newInstance();
        EasemobChatGroup easemobChatGroup = new EasemobChatGroup();
        Object responseObject = easemobChatGroup.addSingleUserToChatGroup(groupId, userId);
        if (null == responseObject) {
            AssertUtil.numberGtZero(null, ResponseContants.ADD_MESSAGE, ResponseContants.ADD);
        }
        ResponseResult responseResult = new Gson().fromJson(responseObject.toString(), ResponseResult.class);
        responseMessage.setData(responseResult.getData());
        return responseMessage;
    }

    @Override
    public ResponseMessage addBatchUsers(String groupId, UserNames userNames) {
        ResponseMessage responseMessage = ResponseMessageFactory.newInstance();
        EasemobChatGroup easemobChatGroup = new EasemobChatGroup();
        Object responseObject = easemobChatGroup.addBatchUsersToChatGroup(groupId, userNames);
        if (null == responseObject) {
            AssertUtil.numberGtZero(null, ResponseContants.ADD_MESSAGE, ResponseContants.ADD);
        }
        ResponseResult responseResult = new Gson().fromJson(responseObject.toString(), ResponseResult.class);
        responseMessage.setData(responseResult.getData());
        return responseMessage;
    }

    @Override
    public ResponseMessage removeSingleUser(String groupId, String userId) {
        ResponseMessage responseMessage = ResponseMessageFactory.newInstance();
        EasemobChatGroup easemobChatGroup = new EasemobChatGroup();
        Object responseObject = easemobChatGroup.removeSingleUserFromChatGroup(groupId, userId);
        if (null == responseObject) {
            AssertUtil.numberGtZero(null, ResponseContants.ADD_MESSAGE, ResponseContants.ADD);
        }
        ResponseResult responseResult = new Gson().fromJson(responseObject.toString(), ResponseResult.class);
        responseMessage.setData(responseResult.getData());
        return responseMessage;
    }

    @Override
    public ResponseMessage removeBatchUsers(String groupId, String[] userIds) {
        ResponseMessage responseMessage = ResponseMessageFactory.newInstance();
        EasemobChatGroup easemobChatGroup = new EasemobChatGroup();
        Object responseObject = easemobChatGroup.removeBatchUsersFromChatGroup(groupId, userIds);
        if (null == responseObject) {
            AssertUtil.numberGtZero(null, ResponseContants.ADD_MESSAGE, ResponseContants.ADD);
        }
        ResponseResult responseResult = new Gson().fromJson(responseObject.toString(), ResponseResult.class);
        responseMessage.setData(responseResult.getData());
        return responseMessage;
    }

    @Override
    public ResponseMessage transferOwner(String groupId, NewOwner newOwner) {
        ResponseMessage responseMessage = ResponseMessageFactory.newInstance();
        EasemobChatGroup easemobChatGroup = new EasemobChatGroup();
        Object responseObject = easemobChatGroup.transferChatGroupOwner(groupId, newOwner);
        if (null == responseObject) {
            AssertUtil.numberGtZero(null, ResponseContants.ADD_MESSAGE, ResponseContants.ADD);
        }
        ResponseResult responseResult = new Gson().fromJson(responseObject.toString(), ResponseResult.class);
        responseMessage.setData(responseResult.getData());
        return responseMessage;
    }

    @Override
    public ResponseMessage addSingleBlockUser(String groupId, String userId) {
        ResponseMessage responseMessage = ResponseMessageFactory.newInstance();
        EasemobChatGroup easemobChatGroup = new EasemobChatGroup();
        Object responseObject = easemobChatGroup.addSingleBlockUserToChatGroup(groupId, userId);
        if (null == responseObject) {
            AssertUtil.numberGtZero(null, ResponseContants.ADD_MESSAGE, ResponseContants.ADD);
        }
        ResponseResult responseResult = new Gson().fromJson(responseObject.toString(), ResponseResult.class);
        responseMessage.setData(responseResult.getData());
        return responseMessage;
    }

    @Override
    public ResponseMessage addBatchBlockUsers(String groupId, UserNames userNames) {
        ResponseMessage responseMessage = ResponseMessageFactory.newInstance();
        EasemobChatGroup easemobChatGroup = new EasemobChatGroup();
        Object responseObject = easemobChatGroup.addBatchBlockUsersToChatGroup(groupId, userNames);
        if (null == responseObject) {
            AssertUtil.numberGtZero(null, ResponseContants.ADD_MESSAGE, ResponseContants.ADD);
        }
        ResponseResult responseResult = new Gson().fromJson(responseObject.toString(), ResponseResult.class);
        responseMessage.setData(responseResult.getData());
        return responseMessage;
    }

    @Override
    public ResponseMessage removeSingleBlockUser(String groupId, String userId) {
        ResponseMessage responseMessage = ResponseMessageFactory.newInstance();
        EasemobChatGroup easemobChatGroup = new EasemobChatGroup();
        Object responseObject = easemobChatGroup.removeSingleBlockUserFromChatGroup(groupId, userId);
        if (null == responseObject) {
            AssertUtil.numberGtZero(null, ResponseContants.ADD_MESSAGE, ResponseContants.ADD);
        }
        ResponseResult responseResult = new Gson().fromJson(responseObject.toString(), ResponseResult.class);
        responseMessage.setData(responseResult.getData());
        return responseMessage;
    }

    @Override
    public ResponseMessage removeSingleBlockUser(String groupId, String[] userIds) {
        ResponseMessage responseMessage = ResponseMessageFactory.newInstance();
        EasemobChatGroup easemobChatGroup = new EasemobChatGroup();
        Object responseObject = easemobChatGroup.removeBatchBlockUsersFromChatGroup(groupId, userIds);
        if (null == responseObject) {
            AssertUtil.numberGtZero(null, ResponseContants.ADD_MESSAGE, ResponseContants.ADD);
        }
        ResponseResult responseResult = new Gson().fromJson(responseObject.toString(), ResponseResult.class);
        responseMessage.setData(responseResult.getData());
        return responseMessage;
    }

}