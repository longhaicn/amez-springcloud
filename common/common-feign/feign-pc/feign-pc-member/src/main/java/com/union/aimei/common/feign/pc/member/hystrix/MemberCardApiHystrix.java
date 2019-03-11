package com.union.aimei.common.feign.pc.member.hystrix;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.member.MemberCardFeign;
import com.union.aimei.common.model.member.MemberCard;
import com.union.aimei.common.vo.member.EditMemberCardVo;
import com.union.aimei.common.vo.member.MemberAndMemberCardVo;
import com.union.aimei.common.vo.member.ReleaseMemberCardVo;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

/**
 * @author houji
 * @date 2018/8/13  11:46
 */
@Component(value = "pc-MemberCardFeign")
public class MemberCardApiHystrix implements MemberCardFeign {

       /**
        * 前端分页查询会员卡
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param memberCard 查询条件
        * @return 
        */
       @Override
       public PageInfo<MemberCard> findByPageForFront(Integer pageNo, Integer pageSize, MemberCard memberCard) {
              return null;
       }

       /**
        * 删除会员卡
        * @param id
        * @return
        */
       @Override
       public int deleteById(int id) {
              return 0;
       }

       /** 
        * 修改会员卡
        * @param memberCard
        * @return
        */
       @Override
       public int edit(MemberCard memberCard) {
              return 0;
       }

       /**
        * 根据ID查询
        * @param id
        * @returnmemberCard
        */
       @Override
       public MemberCard queryById(int id) {
              return null;
       }

       @Override
       public ResponseMessage queryMemberCardDetail(int id) {
              return HystrixResponse.invokeFail();
       }

       @Override
       public ResponseMessage releaseMemberCard(ReleaseMemberCardVo releaseMemberCardVo) {
              return HystrixResponse.invokeFail();
       }

       @Override
       public Integer queryMemberCardCount(MemberAndMemberCardVo memberAndMemberCardVo) {
              return null;
       }

       @Override
       public ResponseMessage editMemberCardInfo(EditMemberCardVo editMemberCardVo) {
              return HystrixResponse.invokeFail();
       }

}