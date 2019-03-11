package com.union.aimei.common.feign.app.im;

import com.union.aimei.common.feign.app.im.hystrix.EasemobImUsersFeignHystrix;
import com.union.aimei.common.model.im.ImUsers;
import com.union.aimei.common.vo.im.common.ResponseResult;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.client.model.RegisterUsers;
import io.swagger.client.model.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * IM用户service
 *
 * @author liurenkai
 * @time 2017/11/28 15:44
 */
@FeignClient(serviceId = "APP-IM-SERVICE", fallback = EasemobImUsersFeignHystrix.class)
public interface EasemobImUsersFeign {

    /**
     * 注册 IM 用户[单个]
     *
     * @param user 用户
     * @return
     * @author liurenkai
     * @date 2017/11/30 18:18
     */
    @ApiOperation(httpMethod = "POST", value = "注册 IM 用户[单个]")
    @PostMapping("/easemob/im/users/register/single")
    ResponseMessage<ImUsers> registerSingle(@ApiParam(value = "用户") @RequestBody User user);

    /**
     * 注册 IM 用户[批量]
     *
     * @param registerUsers 注册用户集合
     * @return
     * @author liurenkai
     * @date 2017/11/30 18:18
     */
    @ApiOperation(httpMethod = "POST", value = "注册 IM 用户[批量]")
    @PostMapping("/easemob/im/users/register/batch")
    ResponseMessage<ResponseResult> registerBatch(@ApiParam(value = "注册用户集合") @RequestBody RegisterUsers registerUsers);

    /**
     * 获取 IM 用户[单个]
     *
     * @param userName 用户名
     * @return
     * @author liurenkai
     * @date 2017/11/30 18:18
     */
    @ApiOperation(httpMethod = "GET", value = "获取 IM 用户[单个]")
    @GetMapping("/easemob/im/users/get/{userName}")
    ResponseMessage<ResponseResult> getByUserName(@ApiParam(value = "用户名") @PathVariable(value = "userName") String userName);

    /**
     * 获取 IM 用户[批量]
     *
     * @param limit  限制数
     * @param cursor 游标
     * @return
     * @author liurenkai
     * @date 2017/11/30 18:18
     */
    @ApiOperation(httpMethod = "GET", value = "获取 IM 用户[批量]")
    @GetMapping("/easemob/im/users/get/batch")
    ResponseMessage<ResponseResult> getBatch(@ApiParam(value = "限制数") @RequestParam(value = "limit") long limit, @ApiParam(value = "游标") @RequestParam(value = "cursor") String cursor);

    /**
     * 删除 IM 用户[单个]
     *
     * @param userName 用户名
     * @return
     * @author liurenkai
     * @date 2017/11/30 18:18
     */
    @ApiOperation(httpMethod = "POST", value = "删除 IM 用户[单个]")
    @PostMapping("/easemob/im/users/delete/{userName}")
    ResponseMessage<ResponseResult> deleteByUserName(@ApiParam(value = "用户名") @PathVariable(value = "userName") String userName);

    /**
     * 删除 IM 用户[批量]
     *
     * @param limit  限制数
     * @param cursor 游标
     * @return
     * @author liurenkai
     * @date 2017/11/30 18:18
     */
    @ApiOperation(httpMethod = "POST", value = "删除 IM 用户[批量]")
    @PostMapping("/easemob/im/users/delete/batch")
    ResponseMessage<ResponseResult> deleteBatch(@ApiParam(value = "限制数") @RequestParam(value = "limit") long limit, @ApiParam(value = "游标") @RequestParam(value = "cursor") String cursor);

    /**
     * 重置 IM 用户密码
     *
     * @param userName    用户名
     * @param newPassword 新密码
     * @return
     * @author liurenkai
     * @date 2017/11/30 18:18
     */
    @ApiOperation(httpMethod = "POST", value = "重置 IM 用户密码")
    @PostMapping("/easemob/im/users/modify/password/{userName}")
    ResponseMessage<ResponseResult> modifyPassword(@ApiParam(value = "用户名") @PathVariable(value = "userName") String userName, @ApiParam(value = "新密码") @RequestParam(value = "newPassword") String newPassword);

