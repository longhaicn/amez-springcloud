package com.union.aimei.common.feign.im.pc;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.im.pc.hystrix.ImChatGroupsApiHystrix;
import com.union.aimei.common.model.im.ImChatGroups;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * IM群组
 *
 * @author liurenkai
 * @time 2017/12/25 19:25
 */
@FeignClient(serviceId = "PC-IM-SERVICE", fallback = ImChatGroupsApiHystrix.class)
public interface ImChatGroupsFeign {
    /**
     * 添加IM群组
     *
     * @param imChatGroups
     * @return
     */
    @PostMapping(value = "/imChatGroups/insert")
    int insert(@RequestBody ImChatGroups imChatGroups);

    /**
     * 删除IM群组
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/imChatGroups/deleteById/{id}")
    int deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改IM群组
     *
     * @param imChatGroups
     * @return
     */
    @PutMapping(value = "/imChatGroups/edit")
    int edit(@RequestBody ImChatGroups imChatGroups);

    /**
     * 根据ID查询
     *
     * @param id
     * @returnimChatGroups
     */
    @GetMapping(value = "/imChatGroups/queryById/{id}")
    ImChatGroups queryById(@PathVariable(value = "id") int id);

    /**
     * 前端分页查询IM群组
     *
     * @param pageNo       分页索引
     * @param pageSize     每页显示数量
     * @param imChatGroups 查询条件
     * @return
     */
    @PostMapping(value = "/imChatGroups/front/findByPage")
    PageInfo<ImChatGroups> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                              @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                              @RequestBody ImChatGroups imChatGroups);

}