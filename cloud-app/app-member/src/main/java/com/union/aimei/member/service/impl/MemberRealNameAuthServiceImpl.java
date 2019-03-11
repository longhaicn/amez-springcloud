package com.union.aimei.member.service.impl;

import com.codingapi.tx.annotation.TxTransaction;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.store.StoreBeauticianFeign;
import com.union.aimei.common.feign.app.store.StoreFeign;
import com.union.aimei.common.model.member.MemberRealNameAuth;
import com.union.aimei.common.model.store.StoreBeautician;
import com.union.aimei.common.util.member.AuthIDNumberUtils;
import com.union.aimei.common.vo.member.IDNumberAuthVo;
import com.union.aimei.member.mapper.MemberRealNameAuthMapper;
import com.union.aimei.member.service.MemberRealNameAuthService;
import com.union.common.utils.*;
import com.union.common.utils.constant.ResponseContants;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
@Service("memberRealNameAuthService")
public class MemberRealNameAuthServiceImpl implements MemberRealNameAuthService {

       @Resource
       private MemberRealNameAuthMapper memberRealNameAuthMapper;

       @Resource
       private StoreFeign storeFeign;


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

       @Override
       public MemberRealNameAuth queryByMemberId(MemberRealNameAuth memberRealNameAuth) {
              List<MemberRealNameAuth> list = this.memberRealNameAuthMapper.selectListByConditions(memberRealNameAuth);
              if(list.size() > 0){
                     memberRealNameAuth = list.get(0);
              }else{
                     memberRealNameAuth = null;
              }
              return memberRealNameAuth;
       }

       /**
        * 添加会员卡实名认证表
        * @param
        * @return
        */
       @Override
       public int addObj(MemberRealNameAuth t) {
              int result = 0;
              int res =  AuthIDNumberUtils.config(t.getIdCard(),t.getRealName());
              if(res == 0){
                     //根据身份证号查询实名认证表看看数据是否存在
                     MemberRealNameAuth  mrna = new MemberRealNameAuth();
                     mrna.setIdCard(t.getIdCard());
                     List<MemberRealNameAuth> list = this.memberRealNameAuthMapper.selectListByConditions(mrna);
                     if(list.size() > 0){
                            mrna = list.get(0);
                            //当根据身份正好查询数据存在并人工审核的状态为2，可以重新提交数据
                            if(mrna.getAuditStatus().equals(MemberRealNameAuth.AuditStatus.NOT_PASS_AUDIT)){
                                   int id = mrna.getId();
                                   t.setId(id);
                                   t.setThirdAuthStatus((byte)1);
                                   t.setAuditStatus((byte)0);
                                   int upId = this.memberRealNameAuthMapper.updateByPrimaryKeySelective(t);
                                   if(upId > 0){
                                          result = 1;
                                   }else{
                                          //验证失败
                                          result =0;
                                   }
                            }else{
                                   result = 3;
                            }
                     }else {
                            t.setThirdAuthStatus((byte)1);
                            int  inId = this.memberRealNameAuthMapper.insertSelective(t);
                            if(inId > 0 ){
                                   result =1;
                            }else {
                                   //验证失败
                                   result =0;
                            }
                     }
              }else{
                     //验证失败
                     result =2;
              }
              return result;
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
        * @param
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

       /**
        * 会员实名制第三认证
        * @param idNumberAuthVo
        * @return
        */

       @Override
       public int authIDNumber(IDNumberAuthVo idNumberAuthVo){
              return AuthIDNumberUtils.config(idNumberAuthVo.getCardNo(),idNumberAuthVo.getRealName());
       }

       @Override
       @TxTransaction(isStart = true, rollbackFor = Exception.class)
       @Transactional(rollbackFor = Exception.class)
       public ResponseMessage insert(MemberRealNameAuth memberRealNameAuth) {
             ResponseMessage result = ResponseMessageFactory.newInstance();
             //判断姓名身份证必须存在
              if(memberRealNameAuth.getIdCard() == null || memberRealNameAuth.getRealName() ==null){
                     result.setCode(4001);
                     result.setMessage("身份证或真实姓名不得为空");
                     return result;
              }
              if(AuthIDNumberUtils.config(memberRealNameAuth.getIdCard(),memberRealNameAuth.getRealName()) != 0){
                     result.setCode(4002);
                     result.setMessage("身份证和姓名不匹配");
                     return result;
              } 
              //提交真实姓名和身份证号，美容师端，认证状态改为待审核
              MemberRealNameAuth mrna = new MemberRealNameAuth();
              mrna.setIdCard(memberRealNameAuth.getIdCard());
              List<MemberRealNameAuth> mrnaList =  this.memberRealNameAuthMapper.selectListByConditions(mrna);
              if(!CollectionUtils.isEmpty(mrnaList)){
                     mrna = mrnaList.get(0);
                     //审核不通过可以重新提交数据
                     if(mrna.getAuditStatus().equals(MemberRealNameAuth.AuditStatus.NOT_PASS_AUDIT)){
                            memberRealNameAuth.setThirdAuthStatus((byte)1);
                            memberRealNameAuth.setAuditStatus((byte)0);
                            memberRealNameAuth.setId(mrna.getId());
                            this.memberRealNameAuthMapper.updateByPrimaryKeySelective(memberRealNameAuth);
                            //用户实名认证成功，美容师实名认证状态修改为待审核
                            StoreBeautician sb = new StoreBeautician();
                            sb.setMemberId(mrna.getMemberId());
                            ResponseMessage<StoreBeautician> sbRes = this.storeBeauticianFeign.queryByMemberId(sb);
                            if(ResponseUtil.isSuccess(sbRes)){
                                   sb.setBeauticianName(mrna.getRealName());
                                   sb.setRealNameStatus(StoreBeautician.RealNameStatus.PENGING);
                                   sb.setId(sbRes.getData().getId());
                                   ResponseMessage upSbMsg = this.storeBeauticianFeign.modifyRealName(sb);
                                   if(ResponseUtil.isSuccess(upSbMsg)){
                                          result.setCode(6001);
                                          result.setMessage("实名认证更新美容师实名状态失败");
                                   }
                            }
                     }else{
                            result.setCode(6002);
                            result.setMessage("实名资料在在审核，请勿重复提交数据");
                     }
                     return result;
              }else{
                     memberRealNameAuth.setThirdAuthStatus((byte)1);
                     this.memberRealNameAuthMapper.insertSelective(memberRealNameAuth);
                     //用户实名认证成功，美容师实名认证状态修改为待审核
                     StoreBeautician sb = new StoreBeautician();
                     sb.setMemberId(mrna.getMemberId());
                     ResponseMessage<StoreBeautician> resSb = this.storeBeauticianFeign.queryByMemberId(sb);
                     if(ResponseUtil.isSuccess(resSb)){
                            sb.setBeauticianName(mrna.getRealName());
                            sb.setRealNameStatus(StoreBeautician.RealNameStatus.PENGING);
                            sb.setId(resSb.getData().getId());
                            ResponseMessage upSbMsg = this.storeBeauticianFeign.modifyRealName(sb);
                            if(ResponseUtil.isFail(upSbMsg)){
                                   result.setCode(6001);
                                   result.setMessage("实名认证更新美容师实名状态失败");
                            }
                     }else{
                            result.setCode(6002);
                            result.setMessage("查询美容师为空");
                     }
                     return result;
              }
       }
}