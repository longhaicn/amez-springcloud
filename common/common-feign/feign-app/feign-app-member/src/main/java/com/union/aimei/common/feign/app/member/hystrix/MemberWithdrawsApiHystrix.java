package com.union.aimei.common.feign.app.member.hystrix;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.member.MemberWithdrawsFeign;
import com.union.aimei.common.model.member.MemberWithdraws;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
@Component(value = "app-MemberWithdrawsFeign")
public class MemberWithdrawsApiHystrix implements MemberWithdrawsFeign {

       /**
        * 前端分页查询会员提现申请表
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param memberWithdraws 查询条件
        * @return 
        */
       @Override
       public PageInfo<MemberWithdraws> findByPageForFront(Integer pageNo, Integer pageSize, MemberWithdraws memberWithdraws) {
              return null;
       }

       /**
        * 添加会员提现申请表
        * @param memberWithdraws
        * @return
        */
       @Override
       public int insert(MemberWithdraws memberWithdraws) {
              return 0;
       }

       @Override
       public ResponseMessage<MemberWithdraws> insertRecord(MemberWithdraws memberWithdraws) {
              return null;
       }

       /**
        * 删除会员提现申请表
        * @param id
        * @return
        */
       @Override
       public int deleteById(int id) {
              return 0;
       }

       /** 
        * 修改会员提现申请表
        * @param memberWithdraws
        * @return
        */
       @Override
       public int edit(MemberWithdraws memberWithdraws) {
              return 0;
       }

       /**
        * 根据ID查询
        * @param id
        * @returnmemberWithdraws
        */
       @Override
       public MemberWithdraws queryById(int id) {
              return null;
       }
}