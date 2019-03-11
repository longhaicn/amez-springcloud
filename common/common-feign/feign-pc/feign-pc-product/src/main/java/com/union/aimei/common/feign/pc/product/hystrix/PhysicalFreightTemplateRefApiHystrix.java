package com.union.aimei.common.feign.pc.product.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.product.PhysicalFreightTemplateRefFeign;
import com.union.aimei.common.model.product.PhysicalFreightTemplateRef;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

/**
 * 产品-运费模板-关联
 *
 * @author liurenkai
 * @time 2018/3/12 16:55
 */
@Component(value = "pc-PhysicalFreightTemplateRefFeign")
public class PhysicalFreightTemplateRefApiHystrix implements PhysicalFreightTemplateRefFeign {

    @Override
    public ResponseMessage<PageInfo<PhysicalFreightTemplateRef>> findByPageForFront(Integer pageNo, Integer pageSize, PhysicalFreightTemplateRef physicalFreightTemplateRef) {
        return HystrixResponse.invokeFail();
    }

    /**
     * 添加产品-运费模板-关联
     *
     * @param physicalFreightTemplateRef
     * @return
     */
    @Override
    public int insert(PhysicalFreightTemplateRef physicalFreightTemplateRef) {
        return 0;
    }

    /**
     * 删除产品-运费模板-关联
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改产品-运费模板-关联
     *
     * @param physicalFreightTemplateRef
     * @return
     */
    @Override
    public int edit(PhysicalFreightTemplateRef physicalFreightTemplateRef) {
        return 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnphysicalFreightTemplateRef
     */
    @Override
    public PhysicalFreightTemplateRef queryById(int id) {
        return null;
    }

    @Override
    public ResponseMessage add(PhysicalFreightTemplateRef physicalFreightTemplateRef) {
        return HystrixResponse.invokeFail();
    }

}