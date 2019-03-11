package com.union.aimei.common.feign.pc.system.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.system.BaseHomeTemplateFeign;
import com.union.aimei.common.model.system.BaseHomeTemplate;
import com.union.aimei.common.vo.system.pc.BaseHomeTemplateVo;
import com.union.aimei.common.vo.system.pc.SelectBaseHomeTemplateVo;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 首页模板
 *
 * @author liurenkai
 * @time 2017/12/26 19:29
 */
@Component(value = "pc-BaseHomeTemplateFeign")
public class BaseHomeTemplateApiHystrix implements BaseHomeTemplateFeign {

    /**
     * 前端分页查询首页模板
     *
     * @param pageNo           分页索引
     * @param pageSize         每页显示数量
     * @param baseHomeTemplate 查询条件
     * @return
     */
    @Override
    public PageInfo<BaseHomeTemplate> findByPageForFront(Integer pageNo, Integer pageSize, BaseHomeTemplate baseHomeTemplate) {
        return null;
    }

    /**
     * 添加首页模板
     *
     * @param baseHomeTemplate
     * @return
     */
    @Override
    public int insert(BaseHomeTemplate baseHomeTemplate) {
        return 0;
    }

    /**
     * 删除首页模板
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改首页模板
     *
     * @param baseHomeTemplate
     * @return
     */
    @Override
    public int edit(BaseHomeTemplate baseHomeTemplate) {
        return 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnbaseHomeTemplate
     */
    @Override
    public BaseHomeTemplate queryById(int id) {
        return null;
    }

    @Override
    public ResponseMessage isEnabled(int id, int isEnabled) {
        return null;
    }

    @Override
    public ResponseMessage addBatchV110(List<BaseHomeTemplate> baseHomeTemplateList) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage deleteByAreaIdV110(int areaId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<List<BaseHomeTemplate>> findForFrontV110(BaseHomeTemplate baseHomeTemplate) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage deleteByUseTypeIdV110(Integer useType) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<BaseHomeTemplateVo> getTemplateDateV110(SelectBaseHomeTemplateVo selectBaseHomeTemplateVo) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage templateDateInsertUpdateV110(BaseHomeTemplateVo baseHomeTemplate) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage saveBaseHomeTemplateByRedis() {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage saveBaseHomeFloorDataByCityIdAnd(Integer cityId, Integer useType) {
        return HystrixResponse.invokeFail();
    }
}