package com.union.aimei.pc.api.order;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.order.OrderReturnFeign;
import com.union.aimei.common.model.order.OrderReturn;
import com.union.aimei.common.vo.order.OrderRefundListVo;
import com.union.aimei.common.vo.order.OrderRefundQueryVo;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author gaowei
 */
@Api(tags = "退换货单")
@RestController
@RequestMapping(value = "orderReturn")
public class OrderReturnApiController {


    @Resource
    private OrderReturnFeign orderReturnFeign;

    /**
     * 分页查询
     *
     * @param pageNo      分页索引
     * @param pageSize    每页显示数量
     * @param orderReturn 查询条件
     * @return ResponseMessage<OrderReturn>
     */
    @ApiOperation(httpMethod = "POST", value = "前端分页查询退换货单")
    @PostMapping("/front/findByPage")
    public ResponseMessage<PageInfo<OrderReturn>> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0")
                                                                   Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10")
                                                                   Integer pageSize, @ApiParam(value = "查询条件") @RequestBody OrderReturn orderReturn) {
        PageInfo<OrderReturn> page=orderReturnFeign.findByPageForFront(pageNo, pageSize, orderReturn);
        ResponseMessage<PageInfo<OrderReturn>> res=new ResponseMessage<>();
        res.setData(page);
        return res;
    }



    /**
     * 根据ID查询OrderReturn
     *
     * @param id
     * @returnorderReturn
     */
    @ApiOperation(httpMethod = "GET", value = "通过ID查询退换货单")
    @GetMapping("/queryById/{id}")
    public ResponseMessage<OrderReturn> queryById(@PathVariable(value = "id") int id) {
        return this.orderReturnFeign.queryByOrderId(id);
    }





    @ApiOperation(httpMethod = "POST", value = "查询分页退款订单")
    @PostMapping(value = "/queryForPage")
    public ResponseMessage<PageInfo<OrderRefundListVo>> queryForPage(
            @ApiParam(value="分页索引",defaultValue="0")  @RequestParam(defaultValue="0")
                    Integer pageNo, @ApiParam(value="每页数量",defaultValue="10")  @RequestParam(defaultValue="10")
                    Integer pageSize, @ApiParam(value="查询条件") @RequestBody OrderRefundQueryVo orderRefundQueryVo
    ){
        return  orderReturnFeign.queryForPage(pageNo, pageSize, orderRefundQueryVo);
    }



}