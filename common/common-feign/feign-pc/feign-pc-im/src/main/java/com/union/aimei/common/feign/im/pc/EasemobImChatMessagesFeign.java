package com.union.aimei.common.feign.im.pc;

import com.union.aimei.common.feign.im.pc.hystrix.EasemobImChatMessagesFeignHystrix;
import com.union.aimei.common.vo.im.common.ResponseResult;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * IM聊天记录 service
 *
 * @author liurenkai
 * @time 2017/11/30 16:27
 */
@FeignClient(serviceId = "PC-IM-SERVICE", fallback = EasemobImChatMessagesFeignHystrix.class)
public interface EasemobImChatMessagesFeign {

    /**
     * 根据时间条件下载历史消息文件
     *
     * @param timeStr 时间
     * @return
     * @author liurenkai
     * @date 2017/11/30 15:43
     */
    @ApiOperation(httpMethod = "POST", value = "根据时间条件下载历史消息文件")
    @PostMapping("/easemob/im/chatMessages/export/time")
    ResponseMessage<ResponseResult> exportTime(@ApiParam(value = "文本消息") @RequestParam(value = "timeStr") String timeStr);

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
    @PostMapping("/easemob/im/chatMessages/export/limit")
    ResponseMessage<ResponseResult> exportLimit(@ApiParam(value = "文本消息") @RequestParam(value = "limit") long limit, @ApiParam(value = "游标") @RequestParam(value = "cursor") String cursor, @ApiParam(value = "查询条件") @RequestParam(value = "query") String query);

}
