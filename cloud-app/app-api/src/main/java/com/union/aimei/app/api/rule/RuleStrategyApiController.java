package com.union.aimei.app.api.rule;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.rule.RuleStrategyFeign;
import com.union.aimei.common.model.rule.RuleStrategy;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 规则策略
 *
 * @author liurenkai
 * @time 2018/5/10 17:35
 */
@Api(tags = "规则策略")
@RestController
@RequestMapping(value = "ruleStrategy")
public class RuleStrategyApiController {
    @Resource
    private RuleStrategyFeign ruleStrategyFeign;

    /**
     * 分页查询规则策略
     *
     * @param pageNo       分页索引
     * @param pageSize     每页数量
     * @param ruleStrategy 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "分页查询规则策略")
    @PostMapping("/front/findByPage")
    public ResponseMessage<PageInfo<RuleStrategy>> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                      @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                      @ApiParam(value = "查询条件") @RequestBody RuleStrategy ruleStrategy) {
        return this.ruleStrategyFeign.findByPageForFront(pageNo, pageSize, ruleStrategy);
    }

}