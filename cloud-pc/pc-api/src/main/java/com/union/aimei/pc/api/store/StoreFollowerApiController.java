package com.union.aimei.pc.api.store;

import com.union.aimei.common.model.store.StoreFollower;
import com.union.aimei.common.feign.pc.store.StoreFollowerFeign;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 店铺粉丝
 *
 * @author liurenkai
 * @time 2018/1/12 17:35
 */
@Api(tags = "店铺粉丝")
@RestController
@RequestMapping(value = "storeFollower")
public class StoreFollowerApiController {
    @Resource
    private StoreFollowerFeign storeFollowerFeign;

    /**
     * 分页查询
     *
     * @param pageNo        分页索引
     * @param pageSize      每页显示数量
     * @param storeFollower 查询条件
     * @return ResponseMessage<StoreFollower>
     */
    @ApiOperation(httpMethod = "POST", value = "前端分页查询店铺粉丝")
    @PostMapping("/front/findByPage")
    public ResponseMessage<StoreFollower> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0")
                                                                     Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10")
                                                                     Integer pageSize, @ApiParam(value = "查询条件") @RequestBody StoreFollower storeFollower) {
        return new ResponseMessage(this.storeFollowerFeign.findByPageForFront(pageNo, pageSize, storeFollower));
    }

    /**
     * 添加StoreFollower
     *
     * @param storeFollower
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "添加店铺粉丝")
    @PostMapping("/insert")
    public ResponseMessage insert(@RequestBody StoreFollower storeFollower) {
        return new ResponseMessage(this.storeFollowerFeign.insert(storeFollower));
    }

    /**
     * 删除StoreFollower
     *
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "DELETE", value = "删除店铺粉丝")
    @DeleteMapping("/deleteById/{id}")
    public ResponseMessage deleteById(@PathVariable(value = "id") int id) {
        return new ResponseMessage(this.storeFollowerFeign.deleteById(id));
    }

    /**
     * 修改StoreFollower
     *
     * @param storeFollower
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "编辑店铺粉丝")
    @PutMapping("/edit")
    public ResponseMessage edit(@RequestBody StoreFollower storeFollower) {
        return new ResponseMessage(this.storeFollowerFeign.edit(storeFollower));
    }

    /**
     * 根据ID查询StoreFollower
     *
     * @param id
     * @returnstoreFollower
     */
    @ApiOperation(httpMethod = "GET", value = "通过ID查询店铺粉丝")
    @GetMapping("/queryById/{id}")
    public ResponseMessage<StoreFollower> queryById(@PathVariable(value = "id") int id) {
        return new ResponseMessage(this.storeFollowerFeign.queryById(id));
    }
}