package com.union.aimei.common.feign.im.pc;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.im.pc.hystrix.ImUsersFriendsApiHystrix;
import com.union.aimei.common.model.im.ImUsersFriends;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * IM用户好友
 *
 * @author liurenkai
 * @time 2017/12/25 19:28
 */
@FeignClient(serviceId = "PC-IM-SERVICE", fallback = ImUsersFriendsApiHystrix.class)
public interface ImUsersFriendsFeign {
    /**
     * 添加IM用户好友
     *
     * @param imUsersFriends
     * @return
     */
    @PostMapping(value = "/imUsersFriends/insert")
    int insert(@RequestBody ImUsersFriends imUsersFriends);

    /**
     * 删除IM用户好友
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/imUsersFriends/deleteById/{id}")
    int deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改IM用户好友
     *
     * @param imUsersFriends
     * @return
     */
    @PutMapping(value = "/imUsersFriends/edit")
    int edit(@RequestBody ImUsersFriends imUsersFriends);

    /**
     * 根据ID查询
     *
     * @param id
     * @returnimUsersFriends
     */
    @GetMapping(value = "/imUsersFriends/queryById/{id}")
    ImUsersFriends queryById(@PathVariable(value = "id") int id);

    /**
     * 前端分页查询IM用户好友
     *
     * @param pageNo         分页索引
     * @param pageSize       每页显示数量
     * @param imUsersFriends 查询条件
     * @return
     */
    @PostMapping(value = "/imUsersFriends/front/findByPage")
    PageInfo<ImUsersFriends> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                @RequestBody ImUsersFriends imUsersFriends);
}