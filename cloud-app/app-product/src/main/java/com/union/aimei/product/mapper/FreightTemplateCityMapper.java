package com.union.aimei.product.mapper;


import com.union.aimei.common.model.product.FreightTemplateCity;
import com.union.aimei.common.vo.product.app.FreightTemplateCityByCityIdVo;
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
     * 查询运费模板城市（根据城市ID）
     *
     * @param cityIdVo
     * @return
     */
    FreightTemplateCity selectByCityId(FreightTemplateCityByCityIdVo cityIdVo);

    /**
     * 查询运费模板城市（默认）
     *
     * @param templateId 模板ID
     * @return
     */
    FreightTemplateCity selectByDefault(@Param("templateId") int templateId);

}