package com.union.aimei.common.feign.im.pc.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.im.pc.ImUsersFeign;
import com.union.aimei.common.model.im.ImUsers;
import org.springframework.stereotype.Component;

/**
 * IM用户
 *
 * @author liurenkai
 * @time 2017/12/25 19:23
 */
@Component(value = "pc-ImUsersFeign")
public class ImUsersApiHystrix implements ImUsersFeign {

    /**
     * 前端分页查询IM用户
     *
     * @param pageNo   分页索引
     * @param pageSize 每页显示数量
     * @param imUsers  查询条件
     * @return
     */
    @Override
    public PageInfo<ImUsers> findByPageForFront(Integer pageNo, Integer pageSize, ImUsers imUsers) {
        return null;
    }

    /**
     * 添加IM用户
     *
     * @param imUsers
     * @return
     */
    @Override
    public int insert(ImUsers imUsers) {
        return 0;
    }

    /**
     * 删除IM用户
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改IM用户
     *
     * @param imUsers
     * @return
     */
    @Override
    public int edit(ImUsers imUsers) {
        return 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnimUsers
     */
    @Override
    public ImUsers queryById(int id) {
        return null;
    }
}