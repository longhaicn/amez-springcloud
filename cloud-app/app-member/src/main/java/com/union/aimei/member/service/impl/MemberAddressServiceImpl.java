package com.union.aimei.member.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.member.MemberAddress;
import com.union.aimei.member.mapper.MemberAddressMapper;
import com.union.aimei.member.service.MemberAddressService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author houji
 * @date 2018/8/13  11:46
 */
@Service("memberAddressService")
public class MemberAddressServiceImpl implements MemberAddressService {
       @Resource
       private MemberAddressMapper memberAddressMapper;

       /**
        * 前端分页查询会员地址
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param memberAddress 查询条件
        * @return 
        */
       @Override
       public PageInfo<MemberAddress> findByPageForFront(Integer pageNo, Integer pageSize, MemberAddress memberAddress) {
              PageHelper.startPage(pageNo,pageSize);
              List<MemberAddress> list = this.memberAddressMapper.selectListByConditions(memberAddress);
              PageInfo<MemberAddress> page = new PageInfo<>(list);
              return page;
       }

       /**
        * 添加会员地址
        * @param
        * @return
        */
       @Override
       public int addObj(MemberAddress t) {
              return this.memberAddressMapper.insertSelective(t);
       }

       /**
        * 删除会员地址
        * @param id
        * @return
        */
       @Override
       public int deleteObjById(int id) {
              return this.memberAddressMapper.deleteByPrimaryKey(id);
       }

       /** 
        * 修改会员地址
        * @param
        * @return
        */
       @Override
       public int modifyObj(MemberAddress t) {
              return this.memberAddressMapper.updateByPrimaryKeySelective(t);
       }

       /**
        * 根据ID查询
        * @param id
        * @returnmemberAddress
        */
       @Override
       public MemberAddress queryObjById(int id) {
              MemberAddress model=this.memberAddressMapper.selectByPrimaryKey(id);
              return model;
       }

       /**
        * 设置默认地址
        * @param
        * @return
        */
       @Override
       @Transactional(rollbackFor = Exception.class)
       public int setDefalutAddress(MemberAddress memberAddress) {
           memberAddressMapper.updateMemberAddressIsDefault(memberAddress.getMemberId());
           memberAddressMapper.updateByPrimaryKeySelective(memberAddress);
           return 1;
       }
}