package com.union.aimei.pc.store.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreCoupons;
import com.union.aimei.common.vo.common.IdBatchVo;
import com.union.aimei.common.vo.store.pc.StoreCouponsProductCountResultVo;
import com.union.aimei.common.vo.store.pc.StoreCouponsProductCountVo;
import com.union.aimei.common.vo.store.pc.StoreCouponsVo;
import com.union.aimei.pc.store.service.StoreCouponsService;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 门店优惠券
 *
 * @author liurenkai
 * @time 2018/1/12 17:34
 */
@Api(tags = "门店优惠券")
@RestController
@RequestMapping(value = "storeCoupons")
public class StoreCouponsController {
    @Resource
    private StoreCouponsService storeCouponsService;

    @PostMapping("/front/findByPage")
    public PageInfo<StoreCoupons> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0")
                                                             Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10")
                                                             Integer pageSize, @ApiParam(value = "查询条件") @RequestBody StoreCoupons storeCoupons) {
        return this.storeCouponsService.findByPageForFront(pageNo, pageSize, storeCoupons);
    }

    @PostMapping("/insert")
    public int insert(@RequestBody StoreCoupons storeCoupons) {
        return this.storeCouponsService.addObj(storeCoupons);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable(value = "id") int id) {
        return this.storeCouponsService.deleteObjById(id);
    }

    @PutMapping("/edit")
    public int edit(@RequestBody StoreCoupons storeCoupons) {
        return this.storeCouponsService.modifyObj(storeCoupons);
    }

    @GetMapping("/queryById/{id}")
    public StoreCoupons queryById(@PathVariable(value = "id") int id) {
        return this.storeCouponsService.queryObjById(id);
    }

    /**
     * 开始定时任务
     *
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "开始定时任务")
    @PutMapping("/startByScheduleTask")
    public ResponseMessage startByScheduleTask() {
        return this.storeCouponsService.startByScheduleTask();
    }

    /**
     * 结束定时任务
     *
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "结束定时任务")
    @PutMapping("/endByScheduleTask")
    public ResponseMessage endByScheduleTask() {
        return this.storeCouponsService.endByScheduleTask();
    }

    /**
     * 新增门店优惠券
     *
     * @param storeCouponsVo 门店优惠券vo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "新增门店优惠券")
    @PostMapping(value = "/add")
    public ResponseMessage add(@RequestBody StoreCouponsVo storeCouponsVo) {
        return this.storeCouponsService.add(storeCouponsVo);
    }

    /**
     * 修改门店优惠券软删除标记
     *
     * @param id        门店优惠券ID
     * @param isEnabled 软删除标记，1为正常，0为删除
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "修改门店优惠券软删除标记")
    @PutMapping(value = "/isEnabled/{id}/{isEnabled}")
    public ResponseMessage isEnabled(@ApiParam(value = "门店优惠券ID") @PathVariable(value = "id") int id,
                                     @ApiParam(value = "软删除标记，1为正常，0为删除") @PathVariable(value = "isEnabled") int isEnabled) {
        return this.storeCouponsService.isEnabled(id, isEnabled);
    }

    /**
     * 根据ID查询门店优惠券
     *
     * @param id 门店优惠券ID
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "根据ID查询门店优惠券")
    @GetMapping("/findById/{id}")
    public ResponseMessage<StoreCoupons> findById(@ApiParam(value = "门店优惠券ID") @PathVariable(value = "id") int id) {
        return this.storeCouponsService.findById(id);
    }


    /**
     * 查询优惠券列表和包含的服务数量
     *
     * @param pageNo
     * @param pageSize
     * @param storeCoupons
     * @return
     */
    @PostMapping("/findByPageForCountProduct")
    public ResponseMessage<PageInfo<StoreCouponsProductCountResultVo>> findByPageForCountProduct(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0")
                                                                                                         Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10")
                                                                                                         Integer pageSize, @ApiParam(value = "查询条件") @RequestBody StoreCouponsProductCountVo storeCoupons) {
        return this.storeCouponsService.findByPageForCountProduct(pageNo, pageSize, storeCoupons);
    }

    /**
     * 批量根据门店ID查询支持全部服务的优惠券
     *
     * @param idBatchVo 批量门店ID
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "批量根据门店ID查询支持全部服务的优惠券")
    @PostMapping("/listAllServiceByStoreIdBatch")
    public ResponseMessage<List<StoreCoupons>> listAllServiceByStoreIdBatch(@ApiParam(value = "批量门店ID") @RequestBody IdBatchVo idBatchVo) {
        return this.storeCouponsService.listAllServiceByStoreIdBatch(idBatchVo);
    }

}