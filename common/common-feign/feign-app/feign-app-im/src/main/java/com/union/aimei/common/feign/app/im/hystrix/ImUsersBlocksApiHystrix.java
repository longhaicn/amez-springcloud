package com.union.aimei.common.feign.app.im.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.im.ImUsersBlocksFeign;
import com.union.aimei.common.model.im.ImUsersBlocks;
import org.springframework.stereotype.Component;

/**
 * IM用户黑名单
 *
 * @author liurenkai
 * @time 2017/12/25 19:24
 */
@Component(value = "app-ImUsersBlocksFeign")
public class ImUsersBlocksApiHystrix implements ImUsersBlocksFeign {

    /**
     * 前端分页查询IM用户黑名单
     *
     * @param pageNo        分页索引
     * @param pageSize      每页显示数量
     * @param imUsersBlocks 查询条件
     * @return
     */
    @Override
    public PageInfo<ImUsersBlocks> findByPageForFront(Integer pageNo, Integer pageSize, ImUsersBlocks imUsersBlocks) {
        return null;
    }

    /**
     * 添加IM用户黑名单
     *
     * @param imUsersBlocks
     * @return
     */
    @Override
    public int insert(ImUsersBlocks imUsersBlocks) {
        return 0;
    }

    /**
     * 删除IM用户黑名单
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改IM用户黑名单
     *
     * @param imUsersBlocks
     * @return
     */
    @Override
    public int edit(ImUsersBlocks imUsersBlocks) {
        return 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnimUsersBlocks
     */
    @Override
    public ImUsersBlocks queryById(int id) {
        return null;
    }
}