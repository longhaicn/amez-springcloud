package com.union.aimei.pc.api.store;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreCoupons;
import com.union.aimei.common.vo.store.pc.StoreCouponsProductCountResultVo;
import com.union.aimei.common.vo.store.pc.StoreCouponsProductCountVo;
import com.union.aimei.common.vo.store.pc.StoreCouponsVo;
import com.union.aimei.common.feign.pc.store.StoreCouponsFeign;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 店铺优惠券
 *
 * @author liurenkai
 * @time 2018/1/12 17:34
 */
@Api(tags = "店铺优惠券")
@RestController
@RequestMapping(value = "storeCoupons")
public class StoreCouponsApiController {
    @Resource
    private StoreCouponsFeign storeCouponsFeign;

    /**
     * 分页查询
     *
     * @param pageNo       分页索引
     * @param pageSize     每页显示数量
     * @param storeCoupons 查询条件
     * @return ResponseMessage<StoreCoupons>
     */
    @ApiOperation(httpMethod = "POST", value = "前端分页查询店铺优惠券")
    @PostMapping("/front/findByPage")
    public ResponseMessage<StoreCoupons> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0")
                                                                    Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10")
                                                                    Integer pageSize, @ApiParam(value = "查询条件") @RequestBody StoreCoupons storeCoupons) {
        return new ResponseMessage(this.storeCouponsFeign.findByPageForFront(pageNo, pageSize, storeCoupons));
    }

    /**
     * 添加StoreCoupons
     *
     * @param storeCoupons
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "添加店铺优惠券")
    @PostMapping("/insert")
    public ResponseMessage insert(@RequestBody StoreCoupons storeCoupons) {
        return new ResponseMessage(this.storeCouponsFeign.insert(storeCoupons));
    }

    /**
     * 删除StoreCoupons
     *
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "DELETE", value = "删除店铺优惠券")
    @DeleteMapping("/deleteById/{id}")
    public ResponseMessage deleteById(@PathVariable(value = "id") int id) {
        return new ResponseMessage(this.storeCouponsFeign.deleteById(id));
    }

    /**
     * 修改StoreCoupons
     *
     * @param storeCoupons
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "编辑店铺优惠券")
    @PutMapping("/edit")
    public ResponseMessage edit(@RequestBody StoreCoupons storeCoupons) {
        return new ResponseMessage(this.storeCouponsFeign.edit(storeCoupons));
    }

    /**
     * 根据ID查询StoreCoupons
     *
     * @param id
     * @returnstoreCoupons
     */
    @ApiOperation(httpMethod = "GET", value = "通过ID查询店铺优惠券")
    @GetMapping("/queryById/{id}")
    public ResponseMessage<StoreCoupons> queryById(@PathVariable(value = "id") int id) {
        return new ResponseMessage(this.storeCouponsFeign.queryById(id));
    }

    /**
     * 新增店铺优惠券
     *
     * @param storeCouponsVo 店铺优惠券vo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "新增店铺优惠券")
    @PostMapping(value = "/add")
    public ResponseMessage add(@RequestBody StoreCouponsVo storeCouponsVo) {
        return new ResponseMessage(this.storeCouponsFeign.add(storeCouponsVo));
    }

    /**
     * 修改店铺优惠券软删除标记
     *
     * @param id        店铺优惠券ID
     * @param isEnabled 软删除标记
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "修改店铺优惠券软删除标记")
    @PutMapping(value = "/isEnabled/{id}/{isEnabled}")
    public ResponseMessage isEnabled(@ApiParam(value = "店铺优惠券ID") @PathVariable(value = "id") int id,
                                     @ApiParam(value = "软删除标记，1为正常，0为删除") @PathVariable(value = "isEnabled") int isEnabled) {
        return new ResponseMessage(this.storeCouponsFeign.isEnabled(id, isEnabled));
    }


    /**
     * 查询优惠券列表和包含的服务数量
     *
     * @param pageNo       分页索引
     * @param pageSize     每页显示数量
     * @param storeCouponsProductCountVo 查询条件
     * @return ResponseMessage<StoreCoupons>
     */
    @ApiOperation(httpMethod = "POST", value = "查询优惠券列表和包含的服务数量")
    @PostMapping("/findByPageForCountProduct")
    public ResponseMessage<PageInfo<StoreCouponsProductCountResultVo>> findByPageForCountProduct(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0")
                                                                    Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10")
                                                                    Integer pageSize, @ApiParam(value = "查询条件") @RequestBody StoreCouponsProductCountVo storeCouponsProductCountVo) {
        return new ResponseMessage(this.storeCouponsFeign.findByPageForCountProduct(pageNo, pageSize, storeCouponsProductCountVo));
    }



}