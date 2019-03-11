package com.union.aimei.member.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.member.MemberCardRef;
import com.union.aimei.member.mapper.MemberCardRefMapper;
import com.union.aimei.member.service.MemberCardRefService;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;

import com.union.common.utils.CollectionUtils;
import org.springframework.stereotype.Service;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
@Service("memberCardRefService")
public class MemberCardRefServiceImpl implements MemberCardRefService {
       @Resource
       private MemberCardRefMapper memberCardRefMapper;

       /**
        * 前端分页查询用户会员卡表
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param memberCardRef 查询条件
        * @return 
        */
       @Override
       public PageInfo<MemberCardRef> findByPageForFront(Integer pageNo, Integer pageSize, MemberCardRef memberCardRef) {
              PageHelper.startPage(pageNo,pageSize);
              List<MemberCardRef> list = this.memberCardRefMapper.selectListByConditions(memberCardRef);
              PageInfo<MemberCardRef> page = new PageInfo<>(list);
              return page;
       }

       /**
        * 添加用户会员卡表
        * @param t
        * @return
        */
       @Override
       public int addObj(MemberCardRef t) {
              return this.memberCardRefMapper.insertSelective(t);
       }

       /**
        * 删除用户会员卡表
        * @param id
        * @return
        */
       @Override
       public int deleteObjById(int id) {
              return this.memberCardRefMapper.deleteByPrimaryKey(id);
       }

       /** 
        * 修改用户会员卡表
        * @param t
        * @return
        */
       @Override
       public int modifyObj(MemberCardRef t) {
              return this.memberCardRefMapper.updateByPrimaryKeySelective(t);
       }

       /**
        * 根据ID查询
        * @param id
        * @returnmemberCardRef
        */
       @Override
       public MemberCardRef queryObjById(int id) {
              MemberCardRef model=this.memberCardRefMapper.selectByPrimaryKey(id);
              return model;
       }

       /**
        * 设置会员卡失效
        */
       @Override
       public void setMemberCardUnEffective() {
              MemberCardRef memberCardRef = new MemberCardRef();
              memberCardRef.setExpiredTime(new Date());
              List<Integer> list = memberCardRefMapper.cardUnEffective(memberCardRef);
              if(!CollectionUtils.isEmpty(list)){
                     this.memberCardRefMapper.updateBatch(list);
              }
       }
}