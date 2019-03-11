package com.union.aimei.im.service.impl;

import com.google.gson.Gson;
import com.union.aimei.im.easemob.api.impl.EasemobSendMessage;
import com.union.aimei.im.service.EasemobImMessagesService;
import com.union.aimei.common.vo.im.common.*;
import com.union.common.utils.AssertUtil;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseMessageFactory;
import com.union.common.utils.constant.ResponseContants;
import io.swagger.client.model.Msg;
import org.springframework.stereotype.Service;

/**
 * IM消息 api impl
 *
 * @author liurenkai
 * @time 2017/11/29 16:54
 */
@Service("easemobImMessagesService")
public class EasemobImMessagesServiceImpl implements EasemobImMessagesService {

    @Override
    public ResponseMessage<ResponseResult> sendTxt(MsgTxt msgTxt) {
        ResponseMessage<ResponseResult> responseMessage = ResponseMessageFactory.newInstance();
        EasemobSendMessage easemobSendMessage = new EasemobSendMessage();
        Msg msg = msgTxt.getMsg();
        msg.setMsg(msgTxt.getMsgContentTxt());
        Object responseObject = easemobSendMessage.sendMessage(msg);
        if (null == responseObject) {
            AssertUtil.numberGtZero(null, ResponseContants.ADD_MESSAGE, ResponseContants.ADD);
        }
        ResponseResult responseResult = new Gson().fromJson(responseObject.toString(), ResponseResult.class);
        responseMessage.setData(responseResult);
        return responseMessage;
    }

    @Override
    public ResponseMessage<ResponseResult> sendImg(MsgImg msgImg) {
        ResponseMessage<ResponseResult> responseMessage = ResponseMessageFactory.newInstance();
        EasemobSendMessage easemobSendMessage = new EasemobSendMessage();
        Msg msg = msgImg.getMsg();
        msg.setMsg(msgImg.getMsgContentImg());
        Object responseObject = easemobSendMessage.sendMessage(msg);
        if (null == responseObject) {
            AssertUtil.numberGtZero(null, ResponseContants.ADD_MESSAGE, ResponseContants.ADD);
        }
        ResponseResult responseResult = new Gson().fromJson(responseObject.toString(), ResponseResult.class);
        responseMessage.setData(responseResult);
        return responseMessage;
    }

    @Override
    public ResponseMessage<ResponseResult> sendAudio(MsgAudio msgAudio) {
        ResponseMessage<ResponseResult> responseMessage = ResponseMessageFactory.newInstance();
        EasemobSendMessage easemobSendMessage = new EasemobSendMessage();
        Msg msg = msgAudio.getMsg();
        msg.setMsg(msgAudio.getMsgContentAudio());
        Object responseObject = easemobSendMessage.sendMessage(msg);
        if (null == responseObject) {
            AssertUtil.numberGtZero(null, ResponseContants.ADD_MESSAGE, ResponseContants.ADD);
        }
        ResponseResult responseResult = new Gson().fromJson(responseObject.toString(), ResponseResult.class);
        responseMessage.setData(responseResult);
        return responseMessage;
    }

    @Override
    public ResponseMessage<ResponseResult> sendVideo(MsgVideo msgVideo) {
        ResponseMessage<ResponseResult> responseMessage = ResponseMessageFactory.newInstance();
        EasemobSendMessage easemobSendMessage = new EasemobSendMessage();
        Msg msg = msgVideo.getMsg();
        msg.setMsg(msgVideo.getMsgContentVideo());
        Object responseObject = easemobSendMessage.sendMessage(msg);
        if (null == responseObject) {
            AssertUtil.numberGtZero(null, ResponseContants.ADD_MESSAGE, ResponseContants.ADD);
        }
        ResponseResult responseResult = new Gson().fromJson(responseObject.toString(), ResponseResult.class);
        responseMessage.setData(responseResult);
        return responseMessage;
    }

    @Override
    public ResponseMessage<ResponseResult> sendCmd(MsgCmd msgCmd) {
        ResponseMessage<ResponseResult> responseMessage = ResponseMessageFactory.newInstance();
        EasemobSendMessage easemobSendMessage = new EasemobSendMessage();
        Msg msg = msgCmd.getMsg();
        msg.setMsg(msgCmd.getMsgContentCmd());
        Object responseObject = easemobSendMessage.sendMessage(msg);
        if (null == responseObject) {
            AssertUtil.numberGtZero(null, ResponseContants.ADD_MESSAGE, ResponseContants.ADD);
        }
        ResponseResult responseResult = new Gson().fromJson(responseObject.toString(), ResponseResult.class);
        responseMessage.setData(responseResult);
        return responseMessage;
    }
}