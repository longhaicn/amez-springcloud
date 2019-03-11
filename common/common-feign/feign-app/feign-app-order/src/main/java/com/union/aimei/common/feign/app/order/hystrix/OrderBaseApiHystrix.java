package com.union.aimei.common.feign.app.order.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.order.OrderBaseFeign;
import com.union.aimei.common.model.order.OrderBase;
import com.union.aimei.common.vo.order.*;
import com.union.aimei.common.vo.pay.PayReturnVo;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.exception.ServerException;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;


/**
 * @author GaoWei
 * @describe
 * @time 2017/12/7,10:56
 */
@Component(value = "app-OrderBaseFeign")
public class OrderBaseApiHystrix implements OrderBaseFeign {

    /**
     * 前端分页查询订单
     *
     * @param pageNo    分页索引
     * @param pageSize  每页显示数量
     * @param orderBase 查询条件
     * @return
     */
    @Override
    public ResponseMessage<PageInfo<HashMap<String, Object>>> findByPageForFront(Integer pageNo, Integer pageSize, OrderBase orderBase) {
        return HystrixResponse.invokeFail();
    }

    /**
     * 添加订单
     *
     * @param orderBase
     * @return
     */
    @Override
    public int insert(OrderBase orderBase) {
        return 0;
    }

    /**
     * 删除订单
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改订单
     *
     * @param orderBase
     * @return
     */
    @Override
    public int edit(OrderBase orderBase) {
        return 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnorderBase
     */
    @Override
    public OrderBase queryById(int id) {
        return null;
    }



    @Override
    public ResponseMessage<HashMap<String, Object>> submitProductOrder(SubmitOrderVo submitOrderVo) {
       throw new ServerException(500,"网络异常,请稍后重试");
    }

    @Override
    public ResponseMessage verificationByCode(Integer isStoreOwner, String mobile, Integer storeId, Integer beauticianId, String orderNo, String verificationCode) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public OrderBase queryByOrderNo(String orderNo) {
        return null;
    }

    @Override
    public ResponseMessage updateStateAfterPay(PayReturnVo payReturnVo) {
        return HystrixResponse.invokeFail();
    }




    @Override
    public ResponseMessage<HashMap<String, Object>> queryOrderDetailsInfO(Integer id) {
        return null;
    }

    @Override
    public ResponseMessage queryMemberHasConsumer(Integer storeId, Integer memberId) {
            return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<SubmitOrder> queryOrderAllInfoByOrderNo(String orderNo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage refund(String orderNo, String reason, String remark) {
        return HystrixResponse.invokeFail();
    }



    @Override
    public ResponseMessage cancelRefundApply(Integer orderId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<RefundDetailsVo> queryRefundDetails(String orderNo) {
        return HystrixResponse.invokeFail();
    }



    @Override
    public PageInfo<HashMap<String, Object>> queryByCondition(Integer pageNo, Integer pageSize, BeauticianQueryVo beauticianQueryVo) {
        return new PageInfo<>();
    }


    @Override
    public ResponseMessage<OrderSendAppVo> querySendToAppVoByOrderId(Integer orderId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<HashMap<String, Object>> queryOrderRefundFailInfo(Integer orderId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<Integer> countBeauticianPreIncome(Integer beauticianId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage updateAppointmentTime(UpdateAppointmentTimeVo updateAppointmentTimeVo) {
        return HystrixResponse.invokeFail();
    }


    @Override
    public ResponseMessage<List<StoreTodayOrderCount>> queryOrderNumByStoreId(Integer storeId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<List<BeauticianTodayOrderCount>> queryOrderNumByBeauticianId(Integer beauticianId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage updateRefundApplication(String orderNo, String reason, String remark) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage auditRefundApply(AuditRefundVo auditRefundVo) {
        return null;
    }

    @Override
    public ResponseMessage changeOrderBeautician(String orderNo, Integer beauticianId) {
        return null;
    }
}