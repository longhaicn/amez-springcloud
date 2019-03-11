package com.union.aimei.pay.task;

import com.google.gson.Gson;
import com.union.aimei.common.constant.common.HttpStatusConstant;
import com.union.aimei.common.constant.order.OrderNumericalConstant;
import com.union.aimei.common.constant.pay.HasPayEnum;
import com.union.aimei.common.feign.app.financial.BeauticianTradeDetailFeign;
import com.union.aimei.common.feign.app.learn.LearnTradeRecodeFeign;
import com.union.aimei.common.feign.app.order.OrderBaseFeign;
import com.union.aimei.common.feign.app.order.OrderGoodsBaseFeign;
import com.union.aimei.common.model.financial.BeauticianTradeDetail;
import com.union.aimei.common.model.learn.LearnTradeRecode;
import com.union.aimei.common.model.order.OrderBase;
import com.union.aimei.common.model.order.OrderGoodsBase;
import com.union.aimei.common.vo.learn.app.TradeRecodeCallBackVo;
import com.union.aimei.common.vo.pay.PayReturnVo;
import com.union.aimei.pay.service.AfterPayService;
import com.union.common.utils.AssertUtil;
import com.union.common.utils.CollectionUtils;
import com.union.common.utils.ResponseMessage;
import com.union.redis.RedisService;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author GaoWei
 * @time 2018/5/23 21:02
 * @description 支付补偿定时任务
 */
@Component
@CommonsLog
public class PayCompensate {

    /**
     * 支付补偿KEY
     */
    private static final String KEY=HasPayEnum.PAY_COMPENSATE_KEY.getValue();
    /**
     * 支付补偿搜索HashKey
     */
    private static final String HASH_KEY=HasPayEnum.PAY_COMPENSATE_HASH_KEY.getValue();

    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    private RedisService redisService;
    @Resource
    private AfterPayService afterPayService;
    @Resource
    private OrderBaseFeign orderBaseFeign;
    @Resource
    private OrderGoodsBaseFeign orderGoodsBaseFeign;
    @Resource
    private BeauticianTradeDetailFeign beauticianTradeDetailFeign;
    @Resource
    private LearnTradeRecodeFeign learnTradeRecodeFeign;


    public void orderPaySuccessCompensateTask(){
        log.info("支付成功异常补偿任务开始执行：");
        List<PayReturnVo> list=returnVoList(KEY,HASH_KEY);
        log.info("需要补偿的数据为:"+list.toString());
        if(!CollectionUtils.isEmpty(list)){
            list.forEach(x->{
                //0:项目购买，1：实物产品购买，2：课程购买，3：活动支付
                int useType=x.getPayUseType();
                log.info("补偿任务类型为："+useType);
                if(useType==0){
                    log.info("执行：项目购买定时任务");
                    compensateProductOrder(x);
                }else if(useType==1){
                    log.info("执行：实物产品购买定时任务");
                    compensateGoodsOrder(x);
                }else  if(useType==PayReturnVo.PayUseType.LESSONS||useType==PayReturnVo.PayUseType.ACTIVITY){
                    log.info("执行：学习课程购买定时任务");
                    compensateLearnTrade(x);
                }
            });
        }
    }

    /**
     * 项目购买异常补偿
     * @param payReturnVo
     */
    private void compensateProductOrder(PayReturnVo payReturnVo){
        log.info("开始执行项目购买异常补偿");
        String orderNo=payReturnVo.getOrderNo();
        OrderBase orderBase=orderBaseFeign.queryByOrderNo(orderNo);
        if(orderBase==null){
            log.info("查询不到该订单,执行删除Redis数据");
            deleteCompensateHashKey(orderNo);
            return;
        }
        int status=orderBase.getStatus();
        log.info("订单状态为："+status);
        //如果订单状态没有改变则全部走一遍
        if(status==0){
            orderBaseFeign.updateStateAfterPay(payReturnVo);
            repeatTask(payReturnVo);
        //如果订单状态改变了
        }else if(status==OrderBase.OrderStatus.WAIT_SERVER){
            repeatTask(payReturnVo);
        }
        //再次查询
        OrderBase orderBase1=orderBaseFeign.queryByOrderNo(orderNo);
        ResponseMessage<BeauticianTradeDetail> res=beauticianTradeDetailFeign.queryByOrderNoAndType(payReturnVo.getOrderNo(),1);
        boolean isTrue=orderBase1.getStatus()==2&&res.getCode()==200&&res.getData()!=null;
        if(isTrue){
            log.info("补偿成功，删除redis数据");
            deleteCompensateHashKey(orderNo);
        }else{
            log.info("补偿失败，尝试继续补偿");
        }

    }

