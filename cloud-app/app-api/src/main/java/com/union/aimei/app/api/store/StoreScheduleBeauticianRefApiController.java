package com.union.aimei.app.api.store;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.store.StoreScheduleBeauticianRefFeign;
import com.union.aimei.common.model.store.StoreScheduleBeauticianRef;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 店铺排班-美容师-关联
 *
 * @author liurenkai
 * @time 2017/12/25 13:44
 */
@Api(tags = "店铺排班-美容师-关联")
@RestController
@RequestMapping(value = "storeScheduleBeauticianRef")
public class StoreScheduleBeauticianRefApiController {
    @Resource
    private StoreScheduleBeauticianRefFeign storeScheduleBeauticianRefFeign;

    /**
     * 分页查询
     *
     * @param pageNo                     分页索引
     * @param pageSize                   每页显示数量
     * @param storeScheduleBeauticianRef 查询条件
     * @return ResponseMessage<StoreScheduleBeauticianRef>
     */
    @ApiOperation(httpMethod = "POST", value = "前端分页查询店铺排班-美容师-关联")
    @PostMapping("/front/findByPage")
    public ResponseMessage<PageInfo<StoreScheduleBeauticianRef>> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                    @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                    @ApiParam(value = "查询条件") @RequestBody StoreScheduleBeauticianRef storeScheduleBeauticianRef) {
        return new ResponseMessage<>(this.storeScheduleBeauticianRefFeign.findByPageForFront(pageNo, pageSize, storeScheduleBeauticianRef));
    }
}