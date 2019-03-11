package com.union.aimei.common.feign.app.im;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.im.ImUsers;
import com.union.aimei.common.feign.app.im.hystrix.ImUsersApiHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * IM用户
 *
 * @author liurenkai
 * @time 2017/12/25 19:27
 */
@FeignClient(serviceId = "APP-IM-SERVICE", fallback = ImUsersApiHystrix.class)
public interface ImUsersFeign {
    /**
     * 添加IM用户
     *
     * @param imUsers
     * @return
     */
    @PostMapping(value = "/imUsers/insert")
    int insert(@RequestBody ImUsers imUsers);

    /**
     * 删除IM用户
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/imUsers/deleteById/{id}")
    int deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改IM用户
     *
     * @param imUsers
     * @return
     */
    @PutMapping(value = "/imUsers/edit")
    int edit(@RequestBody ImUsers imUsers);

    /**
     * 根据ID查询
     *
     * @param id
     * @returnimUsers
     */
    @GetMapping(value = "/imUsers/queryById/{id}")
    ImUsers queryById(@PathVariable(value = "id") int id);

    /**
     * 前端分页查询IM用户
     *
     * @param pageNo   分页索引
     * @param pageSize 每页显示数量
     * @param imUsers  查询条件
     * @return
     */
    @PostMapping(value = "/imUsers/front/findByPage")
    PageInfo<ImUsers> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                         @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                         @RequestBody ImUsers imUsers);
}