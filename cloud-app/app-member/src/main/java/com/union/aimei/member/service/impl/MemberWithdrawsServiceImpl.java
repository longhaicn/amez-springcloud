package com.union.aimei.member.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.store.StoreBeauticianFeign;
import com.union.aimei.common.model.member.Member;
import com.union.aimei.common.model.member.MemberBankCard;
import com.union.aimei.common.model.member.MemberRealNameAuth;
import com.union.aimei.common.model.member.MemberWithdraws;
import com.union.aimei.common.model.store.StoreBeautician;
import com.union.aimei.member.mapper.MemberBankCardMapper;
import com.union.aimei.member.mapper.MemberMapper;
import com.union.aimei.member.mapper.MemberRealNameAuthMapper;
import com.union.aimei.member.mapper.MemberWithdrawsMapper;
import com.union.aimei.member.service.MemberWithdrawsService;
import com.union.common.utils.*;
import com.union.common.utils.constant.ResponseContants;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
@Service("memberWithdrawsService")
public class MemberWithdrawsServiceImpl implements MemberWithdrawsService {
       @Resource
       private MemberWithdrawsMapper memberWithdrawsMapper;

       @Resource
       private MemberRealNameAuthMapper memberRealNameAuthMapper;

       @Resource
       private MemberBankCardMapper memberBankCardMapper;

       @Resource
       private MemberMapper memberMapper;

       @Resource
       private StoreBeauticianFeign storeBeauticianFeign;



       /**
        * 前端分页查询会员提现申请表
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param memberWithdraws 查询条件
        * @return 
        */
       @Override
       public PageInfo<MemberWithdraws> findByPageForFront(Integer pageNo, Integer pageSize, MemberWithdraws memberWithdraws) {
              PageHelper.startPage(pageNo,pageSize);
              List<MemberWithdraws> list = this.memberWithdrawsMapper.selectListByConditions(memberWithdraws);
              PageInfo<MemberWithdraws> page = new PageInfo<>(list);
              return page;
       }

       @Override
       public ResponseMessage<MemberWithdraws> insertRecord(MemberWithdraws memberWithdraws) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              //第一步：根据会员id来查询会员是否实名制认证
              MemberRealNameAuth memberRealNameAuth =  new MemberRealNameAuth();
              memberRealNameAuth.setThirdAuthStatus((byte)1);
              memberRealNameAuth.setMemberId(memberWithdraws.getMemberId());
              List<MemberRealNameAuth> mrnaList = this.memberRealNameAuthMapper.selectListByConditions(memberRealNameAuth);
              if(!CollectionUtils.isEmpty(mrnaList)){
                     memberRealNameAuth = mrnaList.get(0);
                     //把实名制的用户姓名信息
                     memberWithdraws.setMemberRealName(memberRealNameAuth.getRealName());
                     //提现金额有3%的手续费
                     memberWithdraws.setTaxation(doubleToInt(memberWithdraws.getWithdrawAmount()*0.03));
                     //计算实际提现金额
                     memberWithdraws.setActualAmount(memberWithdraws.getWithdrawAmount() - doubleToInt(memberWithdraws.getWithdrawAmount()*0.03));
                     //第二步：根据银行卡id来进行查询会员银行卡信息
                     MemberBankCard memberBankCard =  this.memberBankCardMapper.selectByPrimaryKey(memberWithdraws.getBankCardId());
                     //添加银行卡信息
                     memberWithdraws.setBankCardNo(memberBankCard.getCardNo());
                     //第三步：根据会员id来获取会员手机号码
                     Member member = this.memberMapper.selectByPrimaryKey(memberWithdraws.getMemberId());
                     memberWithdraws.setMemberPhone(member.getRegisterPhone());

                     //第四部：根据会员id来获取会员所属门店信息
                     StoreBeautician storeBeautician = new StoreBeautician();
                     storeBeautician.setMemberId(memberWithdraws.getMemberId());
                     ResponseMessage<StoreBeautician> sbMsg = this.storeBeauticianFeign.queryByMemberId(storeBeautician);
                     if(ResponseUtil.isSuccess(sbMsg)){
                            memberWithdraws.setBelongStoreId(storeBeautician.getStoreId());
                            memberWithdraws.setBelongStoreName(storeBeautician.getStoreName());
                            memberWithdraws.setBeauticianId(storeBeautician.getId());
                     }
                     int res=this.memberWithdrawsMapper.insertSelective(memberWithdraws);
                     AssertUtil.numberGtZero(res,ResponseContants.ADD_MESSAGE,ResponseContants.ADD);
              }else{
                     result.setCode(6001);
                     result.setMessage("会员没有进行实名制");
              }
              return result;
       }

       private static Integer doubleToInt(double doub){
              Integer amount = 0;
              NumberFormat nf = new DecimalFormat("#");
              amount = Integer.parseInt(nf.format(doub));
              return amount;
       }

       /**
        * 添加会员提现申请表
        * @param
        * @return
        */
       @Override
       public int addObj(MemberWithdraws t) {
              return this.memberWithdrawsMapper.insertSelective(t);
       }

       /**
        * 删除会员提现申请表
        * @param id
        * @return
        */
       @Override
       public int deleteObjById(int id) {
              return this.memberWithdrawsMapper.deleteByPrimaryKey(id);
       }

       /** 
        * 修改会员提现申请表
        * @param
        * @return
        */
       @Override
       public int modifyObj(MemberWithdraws t) {
              return this.memberWithdrawsMapper.updateByPrimaryKeySelective(t);
       }

       /**
        * 根据ID查询
        * @param id
        * @returnmemberWithdraws
        */
       @Override
       public MemberWithdraws queryObjById(int id) {
              MemberWithdraws model=this.memberWithdrawsMapper.selectByPrimaryKey(id);
              return model;
       }
}