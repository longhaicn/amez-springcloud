package com.union.aimei.app.api.system;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.system.BaseHomeFloorListFeign;
import com.union.aimei.common.model.system.BaseHomeFloorList;
import com.union.aimei.common.vo.system.app.BaseHomeFloorListVo;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author caizhaoming
 * @create 2018-05-23 10:49
 **/
@Api(tags = "楼层列表数据表")
@RestController
@RequestMapping(value = "baseHomeFloorList")
public class BaseHomeFloorListApiController {

    @Resource
    private BaseHomeFloorListFeign baseHomeFloorListFeign;

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
        BaseHomeFloorListVo baseHomeFloorListVo = new BaseHomeFloorListVo();
        baseHomeFloorListVo.setIsEnabled(BaseHomeFloorList.IS_ENABLED_TURE);
        baseHomeFloorListVo.setFloorId(floorId);
        return this.baseHomeFloorListFeign.findByVoPageForFrontV110(pageNo, pageSize, baseHomeFloorListVo);
    }

}