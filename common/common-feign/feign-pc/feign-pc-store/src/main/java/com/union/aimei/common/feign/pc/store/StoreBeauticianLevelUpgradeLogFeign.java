package com.union.aimei.common.feign.pc.store;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.store.hystrix.StoreBeauticianLevelUpgradeLogApiHystrix;
import com.union.aimei.common.model.store.StoreBeauticianLevelUpgradeLog;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 美容师成长值记录
 *
 * @author liurenkai
 * @time 2018/1/12 17:34
 */
@FeignClient(serviceId = "PC-STORE-SERVICE", fallback = StoreBeauticianLevelUpgradeLogApiHystrix.class)
public interface StoreBeauticianLevelUpgradeLogFeign {
    /**
     * 添加美容师成长值记录
     *
     * @param storeBeauticianLevelUpgradeLog
     * @return
     */
    @PostMapping(value = "/storeBeauticianLevelUpgradeLog/insert")
    int insert(@RequestBody StoreBeauticianLevelUpgradeLog storeBeauticianLevelUpgradeLog);

    /**
     * 删除美容师成长值记录
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/storeBeauticianLevelUpgradeLog/deleteById/{id}")
    int deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改美容师成长值记录
     *
     * @param storeBeauticianLevelUpgradeLog
     * @return
     */
    @PutMapping(value = "/storeBeauticianLevelUpgradeLog/edit")
    int edit(@RequestBody StoreBeauticianLevelUpgradeLog storeBeauticianLevelUpgradeLog);

    /**
     * 根据ID查询
     *
     * @param id
     * @returnstoreBeauticianLevelUpgradeLog
     */
    @GetMapping(value = "/storeBeauticianLevelUpgradeLog/queryById/{id}")
    StoreBeauticianLevelUpgradeLog queryById(@PathVariable(value = "id") int id);

    /**
     * 前端分页查询美容师成长值记录
     *
     * @param pageNo                         分页索引
     * @param pageSize                       每页显示数量
     * @param storeBeauticianLevelUpgradeLog 查询条件
     * @return
     */
    @PostMapping(value = "/storeBeauticianLevelUpgradeLog/front/findByPage")
    PageInfo<StoreBeauticianLevelUpgradeLog> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0")
                                                                        Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10")
                                                                        Integer pageSize, @RequestBody StoreBeauticianLevelUpgradeLog storeBeauticianLevelUpgradeLog);
}