package com.union.aimei.common.feign.pc.financial;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.financial.hystrix.BeauticianTradeDetailHystrix;
import com.union.aimei.common.model.financial.BeauticianTradeDetail;
import com.union.aimei.common.vo.financial.BatchMoneyVo;
import com.union.aimei.common.vo.financial.WithdrawsVo;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
/**
 * @author dell
 */
@FeignClient(name = "pc-financial-service", fallback = BeauticianTradeDetailHystrix.class)
public interface BeauticianTradeDetailFeign {
    /**
     * 基本操作
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
     * 基本操作
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
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    @RequestMapping(value = "/beauticianTradeDetails/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    PageInfo<BeauticianTradeDetail> selectListByConditions(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, @RequestBody BeauticianTradeDetail record);

    /**
     * 分页和条件查询提现列表
     *
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    @RequestMapping(value = "/beauticianTradeDetails/withdrawList", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    PageInfo<BeauticianTradeDetail> withdrawList(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, @RequestBody WithdrawsVo record);

    /**
     * 批量打款
     *
     * @param ids
     * @return
     */
    @RequestMapping(value = "/beauticianTradeDetails/batchMoney/{ids}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    ResponseMessage<String> batchMoney(@PathVariable("ids") String ids);

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
     * 据订单编号和类型查询
     * @param orderNo
     * @param type
     * @return
     */
    @RequestMapping(value = "/beauticianTradeDetails/queryByOrderNoAndType")
    ResponseMessage<BeauticianTradeDetail> queryByOrderNoAndType(@RequestParam(value = "orderNo") String orderNo,
                                                                 @RequestParam(value = "type") Integer type);


    /**
     * 添加美容师流水(v1.1.0)
     *
     * @param record
     * @return
     */
    @RequestMapping(value = "/beauticianTradeDetails/1.1.0/insert", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    ResponseMessage<Integer> insertSelectiveV110(@RequestBody BeauticianTradeDetail record);

    /**
     * 批量打款(v1.1.1)
     *
     * @param batchMoneyVos
     * @return
     */
    @RequestMapping(value = "/beauticianTradeDetails/1.1.1/batchMoney", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    ResponseMessage<String> batchMoneyV111(@RequestBody List<BatchMoneyVo> batchMoneyVos);
}