package com.union.aimei.pay.service.impl;


import org.springframework.stereotype.Service;

/**
 * @author GaoWei
 * @describe
 * @time 2017/12/19,15:59
 */
@Service
public class MemberCardTradeServiceImpl {


//    private static final Logger log = LoggerFactory.getLogger(MemberCardTradeServiceImpl.class);
//    @Resource
//    private WxPayFeign wxPayFeign;
//    @Resource
//    private AliPayFeign aliPayFeign;
//    @Resource
//    private MemberCardFeign memberCardFeign;
//    @Resource
//    private MemberCardRefFeign memberCardRefFeign;
//    @Resource
//    private OrderBaseFeign orderBaseFeign;
//    @Resource
//    private MemberCardTradeRecodeFeign memberCardTradeRecodeFeign;
//    @Resource
//    private AfterPayOperationService afterPayOperationService;
//
//    /**
//     * 生成会员卡充值订单号
//     *
//     * @return
//     */
//    private static String generateOutTradeNo() {
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append(CreateOrderNo.getInstance().GenerateOrder());
//        return stringBuilder.toString();
//    }
//
//    /**
//     * 获取会员卡交易预支付结果
//     *
//     * @param memberCardTrade
//     * @return
//     * @throws WxPayException
//     */
//    @Override
//    public ResponseMessage getPreResult(MemberCardTrade memberCardTrade) throws WxPayException {
//        log.info("请求对象:"+memberCardTrade.toString());
//        ResponseMessage responseMessage = new ResponseMessage();
//        //生成交易订单号
//        String outTradeNo = generateOutTradeNo();
//        log.info("订单号为："+outTradeNo);
//        memberCardTrade.setMemberCardTradeOrderNo(outTradeNo);
//        //获取支付类型
//        Byte payType = memberCardTrade.getPayType();
//        log.info("支付类型为："+payType);
//        //获取交易类型
//        Byte useType = memberCardTrade.getUseType();
//        log.info("交易类型为："+useType);
//        //获取交易金额(购卡则取卡面面值，充值则接收充值金额)
//        Integer payAmount = 0;
//        //会员卡ID
//        Integer memberId = memberCardTrade.getMemberId();
//        String memberCardName;
//        MemberCard memberCard = memberCardFeign.queryById(memberCardTrade.getMemberCardId());
//        TradeVo tradeVo=new TradeVo();
//        if (memberCard == null) {
//            responseMessage.setCode(MemberConstant.MemberCard.CARD_IS_NOT_EXSIT);
//            responseMessage.setMessage(MemberConstant.MemberCard.CARD_IS_NOT_EXSIT_MSG);
//            return responseMessage;
//        } else {
//            memberCardName = memberCard.getCardName();
//            tradeVo.setOrderNo(outTradeNo);
//            tradeVo.setProductName(memberCardName);
//            if (useType == 0) {
//                tradeVo.setTradeType(2);
//                payAmount = memberCardTrade.getAmount();
//            } else if (useType == 2) {
//                tradeVo.setTradeType(1);
//                payAmount = memberCard.getBalance();
//            }
//
//        }
//        tradeVo.setPayType((int) payType);
//        tradeVo.setAmountTotal(payAmount);
//        //确保交易参数全部正确，否则会调用支付失败
//        boolean tradeParamsRight = memberId == null || memberCardName == null || outTradeNo == null || (useType > 2 || useType < 0) || (payType < 0 || payType > 2) || (payAmount <= 0);
//        if (tradeParamsRight) {
//            responseMessage.setCode(PayConstant.TRADE_PARAMS_ERROR);
//            responseMessage.setMessage(PayConstant.TRADE_PARAMS_ERROR_MSG);
//            return responseMessage;
//        }
//        //调用微信支付生成预支付交易单
//        if (0 == payType) {
//            log.info("申请调用微信支付");
//            responseMessage=wxPayFeign.unifiedOrder(tradeVo);
//        } else
//            //调用支付宝支付
//            if (1 == payType) {
//                log.info("申请调用支付宝支付");
//                ResponseMessage<String> body = aliPayFeign.appPayReturnBody(tradeVo);
//                if (200==body.getCode()) {
//                    responseMessage.setData(body);
//                } else {
//                    responseMessage.setCode(PayConstant.INVOKE_ALI_PAY_FAIL);
//                    responseMessage.setMessage(PayConstant.INVOKE_ALI_PAY_FAIL_MSG);
//                }
//            } else {
//                responseMessage.setCode(PayConstant.PAY_FAIL);
//                responseMessage.setMessage(PayConstant.PAY_FAIL_MSG);
//            }
//        if (200 == responseMessage.getCode()) {
//            log.info("状态正常，添加会员卡预交易记录");
//            //添加一条未支付状态的会员卡交易记录
//            MemberCardTradeRecode tradeRecode = getMemberCardTradeRecode(memberCardTrade, payAmount, outTradeNo, payType);
//            memberCardTradeRecodeFeign.insert(tradeRecode);
//        }
//        log.info("调用结果为:"+responseMessage.toString());
//        return responseMessage;
//    }
//
//    private MemberCardTradeRecode getMemberCardTradeRecode(MemberCardTrade memberCardTrade, Integer amount, String orderNo, Byte payType) {
//        MemberCardTradeRecode tradeRecode = new MemberCardTradeRecode();
//        Byte type=memberCardTrade.getUseType();
//        if(2==type){
//            boolean isPlatForm=memberCardTrade.getIsPlatForm();
//            tradeRecode.setIsPlatform(isPlatForm);
//            if(!isPlatForm){
//                tradeRecode.setIssueName("平台");
//            }else{
//                tradeRecode.setIssueName(memberCardTrade.getStoreName());
//            }
//        }
//        tradeRecode.setMemberId(memberCardTrade.getMemberId());
//        tradeRecode.setMemberCardId(memberCardTrade.getMemberCardId());
//        tradeRecode.setMemberCardRefId(memberCardTrade.getMemberCardRefId());
//        tradeRecode.setTradeAmount(amount);
//        tradeRecode.setUseType(memberCardTrade.getUseType());
//        tradeRecode.setStoreId(memberCardTrade.getStoreId());
//        tradeRecode.setStoreName(memberCardTrade.getStoreName());
//        tradeRecode.setOrderNo(orderNo);
//        tradeRecode.setPayType(payType);
//        return tradeRecode;
//    }
//
//
//
//    /**
//     * 会员卡消费
//     * @param memberCardTrade
//     * @return
//     */
//    @Override
//    @TxTransaction(isStart = true,rollbackFor = Exception.class)
//    public ResponseMessage memberCardConsume(MemberCardTrade memberCardTrade) {
//        ResponseMessage responseMessage = new ResponseMessage();
//        if(memberCardTrade==null){
//            responseMessage.setCode(RequestConstant.PARAM_EMPTY);
//            responseMessage.setMessage(RequestConstant.PARAM_EMPTY_MSG);
//            return responseMessage;
//        }
//        String orderNo=memberCardTrade.getMemberCardTradeOrderNo();
//        Byte payType=memberCardTrade.getPayType();
//        OrderBase orderBase = orderBaseFeign.queryByOrderNo(orderNo);
//        if (orderBase != null) {
//            Integer orderStatus=orderBase.getStatus();
//            if(orderStatus>=2){
//                responseMessage.setCode(PayConstant.REPEAT_PAY);
//                responseMessage.setMessage(PayConstant.REPEAT_PAY_MSG);
//                return responseMessage;
//            }
//            Integer orderAmount=orderBase.getNeedPay();
//            responseMessage = memberCardRefFeign.memberCardConsume(orderAmount, memberCardTrade.getMemberId(), memberCardTrade.getMemberCardRefId());
//            if (200 == responseMessage.getCode()) {
//                //添加会员卡交易记录
//                MemberCardTradeRecode recode=getMemberCardTradeRecode(memberCardTrade,orderAmount,orderNo,payType);
//                Byte status=1;
//                recode.setPayStatus(status);
//                memberCardTradeRecodeFeign.insert(recode);
//                //添加交易流水记录
//                afterPayOperationService.operationProductOrder(orderNo,"",3,orderAmount);
//            }
//        } else {
//            responseMessage.setCode(OrderConstant.Base.ORDER_ISNOT_EXSIT);
//            responseMessage.setMessage(OrderConstant.Base.ORDER_ISNOT_EXSIT_MSG);
//        }
//        return responseMessage;
//    }


}
