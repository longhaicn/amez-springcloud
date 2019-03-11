package com.union.aimei.common.feign.pc.product.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.product.ProductPhysicalBeauticianRefFeign;
import com.union.aimei.common.model.product.ProductPhysicalBeauticianRef;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

/**
 * 产品-美容师-关联
 *
 * @author liurenkai
 * @time 2018/2/28 16:19
 */
@Component(value = "pc-ProductPhysicalBeauticianRefFeign")
public class ProductPhysicalBeauticianRefApiHystrix implements ProductPhysicalBeauticianRefFeign {

    @Override
    public ResponseMessage<PageInfo<ProductPhysicalBeauticianRef>> findByPageForFront(Integer pageNo, Integer pageSize, ProductPhysicalBeauticianRef productPhysicalBeauticianRef) {
        return HystrixResponse.invokeFail();
    }

    /**
     * 添加产品-美容师-关联
     *
     * @param productPhysicalBeauticianRef
     * @return
     */
    @Override
    public int insert(ProductPhysicalBeauticianRef productPhysicalBeauticianRef) {
        return 0;
    }

    /**
     * 删除产品-美容师-关联
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改产品-美容师-关联
     *
     * @param productPhysicalBeauticianRef
     * @return
     */
    @Override
    public int edit(ProductPhysicalBeauticianRef productPhysicalBeauticianRef) {
        return 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnproductPhysicalBeauticianRef
     */
    @Override
    public ProductPhysicalBeauticianRef queryById(int id) {
        return null;
    }
}