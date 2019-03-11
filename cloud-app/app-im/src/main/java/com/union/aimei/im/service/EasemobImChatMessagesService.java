package com.union.aimei.im.service;

import com.union.aimei.common.vo.im.common.ResponseResult;
import com.union.common.utils.ResponseMessage;

/**
 * IM聊天记录 api
 *
 * @author liurenkai
 * @time 2017/11/30 16:27
 */
public interface EasemobImChatMessagesService {

    /**
     * 根据时间条件下载历史消息文件
     *
     * @param timeStr 时间
     * @return
     * @author liurenkai
     * @date 2017/11/30 15:43
     */
    ResponseMessage<ResponseResult> exportTime(String timeStr);

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
    ResponseMessage<ResponseResult> exportLimit(long limit, String cursor, String query);

}
