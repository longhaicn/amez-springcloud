package com.union.aimei.common.feign.pc.member.hystrix;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.member.MemberCardUseProductFeign;
import com.union.aimei.common.model.member.MemberCardUseProduct;
import com.union.aimei.common.vo.member.NewProductGroundVo;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
@Component(value = "pc-MemberCardUseProductFeign")
public class MemberCardUseProductApiHystrix implements MemberCardUseProductFeign {

       /**
        * 前端分页查询会员卡适用服务表
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param memberCardUseProduct 查询条件
        * @return 
        */
       @Override
       public PageInfo<MemberCardUseProduct> findByPageForFront(Integer pageNo, Integer pageSize, MemberCardUseProduct memberCardUseProduct) {
              return null;
       }

       @Override
       public ResponseMessage insertMemberCardByProductId(NewProductGroundVo newProductGroundVo) {
              return null;
       }

       /**
        * 添加会员卡适用服务表
        * @param memberCardUseProduct
        * @return
        */
       @Override
       public int insert(MemberCardUseProduct memberCardUseProduct) {
              return 0;
       }

       /**
        * 删除会员卡适用服务表
        * @param id
        * @return
        */
       @Override
       public int deleteById(int id) {
              return 0;
       }

       /** 
        * 修改会员卡适用服务表
        * @param memberCardUseProduct
        * @return
        */
       @Override
       public int edit(MemberCardUseProduct memberCardUseProduct) {
              return 0;
       }

       /**
        * 根据ID查询
        * @param id
        * @returnmemberCardUseProduct
        */
       @Override
       public MemberCardUseProduct queryById(int id) {
              return null;
       }
}