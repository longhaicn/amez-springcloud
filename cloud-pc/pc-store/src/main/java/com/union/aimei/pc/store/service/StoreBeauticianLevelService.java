package com.union.aimei.pc.store.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreBeauticianLevel;
import com.union.aimei.common.vo.store.pc.StoreBeauticianLevelByBatchVo;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.base.SpringCloudBaseService;

import java.util.List;

/**
 * 美容师等级
 *
 * @author liurenkai
 * @time 2018/1/12 17:41
 */
public interface StoreBeauticianLevelService extends SpringCloudBaseService<StoreBeauticianLevel> {
    /**
     * 分页查询美容师等级
     *
     * @param pageNo               分页索引
     * @param pageSize             每页数量
     * @param storeBeauticianLevel 查询条件
     * @return
     */
    ResponseMessage<PageInfo<StoreBeauticianLevel>> findByPageForFront(Integer pageNo, Integer pageSize, StoreBeauticianLevel storeBeauticianLevel);

    /**
     * 批量添加美容师等级
     *
     * @param storeBeauticianLevelByBatchVo
     * @return
     */
    ResponseMessage addByBatch(StoreBeauticianLevelByBatchVo storeBeauticianLevelByBatchVo);

    /**
     * 查询所有美容师等级
     *
     * @return
     */
    ResponseMessage<List<StoreBeauticianLevel>> findListByAll();

    /**
     * 根据成长值获取美容师级别
     *
     * @param growup
     * @return
     */
    ResponseMessage<StoreBeauticianLevel> getLevelBySetionGrowup(Integer growup);

}