    /**
     * 修改用户推送显示昵称
     *
     * @param userName 用户名
     * @param nickName 昵称
     * @return
     * @author liurenkai
     * @date 2017/11/30 18:18
     */
    @ApiOperation(httpMethod = "POST", value = "修改用户推送显示昵称")
    @PostMapping("/easemob/im/users/modify/nickName/{userName}")
    ResponseMessage<ResponseResult> modifyNickName(@ApiParam(value = "用户名") @PathVariable(value = "userName") String userName, @ApiParam(value = "昵称 ") @RequestParam(value = "nickName") String nickName);

    /**
     * 给 IM 用户添加好友
     *
     * @param userName   用户名
     * @param friendName 好友用户名
     * @return
     * @author liurenkai
     * @date 2017/11/30 15:43
     */
    @ApiOperation(httpMethod = "POST", value = "给 IM 用户添加好友")
    @PostMapping("/easemob/im/users/add/{userName}/friend/{friendName}")
    ResponseMessage<ResponseResult> addFriendSingle(@ApiParam(value = "用户名") @PathVariable(value = "userName") String userName, @ApiParam(value = "好友用户名") @PathVariable(value = "friendName") String friendName);

    /**
     * 解除 IM 用户的好友关系
     *
     * @param userName   用户名
     * @param friendName 好友用户名
     * @return
     * @author liurenkai
     * @date 2017/11/30 15:43
     */
    @ApiOperation(httpMethod = "POST", value = "给 IM 用户添加好友")
    @PostMapping("/easemob/im/users/delete/{userName}/friend/{friendName}")
    ResponseMessage<ResponseResult> deleteFriendSingle(@ApiParam(value = "用户名") @PathVariable(value = "userName") String userName, @ApiParam(value = "好友用户名") @PathVariable(value = "friendName") String friendName);

    /**
     * 获取 IM 用户的好友列表
     *
     * @param userName 用户名
     * @return
     * @author liurenkai
     * @date 2017/11/30 15:43
     */
    @ApiOperation(httpMethod = "GET", value = "获取 IM 用户的好友列表")
    @GetMapping("/easemob/im/users/get/friend/{userName}")
    ResponseMessage<ResponseResult> getFriends(@ApiParam(value = "用户名") @PathVariable(value = "userName") String userName);

    /**
     * 获取 IM 用户的黑名单
     *
     * @param userName 用户名
     * @return
     * @author liurenkai
     * @date 2017/11/30 15:43
     */
    @ApiOperation(httpMethod = "GET", value = "获取 IM 用户的黑名单")
    @GetMapping("/easemob/im/users/get/blackList/{userName}")
    ResponseMessage<ResponseResult> getBlackList(@ApiParam(value = "用户名") @PathVariable(value = "userName") String userName);

    /**
     * 往 IM 用户的黑名单中加人
     *
     * @param userName  用户名
     * @param userNames 需要加入到黑名单中的用户名
     * @return
     * @author liurenkai
     * @date 2017/11/30 15:43
     */
    @ApiOperation(httpMethod = "GET", value = "往 IM 用户的黑名单中加人")
    @GetMapping("/easemob/im/users/add/blackList/{userName}")
    ResponseMessage<ResponseResult> addToBlackList(@ApiParam(value = "用户名") @PathVariable(value = "userName") String userName, @ApiParam(value = "需要加入到黑名单中的用户名") @PathVariable(value = "userNames") String userNames);

    /**
     * 从 IM 用户的黑名单中减人
     *
     * @param userName      用户名
     * @param blackListName 黑名单用户名
     * @return
     * @author liurenkai
     * @date 2017/11/30 15:43
     */
    @ApiOperation(httpMethod = "POST", value = "从 IM 用户的黑名单中减人")
    @PostMapping("/easemob/im/users/remove/blackList/{userName}")
    ResponseMessage<ResponseResult> removeFromBlackList(@ApiParam(value = "用户名") @PathVariable(value = "userName") String userName, @ApiParam(value = "黑名单用户名") @PathVariable(value = "blackListName") String blackListName);

