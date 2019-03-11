package com.union.aimei.app.api.store;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.store.StoreExtendFeign;
import com.union.aimei.common.model.store.StoreExtend;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 店铺扩展
 *
 * @author liurenkai
 * @time 2018/4/11 14:29
 */
@Api(tags = "店铺扩展")
@RestController
@RequestMapping(value = "storeExtend")
public class StoreExtendApiController {
    @Resource
    private StoreExtendFeign storeExtendFeign;

    /**
     * 分页查询
     *
     * @param pageNo      分页索引
     * @param pageSize    每页显示数量
     * @param storeExtend 查询条件
     * @return ResponseMessage<StoreExtend>
     */
    @ApiOperation(httpMethod = "POST", value = "前端分页查询店铺扩展")
    @PostMapping("/front/findByPage")
    public ResponseMessage<PageInfo<StoreExtend>> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                     @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                     @ApiParam(value = "查询条件") @RequestBody StoreExtend storeExtend) {
        return new ResponseMessage<>(this.storeExtendFeign.findByPageForFront(pageNo, pageSize, storeExtend));
    }
}