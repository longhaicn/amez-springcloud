package com.union.aimei.member.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.member.MemberCardTradeRecode;
import com.union.common.utils.base.SpringCloudBaseService;

/**
 * @author GaoWei
 * @describe 
 * @time 2017/12/19,10:50
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
        * 根据订单号码查询预交易记录
        * @param orderNo
        * @return
        */
       MemberCardTradeRecode queryByOrderNo(String orderNo);
}