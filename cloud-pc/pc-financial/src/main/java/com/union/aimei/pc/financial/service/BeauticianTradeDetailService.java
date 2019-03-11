package com.union.aimei.pc.financial.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.financial.BeauticianTradeDetail;
import com.union.aimei.common.vo.financial.BatchMoneyVo;
import com.union.aimei.common.vo.financial.WithdrawsVo;
import com.union.common.utils.ResponseMessage;

import java.util.List;
import java.util.Map;
/**
 * @author dell
 */
public interface BeauticianTradeDetailService {
    /**
     * 基本操作
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int insertSelective(BeauticianTradeDetail record);
    /**
     * 基本操作
     *
     * @param id
     * @return
     */
    BeauticianTradeDetail selectByPrimaryKey(Integer id);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BeauticianTradeDetail record);
    /**
     * 查看
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    PageInfo<BeauticianTradeDetail> selectListByConditions(Integer pageNo, Integer pageSize, BeauticianTradeDetail record);

    /**
     * 分页和条件查询提现列表
     *
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    PageInfo<BeauticianTradeDetail> withdrawList(Integer pageNo, Integer pageSize, WithdrawsVo record);

    /**
     * 批量打款
     *
     * @param ids
     * @return
     */
    ResponseMessage<String> batchMoney(String ids);

    /**
     * 根据订单编号删除流水
     *
     * @param orderNo
     * @return
     */
    ResponseMessage<Integer> deleteTradeDetailByOrderNo(String orderNo);

    /**
     * 日订单数和日收入
     *
     * @param id
     * @return
     */
    ResponseMessage<Map<String, Object>> dayOrderAndAccount(Integer id);

    /**
     * 通过订单编号和类型查询
     *
     * @param orderNo
     * @param type
     * @return
     */
    ResponseMessage<BeauticianTradeDetail> queryByOrderNoAndType(String orderNo, Integer type);

    /**
     * 批量打款(v1.1.1)
     *
     * @param batchMoneyVos
     * @return
     */
    ResponseMessage<String> batchMoneyV111(List<BatchMoneyVo> batchMoneyVos);
}