package com.union.aimei.common.feign.im.pc;

import com.union.aimei.common.feign.im.pc.hystrix.EasemobImMessagesFeignHystrix;
import com.union.aimei.common.vo.im.common.*;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * IM消息 service
 *
 * @author liurenkai
 * @time 2017/11/29 16:32
 */
@FeignClient(serviceId = "PC-IM-SERVICE", fallback = EasemobImMessagesFeignHystrix.class)
public interface EasemobImMessagesFeign {


    /**
     * 发送文本消息
     *
     * @param msgTxt 文本消息
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "发送文本消息")
    @PostMapping("/easemob/im/messages/send/txt")
    ResponseMessage<ResponseResult> sendTxt(@ApiParam(value = "文本消息") @RequestBody MsgTxt msgTxt);

    /**
     * 发送图片消息
     *
     * @param msgImg 图片消息
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "发送图片消息")
    @PostMapping("/easemob/im/messages/send/img")
    ResponseMessage<ResponseResult> sendImg(@ApiParam(value = "图片消息") @RequestBody MsgImg msgImg);

    /**
     * 发送语音消息
     *
     * @param msgAudio 语音消息
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "发送语音消息")
    @PostMapping("/easemob/im/messages/send/audio")
    ResponseMessage<ResponseResult> sendAudio(@ApiParam(value = "语音消息") @RequestBody MsgAudio msgAudio);

    /**
     * 发送视频消息
     *
     * @param msgVideo 视频消息
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "发送视频消息")
    @PostMapping("/easemob/im/messages/send/video")
    ResponseMessage<ResponseResult> sendVideo(@ApiParam(value = "视频消息") @RequestBody MsgVideo msgVideo);

    /**
     * 发送透传消息
     *
     * @param msgCmd 透传消息
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "发送透传消息")
    @PostMapping("/easemob/im/messages/send/cmd")
    ResponseMessage<ResponseResult> sendCmd(@ApiParam(value = "透传消息") @RequestBody MsgCmd msgCmd);

}