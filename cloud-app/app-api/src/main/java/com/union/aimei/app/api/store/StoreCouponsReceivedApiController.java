package com.union.aimei.app.api.store;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.store.StoreCouponsReceivedFeign;
import com.union.aimei.common.model.store.StoreCouponsReceived;
import com.union.aimei.common.vo.store.app.StoreCouponsReceivedByUsedVo;
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
 * @time 2017/12/22 15:43
 */
@Api(tags = "店铺优惠券领取")
@RestController
@RequestMapping(value = "storeCouponsReceived")
public class StoreCouponsReceivedApiController {
    @Resource
    private StoreCouponsReceivedFeign storeCouponsReceivedFeign;

    /**
     * 前端分页查询店铺优惠券领取
     *
     * @param pageNo               分页索引
     * @param pageSize             每页显示数量
     * @param storeCouponsReceived 查询条件
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "前端分页查询店铺优惠券领取")
    @PostMapping("/front/findByPage")
    public ResponseMessage<PageInfo<StoreCouponsReceived>> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                              @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                              @ApiParam(value = "查询条件") @RequestBody StoreCouponsReceived storeCouponsReceived) {
        return new ResponseMessage<>(this.storeCouponsReceivedFeign.findByPageForFront(pageNo, pageSize, storeCouponsReceived));
    }

    /**
     * 领取店铺优惠券
     *
     * @param storeCouponsId 店铺优惠卷ID
     * @param memberId       会员ID
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "领取店铺优惠券")
    @PostMapping(value = "/add/{storeCouponsId}/{memberId}")
    public ResponseMessage add(@ApiParam(value = "店铺优惠券ID") @PathVariable(value = "storeCouponsId") int storeCouponsId,
                               @ApiParam(value = "会员ID") @PathVariable(value = "memberId") int memberId) {
        return this.storeCouponsReceivedFeign.add(storeCouponsId, memberId);
    }

    /**
     * 领取的店铺优惠券使用
     *
     * @param storeCouponsReceivedByUsedVo
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "领取的店铺优惠券使用")
    @PostMapping(value = "/used")
    public ResponseMessage used(@ApiParam(value = "参数") @RequestBody StoreCouponsReceivedByUsedVo storeCouponsReceivedByUsedVo) {
        return this.storeCouponsReceivedFeign.used(storeCouponsReceivedByUsedVo);
    }
}