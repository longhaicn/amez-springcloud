package com.union.aimei.member.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.member.MemberCard;
import com.union.aimei.common.model.member.MemberCardUseProduct;
import com.union.aimei.common.model.member.MemberCardUseRange;
import com.union.aimei.common.vo.member.EditMemberCardVo;
import com.union.aimei.common.vo.member.MemberAndMemberCardVo;
import com.union.aimei.common.vo.member.ReleaseMemberCardVo;
import com.union.aimei.member.mapper.MemberCardMapper;
import com.union.aimei.member.mapper.MemberCardUseProductMapper;
import com.union.aimei.member.mapper.MemberCardUseRangeMapper;
import com.union.aimei.member.service.MemberCardService;
import com.union.aimei.member.util.DateUtilDay;
import com.union.common.utils.CollectionUtils;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseMessageFactory;
import com.union.common.utils.constant.RequestConstant;
import com.union.common.utils.constant.ResponseContants;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author GaoWei
 * @describe
 * @time 2018/2/2,11:14
 */
@Service("memberCardService")
public class MemberCardServiceImpl implements MemberCardService {
    @Resource
    private MemberCardMapper memberCardMapper;
    @Resource
    private MemberCardUseRangeMapper memberCardUseRangeMapper;
    @Resource
    private MemberCardUseProductMapper memberCardUseProductMapper;


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
        PageInfo<MemberCard> page = new PageInfo<>(list);
        return page;
    }

    /**
     * 添加会员卡
     *
     * @param
     * @return
     */
    @Override
    @Deprecated
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

    /**
     * 发布会员卡
     *
     * @param releaseMemberCardVo
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseMessage releaseMemberCard(ReleaseMemberCardVo releaseMemberCardVo) {
        MemberCard memberCard = getMemberCard(releaseMemberCardVo);
        //添加会员卡
        memberCardMapper.insertSelective(memberCard);
        Integer cardId = memberCardMapper.queryNewestSaveId(memberCard);
        List<Integer> useAbleStore = releaseMemberCardVo.getUseAbleStoreList();
        if (!CollectionUtils.isEmpty(useAbleStore)) {
            //批量添加会员卡门店使用范围集合
            List<MemberCardUseRange> storeList = getUseStoreRangeList(cardId, releaseMemberCardVo.getUseAbleStoreList());
            memberCardUseRangeMapper.insertMemberCardUseStoreBatch(storeList);
        }

        List<Integer> useAbleProduct = releaseMemberCardVo.getUseAbleProductList();
        if (!CollectionUtils.isEmpty(useAbleProduct)) {
            //批量添加会员卡适用服务集合
            List<MemberCardUseProduct> productList = getMemberCardUseProductList(cardId, releaseMemberCardVo.getUseAbleProductList());
            memberCardUseProductMapper.insertCardUseProductBatch(productList);
        }
        return ResponseMessageFactory.newInstance();

    }


    /**
     * 获取会员卡
     *
     * @param submitMemberCard
     * @return
     */
    private MemberCard getMemberCard(ReleaseMemberCardVo submitMemberCard) {
        MemberCard memberCard = new MemberCard();
        memberCard.setIssueType(submitMemberCard.getIssueType());
        memberCard.setBrandId(submitMemberCard.getBrandId());
        memberCard.setBrandName(submitMemberCard.getBrandName());
        memberCard.setCardName(submitMemberCard.getMemberCardName());
        memberCard.setIssueNum(submitMemberCard.getIssueNum());
        memberCard.setBalance(submitMemberCard.getBalance());
        memberCard.setDiscount(submitMemberCard.getDiscount());
        memberCard.setEffectiveType(submitMemberCard.getEffectiveType());
        memberCard.setEffectiveDay(submitMemberCard.getEffectiveDay());
        memberCard.setSupportRecharge(submitMemberCard.getSupportRecharge());
        memberCard.setUseStartTime(submitMemberCard.getUseStartTime());
        memberCard.setExpiredTime(submitMemberCard.getExpiredTime());
        memberCard.setStylePattern(submitMemberCard.getStylePattern());
        memberCard.setUseRange(submitMemberCard.getUseRange());
        memberCard.setStoreId(submitMemberCard.getStoreId());
        memberCard.setStoreName(submitMemberCard.getStoreName());
        List<Integer> useAbleStoreList = submitMemberCard.getUseAbleStoreList();
        boolean isGt = useAbleStoreList != null && useAbleStoreList.size() == 1;
        memberCard.setUseRange(isGt);
        memberCard.setRemark(submitMemberCard.getRemark());
        return memberCard;
    }

    /**
     * 获取会员卡使用门店范围对象集合
     *
     * @param cardId
     * @param storeIdList
     * @return
     */
    private List<MemberCardUseRange> getUseStoreRangeList(Integer cardId, List<Integer> storeIdList) {
        List<MemberCardUseRange> list = new ArrayList<>(10);
        for (Integer s : storeIdList) {
            MemberCardUseRange memberCardUseRange = new MemberCardUseRange();
            memberCardUseRange.setCardId(cardId);
            memberCardUseRange.setStoreId(s);
            list.add(memberCardUseRange);
        }
        return list;
    }

    /**
     * 获取会员卡适用服务对象集合
     *
     * @param cardId
     * @param productIdList
     * @return
     */
    private List<MemberCardUseProduct> getMemberCardUseProductList(Integer cardId, List<Integer> productIdList) {
        List<MemberCardUseProduct> list = new ArrayList<>(10);
        for (Integer s : productIdList) {
            MemberCardUseProduct memberCardUseProduct = new MemberCardUseProduct();
            memberCardUseProduct.setCardId(cardId);
            memberCardUseProduct.setProductId(s);
            list.add(memberCardUseProduct);
        }
        return list;
    }

    /**
     * 查询会员卡详情
     *
     * @param id
     * @return
     */
    @Override
    public ResponseMessage queryCardDetail(Integer id) {
        ResponseMessage res = ResponseMessageFactory.newInstance();
        Map<String, Object> map = new HashMap<>(3);
        MemberCard memberCard = memberCardMapper.selectByPrimaryKey(id);
        if (memberCard != null) {
            map.put("memberCard", memberCard);
        } else {
            res.setCode(ResponseContants.QUERY_RESULT_EMPTY);
            res.setMessage(ResponseContants.QUERY_RESULT_EMPTY_MESSAGE);
            return res;
        }
        List<Integer> useStoreList = memberCardUseRangeMapper.queryListByCardId(id);
        map.put("useAbleStoreIds", useStoreList);
        List<Integer> useProductList = memberCardUseProductMapper.queryListByCardId(id);
        map.put("useProductList", useProductList);
        res.setData(map);
        return res;
    }

    /**
     * 编辑会员卡详细信息
     *
     * @param editMemberCardVo
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseMessage editMemberCardInfo(EditMemberCardVo editMemberCardVo) {
        ResponseMessage res = ResponseMessageFactory.newInstance();
        if (editMemberCardVo != null) {
            MemberCard memberCard = editMemberCardVo.getMemberCard();
            memberCardMapper.updateByPrimaryKeySelective(memberCard);
            Integer cardId = editMemberCardVo.getMemberCard().getId();
            //删除使用门店范围
            memberCardUseRangeMapper.deleteRecordByCardId(cardId);
            //删除适用服务
            memberCardUseProductMapper.deleteRecordByCardId(cardId);
            //批量添加会员卡门店使用范围集合
            List<MemberCardUseRange> storeList = getUseStoreRangeList(cardId, editMemberCardVo.getUseAbleStoreList());
            memberCardUseRangeMapper.insertMemberCardUseStoreBatch(storeList);
            //批量添加会员卡适用服务集合
            List<MemberCardUseProduct> productList = getMemberCardUseProductList(cardId, editMemberCardVo.getUseAbleProductList());
            memberCardUseProductMapper.insertCardUseProductBatch(productList);
        } else {
            res.setCode(RequestConstant.PARAM_EMPTY);
            res.setMessage(RequestConstant.PARAM_EMPTY_MSG);
        }
        return res;
    }

    /**
     * 查询会员和会员卡新增统计
     */
    @Override
    public Integer queryMemberCardCount(MemberAndMemberCardVo memberAndMemberCardVo) {
        Calendar now = Calendar.getInstance();
        memberAndMemberCardVo.setEndTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(now.getTime()));
        memberAndMemberCardVo.setStartTime(DateUtilDay.getDate(now, memberAndMemberCardVo.getDayCount()));
        return this.memberCardMapper.queryMemberCardCount(memberAndMemberCardVo);
    }

}