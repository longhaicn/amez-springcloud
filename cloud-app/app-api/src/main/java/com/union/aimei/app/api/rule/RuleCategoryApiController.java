package com.union.aimei.app.api.rule;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.rule.RuleCategoryFeign;
import com.union.aimei.common.model.rule.RuleCategory;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 规则分类
 *
 * @author liurenkai
 * @time 2018/5/10 17:35
 */
@Api(tags = "规则分类")
@RestController
@RequestMapping(value = "ruleCategory")
public class RuleCategoryApiController {
    @Resource
    private RuleCategoryFeign ruleCategoryFeign;

    /**
     * 分页查询规则分类
     *
     * @param pageNo       分页索引
     * @param pageSize     每页数量
     * @param ruleCategory 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "分页查询规则分类")
    @PostMapping("/front/findByPage")
    public ResponseMessage<PageInfo<RuleCategory>> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                      @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                      @ApiParam(value = "查询条件") @RequestBody RuleCategory ruleCategory) {
        return this.ruleCategoryFeign.findByPageForFront(pageNo, pageSize, ruleCategory);
    }

}