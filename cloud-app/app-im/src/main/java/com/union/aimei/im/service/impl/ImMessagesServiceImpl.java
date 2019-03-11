package com.union.aimei.im.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.im.ImMessages;
import com.union.aimei.im.mapper.ImMessagesMapper;
import com.union.aimei.im.service.ImMessagesService;
import com.union.aimei.common.vo.im.common.ImMessagesRecentContactlistVo;
import com.union.aimei.common.vo.im.common.ImMessagesVo;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * IM消息
 *
 * @author liurenkai
 * @time 2017/12/25 18:59
 */
@Service("imMessagesService")
public class ImMessagesServiceImpl implements ImMessagesService {
    @Resource
    private ImMessagesMapper imMessagesMapper;

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
        PageHelper.startPage(pageNo, pageSize);
        List<ImMessages> list = this.imMessagesMapper.selectListByConditions(imMessages);
        PageInfo<ImMessages> page = new PageInfo<>(list);
        return page;
    }

    /**
     * 添加IM消息
     *
     * @param imMessages
     * @return
     */
    @Override
    public int addObj(ImMessages imMessages) {
        return this.imMessagesMapper.insertSelective(imMessages);
    }

    /**
     * 删除IM消息
     *
     * @param id
     * @return
     */
    @Override
    public int deleteObjById(int id) {
        return this.imMessagesMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改IM消息
     *
     * @param imMessages
     * @return
     */
    @Override
    public int modifyObj(ImMessages imMessages) {
        return this.imMessagesMapper.updateByPrimaryKeySelective(imMessages);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnimMessages
     */
    @Override
    public ImMessages queryObjById(int id) {
        ImMessages model = this.imMessagesMapper.selectByPrimaryKey(id);
        return model;
    }

    @Override
    public ResponseMessage<PageInfo<ImMessages>> findByPageForFromToList(Integer pageNo, Integer pageSize, ImMessagesVo imMessagesVo) {
        ResponseMessage<PageInfo<ImMessages>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        List<ImMessages> list = this.imMessagesMapper.selectListByFromToList(imMessagesVo);
        PageInfo<ImMessages> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

    @Override
    public ResponseMessage<PageInfo<String>> findByPageForRecentContactlist(Integer pageNo, Integer pageSize, List<String> userNameList) {
        ResponseMessage<PageInfo<String>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        ImMessagesRecentContactlistVo imMessagesRecentContactlistVo = new ImMessagesRecentContactlistVo();
        imMessagesRecentContactlistVo.setUserNameList(userNameList);
        List<String> list = this.imMessagesMapper.selectListByRecentContactlist(imMessagesRecentContactlistVo);
        PageInfo<String> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

}