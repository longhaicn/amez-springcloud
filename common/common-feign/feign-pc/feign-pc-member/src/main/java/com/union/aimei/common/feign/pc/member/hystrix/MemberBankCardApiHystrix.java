package com.union.aimei.common.feign.pc.member.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.member.MemberBankCardFeign;
import com.union.aimei.common.model.member.MemberBankCard;
import org.springframework.stereotype.Component;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
@Component(value = "pc-MemberBankCardFeign")
public class MemberBankCardApiHystrix implements MemberBankCardFeign {

       /**
        * 前端分页查询会员银行卡表
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param memberBankCard 查询条件
        * @return 
        */
       @Override
       public PageInfo<MemberBankCard> findByPageForFront(Integer pageNo, Integer pageSize, MemberBankCard memberBankCard) {
              return null;
       }

       /**
        * 添加会员银行卡表
        * @param memberBankCard
        * @return
        */
       @Override
       public int insert(MemberBankCard memberBankCard) {
              return 0;
       }

       /**
        * 删除会员银行卡表
        * @param id
        * @return
        */
       @Override
       public int deleteById(int id) {
              return 0;
       }

       /** 
        * 修改会员银行卡表
        * @param memberBankCard
        * @return
        */
       @Override
       public int edit(MemberBankCard memberBankCard) {
              return 0;
       }

       /**
        * 根据ID查询
        * @param id
        * @returnmemberBankCard
        */
       @Override
       public MemberBankCard queryById(int id) {
              return null;
       }
}