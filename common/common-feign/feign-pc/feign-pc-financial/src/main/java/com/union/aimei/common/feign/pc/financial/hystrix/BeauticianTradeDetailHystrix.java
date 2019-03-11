package com.union.aimei.common.feign.pc.financial.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.financial.BeauticianTradeDetailFeign;
import com.union.aimei.common.model.financial.BeauticianTradeDetail;
import com.union.aimei.common.vo.financial.BatchMoneyVo;
import com.union.aimei.common.vo.financial.WithdrawsVo;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
/**
 * @author dell
 */
@Component(value = "pc-BeauticianTradeDetailFeign")
public class BeauticianTradeDetailHystrix implements BeauticianTradeDetailFeign {

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
     * 分页和条件查询提现列表
     *
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    @Override
    public PageInfo<BeauticianTradeDetail> withdrawList(Integer pageNo, Integer pageSize, WithdrawsVo record) {
        return null;
    }

    /**
     * 批量打款
     *
     * @param ids
     * @return
     */
    @Override
    public ResponseMessage<String> batchMoney(String ids) {
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
    public ResponseMessage<Integer> insertSelectiveV110(BeauticianTradeDetail record) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<String> batchMoneyV111(List<BatchMoneyVo> batchMoneyVos) {
        return HystrixResponse.invokeFail();
    }
}