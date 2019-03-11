package com.union.aimei.store.mapper;

import com.union.aimei.common.model.store.StoreBeauticianLevel;
import com.union.common.utils.base.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * 美容师等级
 *
 * @author liurenkai
 * @time 2018/1/12 17:37
 */
public interface StoreBeauticianLevelMapper extends BaseMapper<StoreBeauticianLevel> {

    /**
     * 根据成长值获取美容师级别
     *
     * @param growup
     * @return
     */
    StoreBeauticianLevel getLevelBySetionGrowup(@Param("growup") Integer growup);

}