    /**
     * 查询交易流水,如果没有则代表出现异常导致回滚，重新走一遍
     * @param payReturnVo
     */
    private void repeatTask(PayReturnVo payReturnVo){
        ResponseMessage<BeauticianTradeDetail> res=beauticianTradeDetailFeign.queryByOrderNoAndType(payReturnVo.getOrderNo(),1);
        if(res.getCode()==HttpStatusConstant.OK.getStatus() &&res.getData()==null){
            afterPayService.hasPaySuccess(payReturnVo);
        }
    }

    /**
     * 实物产品支付成功异常补偿
     * @param payReturnVo
     */
    private void compensateGoodsOrder(PayReturnVo payReturnVo){
       ResponseMessage<OrderGoodsBase> res=orderGoodsBaseFeign.queryByOrderNo(payReturnVo.getOrderNo());
       AssertUtil.isRemoteInvokeSuccess(res);
       OrderGoodsBase orderGoodsBase=res.getData();
       int status=orderGoodsBase.getStatus();
       if(status==0){
           ResponseMessage resMsg=orderGoodsBaseFeign.updateOrderGoodsBaseInfoAfterPay(payReturnVo);
           AssertUtil.isRemoteInvokeSuccess(resMsg);
           deleteCompensateHashKey(payReturnVo.getOrderNo());
       }

    }

    /**
     * 课程及活动支付成功异常补偿
     * @param payReturnVo
     */
    private void compensateLearnTrade(PayReturnVo payReturnVo){
        ResponseMessage<LearnTradeRecode> res=learnTradeRecodeFeign.queryTradeRecodeByOrderNo(payReturnVo.getOrderNo());
        AssertUtil.isRemoteInvokeSuccess(res);
        LearnTradeRecode recode=res.getData();
        boolean isPay=recode.getPayStatus();
        if(!isPay){
            TradeRecodeCallBackVo vo=new TradeRecodeCallBackVo();
            vo.setOrderNo(payReturnVo.getOrderNo());
            vo.setPayType(payReturnVo.getPayType().byteValue());
            vo.setTradeNo(payReturnVo.getTradeNo());
            vo.setTradeAmount(payReturnVo.getAmountPay());
            ResponseMessage resMsg=learnTradeRecodeFeign.tradeRecodeCallBack(vo);
            AssertUtil.isRemoteInvokeSuccess(resMsg);
            deleteCompensateHashKey(payReturnVo.getOrderNo());
        }

    }

    /**
     *  从redis中获取需要补偿的Payreturn信息
     * @param key
     * @param hashKey
     * @return
     */
    public List<PayReturnVo> returnVoList(String key, String hashKey){
        BoundHashOperations bo = redisTemplate.boundHashOps(key);
        ScanOptions.ScanOptionsBuilder scanBuider=  new ScanOptions.ScanOptionsBuilder();
        scanBuider.match("*"+hashKey+"*");
        ScanOptions so =scanBuider.build();
        Cursor cur = bo.scan(so);
        List<PayReturnVo> list=new ArrayList<>(10);
        try {
            while(cur.hasNext()){
                Map.Entry e= (Map.Entry) cur.next();
                if(e!=null){
                    list.add(new Gson().fromJson(e.getValue().toString(), PayReturnVo.class));
                }
            }
            cur.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 删除补偿hashKey
     * @param orderNo
     */
    private void deleteCompensateHashKey(String orderNo){
        StringBuilder hashKey=new StringBuilder();
        hashKey.append(HASH_KEY);
        hashKey.append(orderNo);
        //删除redis中的hash_key数据
        redisService.hashDelete(KEY,hashKey);
    }


}
