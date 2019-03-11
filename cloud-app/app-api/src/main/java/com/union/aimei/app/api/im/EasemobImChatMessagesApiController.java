package com.union.aimei.app.api.im;

import com.union.aimei.common.vo.im.common.ResponseResult;
import com.union.aimei.common.feign.app.im.EasemobImChatMessagesFeign;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * IM聊天消息 controller
 *
 * @author liurenkai
 * @time 2017/11/29 16:35
 */
@Api(tags = "IM聊天消息 controller")
@RestController
@RequestMapping(value = "/easemob/im/chatMessages")
public class EasemobImChatMessagesApiController {
    @Resource
    private EasemobImChatMessagesFeign easemobImChatMessagesFeign;

    /**
     * 根据时间条件下载历史消息文件
     *
     * @param timeStr 时间
     * @return
     * @author liurenkai
     * @date 2017/11/30 15:43
     */
    @ApiOperation(httpMethod = "POST", value = "根据时间条件下载历史消息文件")
    @PostMapping("/export/time")
    public ResponseMessage<ResponseResult> exportTime(@ApiParam(value = "文本消息") @RequestParam(value = "timeStr") String timeStr) {
        return this.easemobImChatMessagesFeign.exportTime(timeStr);
    }

    /**
     * 分页获取数据
     *
     * @param limit  限制数（一分钟最多调用10次，每次 limit 最大值为1000。）
     * @param cursor 游标
     * @param query  查询条件
     * @return
     * @author liurenkai
     * @date 2017/11/30 15:43
     */
    @ApiOperation(httpMethod = "POST", value = "分页获取数据")
    @PostMapping("/export/limit")
    public ResponseMessage<ResponseResult> exportLimit(@ApiParam(value = "文本消息") @RequestParam(value = "limit") long limit, @ApiParam(value = "游标") @RequestParam(value = "cursor") String cursor, @ApiParam(value = "查询条件") @RequestParam(value = "query") String query) {
        return this.easemobImChatMessagesFeign.exportLimit(limit, cursor, query);
    }

}