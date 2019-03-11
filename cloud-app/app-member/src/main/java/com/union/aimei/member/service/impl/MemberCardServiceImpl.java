package com.union.aimei.member.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.constant.member.MemberCardConstant;
import com.union.aimei.common.feign.app.store.GrowthRuleFeign;
import com.union.aimei.common.feign.app.store.StoreFeign;
import com.union.aimei.common.model.member.MemberCard;
import com.union.aimei.common.model.member.MemberCardTradeRecode;
import com.union.aimei.common.model.member.MemberCardUseProduct;
import com.union.aimei.common.model.member.MemberCardUseRange;
import com.union.aimei.common.model.store.Store;
import com.union.aimei.common.vo.member.BuyMemberCardVo;
import com.union.aimei.common.vo.member.MemberCardDetailsVo;
import com.union.aimei.common.vo.member.SubmitMemberCard;
import com.union.aimei.common.vo.member.ValueComparator;
import com.union.aimei.common.vo.store.app.StoreByIdVo;
import com.union.aimei.member.mapper.MemberCardMapper;
import com.union.aimei.member.mapper.MemberCardTradeRecodeMapper;
import com.union.aimei.member.mapper.MemberCardUseProductMapper;
import com.union.aimei.member.mapper.MemberCardUseRangeMapper;
import com.union.aimei.member.service.MemberCardService;
import com.union.common.utils.CollectionUtils;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseMessageFactory;
import com.union.common.utils.constant.ResponseContants;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
@Service("memberCardService")
public class MemberCardServiceImpl implements MemberCardService {
    @Resource
    private MemberCardMapper memberCardMapper;
    @Resource
    private MemberCardUseRangeMapper memberCardUseRangeMapper;
    @Resource
    private MemberCardUseProductMapper memberCardUseProductMapper;
    @Resource
    private MemberCardTradeRecodeMapper memberCardTradeRecodeMapper;
    @Resource
    private GrowthRuleFeign growthRuleFeign;
    @Resource
    private StoreFeign storeFeign;


    /**
     * 前端分页查询会员卡
     *
     * @param pageNo     分页索引
     * @param pageSize   每页显示数量
     * @param memberCard 查询条件
     * @return
     */
    @Override
    public PageInfo<MemberCard> findByPageForFront(Integer pageNo, Integer pageSize, MemberCard memberCard) {
        PageHelper.startPage(pageNo, pageSize);
        List<MemberCard> list = this.memberCardMapper.selectListByConditions(memberCard);
        List<MemberCard> resList = new ArrayList<>(10);
        for(MemberCard card : list){
            //使用范围(0:多店,1:单店,默认多店)
            if(!card.getUseRange()){
                List<Integer> rangeList =  memberCardUseRangeMapper.queryListByCardId(card.getId());
            }
            resList.add(card);
        }
        PageInfo<MemberCard> page = new PageInfo<>(resList);
        return page;
    }

    /**
     * 添加会员卡
     *
     * @param
     * @return
     */
    @Override
    public int addObj(MemberCard t) {
        return this.memberCardMapper.insertSelective(t);
    }

