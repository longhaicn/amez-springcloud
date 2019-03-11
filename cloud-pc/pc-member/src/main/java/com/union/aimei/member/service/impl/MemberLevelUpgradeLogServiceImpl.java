package com.union.aimei.member.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.member.mapper.MemberLevelUpgradeLogMapper;
import com.union.aimei.member.service.MemberLevelUpgradeLogService;
import com.union.aimei.common.model.member.MemberLevelUpgradeLog;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
@Service("memberLevelUpgradeLogService")
public class MemberLevelUpgradeLogServiceImpl implements MemberLevelUpgradeLogService {
       @Resource
       private MemberLevelUpgradeLogMapper memberLevelUpgradeLogMapper;

       /**
        * 前端分页查询会员成长值记录
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param memberLevelUpgradeLog 查询条件
        * @return 
        */
       @Override
       public PageInfo<MemberLevelUpgradeLog> findByPageForFront(Integer pageNo, Integer pageSize, MemberLevelUpgradeLog memberLevelUpgradeLog) {
              PageHelper.startPage(pageNo,pageSize);
              List<MemberLevelUpgradeLog> list = this.memberLevelUpgradeLogMapper.selectListByConditions(memberLevelUpgradeLog);
              PageInfo<MemberLevelUpgradeLog> page = new PageInfo<>(list);
              return page;
       }

       /**
        * 添加会员成长值记录
        * @param memberLevelUpgradeLog
        * @return
        */
       @Override
       public int addObj(MemberLevelUpgradeLog t) {
              return this.memberLevelUpgradeLogMapper.insertSelective(t);
       }

       /**
        * 删除会员成长值记录
        * @param id
        * @return
        */
       @Override
       public int deleteObjById(int id) {
              return this.memberLevelUpgradeLogMapper.deleteByPrimaryKey(id);
       }

       /** 
        * 修改会员成长值记录
        * @param memberLevelUpgradeLog
        * @return
        */
       @Override
       public int modifyObj(MemberLevelUpgradeLog t) {
              return this.memberLevelUpgradeLogMapper.updateByPrimaryKeySelective(t);
       }

       /**
        * 根据ID查询
        * @param id
        * @returnmemberLevelUpgradeLog
        */
       @Override
       public MemberLevelUpgradeLog queryObjById(int id) {
              MemberLevelUpgradeLog model=this.memberLevelUpgradeLogMapper.selectByPrimaryKey(id);
              return model;
       }
}