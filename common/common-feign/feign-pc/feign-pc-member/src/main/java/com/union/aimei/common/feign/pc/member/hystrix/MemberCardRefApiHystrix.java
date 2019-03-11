package com.union.aimei.common.feign.pc.member.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.member.MemberCardRefFeign;
import com.union.aimei.common.model.member.MemberCardRef;
import org.springframework.stereotype.Component;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
@Component(value = "pc-MemberCardRefFeign")
public class MemberCardRefApiHystrix implements MemberCardRefFeign {

       /**
        * 前端分页查询用户会员卡表
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param memberCardRef 查询条件
        * @return 
        */
       @Override
       public PageInfo<MemberCardRef> findByPageForFront(Integer pageNo, Integer pageSize, MemberCardRef memberCardRef) {
              return null;
       }

       @Override
       public void setMemberCardUnEffective() {

       }

       @Override
       public void test() {

       }

       /**
        * 添加用户会员卡表
        * @param memberCardRef
        * @return
        */
       @Override
       public int insert(MemberCardRef memberCardRef) {
              return 0;
       }

       /**
        * 删除用户会员卡表
        * @param id
        * @return
        */
       @Override
       public int deleteById(int id) {
              return 0;
       }

       /** 
        * 修改用户会员卡表
        * @param memberCardRef
        * @return
        */
       @Override
       public int edit(MemberCardRef memberCardRef) {
              return 0;
       }

       /**
        * 根据ID查询
        * @param id
        * @returnmemberCardRef
        */
       @Override
       public MemberCardRef queryById(int id) {
              return null;
       }
}