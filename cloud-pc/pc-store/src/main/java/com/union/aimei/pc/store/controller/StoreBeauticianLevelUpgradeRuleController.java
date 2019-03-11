package com.union.aimei.pc.store.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreBeauticianLevelUpgradeRule;
import com.union.aimei.pc.store.service.StoreBeauticianLevelUpgradeRuleService;
import com.union.aimei.common.vo.store.pc.StoreBeauticianLevelUpgradeRuleByBatchVo;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 美容师成长值规则设置
 *
 * @author liurenkai
 * @time 2018/1/12 17:34
 */
@Api(tags = "美容师成长值规则设置")
@RestController
@RequestMapping(value = "storeBeauticianLevelUpgradeRule")
public class StoreBeauticianLevelUpgradeRuleController {
    @Resource
    private StoreBeauticianLevelUpgradeRuleService storeBeauticianLevelUpgradeRuleService;

    /**
     * 分页查询美容师成长值规则设置
     *
     * @param pageNo                          分页索引
     * @param pageSize                        每页数量
     * @param storeBeauticianLevelUpgradeRule 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "分页查询美容师成长值规则设置")
    @PostMapping("/front/findByPage")
    public ResponseMessage<PageInfo<StoreBeauticianLevelUpgradeRule>> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo,
                                                                                         @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize,
                                                                                         @ApiParam(value = "查询条件") @RequestBody StoreBeauticianLevelUpgradeRule storeBeauticianLevelUpgradeRule) {
        return this.storeBeauticianLevelUpgradeRuleService.findByPageForFront(pageNo, pageSize, storeBeauticianLevelUpgradeRule);
    }

    @PostMapping("/insert")
    public int insert(@RequestBody StoreBeauticianLevelUpgradeRule storeBeauticianLevelUpgradeRule) {
        return this.storeBeauticianLevelUpgradeRuleService.addObj(storeBeauticianLevelUpgradeRule);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable(value = "id") int id) {
        return this.storeBeauticianLevelUpgradeRuleService.deleteObjById(id);
    }

    @PutMapping("/edit")
    public int edit(@RequestBody StoreBeauticianLevelUpgradeRule storeBeauticianLevelUpgradeRule) {
        return this.storeBeauticianLevelUpgradeRuleService.modifyObj(storeBeauticianLevelUpgradeRule);
    }

    @GetMapping("/queryById/{id}")
    public StoreBeauticianLevelUpgradeRule queryById(@PathVariable(value = "id") int id) {
        return this.storeBeauticianLevelUpgradeRuleService.queryObjById(id);
    }

    /**
     * 批量添加美容师成长值规则设置
     *
     * @param storeBeauticianLevelUpgradeRuleByBatchVo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "批量添加美容师成长值规则设置")
    @PostMapping("/addByBatch")
    public ResponseMessage addByBatch(@ApiParam(value = "批量美容师成长值规则设置") @RequestBody StoreBeauticianLevelUpgradeRuleByBatchVo storeBeauticianLevelUpgradeRuleByBatchVo) {
        return this.storeBeauticianLevelUpgradeRuleService.addByBatch(storeBeauticianLevelUpgradeRuleByBatchVo);
    }

    /**
     * 查询所有美容师成长值规则设置
     *
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "查询所有美容师成长值规则设置")
    @GetMapping("/findListByAll")
    public ResponseMessage<List<StoreBeauticianLevelUpgradeRule>> findListByAll() {
        return this.storeBeauticianLevelUpgradeRuleService.findListByAll();
    }

}