package com.union.aimei.im.service;

import com.union.aimei.common.model.im.ImChatGroups;
import com.union.common.utils.ResponseMessage;
import io.swagger.client.model.Group;
import io.swagger.client.model.ModifyGroup;
import io.swagger.client.model.NewOwner;
import io.swagger.client.model.UserNames;

/**
 * IM用户群组 api
 *
 * @author liurenkai
 * @time 2017/11/30 11:26
 */
public interface EasemobImChatGroupsService {

    /**
     * 分页获取 APP 下的群组
     *
     * @param limit  限制数
     * @param cursor 游标，如果数据还有下一页，API 返回值会包含此字段，字符类型。
     * @return
     * @author liurenkai
     * @date 2017/11/30 14:54
     */
    ResponseMessage<ImChatGroups> getLimit(long limit, String cursor);

    /**
     * 获取群组详情
     *
     * @param groupId 群组ID
     * @return
     * @author liurenkai
     * @date 2017/11/30 14:54
     */
    ResponseMessage<ImChatGroups> getDetails(String groupId);

    /**
     * 创建一个群组
     *
     * @param group IM群组
     * @return
     * @author liurenkai
     * @date 2017/11/30 11:29
     */
    ResponseMessage<ImChatGroups> create(Group group);

    /**
     * 修改群组信息
     *
     * @param groupId     群组ID
     * @param modifyGroup 修改群组
     * @return
     * @author liurenkai
     * @date 2017/11/30 14:18
     */
    ResponseMessage modify(String groupId, ModifyGroup modifyGroup);

    /**
     * 删除群组
     *
     * @param groupId 群组ID
     * @return
     * @author liurenkai
     * @date 2017/11/30 14:46
     */
    ResponseMessage delete(String groupId);

    /**
     * 获取群组成员
     *
     * @param groupId 群组ID
     * @return
     * @author liurenkai
     * @date 2017/11/30 14:46
     */
    ResponseMessage getUsers(String groupId);

    /**
     * 添加群组成员[单个]
     *
     * @param groupId 群组ID
     * @param userId  用户ID
     * @return
     * @author liurenkai
     * @date 2017/11/30 14:46
     */
    ResponseMessage addSingleUser(String groupId, String userId);

    /**
     * 添加群组成员[批量]
     *
     * @param groupId   群组ID
     * @param userNames 用户名集合
     * @return
     * @author liurenkai
     * @date 2017/11/30 14:46
     */
    ResponseMessage addBatchUsers(String groupId, UserNames userNames);

    /**
     * 移除群组成员[单个]
     *
     * @param groupId 群组ID
     * @param userId  用户ID
     * @return
     * @author liurenkai
     * @date 2017/11/30 14:46
     */
    ResponseMessage removeSingleUser(String groupId, String userId);

    /**
     * 移除群组成员[批量]
     *
     * @param groupId 群组ID
     * @param userIds 用户ID集合
     * @return
     * @author liurenkai
     * @date 2017/11/30 14:46
     */
    ResponseMessage removeBatchUsers(String groupId, String[] userIds);

    /**
     * 转让群组
     *
     * @param groupId  群组ID
     * @param newOwner 新群主
     * @return
     * @author liurenkai
     * @date 2017/11/30 14:46
     */
    ResponseMessage transferOwner(String groupId, NewOwner newOwner);

    /**
     * 添加用户至群组黑名单[单个]
     *
     * @param groupId 群组ID
     * @param userId  用户ID
     * @return
     * @author liurenkai
     * @date 2017/11/30 14:46
     */
    ResponseMessage addSingleBlockUser(String groupId, String userId);

    /**
     * 添加用户至群组黑名单[批量]
     *
     * @param groupId   群组ID
     * @param userNames 用户名集合
     * @return
     * @author liurenkai
     * @date 2017/11/30 14:46
     */
    ResponseMessage addBatchBlockUsers(String groupId, UserNames userNames);

    /**
     * 从群组黑名单移除用户[单个]
     *
     * @param groupId 群组ID
     * @param userId  用户ID
     * @return
     * @author liurenkai
     * @date 2017/11/30 14:46
     */
    ResponseMessage removeSingleBlockUser(String groupId, String userId);

    /**
     * 从群组黑名单移除用户[批量]
     *
     * @param groupId 群组ID
     * @param userIds 用户ID集合
     * @return
     * @author liurenkai
     * @date 2017/11/30 14:46
     */
    ResponseMessage removeSingleBlockUser(String groupId, String[] userIds);


}