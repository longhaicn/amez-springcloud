package com.union.aimei.app.api.system;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.system.BaseHomeFloorFeign;
import com.union.aimei.common.model.system.BaseHomeFloor;
import com.union.aimei.common.vo.system.app.BaseHomeFloorPageVo;
import com.union.aimei.common.vo.system.app.SelectBaseHomeTemplateVo;
import com.union.common.utils.AssertUtil;
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
 * @create 2018-05-23 10:49
 **/
@Api(tags = "楼层管理表")
@RestController
@RequestMapping(value = "baseHomeFloor")
public class BaseHomeFloorApiController {

    @Resource
    private BaseHomeFloorFeign baseHomeFloorFeign;

    /**
     * 获取模版页面的楼层数据(v1.1.0)
     *
     * @param pageNo                   分页索引
     * @param pageSize                 每页显示数量
     * @param selectBaseHomeTemplateVo 查询条件
     */
    @ApiOperation(httpMethod = "POST", value = "获取模版页面的楼层数据(v1.1.0)")
    @PostMapping("/1.1.0/findPageFloorDate")
    public ResponseMessage<PageInfo<BaseHomeFloorPageVo>> findPageFloorDateV110(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                @ApiParam(value = "查询条件") @RequestBody SelectBaseHomeTemplateVo selectBaseHomeTemplateVo) {
        return this.baseHomeFloorFeign.findPageFloorDateV110(pageNo, pageSize, selectBaseHomeTemplateVo);
    }

    /**
     * 根据ID查询BaseHomeFloor(v1.1.0)
     *
     * @param id
     * @returnbaseHomeFloor
     */
    @ApiOperation(httpMethod = "GET", value = "根据ID查询BaseHomeFloor(v1.1.0)")
    @GetMapping("/1.1.0/queryById/{id}")
    public ResponseMessage<BaseHomeFloor> queryByIdV110(@PathVariable(value = "id") int id) {
        ResponseMessage result = ResponseMessageFactory.newInstance();
        BaseHomeFloor model = this.baseHomeFloorFeign.queryById(id);
        AssertUtil.notNull(model, ResponseContants.QUERY_EMPTY_MESSAGE, ResponseContants.QUERY_EMPTY);
        result.setData(model);
        return result;
    }

}