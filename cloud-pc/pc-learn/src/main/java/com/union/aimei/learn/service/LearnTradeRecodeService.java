package com.union.aimei.learn.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.learn.LearnTradeRecode;
import com.union.common.utils.base.SpringCloudBaseService;

import java.util.List;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
public interface LearnTradeRecodeService extends SpringCloudBaseService<LearnTradeRecode> {
    /**
     * 前端分页查询交易记录表
     *
     * @param pageNo           分页索引
     * @param pageSize         每页显示数量
     * @param learnTradeRecode 查询条件
     * @return
     */
    PageInfo<LearnTradeRecode> findByPageForFront(Integer pageNo, Integer pageSize, LearnTradeRecode learnTradeRecode);

    /**
     * 根据LearnTradeRecode查询交易记录
     * @param learnTradeRecode
     * @return
     */
    List<LearnTradeRecode> queryTradeRecode(LearnTradeRecode learnTradeRecode);
}