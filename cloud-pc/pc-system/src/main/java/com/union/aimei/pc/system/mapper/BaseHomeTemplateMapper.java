package com.union.aimei.pc.system.mapper;

import com.union.aimei.common.model.system.BaseHomeTemplate;
import com.union.common.utils.base.BaseMapper;

import java.util.List;

/**
 * 首页模板
 *
 * @author liurenkai
 * @time 2017/12/26 19:23
 */
public interface BaseHomeTemplateMapper extends BaseMapper<BaseHomeTemplate> {
    /**
     * 批量添加模版基础数据
     *
     * @param list
     * @return
     */
    int addBatch(List<BaseHomeTemplate> list);

    /**
     * 根据 区域id删除数据
     *
     * @param areaId
     * @return
     */
    int deleteByAreaId(Integer areaId);

    /**
     * 根据 使用类型删除数据
     *
     * @param useType
     * @return
     */
    int deleteByUseTypeId(Integer useType);
}