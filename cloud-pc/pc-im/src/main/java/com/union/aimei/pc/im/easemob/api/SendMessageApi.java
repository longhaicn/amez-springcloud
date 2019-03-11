package com.union.aimei.pc.im.easemob.api;

/**
 * This interface is created for RestAPI of Sending Message, it should be
 * synchronized with the API list.
 *
 * @author Eric23 2016-01-05
 * @see http://docs.easemob.com/
 */
public interface SendMessageApi {

    /**
     * 发送消息
     * @param payload 有效载荷
     * @return
     */
    Object sendMessage(Object payload);
}
