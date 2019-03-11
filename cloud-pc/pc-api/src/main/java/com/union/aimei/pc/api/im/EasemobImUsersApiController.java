package com.union.aimei.pc.api.im;

import com.union.aimei.common.model.im.ImUsers;
import com.union.aimei.common.vo.im.common.ResponseResult;
import com.union.aimei.common.feign.im.pc.EasemobImUsersFeign;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.client.model.RegisterUsers;
import io.swagger.client.model.User;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * IM用户 controller
 *
 * @author liurenkai
 * @time 2017/11/28 15:41
 */
@Api(tags = "IM用户 controller")
@RestController
@RequestMapping(value = "/easemob/im/users")
public class EasemobImUsersApiController {

    @Resource
    private EasemobImUsersFeign easemobImUsersFeign;

    /**
     * 注册 IM 用户[单个]
     *
     * @param user 用户
     * @return
     * @author liurenkai
     * @date 2017/11/30 18:18
     */
    @ApiOperation(httpMethod = "POST", value = "注册 IM 用户[单个]")
    @PostMapping("/register/single")
    public ResponseMessage<ImUsers> registerSingle(@ApiParam(value = "用户") @RequestBody User user) {
        return this.easemobImUsersFeign.registerSingle(user);
    }

    /**
     * 注册 IM 用户[批量]
     *
     * @param registerUsers 注册用户集合
     * @return
     * @author liurenkai
     * @date 2017/11/30 18:18
     */
    @ApiOperation(httpMethod = "POST", value = "注册 IM 用户[批量]")
    @PostMapping("/register/batch")
    public ResponseMessage<ResponseResult> registerBatch(@ApiParam(value = "注册用户集合") @RequestBody RegisterUsers registerUsers) {
        return this.easemobImUsersFeign.registerBatch(registerUsers);
    }

    /**
     * 获取 IM 用户[单个]
     *
     * @param userName 用户名
     * @return
     * @author liurenkai
     * @date 2017/11/30 18:18
     */
    @ApiOperation(httpMethod = "GET", value = "获取 IM 用户[单个]")
    @GetMapping("/get/{userName}")
    public ResponseMessage<ResponseResult> getByUserName(@ApiParam(value = "用户名") @PathVariable(value = "userName") String userName) {
        return this.easemobImUsersFeign.getByUserName(userName);
    }

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
    @GetMapping("/get/batch")
    public ResponseMessage<ResponseResult> getBatch(@ApiParam(value = "限制数") @RequestParam(value = "limit") int limit, @ApiParam(value = "游标") @RequestParam(value = "cursor") String cursor) {
        return this.easemobImUsersFeign.getBatch(limit, cursor);
    }

    /**
     * 删除 IM 用户[单个]
     *
     * @param userName 用户名
     * @return
     * @author liurenkai
     * @date 2017/11/30 18:18
     */
    @ApiOperation(httpMethod = "POST", value = "删除 IM 用户[单个]")
    @PostMapping("/delete/{userName}")
    public ResponseMessage<ResponseResult> deleteByUserName(@ApiParam(value = "用户名") @PathVariable(value = "userName") String userName) {
        return this.easemobImUsersFeign.deleteByUserName(userName);
    }

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
    @PostMapping("/delete/batch")
    public ResponseMessage<ResponseResult> deleteBatch(@ApiParam(value = "限制数") @RequestParam(value = "limit") int limit, @ApiParam(value = "游标") @RequestParam(value = "cursor") String cursor) {
        return this.easemobImUsersFeign.deleteBatch(limit, cursor);
    }

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
    @PostMapping("/modify/password/{userName}")
    public ResponseMessage<ResponseResult> modifyPassword(@ApiParam(value = "用户名") @PathVariable(value = "userName") String userName, @ApiParam(value = "新密码") @RequestParam(value = "newPassword") String newPassword) {
        return this.easemobImUsersFeign.modifyPassword(userName, newPassword);
    }

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
    @PostMapping("/modify/nickName/{userName}")
    public ResponseMessage<ResponseResult> modifyNickName(@ApiParam(value = "用户名") @PathVariable(value = "userName") String userName, @ApiParam(value = "昵称 ") @RequestParam(value = "nickName") String nickName) {
        return this.easemobImUsersFeign.modifyNickName(userName, nickName);
    }

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
    @PostMapping("/add/{userName}/friend/{friendName}")
    public ResponseMessage<ResponseResult> addFriendSingle(@ApiParam(value = "用户名") @PathVariable(value = "userName") String userName, @ApiParam(value = "好友用户名") @PathVariable(value = "friendName") String friendName) {
        return this.easemobImUsersFeign.addFriendSingle(userName, friendName);
    }

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
    @PostMapping("/delete/{userName}/friend/{friendName}")
    public ResponseMessage<ResponseResult> deleteFriendSingle(@ApiParam(value = "用户名") @PathVariable(value = "userName") String userName, @ApiParam(value = "好友用户名") @PathVariable(value = "friendName") String friendName) {
        return this.easemobImUsersFeign.deleteFriendSingle(userName, friendName);
    }

    /**
     * 获取 IM 用户的好友列表
     *
     * @param userName 用户名
     * @return
     * @author liurenkai
     * @date 2017/11/30 15:43
     */
    @ApiOperation(httpMethod = "GET", value = "获取 IM 用户的好友列表")
    @GetMapping("/get/friend/{userName}")
    public ResponseMessage<ResponseResult> getFriends(@ApiParam(value = "用户名") @PathVariable(value = "userName") String userName) {
        return this.easemobImUsersFeign.getFriends(userName);
    }

