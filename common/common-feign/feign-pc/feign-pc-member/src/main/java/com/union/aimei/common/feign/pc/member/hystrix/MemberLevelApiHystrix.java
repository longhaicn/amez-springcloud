package com.union.aimei.common.feign.pc.member.hystrix;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.member.MemberLevelFeign;
import com.union.aimei.common.model.member.MemberLevel;
import org.springframework.stereotype.Component;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
@Component(value ="pc-MemberLevelFeign")
public class MemberLevelApiHystrix implements MemberLevelFeign {

       /**
        * 前端分页查询会员级别
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param memberLevel 查询条件
        * @return 
        */
       @Override
       public PageInfo<MemberLevel> findByPageForFront(Integer pageNo, Integer pageSize, MemberLevel memberLevel) {
              return null;
       }

       /**
        * 添加会员级别
        * @param memberLevel
        * @return
        */
       @Override
       public int insert(MemberLevel memberLevel) {
              return 0;
       }

       /**
        * 删除会员级别
        * @param id
        * @return
        */
       @Override
       public int deleteById(int id) {
              return 0;
       }

       /** 
        * 修改会员级别
        * @param memberLevel
        * @return
        */
       @Override
       public int edit(MemberLevel memberLevel) {
              return 0;
       }

       /**
        * 根据ID查询
        * @param id
        * @returnmemberLevel
        */
       @Override
       public MemberLevel queryById(int id) {
              return null;
       }
}