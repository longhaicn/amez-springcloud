package com.union.aimei.pc.api.im;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.im.ImChatGroups;
import com.union.aimei.common.feign.im.pc.ImChatGroupsFeign;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * IM群组
 *
 * @author liurenkai
 * @time 2018/8/13 17:17
 */
@Api(tags = "IM群组")
@RestController
@RequestMapping(value = "imChatGroups")
public class ImChatGroupsApiController {
    @Resource
    private ImChatGroupsFeign imChatGroupsFeign;

    /**
     * 分页查询
     *
     * @param pageNo       分页索引
     * @param pageSize     每页显示数量
     * @param imChatGroups 查询条件
     * @return ResponseMessage<ImChatGroups>
     */
    @ApiOperation(httpMethod = "POST", value = "前端分页查询IM群组")
    @PostMapping("/front/findByPage")
    public ResponseMessage<PageInfo<ImChatGroups>> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                      @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                      @ApiParam(value = "查询条件") @RequestBody ImChatGroups imChatGroups) {
        return new ResponseMessage<>(this.imChatGroupsFeign.findByPageForFront(pageNo, pageSize, imChatGroups));
    }

}