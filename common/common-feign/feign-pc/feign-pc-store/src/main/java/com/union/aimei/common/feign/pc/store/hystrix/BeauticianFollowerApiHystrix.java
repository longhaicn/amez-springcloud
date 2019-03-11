package com.union.aimei.common.feign.pc.store.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.store.BeauticianFollowerFeign;
import com.union.aimei.common.model.store.BeauticianFollower;
import org.springframework.stereotype.Component;

/**
 * @author caizhaoming
 * @version 1.1
 * @create 2018-06-21 11:43
 **/
@Component(value = "pc-BeauticianFollowerFeign")
public class BeauticianFollowerApiHystrix implements BeauticianFollowerFeign {

    /**
     * 前端分页查询美容师粉丝
     *
     * @param pageNo             分页索引
     * @param pageSize           每页显示数量
     * @param beauticianFollower 查询条件
     * @return
     */
    @Override
    public PageInfo<BeauticianFollower> findByPageForFront(Integer pageNo, Integer pageSize, BeauticianFollower beauticianFollower) {
        return null;
    }

    /**
     * 添加美容师粉丝
     *
     * @param beauticianFollower
     * @return
     */
    @Override
    public int insert(BeauticianFollower beauticianFollower) {
        return 0;
    }

    /**
     * 删除美容师粉丝
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改美容师粉丝
     *
     * @param beauticianFollower
     * @return
     */
    @Override
    public int edit(BeauticianFollower beauticianFollower) {
        return 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnbeauticianFollower
     */
    @Override
    public BeauticianFollower queryById(int id) {
        return null;
    }
}