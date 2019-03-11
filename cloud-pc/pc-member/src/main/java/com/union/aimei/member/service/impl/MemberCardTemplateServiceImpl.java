package com.union.aimei.member.service.impl;

import com.union.aimei.common.model.member.MemberCardTemplate;
import com.union.aimei.member.mapper.MemberCardTemplateMapper;
import com.union.aimei.member.service.MemberCardTemplateService;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;

import com.union.aimei.common.vo.member.MemberCardTemplateVo;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
@Service("memberCardTemplateService")
public class MemberCardTemplateServiceImpl implements MemberCardTemplateService {
       @Resource
       private MemberCardTemplateMapper memberCardTemplateMapper;

       /**
        * 前端分页查询会员卡卡面模板表
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param memberCardTemplate 查询条件
        * @return 
        */
       @Override
       public PageInfo<MemberCardTemplate> findByPageForFront(Integer pageNo, Integer pageSize, MemberCardTemplate memberCardTemplate) {
              PageHelper.startPage(pageNo,pageSize);
              List<MemberCardTemplate> list = this.memberCardTemplateMapper.selectListByConditions(memberCardTemplate);
              PageInfo<MemberCardTemplate> page = new PageInfo<>(list);
              return page;
       }


       /**
        * 批量添加会员卡卡面模板表
        * @param memberCardTemplateVo
        * @return
        */
       @Override
       public void insertByBatch(MemberCardTemplateVo memberCardTemplateVo) {
              MemberCardTemplate memberCardTemplate = new MemberCardTemplate();
              memberCardTemplate.setParentGroupCount(memberCardTemplateVo.getParentGroupCount());
              memberCardTemplate.setId(memberCardTemplateVo.getParentGroupId());
              //更新主题图片的条数
              this.memberCardTemplateMapper.updateByPrimaryKeySelective(memberCardTemplate);
              List<MemberCardTemplate> list = new ArrayList<>(10);
              if(memberCardTemplateVo.getBgImgList().size() > 0 ){
                     for(int i = 0;i<memberCardTemplateVo.getBgImgList().size();i++){
                            memberCardTemplate = new MemberCardTemplate();
                            memberCardTemplate.setParentGroupId(memberCardTemplateVo.getParentGroupId());
                            memberCardTemplate.setBgImgUrl(memberCardTemplateVo.getBgImgList().get(i));
                            list.add(memberCardTemplate);
                     }
              }
              this.memberCardTemplateMapper.insertByBatch(list);
       }

       /**
        * 添加会员卡卡面模板表
        * @param t
        * @return
        */
       @Override
       public int addObj(MemberCardTemplate t) {
              return this.memberCardTemplateMapper.insertSelective(t);
       }

       /**
        * 删除会员卡卡面模板表
        * @param id
        * @return
        */
       @Override
       public int deleteObjById(int id) {
              return this.memberCardTemplateMapper.deleteByPrimaryKey(id);
       }

       /**
        * 根据groupId来删除会员卡模板图片
        * @param id
        * @return
        */
       @Override
       public int deleteByGroupId(int id) {
              return this.memberCardTemplateMapper.deleteByGroupId(id);
       }

       /** 
        * 修改会员卡卡面模板表
        * @param t
        * @return
        */
       @Override
       public int modifyObj(MemberCardTemplate t) {
              return this.memberCardTemplateMapper.updateByPrimaryKeySelective(t);
       }

       /**
        * 根据ID查询
        * @param id
        * @returnmemberCardTemplate
        */
       @Override
       public MemberCardTemplate queryObjById(int id) {
              MemberCardTemplate model=this.memberCardTemplateMapper.selectByPrimaryKey(id);
              return model;
       }
}