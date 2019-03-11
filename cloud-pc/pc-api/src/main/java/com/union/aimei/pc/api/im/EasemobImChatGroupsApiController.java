package com.union.aimei.pc.api.im;

import com.union.aimei.common.feign.im.pc.EasemobImChatGroupsFeign;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.client.model.Group;
import io.swagger.client.model.ModifyGroup;
import io.swagger.client.model.NewOwner;
import io.swagger.client.model.UserNames;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * IM群组controller
 *
 * @author liurenkai
 * @time 2017/11/29 16:35
 */
@Api(tags = "IM群组 controller")
@RestController
@RequestMapping(value = "/easemob/im/chatGroups")
public class EasemobImChatGroupsApiController {
    @Resource
    private EasemobImChatGroupsFeign easemobImChatGroupsFeign;

    /**
     * 分页获取 APP 下的群组
     *
     * @param limit  限制数
     * @param cursor 游标，如果数据还有下一页，API 返回值会包含此字段，字符类型。
     * @return
     * @author liurenkai
     * @date 2017/11/30 14:54
     */
    @ApiOperation(httpMethod = "GET", value = "分页获取 APP 下的群组")
    @GetMapping("/get/limit")
    public ResponseMessage getLimit(@ApiParam(value = "限制数") @RequestParam(value = "limit") long limit, @ApiParam(value = "游标") @RequestParam(value = "cursor") String cursor) {
        return this.easemobImChatGroupsFeign.getLimit(limit, cursor);
    }

    /**
     * 获取群组详情
     *
     * @param groupId 群组ID
     * @return
     * @author liurenkai
     * @date 2017/11/30 14:54
     */
    @ApiOperation(httpMethod = "GET", value = "获取群组详情")
    @GetMapping("/get/details")
    public ResponseMessage getDetails(@ApiParam(value = "群组ID") @RequestParam(value = "groupId") String groupId) {
        return this.easemobImChatGroupsFeign.getDetails(groupId);
    }

    /**
     * 创建一个群组
     *
     * @param group 群组
     * @return
     * @author liurenkai
     * @date 2017/11/30 11:29
     */
    @ApiOperation(httpMethod = "POST", value = "获取群组详情")
    @PostMapping("/create")
    public ResponseMessage create(@ApiParam(value = "群组ID") @RequestBody Group group) {
        return this.easemobImChatGroupsFeign.create(group);
    }

    /**
     * 修改群组信息
     *
     * @param groupId     群组ID
     * @param modifyGroup 修改群组
     * @return
     * @author liurenkai
     * @date 2017/11/30 14:18
     */
    @ApiOperation(httpMethod = "POST", value = "修改群组信息")
    @PostMapping("/modify/{groupId}")
    public ResponseMessage modify(@ApiParam(value = "群组ID") @PathVariable(value = "groupId") String groupId, @ApiParam(value = "修改群组") @RequestBody ModifyGroup modifyGroup) {
        return this.easemobImChatGroupsFeign.modify(groupId, modifyGroup);
    }

    /**
     * 删除群组
     *
     * @param groupId 群组ID
     * @return
     * @author liurenkai
     * @date 2017/11/30 14:46
     */
    @ApiOperation(httpMethod = "POST", value = "删除群组")
    @PostMapping("/delete/{groupId}")
    public ResponseMessage delete(@ApiParam(value = "群组ID") @PathVariable(value = "groupId") String groupId) {
        return this.easemobImChatGroupsFeign.delete(groupId);
    }


    /**
     * 获取群组成员
     *
     * @param groupId 群组ID
     * @return
     * @author liurenkai
     * @date 2017/11/30 14:46
     */
    @ApiOperation(httpMethod = "POST", value = "获取群组成员")
    @PostMapping("/get/users/{groupId}")
    public ResponseMessage getUsers(@ApiParam(value = "群组ID") @PathVariable(value = "groupId") String groupId) {
        return this.easemobImChatGroupsFeign.getUsers(groupId);
    }

    /**
     * 添加群组成员[单个]
     *
     * @param groupId 群组ID
     * @param userId  用户ID
     * @return
     * @author liurenkai
     * @date 2017/11/30 14:46
     */
    @ApiOperation(httpMethod = "POST", value = "添加群组成员[单个]")
    @PostMapping("/add/{groupId}/users/{userId}")
    public ResponseMessage addSingleUser(@ApiParam(value = "群组ID") @PathVariable(value = "groupId") String groupId, @ApiParam(value = "用户ID") @PathVariable(value = "userId") String userId) {
        return this.easemobImChatGroupsFeign.addSingleUser(groupId, userId);
    }

    /**
     * 添加群组成员[批量]
     *
     * @param groupId   群组ID
     * @param userNames 用户名集合
     * @return
     * @author liurenkai
     * @date 2017/11/30 14:46
     */
    @ApiOperation(httpMethod = "POST", value = "添加群组成员[批量]")
    @PostMapping("/add/{groupId}/users/batch}")
    public ResponseMessage addBatchUsers(@ApiParam(value = "群组ID") @PathVariable(value = "groupId") String groupId, @ApiParam(value = "用户名集合") @PathVariable(value = "userNames") UserNames userNames) {
        return this.easemobImChatGroupsFeign.addBatchUsers(groupId, userNames);
    }

