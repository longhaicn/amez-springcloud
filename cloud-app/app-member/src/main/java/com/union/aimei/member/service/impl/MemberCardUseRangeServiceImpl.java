package com.union.aimei.member.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.member.MemberCardUseRange;
import com.union.aimei.member.mapper.MemberCardUseRangeMapper;
import com.union.aimei.member.service.MemberCardUseRangeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
@Service("memberCardUseRangeService")
public class MemberCardUseRangeServiceImpl implements MemberCardUseRangeService {
       @Resource
       private MemberCardUseRangeMapper memberCardUseRangeMapper;

       /**
        * 前端分页查询会员卡使用范围
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param memberCardUseRange 查询条件
        * @return 
        */
       @Override
       public PageInfo<MemberCardUseRange> findByPageForFront(Integer pageNo, Integer pageSize, MemberCardUseRange memberCardUseRange) {
              PageHelper.startPage(pageNo,pageSize);
              List<MemberCardUseRange> list = this.memberCardUseRangeMapper.selectListByConditions(memberCardUseRange);
              PageInfo<MemberCardUseRange> page = new PageInfo<>(list);
              return page;
       }

       /**
        * 添加会员卡使用范围
        * @param
        * @return
        */
       @Override
       public int addObj(MemberCardUseRange t) {
              return this.memberCardUseRangeMapper.insertSelective(t);
       }

       /**
        * 删除会员卡使用范围
        * @param id
        * @return
        */
       @Override
       public int deleteObjById(int id) {
              return this.memberCardUseRangeMapper.deleteByPrimaryKey(id);
       }

       /** 
        * 修改会员卡使用范围
        * @param
        * @return
        */
       @Override
       public int modifyObj(MemberCardUseRange t) {
              return this.memberCardUseRangeMapper.updateByPrimaryKeySelective(t);
       }

       /**
        * 根据ID查询
        * @param id
        * @returnmemberCardUseRange
        */
       @Override
       public MemberCardUseRange queryObjById(int id) {
              MemberCardUseRange model=this.memberCardUseRangeMapper.selectByPrimaryKey(id);
              return model;
       }

}