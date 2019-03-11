package com.union.aimei.im.service;

import com.union.aimei.common.model.im.ImUsers;
import com.union.aimei.common.vo.im.common.ResponseResult;
import com.union.common.utils.ResponseMessage;
import io.swagger.client.model.RegisterUsers;
import io.swagger.client.model.User;

import java.util.List;

/**
 * IM用户service
 *
 * @author liurenkai
 * @time 2017/11/28 15:44
 */
public interface EasemobImUsersService {

    /**
     * 注册 IM 用户[单个]
     *
     * @param user 用户
     * @return
     */
    ResponseMessage<ImUsers> registerSingle(User user);

    /**
     * 注册 IM 用户[批量]
     *
     * @param registerUsers 注册用户集合
     * @return
     */
    ResponseMessage<ResponseResult> registerBatch(RegisterUsers registerUsers);


    /**
     * 获取 IM 用户[单个]
     *
     * @param userName 用户名
     * @return
     */
    ResponseMessage<ResponseResult> getByUserName(String userName);

    /**
     * 获取 IM 用户[批量]
     *
     * @param limit  限制数
     * @param cursor 游标
     * @return
     */
    ResponseMessage<ResponseResult> getBatch(long limit, String cursor);

    /**
     * 删除 IM 用户[单个]
     *
     * @param userName 用户名
     * @return
     */
    ResponseMessage<ResponseResult> deleteByUserName(String userName);

    /**
     * 删除 IM 用户[批量]
     *
     * @param limit  限制数
     * @param cursor 游标
     * @return
     */
    ResponseMessage<ResponseResult> deleteBatch(long limit, String cursor);

    /**
     * 重置 IM 用户密码
     *
     * @param userName    用户名
     * @param newPassword 新密码
     * @return
     */
    ResponseMessage<ResponseResult> modifyPassword(String userName, String newPassword);

    /**
     * 修改用户推送显示昵称
     *
     * @param userName 用户名
     * @param nickName 昵称
     * @return
     */
    ResponseMessage<ResponseResult> modifyNickName(String userName, String nickName);

    /**
     * 给 IM 用户添加好友
     *
     * @param userName   用户名
     * @param friendName 好友用户名
     * @return
     * @author liurenkai
     * @date 2017/11/30 15:43
     */
    ResponseMessage<ResponseResult> addFriendSingle(String userName, String friendName);

    /**
     * 解除 IM 用户的好友关系
     *
     * @param userName   用户名
     * @param friendName 好友用户名
     * @return
     * @author liurenkai
     * @date 2017/11/30 15:43
     */
    ResponseMessage<ResponseResult> deleteFriendSingle(String userName, String friendName);

    /**
     * 获取 IM 用户的好友列表
     *
     * @param userName 用户名
     * @return
     * @author liurenkai
     * @date 2017/11/30 15:43
     */
    ResponseMessage<ResponseResult> getFriends(String userName);

    /**
     * 获取 IM 用户的黑名单
     *
     * @param userName 用户名
     * @return
     * @author liurenkai
     * @date 2017/11/30 15:43
     */
    ResponseMessage<ResponseResult> getBlackList(String userName);

    /**
     * 往 IM 用户的黑名单中加人
     *
     * @param userName  用户名
     * @param userNames 需要加入到黑名单中的用户名
     * @return
     * @author liurenkai
     * @date 2017/11/30 15:43
     */
    ResponseMessage<ResponseResult> addToBlackList(String userName, String userNames);

    /**
     * 从 IM 用户的黑名单中减人
     *
     * @param userName      用户名
     * @param blackListName 黑名单用户名
     * @return
     * @author liurenkai
     * @date 2017/11/30 15:43
     */
    ResponseMessage<ResponseResult> removeFromBlackList(String userName, String blackListName);

    /**
     * 查看用户在线状态
     *
     * @param userName 用户名
     * @return
     * @author liurenkai
     * @date 2017/11/30 15:43
     */
    ResponseMessage<ResponseResult> getStatus(String userName);

    /**
     * 查看用户集合在线状态
     *
     * @param userNameList 用户名集合
     * @return
     * @author liurenkai
     * @date 2017/11/30 15:43
     */
    ResponseMessage<List<ResponseResult>> getStatusBatch(List<String> userNameList);

    /**
     * 查询离线消息数
     *
     * @param userName 用户名
     * @return
     * @author liurenkai
     * @date 2017/11/30 15:43
     */
    ResponseMessage<ResponseResult> getOfflineMsgCount(String userName);

    /**
     * 查询某条离线消息状态
     *
     * @param userName 用户名
     * @param msgId    离线消息ID
     * @return
     * @author liurenkai
     * @date 2017/11/30 15:43
     */
    ResponseMessage<ResponseResult> getSpecifiedOfflineMsgStatus(String userName, String msgId);

    /**
     * 用户账号禁用
     *
     * @param userName 用户名
     * @return
     * @author liurenkai
     * @date 2017/11/30 15:43
     */
    ResponseMessage<ResponseResult> deactivate(String userName);

    /**
     * 用户账号解禁
     *
     * @param userName 用户名
     * @return
     * @author liurenkai
     * @date 2017/11/30 15:43
     */
    ResponseMessage<ResponseResult> activate(String userName);

    /**
     * 强制用户下线
     *
     * @param userName 用户名
     * @return
     * @author liurenkai
     * @date 2017/11/30 15:43
     */
    ResponseMessage<ResponseResult> disconnect(String userName);

    /**
     * 用户登录
     *
     * @param userName 用户名
     * @param password 密码
     * @return
     */
    ResponseMessage login(String userName, String password);

}