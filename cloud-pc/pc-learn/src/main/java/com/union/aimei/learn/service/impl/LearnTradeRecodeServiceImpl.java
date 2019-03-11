package com.union.aimei.learn.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.learn.LearnTradeRecode;
import com.union.aimei.learn.mapper.LearnTradeRecodeMapper;
import com.union.aimei.learn.service.LearnTradeRecodeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
@Service("learnTradeRecodeService")
public class LearnTradeRecodeServiceImpl implements LearnTradeRecodeService {
    @Resource
    private LearnTradeRecodeMapper learnTradeRecodeMapper;

    /**
     * 前端分页查询交易记录表
     *
     * @param pageNo           分页索引
     * @param pageSize         每页显示数量
     * @param learnTradeRecode 查询条件
     * @return
     */
    @Override
    public PageInfo<LearnTradeRecode> findByPageForFront(Integer pageNo, Integer pageSize, LearnTradeRecode learnTradeRecode) {
        PageHelper.startPage (pageNo, pageSize);
        List<LearnTradeRecode> list = this.learnTradeRecodeMapper.selectListByConditions (learnTradeRecode);
        PageInfo<LearnTradeRecode> page = new PageInfo<> (list);
        return page;
    }

    @Override
    public List<LearnTradeRecode> queryTradeRecode(LearnTradeRecode learnTradeRecode) {
        return this.learnTradeRecodeMapper.selectListByConditions(learnTradeRecode);
    }

    /**
     * 添加交易记录表
     *
     * @param t
     * @return
     */
    @Override
    public int addObj(LearnTradeRecode t) {
        return this.learnTradeRecodeMapper.insertSelective (t);
    }

    /**
     * 删除交易记录表
     *
     * @param id
     * @return
     */
    @Override
    public int deleteObjById(int id) {
        return this.learnTradeRecodeMapper.deleteByPrimaryKey (id);
    }

    /**
     * 修改交易记录表
     *
     * @param t
     * @return
     */
    @Override
    public int modifyObj(LearnTradeRecode t) {
        return this.learnTradeRecodeMapper.updateByPrimaryKeySelective (t);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnlearnTradeRecode
     */
    @Override
    public LearnTradeRecode queryObjById(int id) {
        LearnTradeRecode model = this.learnTradeRecodeMapper.selectByPrimaryKey (id);
        return model;
    }
}