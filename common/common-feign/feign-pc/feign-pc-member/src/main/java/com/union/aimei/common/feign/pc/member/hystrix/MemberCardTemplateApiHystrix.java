package com.union.aimei.common.feign.pc.member.hystrix;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.member.MemberCardTemplateFeign;
import com.union.aimei.common.model.member.MemberCardTemplate;
import com.union.aimei.common.vo.member.MemberCardTemplateVo;
import org.springframework.stereotype.Component;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
@Component(value = "pc-MemberCardTemplateFeign")
public class MemberCardTemplateApiHystrix implements MemberCardTemplateFeign {

       /**
        * 前端分页查询会员卡卡面模板表
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param memberCardTemplate 查询条件
        * @return 
        */
       @Override
       public PageInfo<MemberCardTemplate> findByPageForFront(Integer pageNo, Integer pageSize, MemberCardTemplate memberCardTemplate) {
              return null;
       }

       @Override
       public void insertByBatch(MemberCardTemplateVo memberCardTemplateVo) {

       }

       /**
        * 添加会员卡卡面模板表
        * @param memberCardTemplate
        * @return
        */
       @Override
       public int insert(MemberCardTemplate memberCardTemplate) {
              return 0;
       }

       /**
        * 删除会员卡卡面模板表
        * @param id
        * @return
        */
       @Override
       public int deleteById(int id) {
              return 0;
       }

       @Override
       public int deleteByGroupId(int id) {
              return 0;
       }

       /** 
        * 修改会员卡卡面模板表
        * @param memberCardTemplate
        * @return
        */
       @Override
       public int edit(MemberCardTemplate memberCardTemplate) {
              return 0;
       }

       /**
        * 根据ID查询
        * @param id
        * @returnmemberCardTemplate
        */
       @Override
       public MemberCardTemplate queryById(int id) {
              return null;
       }
}