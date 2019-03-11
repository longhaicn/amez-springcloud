package com.union.aimei.financial.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.financial.BeauticianTradeDetail;
import com.union.aimei.common.vo.financial.*;
import com.union.common.utils.ResponseMessage;

import java.util.Map;
/**
 * @author liufeihua
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
    ResponseMessage insertSelectiveV110(BeauticianTradeDetail record);
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
    ResponseMessage updateByPrimaryKeySelectiveV110(BeauticianTradeDetail record);

    /**
     * 查看
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    PageInfo<BeauticianTradeDetail> selectListByConditions(Integer pageNo, Integer pageSize, BeauticianTradeDetail record);

    /**
     * 根据美容师流水vo查询数据(v1.1.0)
     *
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    ResponseMessage<PageInfo<BeauticianTradeDetail>> selectListByConditionsVoV110(Integer pageNo, Integer pageSize, BeauticianTradeDetailVo record);

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
     * app门店端的营业统计中的员工业绩(v1.1.0)
     * @param pageNo
     * @param pageSize
     * @param vo
     * @return
     */
    ResponseMessage<PageInfo<QueryMemberPerformanceResponseVo>> queryMemberPerformanceV110(Integer pageNo, Integer pageSize, QueryMemberPerformanceVo vo);

    /**
     * 美容师流水数据统计vo(v1.1.0)
     * @param beauticianId
     * @return
     */
    ResponseMessage<BeauticianTradeStatisticalVo> queryBeauticianTradeStatisticalV110(Integer beauticianId);

    /**
     * app门店端的营业统计中的员工业绩(v1.1.1)
     * @param pageNo
     * @param pageSize
     * @param vo
     * @return
     */
    ResponseMessage<PageInfo<QueryMemberPerformanceResponseVo>> queryMemberPerformanceV111(Integer pageNo, Integer pageSize, QueryMemberPerformanceVo vo);

    /**
     * 美容师提现到银行卡(v1.1.0)
     *
     * @param memberWithdrawsVo
     * @return
     */
    ResponseMessage withdrawalsByBeauticianV110(WithdrawsVo memberWithdrawsVo);


    /**
     * 返回美容师流水vo(v1.1.0)
     *
     * @param id
     * @return
     */
    ResponseMessage<BeauticianTradeDetailResultVo> selectVoByPrimaryKeyV110(Integer id);


}