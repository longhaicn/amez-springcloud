package com.union.aimei.common.feign.app.store;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.store.hystrix.GrowthRuleApiHystrix;
import com.union.aimei.common.model.store.GrowthRule;
import com.union.aimei.common.vo.store.app.GrowthRuleVo;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author caizhaoming
 * @version 1.1
 * @create 2018-06-21 11:43
 **/
@FeignClient(serviceId = "APP-STORE-SERVICE", fallback = GrowthRuleApiHystrix.class)
public interface GrowthRuleFeign {
    /**
     * 添加成长规则
     *
     * @param growthRule
     * @return
     */
    @PostMapping(value = "/growthRule/insert")
    int insert(@RequestBody GrowthRule growthRule);

    /**
     * 删除成长规则
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/growthRule/deleteById/{id}")
    int deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改成长规则
     *
     * @param growthRule
     * @return
     */
    @PutMapping(value = "/growthRule/edit")
    int edit(@RequestBody GrowthRule growthRule);

    /**
     * 根据ID查询
     *
     * @param id
     * @returngrowthRule
     */
    @GetMapping(value = "/growthRule/queryById/{id}")
    GrowthRule queryById(@PathVariable(value = "id") int id);

    /**
     * 前端分页查询成长规则
     *
     * @param pageNo     分页索引
     * @param pageSize   每页显示数量
     * @param growthRule 查询条件
     * @return
     */
    @PostMapping(value = "/growthRule/front/findByPage")
    PageInfo<GrowthRule> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0")
                                                    Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10")
                                                    Integer pageSize, @RequestBody GrowthRule growthRule);

    /**
     * 保存门店、美容师成长值(v1.1.1)
     *
     * @param growthRuleVo
     * @return
     */
    @PostMapping("/growthRule/1.1.1/saveGrowthRule")
    ResponseMessage saveGrowthRuleV111(@RequestBody GrowthRuleVo growthRuleVo);

    /**
     * 批量保存门店、美容师成长值(v1.1.1)
     *
     * @param growthRuleVoList
     * @return
     */
    @PostMapping("/growthRule/1.1.1/saveBatchGrowthRule")
    ResponseMessage saveBatchGrowthRuleV111(@RequestBody List<GrowthRuleVo> growthRuleVoList);
}