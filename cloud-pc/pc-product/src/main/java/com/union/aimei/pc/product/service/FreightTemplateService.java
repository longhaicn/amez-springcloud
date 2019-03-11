package com.union.aimei.pc.product.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.product.FreightTemplate;
import com.union.aimei.common.vo.product.pc.FreightTemplateByAddVo;
import com.union.aimei.common.vo.product.pc.FreightTemplateByDefaultResVo;
import com.union.aimei.common.vo.product.pc.FreightTemplateByDetailResVo;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.base.SpringCloudBaseService;

/**
 * 运费模板
 *
 * @author liurenkai
 * @time 2018/3/12 16:34
 */
public interface FreightTemplateService extends SpringCloudBaseService<FreightTemplate> {

    /**
     * 分页查询运费模板
     *
     * @param pageNo          分页索引
     * @param pageSize        每页数量
     * @param freightTemplate 查询条件
     * @return
     */
    ResponseMessage<PageInfo<FreightTemplate>> findByPageForFront(Integer pageNo, Integer pageSize, FreightTemplate freightTemplate);

    /**
     * 分页查询运费模板（默认）
     *
     * @param pageNo          分页索引
     * @param pageSize        每页数量
     * @param freightTemplate 查询条件
     * @return
     */
    ResponseMessage<PageInfo<FreightTemplateByDefaultResVo>> findByPageForDefault(Integer pageNo, Integer pageSize, FreightTemplate freightTemplate);

    /**
     * 详情
     *
     * @param id
     * @return
     */
    ResponseMessage<FreightTemplateByDetailResVo> detail(int id);

    /**
     * 添加
     *
     * @param addVo 条件
     * @return
     */
    ResponseMessage add(FreightTemplateByAddVo addVo);

    /**
     * 修改
     *
     * @param addVo 条件
     * @return
     */
    ResponseMessage modify(FreightTemplateByAddVo addVo);

    /**
     * 根据模板名称查询数量
     *
     * @param templateName 模版名称
     * @param notId        不等于的ID
     * @return
     */
    ResponseMessage selectCountByTemplateName(String templateName, Integer notId);

}