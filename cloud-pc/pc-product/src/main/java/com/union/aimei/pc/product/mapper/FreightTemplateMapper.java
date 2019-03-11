package com.union.aimei.pc.product.mapper;

import com.union.aimei.common.model.product.FreightTemplate;
import com.union.aimei.common.vo.product.pc.FreightTemplateByDefaultResVo;
import com.union.common.utils.base.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * 运费模板
 *
 * @author liurenkai
 * @time 2018/3/12 16:24
 */
public interface FreightTemplateMapper extends BaseMapper<FreightTemplate> {

    /**
     * 查询运费模板（默认）
     *
     * @param freightTemplate
     * @return
     */
    List<FreightTemplateByDefaultResVo> selectListByDefault(FreightTemplate freightTemplate);

    /**
     * 根据模板名称查询数量
     *
     * @param condMap 条件
     * @return
     */
    int selectCountByTemplateName(Map<String, Object> condMap);

}