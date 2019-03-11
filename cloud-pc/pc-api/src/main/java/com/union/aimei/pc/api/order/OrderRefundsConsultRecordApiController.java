package com.union.aimei.pc.api.order;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.order.OrderRefundsConsultRecordFeign;
import com.union.aimei.common.model.order.OrderRefundsConsultRecord;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author gaowei
 */
@Api(tags = "服务订单-退款协商记录表")
@RestController
@RequestMapping(value = "orderRefundsConsultRecord")
public class OrderRefundsConsultRecordApiController {

    @Resource
    private OrderRefundsConsultRecordFeign orderRefundsConsultRecordFeign;

    /**
     * 分页查询
     *
     * @param pageNo                    分页索引
     * @param pageSize                  每页显示数量
     * @param orderRefundsConsultRecord 查询条件
     * @return ResponseMessage<OrderRefundsConsultRecord>
     */
    @ApiOperation(httpMethod = "POST", value = "前端分页查询服务订单-退款协商记录表")
    @PostMapping("/front/findByPage")
    public ResponseMessage<PageInfo<OrderRefundsConsultRecord>> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0")
                                                                                 Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10")
                                                                                 Integer pageSize, @ApiParam(value = "查询条件") @RequestBody OrderRefundsConsultRecord orderRefundsConsultRecord) {

        PageInfo<OrderRefundsConsultRecord> page=orderRefundsConsultRecordFeign.findByPageForFront(pageNo, pageSize, orderRefundsConsultRecord);
        ResponseMessage<PageInfo<OrderRefundsConsultRecord>> res=new ResponseMessage<>();
        res.setData(page);
        return res;
    }


    /**
     * 根据ID查询OrderRefundsConsultRecord
     *
     * @param id
     * @returnorderRefundsConsultRecord
     */
    @ApiOperation(httpMethod = "GET", value = "通过ID查询服务订单-退款协商记录表")
    @GetMapping("/queryById/{id}")
    public ResponseMessage<OrderRefundsConsultRecord> queryById(@PathVariable(value = "id") int id) {
         this.orderRefundsConsultRecordFeign.queryById(id);
         return new ResponseMessage<>();
    }
}