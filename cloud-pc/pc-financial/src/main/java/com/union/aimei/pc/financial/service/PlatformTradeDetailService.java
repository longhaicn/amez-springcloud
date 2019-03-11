package com.union.aimei.pc.financial.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.financial.PlatformTradeDetail;
import com.union.aimei.common.vo.financial.PlatformTradeDetailVo;
/**
 * @author dell
 */
public interface PlatformTradeDetailService {
    /**
     * 基本操作
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int insertSelective(PlatformTradeDetail record);
    /**
     * 基本操作
     *
     * @param id
     * @return
     */
    PlatformTradeDetail selectByPrimaryKey(Integer id);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(PlatformTradeDetail record);
    /**
     * 查看
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    PageInfo<PlatformTradeDetail> selectListByConditions(Integer pageNo, Integer pageSize, PlatformTradeDetail record);

    /**
     * 分页和条件查询平台交易流水-后台管理
     *
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    PageInfo<PlatformTradeDetail> selectPlatformListByConditions(Integer pageNo, Integer pageSize, PlatformTradeDetailVo record);

}