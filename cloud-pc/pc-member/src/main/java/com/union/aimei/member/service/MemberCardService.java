package com.union.aimei.member.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.vo.member.*;
import com.union.aimei.common.model.member.MemberCard;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.base.SpringCloudBaseService;


/**
 * @author GaoWei
 * @describe 
 * @time 2018/1/9,14:44
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
        * 发布会员卡
        * @param releaseMemberCardVo
        * @return
        */
       ResponseMessage releaseMemberCard(ReleaseMemberCardVo releaseMemberCardVo);


        /**
         * 查询会员卡详情
         * @param id
         * @return
        */
        ResponseMessage queryCardDetail(Integer id);

         /**
          * 编辑会员卡信息
          * @param editMemberCardVo
          * @return
         */
         ResponseMessage editMemberCardInfo(EditMemberCardVo editMemberCardVo);

    /**
     * 查询会员和会员卡新增统计
     * @param memberAndMemberCardVo
     * @return
     */
    Integer queryMemberCardCount(MemberAndMemberCardVo memberAndMemberCardVo);

}