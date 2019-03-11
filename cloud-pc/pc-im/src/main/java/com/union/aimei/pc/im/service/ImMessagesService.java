package com.union.aimei.pc.im.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.im.ImMessages;
import com.union.aimei.common.vo.im.common.ImMessagesVo;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.base.SpringCloudBaseService;

import java.util.List;

/**
 * IM消息
 *
 * @author liurenkai
 * @time IM消息 18:52
 */
public interface ImMessagesService extends SpringCloudBaseService<ImMessages> {
    /**
     * 前端分页查询IM消息
     *
     * @param pageNo     分页索引
     * @param pageSize   每页显示数量
     * @param imMessages 查询条件
     * @return
     */
    PageInfo<ImMessages> findByPageForFront(Integer pageNo, Integer pageSize, ImMessages imMessages);

    /**
     * 根据发送人集合，接收人集合分页查询IM消息
     *
     * @param pageNo       分页索引
     * @param pageSize     每页显示数量
     * @param imMessagesVo 查询条件
     * @return
     */
    ResponseMessage<PageInfo<ImMessages>> findByPageForFromToList(Integer pageNo, Integer pageSize, ImMessagesVo imMessagesVo);

    /**
     * 根据用户名集合分页查询最近联系人列表
     *
     * @param pageNo   分页索引
     * @param pageSize 每页显示数量
     * @param userNameList 用户名集合
     * @return
     */
    ResponseMessage<PageInfo<String>> findByPageForRecentContactlist(Integer pageNo, Integer pageSize, List<String> userNameList);

}