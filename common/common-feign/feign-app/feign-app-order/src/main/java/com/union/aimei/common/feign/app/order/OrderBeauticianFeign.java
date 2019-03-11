package com.union.aimei.common.feign.app.order;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.order.hystrix.OrderBeauticianApiHystrix;
import com.union.aimei.common.model.order.OrderBeautician;
import com.union.aimei.common.vo.order.BeauticianArrangeVo;
import com.union.aimei.common.vo.order.BeauticianBusyTimeVo;
import com.union.aimei.common.vo.order.BeauticianReserved;
import com.union.aimei.common.vo.order.ChooseBeauticianListVo;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

/**
 * @author GaoWei
 * @describe
 * @time 2017/12/7,10:51
 */
@FeignClient(serviceId = "APP-ORDER-SERVICE", fallback = OrderBeauticianApiHystrix.class)
public interface OrderBeauticianFeign {
    /**
     * 添加订单美容师
     *
     * @param orderBeautician
     * @return
     */
    @PostMapping(value = "/orderBeautician/insert")
    int insert(@RequestBody OrderBeautician orderBeautician);

    /**
     * 删除订单美容师
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/orderBeautician/deleteById/{id}")
    int deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改订单美容师
     *
     * @param orderBeautician
     * @return
     */
    @PutMapping(value = "/orderBeautician/edit")
    int edit(@RequestBody OrderBeautician orderBeautician);

    /**
     * 根据ID查询
     *
     * @param id
     * @returnorderBeautician
     */
    @GetMapping(value = "/orderBeautician/queryById/{id}")
    OrderBeautician queryById(@PathVariable(value = "id") int id);

    /**
     * 前端分页查询订单美容师
     *
     * @param pageNo          分页索引
     * @param pageSize        每页显示数量
     * @param orderBeautician 查询条件
     * @return
     */
    @PostMapping(value = "/orderBeautician/front/findByPage")
    PageInfo<OrderBeautician> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0")
                                                         Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10")
                                                         Integer pageSize, @RequestBody OrderBeautician orderBeautician);


    /**
     * 查看美容师预约看板
     * @param pageNo
     * @param pageSize
     * @param storeId
     * @param chooseTime
     * @return
     */
    @GetMapping("/orderBeautician/reservedBoard")
    ResponseMessage<PageInfo<BeauticianReserved>> reservedBoard(
            @RequestParam(value = "pageNo") Integer pageNo,
            @RequestParam(value = "pageSize") Integer pageSize,
            @RequestParam(value = "storeId", required = false) Integer storeId,
            @RequestParam(value = "chooseTime") String chooseTime);


    /**
     * 美容师安排详情
     * @param pageNo
     * @param pageSize
     * @param id
     * @param storeId
     * @param chooseTime
     * @return
     */
    @GetMapping(value = "/orderBeautician/beauticianArrange")
    ResponseMessage<PageInfo<BeauticianArrangeVo>> beauticianArrange(@RequestParam(value = "pageNo") Integer pageNo,
                                                                     @RequestParam(value = "pageSize") Integer pageSize,
                                                                     @RequestParam(value = "storeId", required = false) Integer storeId,
                                                                     @RequestParam(value = "id") Integer id,
                                                                     @RequestParam(value = "chooseTime") String chooseTime);

    /**
     * 查询店铺美容师订单工作时间
     * @param chooseBeauticianListVo
     * @return
     * @throws ParseException
     */
    @PostMapping(value = "/orderBeautician/queryBeauticianBusyTime")
    ResponseMessage<List<BeauticianBusyTimeVo>> queryBeauticianBusyTime(@RequestBody ChooseBeauticianListVo chooseBeauticianListVo)throws ParseException;

    /**
     * 通过订单ID查询订单美容师信息
     * @param orderId
     * @return
     */
    @GetMapping(value = "/orderBeautician/queryByOrderId/{orderId}")
    ResponseMessage<OrderBeautician> queryByOrderId(@PathVariable("orderId") Integer orderId);

    /**
     * 查询美容师当前时间是否已安排
     * @param chooseBeauticianListVo
     * @return
     * @throws ParseException
     */
    @PostMapping(value = "/orderBeautician/queryBeauticianChooseTimeTimeForBusy")
    ResponseMessage<List<Integer>> queryBeauticianChooseTimeTimeForBusy(@RequestBody ChooseBeauticianListVo chooseBeauticianListVo);


    /**
     * 通过订单编号查询
     * @param orderNo
     * @return
     */
    @GetMapping(value = "/orderBeautician/queryByOrderNo/{orderNo}")
    ResponseMessage<OrderBeautician> queryByOrderNo(@PathVariable(value = "orderNo") String orderNo);


    /**
     * 查询美容师当天订单数量
     * @param beauticianId
     * @return
     */
//    @GetMapping(value = "/orderBeauticia/queryBeauticianTodayOrderTotal/{beauticianId}")
//    ResponseMessage<Integer> queryBeauticianTodayOrderTotal(@PathVariable(value = "beauticianId")Integer beauticianId);
}