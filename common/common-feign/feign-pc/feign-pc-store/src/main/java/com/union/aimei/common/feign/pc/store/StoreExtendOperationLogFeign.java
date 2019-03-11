package com.union.aimei.common.feign.pc.store;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.store.hystrix.StoreExtendOperationLogApiHystrix;
import com.union.aimei.common.model.store.StoreExtendOperationLog;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 店铺扩展操作日志
 *
 * @author liurenkai
 * @time 2018/1/12 17:35
 */
@FeignClient(serviceId = "PC-STORE-SERVICE", fallback = StoreExtendOperationLogApiHystrix.class)
public interface StoreExtendOperationLogFeign {
    /**
     * 添加店铺扩展操作日志
     *
     * @param storeExtendOperationLog
     * @return
     */
    @PostMapping(value = "/storeExtendOperationLog/insert")
    int insert(@RequestBody StoreExtendOperationLog storeExtendOperationLog);

    /**
     * 删除店铺扩展操作日志
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/storeExtendOperationLog/deleteById/{id}")
    int deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改店铺扩展操作日志
     *
     * @param storeExtendOperationLog
     * @return
     */
    @PutMapping(value = "/storeExtendOperationLog/edit")
    int edit(@RequestBody StoreExtendOperationLog storeExtendOperationLog);

    /**
     * 根据ID查询
     *
     * @param id
     * @returnstoreExtendOperationLog
     */
    @GetMapping(value = "/storeExtendOperationLog/queryById/{id}")
    StoreExtendOperationLog queryById(@PathVariable(value = "id") int id);

    /**
     * 前端分页查询店铺扩展操作日志
     *
     * @param pageNo                  分页索引
     * @param pageSize                每页显示数量
     * @param storeExtendOperationLog 查询条件
     * @return
     */
    @PostMapping(value = "/storeExtendOperationLog/front/findByPage")
    PageInfo<StoreExtendOperationLog> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0")
                                                                 Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10")
                                                                 Integer pageSize, @RequestBody StoreExtendOperationLog storeExtendOperationLog);
}