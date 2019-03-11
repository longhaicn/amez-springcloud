package com.union.aimei.common.feign.pc.store;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.store.hystrix.StoreLevelUpgradeLogApiHystrix;
import com.union.aimei.common.model.store.StoreLevelUpgradeLog;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 店铺成长值记录
 *
 * @author liurenkai
 * @time 2018/1/12 17:36
 */
@FeignClient(serviceId = "PC-STORE-SERVICE", fallback = StoreLevelUpgradeLogApiHystrix.class)
public interface StoreLevelUpgradeLogFeign {
    /**
     * 添加店铺成长值记录
     *
     * @param storeLevelUpgradeLog
     * @return
     */
    @PostMapping(value = "/storeLevelUpgradeLog/insert")
    int insert(@RequestBody StoreLevelUpgradeLog storeLevelUpgradeLog);

    /**
     * 删除店铺成长值记录
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/storeLevelUpgradeLog/deleteById/{id}")
    int deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改店铺成长值记录
     *
     * @param storeLevelUpgradeLog
     * @return
     */
    @PutMapping(value = "/storeLevelUpgradeLog/edit")
    int edit(@RequestBody StoreLevelUpgradeLog storeLevelUpgradeLog);

    /**
     * 根据ID查询
     *
     * @param id
     * @returnstoreLevelUpgradeLog
     */
    @GetMapping(value = "/storeLevelUpgradeLog/queryById/{id}")
    StoreLevelUpgradeLog queryById(@PathVariable(value = "id") int id);

    /**
     * 前端分页查询店铺成长值记录
     *
     * @param pageNo               分页索引
     * @param pageSize             每页显示数量
     * @param storeLevelUpgradeLog 查询条件
     * @return
     */
    @PostMapping(value = "/storeLevelUpgradeLog/front/findByPage")
    PageInfo<StoreLevelUpgradeLog> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0")
                                                              Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10")
                                                              Integer pageSize, @RequestBody StoreLevelUpgradeLog storeLevelUpgradeLog);
}