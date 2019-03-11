package com.union.aimei.common.feign.pc.store;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.store.hystrix.StoreLevelApiHystrix;
import com.union.aimei.common.model.store.StoreLevel;
import com.union.aimei.common.vo.store.pc.StoreLevelByBatchVo;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 店铺等级
 *
 * @author liurenkai
 * @time 2018/1/12 17:35
 */
@FeignClient(serviceId = "PC-STORE-SERVICE", fallback = StoreLevelApiHystrix.class)
public interface StoreLevelFeign {
    /**
     * 添加店铺等级
     *
     * @param storeLevel
     * @return
     */
    @PostMapping(value = "/storeLevel/insert")
    int insert(@RequestBody StoreLevel storeLevel);

    /**
     * 删除店铺等级
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/storeLevel/deleteById/{id}")
    int deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改店铺等级
     *
     * @param storeLevel
     * @return
     */
    @PutMapping(value = "/storeLevel/edit")
    int edit(@RequestBody StoreLevel storeLevel);

    /**
     * 根据ID查询
     *
     * @param id
     * @returnstoreLevel
     */
    @GetMapping(value = "/storeLevel/queryById/{id}")
    StoreLevel queryById(@PathVariable(value = "id") int id);

    /**
     * 分页查询店铺等级
     *
     * @param pageNo     分页索引
     * @param pageSize   每页数量
     * @param storeLevel 查询条件
     * @return
     */
    @PostMapping(value = "/storeLevel/front/findByPage")
    ResponseMessage<PageInfo<StoreLevel>> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                             @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                             @RequestBody StoreLevel storeLevel);

    /**
     * 批量添加店铺等级
     *
     * @param storeLevelByBatchVo
     * @return
     */
    @PostMapping("/storeLevel/addByBatch")
    ResponseMessage addByBatch(@RequestBody StoreLevelByBatchVo storeLevelByBatchVo);

    /**
     * 查询所有店铺等级
     *
     * @return
     */
    @GetMapping("/storeLevel/findListByAll")
    ResponseMessage<List<StoreLevel>> findListByAll();

}