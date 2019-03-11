package com.union.aimei.member.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.member.MemberLevelUpgrade;
import com.union.aimei.member.mapper.MemberLevelUpgradeMapper;
import com.union.aimei.member.service.MemberLevelUpgradeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
@Service("memberLevelUpgradeService")
public class MemberLevelUpgradeServiceImpl implements MemberLevelUpgradeService {
       @Resource
       private MemberLevelUpgradeMapper memberLevelUpgradeMapper;

       /**
        * 前端分页查询会员成长值规则设置
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param memberLevelUpgrade 查询条件
        * @return 
        */
       @Override
       public PageInfo<MemberLevelUpgrade> findByPageForFront(Integer pageNo, Integer pageSize, MemberLevelUpgrade memberLevelUpgrade) {
              PageHelper.startPage(pageNo,pageSize);
              List<MemberLevelUpgrade> list = this.memberLevelUpgradeMapper.selectListByConditions(memberLevelUpgrade);
              PageInfo<MemberLevelUpgrade> page = new PageInfo<>(list);
              return page;
       }

       /**
        * 添加会员成长值规则设置
        * @param
        * @return
        */
       @Override
       public int addObj(MemberLevelUpgrade t) {
              return this.memberLevelUpgradeMapper.insertSelective(t);
       }

       /**
        * 删除会员成长值规则设置
        * @param id
        * @return
        */
       @Override
       public int deleteObjById(int id) {
              return this.memberLevelUpgradeMapper.deleteByPrimaryKey(id);
       }

       /** 
        * 修改会员成长值规则设置
        * @param
        * @return
        */
       @Override
       public int modifyObj(MemberLevelUpgrade t) {
              return this.memberLevelUpgradeMapper.updateByPrimaryKeySelective(t);
       }

       /**
        * 根据ID查询
        * @param id
        * @returnmemberLevelUpgrade
        */
       @Override
       public MemberLevelUpgrade queryObjById(int id) {
              MemberLevelUpgrade model=this.memberLevelUpgradeMapper.selectByPrimaryKey(id);
              return model;
       }
}