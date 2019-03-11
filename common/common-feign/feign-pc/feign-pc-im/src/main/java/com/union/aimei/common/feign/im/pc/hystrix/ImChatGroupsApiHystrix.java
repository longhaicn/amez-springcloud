package com.union.aimei.common.feign.im.pc.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.im.pc.ImChatGroupsFeign;
import com.union.aimei.common.model.im.ImChatGroups;
import org.springframework.stereotype.Component;

/**
 * IM群组
 *
 * @author liurenkai
 * @time 2017/12/25 19:19
 */
@Component(value = "pc-ImChatGroupsFeign")
public class ImChatGroupsApiHystrix implements ImChatGroupsFeign {

    /**
     * 前端分页查询IM群组
     *
     * @param pageNo       分页索引
     * @param pageSize     每页显示数量
     * @param imChatGroups 查询条件
     * @return
     */
    @Override
    public PageInfo<ImChatGroups> findByPageForFront(Integer pageNo, Integer pageSize, ImChatGroups imChatGroups) {
        return null;
    }

    /**
     * 添加IM群组
     *
     * @param imChatGroups
     * @return
     */
    @Override
    public int insert(ImChatGroups imChatGroups) {
        return 0;
    }

    /**
     * 删除IM群组
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改IM群组
     *
     * @param imChatGroups
     * @return
     */
    @Override
    public int edit(ImChatGroups imChatGroups) {
        return 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnimChatGroups
     */
    @Override
    public ImChatGroups queryById(int id) {
        return null;
    }
}