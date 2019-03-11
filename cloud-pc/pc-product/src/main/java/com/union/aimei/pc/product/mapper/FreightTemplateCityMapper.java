package com.union.aimei.pc.product.mapper;

import com.union.aimei.common.model.product.FreightTemplateCity;
import com.union.aimei.common.vo.product.pc.FreightTemplateCityByBatchVo;
import com.union.common.utils.base.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * 运费模板城市
 *
 * @author liurenkai
 * @time 2018/3/12 16:24
 */
public interface FreightTemplateCityMapper extends BaseMapper<FreightTemplateCity> {

    /**
     * 批量添加
     *
     * @param batchVo
     * @return
     */
    int addBatch(FreightTemplateCityByBatchVo batchVo);

    /**
     * 根据运费模板ID删除
     *
     * @param templateId 运费模板ID
     * @return
     */
    int deleteByTemplateId(@Param("templateId") int templateId);
}