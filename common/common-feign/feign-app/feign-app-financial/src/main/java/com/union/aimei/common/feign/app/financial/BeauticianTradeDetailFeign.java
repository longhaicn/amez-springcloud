package com.union.aimei.common.feign.app.financial;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.financial.hystrix.BeauticianTradeDetailHystrix;
import com.union.aimei.common.model.financial.BeauticianTradeDetail;
import com.union.aimei.common.vo.financial.*;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
/**
 * @author liufeihua
 */
@FeignClient(name = "app-financial-service", fallback = BeauticianTradeDetailHystrix.class)
public interface BeauticianTradeDetailFeign {
    /**
     * 基础操作
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/beauticianTradeDetails/{id}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    int deleteByPrimaryKey(@PathVariable("id") Integer id);
    /**
     * 基本操作
     * @param record
     * @return
     */
    @RequestMapping(value = "/beauticianTradeDetails/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    int insertSelective(@RequestBody BeauticianTradeDetail record);
    /**
     * 基础操作
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/beauticianTradeDetails/{id}/", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    BeauticianTradeDetail selectByPrimaryKey(@PathVariable("id") Integer id);
    /**
     * 基本操作
     * @param record
     * @return
     */
    @RequestMapping(value = "/beauticianTradeDetails/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    int updateByPrimaryKeySelective(@RequestBody BeauticianTradeDetail record);
    /**
     * 查看
     *
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    @RequestMapping(value = "/beauticianTradeDetails/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    PageInfo<BeauticianTradeDetail> selectListByConditions(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                           @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                           @RequestBody BeauticianTradeDetail record);

    /**
     * 根据订单编号删除流水
     *
     * @param orderNo
     * @return
     */
    @RequestMapping(value = "/beauticianTradeDetails/deleteTradeDetailByOrderNo/{orderNo}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    ResponseMessage<Integer> deleteTradeDetailByOrderNo(@PathVariable("orderNo") String orderNo);


    /**
     * 日订单数和日收入
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/beauticianTradeDetails/dayOrderAndAccount/{id}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    ResponseMessage<Map<String, Object>> dayOrderAndAccount(@PathVariable("id") Integer id);


    /**
     * 根据订单编号和类型查询
     * @param orderNo
     * @param type
     * @return
     */
    @RequestMapping(value = "/beauticianTradeDetails/queryByOrderNoAndType")
    ResponseMessage<BeauticianTradeDetail> queryByOrderNoAndType(@RequestParam(value = "orderNo") String orderNo,
                                                                 @RequestParam(value = "type") Integer type);

    /**
     * app门店端的营业统计中的员工业绩(v1.1.0)
     *
     * @param pageNo
     * @param pageSize
     * @param vo
     * @return
     */
    @PostMapping(value = "/beauticianTradeDetails/1.1.0/queryMemberPerformance")
    ResponseMessage<PageInfo<QueryMemberPerformanceResponseVo>> queryMemberPerformanceV110(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                           @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                           @RequestBody QueryMemberPerformanceVo vo);

    /**
     * app门店端的营业统计中的员工业绩(v1.1.1)
     *
     * @param pageNo
     * @param pageSize
     * @param vo
     * @return
     */
    @PostMapping(value = "/beauticianTradeDetails/1.1.1/queryMemberPerformance")
    ResponseMessage<PageInfo<QueryMemberPerformanceResponseVo>> queryMemberPerformanceV111(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                           @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                           @RequestBody QueryMemberPerformanceVo vo);


    /**
     * 根据美容师流水vo查询数据(v1.1.0)
     *
     * @param pageNo
     * @param pageSize
     * @param vo
     * @return
     */
    @PostMapping(value = "/beauticianTradeDetails/1.1.0/selectListByConditionsVo")
    ResponseMessage<PageInfo<BeauticianTradeDetail>> selectListByConditionsVoV110(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                                  @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                  @RequestBody BeauticianTradeDetailVo vo);

    /**
     * 美容师流水数据统计vo(v1.1.0)
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/beauticianTradeDetails/1.1.0/queryBeauticianTradeStatistical/{id}")
    ResponseMessage<BeauticianTradeStatisticalVo> queryBeauticianTradeStatisticalV110(@PathVariable("id") Integer id);

    /**
     * 添加美容师流水(v1.1.0)
     *
     * @param record
     * @return
     */
    @RequestMapping(value = "/beauticianTradeDetails/1.1.0/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    ResponseMessage<Integer> insertSelectiveV110(@RequestBody BeauticianTradeDetail record);

    /**
     * 根据ID更新美容师流水(v1.1.0)
     *
     * @param record
     * @return
     */
    @RequestMapping(value = "/beauticianTradeDetails/1.1.0/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    ResponseMessage updateByPrimaryKeySelectiveV110(@RequestBody BeauticianTradeDetail record);

    /**
     * 美容师提现到银行卡(v1.1.0)
     *
     * @param memberWithdrawsVo
     * @return
     */
    @PostMapping(value = "/beauticianTradeDetails/1.1.0/withdrawalsByBeautician")
    ResponseMessage withdrawalsByBeauticianV110(@RequestBody WithdrawsVo memberWithdrawsVo);


    /**
     * 根据ID查询美容师流水(v1.1.0)
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/beauticianTradeDetails/1.1.0/selectById/{id}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    ResponseMessage<BeauticianTradeDetailResultVo> selectVoByPrimaryKeyV110(@PathVariable("id") Integer id);

}