package com.union.aimei.common.feign.im.pc;

import com.union.aimei.common.feign.im.pc.hystrix.EasemobImChatGroupsFeignHystrix;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.client.model.Group;
import io.swagger.client.model.ModifyGroup;
import io.swagger.client.model.NewOwner;
import io.swagger.client.model.UserNames;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * IM用户群组 service
 *
 * @author liurenkai
 * @time 2017/11/30 11:26
 */
@FeignClient(serviceId = "PC-IM-SERVICE", fallback = EasemobImChatGroupsFeignHystrix.class)
public interface EasemobImChatGroupsFeign {

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
    @GetMapping("/easemob/im/chatGroups/get/limit")
    ResponseMessage getLimit(@ApiParam(value = "限制数") @RequestParam(value = "limit") long limit, @ApiParam(value = "游标") @RequestParam(value = "cursor") String cursor);

    /**
     * 获取群组详情
     *
     * @param groupId 群组ID
     * @return
     * @author liurenkai
     * @date 2017/11/30 14:54
     */
    @ApiOperation(httpMethod = "GET", value = "获取群组详情")
    @GetMapping("/easemob/im/chatGroups/get/details")
    ResponseMessage getDetails(@ApiParam(value = "群组ID") @RequestParam(value = "groupId") String groupId);

    /**
     * 创建一个群组
     *
     * @param group 群组
     * @return
     * @author liurenkai
     * @date 2017/11/30 11:29
     */
    @ApiOperation(httpMethod = "POST", value = "获取群组详情")
    @PostMapping("/easemob/im/chatGroups/create")
    ResponseMessage create(@ApiParam(value = "群组ID") @RequestBody Group group);

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
    @PostMapping("/easemob/im/chatGroups/modify/{groupId}")
    ResponseMessage modify(@ApiParam(value = "群组ID") @PathVariable(value = "groupId") String groupId, @ApiParam(value = "修改群组") @RequestBody ModifyGroup modifyGroup);

    /**
     * 删除群组
     *
     * @param groupId 群组ID
     * @return
     * @author liurenkai
     * @date 2017/11/30 14:46
     */
    @ApiOperation(httpMethod = "POST", value = "删除群组")
    @PostMapping("/easemob/im/chatGroups/delete/{groupId}")
    ResponseMessage delete(@ApiParam(value = "群组ID") @PathVariable(value = "groupId") String groupId);


    /**
     * 获取群组成员
     *
     * @param groupId 群组ID
     * @return
     * @author liurenkai
     * @date 2017/11/30 14:46
     */
    @ApiOperation(httpMethod = "POST", value = "获取群组成员")
    @PostMapping("/easemob/im/chatGroups/get/users/{groupId}")
    ResponseMessage getUsers(@ApiParam(value = "群组ID") @PathVariable(value = "groupId") String groupId);

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
    @PostMapping("/easemob/im/chatGroups/add/{groupId}/users/{userId}")
    ResponseMessage addSingleUser(@ApiParam(value = "群组ID") @PathVariable(value = "groupId") String groupId, @ApiParam(value = "用户ID") @PathVariable(value = "userId") String userId);

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
    @PostMapping("/easemob/im/chatGroups/add/{groupId}/users/batch}")
    ResponseMessage addBatchUsers(@ApiParam(value = "群组ID") @PathVariable(value = "groupId") String groupId, @ApiParam(value = "用户名集合") @PathVariable(value = "userNames") UserNames userNames);

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
    @PostMapping("/easemob/im/chatGroups/remove/{groupId}/users/{userId}")
    ResponseMessage removeSingleUser(@ApiParam(value = "群组ID") @PathVariable(value = "groupId") String groupId, @ApiParam(value = "用户ID") @PathVariable(value = "userId") String userId);

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
    @PostMapping("/easemob/im/chatGroups/remove/{groupId}/users/{userIds}")
    ResponseMessage removeBatchUsers(@ApiParam(value = "群组ID") @PathVariable(value = "groupId") String groupId, @ApiParam(value = "用户ID集合") @PathVariable(value = "userIds") String[] userIds);

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
    @PostMapping("/easemob/im/chatGroups/transfer/{groupId}/owner/{userId}")
    ResponseMessage transferOwner(@ApiParam(value = "群组ID") @PathVariable(value = "groupId") String groupId, @ApiParam(value = "新群主") @PathVariable(value = "newOwner") NewOwner newOwner);


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
    @PostMapping("/easemob/im/chatGroups/add/{groupId}/blockUsers/{userId}")
    ResponseMessage addSingleBlockUser(@ApiParam(value = "群组ID") @PathVariable(value = "groupId") String groupId, @ApiParam(value = "用户ID") @PathVariable(value = "userId") String userId);

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
    @PostMapping("/easemob/im/chatGroups/add/{groupId}/blockUsers/batch}")
    ResponseMessage addBatchBlockUsers(@ApiParam(value = "群组ID") @PathVariable(value = "groupId") String groupId, @ApiParam(value = "用户名集合") @PathVariable(value = "userNames") UserNames userNames);

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
    @PostMapping("/easemob/im/chatGroups/remove/{groupId}/blockUsers/{userId}")
    ResponseMessage removeSingleBlockUser(@ApiParam(value = "群组ID") @PathVariable(value = "groupId") String groupId, @ApiParam(value = "用户ID") @PathVariable(value = "userId") String userId);

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
    @PostMapping("/easemob/im/chatGroups/remove/{groupId}/blockUsers/{userIds}")
    ResponseMessage removeSingleBlockUsers(@ApiParam(value = "群组ID") @PathVariable(value = "groupId") String groupId, @ApiParam(value = "用户ID集合") @PathVariable(value = "userIds") String[] userIds);


}