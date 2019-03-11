package com.union.aimei.pc.api.store;

import com.union.aimei.common.model.store.StoreCouponsReceived;
import com.union.aimei.common.feign.pc.store.StoreCouponsReceivedFeign;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 店铺优惠券领取
 *
 * @author liurenkai
 * @time 2018/1/12 17:35
 */
@Api(tags = "店铺优惠券领取")
@RestController
@RequestMapping(value = "storeCouponsReceived")
public class StoreCouponsReceivedApiController {
    @Resource
    private StoreCouponsReceivedFeign storeCouponsReceivedFeign;

    /**
     * 分页查询
     *
     * @param pageNo               分页索引
     * @param pageSize             每页显示数量
     * @param storeCouponsReceived 查询条件
     * @return ResponseMessage<StoreCouponsReceived>
     */
    @ApiOperation(httpMethod = "POST", value = "前端分页查询店铺优惠券领取")
    @PostMapping("/front/findByPage")
    public ResponseMessage<StoreCouponsReceived> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0")
                                                                            Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10")
                                                                            Integer pageSize, @ApiParam(value = "查询条件") @RequestBody StoreCouponsReceived storeCouponsReceived) {
        return new ResponseMessage(this.storeCouponsReceivedFeign.findByPageForFront(pageNo, pageSize, storeCouponsReceived));
    }

    /**
     * 添加StoreCouponsReceived
     *
     * @param storeCouponsReceived
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "添加店铺优惠券领取")
    @PostMapping("/insert")
    public ResponseMessage insert(@RequestBody StoreCouponsReceived storeCouponsReceived) {
        return new ResponseMessage(this.storeCouponsReceivedFeign.insert(storeCouponsReceived));
    }

    /**
     * 删除StoreCouponsReceived
     *
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "DELETE", value = "删除店铺优惠券领取")
    @DeleteMapping("/deleteById/{id}")
    public ResponseMessage deleteById(@PathVariable(value = "id") int id) {
        return new ResponseMessage(this.storeCouponsReceivedFeign.deleteById(id));
    }

    /**
     * 修改StoreCouponsReceived
     *
     * @param storeCouponsReceived
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "编辑店铺优惠券领取")
    @PutMapping("/edit")
    public ResponseMessage edit(@RequestBody StoreCouponsReceived storeCouponsReceived) {
        return new ResponseMessage(this.storeCouponsReceivedFeign.edit(storeCouponsReceived));
    }

    /**
     * 根据ID查询StoreCouponsReceived
     *
     * @param id
     * @returnstoreCouponsReceived
     */
    @ApiOperation(httpMethod = "GET", value = "通过ID查询店铺优惠券领取")
    @GetMapping("/queryById/{id}")
    public ResponseMessage<StoreCouponsReceived> queryById(@PathVariable(value = "id") int id) {
        return new ResponseMessage(this.storeCouponsReceivedFeign.queryById(id));
    }
}