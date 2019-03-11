package com.union.aimei.pc.financial.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.financial.PlatformTradeDetail;
import com.union.aimei.common.vo.financial.PlatformTradeDetailVo;
import com.union.aimei.pc.financial.mapper.PlatformTradeDetailMapper;
import com.union.aimei.pc.financial.service.PlatformTradeDetailService;
import com.union.common.utils.date.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
/**
 * @author dell
 */
@Service
public class PlatformTradeDetailServiceImpl implements PlatformTradeDetailService {

    @Autowired(required = false)
    private PlatformTradeDetailMapper platformTradeDetailMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return this.platformTradeDetailMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(PlatformTradeDetail record) {
        record.setStatisticsYear(DateUtil.getCurrentYear());
        record.setStatisticsYearMonth(DateUtil.getCurrentYearMoth());
        record.setCreateTime(new Date());
        return this.platformTradeDetailMapper.insertSelective(record);
    }

    @Override
    public PlatformTradeDetail selectByPrimaryKey(Integer id) {
        return this.platformTradeDetailMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PlatformTradeDetail record) {
        record.setUpdateTime(new Date());
        return this.platformTradeDetailMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public PageInfo<PlatformTradeDetail> selectListByConditions(Integer pageNo, Integer pageSize, PlatformTradeDetail record) {
        PageHelper.startPage(pageNo, pageSize);
        return new PageInfo<>(platformTradeDetailMapper.selectListByConditions(record));
    }

    /**
     * 分页和条件查询平台交易流水-后台管理
     *
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    @Override
    public PageInfo<PlatformTradeDetail> selectPlatformListByConditions(Integer pageNo, Integer pageSize, PlatformTradeDetailVo record) {
        PageHelper.startPage(pageNo, pageSize);
        return new PageInfo<>(platformTradeDetailMapper.selectPlatformListByConditions(record));
    }
}