package com.union.aimei.common.feign.pc.product.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.product.FreightTemplateFeign;
import com.union.aimei.common.model.product.FreightTemplate;
import com.union.aimei.common.vo.product.pc.FreightTemplateByAddVo;
import com.union.aimei.common.vo.product.pc.FreightTemplateByDefaultResVo;
import com.union.aimei.common.vo.product.pc.FreightTemplateByDetailResVo;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

/**
 * 运费模板
 *
 * @author liurenkai
 * @time 2018/3/12 16:54
 */
@Component(value = "pc-FreightTemplateFeign")
public class FreightTemplateApiHystrix implements FreightTemplateFeign {

    @Override
    public ResponseMessage<PageInfo<FreightTemplate>> findByPageForFront(Integer pageNo, Integer pageSize, FreightTemplate freightTemplate) {
        return HystrixResponse.invokeFail ();
    }

    /**
     * 添加运费模板
     *
     * @param freightTemplate
     * @return
     */
    @Override
    public int insert(FreightTemplate freightTemplate) {
        return 0;
    }

    /**
     * 删除运费模板
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改运费模板
     *
     * @param freightTemplate
     * @return
     */
    @Override
    public int edit(FreightTemplate freightTemplate) {
        return 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnfreightTemplate
     */
    @Override
    public FreightTemplate queryById(int id) {
        return null;
    }

    @Override
    public ResponseMessage<PageInfo<FreightTemplateByDefaultResVo>> findByPageForDefault(Integer pageNo, Integer pageSize, FreightTemplate freightTemplate) {
        return HystrixResponse.invokeFail ();
    }

    @Override
    public ResponseMessage<FreightTemplateByDetailResVo> detail(int id) {
        return HystrixResponse.invokeFail ();
    }

    @Override
    public ResponseMessage add(FreightTemplateByAddVo addVo) {
        return HystrixResponse.invokeFail ();
    }

    @Override
    public ResponseMessage modify(FreightTemplateByAddVo addVo) {
        return HystrixResponse.invokeFail ();
    }

    @Override
    public ResponseMessage selectCountByTemplateName(String templateName, Integer notId) {
        return HystrixResponse.invokeFail ();
    }
}