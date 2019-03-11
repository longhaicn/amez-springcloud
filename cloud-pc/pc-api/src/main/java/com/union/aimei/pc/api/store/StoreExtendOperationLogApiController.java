package com.union.aimei.pc.api.store;

import com.union.aimei.common.model.store.StoreExtendOperationLog;
import com.union.aimei.common.feign.pc.store.StoreExtendOperationLogFeign;
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
 * @time 2018/1/12 17:35
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
    public ResponseMessage<StoreExtendOperationLog> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0")
                                                                               Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10")
                                                                               Integer pageSize, @ApiParam(value = "查询条件") @RequestBody StoreExtendOperationLog storeExtendOperationLog) {
        return new ResponseMessage(this.storeExtendOperationLogFeign.findByPageForFront(pageNo, pageSize, storeExtendOperationLog));
    }

    /**
     * 添加StoreExtendOperationLog
     *
     * @param storeExtendOperationLog
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "添加店铺扩展操作日志")
    @PostMapping("/insert")
    public ResponseMessage insert(@RequestBody StoreExtendOperationLog storeExtendOperationLog) {
        return new ResponseMessage(this.storeExtendOperationLogFeign.insert(storeExtendOperationLog));
    }

    /**
     * 删除StoreExtendOperationLog
     *
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "DELETE", value = "删除店铺扩展操作日志")
    @DeleteMapping("/deleteById/{id}")
    public ResponseMessage deleteById(@PathVariable(value = "id") int id) {
        return new ResponseMessage(this.storeExtendOperationLogFeign.deleteById(id));
    }

    /**
     * 修改StoreExtendOperationLog
     *
     * @param storeExtendOperationLog
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "编辑店铺扩展操作日志")
    @PutMapping("/edit")
    public ResponseMessage edit(@RequestBody StoreExtendOperationLog storeExtendOperationLog) {
        return new ResponseMessage(this.storeExtendOperationLogFeign.edit(storeExtendOperationLog));
    }

    /**
     * 根据ID查询StoreExtendOperationLog
     *
     * @param id
     * @returnstoreExtendOperationLog
     */
    @ApiOperation(httpMethod = "GET", value = "通过ID查询店铺扩展操作日志")
    @GetMapping("/queryById/{id}")
    public ResponseMessage<StoreExtendOperationLog> queryById(@PathVariable(value = "id") int id) {
        return new ResponseMessage(this.storeExtendOperationLogFeign.queryById(id));
    }
}