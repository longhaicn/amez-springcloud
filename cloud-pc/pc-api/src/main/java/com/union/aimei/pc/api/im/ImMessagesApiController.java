package com.union.aimei.pc.api.im;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.im.pc.ImMessagesFeign;
import com.union.aimei.common.model.im.ImMessages;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * IM消息
 *
 * @author liurenkai
 * @time 2018/1/8 21:31
 */
@Api(tags = "IM消息")
@RestController
@RequestMapping(value = "imMessages")
public class ImMessagesApiController {
    @Resource
    private ImMessagesFeign imMessagesFeign;

    /**
     * 分页查询
     *
     * @param pageNo     分页索引
     * @param pageSize   每页显示数量
     * @param imMessages 查询条件
     * @return ResponseMessage<ImMessages>
     */
    @ApiOperation(httpMethod = "POST", value = "前端分页查询IM消息")
    @PostMapping("/front/findByPage")
    public ResponseMessage<PageInfo<ImMessages>> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                          @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                          @ApiParam(value = "查询条件") @RequestBody ImMessages imMessages) {
        return new ResponseMessage<>(this.imMessagesFeign.findByPageForFront(pageNo, pageSize, imMessages));
    }

}