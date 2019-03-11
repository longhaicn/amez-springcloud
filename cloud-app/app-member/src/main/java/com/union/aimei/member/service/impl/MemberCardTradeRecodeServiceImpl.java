package com.union.aimei.member.service.impl;

import com.codingapi.tx.annotation.TxTransaction;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.member.MemberCardTradeRecode;
import com.union.aimei.member.mapper.MemberCardTradeRecodeMapper;
import com.union.aimei.member.service.MemberCardTradeRecodeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author GaoWei
 * @describe 
 * @time 2017/12/19,14:38
*/
@Service("memberCardTradeRecodeService")
public class MemberCardTradeRecodeServiceImpl implements MemberCardTradeRecodeService {
       @Resource
       private MemberCardTradeRecodeMapper memberCardTradeRecodeMapper;

       /**
        * 前端分页查询会员卡交易记录
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param memberCardTradeRecode 查询条件
        * @return 
        */
       @Override
       public PageInfo<MemberCardTradeRecode> findByPageForFront(Integer pageNo, Integer pageSize, MemberCardTradeRecode memberCardTradeRecode) {
              PageHelper.startPage(pageNo,pageSize);
              List<MemberCardTradeRecode> list = this.memberCardTradeRecodeMapper.selectListByConditions(memberCardTradeRecode);
              PageInfo<MemberCardTradeRecode> page = new PageInfo<>(list);
              return page;
       }

       /**
        * 添加会员卡交易记录
        * @param
        * @return
        */
       @Override
       @Transactional(rollbackFor = Exception.class)
       public int addObj(MemberCardTradeRecode t) {
              return this.memberCardTradeRecodeMapper.insertSelective(t);
       }

       /**
        * 删除会员卡交易记录
        * @param id
        * @return
        */
       @Override
       public int deleteObjById(int id) {
              return this.memberCardTradeRecodeMapper.deleteByPrimaryKey(id);
       }

       /** 
        * 修改会员卡交易记录
        * @param
        * @return
        */
       @Override
       @TxTransaction(isStart = true, rollbackFor = Exception.class)
       @Transactional(rollbackFor = Exception.class)
       public int modifyObj(MemberCardTradeRecode t) {
              return this.memberCardTradeRecodeMapper.updateByPrimaryKeySelective(t);
       }

       /**
        *
        * @param
        * @return
        */
       @Override
       public MemberCardTradeRecode queryObjById(int id) {
              return memberCardTradeRecodeMapper.selectByPrimaryKey(id);
       }

       @Override
       public MemberCardTradeRecode queryByOrderNo(String orderNo) {
              return memberCardTradeRecodeMapper.queryByOrderNo(orderNo);
       }
}