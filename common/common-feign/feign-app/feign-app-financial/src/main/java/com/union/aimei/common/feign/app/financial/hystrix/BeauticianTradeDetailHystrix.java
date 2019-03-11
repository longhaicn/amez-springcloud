package com.union.aimei.common.feign.app.financial.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.financial.BeauticianTradeDetailFeign;
import com.union.aimei.common.model.financial.BeauticianTradeDetail;
import com.union.aimei.common.vo.financial.*;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;
/**
 * @author liufeihua
 */
@Component
public class BeauticianTradeDetailHystrix implements BeauticianTradeDetailFeign {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 1;
    }

    @Override
    public int insertSelective(BeauticianTradeDetail record) {
        return 1;
    }

    @Override
    public BeauticianTradeDetail selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(BeauticianTradeDetail record) {
        return 1;
    }

    @Override
    public PageInfo<BeauticianTradeDetail> selectListByConditions(Integer pageNo, Integer pageSize, BeauticianTradeDetail record) {
        return null;
    }

    /**
     * 根据订单编号删除流水
     *
     * @param orderNo
     * @return
     */
    @Override
    public ResponseMessage<Integer> deleteTradeDetailByOrderNo(String orderNo) {
        return null;
    }

    /**
     * 日订单数和日收入
     *
     * @param id
     * @return
     */
    @Override
    public ResponseMessage<Map<String, Object>> dayOrderAndAccount(Integer id) {
        return null;
    }

    @Override
    public ResponseMessage<BeauticianTradeDetail> queryByOrderNoAndType(String orderNo, Integer type) {
        return HystrixResponse.invokeFail();
    }

    @Override
    @Deprecated
    public ResponseMessage<PageInfo<QueryMemberPerformanceResponseVo>> queryMemberPerformanceV110(Integer pageNo, Integer pageSize, QueryMemberPerformanceVo vo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<PageInfo<QueryMemberPerformanceResponseVo>> queryMemberPerformanceV111(Integer pageNo, Integer pageSize, QueryMemberPerformanceVo vo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<PageInfo<BeauticianTradeDetail>> selectListByConditionsVoV110(Integer pageNo, Integer pageSize, BeauticianTradeDetailVo vo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<BeauticianTradeStatisticalVo> queryBeauticianTradeStatisticalV110(Integer id) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage insertSelectiveV110(BeauticianTradeDetail record) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage updateByPrimaryKeySelectiveV110(BeauticianTradeDetail record) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage withdrawalsByBeauticianV110(WithdrawsVo memberWithdrawsVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<BeauticianTradeDetailResultVo> selectVoByPrimaryKeyV110(Integer id) {
        return HystrixResponse.invokeFail();
    }


}