    /**
     * 删除会员卡
     *
     * @param id
     * @return
     */
    @Override
    public int deleteObjById(int id) {
        return this.memberCardMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改会员卡
     *
     * @param
     * @return
     */
    @Override
    public int modifyObj(MemberCard t) {
        return this.memberCardMapper.updateByPrimaryKeySelective(t);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnmemberCard
     */
    @Override
    public MemberCard queryObjById(int id) {
        MemberCard model = this.memberCardMapper.selectByPrimaryKey(id);
        return model;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(SubmitMemberCard submitMemberCard) {
        MemberCard memberCard=getMemberCard(submitMemberCard);
        //添加会员卡
        memberCardMapper.insertSelective(memberCard);
        Integer cardId=memberCardMapper.queryNewestSaveId(memberCard);
        //批量添加会员卡门店使用范围集合
        List<MemberCardUseRange> storeList=getUseStoreRangeList(cardId,submitMemberCard.getUseAbleStoreList());
        memberCardUseRangeMapper.insertMemberCardUseStoreBatch(storeList);
        //批量添加会员卡适用服务集合
        List<MemberCardUseProduct> productList=getMemberCardUseProductList(cardId,submitMemberCard.getUseAbleProductList());
        memberCardUseProductMapper.insertCardUseProductBatch(productList);
        return 1;
    }

    /**
     * 获取会员卡
     * @param submitMemberCard
     * @return
     */
    private MemberCard getMemberCard(SubmitMemberCard submitMemberCard){
        MemberCard memberCard=new MemberCard();
        memberCard.setBrandName(submitMemberCard.getMemberCardName());
        memberCard.setBalance(submitMemberCard.getBalance());
        memberCard.setDiscount(submitMemberCard.getDiscount());
        memberCard.setSupportRecharge(submitMemberCard.getSupportRecharge());
        memberCard.setExpiredTime(submitMemberCard.getExpiredTime());
        memberCard.setStylePattern(submitMemberCard.getStylePattern());
        memberCard.setUseRange(submitMemberCard.getUseRange());
        return memberCard;
    }

    /**
     * 获取会员卡使用门店范围对象集合
     * @param cardId
     * @param storeIdList
     * @return
     */
    private List<MemberCardUseRange> getUseStoreRangeList(Integer cardId,List<Integer> storeIdList){
        List<MemberCardUseRange> list=new ArrayList<>(10);
        for(Integer s:storeIdList){
            MemberCardUseRange memberCardUseRange=new MemberCardUseRange();
            memberCardUseRange.setCardId(cardId);
            memberCardUseRange.setStoreId(s);
            list.add(memberCardUseRange);
        }
        return list;
    }

    /**
     * 获取会员卡适用服务对象集合
     * @param cardId
     * @param productIdList
     * @return
     */
    private List<MemberCardUseProduct> getMemberCardUseProductList(Integer cardId,List<Integer> productIdList){
        List<MemberCardUseProduct> list=new ArrayList<>(10);
        for(Integer s:productIdList){
            MemberCardUseProduct memberCardUseProduct=new MemberCardUseProduct();
            memberCardUseProduct.setCardId(cardId);
            memberCardUseProduct.setProductId(s);
            list.add(memberCardUseProduct);
        }
        return list;
    }

    /**
     * 查询会员卡详情
     * @param memberId
     * @param cardId
     * @return
     */
    @Override
    public ResponseMessage queryDetailsByCardId(Integer memberId, Integer cardId) {
        ResponseMessage responseMessage= ResponseMessageFactory.newInstance();
        Map<String,Object> requestMap=new HashMap<>(2);
        requestMap.put("memberId",memberId);
        requestMap.put("cardId",cardId);
        Map<String,Object> map=memberCardMapper.queryDetailsByMemAndCardId(requestMap);
        if(map!=null){
            MemberCardTradeRecode recode=new MemberCardTradeRecode();
            recode.setMemberId(memberId);
            recode.setMemberCardId(cardId);
            byte useType=1;
            recode.setUseType(useType);
            Double reduceAmount=0.0;
            Integer discount=Integer.parseInt(map.get("discount").toString());
              //计算会员卡累计节省金额
              List<MemberCardTradeRecode> tradeList=memberCardTradeRecodeMapper.selectListByConditions(recode);
              if(!CollectionUtils.isEmpty(tradeList)){
                  for(MemberCardTradeRecode m:tradeList){
                      Integer tradeAmount=m.getTradeAmount();
                      reduceAmount+=tradeAmount*(10-discount);
                  }
              }
            map.put("reduceAmount",reduceAmount);
            responseMessage.setData(map);
        }else{
            responseMessage.setCode(ResponseContants.QUERY_RESULT_EMPTY);
            responseMessage.setMessage(ResponseContants.QUERY_RESULT_EMPTY_MESSAGE);
        }
        return responseMessage;
    }

    /**
     * 查询购卡会员卡列表
     * @param brandId
     * @param storeId
     * @return
     */
    @Override
    public PageInfo<BuyMemberCardVo> queryBuyCardPage(Integer pageNo, Integer pageSize, Integer brandId, Integer storeId) {
        Map<String,Object> map=new HashMap<>(1);
        if(brandId!=null&&brandId!=0){
            map.put("brandId",brandId);
        }
        if(storeId!=null&&storeId!=0){
            map.put("storeId",storeId);
        }
        PageHelper.startPage(pageNo, pageSize);
        List<BuyMemberCardVo> list = this.memberCardMapper.queryBuyCardPage(map);
        if(!CollectionUtils.isEmpty(list)){
            list.forEach(x->{
                Integer useRange=x.getUseRange();
                if(useRange==0){
                    x.setUseAbleNum(1);
                }else if(useRange==1){
                    Integer cardId=x.getId();
                    int useAbleStoreNum=memberCardMapper.queryUseAbleNum(cardId);
                    x.setUseAbleNum(useAbleStoreNum);
                }
            });
        }
        PageInfo<BuyMemberCardVo> page = new PageInfo<>(list);
        return page;
    }

    @Override
    public ResponseMessage queryDetailById(Integer id) {
        ResponseMessage res=ResponseMessageFactory.newInstance();
        return res;
    }

    @Override
    public ResponseMessage queryDetailsById(MemberCardDetailsVo memberCardDetailsVo){
        ResponseMessage res= ResponseMessageFactory.newInstance();
        Map<String,Object> map=new HashMap<>(3);
        MemberCard memberCard=memberCardMapper.selectByPrimaryKey(memberCardDetailsVo.getId());
        if(memberCard!=null){
            map.put("memberCard",memberCard);
        }else{
            res.setCode(ResponseContants.QUERY_RESULT_EMPTY);
            res.setMessage(ResponseContants.QUERY_RESULT_EMPTY_MESSAGE);
            return  res;
        }
        List<Integer> useStoreList= memberCardUseRangeMapper.queryListByCardId(memberCardDetailsVo.getId());
        map.put("useAbleStoreIds",useStoreList);
        List<Integer> useProductList=memberCardUseProductMapper.queryListByCardId(memberCardDetailsVo.getId());
        map.put("useProductList",useProductList);

        Map<Integer,Store> storeMap = new HashMap<>(16);
        List<Store> resStore = new ArrayList<>(10);
        //第一步：根据门店id集合，获取门店信息并计算距离
        if(map.containsKey(MemberCardConstant.MapKey.USE_ABLE_STORE_IDS)){
            Map<Integer,Long> disMap = new HashMap<>(16);
            List<Store> emplist = new ArrayList<>(10);
            List<Integer> intList = (List<Integer>)map.get(MemberCardConstant.MapKey.USE_ABLE_STORE_IDS);
            intList.forEach((Integer integer) -> {
                StoreByIdVo storeByIdVo = new StoreByIdVo();
                storeByIdVo.setId(integer);
                storeByIdVo.setPoint(memberCardDetailsVo.getPoint());
                Store store = this.storeFeign.queryDistanceById(storeByIdVo);
                //当门店信息中存在经纬度就可以计算出距离，当不存在，距离就为null

                if(store.getDistance() != null){
                    disMap.put(store.getId(),store.getDistance());
                }else{
                    //当经纬度不存在，距离为null，List保存门店信息
                    emplist.add(store);
                }
                //Map保存所有的门店集合 key--门店id  value--门店
                storeMap.put(integer,store);
            });
            //根据有经纬度的门店计算出距离进行排序
            //获取由近到远门店的id
            List<Integer> listAsc = ValueComparator.sortMap(disMap);
            listAsc.forEach((Integer intasc) -> {
                //用一个List保存由近到远的门店
                resStore.add(storeMap.get(intasc));
            });
            //最后把没有经纬度的list加入到集合中去
            resStore.addAll(emplist);
            map.put("useAbleStoreList",resStore);
        }else{
            map.put("useAbleStoreList","");
        }
        res.setData(map);
        return res;
    }
}