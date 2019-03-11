package com.union.aimei.common.feign.app.member.hystrix;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.member.MemberCardTradeRecodeFeign;
import com.union.aimei.common.model.member.MemberCardTradeRecode;
import org.springframework.stereotype.Component;

/**
 * @author GaoWei
 * @describe
 * @time 2017/12/19,14:33
 */
@Component(value = "app-MemberCardTradeRecodeFeign")
public class MemberCardTradeRecodeApiHystrix implements MemberCardTradeRecodeFeign {

    /**
     * 前端分页查询会员卡交易记录
     *
     * @param pageNo                分页索引
     * @param pageSize              每页显示数量
     * @param memberCardTradeRecode 查询条件
     * @return
     */
    @Override
    public PageInfo<MemberCardTradeRecode> findByPageForFront(Integer pageNo, Integer pageSize, MemberCardTradeRecode memberCardTradeRecode) {
        return null;
    }

    /**
     * 添加会员卡交易记录
     *
     * @param memberCardTradeRecode
     * @return
     */
    @Override
    public int insert(MemberCardTradeRecode memberCardTradeRecode) {
        return 0;
    }

    /**
     * 删除会员卡交易记录
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改会员卡交易记录
     *
     * @param memberCardTradeRecode
     * @return
     */
    @Override
    public int edit(MemberCardTradeRecode memberCardTradeRecode) {
        return 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnmemberCardTradeRecode
     */
    @Override
    public MemberCardTradeRecode queryById(int id) {
        return null;
    }

    @Override
    public MemberCardTradeRecode queryByOrderNo(String orderNo) {
        return null;
    }
}