    /**
     * 获取 IM 用户的黑名单
     *
     * @param userName 用户名
     * @return
     * @author liurenkai
     * @date 2017/11/30 15:43
     */
    @ApiOperation(httpMethod = "GET", value = "获取 IM 用户的黑名单")
    @GetMapping("/get/blackList/{userName}")
    public ResponseMessage<ResponseResult> getBlackList(@ApiParam(value = "用户名") @PathVariable(value = "userName") String userName) {
        return this.easemobImUsersFeign.getBlackList(userName);
    }

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
    @GetMapping("/add/blackList/{userName}")
    public ResponseMessage<ResponseResult> addToBlackList(@ApiParam(value = "用户名") @PathVariable(value = "userName") String userName, @ApiParam(value = "需要加入到黑名单中的用户名") @PathVariable(value = "userNames") String userNames) {
        return this.easemobImUsersFeign.addToBlackList(userName, userNames);
    }

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
    @PostMapping("/remove/blackList/{userName}")
    public ResponseMessage<ResponseResult> removeFromBlackList(@ApiParam(value = "用户名") @PathVariable(value = "userName") String userName, @ApiParam(value = "黑名单用户名") @PathVariable(value = "blackListName") String blackListName) {
        return this.easemobImUsersFeign.removeFromBlackList(userName, blackListName);
    }

    /**
     * 查看用户在线状态
     *
     * @param userName 用户名
     * @return
     * @author liurenkai
     * @date 2017/11/30 15:43
     */
    @ApiOperation(httpMethod = "GET", value = "查看用户在线状态")
    @GetMapping("/get/status/{userName}")
    public ResponseMessage<ResponseResult> getStatus(@ApiParam(value = "用户名") @PathVariable(value = "userName") String userName) {
        return this.easemobImUsersFeign.getStatus(userName);
    }


    /**
     * 查看用户集合在线状态
     *
     * @param userNameList 用户名集合
     * @return
     * @author liurenkai
     * @date 2017/11/30 15:43
     */
    @ApiOperation(httpMethod = "GET", value = "查看用户集合在线状态")
    @GetMapping("/get/status/batch")
    public ResponseMessage<List<ResponseResult>> getStatus(@ApiParam(value = "用户名") @RequestParam(value = "userNameList") List<String> userNameList) {
        return this.easemobImUsersFeign.getStatusBatch(userNameList);
    }

    /**
     * 查询离线消息数
     *
     * @param userName 用户名
     * @return
     * @author liurenkai
     * @date 2017/11/30 15:43
     */
    @ApiOperation(httpMethod = "GET", value = "查询离线消息数")
    @GetMapping("/get/OfflineMsgCount/{userName}")
    public ResponseMessage<ResponseResult> getOfflineMsgCount(@ApiParam(value = "用户名") @PathVariable(value = "userName") String userName) {
        return this.easemobImUsersFeign.getOfflineMsgCount(userName);
    }

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
    @GetMapping("/get/specifiedOfflineMsgStatus/{userName}")
    public ResponseMessage<ResponseResult> getSpecifiedOfflineMsgStatus(@ApiParam(value = "用户名") @PathVariable(value = "userName") String userName, @ApiParam(value = "离线消息ID") @PathVariable(value = "msgId") String msgId) {
        return this.easemobImUsersFeign.getSpecifiedOfflineMsgStatus(userName, msgId);
    }

    /**
     * 用户账号禁用
     *
     * @param userName 用户名
     * @return
     * @author liurenkai
     * @date 2017/11/30 15:43
     */
    @ApiOperation(httpMethod = "GET", value = "用户账号禁用")
    @GetMapping("/deactivate/{userName}")
    public ResponseMessage<ResponseResult> deactivate(@ApiParam(value = "用户名") @PathVariable(value = "userName") String userName) {
        return this.easemobImUsersFeign.deactivate(userName);
    }

    /**
     * 用户账号解禁
     *
     * @param userName 用户名
     * @return
     * @author liurenkai
     * @date 2017/11/30 15:43
     */
    @ApiOperation(httpMethod = "GET", value = "用户账号解禁")
    @GetMapping("/activate/{userName}")
    public ResponseMessage<ResponseResult> activate(@ApiParam(value = "用户名") @PathVariable(value = "userName") String userName) {
        return this.easemobImUsersFeign.activate(userName);
    }

    /**
     * 强制用户下线
     *
     * @param userName 用户名
     * @return
     * @author liurenkai
     * @date 2017/11/30 15:43
     */
    @ApiOperation(httpMethod = "GET", value = "强制用户下线")
    @GetMapping("/disconnect/{userName}")
    public ResponseMessage<ResponseResult> disconnect(@ApiParam(value = "用户名") @PathVariable(value = "userName") String userName) {
        return this.easemobImUsersFeign.activate(userName);
    }

    /**
     * 用户登录
     *
     * @param userName 用户名
     * @param password 密码
     * @return
     * @author liurenkai
     * @date 2017/11/30 18:18
     */
    @ApiOperation(httpMethod = "POST", value = "用户登录")
    @PostMapping("/login")
    public ResponseMessage login(@ApiParam(value = "用户名") @RequestParam(value = "userName") String userName,
                                                 @ApiParam(value = "密码") @RequestParam(value = "password") String password) {
        return this.easemobImUsersFeign.login(userName, password);
    }
}