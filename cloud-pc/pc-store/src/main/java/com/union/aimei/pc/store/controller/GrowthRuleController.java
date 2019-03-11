package com.union.aimei.pc.store.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.constant.store.GrowthRuleConstant;
import com.union.aimei.common.model.store.GrowthRule;
import com.union.aimei.common.vo.store.app.GrowthRuleVo;
import com.union.aimei.pc.store.service.GrowthRuleService;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.exception.ClientException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @author caizhaoming
 * @version 1.1
 * @create 2018-06-21 11:43
 **/
@Api(tags = "成长规则")
@RestController
@RequestMapping(value = "growthRule")
public class GrowthRuleController {
    @Resource
    private GrowthRuleService growthRuleService;

    @PostMapping("/front/findByPage")
    public PageInfo<GrowthRule> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0")
                                                           Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10")
                                                           Integer pageSize, @ApiParam(value = "查询条件") @RequestBody GrowthRule growthRule) {
        return this.growthRuleService.findByPageForFront(pageNo, pageSize, growthRule);
    }

    @PostMapping("/insert")
    public int insert(@RequestBody GrowthRule growthRule) {
        return this.growthRuleService.addObj(growthRule);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable(value = "id") int id) {
        return this.growthRuleService.deleteObjById(id);
    }

    @PutMapping("/edit")
    public int edit(@RequestBody GrowthRule growthRule) {
        return this.growthRuleService.modifyObj(growthRule);
    }

    @GetMapping("/queryById/{id}")
    public GrowthRule queryById(@PathVariable(value = "id") int id) {
        return this.growthRuleService.queryObjById(id);
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
        return this.growthRuleService.checkCode(ruleType, code);
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
        return this.growthRuleService.saveGrowthRule(growthRule);
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
        return this.growthRuleService.editGrowthRule(growthRule);
    }

    /**
     * 保存门店、美容师成长值(v1.1.1)
     *
     * @param growthRuleVo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "保存门店、美容师成长值(v1.1.1)")
    @PostMapping("/1.1.1/saveGrowthRule")
    public ResponseMessage saveGrowthRuleV111(@ApiParam(value = "参数") @RequestBody GrowthRuleVo growthRuleVo) {
        //参数校验
        Optional.of(growthRuleVo)
                .filter(vo -> !StringUtils.isBlank(vo.getCode()))
                .orElseThrow(() -> new ClientException(GrowthRuleConstant.REQUIRED_PARAMETER_CODE, GrowthRuleConstant.BREQUIRED_PARAMETER_MISSING));
        return this.growthRuleService.saveGrowthRuleV111(growthRuleVo);
    }

    /**
     * 批量保存门店、美容师成长值(v1.1.1)
     *
     * @param growthRuleVoList
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "批量保存门店、美容师成长值(v1.1.1)")
    @PostMapping("/1.1.1/saveBatchGrowthRule")
    public ResponseMessage saveBatchGrowthRuleV111(@ApiParam(value = "参数") @RequestBody List<GrowthRuleVo> growthRuleVoList) {
        //参数校验
        growthRuleVoList.forEach(growthRuleVo ->
                Optional.of(growthRuleVo)
                        .filter(vo -> !StringUtils.isBlank(vo.getCode()))
                        .orElseThrow(() -> new ClientException(GrowthRuleConstant.REQUIRED_PARAMETER_CODE, GrowthRuleConstant.BREQUIRED_PARAMETER_MISSING))
        );
        return this.growthRuleService.saveBatchGrowthRuleV111(growthRuleVoList);
    }

}