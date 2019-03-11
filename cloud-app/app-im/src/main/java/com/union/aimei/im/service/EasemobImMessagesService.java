package com.union.aimei.im.service;

import com.union.aimei.common.vo.im.common.*;
import com.union.common.utils.ResponseMessage;

/**
 * IM消息 api
 *
 * @author liurenkai
 * @time 2017/11/29 16:32
 */
public interface EasemobImMessagesService {

    /**
     * 发送文本消息
     *
     * @param msgTxt 文本消息
     * @return
     */
    ResponseMessage<ResponseResult> sendTxt(MsgTxt msgTxt);

    /**
     * 发送图片消息
     *
     * @param msgImg 图片消息
     * @return
     */
    ResponseMessage<ResponseResult> sendImg(MsgImg msgImg);

    /**
     * 发送语音消息
     *
     * @param msgAudio 语音消息
     * @return
     */
    ResponseMessage<ResponseResult> sendAudio(MsgAudio msgAudio);

    /**
     * 发送视频消息
     *
     * @param msgVideo 视频消息
     * @return
     */
    ResponseMessage<ResponseResult> sendVideo(MsgVideo msgVideo);

    /**
     * 发送透传消息
     *
     * @param msgCmd 透传消息
     * @return
     */
    ResponseMessage<ResponseResult> sendCmd(MsgCmd msgCmd);

}