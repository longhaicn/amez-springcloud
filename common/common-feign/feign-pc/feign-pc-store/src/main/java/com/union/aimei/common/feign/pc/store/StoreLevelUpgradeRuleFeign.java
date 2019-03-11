package com.union.aimei.common.feign.pc.store;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.store.hystrix.StoreLevelUpgradeRuleApiHystrix;
import com.union.aimei.common.model.store.StoreLevelUpgradeRule;
import com.union.aimei.common.vo.store.pc.StoreLevelUpgradeRuleByBatchVo;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 店铺成长值规则设置
 *
 * @author liurenkai
 * @time 2018/1/12 17:36
 */
@FeignClient(serviceId = "PC-STORE-SERVICE", fallback = StoreLevelUpgradeRuleApiHystrix.class)
public interface StoreLevelUpgradeRuleFeign {
    /**
     * 添加店铺成长值规则设置
     *
     * @param storeLevelUpgradeRule
     * @return
     */
    @PostMapping(value = "/storeLevelUpgradeRule/insert")
    int insert(@RequestBody StoreLevelUpgradeRule storeLevelUpgradeRule);

    /**
     * 删除店铺成长值规则设置
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/storeLevelUpgradeRule/deleteById/{id}")
    int deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改店铺成长值规则设置
     *
     * @param storeLevelUpgradeRule
     * @return
     */
    @PutMapping(value = "/storeLevelUpgradeRule/edit")
    int edit(@RequestBody StoreLevelUpgradeRule storeLevelUpgradeRule);

    /**
     * 根据ID查询
     *
     * @param id
     * @returnstoreLevelUpgradeRule
     */
    @GetMapping(value = "/storeLevelUpgradeRule/queryById/{id}")
    StoreLevelUpgradeRule queryById(@PathVariable(value = "id") int id);

    /**
     * 分页查询店铺成长值规则设置
     *
     * @param pageNo                分页索引
     * @param pageSize              每页数量
     * @param storeLevelUpgradeRule 查询条件
     * @return
     */
    @PostMapping(value = "/storeLevelUpgradeRule/front/findByPage")
    ResponseMessage<PageInfo<StoreLevelUpgradeRule>> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                        @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                        @RequestBody StoreLevelUpgradeRule storeLevelUpgradeRule);

    /**
     * 批量添加店铺成长值规则设置
     *
     * @param storeLevelUpgradeRuleByBatchVo
     * @return
     */
    @PostMapping("/storeLevelUpgradeRule/addByBatch")
    ResponseMessage addByBatch(@RequestBody StoreLevelUpgradeRuleByBatchVo storeLevelUpgradeRuleByBatchVo);

    /**
     * 查询所有店铺成长值规则设置
     *
     * @return
     */
    @GetMapping("/storeLevelUpgradeRule/findListByAll")
    ResponseMessage<List<StoreLevelUpgradeRule>> findListByAll();

}