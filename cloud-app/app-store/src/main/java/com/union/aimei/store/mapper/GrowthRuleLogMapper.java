package com.union.aimei.store.mapper;

import com.union.aimei.common.model.store.GrowthRuleLog;
import com.union.aimei.common.vo.store.app.GrowthRuleLogVo;
import com.union.common.utils.base.BaseMapper;

import java.util.Map;

/**
 * @author caizhaoming
 * @version 1.1
 * @create 2018-06-21 11:43
 **/
public interface GrowthRuleLogMapper extends BaseMapper<GrowthRuleLog> {


    /**
     * 根据vo获取数据
     *
     * @param growthRuleLogVo
     * @return
     */
    Map<String, Object> selectListByVo(GrowthRuleLogVo growthRuleLogVo);
}