package com.union.aimei.im.easemob.api;

/**
 * 发送消息API
 *
 * @author liurenkai
 * @time 2018/8/13 15:13
 */
public interface SendMessageApi {

    /**
     * 发送消息
     *
     * @param payload 有效载荷
     * @return
     */
    Object sendMessage(Object payload);
}
