package com.union.aimei.app.api.rule;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.rule.RuleLevelFeign;
import com.union.aimei.common.model.rule.RuleLevel;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 规则等级
 *
 * @author liurenkai
 * @time 2018/5/10 17:35
 */
@Api(tags = "规则等级")
@RestController
@RequestMapping(value = "ruleLevel")
public class RuleLevelApiController {
    @Resource
    private RuleLevelFeign ruleLevelFeign;

    /**
     * 分页查询规则等级
     *
     * @param pageNo    分页索引
     * @param pageSize  每页数量
     * @param ruleLevel 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "分页查询规则等级")
    @PostMapping("/front/findByPage")
    public ResponseMessage<PageInfo<RuleLevel>> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                   @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                   @ApiParam(value = "查询条件") @RequestBody RuleLevel ruleLevel) {
        return this.ruleLevelFeign.findByPageForFront(pageNo, pageSize, ruleLevel);
    }

}