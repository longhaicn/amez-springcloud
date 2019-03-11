package com.union.aimei.pc.api.im;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.im.pc.ImChatGroupsUsersFeign;
import com.union.aimei.common.model.im.ImChatGroupsUsers;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * IM群组用户
 *
 * @author liurenkai
 * @time 2018/8/13 17:16
 */
@Api(tags = "IM群组用户")
@RestController
@RequestMapping(value = "imChatGroupsUsers")
public class ImChatGroupsUsersApiController {
    @Resource
    private ImChatGroupsUsersFeign imChatGroupsUsersFeign;

    /**
     * 分页查询
     *
     * @param pageNo            分页索引
     * @param pageSize          每页显示数量
     * @param imChatGroupsUsers 查询条件
     * @return ResponseMessage<ImChatGroupsUsers>
     */
    @ApiOperation(httpMethod = "POST", value = "前端分页查询IM群组用户")
    @PostMapping("/front/findByPage")
    public ResponseMessage<PageInfo<ImChatGroupsUsers>> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                           @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                           @ApiParam(value = "查询条件") @RequestBody ImChatGroupsUsers imChatGroupsUsers) {
        return new ResponseMessage<>(this.imChatGroupsUsersFeign.findByPageForFront(pageNo, pageSize, imChatGroupsUsers));
    }

}