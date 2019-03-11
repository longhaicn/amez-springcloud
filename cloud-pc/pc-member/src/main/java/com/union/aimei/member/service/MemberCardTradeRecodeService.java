package com.union.aimei.member.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.member.MemberCardTradeRecode;
import com.union.aimei.common.vo.member.MemberAndMemberCardVo;
import com.union.aimei.common.vo.member.MemberCardSaleRecodeVo;
import com.union.common.utils.base.SpringCloudBaseService;

/**
 * @author GaoWei
 * @describe 
 * @time 2018/1/9,14:44
*/
public interface MemberCardTradeRecodeService extends SpringCloudBaseService<MemberCardTradeRecode> {
       /**
        * 前端分页查询会员卡交易记录
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param memberCardTradeRecode 查询条件
        * @return 
        */
       PageInfo<MemberCardTradeRecode> findByPageForFront(Integer pageNo, Integer pageSize, MemberCardTradeRecode memberCardTradeRecode);

       /**
        * 后台根据条件查询售卡记录汇总
        * @param pageNo
        * @param pageSize
        * @param memberCardSaleRecodeVo
        * @return
        */
       public PageInfo<MemberCardSaleRecodeVo> queryListCardSaleRecode(Integer pageNo, Integer pageSize, MemberCardSaleRecodeVo memberCardSaleRecodeVo);

       /**
        * 查询售卡记录详情
        * @param id
        * @return
        */
       public MemberCardSaleRecodeVo queryCardSaleDetailById(Integer id);

       /**
        * 根据时间查询会员卡充值订单数量
        * @param memberAndMemberCardVo
        * @return
        */
       Integer queryRechargeCount(MemberAndMemberCardVo memberAndMemberCardVo);

       /**
        * 根据时间查询会员卡售卡订单数量
        * @param memberAndMemberCardVo
        * @return
        */
       Integer querySaleCardCount(MemberAndMemberCardVo memberAndMemberCardVo);
}