package com.union.aimei.member.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.member.MemberWithdraws;
import com.union.aimei.common.vo.member.MemberWithdrawsVo;
import com.union.aimei.member.mapper.MemberWithdrawsMapper;
import com.union.aimei.member.service.MemberWithdrawsService;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
@Service("memberWithdrawsService")
public class MemberWithdrawsServiceImpl implements MemberWithdrawsService {
    @Resource
    private MemberWithdrawsMapper memberWithdrawsMapper;

    /**
     * 前端分页查询会员提现申请表
     *
     * @param pageNo          分页索引
     * @param pageSize        每页显示数量
     * @param memberWithdraws 查询条件
     * @return
     */
    @Override
    public PageInfo<MemberWithdraws> findByPageForFront(Integer pageNo, Integer pageSize, MemberWithdraws memberWithdraws) {
        PageHelper.startPage(pageNo, pageSize);
        List<MemberWithdraws> list = this.memberWithdrawsMapper.selectListByConditions(memberWithdraws);
        PageInfo<MemberWithdraws> page = new PageInfo<>(list);
        return page;
    }

    @Override
    public PageInfo<MemberWithdraws> findByPageForManager(Integer pageNo, Integer pageSize, MemberWithdrawsVo memberWithdrawsVo) {
        PageHelper.startPage(pageNo, pageSize);
        List<MemberWithdraws> list = this.memberWithdrawsMapper.selectListForManager(memberWithdrawsVo);
        PageInfo<MemberWithdraws> page = new PageInfo<>(list);
        return page;
    }

    @Override
    public void updateBatch(List<Integer> idList) {
        List<MemberWithdraws> list = new ArrayList<>(10);
        idList.forEach((Integer integer) -> {
            MemberWithdraws mw = new MemberWithdraws();
            mw.setId(integer);
            mw.setPlayAmountTime(new Date());
            list.add(mw);
        });
        this.memberWithdrawsMapper.updateBatch(list);
    }

    @Override
    public ResponseMessage batchMoney(String ids) {
        String[] list = ids.split(",");
        MemberWithdraws memberWithdraws;
        for (String s : list) {
            memberWithdraws = new MemberWithdraws();
            memberWithdraws.setTradeDetailId(Integer.parseInt(s));
            memberWithdraws.setPlayAmountStatus(true);
            memberWithdraws.setPlayAmountTime(new Date());
            this.memberWithdrawsMapper.updateByTradeDetailId(memberWithdraws);
        }
        return new ResponseMessage();
    }

    /**
     * 添加会员提现申请表
     *
     * @param t
     * @return
     */
    @Override
    public int addObj(MemberWithdraws t) {
        return this.memberWithdrawsMapper.insertSelective(t);
    }

    /**
     * 删除会员提现申请表
     *
     * @param id
     * @return
     */
    @Override
    public int deleteObjById(int id) {
        return this.memberWithdrawsMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改会员提现申请表
     *
     * @param t
     * @return
     */
    @Override
    public int modifyObj(MemberWithdraws t) {
        return this.memberWithdrawsMapper.updateByPrimaryKeySelective(t);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnmemberWithdraws
     */
    @Override
    public MemberWithdraws queryObjById(int id) {
        MemberWithdraws model = this.memberWithdrawsMapper.selectByPrimaryKey(id);
        return model;
    }
}