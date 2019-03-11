package com.union.aimei.app.api.store;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.store.GrowthRuleFeign;
import com.union.aimei.common.model.store.GrowthRule;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseMessageFactory;
import com.union.common.utils.constant.ResponseContants;
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
        ResponseMessage result = ResponseMessageFactory.newInstance();
        PageInfo<GrowthRule> page = growthRuleFeign.findByPageForFront(pageNo, pageSize, growthRule);
        if (page != null) {
            result.setData(page);
        } else {
            result.setCode(ResponseContants.QUERY_EMPTY);
            result.setMessage(ResponseContants.QUERY_EMPTY_MESSAGE);
        }
        return result;
    }

}