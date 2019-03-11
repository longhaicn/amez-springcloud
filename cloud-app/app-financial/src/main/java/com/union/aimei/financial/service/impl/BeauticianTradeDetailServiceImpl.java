package com.union.aimei.financial.service.impl;

import com.codingapi.tx.annotation.TxTransaction;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.constant.financial.CommissionEnum;
import com.union.aimei.common.constant.financial.FinancialConstant;
import com.union.aimei.common.feign.app.member.MemberBankCardFeign;
import com.union.aimei.common.feign.app.member.MemberFeign;
import com.union.aimei.common.feign.app.member.MemberRealNameAuthFeign;
import com.union.aimei.common.feign.app.member.MemberWithdrawsFeign;
import com.union.aimei.common.feign.app.order.OrderBaseFeign;
import com.union.aimei.common.feign.app.order.OrderProductFeign;
import com.union.aimei.common.feign.app.product.ProductFeign;
import com.union.aimei.common.feign.app.store.StoreBeauticianFeign;
import com.union.aimei.common.model.financial.*;
import com.union.aimei.common.model.member.Member;
import com.union.aimei.common.model.member.MemberBankCard;
import com.union.aimei.common.model.member.MemberRealNameAuth;
import com.union.aimei.common.model.member.MemberWithdraws;
import com.union.aimei.common.model.order.OrderBase;
import com.union.aimei.common.model.order.OrderProduct;
import com.union.aimei.common.model.product.Product;
import com.union.aimei.common.model.store.StoreBeautician;
import com.union.aimei.common.vo.financial.*;
import com.union.aimei.common.vo.member.MemberWithdrawsVo;
import com.union.aimei.common.vo.order.BeauticianTodayOrderCount;
import com.union.aimei.common.vo.store.app.StoreBeauticianByIdBatchVo;
import com.union.aimei.financial.mapper.BeauticianTradeDetailMapper;
import com.union.aimei.financial.mapper.PlatformTradeDetailMapper;
import com.union.aimei.financial.mapper.StoreTradeDetailMapper;
import com.union.aimei.financial.service.BeauticianTradeDetailService;
import com.union.aimei.financial.service.CommissionSettingService;
import com.union.common.utils.AssertUtil;
import com.union.common.utils.CollectionUtils;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseUtil;
import com.union.common.utils.create.CreateOrderNo;
import com.union.common.utils.date.DateUtil;
import com.union.common.utils.exception.ServerException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author liufeihua
 */
@Service
public class BeauticianTradeDetailServiceImpl implements BeauticianTradeDetailService {

    @Autowired
    private BeauticianTradeDetailMapper beauticianTradeDetailMapper;

    @Autowired
    private StoreTradeDetailMapper storeTradeDetailMapper;

    @Autowired
    private PlatformTradeDetailMapper platformTradeDetailMapper;

    @Autowired
    private CommissionSettingService commissionSettingService;

    @Autowired
    private MemberRealNameAuthFeign memberRealNameAuthFeign;

    @Autowired
    private MemberBankCardFeign memberBankCardFeign;

    @Autowired
    private MemberFeign memberFeign;

    @Autowired
    private StoreBeauticianFeign storeBeauticianFeign;

    @Autowired
    private MemberWithdrawsFeign memberWithdrawsFeign;

    @Autowired
    private OrderBaseFeign orderBaseFeign;

    @Autowired
    private OrderProductFeign orderProductFeign;

