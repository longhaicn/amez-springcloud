package com.union.aimei.app.api.store;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.store.StoreExtendOperationLogFeign;
import com.union.aimei.common.model.store.StoreExtendOperationLog;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 店铺扩展操作日志
 *
 * @author liurenkai
 * @time 2017/12/26 15:04
 */
@Api(tags = "店铺扩展操作日志")
@RestController
@RequestMapping(value = "storeExtendOperationLog")
public class StoreExtendOperationLogApiController {
    @Resource
    private StoreExtendOperationLogFeign storeExtendOperationLogFeign;

    /**
     * 分页查询
     *
     * @param pageNo                  分页索引
     * @param pageSize                每页显示数量
     * @param storeExtendOperationLog 查询条件
     * @return ResponseMessage<StoreExtendOperationLog>
     */
    @ApiOperation(httpMethod = "POST", value = "前端分页查询店铺扩展操作日志")
    @PostMapping("/front/findByPage")
    public ResponseMessage<PageInfo<StoreExtendOperationLog>> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                 @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                 @ApiParam(value = "查询条件") @RequestBody StoreExtendOperationLog storeExtendOperationLog) {
        return new ResponseMessage<>(this.storeExtendOperationLogFeign.findByPageForFront(pageNo, pageSize, storeExtendOperationLog));
    }

}