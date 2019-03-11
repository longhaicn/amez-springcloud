package com.union.aimei.pc.store.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreLevelUpgradeRule;
import com.union.aimei.pc.store.service.StoreLevelUpgradeRuleService;
import com.union.aimei.common.vo.store.pc.StoreLevelUpgradeRuleByBatchVo;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 店铺成长值规则设置
 *
 * @author liurenkai
 * @time 2018/1/12 17:36
 */
@Api(tags = "店铺成长值规则设置")
@RestController
@RequestMapping(value = "storeLevelUpgradeRule")
public class StoreLevelUpgradeRuleController {
    @Resource
    private StoreLevelUpgradeRuleService storeLevelUpgradeRuleService;

    /**
     * 分页查询店铺成长值规则设置
     *
     * @param pageNo                分页索引
     * @param pageSize              每页数量
     * @param storeLevelUpgradeRule 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "分页查询店铺成长值规则设置")
    @PostMapping("/front/findByPage")
    public ResponseMessage<PageInfo<StoreLevelUpgradeRule>> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo,
                                                                               @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize,
                                                                               @ApiParam(value = "查询条件") @RequestBody StoreLevelUpgradeRule storeLevelUpgradeRule) {
        return this.storeLevelUpgradeRuleService.findByPageForFront(pageNo, pageSize, storeLevelUpgradeRule);
    }

    @PostMapping("/insert")
    public int insert(@RequestBody StoreLevelUpgradeRule storeLevelUpgradeRule) {
        return this.storeLevelUpgradeRuleService.addObj(storeLevelUpgradeRule);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable(value = "id") int id) {
        return this.storeLevelUpgradeRuleService.deleteObjById(id);
    }

    @PutMapping("/edit")
    public int edit(@RequestBody StoreLevelUpgradeRule storeLevelUpgradeRule) {
        return this.storeLevelUpgradeRuleService.modifyObj(storeLevelUpgradeRule);
    }

    @GetMapping("/queryById/{id}")
    public StoreLevelUpgradeRule queryById(@PathVariable(value = "id") int id) {
        return this.storeLevelUpgradeRuleService.queryObjById(id);
    }

    /**
     * 批量添加店铺成长值规则设置
     *
     * @param storeLevelUpgradeRuleByBatchVo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "批量添加店铺成长值规则设置")
    @PostMapping("/addByBatch")
    public ResponseMessage addByBatch(@ApiParam(value = "批量店铺成长值规则设置") @RequestBody StoreLevelUpgradeRuleByBatchVo storeLevelUpgradeRuleByBatchVo) {
        return this.storeLevelUpgradeRuleService.addByBatch(storeLevelUpgradeRuleByBatchVo);
    }

    /**
     * 查询所有店铺成长值规则设置
     *
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "查询所有店铺成长值规则设置")
    @GetMapping("/findListByAll")
    public ResponseMessage<List<StoreLevelUpgradeRule>> findListByAll() {
        return this.storeLevelUpgradeRuleService.findListByAll();
    }

}