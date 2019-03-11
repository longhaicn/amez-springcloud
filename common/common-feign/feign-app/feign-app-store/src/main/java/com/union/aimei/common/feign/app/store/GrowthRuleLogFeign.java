package com.union.aimei.common.feign.app.store;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.store.hystrix.GrowthRuleLogApiHystrix;
import com.union.aimei.common.model.store.GrowthRuleLog;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author caizhaoming
 * @version 1.1
 * @create 2018-06-21 11:43
 **/
@FeignClient(serviceId = "APP-STORE-SERVICE", fallback = GrowthRuleLogApiHystrix.class)
public interface GrowthRuleLogFeign {
    /**
     * 添加成长规则日志表
     *
     * @param growthRuleLog
     * @return
     */
    @PostMapping(value = "/growthRuleLog/insert")
    int insert(@RequestBody GrowthRuleLog growthRuleLog);

    /**
     * 删除成长规则日志表
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/growthRuleLog/deleteById/{id}")
    int deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改成长规则日志表
     *
     * @param growthRuleLog
     * @return
     */
    @PutMapping(value = "/growthRuleLog/edit")
    int edit(@RequestBody GrowthRuleLog growthRuleLog);

    /**
     * 根据ID查询
     *
     * @param id
     * @returngrowthRuleLog
     */
    @GetMapping(value = "/growthRuleLog/queryById/{id}")
    GrowthRuleLog queryById(@PathVariable(value = "id") int id);

    /**
     * 前端分页查询成长规则日志表
     *
     * @param pageNo        分页索引
     * @param pageSize      每页显示数量
     * @param growthRuleLog 查询条件
     * @return
     */
    @PostMapping(value = "/growthRuleLog/front/findByPage")
    PageInfo<GrowthRuleLog> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0")
                                                       Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10")
                                                       Integer pageSize, @RequestBody GrowthRuleLog growthRuleLog);
}