    @Autowired
    private ProductFeign productFeign;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return this.beauticianTradeDetailMapper.deleteByPrimaryKey(id);
    }

    @Override
    @TxTransaction
    @Transactional(rollbackFor = Exception.class)
    public ResponseMessage insertSelectiveV110(BeauticianTradeDetail record) {
        //判断是否重复
        BeauticianTradeDetail repeatBeauticianTradeDetail = new BeauticianTradeDetail();
        repeatBeauticianTradeDetail.setOrderNo(record.getOrderNo());
        repeatBeauticianTradeDetail.setTradeType(record.getTradeType());
        List<BeauticianTradeDetail> list = beauticianTradeDetailMapper.selectListByConditions(repeatBeauticianTradeDetail);
        if (list.size() != 0) {
            throw new ServerException(FinancialConstant.Query.DUPLICATE_NUMBER, FinancialConstant.Query.SAVE_STREAM_ERRORS_DUPLICATE_DATA);
        }
        //保存操作
        record.setStatisticsYear(DateUtil.getCurrentYear());
        record.setStatisticsYearMonth(DateUtil.getCurrentYearMoth());
        record.setCreateTime(new Date());
        this.beauticianTradeDetailMapper.insertSelective(record);
        return new ResponseMessage(record.getId());
    }

    @Override
    public BeauticianTradeDetail selectByPrimaryKey(Integer id) {
        return this.beauticianTradeDetailMapper.selectByPrimaryKey(id);
    }

    @Override
    @TxTransaction
    @Transactional(rollbackFor = Exception.class)
    public ResponseMessage updateByPrimaryKeySelectiveV110(BeauticianTradeDetail record) {
        BeauticianTradeDetail repeatBeauticianTradeDetail = new BeauticianTradeDetail();
        repeatBeauticianTradeDetail.setOrderNo(record.getOrderNo());
        repeatBeauticianTradeDetail.setTradeType(record.getTradeType());
        List<BeauticianTradeDetail> list = beauticianTradeDetailMapper.selectListByConditions(repeatBeauticianTradeDetail);
        record.setId(list.get(0).getId());
        record.setUpdateTime(new Date());
        return new ResponseMessage(this.beauticianTradeDetailMapper.updateByPrimaryKeySelective(record));
    }

    @Override
    public PageInfo<BeauticianTradeDetail> selectListByConditions(Integer pageNo, Integer pageSize, BeauticianTradeDetail record) {
        PageHelper.startPage(pageNo, pageSize);
        return new PageInfo<>(beauticianTradeDetailMapper.selectListByConditions(record));
    }

    @Override
    public ResponseMessage<PageInfo<BeauticianTradeDetail>> selectListByConditionsVoV110(Integer pageNo, Integer pageSize, BeauticianTradeDetailVo record) {
        PageHelper.startPage(pageNo, pageSize);
        List<BeauticianTradeDetail> beauticianTradeDetailList = beauticianTradeDetailMapper.selectListByConditionsVo(record);
        for (BeauticianTradeDetail beauticianTradeDetail : beauticianTradeDetailList) {
            beauticianTradeDetail.setWithdrawAmount(-beauticianTradeDetail.getWithdrawAmount());
        }
        return new ResponseMessage<>(new PageInfo<>(beauticianTradeDetailList));
    }

    /**
     * 根据订单编号删除流水
     *
     * @param orderNo
     * @return
     */
    @Override
    public ResponseMessage<Integer> deleteTradeDetailByOrderNo(String orderNo) {

        //删除美容师表
        BeauticianTradeDetailExample beauticianTradeDetailExample = new BeauticianTradeDetailExample();
        BeauticianTradeDetailExample.Criteria criteria = beauticianTradeDetailExample.createCriteria();
        criteria.andOrderNoEqualTo(orderNo);
        beauticianTradeDetailMapper.deleteByExample(beauticianTradeDetailExample);

        //删除店铺
        StoreTradeDetailExample storeTradeDetailExample = new StoreTradeDetailExample();
        StoreTradeDetailExample.Criteria storeTradeDetailExampleCriteria = storeTradeDetailExample.createCriteria();
        storeTradeDetailExampleCriteria.andOrderNoEqualTo(orderNo);
        storeTradeDetailMapper.deleteByExample(storeTradeDetailExample);

        //删除平台
        PlatformTradeDetailExample platformTradeDetailExample = new PlatformTradeDetailExample();
        PlatformTradeDetailExample.Criteria platformTradeDetailExampleCriteria = platformTradeDetailExample.createCriteria();
        platformTradeDetailExampleCriteria.andOrderNumberEqualTo(orderNo);
        platformTradeDetailMapper.deleteByExample(platformTradeDetailExample);
        return new ResponseMessage<>();
    }

    /**
     * 日订单数和日收入
     *
     * @param id
     * @return
     */
    @Override
    public ResponseMessage<Map<String, Object>> dayOrderAndAccount(Integer id) {
        Map<String, Object> map = beauticianTradeDetailMapper.dayOrderAndAccount(id);
        HashMap<String, Object> hashMap = new HashMap<>(2);

        hashMap.put("id", id);
        hashMap.put("statisticsYearMonth", DateUtil.getCurrentYearMoth());
        map.put("statisticsYearMonth", beauticianTradeDetailMapper.monthAccount(hashMap));


        ResponseMessage<List<BeauticianTodayOrderCount>> listResponseMessage = orderBaseFeign.queryOrderNumByBeauticianId(id);
        AssertUtil.isTrue(listResponseMessage.getCode() == 200, listResponseMessage.getMessage());
        int size = listResponseMessage.getData().size();
        if (size > 0) {

            for (BeauticianTodayOrderCount beauticianTodayOrderCount : listResponseMessage.getData()) {
                if (beauticianTodayOrderCount.getStatus() == 2) {
                    map.put("waitForService", beauticianTodayOrderCount.getNum());
                } else if (beauticianTodayOrderCount.getStatus() == 3) {
                    map.put("ingForService", beauticianTodayOrderCount.getNum());
                } else if (beauticianTodayOrderCount.getStatus() == 4) {
                    map.put("waitForSay", beauticianTodayOrderCount.getNum());
                }
            }
        } else {
            map.put("waitForService", 0);
            map.put("ingForService", 0);
            map.put("waitForSay", 0);
        }


        return new ResponseMessage<>(map);
    }

    @Override
    public ResponseMessage<BeauticianTradeDetail> queryByOrderNoAndType(String orderNo, Integer type) {
        BeauticianTradeDetailExample example = new BeauticianTradeDetailExample();
        BeauticianTradeDetailExample.Criteria criteria = example.createCriteria();
        criteria.andOrderNoEqualTo(orderNo);
        criteria.andTradeTypeEqualTo(type);
        List<BeauticianTradeDetail> list = beauticianTradeDetailMapper.selectByExample(example);
        BeauticianTradeDetail beauticianTradeDetail = null;
        ResponseMessage<BeauticianTradeDetail> res = new ResponseMessage<>();
        if (!CollectionUtils.isEmpty(list) && null != list.get(0)) {
            beauticianTradeDetail = list.get(0);
            res.setData(beauticianTradeDetail);
        } else {
            throw new ServerException(FinancialConstant.Query.DUPLICATE_NUMBER, FinancialConstant.Query.SELECT_NULL);
        }
        return res;
    }

    /**
     * app门店端的营业统计中的员工业绩
     *
     * @param vo
     * @return
     */
    @Override
    @Deprecated
    public ResponseMessage<PageInfo<QueryMemberPerformanceResponseVo>> queryMemberPerformanceV110(Integer pageNo, Integer pageSize, QueryMemberPerformanceVo vo) {
        int i = 10;
        if (StringUtils.isNotEmpty(vo.getStartDate()) && vo.getStartDate().length() == i) {
            vo.setStartDate(vo.getStartDate() + " 00:00:00");
        }
        if (StringUtils.isNotEmpty(vo.getEndDate()) && vo.getEndDate().length() == i) {
            vo.setEndDate(vo.getEndDate() + " 23:59:59");
        }
        ResponseMessage responseMessage = new ResponseMessage();
        PageHelper.startPage(pageNo, pageSize);
        List<QueryMemberPerformanceResponseVo> queryMemberPerformanceResponseVoList = this.beauticianTradeDetailMapper.queryMemberPerformance(vo);
        PageInfo<QueryMemberPerformanceResponseVo> page = new PageInfo<>(queryMemberPerformanceResponseVoList);
        responseMessage.setData(page);
        return responseMessage;
    }

    @Override
    public ResponseMessage<BeauticianTradeStatisticalVo> queryBeauticianTradeStatisticalV110(Integer beauticianId) {
        BeauticianTradeStatisticalVo beauticianTradeStatisticalVo = this.beauticianTradeDetailMapper.queryBeauticianTradeStatistical(beauticianId);
        if (null == beauticianTradeStatisticalVo) {
            throw new ServerException(FinancialConstant.Query.DUPLICATE_NUMBER, FinancialConstant.Query.SELECT_NULL);
        }
        return new ResponseMessage<>(beauticianTradeStatisticalVo);
    }

    @Override
    public ResponseMessage<PageInfo<QueryMemberPerformanceResponseVo>> queryMemberPerformanceV111(Integer pageNo, Integer pageSize, QueryMemberPerformanceVo vo) {
        int i = 10;
        if (StringUtils.isNotEmpty(vo.getStartDate()) && vo.getStartDate().length() == i) {
            vo.setStartDate(vo.getStartDate() + " 00:00:00");
        }
        if (StringUtils.isNotEmpty(vo.getEndDate()) && vo.getEndDate().length() == i) {
            vo.setEndDate(vo.getEndDate() + " 23:59:59");
        }
        ResponseMessage responseMessage = new ResponseMessage();
        PageHelper.startPage(pageNo, pageSize);
        List<QueryMemberPerformanceResponseVo> queryMemberPerformanceResponseVoList = this.beauticianTradeDetailMapper.queryMemberPerformanceV111(vo);
        PageInfo<QueryMemberPerformanceResponseVo> page = new PageInfo<>(queryMemberPerformanceResponseVoList);
        responseMessage.setData(page);
        if (!CollectionUtils.isEmpty(page.getList())) {
            List<Integer> idList = page.getList().stream().map(QueryMemberPerformanceResponseVo::getBeauticianId).collect(Collectors.toList());
            //根据美容师id去获取美容师名字
            if (null != idList && idList.size() > 0) {
                StoreBeauticianByIdBatchVo storeBeauticianByIdBatchVo = new StoreBeauticianByIdBatchVo();
                storeBeauticianByIdBatchVo.setBeauticianIdList(idList);
                ResponseMessage<List<StoreBeautician>> responseMessage1 = this.storeBeauticianFeign.findListByIdBatch(storeBeauticianByIdBatchVo);
                ResponseUtil.isFailThrowException(responseMessage1);
                Map<Integer, StoreBeautician> map = responseMessage1.getData().stream().collect(Collectors.toMap(StoreBeautician::getId, Function.identity()));
                for (QueryMemberPerformanceResponseVo queryMemberPerformanceResponseVo : page.getList()) {
                    if (map.containsKey(queryMemberPerformanceResponseVo.getBeauticianId())) {
                        queryMemberPerformanceResponseVo.setBeauticianName(map.get(queryMemberPerformanceResponseVo.getBeauticianId()).getBeauticianName());
                        queryMemberPerformanceResponseVo.setHeadImgUrl(map.get(queryMemberPerformanceResponseVo.getBeauticianId()).getHeadImgUrl());
                        queryMemberPerformanceResponseVo.setBeauticianType(map.get(queryMemberPerformanceResponseVo.getBeauticianId()).getBeauticianType());
                    }
                }
            }
        }
        return responseMessage;
    }

    /**
     * 根据会员id来查询会员是否实名制认证
     *
     * @param memberId 会员ID
     */
    private MemberRealNameAuth withdrawalsByMemberRealName(int memberId) {
        MemberRealNameAuth memberRealNameAuth = new MemberRealNameAuth();
        memberRealNameAuth.setThirdAuthStatus((byte) 1);
        memberRealNameAuth.setAuditStatus((byte) 1);
        memberRealNameAuth.setMemberId(memberId);
        memberRealNameAuth = this.memberRealNameAuthFeign.queryByMemberId(memberRealNameAuth);
        if (null == memberRealNameAuth) {
            throw new ServerException(FinancialConstant.Query.ERROR_NUMBE, FinancialConstant.Query.MEMBERS_DID_NOT_IMPLEMENT_REAL_NAME_SYSTEM);
        }
        return memberRealNameAuth;
    }

    /**
     * 判断提现金额是否足够
     *
     * @param beauticianId   美容师ID
     * @param withdrawAmount 取款金额
     */
    private void withdrawalsBySettlementAmount(Integer beauticianId, Integer withdrawAmount) {
        ResponseMessage<BeauticianTradeStatisticalVo> responseMessage = this.queryBeauticianTradeStatisticalV110(beauticianId);
        ResponseUtil.isFailThrowException(responseMessage);
        if (responseMessage.getData().getSettlementAmount() < withdrawAmount) {
            //提现金额不足
            throw new ServerException(FinancialConstant.Query.DUPLICATE_NUMBER, FinancialConstant.Query.WITHDRAWAL_AMOUNT_IS_INSUFFICIENT);
        }
    }

    /**
     * 保存美容师流水
     *
     * @param storeBeautician
     * @param memberRealNameAuth
     * @param taxation
     * @param actualWithdrawalAmount
     * @param member
     * @param memberWithdrawsVo
     * @param memberBankCard
     * @param date
     */
    private Integer saveBeauticianTradeDetail(StoreBeautician storeBeautician, MemberRealNameAuth memberRealNameAuth, Integer taxation, Integer actualWithdrawalAmount, Member member, WithdrawsVo memberWithdrawsVo, MemberBankCard memberBankCard, Date date) {
        BeauticianTradeDetail beauticianTradeDetail = new BeauticianTradeDetail();
        //美容师类型
        if (storeBeautician.getBeauticianType() == StoreBeautician.BeauticianType.FULL_TIME) {
            beauticianTradeDetail.setBeauticianType(BeauticianTradeDetail.BEAUTICIAN_TYPE_FULL);
        } else if (storeBeautician.getBeauticianType() == StoreBeautician.BeauticianType.PART_TIME) {
            beauticianTradeDetail.setBeauticianType(BeauticianTradeDetail.BEAUTICIAN_TYPE_PART);
        }
        beauticianTradeDetail.setBeauticianName(memberRealNameAuth.getRealName());
        beauticianTradeDetail.setTaxation(taxation);
        beauticianTradeDetail.setActualAmount(actualWithdrawalAmount);
        beauticianTradeDetail.setBeauticianPhone(member.getRegisterPhone());
        beauticianTradeDetail.setStoreId(storeBeautician.getStoreId());
        beauticianTradeDetail.setStoreName(storeBeautician.getStoreName());
        beauticianTradeDetail.setBeauticianId(storeBeautician.getId());
        beauticianTradeDetail.setWithdrawAmount(memberWithdrawsVo.getWithdrawAmount());
        beauticianTradeDetail.setOrderNo(CreateOrderNo.getInstance().GenerateOrder());
        beauticianTradeDetail.setTradeType(2);
        beauticianTradeDetail.setTradeStatus(0);
        beauticianTradeDetail.setBankBranch(memberBankCard.getBankname());
        beauticianTradeDetail.setBankName(memberBankCard.getBankname());
        beauticianTradeDetail.setBankCardNo(memberBankCard.getBankcard());
        beauticianTradeDetail.setAddTime(date);
        beauticianTradeDetail.setCreateTime(date);
        beauticianTradeDetail.setPlayAmountStatus((byte) 0);
        beauticianTradeDetail.setRemarks(FinancialConstant.Query.WITHDRAW);
        beauticianTradeDetail.setTradeType(BeauticianTradeDetail.TRADE_TYPE_WITHDRAW);
        beauticianTradeDetail.setReadyPlayAmountTime(getNextTuesday(date));
        ResponseMessage<Integer> responseMessage = this.insertSelectiveV110(beauticianTradeDetail);
        ResponseUtil.isFailThrowException(responseMessage);
        return responseMessage.getData();
    }

    /**
     * 会员提现申请表赋值
     *
     * @param memberWithdrawsVo
     * @param storeBeautician
     * @param memberRealNameAuth
     * @param member
     * @param commissionSetting
     * @param taxation
     * @param actualWithdrawalAmount
     * @param memberBankCard
     * @param date
     * @param tradeDetailId
     */
    private void saveMemberWithdraws(WithdrawsVo memberWithdrawsVo, StoreBeautician storeBeautician, MemberRealNameAuth memberRealNameAuth, Member member, CommissionSetting commissionSetting, Integer taxation, Integer actualWithdrawalAmount, MemberBankCard memberBankCard, Date date, Integer tradeDetailId) {
        MemberWithdraws memberWithdraws = new MemberWithdraws();
        memberWithdraws.setMemberId(memberWithdrawsVo.getMemberId());
        memberWithdraws.setBeauticianId(storeBeautician.getId());
        memberWithdraws.setMemberRealName(memberRealNameAuth.getRealName());
        memberWithdraws.setMemberPhone(member.getRegisterPhone());
        memberWithdraws.setBelongStoreId(storeBeautician.getStoreId());
        memberWithdraws.setBelongStoreName(storeBeautician.getStoreName());
        memberWithdraws.setWithdrawAmount(memberWithdrawsVo.getWithdrawAmount());
        memberWithdraws.setTaxRate(Byte.parseByte(String.valueOf(commissionSetting.getCommissionRate())));
        memberWithdraws.setTaxation(taxation);
        memberWithdraws.setActualAmount(actualWithdrawalAmount);
        memberWithdraws.setBankCardId(memberBankCard.getId());
        memberWithdraws.setBankCardNo(memberBankCard.getBankcard());
        memberWithdraws.setPlayAmountStatus(false);
        memberWithdraws.setAddTime(date);
        memberWithdraws.setExpectAmountTime(getNextTuesday(date));
        memberWithdraws.setTradeDetailId(tradeDetailId);
        this.memberWithdrawsFeign.insert(memberWithdraws);
    }

    @Override
    public ResponseMessage withdrawalsByBeauticianV110(WithdrawsVo memberWithdrawsVo) {
        //第一步：根据会员id来查询会员是否实名制认证
        MemberRealNameAuth memberRealNameAuth = this.withdrawalsByMemberRealName(memberWithdrawsVo.getMemberId());
        //第二步：判断提现金额是否足够
        this.withdrawalsBySettlementAmount(memberWithdrawsVo.getBeauticianId(), memberWithdrawsVo.getWithdrawAmount());
        //第三步：查询单前手续费百分比
        CommissionSetting commissionSetting = this.commissionSettingService.selectByCommissionCode(CommissionEnum.MRSTISXF.getType());
        if (null == commissionSetting) {
            throw new ServerException(FinancialConstant.Query.DUPLICATE_NUMBER, FinancialConstant.Query.NO_COMMISSION);
        }
        //手续费税率
        double commissionRate = commissionSetting.getCommissionRate() / 100D;
        //提现金额的手续费
        Integer taxation = doubleToInt(memberWithdrawsVo.getWithdrawAmount() * commissionRate);
        //计算实际提现金额
        Integer actualWithdrawalAmount = memberWithdrawsVo.getWithdrawAmount() - doubleToInt(memberWithdrawsVo.getWithdrawAmount() * commissionRate);
        //第四步：根据银行卡id来进行查询会员银行卡信息
        MemberBankCard memberBankCard = this.memberBankCardFeign.queryById(memberWithdrawsVo.getBankCardId());
        //第五步：根据会员id来获取会员手机号码
        Member member = this.memberFeign.queryById(memberWithdrawsVo.getMemberId());
        //第六步：根据会员id来获取会员所属门店信息
        StoreBeautician storeBeautician = new StoreBeautician();
        storeBeautician.setMemberId(memberWithdrawsVo.getMemberId());
        storeBeautician = this.storeBeauticianFeign.queryByMemberId(storeBeautician).getData();
        if (storeBeautician == null) {
            throw new ServerException(FinancialConstant.Query.DUPLICATE_NUMBER, FinancialConstant.Query.THE_BEAUTICIAN_USER_WAS_NOT_FOUND);
        }
        Date date = new Date();
        // 保存美容师流水表
        Integer tradeDetailId = this.saveBeauticianTradeDetail(storeBeautician, memberRealNameAuth, taxation, actualWithdrawalAmount, member, memberWithdrawsVo, memberBankCard, date);
        // 保存美容师提现表
        this.saveMemberWithdraws(memberWithdrawsVo, storeBeautician, memberRealNameAuth, member, commissionSetting, taxation, actualWithdrawalAmount, memberBankCard, date, tradeDetailId);
        return new ResponseMessage();
    }

    @Override
    public ResponseMessage<BeauticianTradeDetailResultVo> selectVoByPrimaryKeyV110(Integer id) {

        BeauticianTradeDetailResultVo beauticianTradeDetailResultVo = new BeauticianTradeDetailResultVo();

        //获取流水数据
        BeauticianTradeDetail beauticianTradeDetail = this.selectByPrimaryKey(id);
        if (null == beauticianTradeDetail) {
            throw new ServerException(FinancialConstant.Query.DUPLICATE_NUMBER, FinancialConstant.Query.THE_BEAUTICIAN_RUNNING_WATER_IS_EMPTY);
        }
        BeanUtils.copyProperties(beauticianTradeDetail, beauticianTradeDetailResultVo);
        if (beauticianTradeDetail.getTradeType() != BeauticianTradeDetail.TRADE_TYPE_WITHDRAW) {

            //获取订单数据
            OrderBase orderBase = this.orderBaseFeign.queryByOrderNo(beauticianTradeDetail.getOrderNo());
            if (null == orderBase) {
                throw new ServerException(FinancialConstant.Query.DUPLICATE_NUMBER, FinancialConstant.Query.THE_ORDER_BASE_IS_EMPTY);
            }
            BeanUtils.copyProperties(orderBase, beauticianTradeDetailResultVo);

            //查询项目类型
            ResponseMessage<OrderProduct> responseMessage = this.orderProductFeign.queryByOrderNo(beauticianTradeDetail.getOrderNo());
            if (ResponseUtil.isFail(responseMessage)) {
                return (ResponseMessage) responseMessage;
            }
            ResponseMessage<Product> responseMessage1 = this.productFeign.findById(responseMessage.getData().getProductId());
            if (ResponseUtil.isFail(responseMessage1)) {
                return (ResponseMessage) responseMessage1;
            }
            beauticianTradeDetailResultVo.setProductType(responseMessage1.getData().getProductType());

        }
        return new ResponseMessage<>(beauticianTradeDetailResultVo);
    }


    private static int doubleToInt(double doub) {
        int amount = 0;
        NumberFormat nf = new DecimalFormat("#");
        amount = Integer.parseInt(nf.format(doub));
        return amount;
    }


    public static Date getNextTuesday(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.WEEK_OF_YEAR, 1);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
        return cal.getTime();
    }
}