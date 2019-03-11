package com.union.aimei.pc.api.store;

import com.union.aimei.common.model.store.StoreExtend;
import com.union.aimei.common.feign.pc.store.StoreExtendFeign;
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
 * @time 2018/1/12 17:35
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
    public ResponseMessage<StoreExtend> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0")
                                                                   Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10")
                                                                   Integer pageSize, @ApiParam(value = "查询条件") @RequestBody StoreExtend storeExtend) {
        return new ResponseMessage(this.storeExtendFeign.findByPageForFront(pageNo, pageSize, storeExtend));
    }

    /**
     * 添加StoreExtend
     *
     * @param storeExtend
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "添加店铺扩展")
    @PostMapping("/insert")
    public ResponseMessage insert(@RequestBody StoreExtend storeExtend) {
        return new ResponseMessage(this.storeExtendFeign.insert(storeExtend));
    }

    /**
     * 删除StoreExtend
     *
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "DELETE", value = "删除店铺扩展")
    @DeleteMapping("/deleteById/{id}")
    public ResponseMessage deleteById(@PathVariable(value = "id") int id) {
        return new ResponseMessage(this.storeExtendFeign.deleteById(id));
    }

    /**
     * 修改StoreExtend
     *
     * @param storeExtend
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "编辑店铺扩展")
    @PutMapping("/edit")
    public ResponseMessage edit(@RequestBody StoreExtend storeExtend) {
        return new ResponseMessage(this.storeExtendFeign.edit(storeExtend));
    }

    /**
     * 根据ID查询StoreExtend
     *
     * @param id
     * @returnstoreExtend
     */
    @ApiOperation(httpMethod = "GET", value = "通过ID查询店铺扩展")
    @GetMapping("/queryById/{id}")
    public ResponseMessage<StoreExtend> queryById(@PathVariable(value = "id") int id) {
        return new ResponseMessage(this.storeExtendFeign.queryById(id));
    }
}