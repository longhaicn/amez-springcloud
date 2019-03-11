package com.union.aimei.member.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.member.MemberRealNameAuth;
import com.union.aimei.common.vo.member.IDNumberAuthVo;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.base.SpringCloudBaseService;

/**
 * @author GaoWei
 * @describe 
 * @time 2018/2/8,17:31
*/
public interface MemberRealNameAuthService extends SpringCloudBaseService<MemberRealNameAuth> {
       /**
        * 前端分页查询会员卡实名认证表
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param memberRealNameAuth 查询条件
        * @return 
        */
       PageInfo<MemberRealNameAuth> findByPageForFront(Integer pageNo, Integer pageSize, MemberRealNameAuth memberRealNameAuth);

       /**
        * 根据会员id来查询会员是否进行实名验证
        * @param memberRealNameAuth
        * @return
        */
       MemberRealNameAuth queryByMemberId(MemberRealNameAuth memberRealNameAuth);

       /**
        * 会员第三方实名认证
        * @param idNumberAuthVo
        * @return
        */
       int authIDNumber(IDNumberAuthVo idNumberAuthVo);

       /**
        * 添加会员实名认证
        * @param memberRealNameAuth
        * @return
        */
       ResponseMessage insert(MemberRealNameAuth memberRealNameAuth);
}