package com.union.aimei.member.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.member.MemberCardUseProduct;
import com.union.aimei.common.model.member.MemberCardUseRange;
import com.union.aimei.member.mapper.MemberCardTradeRecodeMapper;
import com.union.aimei.common.model.member.MemberCardTradeRecode;
import com.union.aimei.member.mapper.MemberCardUseProductMapper;
import com.union.aimei.member.mapper.MemberCardUseRangeMapper;
import com.union.aimei.member.service.MemberCardTradeRecodeService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.annotation.Resource;

import com.union.aimei.member.util.DateUtilDay;
import com.union.aimei.common.vo.member.MemberAndMemberCardVo;
import com.union.aimei.common.vo.member.MemberCardSaleRecodeVo;
import com.union.common.utils.CollectionUtils;
import org.springframework.stereotype.Service;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
@Service("memberCardTradeRecodeService")
public class MemberCardTradeRecodeServiceImpl implements MemberCardTradeRecodeService {
       @Resource
       private MemberCardTradeRecodeMapper memberCardTradeRecodeMapper;

       @Resource
       private MemberCardUseRangeMapper memberCardUseRangeMapper;

       @Resource
       private MemberCardUseProductMapper memberCardUseProductMapper;

       /**
        * 前端分页查询会员卡交易记录
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param memberCardTradeRecode 查询条件
        * @return 
        */
       @Override
       public PageInfo<MemberCardTradeRecode> findByPageForFront(Integer pageNo, Integer pageSize, MemberCardTradeRecode memberCardTradeRecode) {
              PageHelper.startPage(pageNo,pageSize);
              List<MemberCardTradeRecode> list = this.memberCardTradeRecodeMapper.selectListByConditions(memberCardTradeRecode);
              PageInfo<MemberCardTradeRecode> page = new PageInfo<>(list);
              return page;
       }

       @Override
       public PageInfo<MemberCardSaleRecodeVo> queryListCardSaleRecode(Integer pageNo, Integer pageSize, MemberCardSaleRecodeVo memberCardSaleRecodeVo) {
              PageHelper.startPage(pageNo,pageSize);
              List<MemberCardSaleRecodeVo> list = this.memberCardTradeRecodeMapper.queryListCardSaleRecode(memberCardSaleRecodeVo);
              PageInfo<MemberCardSaleRecodeVo> page = new PageInfo<>(list);
              return page;
       }

       @Override
       public MemberCardSaleRecodeVo queryCardSaleDetailById(Integer id) {
              MemberCardSaleRecodeVo memberCardSaleRecodeVo = this.memberCardTradeRecodeMapper.queryCardSaleDetailById(id);
              if(memberCardSaleRecodeVo.getMemberCardId() != null){
                     //根据会员卡id来查询会员卡适用的门店
                     MemberCardUseRange memberCardUseRange = new MemberCardUseRange();
                     memberCardUseRange.setCardId(memberCardSaleRecodeVo.getMemberCardId());
                     List<MemberCardUseRange> rangeList =  this.memberCardUseRangeMapper.selectListByConditions(memberCardUseRange);
                     if(!CollectionUtils.isEmpty(rangeList)){
                            List<Integer> store = new ArrayList<>(10);
                            for(MemberCardUseRange number : rangeList){
                                store.add(number.getStoreId());
                            }
                            memberCardSaleRecodeVo.setUseStoreList(store);
                            memberCardSaleRecodeVo.setUseStoreListSize(store.size());
                     }
                     //查询会员卡适用的服务
                     MemberCardUseProduct memberCardUseProduct = new MemberCardUseProduct();
                     memberCardUseProduct.setCardId(memberCardSaleRecodeVo.getMemberCardId());
                     List<MemberCardUseProduct> serviceList =  this.memberCardUseProductMapper.selectListByConditions(memberCardUseProduct);
                     if(!CollectionUtils.isEmpty(serviceList)){
                         List<Integer> product = new ArrayList<>(10);
                         for(MemberCardUseProduct pro : serviceList){
                             product.add(pro.getProductId());
                         }
                         memberCardSaleRecodeVo.setUseServiceList(product);
                         memberCardSaleRecodeVo.setUseServiceListSize(product.size());
                     }
              }
              return memberCardSaleRecodeVo;
       }

       @Override
       public Integer queryRechargeCount(MemberAndMemberCardVo memberAndMemberCardVo) {
              Calendar now = Calendar.getInstance();
              memberAndMemberCardVo.setEndTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(now.getTime()));
              memberAndMemberCardVo.setStartTime(DateUtilDay.getDate(now,memberAndMemberCardVo.getDayCount()));
              memberAndMemberCardVo.setConsType(0);
              return this.memberCardTradeRecodeMapper.queryRechargeAndSaleCardCount(memberAndMemberCardVo);
       }

       @Override
       public Integer querySaleCardCount(MemberAndMemberCardVo memberAndMemberCardVo) {
              Calendar now = Calendar.getInstance();
              memberAndMemberCardVo.setEndTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(now.getTime()));
              memberAndMemberCardVo.setStartTime(DateUtilDay.getDate(now,memberAndMemberCardVo.getDayCount()));
              memberAndMemberCardVo.setConsType(1);
              return this.memberCardTradeRecodeMapper.queryRechargeAndSaleCardCount(memberAndMemberCardVo);
       }


       /**
        * 添加会员卡交易记录
        * @param t
        * @return
        */
       @Override
       public int addObj(MemberCardTradeRecode t) {
              return this.memberCardTradeRecodeMapper.insertSelective(t);
       }

       /**
        * 删除会员卡交易记录
        * @param id
        * @return
        */
       @Override
       public int deleteObjById(int id) {
              return this.memberCardTradeRecodeMapper.deleteByPrimaryKey(id);
       }

       /** 
        * 修改会员卡交易记录
        * @param t
        * @return
        */
       @Override
       public int modifyObj(MemberCardTradeRecode t) {
              return this.memberCardTradeRecodeMapper.updateByPrimaryKeySelective(t);
       }

       /**
        * 根据ID查询
        * @param id
        * @returnmemberCardTradeRecode
        */
       @Override
       public MemberCardTradeRecode queryObjById(int id) {
              MemberCardTradeRecode model=this.memberCardTradeRecodeMapper.selectByPrimaryKey(id);
              return model;
       }
}