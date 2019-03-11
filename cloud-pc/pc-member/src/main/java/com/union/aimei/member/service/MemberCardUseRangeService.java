package com.union.aimei.member.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.member.MemberCardUseRange;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.base.SpringCloudBaseService;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
public interface MemberCardUseRangeService extends SpringCloudBaseService<MemberCardUseRange> {
    /**
     * 前端分页查询会员卡使用范围
     *
     * @param pageNo             分页索引
     * @param pageSize           每页显示数量
     * @param memberCardUseRange 查询条件
     * @return
     */
    PageInfo<MemberCardUseRange> findByPageForFront(Integer pageNo, Integer pageSize, MemberCardUseRange memberCardUseRange);

    /**
     * 根据storeId来修改会员卡使用门店
     *
     * @param storeId
     */
    void updateBatch(int storeId);



    /**
     * 根据门店id修改会员卡的冻结状态
     *
     * @param storeId
     * @param type
     * @return
     */
    ResponseMessage memberCardStatusByStoreId(int storeId, int type);


}