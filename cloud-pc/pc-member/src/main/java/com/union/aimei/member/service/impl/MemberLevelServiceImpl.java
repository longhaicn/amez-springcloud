package com.union.aimei.member.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.member.MemberLevel;
import com.union.aimei.member.service.MemberLevelService;
import com.union.aimei.member.mapper.MemberLevelMapper;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
@Service("memberLevelService")
public class MemberLevelServiceImpl implements MemberLevelService {
       @Resource
       private MemberLevelMapper memberLevelMapper;

       /**
        * 前端分页查询会员级别
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param memberLevel 查询条件
        * @return 
        */
       @Override
       public PageInfo<MemberLevel> findByPageForFront(Integer pageNo, Integer pageSize, MemberLevel memberLevel) {
              PageHelper.startPage(pageNo,pageSize);
              List<MemberLevel> list = this.memberLevelMapper.selectListByConditions(memberLevel);
              PageInfo<MemberLevel> page = new PageInfo<>(list);
              return page;
       }

       /**
        * 添加会员级别
        * @param memberLevel
        * @return
        */
       @Override
       public int addObj(MemberLevel t) {
              return this.memberLevelMapper.insertSelective(t);
       }

       /**
        * 删除会员级别
        * @param id
        * @return
        */
       @Override
       public int deleteObjById(int id) {
              return this.memberLevelMapper.deleteByPrimaryKey(id);
       }

       /** 
        * 修改会员级别
        * @param memberLevel
        * @return
        */
       @Override
       public int modifyObj(MemberLevel t) {
              return this.memberLevelMapper.updateByPrimaryKeySelective(t);
       }

       /**
        * 根据ID查询
        * @param id
        * @returnmemberLevel
        */
       @Override
       public MemberLevel queryObjById(int id) {
              MemberLevel model=this.memberLevelMapper.selectByPrimaryKey(id);
              return model;
       }
}