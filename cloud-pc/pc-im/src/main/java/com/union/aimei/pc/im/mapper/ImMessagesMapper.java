package com.union.aimei.pc.im.mapper;

import com.union.aimei.common.model.im.ImMessages;
import com.union.aimei.common.vo.im.common.ImMessagesByBatchVo;
import com.union.aimei.common.vo.im.common.ImMessagesRecentContactlistVo;
import com.union.aimei.common.vo.im.common.ImMessagesVo;
import com.union.common.utils.base.BaseMapper;

import java.util.List;

/**
 * IM消息
 *
 * @author liurenkai
 * @time 2018/1/8 21:08
 */
public interface ImMessagesMapper extends BaseMapper<ImMessages> {

    /**
     * 根据发送人集合，接收人集合查询IM消息
     *
     * @param imMessagesVo IM消息
     * @return
     */
    List<ImMessages> selectListByFromToList(ImMessagesVo imMessagesVo);

    /**
     * 根据用户名集合查询最近联系人列表
     *
     * @param imMessagesRecentContactlistVo
     * @return
     */
    List<String> selectListByRecentContactlist(ImMessagesRecentContactlistVo imMessagesRecentContactlistVo);

    /**
     * 批量添加IM消息
     *
     * @param batchVo
     * @return
     */
    int addBatch(ImMessagesByBatchVo batchVo);

}