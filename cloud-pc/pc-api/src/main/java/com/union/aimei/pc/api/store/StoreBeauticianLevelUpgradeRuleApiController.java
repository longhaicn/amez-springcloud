package com.union.aimei.pc.api.store;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreBeauticianLevelUpgradeRule;
import com.union.aimei.common.vo.store.pc.StoreBeauticianLevelUpgradeRuleByBatchVo;
import com.union.aimei.common.feign.pc.store.StoreBeauticianLevelUpgradeRuleFeign;
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
public class StoreBeauticianLevelUpgradeRuleApiController {
    @Resource
    private StoreBeauticianLevelUpgradeRuleFeign storeBeauticianLevelUpgradeRuleFeign;

    /**
     * 分页查询美容师成长值规则设置
     *
     * @param pageNo                          分页索引
     * @param pageSize                        每页数量
     * @param storeBeauticianLevelUpgradeRule 查询条件
     * @return ResponseMessage<StoreBeauticianLevelUpgradeRule>
     */
    @ApiOperation(httpMethod = "POST", value = "分页查询美容师成长值规则设置")
    @PostMapping("/front/findByPage")
    public ResponseMessage<PageInfo<StoreBeauticianLevelUpgradeRule>> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                         @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                         @ApiParam(value = "查询条件") @RequestBody StoreBeauticianLevelUpgradeRule storeBeauticianLevelUpgradeRule) {
        return new ResponseMessage(this.storeBeauticianLevelUpgradeRuleFeign.findByPageForFront(pageNo, pageSize, storeBeauticianLevelUpgradeRule));
    }

    /**
     * 添加StoreBeauticianLevelUpgradeRule
     *
     * @param storeBeauticianLevelUpgradeRule
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "添加美容师成长值规则设置")
    @PostMapping("/insert")
    public ResponseMessage insert(@RequestBody StoreBeauticianLevelUpgradeRule storeBeauticianLevelUpgradeRule) {
        return new ResponseMessage(this.storeBeauticianLevelUpgradeRuleFeign.insert(storeBeauticianLevelUpgradeRule));
    }

    /**
     * 删除StoreBeauticianLevelUpgradeRule
     *
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "DELETE", value = "删除美容师成长值规则设置")
    @DeleteMapping("/deleteById/{id}")
    public ResponseMessage deleteById(@PathVariable(value = "id") int id) {
        return new ResponseMessage(this.storeBeauticianLevelUpgradeRuleFeign.deleteById(id));
    }

    /**
     * 修改StoreBeauticianLevelUpgradeRule
     *
     * @param storeBeauticianLevelUpgradeRule
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "编辑美容师成长值规则设置")
    @PutMapping("/edit")
    public ResponseMessage edit(@RequestBody StoreBeauticianLevelUpgradeRule storeBeauticianLevelUpgradeRule) {
        return new ResponseMessage(this.storeBeauticianLevelUpgradeRuleFeign.edit(storeBeauticianLevelUpgradeRule));
    }

    /**
     * 根据ID查询StoreBeauticianLevelUpgradeRule
     *
     * @param id
     * @returnstoreBeauticianLevelUpgradeRule
     */
    @ApiOperation(httpMethod = "GET", value = "通过ID查询美容师成长值规则设置")
    @GetMapping("/queryById/{id}")
    public ResponseMessage<StoreBeauticianLevelUpgradeRule> queryById(@PathVariable(value = "id") int id) {
        return new ResponseMessage(this.storeBeauticianLevelUpgradeRuleFeign.queryById(id));
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
        return new ResponseMessage(this.storeBeauticianLevelUpgradeRuleFeign.addByBatch(storeBeauticianLevelUpgradeRuleByBatchVo));
    }

    /**
     * 查询所有美容师成长值规则设置
     *
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "查询所有美容师成长值规则设置")
    @GetMapping("/findListByAll")
    public ResponseMessage<List<StoreBeauticianLevelUpgradeRule>> findListByAll() {
        return new ResponseMessage(this.storeBeauticianLevelUpgradeRuleFeign.findListByAll());
    }
}