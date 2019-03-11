package com.union.aimei.pc.api.store;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreLevelUpgradeRule;
import com.union.aimei.common.vo.store.pc.StoreLevelUpgradeRuleByBatchVo;
import com.union.aimei.common.feign.pc.store.StoreLevelUpgradeRuleFeign;
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
public class StoreLevelUpgradeRuleApiController {
    @Resource
    private StoreLevelUpgradeRuleFeign storeLevelUpgradeRuleFeign;

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
    public ResponseMessage<PageInfo<StoreLevelUpgradeRule>> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                               @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                               @ApiParam(value = "查询条件") @RequestBody StoreLevelUpgradeRule storeLevelUpgradeRule) {
        return new ResponseMessage(this.storeLevelUpgradeRuleFeign.findByPageForFront(pageNo, pageSize, storeLevelUpgradeRule));
    }

    /**
     * 添加StoreLevelUpgradeRule
     *
     * @param storeLevelUpgradeRule
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "添加店铺成长值规则设置")
    @PostMapping("/insert")
    public ResponseMessage insert(@RequestBody StoreLevelUpgradeRule storeLevelUpgradeRule) {
        return new ResponseMessage(this.storeLevelUpgradeRuleFeign.insert(storeLevelUpgradeRule));
    }

    /**
     * 删除StoreLevelUpgradeRule
     *
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "DELETE", value = "删除店铺成长值规则设置")
    @DeleteMapping("/deleteById/{id}")
    public ResponseMessage deleteById(@PathVariable(value = "id") int id) {
        return new ResponseMessage(this.storeLevelUpgradeRuleFeign.deleteById(id));
    }

    /**
     * 修改StoreLevelUpgradeRule
     *
     * @param storeLevelUpgradeRule
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "编辑店铺成长值规则设置")
    @PutMapping("/edit")
    public ResponseMessage edit(@RequestBody StoreLevelUpgradeRule storeLevelUpgradeRule) {
        return new ResponseMessage(this.storeLevelUpgradeRuleFeign.edit(storeLevelUpgradeRule));
    }

    /**
     * 根据ID查询StoreLevelUpgradeRule
     *
     * @param id
     * @returnstoreLevelUpgradeRule
     */
    @ApiOperation(httpMethod = "GET", value = "通过ID查询店铺成长值规则设置")
    @GetMapping("/queryById/{id}")
    public ResponseMessage<StoreLevelUpgradeRule> queryById(@PathVariable(value = "id") int id) {
        return new ResponseMessage(this.storeLevelUpgradeRuleFeign.queryById(id));
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
        return new ResponseMessage(this.storeLevelUpgradeRuleFeign.addByBatch(storeLevelUpgradeRuleByBatchVo));
    }

    /**
     * 查询所有店铺成长值规则设置
     *
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "查询所有店铺成长值规则设置")
    @GetMapping("/findListByAll")
    public ResponseMessage<List<StoreLevelUpgradeRule>> findListByAll() {
        return new ResponseMessage(this.storeLevelUpgradeRuleFeign.findListByAll());
    }
}