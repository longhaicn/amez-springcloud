package com.union.aimei.common.feign.pc.system;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.system.hystrix.BaseHomeAreaApiHystrix;
import com.union.aimei.common.model.system.BaseHomeArea;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 区域表
 *
 * @author caizhaoming
 * @create 2018-05-23 10:49
 **/
@FeignClient(serviceId = "pc-system-service", fallback = BaseHomeAreaApiHystrix.class)
public interface BaseHomeAreaFeign {
    /**
     * 添加首页区域表
     *
     * @param baseHomeArea
     * @return
     */
    @PostMapping(value = "/baseHomeArea/insert")
    ResponseMessage insert(@RequestBody BaseHomeArea baseHomeArea);

    /**
     * 删除首页区域表
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/baseHomeArea/deleteById/{id}")
    int deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改首页区域表
     *
     * @param baseHomeArea
     * @return
     */
    @PutMapping(value = "/baseHomeArea/edit")
    int edit(@RequestBody BaseHomeArea baseHomeArea);

    /**
     * 根据ID查询
     *
     * @param id
     * @returnbaseHomeArea
     */
    @GetMapping(value = "/baseHomeArea/queryById/{id}")
    BaseHomeArea queryById(@PathVariable(value = "id") int id);

    /**
     * 前端分页查询首页区域表
     *
     * @param pageNo       分页索引
     * @param pageSize     每页显示数量
     * @param baseHomeArea 查询条件
     * @return
     */
    @PostMapping(value = "/baseHomeArea/front/findByPage")
    PageInfo<BaseHomeArea> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0")
                                                      Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10")
                                                      Integer pageSize, @RequestBody BaseHomeArea baseHomeArea);

    /**
     * 添加数据(v1.1.0)
     *
     * @param baseHomeArea
     * @return
     */
    @PostMapping("/baseHomeArea/1.1.0/insertBasehomeArea")
    ResponseMessage insertBasehomeAreaV110(@RequestBody BaseHomeArea baseHomeArea);


    /**
     * 根据区域数据获取list(v1.1.0)
     *
     * @param baseHomeArea
     * @return
     */
    @PostMapping("/baseHomeArea/1.1.0/findForFront")
    ResponseMessage<List<BaseHomeArea>> findForFrontV110(@RequestBody BaseHomeArea baseHomeArea);

}