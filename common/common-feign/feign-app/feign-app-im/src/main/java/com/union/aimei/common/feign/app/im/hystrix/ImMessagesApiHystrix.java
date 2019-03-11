package com.union.aimei.common.feign.app.im.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.im.ImMessagesFeign;
import com.union.aimei.common.model.im.ImMessages;
import com.union.aimei.common.vo.im.common.ImMessagesVo;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * IM消息
 *
 * @author liurenkai
 * @time 2017/12/25 19:20
 */
@Component(value = "app-ImMessagesFeign")
public class ImMessagesApiHystrix implements ImMessagesFeign {

    /**
     * 前端分页查询IM消息
     *
     * @param pageNo     分页索引
     * @param pageSize   每页显示数量
     * @param imMessages 查询条件
     * @return
     */
    @Override
    public PageInfo<ImMessages> findByPageForFront(Integer pageNo, Integer pageSize, ImMessages imMessages) {
        return null;
    }

    /**
     * 添加IM消息
     *
     * @param imMessages
     * @return
     */
    @Override
    public int insert(ImMessages imMessages) {
        return 0;
    }

    /**
     * 删除IM消息
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改IM消息
     *
     * @param imMessages
     * @return
     */
    @Override
    public int edit(ImMessages imMessages) {
        return 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnimMessages
     */
    @Override
    public ImMessages queryById(int id) {
        return null;
    }

    @Override
    public ResponseMessage<PageInfo<ImMessages>> findByPageForFromToList(Integer pageNo, Integer pageSize, ImMessagesVo imMessagesVo) {
        return null;
    }

    @Override
    public ResponseMessage<PageInfo<String>> findByPageForRecentContactlist(Integer pageNo, Integer pageSize, List<String> userNameList) {
        return null;
    }
}