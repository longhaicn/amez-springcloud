package com.union.aimei.common.feign.app.member.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.member.MemberCardRefFeign;
import com.union.aimei.common.model.member.MemberCardRef;
import com.union.aimei.common.model.member.MemberCardTradeRecode;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author GaoWei
 * @describe
 * @time 2017/12/19,10:54
 */
@Component(value = "app-MemberCardRefFeign")
public class MemberCardRefApiHystrix implements MemberCardRefFeign {

    /**
     * 前端分页查询用户会员卡表
     *
     * @param pageNo        分页索引
     * @param pageSize      每页显示数量
     * @param memberCardRef 查询条件
     * @return
     */
    @Override
    public PageInfo<MemberCardRef> findByPageForFront(Integer pageNo, Integer pageSize, MemberCardRef memberCardRef) {
        return null;
    }

    /**
     * 添加用户会员卡表
     *
     * @param memberCardRef
     * @return
     */
    @Override
    public int insert(MemberCardRef memberCardRef) {
        return 0;
    }

    /**
     * 删除用户会员卡表
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改用户会员卡表
     *
     * @param memberCardRef
     * @return
     */
    @Override
    public int edit(MemberCardRef memberCardRef) {
        return 0;
    }

    @Override
    public ResponseMessage queryById(int id) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public  ResponseMessage<MemberCardRef> queryByRefId(int id) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<MemberCardRef> queryByIdAndCardId(Map<String, Object> map) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<PageInfo<Map<String,Object>>> queryByMemberId(Integer pageNo, Integer pageSize, Integer memberId,Byte isEnabled) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<PageInfo<Map<String, Object>>> queryUserdByMemberId(Integer pageNo, Integer pageSize, Integer memberId, Integer productId) {
        return null;
    }

    @Override
    public ResponseMessage memberCardConsume(Integer amount, Integer memberId, Integer memberCardId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage queryMemberNewestCard(Integer memberId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage insertBuyCardRecord(MemberCardTradeRecode memberCardTradeRecode) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage updateMemberCardBalance(MemberCardTradeRecode memberCardTradeRecode) {
        return HystrixResponse.invokeFail();
    }
}