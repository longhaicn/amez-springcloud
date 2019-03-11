package com.union.aimei.member.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.member.MemberBankCard;
import com.union.aimei.common.util.member.AuthBankCardUtils;
import com.union.aimei.member.mapper.MemberBankCardMapper;
import com.union.aimei.member.service.MemberBankCardService;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
@Service("memberBankCardService")
public class MemberBankCardServiceImpl implements MemberBankCardService {
       @Resource
       private MemberBankCardMapper memberBankCardMapper;

       /**
        * 前端分页查询会员银行卡表
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param memberBankCard 查询条件
        * @return 
        */
       @Override
       public PageInfo<MemberBankCard> findByPageForFront(Integer pageNo, Integer pageSize, MemberBankCard memberBankCard) {
              PageHelper.startPage(pageNo,pageSize);
              List<MemberBankCard> list = this.memberBankCardMapper.selectListByConditions(memberBankCard);
              PageInfo<MemberBankCard> page = new PageInfo<>(list);
              return page;
       }

       /**
        * 添加会员银行卡表
        * @param
        * @return
        */
       @Override
       public int addObj(MemberBankCard t) {
              int result = 0;
              JSONObject authRes = AuthBankCardUtils.configBankCard(t.getMobile(),t.getBankcard(),t.getCardNo(),t.getRealName());
              if(authRes == null){
                     result = 2;
              }else{
                     t.setThirdAuthStatus((byte)1);
                     try {
                            t.setAbbreviation(authRes.getString("abbreviation"));
                            t.setBankimage(authRes.getString("bankimage"));
                            t.setBankname(authRes.getString("bankname"));
                            t.setBankurl(authRes.getString("bankurl"));
                            t.setCardname(authRes.getString("cardname"));
                            t.setCardtype(authRes.getString("cardtype"));
                            t.setEnbankname(authRes.getString("enbankname"));
                            t.setIsLuhn(authRes.getBoolean("isLuhn"));
                            t.setIscreditcard(authRes.getInt("iscreditcard"));
                            t.setServicephone(authRes.getString("servicephone"));
                            this.memberBankCardMapper.insertSelective(t);
                            result = 1;
                     } catch (Exception e) {
                            result =  3;
                            e.printStackTrace();
                     }
              }
              return result;
       }

       /**
        * 删除会员银行卡表
        * @param id
        * @return
        */
       @Override
       public int deleteObjById(int id) {
              return this.memberBankCardMapper.deleteByPrimaryKey(id);
       }

       /** 
        * 修改会员银行卡表
        * @param
        * @return
        */
       @Override
       public int modifyObj(MemberBankCard t) {
              return this.memberBankCardMapper.updateByPrimaryKeySelective(t);
       }

       /**
        * 根据ID查询
        * @param id
        * @returnmemberBankCard
        */
       @Override
       public MemberBankCard queryObjById(int id) {
              MemberBankCard model=this.memberBankCardMapper.selectByPrimaryKey(id);
              return model;
       }
}