package com.union.aimei.app.api.order.controller;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.order.OrderBeautician;
import com.union.aimei.common.vo.order.BeauticianArrangeVo;
import com.union.aimei.common.vo.order.BeauticianBusyTimeVo;
import com.union.aimei.common.vo.order.BeauticianReserved;
import com.union.aimei.common.vo.order.ChooseBeauticianListVo;
import com.union.aimei.app.api.order.service.OrderBeauticianService;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author GaoWei
 * @describe
 * @time 2017/12/7,11:53
 */
@Api(tags = "订单美容师")
@RestController
@RequestMapping(value = "orderBeautician")
public class OrderBeauticianController {

    @Resource
    private OrderBeauticianService orderBeauticianService;




    /**
     * 店铺预约看板
     * @param pageNo
     * @param pageSize
     * @param storeId 门店ID
     * @param chooseTime 选择时间
     * @return
     */
    @GetMapping("/reservedBoard")
    public ResponseMessage<PageInfo<BeauticianReserved>> reservedBoard(
            @RequestParam(value = "pageNo") Integer pageNo,
            @RequestParam(value = "pageSize") Integer pageSize,
            @RequestParam(value = "storeId")Integer storeId,
            @RequestParam(value = "chooseTime") String chooseTime) {
        return orderBeauticianService.reservedBoard(pageNo,pageSize,storeId,chooseTime);
    }



    /**
     * 店铺美容师安排详情
     * @param pageNo
     * @param pageSize
     * @param storeId 店铺ID
     * @param id 美容师ID
     * @param chooseTime 选择时间
     * @return
     */
    @GetMapping(value = "/beauticianArrange")
    public ResponseMessage<PageInfo<BeauticianArrangeVo>> beauticianArrange(@RequestParam(value = "pageNo") Integer pageNo,
                                                                            @RequestParam(value = "pageSize") Integer pageSize,
                                                                            @RequestParam(value = "storeId",required = false) Integer storeId,
                                                                            @RequestParam(value = "id") Integer id,
                                                                            @RequestParam(value = "chooseTime") String chooseTime) {
        return orderBeauticianService.beauticianArrange(pageNo, pageSize, storeId,id, chooseTime);
    }



    /**
     * 查询美容师繁忙时间(正常上班时间为早8点到晚10点)
     * @return
     */
    @PostMapping(value = "queryBeauticianBusyTime")
    public ResponseMessage<List<BeauticianBusyTimeVo>> queryBeauticianBusyTime(
            @RequestBody ChooseBeauticianListVo chooseBeauticianListVo) {
        return orderBeauticianService.queryBeauticianBusyTime(chooseBeauticianListVo);
    }


    /**
     * 通过订单编号查询
     * @param orderNo
     * @return
     */
    @GetMapping(value = "/queryByOrderNo/{orderNo}")
    public ResponseMessage<OrderBeautician> queryByOrderNo(@PathVariable(value = "orderNo")String orderNo ){
        return orderBeauticianService.queryByOrderNo(orderNo);
    }

    /**
     * 通过订单ID查询订单美容师信息
     * @param orderId
     * @return
     */
    @GetMapping(value = "/queryByOrderId/{orderId}")
    public ResponseMessage<OrderBeautician> queryByOrderId(@PathVariable  Integer orderId){
        return orderBeauticianService.queryByOrderId(orderId);
    }

    /**
     * 查询美容师当前时间是否已安排
     * @return
     */
    @PostMapping(value = "/queryBeauticianChooseTimeTimeForBusy")
    public ResponseMessage queryBeauticianChooseTimeTimeForBusy(@RequestBody  ChooseBeauticianListVo chooseBeauticianListVo) {
        return orderBeauticianService.queryBeauticianChooseTimeTimeForBusy(chooseBeauticianListVo);
    }


}