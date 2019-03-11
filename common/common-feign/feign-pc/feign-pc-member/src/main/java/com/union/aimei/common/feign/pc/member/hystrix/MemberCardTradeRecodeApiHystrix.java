package com.union.aimei.common.feign.pc.member.hystrix;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.member.MemberCardTradeRecodeFeign;
import com.union.aimei.common.model.member.MemberCardTradeRecode;
import com.union.aimei.common.vo.member.MemberAndMemberCardVo;
import com.union.aimei.common.vo.member.MemberCardSaleRecodeVo;
import org.springframework.stereotype.Component;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
@Component(value = "pc-MemberCardTradeRecodeFeign")
public class MemberCardTradeRecodeApiHystrix implements MemberCardTradeRecodeFeign {

       /**
        * 前端分页查询会员卡交易记录
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param memberCardTradeRecode 查询条件
        * @return 
        */
       @Override
       public PageInfo<MemberCardTradeRecode> findByPageForFront(Integer pageNo, Integer pageSize, MemberCardTradeRecode memberCardTradeRecode) {
              return null;
       }

       @Override
       public PageInfo<MemberCardSaleRecodeVo> queryListCardSaleRecode(Integer pageNo, Integer pageSize, MemberCardSaleRecodeVo memberCardSaleRecodeVo) {
              return null;
       }

       @Override
       public MemberCardSaleRecodeVo queryCardSaleDetailById(int id) {
              return null;
       }

       @Override
       public Integer queryRechargeCount(MemberAndMemberCardVo memberAndMemberCardVo) {
              return null;
       }

       @Override
       public Integer querySaleCardCount(MemberAndMemberCardVo memberAndMemberCardVo) {
              return null;
       }

       /**
        * 添加会员卡交易记录
        * @param memberCardTradeRecode
        * @return
        */
       @Override
       public int insert(MemberCardTradeRecode memberCardTradeRecode) {
              return 0;
       }

       /**
        * 删除会员卡交易记录
        * @param id
        * @return
        */
       @Override
       public int deleteById(int id) {
              return 0;
       }

       /** 
        * 修改会员卡交易记录
        * @param memberCardTradeRecode
        * @return
        */
       @Override
       public int edit(MemberCardTradeRecode memberCardTradeRecode) {
              return 0;
       }

       /**
        * 根据ID查询
        * @param id
        * @returnmemberCardTradeRecode
        */
       @Override
       public MemberCardTradeRecode queryById(int id) {
              return null;
       }
}