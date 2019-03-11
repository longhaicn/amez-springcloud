package com.union.aimei.member.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.member.MemberCardUseProduct;
import com.union.aimei.member.mapper.MemberCardMapper;
import com.union.aimei.member.mapper.MemberCardUseProductMapper;
import com.union.aimei.member.service.MemberCardUseProductService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import com.union.aimei.common.vo.member.NewProductGroundVo;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.constant.ResponseContants;
import org.springframework.stereotype.Service;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
@Service("memberCardUseProductService")
public class MemberCardUseProductServiceImpl implements MemberCardUseProductService {
       @Resource
       private MemberCardUseProductMapper memberCardUseProductMapper;

       @Resource
       private MemberCardMapper memberCardMapper;

       /**
        * 前端分页查询会员卡适用服务表
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param memberCardUseProduct 查询条件
        * @return 
        */
       @Override
       public PageInfo<MemberCardUseProduct> findByPageForFront(Integer pageNo, Integer pageSize, MemberCardUseProduct memberCardUseProduct) {
              PageHelper.startPage(pageNo,pageSize);
              List<MemberCardUseProduct> list = this.memberCardUseProductMapper.selectListByConditions(memberCardUseProduct);
              PageInfo<MemberCardUseProduct> page = new PageInfo<>(list);
              return page;
       }

       @Override
       public ResponseMessage insertMemberCardByProductId(NewProductGroundVo newProductGroundVo) {
              //查询所有的会员卡
              Map<String,Object> mapCard = new HashMap<>(2);
              mapCard.put("brandId",newProductGroundVo.getBrandId());
              mapCard.put("storeIdList",newProductGroundVo.getStoreIdList());
              List<Integer> list = this.memberCardMapper.queryByStoreId(mapCard);
              if(list.size() > 0){
                     Map<String,Object> map = new HashMap<>(3);
                     map.put("productId",newProductGroundVo.getProductId());
                     map.put("productName",newProductGroundVo.getProductName());
                     map.put("cardIdList",list);
                     this.memberCardUseProductMapper.insertBatch(map);
              }
              return new ResponseMessage();
       }

       /**
        * 添加会员卡适用服务表
        * @param t
        * @return
        */
       @Override
       public int addObj(MemberCardUseProduct t) {
              return this.memberCardUseProductMapper.insertSelective(t);
       }

       /**
        * 删除会员卡适用服务表
        * @param id
        * @return
        */
       @Override
       public int deleteObjById(int id) {
              return this.memberCardUseProductMapper.deleteByPrimaryKey(id);
       }

       /** 
        * 修改会员卡适用服务表
        * @param t
        * @return
        */
       @Override
       public int modifyObj(MemberCardUseProduct t) {
              return this.memberCardUseProductMapper.updateByPrimaryKeySelective(t);
       }

       /**
        * 根据ID查询
        * @param id
        * @returnmemberCardUseProduct
        */
       @Override
       public MemberCardUseProduct queryObjById(int id) {
              MemberCardUseProduct model=this.memberCardUseProductMapper.selectByPrimaryKey(id);
              return model;
       }
}