    /**
     * 移除群组成员[单个]
     *
     * @param groupId 群组ID
     * @param userId  用户ID
     * @return
     * @author liurenkai
     * @date 2017/11/30 14:46
     */
    @ApiOperation(httpMethod = "POST", value = "移除群组成员[单个]")
    @PostMapping("/remove/{groupId}/users/{userId}")
    public ResponseMessage removeSingleUser(@ApiParam(value = "群组ID") @PathVariable(value = "groupId") String groupId, @ApiParam(value = "用户ID") @PathVariable(value = "userId") String userId) {
        return this.easemobImChatGroupsFeign.removeSingleUser(groupId, userId);
    }

    /**
     * 移除群组成员[批量]
     *
     * @param groupId 群组ID
     * @param userIds 用户ID集合
     * @return
     * @author liurenkai
     * @date 2017/11/30 14:46
     */
    @ApiOperation(httpMethod = "POST", value = "移除群组成员[批量]")
    @PostMapping("/remove/{groupId}/users/{userIds}")
    public ResponseMessage removeBatchUsers(@ApiParam(value = "群组ID") @PathVariable(value = "groupId") String groupId, @ApiParam(value = "用户ID集合") @PathVariable(value = "userIds") String[] userIds) {
        return this.easemobImChatGroupsFeign.removeBatchUsers(groupId, userIds);
    }

    /**
     * 转让群组
     *
     * @param groupId  群组ID
     * @param newOwner 新群主
     * @return
     * @author liurenkai
     * @date 2017/11/30 14:46
     */
    @ApiOperation(httpMethod = "POST", value = "转让群组")
    @PostMapping("/transfer/{groupId}/owner/{userId}")
    public ResponseMessage transferOwner(@ApiParam(value = "群组ID") @PathVariable(value = "groupId") String groupId, @ApiParam(value = "新群主") @PathVariable(value = "newOwner") NewOwner newOwner) {
        return this.easemobImChatGroupsFeign.transferOwner(groupId, newOwner);
    }


    /**
     * 添加用户至群组黑名单[单个]
     *
     * @param groupId 群组ID
     * @param userId  用户ID
     * @return
     * @author liurenkai
     * @date 2017/11/30 14:46
     */
    @ApiOperation(httpMethod = "POST", value = "添加用户至群组黑名单[单个]")
    @PostMapping("/add/{groupId}/blockUsers/{userId}")
    public ResponseMessage addSingleBlockUser(@ApiParam(value = "群组ID") @PathVariable(value = "groupId") String groupId, @ApiParam(value = "用户ID") @PathVariable(value = "userId") String userId) {
        return this.easemobImChatGroupsFeign.addSingleBlockUser(groupId, userId);
    }

    /**
     * 添加用户至群组黑名单[批量]
     *
     * @param groupId   群组ID
     * @param userNames 用户名集合
     * @return
     * @author liurenkai
     * @date 2017/11/30 14:46
     */
    @ApiOperation(httpMethod = "POST", value = "添加用户至群组黑名单[批量]")
    @PostMapping("/add/{groupId}/blockUsers/batch}")
    public ResponseMessage addBatchBlockUsers(@ApiParam(value = "群组ID") @PathVariable(value = "groupId") String groupId, @ApiParam(value = "用户名集合") @PathVariable(value = "userNames") UserNames userNames) {
        return this.easemobImChatGroupsFeign.addBatchBlockUsers(groupId, userNames);
    }

    /**
     * 从群组黑名单移除用户[单个]
     *
     * @param groupId 群组ID
     * @param userId  用户ID
     * @return
     * @author liurenkai
     * @date 2017/11/30 14:46
     */
    @ApiOperation(httpMethod = "POST", value = "移除群组成员[单个]")
    @PostMapping("/remove/{groupId}/blockUsers/{userId}")
    public ResponseMessage removeSingleBlockUser(@ApiParam(value = "群组ID") @PathVariable(value = "groupId") String groupId, @ApiParam(value = "用户ID") @PathVariable(value = "userId") String userId) {
        return this.easemobImChatGroupsFeign.removeSingleBlockUser(groupId, userId);
    }

    /**
     * 从群组黑名单移除用户[批量]
     *
     * @param groupId 群组ID
     * @param userIds 用户ID集合
     * @return
     * @author liurenkai
     * @date 2017/11/30 14:46
     */
    @ApiOperation(httpMethod = "POST", value = "从群组黑名单移除用户[批量]")
    @PostMapping("/remove/{groupId}/blockUsers/{userIds}")
    public ResponseMessage removeSingleBlockUsers(@ApiParam(value = "群组ID") @PathVariable(value = "groupId") String groupId, @ApiParam(value = "用户ID集合") @PathVariable(value = "userIds") String[] userIds) {
        return this.easemobImChatGroupsFeign.removeSingleBlockUsers(groupId, userIds);
    }

}