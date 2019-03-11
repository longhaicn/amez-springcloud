package com.union.aimei.common.feign.app.member.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.member.MemberCardFeign;
import com.union.aimei.common.model.member.MemberCard;
import com.union.aimei.common.vo.member.MemberCardDetailsVo;
import com.union.aimei.common.vo.member.SubmitMemberCard;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

/**
 * @author GaoWei
 * @describe
 * @time 2017/12/19,10:54
 */
@Component(value = "app-MemberCardFeign")
public class MemberCardApiHystrix implements MemberCardFeign {

    @Override
    public PageInfo<MemberCard> findByPageForFront(Integer pageNo, Integer pageSize, MemberCard memberCard) {
        return new PageInfo<>();
    }

    @Override
    public int insert(SubmitMemberCard submitMemberCard) {
        return 0;
    }

    /**
     * 删除会员卡
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改会员卡
     *
     * @param memberCard
     * @return
     */
    @Override
    public int edit(MemberCard memberCard) {
        return 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnmemberCard
     */
    @Override
    public MemberCard queryById(int id) {
        return null;
    }

    @Override
    public ResponseMessage queryDetailsByCardId(Integer memberId, Integer cardId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage queryDetailById(int id) {
        return null;
    }

    @Override
    public ResponseMessage queryDetailsById(MemberCardDetailsVo memberCardDetailsVo) {
        return null;
    }
}