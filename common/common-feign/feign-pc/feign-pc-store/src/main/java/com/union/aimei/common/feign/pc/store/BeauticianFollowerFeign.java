package com.union.aimei.common.feign.pc.store;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.store.hystrix.BeauticianFollowerApiHystrix;
import com.union.aimei.common.model.store.BeauticianFollower;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author caizhaoming
 * @version 1.1
 * @create 2018-06-21 11:43
 **/
@FeignClient(serviceId = "PC-STORE-SERVICE", fallback = BeauticianFollowerApiHystrix.class)
public interface BeauticianFollowerFeign {
    /**
     * 添加美容师粉丝
     *
     * @param beauticianFollower
     * @return
     */
    @PostMapping(value = "/beauticianFollower/insert")
    int insert(@RequestBody BeauticianFollower beauticianFollower);

    /**
     * 删除美容师粉丝
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/beauticianFollower/deleteById/{id}")
    int deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改美容师粉丝
     *
     * @param beauticianFollower
     * @return
     */
    @PutMapping(value = "/beauticianFollower/edit")
    int edit(@RequestBody BeauticianFollower beauticianFollower);

    /**
     * 根据ID查询
     *
     * @param id
     * @returnbeauticianFollower
     */
    @GetMapping(value = "/beauticianFollower/queryById/{id}")
    BeauticianFollower queryById(@PathVariable(value = "id") int id);

    /**
     * 前端分页查询美容师粉丝
     *
     * @param pageNo             分页索引
     * @param pageSize           每页显示数量
     * @param beauticianFollower 查询条件
     * @return
     */
    @PostMapping(value = "/beauticianFollower/front/findByPage")
    PageInfo<BeauticianFollower> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0")
                                                            Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10")
                                                            Integer pageSize, @RequestBody BeauticianFollower beauticianFollower);
}