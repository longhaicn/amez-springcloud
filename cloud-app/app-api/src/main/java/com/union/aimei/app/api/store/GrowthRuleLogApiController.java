package com.union.aimei.app.api.store;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.store.GrowthRuleLogFeign;
import com.union.aimei.common.model.store.GrowthRuleLog;
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
@Api(tags = "成长规则日志表")
@RestController
@RequestMapping(value = "growthRuleLog")
public class GrowthRuleLogApiController {
    @Resource
    private GrowthRuleLogFeign growthRuleLogFeign;

    /**
     * 分页查询
     *
     * @param pageNo        分页索引
     * @param pageSize      每页显示数量
     * @param growthRuleLog 查询条件
     * @return ResponseMessage<GrowthRuleLog>
     */
    @ApiOperation(httpMethod = "POST", value = "前端分页查询成长规则日志表")
    @PostMapping("/front/findByPage")
    public ResponseMessage<GrowthRuleLog> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0")
                                                                     Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10")
                                                                     Integer pageSize, @ApiParam(value = "查询条件") @RequestBody GrowthRuleLog growthRuleLog) {
        ResponseMessage result = ResponseMessageFactory.newInstance();
        PageInfo<GrowthRuleLog> page = growthRuleLogFeign.findByPageForFront(pageNo, pageSize, growthRuleLog);
        if (page != null) {
            result.setData(page);
        } else {
            result.setCode(ResponseContants.QUERY_EMPTY);
            result.setMessage(ResponseContants.QUERY_EMPTY_MESSAGE);
        }
        return result;
    }


}