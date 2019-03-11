package com.union.aimei.app.api.order;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.order.OrderBeauticianFeign;
import com.union.aimei.common.model.order.OrderBeautician;
import com.union.aimei.common.vo.order.BeauticianArrangeVo;
import com.union.aimei.common.vo.order.BeauticianReserved;
import com.union.aimei.common.vo.order.ChooseBeauticianListVo;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseMessageFactory;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;

/**
 * @author GaoWei
 * @describe
 * @time 2017/12/7,11:35
 */
@Api(tags = "订单美容师")
@RestController
@RequestMapping(value = "orderBeautician")
public class OrderBeauticianApiController {


    @Resource
    private OrderBeauticianFeign orderBeauticianFeign;

    /**
     * 根据ID查询OrderBeautician
     *
     * @param id
     * @returnorderBeautician
     */
    @ApiOperation(httpMethod = "GET", value = "通过ID查询订单美容师")
    @GetMapping("/queryById/{id}")
    public ResponseMessage<OrderBeautician> queryById(@PathVariable(value = "id") int id) {
        ResponseMessage res=ResponseMessageFactory.newInstance();
        res.setData( this.orderBeauticianFeign.queryById(id));
        return res;
    }

    /**
     * 预约看板
     * @param chooseTime
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "预约看板")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "int",name = "pageNo",value = "分页开始",defaultValue = "1",paramType = "query"),
            @ApiImplicitParam(dataType = "int",name = "pageSize",value = "每页多少条",defaultValue="10",paramType = "query"),
            @ApiImplicitParam(dataType = "int",name = "storeId",required = false,value = "店铺ID",defaultValue = "4",paramType = "query"),
            @ApiImplicitParam(dataType = "String",name = "chooseTime",required = true,value = "选择时间",defaultValue="2017-12-27",paramType = "query")
    })
    @GetMapping(value = "/reservedBoard")
    public ResponseMessage<PageInfo<BeauticianReserved>> reservedBoard(
             @RequestParam(value ="pageNo") Integer pageNo,
             @RequestParam(value = "pageSize") Integer pageSize,
             @RequestParam(value = "storeId",required = false) Integer storeId,
             @RequestParam(value = "chooseTime") String chooseTime) {
        return orderBeauticianFeign.reservedBoard(pageNo,pageSize,storeId,chooseTime);
    }

    /**
     * 美容师安排详情
     * @param pageNo
     * @param pageSize
     * @param storeId 店铺ID
     * @param id 美容师ID
     * @param chooseTime 选择时间
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "美容师时间安排详情")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "int",name = "pageNo",value = "分页开始",defaultValue = "1",paramType = "query"),
            @ApiImplicitParam(dataType = "int",name = "pageSize",value = "每页多少条",defaultValue="10",paramType = "query"),
            @ApiImplicitParam(dataType = "int",name = "storeId",value = "店铺ID",defaultValue = "4",paramType = "query"),
            @ApiImplicitParam(dataType = "int",name = "id",value = "美容师ID",defaultValue="3",paramType = "query"),
            @ApiImplicitParam(dataType = "String",name = "chooseTime",required = true,value = "选择时间",defaultValue="2017-12-27",paramType = "query")
    })
    @GetMapping(value = "/beauticianArrange")
    public ResponseMessage<PageInfo<BeauticianArrangeVo>> beauticianArrange(@RequestParam(value = "pageNo") Integer pageNo,
                                                                            @RequestParam(value = "pageSize") Integer pageSize,
                                                                            @RequestParam(value = "storeId",required = false) Integer storeId,
                                                                            @RequestParam(value = "id") Integer id,
                                                                            @RequestParam(value = "chooseTime") String chooseTime){
        return  orderBeauticianFeign.beauticianArrange(pageNo, pageSize, storeId,id, chooseTime);
    }


    /**
     * 查询美容师繁忙时间(正常上班时间为早8点到晚10点)
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "查询美容师繁忙时间")
    @PostMapping(value = "queryBeauticianBusyTime")
    public ResponseMessage queryBeauticianBusyTime(
            @RequestBody ChooseBeauticianListVo chooseBeauticianListVo)throws ParseException {
        return orderBeauticianFeign.queryBeauticianBusyTime(chooseBeauticianListVo);
    }




}