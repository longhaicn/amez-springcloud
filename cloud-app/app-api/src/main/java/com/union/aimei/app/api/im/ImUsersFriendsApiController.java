package com.union.aimei.app.api.im;

import com.union.aimei.common.feign.app.im.ImUsersFriendsFeign;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * IM用户好友
 *
 * @author liurenkai
 * @time 2018/8/13 15:16
 */
@Api(tags = "IM用户好友")
@RestController
@RequestMapping(value = "imUsersFriends")
public class ImUsersFriendsApiController {
    @Resource
    private ImUsersFriendsFeign imUsersFriendsFeign;
}