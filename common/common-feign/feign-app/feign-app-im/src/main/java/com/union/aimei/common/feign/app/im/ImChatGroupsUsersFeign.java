package com.union.aimei.common.feign.app.im;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.im.ImChatGroupsUsers;
import com.union.aimei.common.feign.app.im.hystrix.ImChatGroupsUsersApiHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * IM群组用户
 *
 * @author liurenkai
 * @time 2017/12/25 19:25
 */
@FeignClient(serviceId = "APP-IM-SERVICE", fallback = ImChatGroupsUsersApiHystrix.class)
public interface ImChatGroupsUsersFeign {
    /**
     * 添加IM群组用户
     *
     * @param imChatGroupsUsers
     * @return
     */
    @PostMapping(value = "/imChatGroupsUsers/insert")
    int insert(@RequestBody ImChatGroupsUsers imChatGroupsUsers);

    /**
     * 删除IM群组用户
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/imChatGroupsUsers/deleteById/{id}")
    int deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改IM群组用户
     *
     * @param imChatGroupsUsers
     * @return
     */
    @PutMapping(value = "/imChatGroupsUsers/edit")
    int edit(@RequestBody ImChatGroupsUsers imChatGroupsUsers);

    /**
     * 根据ID查询
     *
     * @param id
     * @returnimChatGroupsUsers
     */
    @GetMapping(value = "/imChatGroupsUsers/queryById/{id}")
    ImChatGroupsUsers queryById(@PathVariable(value = "id") int id);

    /**
     * 前端分页查询IM群组用户
     *
     * @param pageNo            分页索引
     * @param pageSize          每页显示数量
     * @param imChatGroupsUsers 查询条件
     * @return
     */
    @PostMapping(value = "/imChatGroupsUsers/front/findByPage")
    PageInfo<ImChatGroupsUsers> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                   @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                   @RequestBody ImChatGroupsUsers imChatGroupsUsers);
}