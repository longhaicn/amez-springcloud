package com.union.aimei.common.feign.app.member.hystrix;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.member.MemberRealNameAuthFeign;
import com.union.aimei.common.model.member.MemberRealNameAuth;
import com.union.aimei.common.vo.member.IDNumberAuthVo;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
@Component(value = "app-MemberRealNameAuthFeign")
public class MemberRealNameAuthApiHystrix implements MemberRealNameAuthFeign {

       /**
        * 前端分页查询会员卡实名认证表
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param memberRealNameAuth 查询条件
        * @return 
        */
       @Override
       public PageInfo<MemberRealNameAuth> findByPageForFront(Integer pageNo, Integer pageSize, MemberRealNameAuth memberRealNameAuth) {
              return null;
       }

       @Override
       public MemberRealNameAuth queryByMemberId(MemberRealNameAuth memberRealNameAuth) {
              return null;
       }

       @Override
       public int authIDNumber(IDNumberAuthVo idNumberAuthVo) {
              return 0;
       }

       /**
        * 添加会员卡实名认证表
        * @param memberRealNameAuth
        * @return
        */
       @Override
       public int insert(MemberRealNameAuth memberRealNameAuth) {
              return 0;
       }

       @Override
       public ResponseMessage addObj(MemberRealNameAuth memberRealNameAuth) {
              return null;
       }

       /**
        * 删除会员卡实名认证表
        * @param id
        * @return
        */
       @Override
       public int deleteById(int id) {
              return 0;
       }

       /** 
        * 修改会员卡实名认证表
        * @param memberRealNameAuth
        * @return
        */
       @Override
       public int edit(MemberRealNameAuth memberRealNameAuth) {
              return 0;
       }

       /**
        * 根据ID查询
        * @param id
        * @returnmemberRealNameAuth
        */
       @Override
       public MemberRealNameAuth queryById(int id) {
              return null;
       }
}