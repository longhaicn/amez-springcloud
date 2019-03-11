package com.union.aimei.member.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.member.MemberCard;
import com.union.aimei.common.vo.member.BuyMemberCardVo;
import com.union.aimei.common.vo.member.MemberCardDetailsVo;
import com.union.aimei.common.vo.member.SubmitMemberCard;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.base.SpringCloudBaseService;

/**
 * @author GaoWei
 * @describe 
 * @time 2017/12/19,10:47
*/
public interface MemberCardService extends SpringCloudBaseService<MemberCard> {
       /**
        * 前端分页查询会员卡
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param memberCard 查询条件
        * @return 
        */
       PageInfo<MemberCard> findByPageForFront(Integer pageNo, Integer pageSize, MemberCard memberCard);


    /**
     * 保存会员卡(包含会员卡使用门店范围，适用服务)
     * @param submitMemberCard
     * @return
     */
    int insert(SubmitMemberCard submitMemberCard);

    /**
     * 查询会员卡详情
     * @param memberId
     * @param cardId
     * @return
     */
    ResponseMessage queryDetailsByCardId(Integer memberId,Integer cardId);

    /**
     * 查询购买会员卡列表
     * @param pageNo
     * @param pageSize
     * @param brandId
     * @param storeId
     * @return
     */
    PageInfo<BuyMemberCardVo> queryBuyCardPage(Integer pageNo, Integer pageSize, Integer brandId, Integer storeId);

    /**
     * 根据会员卡id来查询会员卡详情信息
     * @param id
     * @return
     */
    ResponseMessage queryDetailById(Integer id);

    /**
     * 查询会员卡详情
     * @param memberCardDetailsVo
     * @return
     */
    ResponseMessage queryDetailsById(MemberCardDetailsVo memberCardDetailsVo);
}