package com.union.aimei.member.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.member.MemberCardUseProduct;
import com.union.aimei.common.vo.member.NewProductGroundVo;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.base.SpringCloudBaseService;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
public interface MemberCardUseProductService extends SpringCloudBaseService<MemberCardUseProduct> {
       /**
        * 前端分页查询会员卡适用服务表
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param memberCardUseProduct 查询条件
        * @return 
        */
       PageInfo<MemberCardUseProduct> findByPageForFront(Integer pageNo, Integer pageSize, MemberCardUseProduct memberCardUseProduct);

       /**
        * 当品牌发布得商品在品牌所属门店上架，添加会员卡支付
        * @param newProductGroundVo
        * @return
        */
       ResponseMessage insertMemberCardByProductId(NewProductGroundVo newProductGroundVo);
}