    /**
     * 查看用户在线状态
     *
     * @param userName 用户名
     * @return
     * @author liurenkai
     * @date 2017/11/30 15:43
     */
    @ApiOperation(httpMethod = "GET", value = "查看用户在线状态")
    @GetMapping("/easemob/im/users/get/status/{userName}")
    ResponseMessage<ResponseResult> getStatus(@ApiParam(value = "用户名") @PathVariable(value = "userName") String userName);

    /**
     * 查看用户集合在线状态
     *
     * @param userNameList 用户名集合
     * @return
     * @author liurenkai
     * @date 2017/11/30 15:43
     */
    @ApiOperation(httpMethod = "GET", value = "查看用户集合在线状态")
    @GetMapping("/easemob/im/users/get/status/batch")
    ResponseMessage<List<ResponseResult>> getStatusBatch(@ApiParam(value = "用户名") @RequestParam(value = "userNameList") List<String> userNameList);

    /**
     * 查询离线消息数
     *
     * @param userName 用户名
     * @return
     * @author liurenkai
     * @date 2017/11/30 15:43
     */
    @ApiOperation(httpMethod = "GET", value = "查询离线消息数")
    @GetMapping("/easemob/im/users/get/OfflineMsgCount/{userName}")
    ResponseMessage<ResponseResult> getOfflineMsgCount(@ApiParam(value = "用户名") @PathVariable(value = "userName") String userName);

    /**
     * 查询某条离线消息状态
     *
     * @param userName 用户名
     * @param msgId    离线消息ID
     * @return
     * @author liurenkai
     * @date 2017/11/30 15:43
     */
    @ApiOperation(httpMethod = "GET", value = "查询离线消息数")
    @GetMapping("/easemob/im/users/get/specifiedOfflineMsgStatus/{userName}")
    ResponseMessage<ResponseResult> getSpecifiedOfflineMsgStatus(@ApiParam(value = "用户名") @PathVariable(value = "userName") String userName, @ApiParam(value = "离线消息ID") @PathVariable(value = "msgId") String msgId);

    /**
     * 用户账号禁用
     *
     * @param userName 用户名
     * @return
     * @author liurenkai
     * @date 2017/11/30 15:43
     */
    @ApiOperation(httpMethod = "GET", value = "用户账号禁用")
    @GetMapping("/easemob/im/users/deactivate/{userName}")
    ResponseMessage<ResponseResult> deactivate(@ApiParam(value = "用户名") @PathVariable(value = "userName") String userName);

    /**
     * 用户账号解禁
     *
     * @param userName 用户名
     * @return
     * @author liurenkai
     * @date 2017/11/30 15:43
     */
    @ApiOperation(httpMethod = "GET", value = "用户账号解禁")
    @GetMapping("/easemob/im/users/activate/{userName}")
    ResponseMessage<ResponseResult> activate(@ApiParam(value = "用户名") @PathVariable(value = "userName") String userName);

    /**
     * 强制用户下线
     *
     * @param userName 用户名
     * @return
     * @author liurenkai
     * @date 2017/11/30 15:43
     */
    @ApiOperation(httpMethod = "GET", value = "强制用户下线")
    @GetMapping("/easemob/im/users/disconnect/{userName}")
    ResponseMessage<ResponseResult> disconnect(@ApiParam(value = "用户名") @PathVariable(value = "userName") String userName);

    /**
     * 用户登录
     *
     * @param userName 用户名
     * @param password 密码
     * @return
     * @author liurenkai
     * @date 2017/11/30 15:43
     */
    @ApiOperation(httpMethod = "POST", value = "用户登录")
    @PostMapping("/easemob/im/users/login")
    ResponseMessage login(@ApiParam(value = "用户名") @RequestParam(value = "userName") String userName,
                          @ApiParam(value = "密码") @RequestParam(value = "password") String password);

}