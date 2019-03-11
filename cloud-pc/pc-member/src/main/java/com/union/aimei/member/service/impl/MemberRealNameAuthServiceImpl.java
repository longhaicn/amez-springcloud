package com.union.aimei.member.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.store.StoreBeauticianFeign;
import com.union.aimei.common.model.member.MemberRealNameAuth;
import com.union.aimei.member.mapper.MemberRealNameAuthMapper;
import com.union.aimei.member.service.MemberRealNameAuthService;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
@Service("memberRealNameAuthService")
public class MemberRealNameAuthServiceImpl implements MemberRealNameAuthService {
       @Resource
       private MemberRealNameAuthMapper memberRealNameAuthMapper;

       @Resource
       private StoreBeauticianFeign storeBeauticianFeign;


       /**
        * 前端分页查询会员卡实名认证表
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param memberRealNameAuth 查询条件
        * @return 
        */
       @Override
       public PageInfo<MemberRealNameAuth> findByPageForFront(Integer pageNo, Integer pageSize, MemberRealNameAuth memberRealNameAuth) {
              PageHelper.startPage(pageNo,pageSize);
              List<MemberRealNameAuth> list = this.memberRealNameAuthMapper.selectListByConditions(memberRealNameAuth);
              PageInfo<MemberRealNameAuth> page = new PageInfo<>(list);
              return page;
       }

       /**
        * 添加会员卡实名认证表
        * @param t
        * @return
        */
       @Override
       public int addObj(MemberRealNameAuth t) {
              return this.memberRealNameAuthMapper.insertSelective(t);
       }

       /**
        * 删除会员卡实名认证表
        * @param id
        * @return
        */
       @Override
       public int deleteObjById(int id) {
              return this.memberRealNameAuthMapper.deleteByPrimaryKey(id);
       }

       /** 
        * 修改会员卡实名认证表
        * @param t
        * @return
        */
       @Override
       public int modifyObj(MemberRealNameAuth t) {
              return this.memberRealNameAuthMapper.updateByPrimaryKeySelective(t);
       }

       /**
        * 根据ID查询
        * @param id
        * @returnmemberRealNameAuth
        */
       @Override
       public MemberRealNameAuth queryObjById(int id) {
              MemberRealNameAuth model=this.memberRealNameAuthMapper.selectByPrimaryKey(id);
              return model;
       }
}