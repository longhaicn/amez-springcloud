package com.union.aimei.pc.api.store;

import com.union.aimei.common.model.store.GrowthRule;
import com.union.aimei.common.feign.pc.store.GrowthRuleFeign;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author caizhaoming
 * @version 1.1
 * @create 2018-06-21 11:43
 **/
@Api(tags = "成长规则")
@RestController
@RequestMapping(value = "growthRule")
public class GrowthRuleApiController {
    @Resource
    private GrowthRuleFeign growthRuleFeign;

    /**
     * 分页查询
     *
     * @param pageNo     分页索引
     * @param pageSize   每页显示数量
     * @param growthRule 查询条件
     * @return ResponseMessage<GrowthRule>
     */
    @ApiOperation(httpMethod = "POST", value = "前端分页查询成长规则")
    @PostMapping("/front/findByPage")
    public ResponseMessage<GrowthRule> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0")
                                                                  Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10")
                                                                  Integer pageSize, @ApiParam(value = "查询条件") @RequestBody GrowthRule growthRule) {
        return new ResponseMessage(this.growthRuleFeign.findByPageForFront(pageNo, pageSize, growthRule));
    }

    /**
     * 根据ID查询GrowthRule
     *
     * @param id
     * @returngrowthRule
     */
    @ApiOperation(httpMethod = "GET", value = "通过ID查询成长规则")
    @GetMapping("/queryById/{id}")
    public ResponseMessage<GrowthRule> queryById(@PathVariable(value = "id") int id) {
        return new ResponseMessage(this.growthRuleFeign.queryById(id));
    }

    /**
     * 校验编码是否重复
     *
     * @param ruleType
     * @param code
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "校验编码是否重复")
    @GetMapping(value = "/checkCode/{ruleType}/{code}")
    public ResponseMessage checkCode(@ApiParam(value = "类型：0-门店、1-美容师") @PathVariable(value = "ruleType") byte ruleType,
                                     @ApiParam(value = "编码") @PathVariable(value = "code") String code) {
        return new ResponseMessage(this.growthRuleFeign.checkCode(ruleType, code));
    }

    /**
     * 保存成长规则
     *
     * @param growthRule
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "保存成长规则")
    @PostMapping("/saveGrowthRule")
    public ResponseMessage saveGrowthRule(@ApiParam(value = "数据") @RequestBody GrowthRule growthRule) {
        return new ResponseMessage(this.growthRuleFeign.saveGrowthRule(growthRule));
    }

    /**
     * 修改成长规则
     *
     * @param growthRule
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "修改成长规则")
    @PostMapping("/editGrowthRule")
    public ResponseMessage editGrowthRule(@ApiParam(value = "数据") @RequestBody GrowthRule growthRule) {
        return new ResponseMessage(this.growthRuleFeign.editGrowthRule(growthRule));
    }
}