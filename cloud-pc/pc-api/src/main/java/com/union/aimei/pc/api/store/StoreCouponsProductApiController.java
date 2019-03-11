package com.union.aimei.pc.api.store;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreCouponsProduct;
import com.union.aimei.common.feign.pc.store.StoreCouponsProductFeign;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 优惠券-服务-关联
 *
 * @author liurenkai
 * @time 2018/1/12 17:35
 */
@Api(tags = "优惠券-服务-关联")
@RestController
@RequestMapping(value = "storeCouponsProduct")
public class StoreCouponsProductApiController {
    @Resource
    private StoreCouponsProductFeign storeCouponsProductFeign;

    /**
     * 分页查询
     *
     * @param pageNo              分页索引
     * @param pageSize            每页显示数量
     * @param storeCouponsProduct 查询条件
     * @return ResponseMessage<StoreCouponsProduct>
     */
    @ApiOperation(httpMethod = "POST", value = "前端分页查询优惠券-服务-关联")
    @PostMapping("/front/findByPage")
    public ResponseMessage<PageInfo<StoreCouponsProduct>> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0")
                                                                           Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10")
                                                                           Integer pageSize, @ApiParam(value = "查询条件") @RequestBody StoreCouponsProduct storeCouponsProduct) {
        return new ResponseMessage(this.storeCouponsProductFeign.findByPageForFront(pageNo, pageSize, storeCouponsProduct));
    }

    /**
     * 添加StoreCouponsProduct
     *
     * @param storeCouponsProduct
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "添加优惠券-服务-关联")
    @PostMapping("/insert")
    public ResponseMessage insert(@RequestBody StoreCouponsProduct storeCouponsProduct) {
        return new ResponseMessage(this.storeCouponsProductFeign.insert(storeCouponsProduct));
    }

    /**
     * 删除StoreCouponsProduct
     *
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "DELETE", value = "删除优惠券-服务-关联")
    @DeleteMapping("/deleteById/{id}")
    public ResponseMessage deleteById(@PathVariable(value = "id") int id) {
        return new ResponseMessage(this.storeCouponsProductFeign.deleteById(id));
    }

    /**
     * 修改StoreCouponsProduct
     *
     * @param storeCouponsProduct
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "编辑优惠券-服务-关联")
    @PutMapping("/edit")
    public ResponseMessage edit(@RequestBody StoreCouponsProduct storeCouponsProduct) {
        return new ResponseMessage(this.storeCouponsProductFeign.edit(storeCouponsProduct));
    }

    /**
     * 根据ID查询StoreCouponsProduct
     *
     * @param id
     * @returnstoreCouponsProduct
     */
    @ApiOperation(httpMethod = "GET", value = "通过ID查询优惠券-服务-关联")
    @GetMapping("/queryById/{id}")
    public ResponseMessage<StoreCouponsProduct> queryById(@PathVariable(value = "id") int id) {
        return new ResponseMessage(this.storeCouponsProductFeign.queryById(id));
    }

}