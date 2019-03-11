package com.union.aimei.pc.api.store;

import com.union.aimei.common.model.store.StoreScheduleBeauticianRef;
import com.union.aimei.common.feign.pc.store.StoreScheduleBeauticianRefFeign;
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
 * @time 2018/1/12 17:36
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
    public ResponseMessage<StoreScheduleBeauticianRef> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0")
                                                                                  Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10")
                                                                                  Integer pageSize, @ApiParam(value = "查询条件") @RequestBody StoreScheduleBeauticianRef storeScheduleBeauticianRef) {
        return new ResponseMessage(this.storeScheduleBeauticianRefFeign.findByPageForFront(pageNo, pageSize, storeScheduleBeauticianRef));
    }

    /**
     * 添加StoreScheduleBeauticianRef
     *
     * @param storeScheduleBeauticianRef
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "添加店铺排班-美容师-关联")
    @PostMapping("/insert")
    public ResponseMessage insert(@RequestBody StoreScheduleBeauticianRef storeScheduleBeauticianRef) {
        return new ResponseMessage(this.storeScheduleBeauticianRefFeign.insert(storeScheduleBeauticianRef));
    }

    /**
     * 删除StoreScheduleBeauticianRef
     *
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "DELETE", value = "删除店铺排班-美容师-关联")
    @DeleteMapping("/deleteById/{id}")
    public ResponseMessage deleteById(@PathVariable(value = "id") int id) {
        return new ResponseMessage(this.storeScheduleBeauticianRefFeign.deleteById(id));
    }

    /**
     * 修改StoreScheduleBeauticianRef
     *
     * @param storeScheduleBeauticianRef
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "编辑店铺排班-美容师-关联")
    @PutMapping("/edit")
    public ResponseMessage edit(@RequestBody StoreScheduleBeauticianRef storeScheduleBeauticianRef) {
        return new ResponseMessage(this.storeScheduleBeauticianRefFeign.edit(storeScheduleBeauticianRef));
    }

    /**
     * 根据ID查询StoreScheduleBeauticianRef
     *
     * @param id
     * @returnstoreScheduleBeauticianRef
     */
    @ApiOperation(httpMethod = "GET", value = "通过ID查询店铺排班-美容师-关联")
    @GetMapping("/queryById/{id}")
    public ResponseMessage<StoreScheduleBeauticianRef> queryById(@PathVariable(value = "id") int id) {
        return new ResponseMessage(this.storeScheduleBeauticianRefFeign.queryById(id));
    }
}