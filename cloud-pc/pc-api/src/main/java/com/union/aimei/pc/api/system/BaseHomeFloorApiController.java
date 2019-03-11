package com.union.aimei.pc.api.system;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.system.BaseHomeFloorFeign;
import com.union.aimei.common.model.system.BaseHomeFloor;
import com.union.aimei.common.vo.system.pc.BaseHomeFloorPageVo;
import com.union.aimei.common.vo.system.pc.BaseHomeFloorVo;
import com.union.aimei.common.vo.system.pc.SelectBaseHomeTemplateVo;
import com.union.common.utils.AssertUtil;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseMessageFactory;
import com.union.common.utils.constant.ResponseContants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author caizhaoming
 * @create 2018-05-23 10:49
 **/
@Api(tags = "楼层管理")
@RestController
@RequestMapping(value = "baseHomeFloor")
public class BaseHomeFloorApiController {

    @Resource
    private BaseHomeFloorFeign baseHomeFloorFeign;

    /**
     * 修改模版楼层数据(v1.1.0)
     *
     * @param baseHomeFloor
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "修改模版楼层数据(v1.1.0)")
    @PutMapping("/1.1.0/edit")
    public ResponseMessage edit(@RequestBody BaseHomeFloor baseHomeFloor) {
        ResponseMessage result = ResponseMessageFactory.newInstance();
        int res = this.baseHomeFloorFeign.edit(baseHomeFloor);
        AssertUtil.numberGtZero(res, ResponseContants.EDIT_MESSAGE, ResponseContants.EDIT);
        return result;
    }

    /**
     * 添加模版楼层数据(v1.1.0)
     *
     * @param baseHomeFloorVo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "添加模版楼层数据(v1.1.0)")
    @PostMapping("/1.1.0/floorDateInsertUpdate")
    public ResponseMessage<List<BaseHomeFloor>> floorDateInsertV110(@ApiParam(value = "数据") @RequestBody BaseHomeFloorVo baseHomeFloorVo) {
        return this.baseHomeFloorFeign.floorDateInsertV110(baseHomeFloorVo);
    }

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
     * 批量更新数据(v1.1.0)
     *
     * @param baseHomeFloorList 更新的数据
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "批量更新数据(v1.1.0)")
    @PutMapping("/1.1.0/editBatch")
    public ResponseMessage<List<BaseHomeFloor>> editBatchV110(@ApiParam(value = "数据") @RequestBody List<BaseHomeFloor> baseHomeFloorList) {
        return this.baseHomeFloorFeign.editBatchV110(baseHomeFloorList);
    }

}