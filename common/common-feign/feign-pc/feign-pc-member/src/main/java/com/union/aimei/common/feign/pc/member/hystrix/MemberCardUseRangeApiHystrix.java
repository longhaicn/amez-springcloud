package com.union.aimei.common.feign.pc.member.hystrix;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.member.MemberCardUseRangeFeign;
import com.union.aimei.common.model.member.MemberCardUseRange;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
@Component(value = "pc-MemberCardUseRangeFeign")
public class MemberCardUseRangeApiHystrix implements MemberCardUseRangeFeign {

    /**
     * 前端分页查询会员卡使用范围
     *
     * @param pageNo             分页索引
     * @param pageSize           每页显示数量
     * @param memberCardUseRange 查询条件
     * @return
     */
    @Override
    public PageInfo<MemberCardUseRange> findByPageForFront(Integer pageNo, Integer pageSize, MemberCardUseRange memberCardUseRange) {
        return null;
    }

    @Override
    public void updateBatch(int storeId) {

    }

    @Override
    public ResponseMessage memberCardStatusByStoreId(int storeId, int type) {
        return HystrixResponse.invokeFail ();
    }

    /**
     * 添加会员卡使用范围
     *
     * @param memberCardUseRange
     * @return
     */
    @Override
    public int insert(MemberCardUseRange memberCardUseRange) {
        return 0;
    }

    /**
     * 删除会员卡使用范围
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改会员卡使用范围
     *
     * @param memberCardUseRange
     * @return
     */
    @Override
    public int edit(MemberCardUseRange memberCardUseRange) {
        return 0;
    }


    /**
     * 根据ID查询
     *
     * @param id
     * @returnmemberCardUseRange
     */
    @Override
    public MemberCardUseRange queryById(int id) {
        return null;
    }
}