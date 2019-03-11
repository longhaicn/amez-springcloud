package com.union.aimei.common.feign.pc.store;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.store.hystrix.StoreBeauticianLevelApiHystrix;
import com.union.aimei.common.model.store.StoreBeauticianLevel;
import com.union.aimei.common.vo.store.pc.StoreBeauticianLevelByBatchVo;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 美容师等级
 *
 * @author liurenkai
 * @time 2018/1/12 17:34
 */
@FeignClient(serviceId = "PC-STORE-SERVICE", fallback = StoreBeauticianLevelApiHystrix.class)
public interface StoreBeauticianLevelFeign {
    /**
     * 添加美容师等级
     *
     * @param storeBeauticianLevel
     * @return
     */
    @PostMapping(value = "/storeBeauticianLevel/insert")
    int insert(@RequestBody StoreBeauticianLevel storeBeauticianLevel);

    /**
     * 删除美容师等级
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/storeBeauticianLevel/deleteById/{id}")
    int deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改美容师等级
     *
     * @param storeBeauticianLevel
     * @return
     */
    @PutMapping(value = "/storeBeauticianLevel/edit")
    int edit(@RequestBody StoreBeauticianLevel storeBeauticianLevel);

    /**
     * 根据ID查询
     *
     * @param id
     * @returnstoreBeauticianLevel
     */
    @GetMapping(value = "/storeBeauticianLevel/queryById/{id}")
    StoreBeauticianLevel queryById(@PathVariable(value = "id") int id);

    /**
     * 前端分页查询美容师等级
     *
     * @param pageNo               分页索引
     * @param pageSize             每页显示数量
     * @param storeBeauticianLevel 查询条件
     * @return
     */
    @PostMapping(value = "/storeBeauticianLevel/front/findByPage")
    ResponseMessage<PageInfo<StoreBeauticianLevel>> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                       @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                       @RequestBody StoreBeauticianLevel storeBeauticianLevel);

    /**
     * 批量添加美容师等级
     *
     * @param storeBeauticianLevelByBatchVo
     * @return
     */
    @PostMapping("/storeBeauticianLevel/addByBatch")
    ResponseMessage addByBatch(@RequestBody StoreBeauticianLevelByBatchVo storeBeauticianLevelByBatchVo);

    /**
     * 查询所有美容师等级
     *
     * @return
     */
    @GetMapping("/storeBeauticianLevel/findListByAll")
    ResponseMessage<List<StoreBeauticianLevel>> findListByAll();

    /**
     * 根据成长值获取美容师级别
     *
     * @param growup 成长值
     * @return
     */
    @GetMapping("/storeBeauticianLevel/getLevelBySetionGrowup/{growup}")
    ResponseMessage<StoreBeauticianLevel> getLevelBySetionGrowup(@PathVariable("growup") Integer growup);
}