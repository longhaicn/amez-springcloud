package com.union.aimei.pc.api.im;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.im.ImUsersFriends;
import com.union.aimei.common.feign.im.pc.ImUsersFriendsFeign;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * IM用户好友
 *
 * @author liurenkai
 * @time 2018/8/13 17:17
 */
@Api(tags = "IM用户好友")
@RestController
@RequestMapping(value = "imUsersFriends")
public class ImUsersFriendsApiController {
    @Resource
    private ImUsersFriendsFeign imUsersFriendsFeign;

    /**
     * 分页查询
     *
     * @param pageNo         分页索引
     * @param pageSize       每页显示数量
     * @param imUsersFriends 查询条件
     * @return ResponseMessage<ImUsersFriends>
     */
    @ApiOperation(httpMethod = "POST", value = "前端分页查询IM用户好友")
    @PostMapping("/front/findByPage")
    public ResponseMessage<PageInfo<ImUsersFriends>> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                        @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                        @ApiParam(value = "查询条件") @RequestBody ImUsersFriends imUsersFriends) {
        return new ResponseMessage<>(this.imUsersFriendsFeign.findByPageForFront(pageNo, pageSize, imUsersFriends));
    }

}