package com.union.aimei.app.api.im;

import com.union.aimei.common.feign.app.im.ImChatGroupsUsersFeign;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * IM群组用户
 *
 * @author liurenkai
 * @time 2018/8/13 15:16
 */
@Api(tags = "IM群组用户")
@RestController
@RequestMapping(value = "imChatGroupsUsers")
public class ImChatGroupsUsersApiController {
    @Resource
    private ImChatGroupsUsersFeign imChatGroupsUsersFeign;

}