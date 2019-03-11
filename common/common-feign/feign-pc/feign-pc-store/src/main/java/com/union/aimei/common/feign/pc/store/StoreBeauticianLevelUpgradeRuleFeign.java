package com.union.aimei.common.feign.pc.store;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.store.hystrix.StoreBeauticianLevelUpgradeRuleApiHystrix;
import com.union.aimei.common.model.store.StoreBeauticianLevelUpgradeRule;
import com.union.aimei.common.vo.store.pc.StoreBeauticianLevelUpgradeRuleByBatchVo;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 美容师成长值规则设置
 *
 * @author liurenkai
 * @time 2018/1/12 17:34
 */
@FeignClient(serviceId = "PC-STORE-SERVICE", fallback = StoreBeauticianLevelUpgradeRuleApiHystrix.class)
public interface StoreBeauticianLevelUpgradeRuleFeign {
    /**
     * 添加美容师成长值规则设置
     *
     * @param storeBeauticianLevelUpgradeRule
     * @return
     */
    @PostMapping(value = "/storeBeauticianLevelUpgradeRule/insert")
    int insert(@RequestBody StoreBeauticianLevelUpgradeRule storeBeauticianLevelUpgradeRule);

    /**
     * 删除美容师成长值规则设置
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/storeBeauticianLevelUpgradeRule/deleteById/{id}")
    int deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改美容师成长值规则设置
     *
     * @param storeBeauticianLevelUpgradeRule
     * @return
     */
    @PutMapping(value = "/storeBeauticianLevelUpgradeRule/edit")
    int edit(@RequestBody StoreBeauticianLevelUpgradeRule storeBeauticianLevelUpgradeRule);

    /**
     * 根据ID查询
     *
     * @param id
     * @returnstoreBeauticianLevelUpgradeRule
     */
    @GetMapping(value = "/storeBeauticianLevelUpgradeRule/queryById/{id}")
    StoreBeauticianLevelUpgradeRule queryById(@PathVariable(value = "id") int id);

    /**
     * 分页查询美容师成长值规则设置
     *
     * @param pageNo                          分页索引
     * @param pageSize                        每页数量
     * @param storeBeauticianLevelUpgradeRule 查询条件
     * @return
     */
    @PostMapping(value = "/storeBeauticianLevelUpgradeRule/front/findByPage")
    ResponseMessage<PageInfo<StoreBeauticianLevelUpgradeRule>> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                  @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                  @RequestBody StoreBeauticianLevelUpgradeRule storeBeauticianLevelUpgradeRule);

    /**
     * 批量添加美容师成长值规则设置
     *
     * @param storeBeauticianLevelUpgradeRuleByBatchVo
     * @return
     */
    @PostMapping("/storeBeauticianLevelUpgradeRule/addByBatch")
    ResponseMessage addByBatch(@RequestBody StoreBeauticianLevelUpgradeRuleByBatchVo storeBeauticianLevelUpgradeRuleByBatchVo);

    /**
     * 查询所有美容师成长值规则设置
     *
     * @return
     */
    @GetMapping("/storeBeauticianLevelUpgradeRule/findListByAll")
    ResponseMessage<List<StoreBeauticianLevelUpgradeRule>> findListByAll();

}