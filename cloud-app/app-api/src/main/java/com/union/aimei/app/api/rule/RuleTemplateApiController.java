package com.union.aimei.app.api.rule;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.rule.RuleTemplateFeign;
import com.union.aimei.common.model.rule.RuleTemplate;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 规则模板
 *
 * @author liurenkai
 * @time 2018/5/10 17:35
 */
@Api(tags = "规则模板")
@RestController
@RequestMapping(value = "ruleTemplate")
public class RuleTemplateApiController {
    @Resource
    private RuleTemplateFeign ruleTemplateFeign;

    /**
     * 分页查询规则模板
     *
     * @param pageNo       分页索引
     * @param pageSize     每页数量
     * @param ruleTemplate 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "分页查询规则模板")
    @PostMapping("/front/findByPage")
    public ResponseMessage<PageInfo<RuleTemplate>> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                      @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                      @ApiParam(value = "查询条件") @RequestBody RuleTemplate ruleTemplate) {
        return this.ruleTemplateFeign.findByPageForFront(pageNo, pageSize, ruleTemplate);
    }

}