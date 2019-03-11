package com.union.aimei.common.feign.app.im;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.im.ImUsersBlocks;
import com.union.aimei.common.feign.app.im.hystrix.ImUsersBlocksApiHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * IM用户黑名单
 *
 * @author liurenkai
 * @time 2017/12/25 19:27
 */
@FeignClient(serviceId = "APP-IM-SERVICE", fallback = ImUsersBlocksApiHystrix.class)
public interface ImUsersBlocksFeign {
    /**
     * 添加IM用户黑名单
     *
     * @param imUsersBlocks
     * @return
     */
    @PostMapping(value = "/imUsersBlocks/insert")
    int insert(@RequestBody ImUsersBlocks imUsersBlocks);

    /**
     * 删除IM用户黑名单
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/imUsersBlocks/deleteById/{id}")
    int deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改IM用户黑名单
     *
     * @param imUsersBlocks
     * @return
     */
    @PutMapping(value = "/imUsersBlocks/edit")
    int edit(@RequestBody ImUsersBlocks imUsersBlocks);

    /**
     * 根据ID查询
     *
     * @param id
     * @returnimUsersBlocks
     */
    @GetMapping(value = "/imUsersBlocks/queryById/{id}")
    ImUsersBlocks queryById(@PathVariable(value = "id") int id);

    /**
     * 前端分页查询IM用户黑名单
     *
     * @param pageNo        分页索引
     * @param pageSize      每页显示数量
     * @param imUsersBlocks 查询条件
     * @return
     */
    @PostMapping(value = "/imUsersBlocks/front/findByPage")
    PageInfo<ImUsersBlocks> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                               @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                               @RequestBody ImUsersBlocks imUsersBlocks);
}