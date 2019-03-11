package com.union.aimei.store.mapper;

import com.union.aimei.common.model.store.BeauticianServiceScope;
import com.union.common.utils.base.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * 美容师服务范围
 *
 * @author liurenkai
 * @time 2018/5/19 11:02
 */
public interface BeauticianServiceScopeMapper extends BaseMapper<BeauticianServiceScope> {

    /**
     * 根据美容师ID取消选择
     *
     * @param beauticianId 美容师ID
     * @return
     */
    int cancelSelectByBeauticianId(@Param(value = "beauticianId") int beauticianId);

}