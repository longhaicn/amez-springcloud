package com.union.aimei.pc.api.system;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.system.BaseHomeFloorListFeign;
import com.union.aimei.common.model.system.BaseHomeFloorList;
import com.union.aimei.common.vo.system.pc.BaseHomeFloorListVo;
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
@Api(tags = "楼层列表数据")
@RestController
@RequestMapping(value = "baseHomeFloorList")
public class BaseHomeFloorListApiController {

    @Resource
    private BaseHomeFloorListFeign baseHomeFloorListFeign;

    /**
     * 添加BaseHomeFloorList(v1.1.0)
     *
     * @param baseHomeFloorList
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "添加楼层列表数据表(v1.1.0)")
    @PostMapping("/1.1.0/insert")
    public ResponseMessage insertV110(@RequestBody BaseHomeFloorList baseHomeFloorList) {
        ResponseMessage result = ResponseMessageFactory.newInstance();
        int res = this.baseHomeFloorListFeign.insert(baseHomeFloorList);
        AssertUtil.numberGtZero(res, ResponseContants.ADD_MESSAGE, ResponseContants.ADD);
        return result;
    }

    /**
     * 更新楼层数据(v1.1.0)
     *
     * @param baseHomeFloorList
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "更新楼层数据(v1.1.0)")
    @PutMapping("/1.1.0/edit")
    public ResponseMessage editV110(@RequestBody BaseHomeFloorList baseHomeFloorList) {
        ResponseMessage result = ResponseMessageFactory.newInstance();
        int res = this.baseHomeFloorListFeign.edit(baseHomeFloorList);
        AssertUtil.numberGtZero(res, ResponseContants.EDIT_MESSAGE, ResponseContants.EDIT);
        return result;
    }

    /**
     * 前端分页查询楼层内商品的数据(v1.1.0)
     *
     * @param pageNo   分页索引
     * @param pageSize 每页显示数量
     * @param floorId  楼层id
     */
    @ApiOperation(httpMethod = "POST", value = "前端分页查询楼层内商品的数据(v1.1.0)")
    @PostMapping("/1.1.0/findPageByFloorId")
    public ResponseMessage<PageInfo<BaseHomeFloorListVo>> findPageByFloorIdV110(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                @ApiParam(value = "楼层id") @RequestParam(value = "floorId") Integer floorId) {
        return this.baseHomeFloorListFeign.findByVoPageForFrontV110(pageNo, pageSize, floorId);
    }

    /**
     * 批量添加楼层商品数据(v1.1.0)
     *
     * @param baseHomeFloorListList
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "批量添加楼层商品数据(v1.1.0)")
    @PostMapping("/1.1.0/addBatch")
    public ResponseMessage addBatchV110(@ApiParam(value = "数据") @RequestBody List<BaseHomeFloorList> baseHomeFloorListList) {
        return this.baseHomeFloorListFeign.addBatchV110(baseHomeFloorListList);
    }

    /**
     * 根据楼层id获取已选择的产品(v1.1.0)
     *
     * @param floorId 楼层id
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "根据楼层id获取已选择的产品(v1.1.0)")
    @PostMapping("/1.1.0/findByFloorId/{floorId}/{productType}")
    public ResponseMessage<List<BaseHomeFloorList>> findByFloorIdV110(@ApiParam(required = true, value = "楼层id") @PathVariable(value = "floorId") int floorId,
                                                                      @ApiParam(required = true, value = "产品类型 0-平台 1-门店资源") @PathVariable(value = "productType") int productType) {
        return this.baseHomeFloorListFeign.findByFloorIdV110(floorId, productType);
    }

}